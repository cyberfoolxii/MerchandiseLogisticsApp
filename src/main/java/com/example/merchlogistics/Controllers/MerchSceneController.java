package com.example.merchlogistics.Controllers;

import com.example.merchlogistics.Entities.Merchandise;
import com.example.merchlogistics.Entities.MerchandiseBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.TreeSet;

public class MerchSceneController extends Controller {
    private final TreeSet<Merchandise> merchandiseTreeSet = new TreeSet<>();
    @FXML
    private VBox myVBox;
    @FXML
    private HBox selectOptionHBox;

    public void remove(ActionEvent event) {

    }

    public void export(ActionEvent event) {

    }

    public void addMerch(Merchandise merchandise) {
        merchandiseTreeSet.add(merchandise);
        update(merchandise);
    }

    private void update(Merchandise merchandise) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXMLs/Items/MerchItem.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            MerchItemController merchItemController = fxmlLoader.getController();
            merchItemController.setup(merchandise);
            myVBox.getChildren().add(parent);
        } catch (Exception ignore) {

        }
    }

    public void showOptions() {
        selectOptionHBox.setVisible(true);
    }

    public void hideOptions() {
        selectOptionHBox.setVisible(false);
    }

    public void switchToAddMerchScene(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXMLs/NewMerchItemScene.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
            ((NewMerchItemController) fxmlLoader.getController()).setStage(stage);
        } catch (Exception ignore) {

        }
    }
}