package com.mygdx.game;

import com.badlogic.gdx.Game;

public class OutbreakGame extends Game {
    public static final String TAG = OutbreakGame.class.getName();

    @Override
    public void create() {
        setScreen(new OutbreakScreen(Constants.Difficulty.EASY));
    }
}