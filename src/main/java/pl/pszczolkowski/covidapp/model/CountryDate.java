
package pl.pszczolkowski.covidapp.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Country",
    "CountryCode",
    "Province",
    "City",
    "CityCode",
    "Lat",
    "Lon",
    "Cases",
    "Status",
    "Date"
})
public class CountryDate {

    @JsonProperty("Country")
    private String country;
    @JsonProperty("CountryCode")
    private String countryCode;
    @JsonProperty("Province")
    private String province;
    @JsonProperty("City")
    private String city;
    @JsonProperty("CityCode")
    private String cityCode;
    @JsonProperty("Lat")
    private String lat;
    @JsonProperty("Lon")
    private String lon;
    @JsonProperty("Cases")
    private Integer cases;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Date")
    private String date;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("Country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("CountryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("CountryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("Province")
    public String getProvince() {
        return province;
    }

    @JsonProperty("Province")
    public void setProvince(String province) {
        this.province = province;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("CityCode")
    public String getCityCode() {
        return cityCode;
    }

    @JsonProperty("CityCode")
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @JsonProperty("Lat")
    public String getLat() {
        return lat;
    }

    @JsonProperty("Lat")
    public void setLat(String lat) {
        this.lat = lat;
    }

    @JsonProperty("Lon")
    public String getLon() {
        return lon;
    }

    @JsonProperty("Lon")
    public void setLon(String lon) {
        this.lon = lon;
    }

    @JsonProperty("Cases")
    public Integer getCases() {
        return cases;
    }

    @JsonProperty("Cases")
    public void setCases(Integer cases) {
        this.cases = cases;
    }

    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("Date")
    public String getDate() {
        return date;
    }

    @JsonProperty("Date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "CountryDate{" +
                "country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", cases=" + cases +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
