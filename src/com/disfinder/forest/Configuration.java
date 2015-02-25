package com.disfinder.forest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Configuration {
    private static final Log LOG = LogFactory.getLog(Configuration.class);
    static String configFilename = "config.properties";
    private static Properties properties=new Properties();
    public static Configuration instance = new Configuration();
    
    public static Properties getConfiguration()
    {
	return getProperties();
    }

//    public static Properties getConfiguration(ServletConfig servletConfig)
//    {
//	 String path = servletConfig.getServletContext().getRealPath("/WEB-INF");
//	 LOG.info(path);
//	 return properties;
//    }    
    
    private Configuration() {}
    

    public static Configuration getInstance() {
	if (instance == null) {
	    instance = new Configuration();
	}

	return instance;
    }
    

    public void init()  {
	//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	//InputStream stream = classLoader.getResourceAsStream(configFilename);
	
	InputStream stream = this.getClass().getClassLoader().getResourceAsStream(Constants.PROPERTIES_FILENAME);
	if (stream == null) {
	    LOG.fatal("No configuration file found");
	    //throw new FileNotFoundException("No config found.");
	    //System.out.println("No file found.");
	} else {
	    System.out.println("file found.");
	    //Properties p = new Properties();
	    try {
		getProperties().load(stream);
		LOG.info("Properties: "+getProperties());
	    } catch (IOException e) {
		System.out.println(e.getMessage());// e.();
	    }
	}
    }

    public static Properties getProperties() {
	return properties;
    }

    public static void setProperties(Properties properties) {
	Configuration.properties = properties;
    }
}
