package config;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.apache.commons.io.input.ReaderInputStream;

import java.io.*;
import java.util.Properties;

public class LoadConfig extends Properties {

    public LoadConfig(){
        try {
            this.loadFromXML(new FileInputStream("src/main/resources/properties.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getToken(){
        return getProperty("telegram.token");
    }
    public String getName(){
        return getProperty("telegram.name");
    }

}
