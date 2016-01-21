package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.objects.balls.StandardBall;
import com.mygdx.game.utils.Constants;

import java.util.Collection;

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

    public void update(float delta, Player player, Bricks bricks) {
        position.mulAdd(velocity, delta);

        fakeBall.setPosition(position);

        ensureInBounds();
        checkPaddleCollision(player);
        checkBrickCollision(bricks);
    }

    private void ensureInBounds() {
        if (position.x < 0) velocity.x = -velocity.x;
        if (position.x + ball.getSize() > viewport.getWorldWidth()) velocity.x = -velocity.x;
        if (position.y < 0) velocity.y = -velocity.y;
        if (position.y + ball.getSize() > viewport.getWorldHeight()) velocity.y = -velocity.y;
    }

    private void checkPaddleCollision(Player player) {
        if (fakeBall.overlaps(player.getBounds())) {
            if (position.x <= player.getBounds().getX()) {
                position.set(player.getBounds().getX() - ball.getSize(), position.y);
                velocity.y = -velocity.y;
                velocity.x = -velocity.x;
            } else if (position.x >= player.getBounds().getX() + player.getPaddle().getWidth()) {
                position.set(
                        player.getBounds().getX() + player.getPaddle().getWidth() + ball.getSize(),
                        position.y
                );
                velocity.y = -velocity.y;
                velocity.x = -velocity.x;
            } else if (position.y <= player.getBounds().getY()) {
                position.set(position.x, player.getBounds().getY() - ball.getSize());
                velocity.y = -velocity.y;
            } else {
                position.set(position.x, player.getBounds().getY() + ball.getSize());
                velocity.y = -velocity.y;
            }
        }
    }

    private void checkBrickCollision(Bricks bricks) {
        for (int i = 0; i < bricks.getBricks().size; i++) {
            if (fakeBall.overlaps(bricks.getBricks().get(i).getBounds())) {
                velocity.y = -velocity.y;
                bricks.getBricks().removeIndex(i);
            }
        }
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
}
