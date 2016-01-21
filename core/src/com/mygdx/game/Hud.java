package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.utils.Constants;

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
        float x = Constants.HUD_MARGIN;
        float y = viewport.getWorldHeight() - Constants.BALL_SIZE - Constants.HUD_MARGIN;

        batch.draw(
                new Texture("coin_06.png"),
                x,
                y,
                20,
                20
        );
        font.setColor(Color.BLACK);
        font.draw(
                batch,
                "1337",
                x + 25,
                y + 16
        );

        x = viewport.getWorldWidth() - 20 - 3 * 20;
        y = viewport.getWorldHeight() - Constants.BALL_SIZE - Constants.HUD_MARGIN;

        for (int i = 0; i < 3; i++) {
//            batch.setColor(0.5f, 0.5f, 0.5f, 0.5f);
            batch.draw(
                    new Texture("ballBlack_08.png"),
                    x + i * (20 + 5),
                    y,
                    20,
                    20
            );
            batch.setColor(1, 1, 1, 1);
        }
    }
}
