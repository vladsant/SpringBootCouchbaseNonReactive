package com.spring.couchbase.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.couchbase.exception.ResourceNotFoundException;
import com.spring.couchbase.model.AirlineEntity;
import com.spring.couchbase.repositories.AirlineRepository;
import com.spring.couchbase.service.AirlineService;

@Service
public class AirlineServiceImpl implements AirlineService {
   
	@Autowired
	AirlineRepository airlineRepository;
	
	@Override
	public AirlineEntity getAirlineDetailsById(String id) {
		Optional<AirlineEntity> airlineEntity =airlineRepository.findById(id);
		if(airlineEntity.isEmpty() || airlineEntity.get().getId()==null || airlineEntity.get().getId().isEmpty()) {
          throw new ResourceNotFoundException("Find Airline","Id",id);   			
		}else {
			return airlineEntity.get();
		}
	 }

	@Override
	public AirlineEntity updateAirlineDetails(AirlineEntity updatedAirlineEntity) {
		Optional<AirlineEntity> airlineEntity =airlineRepository.findById(updatedAirlineEntity.getId());
		if(airlineEntity.isEmpty() || airlineEntity.get().getId()==null || airlineEntity.get().getId().isEmpty()) {
          throw new ResourceNotFoundException("Find Airline","Id",updatedAirlineEntity.getId());   			
		}else {
			return airlineRepository.save(updatedAirlineEntity);
		}
	}
	

	@Override
	public Object deleteAirline(String id) {
		Optional<AirlineEntity> airlineEntity =airlineRepository.findById(id);
		if(airlineEntity.isEmpty() || airlineEntity.get().getId()==null || airlineEntity.get().getId().isEmpty()) {
          throw new ResourceNotFoundException("Find Airline","Id",id);   			
		}else {
			airlineRepository.deleteById(id);
			return id+" : Deleted Sucessfully";
		}
	}

	@Override
	public AirlineEntity addAirline(AirlineEntity airlineEntity) {
		return airlineRepository.save(airlineEntity);
	}

	@Override
	public List<AirlineEntity>  findAll() {
		return airlineRepository.findAll();
	}

}
