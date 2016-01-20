//package com.mygdx.game.Trash;
//
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//import com.badlogic.gdx.math.Rectangle;
//import com.badlogic.gdx.math.Vector2;
//
///**
// * Created by Tobias on 1/12/2016.
// */
//public class Brick {
//    Texture brickTexture = new Texture("tileGrey_14.png");
//
//    Rectangle brick;
//    Vector2 position;
//
//    public Brick(Vector2 position) {
//        this.position = position;
//    }
//
//    public void render(SpriteBatch batch) {
//        brick = new Rectangle(
//                position.x,
//                position.y,
//                50,
//                50
//        );
//        batch.draw(
//                brickTexture,
//                position.x,
//                position.y,
//                50,
//                50
//        );
//    }
//}