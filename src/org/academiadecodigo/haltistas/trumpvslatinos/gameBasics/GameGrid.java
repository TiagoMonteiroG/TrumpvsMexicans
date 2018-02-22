package org.academiadecodigo.haltistas.trumpvslatinos.gameBasics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameGrid {

    public static final int PADDING = 10;


    public GameGrid(String source) {

        int x = PADDING;
        int y = PADDING;
        Picture picture = new Picture(x, y, source);
        picture.draw();

    }


}
