package com.example.merchlogistics.Workers;

import javafx.stage.FileChooser;

import java.io.File;

public class URIBrowser implements Browsable {
    @Override
    public String browse() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file == null) {
            return null;
        }
        return file.toURI().toString();
    }
}
