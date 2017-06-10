
package pl.mroziqella.facebook.model;
import java.util.Map;

public class City {

    private String countryName;
    private String cityName;
    private String stateName;
    private Coords coords;
    private Map<String, Object> additionalProperties;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Coords getCoords() {
        return coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (countryName != null ? !countryName.equals(city.countryName) : city.countryName != null) return false;
        if (cityName != null ? !cityName.equals(city.cityName) : city.cityName != null) return false;
        if (stateName != null ? !stateName.equals(city.stateName) : city.stateName != null) return false;
        if (coords != null ? !coords.equals(city.coords) : city.coords != null) return false;
        return additionalProperties != null ? additionalProperties.equals(city.additionalProperties) : city.additionalProperties == null;
    }

    @Override
    public int hashCode() {
        int result = countryName != null ? countryName.hashCode() : 0;
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        result = 31 * result + (stateName != null ? stateName.hashCode() : 0);
        result = 31 * result + (coords != null ? coords.hashCode() : 0);
        result = 31 * result + (additionalProperties != null ? additionalProperties.hashCode() : 0);
        return result;
    }
}
