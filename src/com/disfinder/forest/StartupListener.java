package com.disfinder.forest;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.disfinder.forest.cache.ForestCache;

public class StartupListener implements ServletContextListener {    
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {	
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
	
	ForestCache cache = ForestCache.getInstance();
	cache.initeRandomJobs(10);
	
	
    }

}
