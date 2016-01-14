package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/**
 * Created by Tobias on 1/12/2016.
 */
public class OutbreakScreen implements Screen {
    public static final String TAG = OutbreakScreen.class.getName();

    SpriteBatch batch;
    ExtendViewport outbreakViewport;
    ShapeRenderer renderer;
    Player player;
    Ball ball;
    Bricks bricks;

    @Override
    public void show() {
        outbreakViewport = new ExtendViewport(Constants.WORLD_SIZE, Constants.WORLD_SIZE);
        renderer = new ShapeRenderer();
        batch = new SpriteBatch();
        renderer.setAutoShapeType(true);
        player = new Player(outbreakViewport);
        ball = new Ball(outbreakViewport);
        bricks = new Bricks(outbreakViewport);
    }

    @Override
    public void render(float delta) {
        player.update(delta);
        ball.update(delta);

        if (player.hitByBall(ball)) {
            System.out.println("Paddle - ball collision");
        }

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

        bricks.render(renderer);
        ball.render(renderer);
        player.render(renderer);

        renderer.end();
    }

    @Override
    public void resize(int width, int height) {
        outbreakViewport.update(width, height, true);
        bricks.init();
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
        renderer.dispose();
    }
}