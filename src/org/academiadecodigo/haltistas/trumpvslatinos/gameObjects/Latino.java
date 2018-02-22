package org.academiadecodigo.haltistas.trumpvslatinos.gameObjects;

import org.academiadecodigo.haltistas.trumpvslatinos.Game;

public class Latino extends Item {

    private Game game;

    public Latino(int x, int y, String source, Game game) {
        super(x, y, source);
        this.game = game;
    }

    public void move() {

        if (getMove() && getY() < 810) {
            translate(0, 4);

        }

        if (getY() >= 810) {
            game.setGameOver(true);

        }

        if (colide()) {
            getPicture().delete();
            setMove(false);
            getPicture().translate(0, -910);
            getPicture().draw();
            setColide(false);
        }

    }

    @Override
    public void translate(double dx, double dy) {

        getPicture().translate(dx, dy);
        setY(getY() + (int) dy);

    }

}
