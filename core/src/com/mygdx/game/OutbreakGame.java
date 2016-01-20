package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.screens.GameplayScreen;

public class OutbreakGame extends Game {
    public static final String TAG = OutbreakGame.class.getName();

    @Override
    public void create() {
        setScreen(new GameplayScreen());
    }
}