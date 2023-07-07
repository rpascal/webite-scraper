package website.scraper.two.bing;

import website.scraper.two.bing.model.BingSearchResponse;
import website.scraper.two.json.Mapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BingSearchClient {

    private static final String bingMapsUrl = "https://dev.virtualearth.net/REST/v1/LocalSearch/";
    private static final String key = "Apxdu0Lch88uaXQkkibfSZqRaU8NzwwLWhhNMwtkhkYUQ9nBBte-kfTAQLe1OtsI";

    private static final int maxResults = 25;

    public BingSearchResponse search(String query, double lat, double _long, int radius) throws IOException, InterruptedException {
        final HttpClient client = HttpClient.newBuilder().build();

        final String url =
                bingMapsUrl
                        + "?query=" + query
                        + "&maxResults=" + maxResults
                        + "&userCircularMapView=" + lat + "," + _long + "," + radius
                        + "&key=" + key;

        System.out.println(url);

        final HttpRequest request = HttpRequest
                .newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        return Mapper.MAPPER.readValue(response.body(), BingSearchResponse.class);
    }

}
