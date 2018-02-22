package org.academiadecodigo.haltistas.trumpvslatinos.gameBasics;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartMenu {

    private static final int PADDING = 10;
    private Picture picture;

    public StartMenu(String source) {

        int x = PADDING;
        int y = PADDING;
        this.picture = new Picture(x, y, source);
        picture.draw();

    }

    public void hide(){
        picture.delete();
    }

}
