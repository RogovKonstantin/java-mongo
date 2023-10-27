package com.spring.mongo.demo.service.impl;

import com.spring.mongo.demo.model.Car;
import com.spring.mongo.demo.model.CarInfo;
import com.spring.mongo.demo.model.Owner;
import com.spring.mongo.demo.model.Registration;
import com.spring.mongo.demo.repository.CarRepository;
import com.spring.mongo.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private final MongoTemplate mongoTemplate;
    @Autowired
    private CarRepository carRepository;

    public CarServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<CarInfo> groupCarsByType() {
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.group("type").count().as("count"), Aggregation.project().andInclude("type", "count"));
        AggregationResults<CarInfo> results = mongoTemplate.aggregate(aggregation, "cars", CarInfo.class);
        return results.getMappedResults();
    }

    @Override
    public List<Car> getCarByColorAndType(String color, String type) {
        return carRepository.getCarByColorAndType(color, type);
    }

    @Override
    public int getCountByColor(String color) {
        return carRepository.countByColor(color);
    }

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCarColorById(String id, String color) {
        Optional<Car> carDb = this.carRepository.findById(id);

        if (carDb.isPresent()) {
            Car carUpdate = carDb.get();
            carUpdate.setColor(color);

            carRepository.save(carUpdate);
            System.out.println("цвет обновлен");
            return carUpdate;
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(String id) {

        Optional<Car> carDb = this.carRepository.findById(id);

        if (carDb.isPresent()) {
            return carDb.get();
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteCar(String id) {
        Optional<Car> productDb = this.carRepository.findById(id);

        if (productDb.isPresent()) {
            this.carRepository.delete(productDb.get());
            System.out.println("машина удалена");
        } else {
            System.out.println("not found");
        }
    }

    @Override
    public Map<String, String> deleteByOwner(Owner owner) {
        Map<String, String> response = new HashMap<>();
        boolean exists = carRepository.existsByOwner(owner);
        if (exists) {
            carRepository.deleteByOwner(owner);
            response.put("status", "OK");
            response.put("data", "Car deleted by owner");
        } else {
            response.put("status", "FAIL");
            response.put("data", "Owner not found");
        }
        return response;
    }

    @Override
    public Map<String, String> deleteByRegistration(Registration registration) {
        Map<String, String> response = new HashMap<>();
        boolean exists = carRepository.existsByRegistration(registration);
        if (exists) {
            carRepository.deleteByRegistration(registration);
            response.put("status", "OK");
            response.put("data", "Car deleted by registration");
        } else {
            response.put("status", "FAIL");
            response.put("data", "Registration not found");
        }
        return response;
    }
}
