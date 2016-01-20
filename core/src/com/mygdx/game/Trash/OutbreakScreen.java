//package com.mygdx.game.Trash;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.InputAdapter;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//import com.badlogic.gdx.math.Circle;
//import com.badlogic.gdx.math.Rectangle;
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.utils.Align;
//import com.badlogic.gdx.utils.viewport.ExtendViewport;
//import com.badlogic.gdx.utils.viewport.ScreenViewport;
//import com.mygdx.game.*;
//
///**
// * Created by Tobias on 1/12/2016.
// */
//public class OutbreakScreen extends InputAdapter implements Screen {
//    public static final String TAG = OutbreakScreen.class.getName();
//
//    OutbreakGame game;
//    com.mygdx.game.Trash.Constants.Difficulty difficulty;
//
//    ExtendViewport outbreakViewport;
//    ShapeRenderer renderer;
//
//    ScreenViewport hudViewport;
//    SpriteBatch batch;
//    BitmapFont font;
//
//    Player player;
//    Ball ball;
//    com.mygdx.game.Bricks bricks;
//
//    com.mygdx.game.Ball2 ball2;
//    Paddle paddle;
////    Brick brick;
//
//    int score;
//
//    public OutbreakScreen(OutbreakGame game, com.mygdx.game.Trash.Constants.Difficulty difficulty) {
//        this.game = game;
//        this.difficulty = difficulty;
//    }
//
//    @Override
//    public void show() {
//        outbreakViewport = new ExtendViewport(com.mygdx.game.Trash.Constants.GAME_WORLD_SIZE, com.mygdx.game.Trash.Constants.GAME_WORLD_SIZE);
////        System.out.println("outbreakViewport.getWorldWidth() = " + outbreakViewport.getWorldWidth());
//
//        renderer = new ShapeRenderer();
//        renderer.setAutoShapeType(true);
//
//        hudViewport = new ScreenViewport();
//        batch = new SpriteBatch();
//
//        font = new BitmapFont();
//        font.getRegion().getTexture().setFilter(
//                Texture.TextureFilter.Linear,
//                Texture.TextureFilter.Linear
//        );
//
//        player = new Player(outbreakViewport);
//        ball = new Ball(outbreakViewport, difficulty);
//        bricks = new com.mygdx.game.Trash.Bricks(outbreakViewport, difficulty);
//
//        ball2 = new com.mygdx.game.Trash.Ball2(outbreakViewport, difficulty);
//        paddle = new Paddle(outbreakViewport);
////        brick = new Brick(new Vector2(outbreakViewport.getScreenWidth() / 2, outbreakViewport.getScreenHeight() / 2));
//
//        Gdx.input.setInputProcessor(this);
//
//        score = 0;
//    }
//
//    @Override
//    public void render(float delta) {
////        player.update(delta);
////        ball.update(delta);
//        ball2.update(delta);
//        paddle.update(delta);
//
////        if (player.hitByBall(ball)) {
////            ball.velocity.y = -ball.velocity.y;
////        }
////
////        if (ball.detectBrickCollision(bricks)) {
////            ball.velocity.y = -ball.velocity.y;
////        }
//
//        if (paddle.hitByBall(ball2)) {
//            ball2.velocity.y = -ball2.velocity.y;
//        }
////        if (intersects(ball2.ball, paddle.paddle)) {
////            System.out.println("\n --- INTERSECTION!!! --- \n");
////            ball2.velocity.y = -ball2.velocity.y;
////        }
//
//        outbreakViewport.apply(true);
//        Gdx.gl.glClearColor(
//                com.mygdx.game.Trash.Constants.GAME_BACKGROUND_COLOR.r,
//                com.mygdx.game.Trash.Constants.GAME_BACKGROUND_COLOR.g,
//                com.mygdx.game.Trash.Constants.GAME_BACKGROUND_COLOR.b,
//                1
//        );
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        renderer.setProjectionMatrix(outbreakViewport.getCamera().combined);
//        renderer.begin(ShapeRenderer.ShapeType.Filled);
//
////        ball.render(renderer);
////        player.render(renderer);
//
//        renderer.end();
//
//        score = bricks.bricksDestroyed;
//        hudViewport.apply();
//        batch.setProjectionMatrix(hudViewport.getCamera().combined);
//        batch.begin();
//        font.draw(batch, "Number of lives: " + ball.numOfLives + "\nDifficulty: " + difficulty.label,
//                com.mygdx.game.Trash.Constants.HUD_MARGIN, hudViewport.getWorldHeight() - com.mygdx.game.Trash.Constants.HUD_MARGIN);
//        font.draw(batch, "Score: " + bricks.bricksDestroyed + "\nBricks left: " + bricks.numOfBricksLeft,
//                hudViewport.getWorldWidth() - com.mygdx.game.Trash.Constants.HUD_MARGIN,
//                hudViewport.getWorldHeight() - com.mygdx.game.Trash.Constants.HUD_MARGIN,
//                0, Align.right, false);
//        bricks.render(batch);
//        ball2.render(batch);
//        paddle.render(batch);
//        batch.end();
//
//        if (bricks.numOfBricksLeft <= 0) {
//            game.showVictoryScreen();
//        }
//
//        if (ball.numOfLives <= 0) {
//            game.showGameOverScreen();
//        }
//    }
//
//    public boolean intersects(Circle circle, Rectangle rectangle) {
//        Vector2 circleDistance = new Vector2();
//        circleDistance.x = Math.abs(circle.x - rectangle.x);
//        circleDistance.y = Math.abs(circle.y - rectangle.y);
//
//        if (circleDistance.x > (rectangle.width / 2 + circle.radius)) {
//            return false;
//        }
//        if (circleDistance.y > (rectangle.height / 2 + circle.radius)) {
//            return false;
//        }
//
//        if (circleDistance.x <= (rectangle.width / 2)) {
//            return true;
//        }
//        if (circleDistance.y <= (rectangle.height / 2)) {
//            return true;
//        }
//
//        double cornerDistance_sq = Math.pow(circleDistance.x - rectangle.width / 2, 2) + Math.pow(circleDistance.y - rectangle.height / 2, 2);
//        return (cornerDistance_sq <= (Math.pow(circle.radius, 2)));
//    }
//
//    @Override
//    public void resize(int width, int height) {
//        outbreakViewport.update(width, height, true);
//        hudViewport.update(width, height, true);
//        font.getData().setScale(Math.min(width, height) / com.mygdx.game.Trash.Constants.HUD_FONT_REFERENCE_SCREEN_SIZE);
//        bricks.init();
//        player.init();
//    }
//
//    @Override
//    public void pause() {
//
//    }
//
//    @Override
//    public void resume() {
//
//    }
//
//    @Override
//    public void hide() {
//
//    }
//
//    @Override
//    public void dispose() {
//        renderer.dispose();
//        batch.dispose();
//    }
//
//    @Override
//    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        game.showMenuScreen();
//        return true;
//    }
//}