package com.example.merchlogistics.Entities;

import java.io.Serializable;

/* this class represents a merchandise*/
public class Merchandise implements Calculable, Serializable {
    private String merchName;
    private int quantity;
    private double price;

    public String getMerchName() {
        return merchName;
    }

    public void setMerchName(String merchName) {
        this.merchName = merchName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double calculate() {
        return price * quantity;
    }
}