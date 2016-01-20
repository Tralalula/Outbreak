package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.objects.Player;
import com.mygdx.game.objects.Ball;
import com.mygdx.game.utils.Constants;

/**
 * Created by Tobias on 20-01-2016.
 */
public class GameplayScreen implements Screen {
    public static final String TAG = GameplayScreen.class.getName();

    private ExtendViewport gameplayViewport;
    private SpriteBatch batch;

    private Player player;
    private Ball ball;

    @Override
    public void show() {
        gameplayViewport = new ExtendViewport(
                Constants.GAME_WORLD_SIZE,
                Constants.GAME_WORLD_SIZE
        );

        batch = new SpriteBatch();

        player = new Player(gameplayViewport);
        ball = new Ball(gameplayViewport);
    }

    @Override
    public void render(float delta) {
        player.update(delta);
        ball.update(delta, player);

        gameplayViewport.apply();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(gameplayViewport.getCamera().combined);
        batch.begin();

        player.render(batch);
        ball.render(batch);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        gameplayViewport.update(width, height, true);
        player.init();
        ball.init();
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
