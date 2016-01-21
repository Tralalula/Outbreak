package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.utils.Constants;

/**
 * Created by Tobias on 20-01-2016.
 */
public class Bricks {
    public static final String TAG = Brick.class.getName();

    private Viewport viewport;
    private Array<Brick> brickArray;

    public Bricks(Viewport viewport) {
        this.viewport = viewport;
    }

    public void init() {
        brickArray = new DelayedRemovalArray<Brick>();

        int brickMargin = (int) viewport.getWorldWidth() / Constants.BRICK_NUM_COLS;
        brickMargin -= Constants.BRICK_WIDTH;

        Vector2 initialPosition = new Vector2(
                brickMargin,
                viewport.getWorldHeight() - Constants.BRICK_HEIGHT - Constants.BRICK_TOP_MARGIN
        );

//        int numCols = (int) viewport.getWorldWidth() / (Constants.BRICK_WIDTH + Constants.BRICK_MARGIN);

        float yStart = initialPosition.y;
        for (int i = 0; i < Constants.BRICK_NUM_ROWS; i++) {
            float xStart = initialPosition.x;
            for (int j = 0; j < Constants.BRICK_NUM_COLS; j++) {
                Vector2 brickPosition = new Vector2(xStart, yStart);
                brickArray.add(new Brick(brickPosition));
                xStart += Constants.BRICK_WIDTH + brickMargin;
            }
            yStart -= Constants.BRICK_HEIGHT + Constants.BRICK_MARGIN;
        }
    }

    public void render(SpriteBatch batch) {
        for (Brick brick : brickArray) {
            brick.render(batch);
        }
    }

    public Array<Brick> getBricks() {
        return brickArray;
    }
}
