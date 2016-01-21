package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
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
    private Paddle paddle;
    private Rectangle fakePaddle;

    public Player(Viewport viewport) {
        this.viewport = viewport;
        position = new Vector2();
        Texture paddleTexture = new Texture(Constants.PADDLE_TEXTURE);
        paddle = new Paddle(paddleTexture, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
        fakePaddle = new Rectangle(position.x, position.y, paddle.getWidth(), paddle.getHeight());
    }

    public void init() {
        position.x = (viewport.getWorldWidth() - paddle.getWidth()) / 2;
//        position.y = (viewport.getWorldHeight() - Constants.PADDLE_HEIGHT) / 2;
        position.y = viewport.getWorldHeight() / 12;
    }

    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            position.x -= delta * Constants.PADDLE_MOVEMENT_SPEED;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.x += delta * Constants.PADDLE_MOVEMENT_SPEED;
        }

        fakePaddle.setPosition(position);
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

    public Rectangle getBounds() {
        return fakePaddle;
    }

    public Vector2 getPosition() {
        return position;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setPosition(float x, float y) {
        setPosition(new Vector2(x, y));
    }

    public void setX(float x) {
        position.x = x;
    }

    public void setY(float y) {
        position.y = y;
    }
}