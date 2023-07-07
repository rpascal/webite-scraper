package website.scraper.two.audit;

import website.scraper.two.bing.model.BingSearchResponse;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SearchAuditTracker {

    private static final String filePath = "./searchAudit.csv";

    public void track(
            String query,
            double lat,
            double _long,
            int radius,
            BingSearchResponse searchResponse,
            LocalDateTime timestamp
    ) throws IOException {
        SearchAuditItem item = new SearchAuditItem(
                lat,
                _long,
                query,
                searchResponse
                        .getResourceSets()
                        .stream()
                        .map(x -> x.getEstimatedTotal())
                        .reduce(0, Integer::sum),
                radius,
               timestamp
        );

        File csvFile = new File(filePath);

        if (!csvFile.exists()) {
            FileWriter fileWriter = new FileWriter(csvFile);
            fileWriter.write(SearchAuditItem.CSV_HEADER);
            fileWriter.close();
        }

        FileWriter fileWriter = new FileWriter(csvFile, true);
        fileWriter.write("\n");
        fileWriter.write(item.csvLine());
        fileWriter.close();
    }

}
