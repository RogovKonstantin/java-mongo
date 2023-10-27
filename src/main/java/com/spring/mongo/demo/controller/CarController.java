package com.spring.mongo.demo.controller;

import com.spring.mongo.demo.model.Car;
import com.spring.mongo.demo.model.CarInfo;
import com.spring.mongo.demo.model.Owner;
import com.spring.mongo.demo.model.Registration;
import com.spring.mongo.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public List<Car> getAll() {
        return carService.getAllCars();
    }

    @GetMapping("/cars/countbytype")
    public List<CarInfo> byTypeCount() {
        try {
            carService.groupCarsByType();
        } catch (Exception e) {
            throw new CarNotFoundException();
        }
        return carService.groupCarsByType();
    }

    @GetMapping("/cars/countbycolor/{color}")
    public int count(@PathVariable String color) {
        try {
            carService.getCountByColor(color);
        } catch (Exception e) {
            throw new CarNotFoundException();
        }
        return carService.getCountByColor(color);
    }


    @GetMapping("/cars/{carId}")
    public Car getCarById(@PathVariable String carId) {
        try {
            carService.getCarById(carId);
        } catch (Exception e) {
            throw new CarNotFoundException();
        }
        return carService.getCarById(carId);

    }

    @PostMapping("/cars")
    public Car newCar(@RequestBody Car car) {
        return carService.createCar(car);

    }

    @PutMapping("/cars/{carId}/{color}")
    public Car car(@PathVariable String carId, @PathVariable String color) {
        return carService.updateCarColorById(carId, color);
    }

    @DeleteMapping("/cars/{carId}")
    void deleteCar(@PathVariable String carId) {
        carService.deleteCar(carId);
    }

    @DeleteMapping("/cars/deleteByOwner")
    public Map<String, String> deleteByOwner(@RequestBody Owner owner) {
        return carService.deleteByOwner(owner);
    }

    @DeleteMapping("/cars/deleteByRegistration")
    public Map<String, String> deleteByRegistration(@RequestBody Registration registration) {
        return carService.deleteByRegistration(registration);
    }

}
