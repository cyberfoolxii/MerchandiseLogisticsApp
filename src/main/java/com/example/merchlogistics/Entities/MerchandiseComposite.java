package com.example.merchlogistics.Entities;

import javafx.scene.image.Image;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchandiseComposite implements Calculable, Available, Comparable<MerchandiseComposite> {
    private final List<Calculable> calculableList = new ArrayList<>();
    private final Image image;
    private final String name;
    private String createDate;
    private String exportDate;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

    public MerchandiseComposite(Image image, String name) {
        this.image = image;
        this.name = name;
        createDate = simpleDateFormat.format(new Date());
    }

    public MerchandiseComposite(MerchandiseComposite merchandiseComposite) {
        this.image = merchandiseComposite.image;
        this.name = merchandiseComposite.name;
        this.createDate = merchandiseComposite.createDate;
        this.exportDate = merchandiseComposite.exportDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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

    public String getName() {
        return name;
    }

    public void addItem(Calculable calculable) {
        calculableList.add(calculable);
    }

    @Override
    public int calculate() {
        int totalPrice = 0;
        for (Calculable calculable : calculableList) {
            totalPrice += calculable.calculate();
        }
        return totalPrice;
    }

    @Override
    public boolean isAvailable() {
        return calculableList.isEmpty();
    }

    @Override
    public int compareTo(MerchandiseComposite o) {
        return this.name.compareTo(o.name);
    }
}
