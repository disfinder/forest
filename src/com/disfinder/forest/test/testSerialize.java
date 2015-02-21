package com.disfinder.forest.test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.disfinder.forest.jenkins.model.Jobs;

public class testSerialize {
    private static final Log LOG = LogFactory.getLog(testSerialize.class);

    public static void main(String[] args) {
	Jobs jobs=testJobsCreate.getSomeJobs(8);
	System.out.println(jobs);
	
	    //serialize the List
	    try (
	      OutputStream file = new FileOutputStream("quarks.ser");
	      OutputStream buffer = new BufferedOutputStream(file);
	      ObjectOutput output = new ObjectOutputStream(buffer);
	    ){
	      output.writeObject(jobs);
	    }  
	    catch(IOException ex){
	      LOG.error("Cannot perform output."+ex);
	    }
    }

}
