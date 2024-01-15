package com.example.merchlogistics.Entities;

import javafx.scene.image.Image;

import java.io.File;

public class MerchandiseBuilder {
    private Merchandise merchandise;

    public MerchandiseBuilder() {
        reset();
    }

    public void reset() {
        merchandise = new Merchandise();
    }

    public void buildImage(String path) {
        File file = new File(path);
        Image image = new Image(file.toURI().toString());
        merchandise.setImage(image);
    }

    public void buildName(String name) {
        merchandise.setName(name);
    }

    public void buildPrice(int price) {
        merchandise.setPrice(price);
    }

    public void buildQuantity(int quantity) {
        merchandise.setQuantity(quantity);
    }

    public Merchandise getMerchandise() {
        return merchandise;
    }
}
