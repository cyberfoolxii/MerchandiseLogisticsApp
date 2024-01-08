package com.example.merchlogistics.ExceptionLoggers;

import java.io.IOException;

public class IOExceptionLogger implements Loggable {
    @Override
    public void showExceptionLog() {
        System.out.println("IOException encountered!");
    }
}
