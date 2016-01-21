package com.mygdx.game.utils;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.objects.Bricks;

/**
 * Created by Tobias on 21-01-2016.
 */
public class CollisionDetector {
    public int checkBrickCollision(Rectangle rectangle, Bricks bricks) {
        for (int i = 0; i < bricks.getBricks().size; i++) {
            if (rectangle.overlaps(bricks.getBricks().get(i).getBounds())) {
                return i;
            }
        }
        return -1;
    }

    public String checkRectangleCollision(Rectangle rectangle1, Rectangle rectangle2) {
        if (rectangle1.overlaps(rectangle2)) {
            if (rectangle1.getX() <= rectangle2.getX()) {
                return Constants.COLLISION_DETECTOR_LEFT;
            } else if (rectangle1.getX() >= rectangle2.getX() + rectangle2.getWidth()) {
                return Constants.COLLISION_DETECTOR_RIGHT;
            } else if (rectangle1.getY() <= rectangle2.getY()) {
                return Constants.COLLISION_DETECTOR_BOTTOM;
            } else {
                return Constants.COLLISION_DETECTOR_TOP;
            }
        }

        return Constants.COLLISION_DETECTOR_NONE;
    }

    public String checkWallCollision(Viewport viewport, Rectangle rectangle) {
        if (rectangle.getX() < 0) {
            return Constants.COLLISION_DETECTOR_LEFT;
        } else if (rectangle.getX() + rectangle.getWidth() > viewport.getWorldWidth()) {
            return Constants.COLLISION_DETECTOR_RIGHT;
        } else if (rectangle.getY() < 0) {
            return Constants.COLLISION_DETECTOR_BOTTOM;
        } else if (rectangle.getY() + rectangle.getHeight() > viewport.getWorldHeight()) {
            return Constants.COLLISION_DETECTOR_TOP;
        }
        return Constants.COLLISION_DETECTOR_NONE;
    }
}
