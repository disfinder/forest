package com.disfinder.forest.cache;

import java.net.URL;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.disfinder.forest.jenkins.model.Job;
import com.disfinder.forest.jenkins.model.Jobs;

public final class ForestCacheManager {
    private static final Log LOG = LogFactory.getLog(ForestCacheManager.class);
    private CacheManager cacheManager;
    private static final String JOBS_CACHE = "jobsCache";

    public ForestCacheManager()
    {
	URL url = getClass().getClassLoader().getResource("WEB-INF/forest.xml");//getResource("/forest.xml");
	
	//URL config = getContext().getServletContext().getResource("/WEB-INF/config.groovy");
	CacheManager cacheManager = CacheManager.newInstance(url);
//	CacheManager cacheManager = CacheManager.newInstance("forest.xml");
	this.cacheManager=cacheManager;
    }
//    public ForestCacheManager(final CacheManager cacheManager) {
//	this.cacheManager = cacheManager;
//    }

    public Element putToCacheElement(final String objectKey, final Object object) {
	Cache cache = cacheManager.getCache(JOBS_CACHE);
	Element el = new Element(objectKey, object);
	LOG.debug("Put to cache "+JOBS_CACHE+" by  key "+objectKey+ " an element "+object);
	cache.put(el);
	return el;
    }
    
    public Object getFromCache(
	      final String objectKey) {
	    Cache cache = cacheManager.getCache(JOBS_CACHE);
	    Element el=cache.get(objectKey);
	    //Element el = getFromCacheElement(objectKey);
	    return el != null ? el.getObjectValue() : null;
	  }
    
    public void initCache()
    {
	Cache cache = cacheManager.getCache(JOBS_CACHE);
	Jobs jobs=new Jobs();
	Job job=new Job();
	job.name="stub_job1";
	job.parameters.put("param0", "value0");
	job.parameters.put("param1", "value1");
	jobs.jobsList.add(job);
	
	Element stub=new Element("Jobs", jobs);
	cache.put(stub);
	
	Element init=new Element(com.disfinder.Constants.IS_CACHE_FILLED_NAME, new Boolean(true));
	cache.put(init);
	//Boolean isCacheFilled=(Boolean) forestCacheManager.getFromCache(IS_CACHE_FILLED_NAME);
    }

}
