package com.mygdx.game;

import com.badlogic.gdx.Game;

public class OutbreakGame extends Game {
	@Override
	public void create() {
		setScreen(new OutbreakScreen());
	}
}