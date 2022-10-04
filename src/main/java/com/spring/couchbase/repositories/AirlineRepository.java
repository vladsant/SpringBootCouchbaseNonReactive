package com.spring.couchbase.repositories;

import java.util.List;

import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.couchbase.model.AirlineEntity;

@Repository
public interface AirlineRepository extends CrudRepository<AirlineEntity, String> {
	@Query("#{#n1ql.selectEntity} WHERE type=\"airline\"") 
	public List<AirlineEntity> findAll();
}