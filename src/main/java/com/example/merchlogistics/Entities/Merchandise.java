package com.example.merchlogistics.Entities;

import javafx.scene.image.Image;

import java.text.SimpleDateFormat;
import java.util.Date;

/* this class represents a merchandise*/
public class Merchandise implements Calculable, Comparable<Merchandise> {
    private static int ordinal;
    private final Image image;
    private final String name;
    private final int price;
    private final int quantity;
    private final String code;

    public Merchandise(Image image, String name, int price, int quantity) {
        code = "#" + (ordinal++);
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCode() {
        return code;
    }

    public Image getImage() {
        return image;
    }

    @Override
    public int compareTo(Merchandise o) {
        int comp = this.name.compareTo(o.name);
        if (comp > 0) {
            return 1;
        } else if (comp < 0) {
            return -1;
        }
        return this.code.compareTo(o.code);
    }

    @Override
    public int calculate() {
        return price * quantity;
    }
}