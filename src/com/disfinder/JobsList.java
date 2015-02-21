package com.disfinder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.http.client.ClientProtocolException;

public class JobsList {
    public ArrayList<String> jobsList = new ArrayList<String>();

    public boolean initJobsList() {
	Properties configuration = Configuration.getConfiguration();
	try {
	    String response = GetHttpResponse.get(configuration.getProperty("list_url"), configuration.getProperty("username"),
	    	configuration.getProperty("password"));
	    System.out.println(response);
	    // TODO parse Jenkins response
	} catch (ClientProtocolException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return false;
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return false;
	}

	return true;
    }
}
