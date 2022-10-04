	package com.spring.couchbase.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories;;

@Configuration
@EnableReactiveCouchbaseRepositories("com.spring.couchbase.repositories")
public class CouchbaseConfiguration extends AbstractCouchbaseConfiguration {

    private CouchbaseProperties couchbaseProperties;

    public CouchbaseConfiguration(CouchbaseProperties couchbaseProperties) {
        this.couchbaseProperties = couchbaseProperties;
    }

	@Override
	public String getConnectionString() {
		return couchbaseProperties.getConnectionString();
	}

	@Override
	public String getUserName() {
		return couchbaseProperties.getUserName();
	}

	@Override
	public String getPassword() {
		return couchbaseProperties.getPassword();
	}

	@Override
	public String getBucketName() {
	    return couchbaseProperties.getBucketName();
	}    
}