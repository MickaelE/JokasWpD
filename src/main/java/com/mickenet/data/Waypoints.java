package com.mickenet.data;
import org.parse4j.ParseClassName;
import org.parse4j.ParseObject;

@ParseClassName("Waypoints")
public class Waypoints extends ParseObject {
    private String  projectId;
    private Double  Latitud;
    private Double Longitud;

   public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }



    public Double getLatitud() {
        return Latitud;
    }


// --Commented out by Inspection START (2017-11-20 21:28):
   public void setLatitud(Double latitud) {
        Latitud = latitud;
    }
// --Commented out by Inspection STOP (2017-11-20 21:28)

// --Commented out by Inspection START (2017-11-20 21:28):
    public Double getLongitud() {
        return Longitud;
   }
// --Commented out by Inspection STOP (2017-11-20 21:28)

// --Commented out by Inspection START (2017-11-20 21:28):
   public void setLongitud(Double longitud) {
       Longitud = longitud;
    }

}
