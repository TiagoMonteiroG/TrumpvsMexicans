package org.academiadecodigo.haltistas.trumpvslatinos.gameBasics;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartMenu {

    private Picture picture;

    public StartMenu(String source) {

        this.picture = new Picture(GameGrid.PADDING, GameGrid.PADDING, source);
        picture.draw();

    }

    public void hide(){
        picture.delete();
    }

}
