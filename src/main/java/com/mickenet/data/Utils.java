package com.mickenet.data;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Utils {

    public void printFile(String FILENAME, ArrayList<String>content){
        Path out;
        try {
            out = Paths.get(FILENAME);
            Files.write(out,content, Charset.defaultCharset());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File(FILENAME);
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    // no application registered for PDFs
                }
            }
        }
    }

}
