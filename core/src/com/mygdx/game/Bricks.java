package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Tobias on 1/12/2016.
 */
public class Bricks {
    public static final String TAG = Bricks.class.getName();

    Constants.Difficulty difficulty;

    int bricksDestroyed;
    int numOfBricksLeft;
    DelayedRemovalArray<Brick> brickArray;
    Viewport viewport;

    public Bricks(Viewport viewport, Constants.Difficulty difficulty) {
        this.difficulty = difficulty;
        this.viewport = viewport;
        init();
    }

    public void init() {
        brickArray = new DelayedRemovalArray<Brick>();

        bricksDestroyed = 0;
        int numRows = 5;
        int numCols = 8;
        numOfBricksLeft = numRows * numCols;

        float xSpace = Constants.BRICK_WIDTH + 0.60416675f;
        float ySpace = Constants.BRICK_HEIGHT + 0.5f;
        float initialXStartPosition = viewport.getWorldWidth() - (viewport.getWorldWidth() - 0.5f);

        float yStartPosition = Constants.GAME_WORLD_SIZE / 1.1f;
        for (int i = 0; i < numRows; i++) {
            float xStartPosition = initialXStartPosition;
            for (int j = 0; j < numCols; j++) {
                Vector2 brickPosition = new Vector2(xStartPosition, yStartPosition);
                xStartPosition += xSpace;
                brickArray.add(new Brick(brickPosition));
            }
            yStartPosition -= ySpace;
        }
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Constants.BRICK_COLOR);

        for (Brick brick : brickArray) {
            brick.render(renderer);
        }
    }
}