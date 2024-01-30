package com.example.merchlogistics;

import com.example.merchlogistics.Controllers.Controller;
import com.example.merchlogistics.Enums.SceneEnum;
import com.example.merchlogistics.Workers.*;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class LogisticsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneGettable sceneGettable = SceneManager.getInstance();
        ControllerGettable controllerGettable = (ControllerGettable) sceneGettable;
        SceneSwitchable sceneSwitchable = new SceneSwitcher(stage, sceneGettable);

        for (Object controller : controllerGettable.getAllControllers()) {
            ((Controller) controller).setSceneSwitchable(sceneSwitchable);
        }

        sceneSwitchable.switchScene(SceneEnum.MAIN_SCENE);

        stage.setWidth(800); stage.setHeight(800);
    }

    public static void main(String[] args) {
        launch();
    }
}