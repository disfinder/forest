package com.disfinder;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetHttpResponse {
    //Integer portNumber=8080;
    static String get(String URL, String username, String password) throws ClientProtocolException, IOException {
	String s_response = null;

	CredentialsProvider credsProvider = new BasicCredentialsProvider();
	//credsProvider.setCredentials(new AuthScope("localhost", 443), new UsernamePasswordCredentials("username", "password"));
	credsProvider.setCredentials(new AuthScope("localhost", -1 /*any port*/), new UsernamePasswordCredentials(username, password));
	CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
	try {
	    HttpGet httpget = new HttpGet(URL);

	    //System.out.println("Executing request " + httpget.getRequestLine());
	    CloseableHttpResponse response = httpclient.execute(httpget);
	    try {
		//System.out.println("----------------------------------------");
		//System.out.println(response.getStatusLine());
		HttpEntity entity = response.getEntity();
		s_response=EntityUtils.toString(entity);
		EntityUtils.consume(response.getEntity());
	    } finally {
		response.close();
	    }
	} finally {
	    httpclient.close();
	}

	return s_response;

    }

}
