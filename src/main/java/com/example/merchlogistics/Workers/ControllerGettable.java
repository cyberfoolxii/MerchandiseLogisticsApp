package com.example.merchlogistics.Workers;

import com.example.merchlogistics.Enums.SceneEnum;

import java.util.Collection;

public interface ControllerGettable {
    Object getController(SceneEnum sceneEnum);
    Collection<Object> getAllControllers();
}
