package com.mickenet.data;
import org.parse4j.ParseClassName;
import org.parse4j.ParseObject;

@ParseClassName("Waypoints")
public class Waypoints extends ParseObject {
    String  projectId;
    Double  Latitud;
    Double Longitud;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Double getLatitud() {
        return Latitud;
    }

    public void setLatitud(Double latitud) {
        Latitud = latitud;
    }

    public Double getLongitud() {
        return Longitud;
    }

    public void setLongitud(Double longitud) {
        Longitud = longitud;
    }
}
