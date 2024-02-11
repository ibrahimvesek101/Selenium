package Utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigurationReader {

        public static Properties properties;
        static {
            String  path = "Config.properties";

            try {
                FileInputStream fis = new FileInputStream(path);
                properties = new Properties();
                properties.load(fis);
                fis.close();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
        public static String getProperty(String key){
            return properties.getProperty(key);
        }

}
