package com.example.merchlogistics.Entities;

public class MerchandiseBuilder {
    private Merchandise merchandise;

    public void reset() {
        merchandise = new Merchandise();
    }

    public void buildName(String name) {
        merchandise.setMerchName(name);
    }

    public void buildPrice(double price) {
        merchandise.setPrice(price);
    }

    public void buildQuantity(int quantity) {
        merchandise.setQuantity(quantity);
    }

    public Merchandise getMerchandise() {
        return merchandise;
    }
}
