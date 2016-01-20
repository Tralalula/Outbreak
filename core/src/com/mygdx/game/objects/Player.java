package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.objects.paddles.Paddle;
import com.mygdx.game.utils.Constants;

/**
 * Created by Tobias on 20-01-2016.
 */
public class Player {
    public static final String TAG = Player.class.getName();

    private Viewport viewport;
    private Vector2 position;
    private Texture paddleTexture;
    private Paddle paddle;
    private Rectangle fakePaddle;

    public Player(Viewport viewport) {
        this.viewport = viewport;
        position = new Vector2();
        paddleTexture = new Texture(Constants.PADDLE_TEXTURE);
        paddle = new Paddle(paddleTexture, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
        fakePaddle = new Rectangle(position.x, position.y, paddle.getWidth(), paddle.getHeight());
        init();
    }

    public void init() {
        position.x = (viewport.getWorldWidth() - Constants.PADDLE_WIDTH) / 2;
//        position.y = (viewport.getWorldHeight() - Constants.PADDLE_HEIGHT) / 2;
        position.y = viewport.getWorldHeight() / 12;
    }

    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            position.x -= delta * Constants.PADDLE_MOVEMENT_SPEED;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.x += delta * Constants.PADDLE_MOVEMENT_SPEED;
        }

        fakePaddle.setPosition(position.x, position.y);

        ensureInBounds();
    }

    private void ensureInBounds() {
        if (position.x < 0) {
            position.x = 0;
        }

        if (position.x + paddle.getWidth() > viewport.getWorldWidth()) {
            position.x = viewport.getWorldWidth() - paddle.getWidth();
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(
                paddle.getTexture(),
                position.x,
                position.y,
                paddle.getWidth(),
                paddle.getHeight()
        );
    }

    public Paddle getPaddle() {
        return paddle;
    }
}