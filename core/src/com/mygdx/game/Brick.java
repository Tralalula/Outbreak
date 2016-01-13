package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Tobias on 1/12/2016.
 */
public class Brick {
    public static final String TAG = Brick.class.getName();

    Vector2 position;

    public Brick(Vector2 position) {
        this.position = position;
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.BRICK_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.rect(position.x, position.y, Constants.BRICK_WIDTH, Constants.BRICK_HEIGHT);
    }
}