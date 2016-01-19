package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Tobias on 19-01-2016.
 */
public class Ball2 {
    Texture ballTexture = new Texture("ballBlack_08.png");
//    float LOGO_SIZE = 0.5f * Constants.GAME_WORLD_SIZE;
    float LOGO_SIZE = 8 * 3;

    Constants.Difficulty difficulty;
    ExtendViewport viewport;

    Rectangle ball;

    Vector2 position;
    Vector2 velocity;

    public Ball2(ExtendViewport viewport, Constants.Difficulty difficulty) {
        this.viewport = viewport;
        this.difficulty = difficulty;
        position = new Vector2();
        velocity = new Vector2();
        init();
    }

    public void init() {
        position.set(Constants.GAME_WORLD_SIZE / 2, Constants.GAME_WORLD_SIZE / 2);
        velocity.x = 300.0f;
        velocity.y = 300.0f;

        ball = new Rectangle(position.x, position.y, LOGO_SIZE, LOGO_SIZE);
    }

    private void detectWallCollision(float radius, float viewportWidth, float viewportHeight) {
//        System.out.println("radius = " + radius + " viewportWidth = " + viewportWidth + " viewportHeight = " + viewportHeight);
        if (ball.x < 0) velocity.x = -velocity.x;
        if (ball.x + LOGO_SIZE > viewportWidth) velocity.x = -velocity.x;
        if (ball.y < 0) velocity.y = -velocity.y;
        if (ball.y + LOGO_SIZE > viewportHeight) velocity.y = -velocity.y;
    }

    public void update(float delta) {
        position.mulAdd(velocity, delta);
        ball.setPosition(position.x, position.y);
//        System.out.println("ball.position.x = " + position.x + " position.y = " + position.y + " getX = " + ball.x + " getY = " + ball.y);
        detectWallCollision(
                LOGO_SIZE / 2,
                viewport.getScreenWidth(),
                viewport.getScreenHeight()
        );
    }

    public void render(SpriteBatch batch) {
        batch.draw(
                ballTexture,
                position.x,
                position.y,
                LOGO_SIZE,
                LOGO_SIZE
        );
    }

}
