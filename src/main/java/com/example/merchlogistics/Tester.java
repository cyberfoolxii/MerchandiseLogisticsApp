package com.example.merchlogistics;
import com.example.merchlogistics.Enums.SceneEnum;
public class Tester {

    private enum E {
        ONE,
        TWO,
        THREE
    }
    public static void main(String[] args) {
        System.out.println(E.values().length);
    }
}