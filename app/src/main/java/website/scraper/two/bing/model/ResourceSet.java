package website.scraper.two.bing.model;

import java.util.ArrayList;

public class ResourceSet{
    private  int estimatedTotal;
    private  ArrayList<Resource> resources;

    public ResourceSet(){}

    public ResourceSet(int estimatedTotal, ArrayList<Resource> resources) {
        this.estimatedTotal = estimatedTotal;
        this.resources = resources;
    }

    public void setEstimatedTotal(int estimatedTotal) {
        this.estimatedTotal = estimatedTotal;
    }

    public void setResources(ArrayList<Resource> resources) {
        this.resources = resources;
    }

    public int getEstimatedTotal() {
        return estimatedTotal;
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }
}