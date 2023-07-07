package website.scraper.two.geo;

public class LatLongAdjuster {

    public static double adjustLatitudeByMeters(double originalLat, double meters) {
        double coef = (meters / 2) / 111320.0;
        double new_lat = originalLat + coef;
        return new_lat;
    }

    public static double adjustLongitudeByMeters(double originalLat, double originalLong, double meters) {
        double coef = meters / 111320.0;
        // pi / 180 ~= 0.01745
        double new_long = originalLong + coef / Math.cos(originalLat * 0.01745);
        return new_long;
    }

}
