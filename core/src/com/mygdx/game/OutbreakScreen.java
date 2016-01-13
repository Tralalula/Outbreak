package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/**
 * Created by Tobias on 1/12/2016.
 */
public class OutbreakScreen implements Screen {
    public static final String TAG = OutbreakScreen.class.getName();

    ExtendViewport outbreakViewport;
    ShapeRenderer renderer;
    Paddle paddle;
    Brick brick;

    @Override
    public void show() {
        outbreakViewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);
        paddle = new Paddle(outbreakViewport);
        brick = new Brick(new Vector2(Constants.WORLD_SIZE / 2, Constants.WORLD_SIZE / 2));
    }

    @Override
    public void render(float delta) {
        outbreakViewport.apply(true);
        Gdx.gl.glClearColor(
                Constants.BACKGROUND_COLOR.r,
                Constants.BACKGROUND_COLOR.g,
                Constants.BACKGROUND_COLOR.b,
                1
        );
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(outbreakViewport.getCamera().combined);

        renderer.begin(ShapeRenderer.ShapeType.Filled);

        brick.render(renderer);
        paddle.render(renderer);

        renderer.end();
    }

    @Override
    public void resize(int width, int height) {
        outbreakViewport.update(width, height, true);
        paddle.init();
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