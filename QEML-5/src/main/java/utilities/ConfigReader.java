package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class ConfigReader {
    private static Properties properties;
    public ConfigReader() throws IOException {
        properties=new Properties();
        loadProperties();
    }
    private void loadProperties() throws IOException {
        try{
            FileInputStream fileInputStream=new FileInputStream("src/test/resources/config.properties");
            properties.load(fileInputStream);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
