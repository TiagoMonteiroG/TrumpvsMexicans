package org.academiadecodigo.haltistas.trumpvslatinos.gameBasics;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartMenu {

    public static final int PADDING = 10;
    private int x;
    private int y;
    private Picture picture;

    public StartMenu(String source) {

        this.x = PADDING;
        this.y = PADDING;
        Picture picture = new Picture(x, y, source);
        picture.draw();

    }


}
