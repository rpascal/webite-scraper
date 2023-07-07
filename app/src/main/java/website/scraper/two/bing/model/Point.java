package website.scraper.two.bing.model;

import java.util.ArrayList;

public class Point{
    private  String type;
    private  ArrayList<Double> coordinates;

    public Point(){}

    public Point(String type, ArrayList<Double> coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCoordinates(ArrayList<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public ArrayList<Double> getCoordinates() {
        return coordinates;
    }

    public String getType() {
        return type;
    }
}

