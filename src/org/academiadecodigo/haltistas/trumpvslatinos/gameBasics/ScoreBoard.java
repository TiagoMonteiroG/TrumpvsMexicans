package org.academiadecodigo.haltistas.trumpvslatinos.gameBasics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class ScoreBoard {

    private int x;
    private int y;
    private int score = 0;
    private Text text;

    public ScoreBoard (int x, int y) {
        this.x = x;
        this.y = y;
        this.text = new Text (x, y, "Score : " + score);
        text.setColor(Color.DARK_GRAY);
        text.draw();
        text.grow(40,40);
    }

    public void increaseScore(int points) {
        score += points ;
    }
}
