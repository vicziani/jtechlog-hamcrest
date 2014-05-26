package jtechlog.hamcrest;

public class Address {

    private AddressType addressType;

    private String zip;

    private String city;

    private String line1;

    public Address(AddressType addressType, String zip, String city, String line1) {
        this.addressType = addressType;
        this.zip = zip;
        this.city = city;
        this.line1 = line1;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }
}
