package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by Tobias on 20-01-2016.
 */
public class Hud {
    public static final String TAG = Hud.class.getName();

    BitmapFont font;
    private Viewport viewport;

    public Hud(Viewport viewport) {
        this.viewport = viewport;
        font = new BitmapFont();
        font.getData().setScale(1);
    }

    public void render(SpriteBatch batch) {
        font.setColor(Color.BLACK);
        font.draw(
                batch,
                "Test :-)",
                viewport.getWorldWidth() / 2,
                viewport.getWorldHeight() / 2
        );
    }
}
