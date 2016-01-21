package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.objects.bricks.StandardBrick;
import com.mygdx.game.utils.Constants;

/**
 * Created by Tobias on 20-01-2016.
 */
public class Brick {
    public static final String TAG = Brick.class.getName();

    private Vector2 position;
    private StandardBrick brick;
    private Texture brickTexture;
    private Rectangle fakeBrick;

    public Brick(Vector2 position) {
        this.position = position;
        brickTexture = new Texture(Constants.BRICK_TEXTURE);
        brick = new StandardBrick(brickTexture, Constants.BRICK_WIDTH, Constants.BRICK_HEIGHT);
        fakeBrick = new Rectangle(position.x, position.y, brick.getWidth(), brick.getHeight());
    }

    public void render(SpriteBatch batch) {
        batch.draw(
                brick.getTexture(),
                position.x,
                position.y,
                brick.getWidth(),
                brick.getHeight()
        );
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

    public int getWidth() {
        return brick.getWidth();
    }

    public int getHeight() {
        return brick.getHeight();
    }

    public Rectangle getBounds() {
        return fakeBrick;
    }

    public Texture getTexture() {
        return brickTexture;
    }
}
