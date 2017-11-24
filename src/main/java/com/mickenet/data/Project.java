
package com.mickenet.data;
import org.parse4j  .ParseClassName;
import org.parse4j.ParseObject;

@ParseClassName("project")
public class Project extends ParseObject {
     String project_name;


    public String getName() {
        return getString("project_name");
    }


    public void setName( String name ) {

       put("displayName", name);
   }

}