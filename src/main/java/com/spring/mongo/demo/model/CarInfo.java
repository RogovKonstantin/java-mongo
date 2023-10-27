package com.spring.mongo.demo.model;

public class CarInfo {

    private int count;
    private String id;





    public String getId() {
        return id;
    }

    public void set_id(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString() {
        return "CarInfo{" +
                "type='" + id + '\'' +
                ", count=" + count +
                '}';
    }
}