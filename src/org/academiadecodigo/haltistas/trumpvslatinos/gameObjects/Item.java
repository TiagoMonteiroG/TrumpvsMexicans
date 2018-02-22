package org.academiadecodigo.haltistas.trumpvslatinos.gameObjects;

import org.academiadecodigo.simplegraphics.graphics.Movable;

public abstract class Item extends GameObject implements Movable {

    private boolean move = false;

    public Item(int x, int y, String source) {
        super(x, y, source);
    }

    @Override
    public void translate(double dx, double dy) {

        int currentY = getY();

        setY(currentY + (int) dy);
        getPicture().translate(dx, dy);

    }

    public void setMove (boolean change) {
        move = change;
    }

    public boolean getMove () {
        return move;
    }


}
