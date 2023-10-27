package com.spring.mongo.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CarNotFoundException extends RuntimeException{
    public CarNotFoundException(){
        super("Car not found");
    }
}
