package com.spring.mongo.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.spring.mongo.demo.model.Car;
import com.spring.mongo.demo.model.CarInfo;
import com.spring.mongo.demo.model.Owner;
import com.spring.mongo.demo.model.Registration;

public interface CarService {

	List<CarInfo> groupCarsByType();

	List<Car> getCarByColorAndType(String color, String type);

	int getCountByColor(String color);

	Car createCar(Car car);

	Car updateCarColorById(String id, String color);

	List<Car> getAllCars();

	Car getCarById(String id);

	void deleteCar(String id);

	Map<String, String> deleteByOwner(Owner owner);
	Map<String, String> deleteByRegistration(Registration registration);


}
