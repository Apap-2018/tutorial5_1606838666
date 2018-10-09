package com.apap.tutorial5.service;

import java.util.Optional;

import com.apap.tutorial5.model.CarModel;
import com.apap.tutorial5.model.DealerModel;

/**
 * 
 * @author faisalridwan
 * CarService
 */
public interface CarService {
	void addCar(CarModel car);
	void deleteCar(long carId);
	void editCar(CarModel newCar, Long id);
	Optional<CarModel> getCarDetailById(Long id);
}
