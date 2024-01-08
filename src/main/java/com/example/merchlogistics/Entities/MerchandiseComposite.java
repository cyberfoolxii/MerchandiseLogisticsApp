package com.example.merchlogistics.Entities;

import java.util.ArrayList;
import java.util.List;

public class MerchandiseComposite implements Calculable {
    private final List<Calculable> calculableList = new ArrayList<>();

    public void add(Calculable calculable) {
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

}
