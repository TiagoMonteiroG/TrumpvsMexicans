package org.academiadecodigo.haltistas.trumpvslatinos.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Paper extends Item {

    public Paper (int x, int y, String source) {
        super(x, y, source);
    }

    public void move() {

            if (getY() > 10) {
                translate(0, -10);

            }
            if (getY() == 10) {
                getPicture().delete();
            }
    }

    @Override
    public void translate (double dx, double dy) {

        getPicture().translate(dx, dy);
        setY(getY()+ (int) dy);

    }

    @Override
    public int getY() {
        return super.getY();
    }
}
