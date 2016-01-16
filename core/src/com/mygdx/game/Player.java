package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Tobias on 1/12/2016.
 */
public class Player {
    public static final String TAG = Player.class.getName();

    Vector2 position;
    Viewport viewport;

    public Player(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init() {
        position = new Vector2(viewport.getWorldWidth() / 2, Constants.PADDLE_STARTING_POSITION_Y);
    }

    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            position.x -= delta * Constants.PADDLE_MOVEMENT_SPEED;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.x += delta * Constants.PADDLE_MOVEMENT_SPEED;
        }

        float accelerometerInput = -Gdx.input.getAccelerometerY()
                / (Constants.ACCELEROMETER_GRAVITATIONAL_ACCELERATION * Constants.ACCELEROMETER_SENSITIVITY);
        position.x += -delta * accelerometerInput * Constants.PADDLE_MOVEMENT_SPEED;

        ensureInBounds();
    }

    private void ensureInBounds() {
        if (position.x < 0) {
            position.x = 0f;
        }

        if (position.x + Constants.PADDLE_WIDTH > viewport.getWorldWidth()) {
            position.x = viewport.getWorldWidth() - Constants.PADDLE_WIDTH;
        }
    }

    public boolean hitByBall(Ball ball) {
        boolean isHit = false;

        if (ball.position.x >= this.position.x &&
            ball.position.x <= this.position.x + Constants.PADDLE_WIDTH &&
            ball.position.y <= this.position.y + Constants.PADDLE_HEIGHT + Constants.BALL_RADIUS &&
            ball.position.y >= this.position.y - Constants.PADDLE_HEIGHT) {
            isHit = true;
        }

        return isHit;
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.PADDLE_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.rect(position.x, position.y, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
    }
}