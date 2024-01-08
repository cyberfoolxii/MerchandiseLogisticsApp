package com.example.merchlogistics.Controllers;

import com.example.merchlogistics.Enums.SceneEnum;
import com.example.merchlogistics.Workers.SceneSwitchable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public abstract class Controller {
    @FXML
    protected MenuButton optionsMenuButton;
    @FXML
    protected MenuItem merchMenuItem;
    @FXML
    protected MenuItem historyMenuItem;
    protected SceneSwitchable sceneSwitchable;

    public void setSceneSwitchable(SceneSwitchable sceneSwitchable) {
        this.sceneSwitchable = sceneSwitchable;
    }

    public void switchToMerchScene(ActionEvent event) {
        System.out.println("switched to merch");
        sceneSwitchable.switchScene(SceneEnum.MERCH_SCENE);
    }

    public void switchToHistoryScene(ActionEvent event) {
        System.out.println("switched to history");
        sceneSwitchable.switchScene(SceneEnum.HISTORY_SCENE);
    }
}
