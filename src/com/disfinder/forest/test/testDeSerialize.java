package com.disfinder.forest.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.disfinder.forest.jenkins.model.Jobs;

public class testDeSerialize {
//    private static final Log LOG = LogFactory.getLog(ForestCacheManager.class);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
	Jobs jobs=new Jobs();//testJobsCreate.getSomeJobs();
	
	    //unserialize
	   FileInputStream fis = new FileInputStream("quarks.ser");
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    jobs = (Jobs) ois.readObject();
	    ois.close();
	      
	    System.out.println("--Serialized object--");
	    System.out.println(jobs.toString());
	    
	    
	    


}
    }
