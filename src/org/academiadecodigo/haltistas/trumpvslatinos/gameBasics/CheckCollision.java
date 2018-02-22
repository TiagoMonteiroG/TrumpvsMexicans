package org.academiadecodigo.haltistas.trumpvslatinos.gameBasics;

import org.academiadecodigo.haltistas.trumpvslatinos.gameObjects.GameObject;

public class CheckCollision {
    GameObject[] latino;
    GameObject[] paper;
    GameObject[] money;
    GameObject trump;


    public CheckCollision(GameObject[] latino, GameObject[] paper, GameObject[] money, GameObject trump) {
        this.latino = latino;
        this.paper = paper;
        this.money = money;
        this.trump = trump;

    }


    public void latinoCollision() {


        for (int i = 0; i < latino.length; i++) {
            for (int j = 0; j < paper.length; j++) {

                if (paper[j] != null) {
                    if (((latino[i].getX() < paper[j].getX() &&
                            paper[j].getX() < latino[i].getX1()) ||

                            (latino[i].getX() < paper[j].getX1() &&
                                    paper[j].getX1() < latino[i].getX1())) &&

                            (latino[i].getY() < paper[j].getY() &&
                                    paper[j].getY() < latino[i].getY1())) {


                        latino[i].setColide(true);
                        paper[j].setColide(true);
                    }
                }
            }

        }

    }

    public void trumpCollision() {

        for (int i = 0; i < money.length; i++) {

           if (money[i].getXBottom() >= trump.getY() && (money[i].getX() > trump.getX() &&
                   trump.getX1() > money[i].getX()))
                {
               money[i].setColide(true);

           }

        }


    }


}
