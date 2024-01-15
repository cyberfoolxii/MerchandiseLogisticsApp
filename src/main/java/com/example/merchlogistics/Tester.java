package com.example.merchlogistics;
import com.example.merchlogistics.Enums.SceneEnum;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Tester {

    public static boolean isSatisfied(int n) {
        double low = 0.0;
        double high = n;
        double mid = 0.0;
        while (true) {
            mid = low + (high - low) / 2;
            double x = mid * mid;
            if (x < n) low = mid + 0.01;
            if (x > n) high = mid - 0.01;
            if (x >= n - 0.01 && x <= n + 0.01) {
                System.out.println("x : " + x);
                if ((int) x != n) return false;
                break;
            }
        }
        return isPrime((int) mid);
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= n - 1; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        DecimalFormat decimalFormat = ((DecimalFormat) numberFormat);
        decimalFormat.applyPattern("###,###");

        int a = 123456789;
        System.out.println(decimalFormat.format(a));
    }
}