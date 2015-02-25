package com.disfinder.forest;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.disfinder.forest.cache.ForestCache;

public class StartupListener implements ServletContextListener {   
    private static final Log LOG = LogFactory.getLog(StartupListener.class);
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {	
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
	Configuration configuration = Configuration.getInstance();
	configuration.init();
	
	ForestCache cache = ForestCache.getInstance();
	cache.initeRandomJobs(10);
	
	LOG.debug("Config: "+Configuration.getProperties());
	LOG.info("Application Forest started up, growing and waving branches.");
	
    }

}
