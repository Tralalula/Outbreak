package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Tobias on 1/12/2016.
 */
public class Ball {
    public static final String TAG = Ball.class.getName();

    Vector2 position;
    Vector2 velocity;
    Viewport viewport;

    public Ball(Viewport viewport) {
        this.viewport = viewport;
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
        }

        if (position.y + radius > viewportHeight) {
            position.y = viewportHeight - radius;
            velocity.y = -velocity.y;
        }
    }

    public boolean detectBrickCollision(Bricks bricks) {
        for (Brick brick : bricks.brickArray) {
            if (this.position.x >= brick.position.x &&
                this.position.x <= brick.position.x + Constants.BRICK_WIDTH &&
                this.position.y <= brick.position.y + Constants.BRICK_HEIGHT + Constants.BALL_RADIUS &&
                this.position.y >= brick.position.y - Constants.BRICK_HEIGHT) {
                brick.position.y = -Constants.BRICK_HEIGHT;
                return true;
            }
        }

        return false;
    }

    public void init() {
        position = new Vector2(Constants.WORLD_SIZE / 2, Constants.WORLD_SIZE / 2);
        velocity = new Vector2(5.0f, 5.0f);
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.BALL_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.circle(position.x, position.y, Constants.BALL_RADIUS, Constants.BALL_SEGMENTS);
    }
}