package com.mickenet.data;
import org.parse4j.ParseClassName;
import org.parse4j.ParseObject;

@ParseClassName("waypoints")
public class Waypoints extends ParseObject {
    private Number Latitude;
    private Number Longitude;

    public Number getLatitude() {
        return getNumber("latitude");
    }

   public void setLatitude(Number latitude) {
       Latitude = latitude;
    }

    public Number getLongitude() {
        return getNumber("longitude");
   }

   public void setLongitude(Number longitude) {
        Longitude = longitude;
    }

}
