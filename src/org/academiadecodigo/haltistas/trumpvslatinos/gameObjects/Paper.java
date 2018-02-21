package org.academiadecodigo.haltistas.trumpvslatinos.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Paper extends Item {

    public Paper (int x, int y, String source) {
        super(x, y, source);
    }



    public void move(){

        System.out.println("moving the paper");
        System.out.println("Y: " + getY());
        if (getY() > 10) {
            System.out.println(getY());
            translate(0, -10);

            //System.out.println(getMove());
        }
        if (getY() == 10) {
            getPicture().delete();
        }
    }


    @Override
    public void translate (double dx, double dy) {


        getPicture().translate(dx, dy);
        setY(getY()+ (int) dy);
        System.out.println(getY());



         /*   if (getY() > 10) {

                getPicture().translate(dx, dy);
                setY(getY()+ (int) dy);
                System.out.println(getY());
            }*/


    }

    @Override
    public int getY() {
        return super.getY();
    }
}
