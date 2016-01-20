package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/**
 * Created by Tobias on 1/20/2016.
 */
public class GameplayScreen implements Screen {
    public static final String TAG = GameplayScreen.class.getName();

    private ExtendViewport gameplayViewport;
    private SpriteBatch batch;

    @Override
    public void show() {
        gameplayViewport = new ExtendViewport(160, 160);
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        gameplayViewport.apply();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(gameplayViewport.getCamera().combined);
        batch.begin();
        batch.draw(
                new Texture("paddle_02.png"),
                gameplayViewport.getWorldWidth() / 2,
                gameplayViewport.getWorldHeight() / 2,
                100,
                20
        );
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        gameplayViewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
