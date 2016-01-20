//package com.mygdx.game.Trash;
//
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.utils.DelayedRemovalArray;
//import com.badlogic.gdx.utils.viewport.Viewport;
//
///**
// * Created by Tobias on 1/12/2016.
// */
//public class Bricks {
//    public static final String TAG = Bricks.class.getName();
//
//    Constants.Difficulty difficulty;
//
//    int bricksDestroyed;
//    int numOfBricksLeft;
//    DelayedRemovalArray<Brick> brickArray;
//    Viewport viewport;
//
//    public Bricks(Viewport viewport, Constants.Difficulty difficulty) {
//        this.difficulty = difficulty;
//        this.viewport = viewport;
//        init();
//    }
//
//    public void init() {
//        brickArray = new DelayedRemovalArray<Brick>();
//
//        bricksDestroyed = 0;
//        int numRows = 5;
//        int numCols = 8;
//        numOfBricksLeft = numRows * numCols;
//
//        float xSpace = (viewport.getScreenWidth() / numCols);
//        float ySpace = 50 + 5;
//        float initialXStartPosition = viewport.getScreenWidth() - (viewport.getScreenWidth() - 5);
//
//        float yStartPosition = viewport.getScreenWidth() - (55 * (numRows - 1));
//        for (int i = 0; i < numRows; i++) {
//            float xStartPosition = initialXStartPosition;
//            for (int j = 0; j < numCols; j++) {
//                Vector2 brickPosition = new Vector2(xStartPosition, yStartPosition);
//                xStartPosition += xSpace;
//                brickArray.add(new Brick(brickPosition));
//            }
//            yStartPosition -= ySpace;
//        }
//    }
//
//    public void render(SpriteBatch batch) {
//        for (Brick brick : brickArray) {
//            brick.render(batch);
//        }
//    }
//}