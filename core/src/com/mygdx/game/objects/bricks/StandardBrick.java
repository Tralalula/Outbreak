package com.mygdx.game.objects.bricks;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Tobias on 20-01-2016.
 */
public class StandardBrick {
    public static final String TAG = StandardBrick.class.getName();

    private Texture brickTexture;
    private int brickWidth;
    private int brickHeight;

    public StandardBrick(Texture texture, int width, int height) {
        brickTexture = texture;
        brickWidth = width;
        brickHeight = height;
    }

    public int getWidth() {
        return brickWidth;
    }

    public int getHeight() {
        return brickHeight;
    }

    public Texture getTexture() {
        return brickTexture;
    }
}
