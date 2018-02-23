package org.academiadecodigo.haltistas.trumpvslatinos.gameObjects;

import org.academiadecodigo.haltistas.trumpvslatinos.gameBasics.GameGrid;
import org.academiadecodigo.simplegraphics.graphics.Movable;

public class Trump extends GameObject implements Movable {

    private Direction direction;
    private boolean shooting;
    private Paper[] paper;


    public Trump(int x, int y, String source) {
        super(x, y, source);
        this.direction = Direction.NULL;
        this.paper = new Paper[5];
    }

    public Paper[] getPaper() {
        return paper;
    }

    public void move() {

        if (direction.equals(Direction.RIGHT)) {
            translate(20, 0);
            direction = Direction.NULL;
            return;
        }

        if (direction.equals(Direction.LEFT)) {
            translate(-20, 0);
            direction = Direction.NULL;
            return;
        }

        translate(0, 0);

    }

    public Paper shoot() {

        if (!shooting) {
            return null;
        }

        Paper toReturn = null;

        int paperWidth = 20;
        shooting = false;
        for (int i = 0; i < paper.length; i++) {
            if (paper[i] == null) {
                paper[i] = new Paper(getX() + getWidth() - paperWidth, 700, "assets/paper.png");
                toReturn = paper[i];
                break;
            }

        }
        return toReturn;
    }

    @Override
    public void translate(double dx, double dy) {

        int currentX = getX();

        if (currentX == 510 && dx > 0) {
            return;
        }

        if (currentX == 10 && dx < 0) {
            return;
        }

        setX(currentX + (int) dx);
        getPicture().translate(dx, dy);

    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    public void setShooting(boolean bool) {
        this.shooting = bool;
    }


    public void paperShoot() {
        for (int i = 0; i < paper.length; i++) {

            if (paper[i] == null) {
                paper[i] = shoot();
                continue;
            }
            paper[i].move();

            if (paper[i].getY() == GameGrid.PADDING) {
                paper[i] = null;

            }

        }

    }

}

