package com.disfinder;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.disfinder.forest.cache.ForestCacheManager;

public class StartupListener implements ServletContextListener {
    private static final Log LOG = LogFactory.getLog(StartupListener.class);
    

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
	LOG.info("Destroying context...");
	
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
	LOG.info("Initializing context...");
	LOG.debug("Init cache...");
	ForestCacheManager forestCacheManager=new ForestCacheManager();
	Boolean isCacheFilled=(Boolean) forestCacheManager.getFromCache(Constants.IS_CACHE_FILLED_NAME);
	LOG.debug("is cache filled:"+isCacheFilled);
	if(isCacheFilled==null)
	{ 
	    LOG.debug("Fill cache...");
	    forestCacheManager.initCache();
	}
	isCacheFilled=(Boolean) forestCacheManager.getFromCache(Constants.IS_CACHE_FILLED_NAME);
	LOG.debug("is cache filled:"+isCacheFilled);
	
	
    }

}
