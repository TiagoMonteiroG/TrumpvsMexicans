package org.academiadecodigo.haltistas.trumpvslatinos.gameBasics;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameGrid {

    public static final int PADDING = 10;
    private Picture picture;


    public GameGrid(String source) {

        picture = new Picture(PADDING, PADDING, source);
        picture.draw();

    }

    public Picture getPicture(){
        return picture;
    }

}
