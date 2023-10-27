package com.spring.mongo.demo.model;

public class Registration {

    private String date;
    private String plate;

    public Registration(String date, String plate) {
        this.date = date;
        this.plate = plate;
    }


    @Override
    public String toString() {
        return "Registration{" +
                "date='" + date + '\'' +
                ", plate='" + plate + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
