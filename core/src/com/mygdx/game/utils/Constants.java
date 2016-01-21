package com.mygdx.game.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Tobias on 20-01-2016.
 */
public class Constants {
    public static final String TAG = Constants.class.getName();

    // Game
    public static final int GAME_WORLD_SIZE = 320;
    public static final Color GAME_BACKGROUND_COLOR = Color.SKY;

    // Text
    public static final String TEXT_NUMBER_OF_LIVES_LEFT = "Number of lives left";
    public static final String TEXT_NUMBER_OF_BRICKS_LEFT = "Number of bricks left";
    public static final String TEXT_DIFFICULTY = "Difficulty";

    // Paddle
    public static final String PADDLE_TEXTURE = "paddle_02.png";
    public static final int PADDLE_WIDTH = 100;
    public static final int PADDLE_HEIGHT = 20;
    public static final int PADDLE_MOVEMENT_SPEED = 200;

    // Ball
    public static final String BALL_TEXTURE = "ballBlack_08.png";
    public static final int BALL_SIZE = 20;

    // Brick
    public static final String BRICK_TEXTURE = "tileGrey_14.png";
    public static final int BRICK_WIDTH = 40;
    public static final int BRICK_HEIGHT = 20;
    public static final int BRICK_NUM_ROWS = 5;
    public static final int BRICK_NUM_COLS = 8;
    public static final int BRICK_MARGIN = 15;

    // CollisionDetector
    public static final String COLLISION_DETECTOR_LEFT = "LEFT";
    public static final String COLLISION_DETECTOR_RIGHT = "RIGHT";
    public static final String COLLISION_DETECTOR_BOTTOM = "BOTTOM";
    public static final String COLLISION_DETECTOR_TOP = "TOP";
    public static final String COLLISION_DETECTOR_NONE = "NONE";

    // Hud
    public static final int HUD_VIEWPORT_WIDTH = 320;
    public static final int HUD_VIEWPORT_HEIGHT = 320;
    public static final int HUD_MARGIN = 5;
}
