package com.spring.couchbase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.couchbase.exception.ResourceNotFoundException;
import com.spring.couchbase.model.AirlineEntity;
import com.spring.couchbase.service.AirlineService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/airline/")
public class AirlineController {
	
	@Autowired
	AirlineService airlineService;
	
	@PostMapping()
	public AirlineEntity addAirline(@RequestBody AirlineEntity airlineEntity){
		return airlineService.addAirline(airlineEntity);
	}
	
	@GetMapping("/all")
	public List<AirlineEntity> getAllAirline()
	{
		return airlineService.findAll();
	}

	@GetMapping("/{id}")
	public AirlineEntity getAirlineDetailsById(@PathVariable("id") String id)
	{
		return airlineService.getAirlineDetailsById(id);
	}
	
	@PutMapping("/{id}")
	  public  AirlineEntity updateAirlineDetails(@PathVariable("id") String id, @RequestBody AirlineEntity airlineEntity) {
		if(id.equals(airlineEntity.getId())) {
			return airlineService.updateAirlineDetails(airlineEntity);				
		}else {
			throw new  ResourceNotFoundException("Enter correct Airline id","Airline Id",id);
	    }
	  }
	
	@DeleteMapping("/{id}")
	  public  Object deleteAirline(@PathVariable("id") String id) {
	    return airlineService.deleteAirline(id);
	  }
}
