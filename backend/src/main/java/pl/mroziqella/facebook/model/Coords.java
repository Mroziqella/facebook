
package pl.mroziqella.facebook.model;

import java.util.Map;

public class Coords {

    private Double lon;
    private Double lat;
    private Map<String, Object> additionalProperties;

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
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

        Coords coords = (Coords) o;

        if (lon != null ? !lon.equals(coords.lon) : coords.lon != null) return false;
        if (lat != null ? !lat.equals(coords.lat) : coords.lat != null) return false;
        return additionalProperties != null ? additionalProperties.equals(coords.additionalProperties) : coords.additionalProperties == null;
    }

    @Override
    public int hashCode() {
        int result = lon != null ? lon.hashCode() : 0;
        result = 31 * result + (lat != null ? lat.hashCode() : 0);
        result = 31 * result + (additionalProperties != null ? additionalProperties.hashCode() : 0);
        return result;
    }
}
