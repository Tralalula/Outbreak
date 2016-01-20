//package com.mygdx.game.Trash;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.Pixmap;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
//import com.badlogic.gdx.scenes.scene2d.Actor;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.scenes.scene2d.ui.Skin;
//import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
//import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
//import com.mygdx.game.*;
//
//public class MenuScreen implements Screen {
//    OutbreakGame game;
//    BitmapFont font;
//    Skin skin;
//    Stage stage;
//
//    public MenuScreen(OutbreakGame game) {
//        this.game = game;
//    }
//
//    public void createBasicSkin() {
//        font = new BitmapFont();
//        skin = new Skin();
//        skin.add("default", font);
//
//        Pixmap pixmap = new Pixmap(
//                (int) Gdx.graphics.getWidth() / 4,
//                (int) Gdx.graphics.getHeight() / 10,
//                Pixmap.Format.RGBA8888
//        );
//        pixmap.setColor(Color.WHITE);
//        pixmap.fill();
//        skin.add("background", new Texture(pixmap));
//
//        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
//        textButtonStyle.up = skin.newDrawable("background", Color.GRAY);
//        textButtonStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
//        textButtonStyle.checked = skin.newDrawable("background", Color.DARK_GRAY);
//        textButtonStyle.over = skin.newDrawable("background", Color.LIGHT_GRAY);
//        textButtonStyle.font = skin.getFont("default");
//        skin.add("default", textButtonStyle);
//    }
//
//    @Override
//    public void show() {
//        stage = new Stage();
//        Gdx.input.setInputProcessor(stage);
//
//        createBasicSkin();
//
//        TextButton easyGameButton = new TextButton(Constants.DIFFICULTY_EASY_LABEL, skin);
//        easyGameButton.setPosition(
//                Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8,
//                Gdx.graphics.getHeight() / 2 + 50
//        );
//
//        easyGameButton.addListener(new ChangeListener() {
//            @Override
//            public void changed(ChangeEvent event, Actor actor) {
//                game.showOutbreakScreen(Constants.Difficulty.EASY);
//            }
//        });
//        stage.addActor(easyGameButton);
//
//        TextButton mediumGameButton = new TextButton(Constants.DIFFICULTY_MEDIUM_LABEL, skin);
//        mediumGameButton.setPosition(
//                Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8,
//                Gdx.graphics.getHeight() / 2
//        );
//
//        mediumGameButton.addListener(new ChangeListener() {
//            @Override
//            public void changed(ChangeEvent event, Actor actor) {
//                game.showOutbreakScreen(Constants.Difficulty.MEDIUM);
//            }
//        });
//        stage.addActor(mediumGameButton);
//
//        TextButton hardGameButton = new TextButton(Constants.DIFFICULTY_HARD_LABEL, skin);
//        hardGameButton.setPosition(
//                Gdx.graphics.getWidth() / 2 - Gdx.graphics.getWidth() / 8,
//                Gdx.graphics.getHeight() / 2 - 50
//        );
//
//        hardGameButton.addListener(new ChangeListener() {
//            @Override
//            public void changed(ChangeEvent event, Actor actor) {
//                game.showOutbreakScreen(Constants.Difficulty.HARD);
//            }
//        });
//        stage.addActor(hardGameButton);
//    }
//
//    @Override
//    public void render(float delta) {
//        Gdx.gl.glClearColor(
//                Constants.GAME_BACKGROUND_COLOR.r,
//                Constants.GAME_BACKGROUND_COLOR.g,
//                Constants.GAME_BACKGROUND_COLOR.b,
//                1
//        );
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        stage.act();
//        stage.draw();
//    }
//
//    @Override
//    public void resize(int width, int height) {
//
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
//        stage.dispose();
//        skin.dispose();
//        font.dispose();
//    }
//
//    @Override
//    public void dispose() {
//
//    }
//}