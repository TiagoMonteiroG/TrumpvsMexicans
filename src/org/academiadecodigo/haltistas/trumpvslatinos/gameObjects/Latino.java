package org.academiadecodigo.haltistas.trumpvslatinos.gameObjects;

public class Latino extends Item {

    public Latino(int x, int y, String source) {
        super(x, y, source);
    }

    public void move() {

        if (getMove() && getY() < 810) {
            translate(0, 4);

        }

        if (getY() >= 810) {

            getPicture().delete();
            setMove(false);
            getPicture().translate(0,-910);
            //setX((int) Math.floor((Math.random() * 580 + 10)));
            getPicture().draw();


            System.out.println(getY());
            System.out.println(getMove());
            System.out.println(getX());
        }

    }

    @Override
    public void translate(double dx, double dy) {

        getPicture().translate(dx, dy);
        setY(getY() + (int) dy);

    }


}
