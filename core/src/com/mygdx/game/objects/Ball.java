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
    private Texture ballTexture;
    private StandardBall ball;
    private Rectangle fakeBall;

    public Ball(Viewport viewport) {
        this.viewport = viewport;
        position = new Vector2();
        velocity = new Vector2(200, 200);
        ballTexture = new Texture(Constants.BALL_TEXTURE);
        ball = new StandardBall(ballTexture, Constants.BALL_SIZE);
        fakeBall = new Rectangle(position.x, position.y, ball.getSize(), ball.getSize());
    }

    public void init() {
        position.x = (viewport.getWorldWidth() - ball.getSize()) / 2;
        position.y = (viewport.getWorldHeight() - ball.getSize()) / 2;
    }

    public void update(float delta, Player player) {
        position.mulAdd(velocity, delta);

        fakeBall.setPosition(position);

        ensureInBounds();
        checkPaddleCollision(player);
    }

    private void ensureInBounds() {
        if (position.x < 0) velocity.x = -velocity.x;
        if (position.x + ball.getSize() > viewport.getWorldWidth()) velocity.x = -velocity.x;
        if (position.y < 0) velocity.y = -velocity.y;
        if (position.y + ball.getSize() > viewport.getWorldHeight()) velocity.y = -velocity.y;
    }

    private void checkPaddleCollision(Player player) {
        if (fakeBall.overlaps(player.getBounds())) {
            velocity.y = -velocity.y;
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(
                ballTexture,
                position.x,
                position.y,
                ball.getSize(),
                ball.getSize()
        );
    }

    public StandardBall getBall() {
        return ball;
    }
}
