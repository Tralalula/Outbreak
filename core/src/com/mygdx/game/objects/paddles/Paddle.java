package com.mygdx.game.objects.paddles;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Tobias on 20-01-2016.
 */
public class Paddle {
    public static final String TAG = Paddle.class.getName();

    private Texture paddleTexture;
    private int paddleWidth;
    private int paddleHeight;

    public Paddle(Texture texture, int width, int height) {
        paddleTexture = texture;
        paddleWidth = width;
        paddleHeight = height;
    }

    public int getWidth() {
        return paddleWidth;
    }

    public int getHeight() {
        return paddleHeight;
    }

    public Texture getTexture() {
        return paddleTexture;
    }
}
