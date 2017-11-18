package com.mickenet.data;
import com.sun.tools.javap.TypeAnnotationWriter;
import org.parse4j.Parse;
import org.parse4j.util.ParseRegistry;

public class  Defaults {
    private static final String APP_ID = "244600d975e2836676e64cb3a18ceca692a9a23c";
    private static final String APP_REST_API_ID = "a9122d5ab8f97176c51a2e5cf5273dd6543bfe93";
    private static final String CUSTOM_SERVER_PATH = "http://jokaswp.mooo.com:81/jokas/";
    public void initializeParse() {

        ParseRegistry.registerSubclass(Projects.class);
        ParseRegistry.registerSubclass(Waypoints.class);
        Parse.getParseAPIUrl(CUSTOM_SERVER_PATH);
        Parse.initialize(APP_ID,APP_REST_API_ID);
    }
}
