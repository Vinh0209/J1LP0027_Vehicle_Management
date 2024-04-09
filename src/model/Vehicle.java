/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author BAO TRAN
 */
public class Vehicle {

    private String id;
    private String type;
    private String name;
    private String color;
    private double price;
    private String brand;
    private int productYear;

    public Vehicle(String id, String type, String name, String color, double price, String brand, int productYear) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.color = color;
        this.price = price;
        this.brand = brand;
        this.productYear = productYear;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getProductYear() {
        return productYear;
    }

    public void setProductYear(int productYear) {
        this.productYear = productYear;
    }

   
    @Override
    public String toString() {
        return id + ", " + type + ", " + name + ", " + color + ", " + price + ", " + brand + ", " + productYear;
    }
}
