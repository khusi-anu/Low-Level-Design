public class Address {
    private String cityName;
    private String pinCode;
    private String state;

    public Address(String cityName, String pinCode, String state) {
        this.cityName = cityName;
        this.pinCode = pinCode;
        this.state = state;
    }

    public String getCityName() {
        return cityName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getState() {
        return state;
    }
}
