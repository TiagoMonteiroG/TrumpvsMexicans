package org.academiadecodigo.haltistas.trumpvslatinos.gameBasics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class ScoreBoard {

    private int score;
    private Text text;

    public ScoreBoard (int x, int y) {

        this.text = new Text (x, y, "Score : "  + score );
        text.setColor(Color.DARK_GRAY);
        text.draw();
        text.grow(40,40);
    }

    public void incrementScore(int points) {
        score += points ;
        this.text.setText("Score : " + score);
    }

    public void reduceScore(int points){
        score -= points;
        this.text.setText("Score : " + score);
    }
}
