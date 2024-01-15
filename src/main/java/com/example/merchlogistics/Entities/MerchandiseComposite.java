package com.example.merchlogistics.Entities;

import java.util.ArrayList;
import java.util.List;

public class MerchandiseComposite implements Calculable, Available {
    private final List<Calculable> calculableList = new ArrayList<>();

    public void addItem(Calculable calculable) {
        calculableList.add(calculable);
    }

    @Override
    public double calculate() {
        double totalPrice = 0.0;
        for (Calculable calculable : calculableList) {
            totalPrice += calculable.calculate();
        }
        return totalPrice;
    }

    @Override
    public boolean isAvailable() {
        for (Calculable calculable : calculableList) {
            Available available = (Available) calculable;
            if (available.isAvailable()) {
                return true;
            }
        }
        return false;
    }
}
