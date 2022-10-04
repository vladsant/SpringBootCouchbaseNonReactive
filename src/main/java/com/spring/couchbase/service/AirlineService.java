package com.spring.couchbase.service;

import java.util.List;
import java.util.Optional;

import com.spring.couchbase.model.AirlineEntity;

public interface AirlineService {
	public AirlineEntity addAirline(AirlineEntity airlineEntity);	
	public AirlineEntity getAirlineDetailsById(String id);
	public AirlineEntity updateAirlineDetails(AirlineEntity airlineEntity);
	public Object  deleteAirline(String id);
	public List<AirlineEntity>  findAll();
}
