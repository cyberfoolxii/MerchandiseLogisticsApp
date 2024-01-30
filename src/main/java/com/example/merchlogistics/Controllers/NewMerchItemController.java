package com.example.merchlogistics.Controllers;

import com.example.merchlogistics.Entities.MerchandiseComposite;
import com.example.merchlogistics.Enums.SceneEnum;
import com.example.merchlogistics.Workers.Browsable;
import com.example.merchlogistics.Workers.SceneManager;
import com.example.merchlogistics.Workers.URIBrowser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.List;

public class NewMerchItemController {
    private Stage stage;
    private final Browsable browsable = new URIBrowser();
    private MerchandiseComposite merchandiseComposite;
    private LinkedList<NewSubitemController> newSubitemControllers = new LinkedList<>();
    @FXML
    private Label sumLabel;
    @FXML
    private TextField imagePathTextField;
    @FXML
    private TextField merchNameTextField;
    @FXML
    private TextField merchQuantityTextField;
    @FXML
    private ImageView imageView;
    @FXML
    private VBox myVBox;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private void updateImageView() {
        Image image = new Image(imagePathTextField.getText());
        imageView.setImage(image);
    }

    public void browse(ActionEvent event) {
        imagePathTextField.setText(browsable.browse());
        updateImageView();
    }

    public void cancel(ActionEvent event) {
        stage.close();
    }

    public void modify(ActionEvent event) {
        setEditable(true);
    }

    public void complete(ActionEvent event) {
        setEditable(false);
        buildMerchComposite();
        MerchSceneController merchSceneController = (MerchSceneController) SceneManager
                .getInstance()
                .getController(SceneEnum.MERCH_SCENE);
        merchSceneController.addMerch(merchandiseComposite);
        stage.close();
    }

    public void buildMerchComposite() {
        merchandiseComposite = new MerchandiseComposite(
                new Image(imagePathTextField.getText()),
                merchNameTextField.getText());

        for (NewSubitemController newSubitemController : newSubitemControllers) {
            newSubitemController.buildNewMerch();
            merchandiseComposite.addItem(newSubitemController.getMerchandise());
        }
    }

    public MerchandiseComposite getMerchandiseComposite() {
        return merchandiseComposite;
    }

    private void setEditable(boolean isEditable) {
        imagePathTextField.setEditable(isEditable);
        merchNameTextField.setEditable(isEditable);
        merchQuantityTextField.setEditable(isEditable);
    }

    public void addNewSubMerch (ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXMLs/Items/NewSubitem.fxml"));
        try {
            myVBox.getChildren().add(fxmlLoader.load());
            newSubitemControllers.add(fxmlLoader.getController());
        } catch (Exception ignore) {

        }
    }
}
