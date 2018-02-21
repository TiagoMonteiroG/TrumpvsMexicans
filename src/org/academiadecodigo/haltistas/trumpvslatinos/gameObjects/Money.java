package org.academiadecodigo.haltistas.trumpvslatinos.gameObjects;

public class Money extends Item {
    public Money(int x, int y, String source) {
        super(x, y, source);
    }

    public void move() {


        if (getMove() && getY() < 860) {
            translate(0, 4);

        }

        if (getY() == 860) {

            getPicture().delete();
            setMove(false);
            getPicture().translate(0,-960);
           // setX( (int) Math.floor((Math.random() * 580 + 10)));
            getPicture().draw();

        }
    }

    @Override
    public void translate(double dx, double dy) {

        getPicture().translate(dx, dy);
        setY(getY() + (int) dy);
    }
}


