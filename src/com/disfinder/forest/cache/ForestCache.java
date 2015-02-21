package com.disfinder.forest.cache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.disfinder.forest.jenkins.model.Jobs;

public class ForestCache {
    public int a = 1;
    private static final Log LOG = LogFactory.getLog(ForestCache.class);
    public static ForestCache instance = new ForestCache();
    public Jobs jobs;
    
    private void loadFromDisk(){
	
    }
    private ForestCache() {
	
    }

    public static ForestCache getInstance() {
	if (instance == null) {
	    instance = new ForestCache();
	}
	return instance;
    }


}
