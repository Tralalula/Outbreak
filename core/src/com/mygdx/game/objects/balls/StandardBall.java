package com.mygdx.game.objects.balls;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by Tobias on 20-01-2016.
 */
public class StandardBall {
    public static final String TAG = StandardBall.class.getName();

    private Texture ballTexture;
    private int ballSize;

    public StandardBall(Texture texture, int size) {
        ballTexture = texture;
        ballSize = size;
    }

    public int getSize() {
        return ballSize;
    }

    public Texture getTexture() {
        return ballTexture;
    }
}
