package website.scraper.two.audit;

import java.time.LocalDateTime;

public class SearchAuditItem {

    private final double latitude;
    private final double longitude;
    private final String searchTerm;
    private final int resultsCount;
    private final int radius;
    private final LocalDateTime date;

    public SearchAuditItem(double latitude, double longitude, String searchTerm, int resultsCount, int radius, LocalDateTime date) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.searchTerm = searchTerm;
        this.resultsCount = resultsCount;
        this.radius = radius;
        this.date = date;
    }

    public final static String CSV_HEADER = "latitude~longitude~searchTerm~resultsCount~radius~date";

    public String csvLine() {
        return latitude + "~" +
                longitude + "~" +
                searchTerm + "~" +
                resultsCount + "~" +
                radius + "~" +
                date.getYear() + "/" + date.getDayOfMonth() + "/" + date.getDayOfMonth();
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public int getResultsCount() {
        return resultsCount;
    }

    public int getRadius() {
        return radius;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
