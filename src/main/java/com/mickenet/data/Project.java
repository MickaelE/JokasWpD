
package com.mickenet.data;
import org.parse4j  .ParseClassName;
import org.parse4j.ParseObject;

@ParseClassName("project")
public class Project extends ParseObject {
     String name;
    // --Commented out by Inspection (2017-11-20 21:29):private String name;

    public String getName() {
        String name="";
        return name;
    }

// --Commented out by Inspection START (2017-11-20 21:28):
//    public void setName( String name ) {
//
//        this.name = name;
//    }
// --Commented out by Inspection STOP (2017-11-20 21:28)
}