package org.academiadecodigo.haltistas.trumpvslatinos.gameBasics;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameGrid implements Colidable {

    public static final int PADDING = 10;
    private int x;
    private int y;

    private int height;
    private Picture picture;

    public GameGrid(String source) {

        this.x = PADDING;
        this.y = PADDING;
        Picture picture = new Picture(x, y, source);
        picture.draw();

    }


    public int getHeight() {
        return picture.getHeight() + PADDING;
    }

    public int getWidth() {
        return picture.getWidth()+ PADDING;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
