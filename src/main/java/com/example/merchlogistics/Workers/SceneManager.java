package com.example.merchlogistics.Workers;

import com.example.merchlogistics.ExceptionLoggers.IOExceptionLogger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import com.example.merchlogistics.ExceptionLoggers.Loggable;
import com.example.merchlogistics.Enums.SceneEnum;
import javafx.scene.Scene;

/* this class represents a scene loader
 * its responsibility is to load scenes and
 * provide it to client whenever they need
 */
public class SceneManager implements SceneGettable, ControllerGettable {
    private static SceneManager sceneManager;
    private final HashMap<SceneEnum, Scene> enumSceneHashMap = new HashMap<>();
    private final HashMap<SceneEnum, Object> enumControllerHashMap = new HashMap<>();
    private final Loggable loggable = new IOExceptionLogger();

    public static SceneManager getInstance() {
        if (sceneManager == null) {
            sceneManager = new SceneManager();
        }
        return sceneManager;
    }

    /* this constructor loads every possible scene from path
     *  for later use
     */
    private SceneManager() {
        load(SceneEnum.MAIN_SCENE, "/FXMLs/MainSceneFXML.fxml");
        load(SceneEnum.MERCH_SCENE, "/FXMLs/MerchScene.fxml");
        load(SceneEnum.HISTORY_SCENE, "/FXMLs/HistoryScene.fxml");
    }

    /* get a single scene from the loaded list, scene enum required */
    @Override
    public Scene getScene (SceneEnum sceneEnum) {
        return enumSceneHashMap.get(sceneEnum);
    }

    @Override
    public Collection<Scene> getAllScene () {
        return enumSceneHashMap.values();
    }

    private void load(SceneEnum sceneEnum, String path) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        try {
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            enumSceneHashMap.put(sceneEnum, scene);
            enumControllerHashMap.put(sceneEnum, fxmlLoader.getController());
        } catch (IOException ioException) {
            loggable.showExceptionLog();
        }
    }

    @Override
    public Object getController(SceneEnum sceneEnum) {
        return enumControllerHashMap.get(sceneEnum);
    }

    @Override
    public Collection<Object> getAllControllers() {
        return enumControllerHashMap.values();
    }
}
