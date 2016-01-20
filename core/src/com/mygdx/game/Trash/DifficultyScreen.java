//package com.mygdx.game.Trash;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.InputAdapter;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
//import com.badlogic.gdx.graphics.g2d.GlyphLayout;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.utils.Align;
//import com.badlogic.gdx.utils.viewport.FitViewport;
//import com.mygdx.game.*;
//
///**
// * Created by tobi0958 on 1/12/2016.
// */
//public class DifficultyScreen extends InputAdapter implements Screen {
//    public static final String TAG = DifficultyScreen.class.getName();
//
//    OutbreakGame game;
//
//    ShapeRenderer renderer;
//    SpriteBatch batch;
//    FitViewport viewport;
//
//    BitmapFont font;
//
//    public DifficultyScreen(OutbreakGame game) {
//        this.game = game;
//    }
//
//    @Override
//    public void show() {
//        renderer = new ShapeRenderer();
//        batch = new SpriteBatch();
//
//        viewport = new FitViewport(Constants.DIFFICULTY_WORLD_SIZE, Constants.DIFFICULTY_WORLD_SIZE);
//        Gdx.input.setInputProcessor(this);
//
//        font = new BitmapFont();
//        font.getData().setScale(Constants.DIFFICULTY_LABEL_SCALE);
//        font.getRegion().getTexture().setFilter(
//                Texture.TextureFilter.Linear, Texture.TextureFilter.Linear
//        );
//    }
//
//    @Override
//    public void render(float delta) {
//        viewport.apply();
//        Gdx.gl.glClearColor(
//                Constants.GAME_BACKGROUND_COLOR.r,
//                Constants.GAME_BACKGROUND_COLOR.g,
//                Constants.GAME_BACKGROUND_COLOR.b,
//                1
//        );
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        renderer.setProjectionMatrix(viewport.getCamera().combined);
//        renderer.begin(ShapeRenderer.ShapeType.Filled);
//
//        renderer.setColor(Constants.DIFFICULTY_EASY_COLOR);
//        renderer.rect(
//                Constants.DIFFICULTY_WORLD_SIZE / 2,
//                Constants.DIFFICULTY_WORLD_SIZE / 2,
//                100, 50
//        );
//
//        renderer.setColor(Constants.DIFFICULTY_MEDIUM_COLOR);
//        renderer.rect(
//                Constants.DIFFICULTY_WORLD_SIZE / 2,
//                Constants.DIFFICULTY_WORLD_SIZE / 2 - 55,
//                100, 50
//        );
//
//        renderer.setColor(Constants.DIFFICULTY_HARD_COLOR);
//        renderer.rect(
//                Constants.DIFFICULTY_WORLD_SIZE / 2,
//                Constants.DIFFICULTY_WORLD_SIZE / 2 - 110,
//                100, 50
//        );
//
//        renderer.end();
//
//        batch.setProjectionMatrix(viewport.getCamera().combined);
//        batch.begin();
//
//        final GlyphLayout easyLayout = new GlyphLayout(font, Constants.DIFFICULTY_EASY_LABEL);
//        font.draw(
//                batch,
//                Constants.DIFFICULTY_EASY_LABEL,
//                Constants.DIFFICULTY_WORLD_SIZE / 2,
//                Constants.DIFFICULTY_WORLD_SIZE / 2 + easyLayout.height / 2,
//                0,
//                Align.center,
//                false
//        );
//
//        final GlyphLayout mediumLayout = new GlyphLayout(font, Constants.DIFFICULTY_MEDIUM_LABEL);
//        font.draw(batch,
//                Constants.DIFFICULTY_MEDIUM_LABEL,
//                Constants.DIFFICULTY_WORLD_SIZE / 2,
//                Constants.DIFFICULTY_WORLD_SIZE / 2 - 55 + mediumLayout.height / 2,
//                0,
//                Align.center,
//                false
//        );
//
//        final GlyphLayout hardLayout = new GlyphLayout(font, Constants.DIFFICULTY_HARD_LABEL);
//        font.draw(batch,
//                Constants.DIFFICULTY_HARD_LABEL,
//                Constants.DIFFICULTY_WORLD_SIZE / 2,
//                (Constants.DIFFICULTY_WORLD_SIZE / 2 - 110) + hardLayout.height / 2,
//                0,
//                Align.center,
//                false
//        );
//
//        batch.end();
//    }
//
//    @Override
//    public void resize(int width, int height) {
//        viewport.update(width, height, true);
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
//        batch.dispose();
//        font.dispose();
//        renderer.dispose();
//    }
//
//    @Override
//    public void dispose() {
//
//    }
//
//    @Override
//    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        Vector2 worldTouch = viewport.unproject(new Vector2(screenX, screenY));
//
//        if (worldTouch.dst(Constants.DIFFICULTY_EASY_CENTER) < 100) {
//            game.showOutbreakScreen(Constants.Difficulty.EASY);
//        }
//
//        if (worldTouch.dst(Constants.DIFFICULTY_MEDIUM_CENTER) < 100) {
//            game.showOutbreakScreen(Constants.Difficulty.MEDIUM);
//        }
//
//        if (worldTouch.dst(Constants.DIFFICULTY_HARD_CENTER) < 100) {
//            game.showOutbreakScreen(Constants.Difficulty.HARD);
//        }
//
//        return true;
//    }
//}