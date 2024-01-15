package com.example.merchlogistics.Controllers;

import com.example.merchlogistics.Entities.MerchandiseBuilder;
import com.example.merchlogistics.Enums.SceneEnum;
import com.example.merchlogistics.Workers.Getter;
import com.example.merchlogistics.Workers.SceneSwitchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class NewMerchItemController {
    private Stage stage;
    private final MerchandiseBuilder merchandiseBuilder = new MerchandiseBuilder();

    @FXML
    private TextField imagePathTextField;
    @FXML
    private TextField merchNameTextField;
    @FXML
    private TextField merchQuantityTextField;
    @FXML
    private TextField merchPriceTextField;
    @FXML
    private ImageView imageView;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void updateImageView() {
        File file = new File(imagePathTextField.getText());
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }

    public void browse(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file == null) {
            System.out.println("file error");
        } else {
            imagePathTextField.setText(file.getAbsolutePath());
            updateImageView();
        }
    }

    public void cancel(ActionEvent event) {
        stage.close();
    }

    public void complete(ActionEvent event) {
        merchandiseBuilder.buildImage(imagePathTextField.getText());
        merchandiseBuilder.buildName(merchNameTextField.getText());
        merchandiseBuilder.buildQuantity(Integer.parseInt(merchQuantityTextField.getText()));
        merchandiseBuilder.buildPrice(Integer.parseInt(merchPriceTextField.getText()));
        MerchSceneController merchSceneController =
                (MerchSceneController) Getter.getInstance().getController(SceneEnum.MERCH_SCENE);
        merchSceneController.addMerch(merchandiseBuilder.getMerchandise());
        stage.close();
    }

    public void addNewSubMerch(ActionEvent event) {

    }
}
