package website.scraper.two.bing.model;

import java.util.ArrayList;

public class BingSearchResponse {
    private String authenticationResultCode;
    private String brandLogoUri;
    private String copyright;
    private ArrayList<ResourceSet> resourceSets;
    private int statusCode;
    private String statusDescription;
    private String traceId;

    public BingSearchResponse() {
    }

    public BingSearchResponse(String authenticationResultCode, String brandLogoUri, String copyright, ArrayList<ResourceSet> resourceSets, int statusCode, String statusDescription, String traceId) {
        this.authenticationResultCode = authenticationResultCode;
        this.brandLogoUri = brandLogoUri;
        this.copyright = copyright;
        this.resourceSets = resourceSets;
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
        this.traceId = traceId;
    }

    public int resultCount() {
        return getResourceSets()
                .stream()
                .map(x -> x.getEstimatedTotal())
                .reduce(0, Integer::sum);
    }

    public boolean emptyResults() {
        return resultCount() == 0;
    }

    public void setAuthenticationResultCode(String authenticationResultCode) {
        this.authenticationResultCode = authenticationResultCode;
    }

    public void setBrandLogoUri(String brandLogoUri) {
        this.brandLogoUri = brandLogoUri;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setResourceSets(ArrayList<ResourceSet> resourceSets) {
        this.resourceSets = resourceSets;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getAuthenticationResultCode() {
        return authenticationResultCode;
    }

    public String getBrandLogoUri() {
        return brandLogoUri;
    }

    public String getCopyright() {
        return copyright;
    }

    public ArrayList<ResourceSet> getResourceSets() {
        return resourceSets;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public String getTraceId() {
        return traceId;
    }
}



