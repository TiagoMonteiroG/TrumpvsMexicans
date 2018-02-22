package org.academiadecodigo.haltistas.trumpvslatinos.gameBasics;

import org.academiadecodigo.haltistas.trumpvslatinos.gameObjects.GameObject;

public class CheckCollision {
    private GameObject[] latino;
    private GameObject[] paper;
    private GameObject[] money;
    private GameObject trump;


    public CheckCollision(GameObject[] latino, GameObject[] paper, GameObject[] money, GameObject trump) {
        this.latino = latino;
        this.paper = paper;
        this.money = money;
        this.trump = trump;

    }

    public void latinoCollision() {

        for (GameObject l : latino) {
            for (GameObject p : paper) {

                if (p != null) {
                    if (((l.getX() < p.getX() &&
                            p.getX() < l.getX1()) ||

                            (l.getX() < p.getX1() &&
                                    p.getX1() < l.getX1())) &&

                            (l.getY() < p.getY() &&
                                    p.getY() < l.getY1())) {


                        l.setCollide(true);
                        p.setCollide(true);
                    }
                }
            }

        }

    }

    public void trumpCollision() {

        for (GameObject m : money) {

            if (m.getXBottom() >= trump.getY() && (m.getX() > trump.getX() &&
                    trump.getX1() > m.getX())) {
                m.setCollide(true);

            }
        }

    }
}
