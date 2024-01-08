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
        SceneGettable sceneGettable = new Getter();
        ControllerGettable controllerGettable = (ControllerGettable) sceneGettable;
        SceneSwitchable sceneSwitchable = new SceneSwitcher(stage, sceneGettable);

        for (Object controller : controllerGettable.getAllControllers()) {
            ((Controller) controller).setSceneSwitchable(sceneSwitchable);
        }

        sceneSwitchable.switchScene(SceneEnum.MAIN_SCENE);

/*        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXMLs/MainSceneFXML.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/
    }

    public static void main(String[] args) {
        launch();
    }
}