package ukr.astelit;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    static String configFilename = "config.properties";
    public static Properties properties=new Properties();
    
    public static Properties getConfiguration()
    {
	return properties;
    }

    public Configuration() {
	ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	InputStream stream = classLoader.getResourceAsStream(configFilename);

	if (stream == null) {
	    System.out.println("No file found.");
	} else {
	    System.out.println("file found.");
	    //Properties p = new Properties();
	    try {
		properties.load(stream);
	    } catch (IOException e) {
		System.out.println(e.getMessage());// e.();
	    }
	}
    }
}
