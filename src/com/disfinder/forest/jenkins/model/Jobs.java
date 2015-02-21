package com.disfinder.forest.jenkins.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Jobs implements Serializable {
    private static final long serialVersionUID = 1L;
    public ArrayList<Job> jobsList = new ArrayList<Job>();

    private void writeObject(ObjectOutputStream o) throws IOException {
	o.writeObject(jobsList);
    }

    //@SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream o) throws IOException, ClassNotFoundException {
	jobsList = (ArrayList<Job>) o.readObject();
	validate();
    }

    private void validate() {
	if (jobsList == null || jobsList.size() == 0)
	    throw new IllegalArgumentException();
    }
    
    @Override
    public String toString() {
	String s=new String();
	if(jobsList.size()==0)
	{
	    s="EMPTY";
	}
	else
	{
	    s="";
	    for(Job j:jobsList){
		s+=j.toString();
	    }
	}
	
	
	return s;
    }
}
