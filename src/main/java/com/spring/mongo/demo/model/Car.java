package com.spring.mongo.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cars")
public class Car {
    @Id
    private String id;
    private String type;
    private String color;
    private int vin;
    private Owner owner;
    private Registration registration;
    private int index;

    public Car(String id, String type, String color, int vin, Owner owner, Registration registration, int index) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.vin = vin;
        this.owner = owner;
        this.registration = registration;
        this.index = index;
    }

    public Car(String type, String color, int vin, Owner owner, Registration registration, int index) {
        this.type = type;
        this.color = color;
        this.vin = vin;
        this.owner = owner;
        this.registration = registration;
        this.index = index;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", vin=" + vin +
                ", owner=" + owner +
                ", registration=" + registration +
                ", index=" + index +
                '}';
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
