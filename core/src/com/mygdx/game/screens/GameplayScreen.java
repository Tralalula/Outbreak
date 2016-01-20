package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.objects.Player;
import com.mygdx.game.objects.paddles.Paddle;
import com.mygdx.game.utils.Constants;

/**
 * Created by Tobias on 20-01-2016.
 */
public class GameplayScreen implements Screen {
    public static final String TAG = GameplayScreen.class.getName();

    private ExtendViewport gameplayViewport;
    private SpriteBatch batch;
    private Player player;

    @Override
    public void show() {
        gameplayViewport = new ExtendViewport(
                Constants.GAME_WORLD_SIZE,
                Constants.GAME_WORLD_SIZE
        );

        batch = new SpriteBatch();
        player = new Player(gameplayViewport);
    }

    @Override
    public void render(float delta) {
        player.update(delta);

        gameplayViewport.apply();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(gameplayViewport.getCamera().combined);
        batch.begin();

        player.render(batch);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        gameplayViewport.update(width, height, true);
        player.init();
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
        batch.dispose();
        player.getPaddle().getTexture().dispose();
    }
}
