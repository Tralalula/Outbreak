package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by Tobias on 1/12/2016.
 */
public class Constants {
    // Game
    public static final float GAME_WORLD_SIZE = 10.0f;
    public static final Color GAME_BACKGROUND_COLOR = Color.BLACK;
    public static final int GAME_NUM_OF_LIVES = 3;

    // Player
    public static final float PADDLE_HEIGHT = 0.4f;
    public static final float PADDLE_WIDTH = 4.0f;
    public static final Color PADDLE_COLOR = Color.NAVY;
    public static final float PADDLE_STARTING_POSITION_Y = 2.0f;
    public static final float PADDLE_MOVEMENT_SPEED = 10.0f;

    // Brick(s)
    public static final float BRICK_HEIGHT = 0.5f;
    public static final float BRICK_WIDTH = 1.0f;
    public static final Color BRICK_COLOR = Color.FIREBRICK;

    // Ball
    public static final Color BALL_COLOR = Color.FOREST;
    public static final float BALL_RADIUS = 0.4f;
    public static final int BALL_SEGMENTS = 20;

    // Accelerometer
    public static final float ACCELEROMETER_SENSITIVITY = 0.5f;
    public static final float ACCELEROMETER_GRAVITATIONAL_ACCELERATION = 9.8f;

    // Hud
    public static final float HUD_FONT_REFERENCE_SCREEN_SIZE = 480.0f;
    public static final float HUD_MARGIN = 20.0f;

    // Difficulty
    public static final String DIFFICULTY_EASY_LABEL = "Easy";
    public static final String DIFFICULTY_MEDIUM_LABEL = "Medium";
    public static final String DIFFICULTY_HARD_LABEL = "Hard";
    public static final String DIFFICULTY_HARDCORE_LABEL = "Hardcore";

    public static final int DIFFICULTY_EASY_NUM_OF_LIVES = 10;
    public static final int DIFFICULTY_MEDIUM_NUM_OF_LIVES = 7;
    public static final int DIFFICULTY_HARD_NUM_OF_LIVES = 3;
    public static final int DIFFICULTY_HARDCORE_NUM_OF_LIVES = 1;

    public enum Difficulty {
        EASY(DIFFICULTY_EASY_NUM_OF_LIVES, DIFFICULTY_EASY_LABEL),
        MEDIUM(DIFFICULTY_MEDIUM_NUM_OF_LIVES, DIFFICULTY_MEDIUM_LABEL),
        HARD(DIFFICULTY_HARD_NUM_OF_LIVES, DIFFICULTY_HARD_LABEL),
        HARDCORE(DIFFICULTY_HARDCORE_NUM_OF_LIVES, DIFFICULTY_HARDCORE_LABEL);

        int numOfLives;
        String label;

        Difficulty(int numOfLives, String label) {
            this.numOfLives = numOfLives;
            this.label = label;
        }
    }
}