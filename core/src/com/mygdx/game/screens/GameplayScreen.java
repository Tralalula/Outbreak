package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.objects.Bricks;
import com.mygdx.game.objects.Player;
import com.mygdx.game.objects.Ball;
import com.mygdx.game.objects.Brick;
import com.mygdx.game.utils.CollisionDetector;
import com.mygdx.game.utils.Constants;

/**
 * Created by Tobias on 20-01-2016.
 */
public class GameplayScreen implements Screen {
    public static final String TAG = GameplayScreen.class.getName();

    private ExtendViewport gameplayViewport;
    private SpriteBatch batch;

    private CollisionDetector collisionDetector;

    private Player player;
    private Ball ball;
    private Bricks bricks;

    @Override
    public void show() {
        gameplayViewport = new ExtendViewport(
                Constants.GAME_WORLD_SIZE,
                Constants.GAME_WORLD_SIZE
        );
        batch = new SpriteBatch();

        collisionDetector = new CollisionDetector();

        player = new Player(gameplayViewport);
        ball = new Ball(gameplayViewport);
        bricks = new Bricks(gameplayViewport);
    }

    @Override
    public void render(float delta) {
        player.update(delta);
        ball.update(delta);

        collisionManager();

        gameplayViewport.apply();
        Gdx.gl.glClearColor(
                Constants.GAME_BACKGROUND_COLOR.r,
                Constants.GAME_BACKGROUND_COLOR.g,
                Constants.GAME_BACKGROUND_COLOR.b,
                1
        );
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(gameplayViewport.getCamera().combined);
        batch.begin();

        player.render(batch);
        ball.render(batch);
        bricks.render(batch);

        batch.end();
    }

    private void collisionManager() {
        int brickIndex = collisionDetector.checkBrickCollision(ball.getBounds(), bricks);
        if (brickIndex != -1) {
            bricks.getBricks().removeIndex(brickIndex);
            ball.reverseYVelocity();
        }

        String paddleSide = collisionDetector.checkRectangleCollision(
                ball.getBounds(),
                player.getBounds()
        );
        if (paddleSide != Constants.COLLISION_DETECTOR_NONE) {
            if (paddleSide == Constants.COLLISION_DETECTOR_LEFT) {
                ball.setX(player.getBounds().getX() - ball.getSize());
                ball.reverseVelocity();
            } else if (paddleSide == Constants.COLLISION_DETECTOR_RIGHT) {
                ball.setX(player.getBounds().getX() + player.getPaddle().getWidth() + ball.getSize());
                ball.reverseVelocity();
            } else if (paddleSide == Constants.COLLISION_DETECTOR_BOTTOM) {
                ball.setY(player.getBounds().getY() - ball.getSize());
                ball.reverseYVelocity();
            } else {
                ball.setY(player.getBounds().getY() + ball.getSize());
                ball.reverseYVelocity();
            }
        }

        String ballWallCollision = collisionDetector.checkWallCollision(
                gameplayViewport,
                ball.getBounds()
        );
        if (ballWallCollision == Constants.COLLISION_DETECTOR_LEFT) {
            ball.setX(0);
            ball.reverseXVelocity();
        }

        if (ballWallCollision == Constants.COLLISION_DETECTOR_RIGHT) {
            ball.setX(gameplayViewport.getWorldWidth() - ball.getSize());
            ball.reverseXVelocity();
        }

        if (ballWallCollision == Constants.COLLISION_DETECTOR_BOTTOM) {
            ball.setY(0);
            ball.reverseYVelocity();
        }

        if (ballWallCollision == Constants.COLLISION_DETECTOR_TOP) {
            ball.setY(gameplayViewport.getWorldHeight() - ball.getSize());
            ball.reverseYVelocity();
        }

        String playerWallCollision = collisionDetector.checkWallCollision(
                gameplayViewport,
                player.getBounds()
        );
        if (playerWallCollision == Constants.COLLISION_DETECTOR_LEFT) {
            player.setX(0);
        }

        if (playerWallCollision == Constants.COLLISION_DETECTOR_RIGHT) {
            player.setX(gameplayViewport.getWorldWidth() - player.getPaddle().getWidth());
        }
    }

    @Override
    public void resize(int width, int height) {
        gameplayViewport.update(width, height, true);
        player.init();
        ball.init();
        bricks.init();
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
        ball.getBall().getTexture().dispose();
        for (Brick brick : bricks.getBricks()) {
            brick.getTexture().dispose();
        }
    }
}
