package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Created by Tobias on 1/12/2016.
 */
public class OutbreakScreen extends InputAdapter implements Screen {
    public static final String TAG = OutbreakScreen.class.getName();

    OutbreakGame game;
    Constants.Difficulty difficulty;

    ExtendViewport outbreakViewport;
    ShapeRenderer renderer;

    ScreenViewport hudViewport;
    SpriteBatch batch;
    BitmapFont font;

    Player player;
    Ball ball;
    Bricks bricks;

    int score;

    public OutbreakScreen(OutbreakGame game, Constants.Difficulty difficulty) {
        this.game = game;
        this.difficulty = difficulty;
    }

    @Override
    public void show() {
        outbreakViewport = new ExtendViewport(Constants.GAME_WORLD_SIZE, Constants.GAME_WORLD_SIZE);

        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);

        hudViewport = new ScreenViewport();
        batch = new SpriteBatch();

        font = new BitmapFont();
        font.getRegion().getTexture().setFilter(
                Texture.TextureFilter.Linear,
                Texture.TextureFilter.Linear
        );

        player = new Player(outbreakViewport);
        ball = new Ball(outbreakViewport, difficulty);
        bricks = new Bricks(outbreakViewport, difficulty);

        Gdx.input.setInputProcessor(this);

        score = 0;
    }

    @Override
    public void render(float delta) {
        player.update(delta);
        ball.update(delta);

        if (player.hitByBall(ball)) {
            ball.velocity.y = -ball.velocity.y;
        }

        if (ball.detectBrickCollision(bricks)) {
            ball.velocity.y = -ball.velocity.y;
        }

        outbreakViewport.apply(true);
        Gdx.gl.glClearColor(
                Constants.GAME_BACKGROUND_COLOR.r,
                Constants.GAME_BACKGROUND_COLOR.g,
                Constants.GAME_BACKGROUND_COLOR.b,
                1
        );
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(outbreakViewport.getCamera().combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        bricks.render(renderer);
        ball.render(renderer);
        player.render(renderer);

        renderer.end();

        score = bricks.bricksDestroyed;
        hudViewport.apply();
        batch.setProjectionMatrix(hudViewport.getCamera().combined);
        batch.begin();
        font.draw(batch, "Number of lives: " + ball.numOfLives + "\nDifficulty: " + difficulty.label,
                Constants.HUD_MARGIN, hudViewport.getWorldHeight() - Constants.HUD_MARGIN);
        font.draw(batch, "Score: " + bricks.bricksDestroyed,
                hudViewport.getWorldWidth() - Constants.HUD_MARGIN,
                hudViewport.getWorldHeight() - Constants.HUD_MARGIN,
                0, Align.right, false);

        if (ball.numOfLives <= 0) {
            font.draw(
                    batch,
                    "GAME OVER",
                    hudViewport.getWorldWidth() / 2,
                    hudViewport.getWorldHeight() / 2,
                    0,
                    Align.left,
                    false
            );
        }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        outbreakViewport.update(width, height, true);
        hudViewport.update(width, height, true);
        font.getData().setScale(Math.min(width, height) / Constants.HUD_FONT_REFERENCE_SCREEN_SIZE);
        bricks.init();
        player.init();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        renderer.dispose();
        batch.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        game.showDifficultyScreen();
        return true;
    }
}