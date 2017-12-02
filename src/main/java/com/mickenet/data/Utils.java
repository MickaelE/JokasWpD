package com.mickenet.data;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Utils {

    public void printFile(String FILENAME, ArrayList<String>content){
        try {
            Path out = Paths.get(FILENAME);
            Files.write(out,content, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
