package org.academiadecodigo.haltistas.trumpvslatinos.gameObjects;

import org.academiadecodigo.haltistas.trumpvslatinos.gameBasics.ScoreBoard;

public class Money extends Item {

    private ScoreBoard scoreBoard;

    public Money(int x, int y, String source) {
        super(x, y, source);
        this.scoreBoard = new ScoreBoard(70, 850);
    }

    public void move() {

        if (getMove() && getY() < 860) {
            translate(0, 4);

        }

        if (getY() == 860) {

            getPicture().delete();
            setMove(false);
            getPicture().translate(0, -960);
            getPicture().draw();

        }

        if (colide()) {
            scoreBoard.setScore(100);
            getPicture().delete();
            setMove(false);
            getPicture().translate(0, -960);
            getPicture().draw();
            setColide(false);

        }
        scoreBoard.setText(scoreBoard.getScore());
    }

    @Override
    public void translate(double dx, double dy) {

        getPicture().translate(dx, dy);
        setY(getY() + (int) dy);
    }
}


