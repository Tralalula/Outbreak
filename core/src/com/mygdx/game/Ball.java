package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Tobias on 1/12/2016.
 */
public class Ball {
    public static final String TAG = Ball.class.getName();
    Constants.Difficulty difficulty;
    Vector2 position;
    Vector2 velocity;
    Viewport viewport;
    int numOfLives;

    public Ball(Viewport viewport, Constants.Difficulty difficulty) {
        this.viewport = viewport;
        this.difficulty = difficulty;
        numOfLives = difficulty.numOfLives;
        init();
    }

    public void update(float delta) {
        velocity.clamp(10f, 400f);

        velocity.x -= delta * velocity.x;
        velocity.y -= delta * velocity.y;

        position.x += delta * velocity.x;
        position.y += delta * velocity.y;

        detectWallCollision(
                Constants.BALL_RADIUS,
                viewport.getWorldWidth(),
                viewport.getWorldHeight()
        );
    }

    private void detectWallCollision(float radius, float viewportWidth, float viewportHeight) {
        if (position.x - radius < 0) {
            position.x = radius;
            velocity.x = -velocity.x;
        }

        if (position.x + radius > viewportWidth) {
            position.x = viewportWidth - radius;
            velocity.x = -velocity.x;
        }

        if (position.y - radius < 0) {
            position.y = radius;
            velocity.y = -velocity.y;
            numOfLives--;
            init();
        }

        if (position.y + radius > viewportHeight) {
            position.y = viewportHeight - radius;
            velocity.y = -velocity.y;
        }
    }

    public boolean detectBrickCollision(Bricks bricks) {
        bricks.brickArray.begin();
        for (int i = 0; i < bricks.brickArray.size; i++) {
            if (this.position.x >= bricks.brickArray.get(i).position.x &&
                    this.position.x <= bricks.brickArray.get(i).position.x + Constants.BRICK_WIDTH &&
                    this.position.y <= bricks.brickArray.get(i).position.y + Constants.BRICK_HEIGHT + Constants.BALL_RADIUS &&
                    this.position.y >= bricks.brickArray.get(i).position.y - Constants.BRICK_HEIGHT) {
                bricks.bricksDestroyed++;
                bricks.brickArray.get(i).position.y = -Constants.BRICK_HEIGHT * 5;
                bricks.brickArray.removeIndex(i);
                return true;
            }
        }
        bricks.brickArray.end();

        return false;
    }

    public void init() {
        position = new Vector2(Constants.GAME_WORLD_SIZE / 2, Constants.GAME_WORLD_SIZE / 2);
        velocity = new Vector2(5.0f, 5.0f);
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.BALL_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.circle(position.x, position.y, Constants.BALL_RADIUS, Constants.BALL_SEGMENTS);
    }
}