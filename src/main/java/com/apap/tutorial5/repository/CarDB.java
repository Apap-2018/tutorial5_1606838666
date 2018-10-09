package com.apap.tutorial5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tutorial5.model.CarModel;

/**
 * 
 * @author faisalridwan
 * CarDB
 */
@Repository
public interface CarDB extends JpaRepository<CarModel, Long>{
	CarModel findByType(String type);
}
