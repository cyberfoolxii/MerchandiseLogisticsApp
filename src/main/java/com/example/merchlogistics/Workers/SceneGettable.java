package com.example.merchlogistics.Workers;

import com.example.merchlogistics.Enums.SceneEnum;
import javafx.scene.Scene;

import java.util.Collection;

public interface SceneGettable {
    Scene getScene(SceneEnum sceneEnum);
    Collection<Scene> getAllScene();
}
