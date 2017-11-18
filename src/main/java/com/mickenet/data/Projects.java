
package com.mickenet.data;
import org.parse4j  .ParseClassName;
import org.parse4j.ParseObject;

@ParseClassName("Projects")
public class Projects extends ParseObject {
    private String objectId;
    private String name;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId( String objectId ) {

        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {

        this.name = name;
    }
}