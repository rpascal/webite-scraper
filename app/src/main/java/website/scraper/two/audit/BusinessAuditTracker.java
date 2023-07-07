package website.scraper.two.audit;

import website.scraper.two.bing.model.BingSearchResponse;
import website.scraper.two.bing.model.Point;
import website.scraper.two.bing.model.Resource;
import website.scraper.two.json.Mapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BusinessAuditTracker {

    private static final String destinationPath = "./results";
    private static final String CSV_HEADER = "name,website,lat,long,timestamp";

    private final Set<String> knownBadName;
    private final Set<String> seen;


    public BusinessAuditTracker() {
        knownBadName = new HashSet<String>();
        knownBadName.add("Planet Fitness");
        knownBadName.add("Orangetheory");
        knownBadName.add("Orangetheory Fitness");
        knownBadName.add("Pure Barre");
        knownBadName.add("ymca");
        knownBadName.add("Anytime Fitness");


        seen = new HashSet<>();
    }

    public void track(
            BingSearchResponse searchResponse,
            LocalDateTime timestamp,
            String instanceKey
    ) throws IOException {
        List<Resource> resources =
                searchResponse
                        .getResourceSets()
                        .stream()
                        .flatMap(x -> x.getResources().stream())
                        .filter(resource -> {
                            boolean dontWant = !knownBadName.contains(resource.getName());
                            boolean saw = seen.contains(resource.seenKey());
                            return dontWant && !saw;
                        })
                        .collect(Collectors.toList());

        resources.forEach(x -> seen.add(x.seenKey()));

        long milli = timestamp.toInstant(ZoneOffset.UTC).toEpochMilli();

        writeRawResources(resources, milli);
        appendCsv(resources, milli, instanceKey);
    }

    private void writeRawResources( List<Resource> resources, long milli) throws IOException {
        Path destination = Path.of(destinationPath).resolve("raw");
        destination.toFile().mkdir();
        Path file = destination.resolve(milli + ".csv");
        FileWriter fileWriter = new FileWriter(file.toFile());
        fileWriter.write(Mapper.MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(resources));
        fileWriter.close();
    }

    private void appendCsv(
            List<Resource> resources,
            long milli,
            String instanceKey
    ) throws IOException {
        Path destination = Path.of(destinationPath).resolve("csv");
        destination.toFile().mkdir();
        File csvFile = destination.resolve(instanceKey + ".csv").toFile();

        if (!csvFile.exists()) {
            FileWriter fileWriter = new FileWriter(csvFile);
            fileWriter.write(CSV_HEADER);
            fileWriter.close();
        }

        FileWriter fileWriter = new FileWriter(csvFile, true);

        resources
                .stream()
                .map(x -> resourceCsvRow(x, milli))
                .forEach(row -> {
                    try {
                        fileWriter.write("\n" + row);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });


        fileWriter.close();
    }

    private String resourceCsvRow(Resource resource, long stamp) {
        Point point = resource.getPoint();

        String name = resource.getName().replace(",", "");
        if (point == null) {
            String row = name + "," +
                    resource.getWebsite() + "," +
                    -1 + "," +
                    -1 + "," +
                    stamp;
            return row;
        } else {
            String row = name + "," +
                    resource.getWebsite() + "," +
                    point.getCoordinates().get(0) + "," +
                    point.getCoordinates().get(1) + "," +
                    stamp;
            return row;
        }
    }

}
