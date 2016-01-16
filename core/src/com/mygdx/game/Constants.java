package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;

/**
 * Created by Tobias on 1/12/2016.
 */
public class Constants {
    // Game
    public static final float GAME_WORLD_SIZE = 10.0f;
    public static final Color GAME_BACKGROUND_COLOR = Color.BLACK;

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
}