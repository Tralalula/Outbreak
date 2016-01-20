//package com.mygdx.game.Trash;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.math.Intersector;
//import com.badlogic.gdx.math.Rectangle;
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.utils.viewport.ExtendViewport;
//
///**
// * Created by Tobias on 19-01-2016.
// */
//public class Paddle {
//    Texture paddleTexture = new Texture("paddle_02.png");
//    float paddleWidth = 40 * 3;
//    float paddleHeight = 5 * 3;
//
//    ExtendViewport viewport;
//
//    Rectangle paddle;
//
//    Vector2 position;
//
//    public Paddle(ExtendViewport viewport) {
//        this.viewport = viewport;
//        position = new Vector2();
//        init();
//    }
//
//    public void init() {
//        position.set(viewport.getScreenWidth() / 2, 50f);
//
//        paddle = new Rectangle(position.x, position.y, paddleWidth, paddleHeight);
//    }
//
//    public void update(float delta) {
//        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
//            position.x -= delta * Constants.PADDLE_MOVEMENT_SPEED;
//        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
//            position.x += delta * Constants.PADDLE_MOVEMENT_SPEED;
//        }
//
//        float accelerometerInput = -Gdx.input.getAccelerometerY()
//                / (Constants.ACCELEROMETER_GRAVITATIONAL_ACCELERATION * Constants.ACCELEROMETER_SENSITIVITY);
//        position.x += -delta * accelerometerInput * Constants.PADDLE_MOVEMENT_SPEED;
//        ensureInBounds();
//    }
//
//    public boolean hitByBall(com.mygdx.game.Trash.Ball2 ball2) {
//        boolean isHit = false;
//        paddle.setPosition(position.x, position.y);
//
//        if (Intersector.intersectRectangles(ball2.ball, paddle, new Rectangle())) {
//            isHit = true;
//        }
//        return isHit;
//    }
//
//    private void ensureInBounds() {
//        if (position.x < 0) {
//            position.x = 0f;
//        }
//
//        if (position.x + paddleWidth > viewport.getScreenWidth()) {
//            position.x = viewport.getScreenWidth() - paddleWidth;
//        }
//    }
//
//    public void render(SpriteBatch batch) {
//        batch.draw(
//                paddleTexture,
//                position.x,
//                position.y,
//                paddleWidth,
//                paddleHeight
//        );
//    }
//
//}
