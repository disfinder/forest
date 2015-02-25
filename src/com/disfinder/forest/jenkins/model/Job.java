package com.disfinder.forest.jenkins.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class Job implements Serializable{
    private static final long serialVersionUID = -7364344106314468882L;
    public String name="";
    public HashMap<String, String> parameters=new HashMap<String, String>();

    private void writeObject(ObjectOutputStream o)
	    throws IOException {  
	    o.writeObject(name);
	    o.writeObject(parameters);
	  }
    
    private void readObject(ObjectInputStream o) throws IOException, ClassNotFoundException {
	name = (String) o.readObject();
	parameters=(HashMap<String, String>) o.readObject();
	validate();
    }

    private void validate() {
	if (name == null || name.length()==0)
	    throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
	String s="";//new String();
	s+=name+"(";
	for(String p:parameters.keySet()){
	    s+=p+":"+parameters.get(p)+",";
	}
	s+=")";
	return s;
    }
}
