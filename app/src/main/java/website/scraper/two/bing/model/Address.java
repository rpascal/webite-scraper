package website.scraper.two.bing.model;

public class Address{
    private  String addressLine;
    private  String adminDistrict;
    private  String countryRegion;
    private  String formattedAddress;
    private  String locality;
    private  String postalCode;

    public Address(){}

    public Address(String addressLine, String adminDistrict, String countryRegion, String formattedAddress, String locality, String postalCode) {
        this.addressLine = addressLine;
        this.adminDistrict = adminDistrict;
        this.countryRegion = countryRegion;
        this.formattedAddress = formattedAddress;
        this.locality = locality;
        this.postalCode = postalCode;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public void setAdminDistrict(String adminDistrict) {
        this.adminDistrict = adminDistrict;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public String getAdminDistrict() {
        return adminDistrict;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public String getLocality() {
        return locality;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
