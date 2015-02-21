package com.disfinder.forest.test;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

import com.disfinder.forest.jenkins.model.Job;
import com.disfinder.forest.jenkins.model.Jobs;

public class testJobsCreate {
    static Jobs getSomeJobs(){
	Jobs jobs=new Jobs();
	Job job=new Job();
	job.name="stub_job1";
	job.parameters.put("param0", "value0");
	job.parameters.put("param1", "value1");
	jobs.jobsList.add(job);
	return jobs;
    }

    
    static Jobs getSomeJobs(int count){
	Jobs jobs=new Jobs();
	Random rand=new Random();
	for(int i=0;i<count;i++)
	{
	    Job job=new Job();
	    job.name="job_"+i;
	    for (int j=0;j<rand.nextInt(count);j++)
	    {
		job.parameters.put("param_"+j, RandomStringUtils.random(10,false,true));
	    }
	    jobs.jobsList.add(job);
	}
	return jobs;
    }

}
