package com.example.merchlogistics.Controllers;

import com.example.merchlogistics.Entities.Merchandise;
import com.example.merchlogistics.Entities.MerchandiseComposite;
import com.example.merchlogistics.Workers.URIBrowser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class MerchSceneController extends Controller {
    private final TreeSet<MerchandiseComposite> merchandiseCompositeTreeSet = new TreeSet<>();
    private final List<Stage> stages = new ArrayList<>();
    @FXML
    private VBox myVBox;
    @FXML
    private HBox selectOptionHBox;

    public void remove(ActionEvent event) {

    }

    public void export(ActionEvent event) {

    }

    public void addMerch(MerchandiseComposite merchandiseComposite) {
        merchandiseCompositeTreeSet.add(merchandiseComposite);
        update(merchandiseComposite);
    }

    private void update(MerchandiseComposite merchandiseComposite) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXMLs/Items/MerchItem.fxml"));
        try {
            Parent parent = fxmlLoader.load();
            MerchItemController merchItemController = fxmlLoader.getController();
            merchItemController.setup(merchandiseComposite);
            myVBox.getChildren().add(parent);
        } catch (Exception ignore) {
            System.out.println("MerchSceneController update error");
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