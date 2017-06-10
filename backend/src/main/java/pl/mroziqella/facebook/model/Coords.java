
package pl.mroziqella.facebook.model;


public class Coords {

    private Double lon;
    private Double lat;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coords coords = (Coords) o;

        if (lon != null ? !lon.equals(coords.lon) : coords.lon != null) return false;
        return lat != null ? lat.equals(coords.lat) : coords.lat == null;
    }

    @Override
    public int hashCode() {
        int result = lon != null ? lon.hashCode() : 0;
        result = 31 * result + (lat != null ? lat.hashCode() : 0);
        return result;
    }
}
