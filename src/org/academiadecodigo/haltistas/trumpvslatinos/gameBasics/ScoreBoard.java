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

    public void setScore(int points) {
        score += points ;

    }

    public void setText(int score) {
        this.text.setText("Score : " + score);
    }

    public int getScore(){
        return score;
    }


}
