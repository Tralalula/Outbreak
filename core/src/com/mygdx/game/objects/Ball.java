package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.objects.balls.StandardBall;
import com.mygdx.game.utils.CollisionDetector;
import com.mygdx.game.utils.Constants;

/**
 * Created by Tobias on 20-01-2016.
 */
public class Ball {
    public static final String TAG = Ball.class.getName();

    private Viewport viewport;
    private Vector2 position;
    private Vector2 velocity;
    private StandardBall ball;
    private Rectangle fakeBall;

    public Ball(Viewport viewport) {
        this.viewport = viewport;
        position = new Vector2();
        velocity = new Vector2(200, 200);
        Texture ballTexture = new Texture(Constants.BALL_TEXTURE);
        ball = new StandardBall(ballTexture, Constants.BALL_SIZE);
        fakeBall = new Rectangle(position.x, position.y, ball.getSize(), ball.getSize());
    }

    public void init() {
        position.x = (viewport.getWorldWidth() - ball.getSize()) / 2;
        position.y = (viewport.getWorldHeight() - ball.getSize()) / 2;
    }

    public void update(float delta) {
        position.mulAdd(velocity, delta);

        fakeBall.setPosition(position);
    }

    public void render(SpriteBatch batch) {
        batch.draw(
                ball.getTexture(),
                position.x,
                position.y,
                ball.getSize(),
                ball.getSize()
        );
    }

    public StandardBall getBall() {
        return ball;
    }

    public Rectangle getBounds() {
        return fakeBall;
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

    public Vector2 getVelocity() {
        return velocity;
    }

    public float getXVelocity() {
        return velocity.x;
    }

    public float getYVelocity() {
        return velocity.y;
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

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public void setVelocity(float x, float y) {
        setVelocity(new Vector2(x, y));
    }

    public void setXVelocity(float x) {
        velocity.x = x;
    }

    public void setYVelocity(float y) {
        velocity.y = y;
    }

    public void reverseVelocity() {
        setVelocity(-velocity.x, -velocity.y);
    }

    public void reverseXVelocity() {
        velocity.x = -velocity.x;
    }

    public void reverseYVelocity() {
        velocity.y = -velocity.y;
    }

    public float getSize() {
        return ball.getSize();
    }
}
