package com.disfinder.forest.cache;

import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.disfinder.forest.jenkins.model.Job;

public class ForestCache {
    public int a = 1;
    private static final Log LOG = LogFactory.getLog(ForestCache.class);
    public static ForestCache instance = new ForestCache();
    // public Jobs jobs=new Jobs();;
    public ArrayList<Job> allJobs = new ArrayList<Job>();
    public ArrayList<Job> selectedJobs = new ArrayList<Job>();

    private void loadFromDisk() {
	LOG.info("Start load cache from disk.");

    }

    private ForestCache() {

    }

    public void initeRandomJobs(int count) {
	allJobs.clear();
	Random rand = new Random();
	for (int i = 0; i < count; i++) {
	    Job job = new Job();
	    job.name = "job_" + i;
	    for (int j = 0; j < rand.nextInt(count); j++) {
		job.parameters.put("param_" + j, "value_" + j);// RandomStringUtils.random(10,false,true));
	    }
	    allJobs.add(job);
	}
	// return jobs;
    }

    public static ForestCache getInstance() {
	if (instance == null) {
	    instance = new ForestCache();
	}

	return instance;
    }

}
