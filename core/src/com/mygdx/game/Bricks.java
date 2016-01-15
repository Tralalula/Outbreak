package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Tobias on 1/12/2016.
 */
public class Bricks {
    public static final String TAG = Bricks.class.getName();

    DelayedRemovalArray<Brick> brickArray;
    Viewport viewport;

    public Bricks(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init() {
        brickArray = new DelayedRemovalArray<Brick>();

        int numRows = 5;
        int numCols = 8;

        float xSpace = Constants.BRICK_WIDTH + 0.60416675f;
        float ySpace = Constants.BRICK_HEIGHT + 0.5f;
        System.out.println("WORLD SIZE " + viewport.getWorldWidth());
        float initialXStartPosition = viewport.getWorldWidth() - (viewport.getWorldWidth() - 0.5f);

        float yStartPosition = Constants.WORLD_SIZE / 1.1f;
        for (int i = 0; i < numRows; i++) {
            float xStartPosition = initialXStartPosition;
            for (int j = 0; j < numCols; j++) {
                Vector2 brickPosition = new Vector2(xStartPosition, yStartPosition);
                xStartPosition += xSpace;
                brickArray.add(new Brick(brickPosition));
            }
            yStartPosition -= ySpace;
        }

        brickArray.begin();

        for (int i = 0; i < brickArray.size; i++) {
            if (brickArray.get(i).position.y <= -Constants.BRICK_HEIGHT) {
                brickArray.removeIndex(i);
            }
        }

        brickArray.end();
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.BRICK_COLOR);

        for (Brick brick : brickArray) {
            brick.render(renderer);
        }
    }
}