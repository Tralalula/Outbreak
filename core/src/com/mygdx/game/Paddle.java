package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by tobi0958 on 1/12/2016.
 */
public class Paddle {
    public static final String TAG = Paddle.class.getName();

    Vector2 position;
    Viewport viewport;

    public Paddle(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init() {
        position = new Vector2(viewport.getWorldWidth() / 2, Constants.PADDLE_STARTING_POSITION_Y);
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.PADDLE_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.rect(position.x, position.y, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
    }
}