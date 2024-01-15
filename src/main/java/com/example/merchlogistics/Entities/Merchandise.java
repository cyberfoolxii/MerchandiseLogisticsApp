package com.example.merchlogistics.Entities;

import javafx.scene.image.Image;

import java.text.SimpleDateFormat;
import java.util.Date;

/* this class represents a merchandise*/
public class Merchandise implements Calculable, Comparable<Merchandise>, Available {

    private static int ordinal;
    private Image image;
    private String name;
    private int quantity;
    private int price;
    private final String code;
    private final String importDate;
    private String exportDate;

    public Merchandise() {
        code = "#" + ordinal;
        ordinal++;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        importDate = simpleDateFormat.format(new Date());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getImportDate() {
        return importDate;
    }

    public String getExportDate() {
        return exportDate;
    }

    public void setExportDate(String exportDate) {
        this.exportDate = exportDate;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public boolean isAvailable () {
        return quantity > 0;
    }

    @Override
    public double calculate() {
        return price * quantity;
    }

    @Override
    public int compareTo(Merchandise o) {
        return this.name.compareTo(o.name);
    }

}