package com.mygdx.game;

import com.badlogic.gdx.Game;

public class OutbreakGame extends Game {
    public static final String TAG = OutbreakGame.class.getName();

    @Override
    public void create() {
        showMenuScreen();
    }

    public void showDifficultyScreen() {
        setScreen(new DifficultyScreen(this));
    }

    public void showMenuScreen() {
        setScreen(new MenuScreen(this));
    }

    public void showOutbreakScreen(Constants.Difficulty difficulty) {
        setScreen(new OutbreakScreen(this, difficulty));
    }
}