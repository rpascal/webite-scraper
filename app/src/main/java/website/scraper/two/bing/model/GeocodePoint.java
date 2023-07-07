package website.scraper.two.bing.model;

import java.util.ArrayList;

public class GeocodePoint{
    private  String type;
    private  ArrayList<Double> coordinates;
    private  String calculationMethod;
    private  ArrayList<String> usageTypes;

    public GeocodePoint(){}

    public GeocodePoint(String type, ArrayList<Double> coordinates, String calculationMethod, ArrayList<String> usageTypes) {
        this.type = type;
        this.coordinates = coordinates;
        this.calculationMethod = calculationMethod;
        this.usageTypes = usageTypes;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCoordinates(ArrayList<Double> coordinates) {
        this.coordinates = coordinates;
    }

    public void setCalculationMethod(String calculationMethod) {
        this.calculationMethod = calculationMethod;
    }

    public void setUsageTypes(ArrayList<String> usageTypes) {
        this.usageTypes = usageTypes;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Double> getCoordinates() {
        return coordinates;
    }

    public String getCalculationMethod() {
        return calculationMethod;
    }

    public ArrayList<String> getUsageTypes() {
        return usageTypes;
    }
}
