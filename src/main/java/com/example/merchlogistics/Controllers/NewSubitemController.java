package com.example.merchlogistics.Controllers;

import com.example.merchlogistics.Entities.Merchandise;
import com.example.merchlogistics.Workers.Browsable;
import com.example.merchlogistics.Workers.URIBrowser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NewSubitemController {
    private Merchandise merchandise;
    private final Browsable browsable = new URIBrowser();

    @FXML
    private ImageView imageView;
    @FXML
    private TextField imagePathTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField quantityTextField;
    @FXML
    private Button confirmButton;
    @FXML
    private Button browseButton;
    private Image image;
    private boolean isConfirmed;

    public Merchandise getMerchandise() {
        return merchandise;
    }

    public void browse(ActionEvent event) {
        String path = browsable.browse();
        imagePathTextField.setText(path);
        image = new Image(path);
        imageView.setImage(image);
    }

    public void confirm(ActionEvent event) {
        if (isConfirmed) {
            changeEditability(true);
            confirmButton.setText("Đồng ý");
        } else {
            buildNewMerch();
            changeEditability(false);
            confirmButton.setText("Sửa");
        }
        isConfirmed = !isConfirmed;
    }

    public void buildNewMerch() {
        merchandise = new Merchandise(
                image,
                nameTextField.getText(),
                Integer.parseInt(priceTextField.getText()),
                Integer.parseInt(quantityTextField.getText()));
    }

    public void changeEditability(boolean isEditable) {
        imagePathTextField.setEditable(isEditable);
        nameTextField.setEditable(isEditable);
        priceTextField.setEditable(isEditable);
        quantityTextField.setEditable(isEditable);
        browseButton.setDisable(!isEditable);
    }
}