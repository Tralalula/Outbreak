//package com.mygdx.game.Trash;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.InputAdapter;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
//import com.badlogic.gdx.graphics.g2d.GlyphLayout;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.utils.Align;
//import com.badlogic.gdx.utils.viewport.FitViewport;
//import com.mygdx.game.*;
//
///**
// * Created by Tobias on 17-01-2016.
// */
//public class GameOverSreen extends InputAdapter implements Screen {
//    public static final String TAG = VictoryScreen.class.getName();
//
//    OutbreakGame game;
//
//    SpriteBatch batch;
//    FitViewport viewport;
//    BitmapFont font;
//
//    public GameOverSreen(OutbreakGame game) {
//        this.game = game;
//    }
//
//    @Override
//    public void show() {
//        batch = new SpriteBatch();
//
//        viewport = new FitViewport(Constants.DIFFICULTY_WORLD_SIZE, Constants.DIFFICULTY_WORLD_SIZE);
//        Gdx.input.setInputProcessor(this);
//
//        font = new BitmapFont();
//        font.getData().setScale(Constants.DIFFICULTY_LABEL_SCALE);
//        font.getRegion().getTexture().setFilter(
//                Texture.TextureFilter.Linear,
//                Texture.TextureFilter.Linear
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
//
//        batch.setProjectionMatrix(viewport.getCamera().combined);
//        batch.begin();
//
//        final GlyphLayout victoryLayout = new GlyphLayout(font, "Game Over!");
//        font.draw(
//                batch,
//                "Game Over!",
//                Constants.DIFFICULTY_MEDIUM_CENTER.x,
//                Constants.DIFFICULTY_MEDIUM_CENTER.y + victoryLayout.height / 2,
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
//    }
//
//    @Override
//    public void dispose() {
//
//    }
//
//    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        game.showMenuScreen();
//        return true;
//    }
//}
