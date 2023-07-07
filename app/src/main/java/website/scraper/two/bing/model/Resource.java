package website.scraper.two.bing.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Resource {
    private String __type;
    private String name;
    private Point point;
    @JsonProperty("Address")
    private Address address;
    @JsonProperty("PhoneNumber")
    private String phoneNumber; // could be null
    @JsonProperty("Website")
    private String website; // Could be null
    private String entityType;
    private ArrayList<GeocodePoint> geocodePoints;

    public Resource() {
    }

    public Resource(String __type, String name, Point point, Address address, String phoneNumber, String website, String entityType, ArrayList<GeocodePoint> geocodePoints) {
        this.__type = __type;
        this.name = name;
        this.point = point;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.entityType = entityType;
        this.geocodePoints = geocodePoints;
    }

    public String seenKey() {
        Point point = getPoint();
        if (point == null) {
            return getName() + "_" + getAddress().getFormattedAddress();
        } else {
            ArrayList<Double> coordinates = point.getCoordinates();
            return getName() + "_" + coordinates.get(0) + "," + coordinates.get(1);

        }
    }

    public void set__type(String __type) {
        this.__type = __type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public void setGeocodePoints(ArrayList<GeocodePoint> geocodePoints) {
        this.geocodePoints = geocodePoints;
    }

    public String get__type() {
        return __type;
    }

    public String getName() {
        return name;
    }

    public Point getPoint() {
        return point;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public String getEntityType() {
        return entityType;
    }

    public ArrayList<GeocodePoint> getGeocodePoints() {
        return geocodePoints;
    }
}