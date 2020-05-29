
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
    "NewConfirmed",
    "TotalConfirmed",
    "NewDeaths",
    "TotalDeaths",
    "NewRecovered",
    "TotalRecovered"
})
public class Global {

    @JsonProperty("NewConfirmed")
    private Integer newConfirmed;
    @JsonProperty("TotalConfirmed")
    private Integer totalConfirmed;
    @JsonProperty("NewDeaths")
    private Integer newDeaths;
    @JsonProperty("TotalDeaths")
    private Integer totalDeaths;
    @JsonProperty("NewRecovered")
    private Integer newRecovered;
    @JsonProperty("TotalRecovered")
    private Integer totalRecovered;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("NewConfirmed")
    public Integer getNewConfirmed() {
        return newConfirmed;
    }

    @JsonProperty("NewConfirmed")
    public void setNewConfirmed(Integer newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    @JsonProperty("TotalConfirmed")
    public Integer getTotalConfirmed() {
        return totalConfirmed;
    }

    @JsonProperty("TotalConfirmed")
    public void setTotalConfirmed(Integer totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    @JsonProperty("NewDeaths")
    public Integer getNewDeaths() {
        return newDeaths;
    }

    @JsonProperty("NewDeaths")
    public void setNewDeaths(Integer newDeaths) {
        this.newDeaths = newDeaths;
    }

    @JsonProperty("TotalDeaths")
    public Integer getTotalDeaths() {
        return totalDeaths;
    }

    @JsonProperty("TotalDeaths")
    public void setTotalDeaths(Integer totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    @JsonProperty("NewRecovered")
    public Integer getNewRecovered() {
        return newRecovered;
    }

    @JsonProperty("NewRecovered")
    public void setNewRecovered(Integer newRecovered) {
        this.newRecovered = newRecovered;
    }

    @JsonProperty("TotalRecovered")
    public Integer getTotalRecovered() {
        return totalRecovered;
    }

    @JsonProperty("TotalRecovered")
    public void setTotalRecovered(Integer totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
