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
    Viewport viewport;

    public Ball(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init() {
        position = new Vector2(Constants.WORLD_SIZE / 2, Constants.WORLD_SIZE / 2);
//        System.out.println(" WORLD WIDTH = " + viewport.getWorldWidth() + " WORLD HEIGHT = " + viewport.getWorldHeight());
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.BALL_COLOR);
        renderer.set(ShapeRenderer.ShapeType.Filled);
        renderer.circle(position.x, position.y, Constants.BALL_RADIUS, Constants.BALL_SEGMENTS);
    }
}