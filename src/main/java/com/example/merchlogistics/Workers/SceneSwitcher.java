package com.example.merchlogistics.Workers;

import com.example.merchlogistics.Enums.SceneEnum;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneSwitcher implements SceneSwitchable {
    private final Stage stage;
    private final SceneGettable sceneGettable;
    public SceneSwitcher(Stage stage, SceneGettable sceneGettable) {
        this.sceneGettable = sceneGettable;
        this.stage = stage;
    }

    @Override
    public void switchScene(SceneEnum sceneEnum) {
        stage.setScene(sceneGettable.getScene(sceneEnum));
        stage.show();
    }
}
