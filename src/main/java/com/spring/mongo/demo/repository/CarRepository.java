package com.spring.mongo.demo.repository;

import com.spring.mongo.demo.model.Car;
import com.spring.mongo.demo.model.Owner;
import com.spring.mongo.demo.model.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CarRepository extends MongoRepository<Car, String> {

    int countByColor(String color);

    List<Car> getCarByColorAndType(String color, String type);

    List<Car> findAll();

    Car findByIndex(int index);

    List<Car> findByType(String type);

    void deleteByOwner(Owner owner);

    void deleteByRegistration(Registration registration);

    boolean existsByOwner(Owner owner);

    boolean existsByRegistration(Registration registration);
}
