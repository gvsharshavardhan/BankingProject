package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    static Properties prop;
    static{
        File file = new File("/Users/harshavardhan/IdeaProjects/opencartProject/src/main/resources/XYZBank.properties");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop = new Properties();
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBrowser(){
        return (String) prop.get("browser");
    }

    public static String getURL(){
        return (String) prop.get("url");
    }
}