package com.spring.couchbase.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CouchbaseProperties {

    private String connectionString;
    private String userName;
    private String password;
    private String bucketName;
    private int port;

    
    public CouchbaseProperties(
      @Value("${spring.couchbase.connection-string}") String connectionString, 
      @Value("${spring.couchbase.user.name}") String userName, 
      @Value("${spring.couchbase.password}") String password, 
       @Value("${spring.couchbase.bucket.name}") String bucketName, 
      @Value("${spring.couchbase.port}") int port) {
        this.connectionString = connectionString;
        this.userName = userName;
        this.password = password;
        this.bucketName=bucketName;
        this.port = port;
    }

	
	public String getConnectionString() {
		return connectionString;
	}


	public String getUserName() {
		return userName;
	}


	public String getPassword() {
		return password;
	}


	public String getBucketName() {
		return bucketName;
	}


	public int getPort() {
		return port;
	}
   
}