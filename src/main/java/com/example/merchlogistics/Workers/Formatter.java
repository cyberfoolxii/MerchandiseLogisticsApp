package com.example.merchlogistics.Workers;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Formatter {
    public static String format(int number) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        DecimalFormat decimalFormat = ((DecimalFormat) numberFormat);
        decimalFormat.applyPattern("###,###");
        return decimalFormat.format(number);
    }
}
