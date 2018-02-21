package org.academiadecodigo.haltistas.trumpvslatinos;

import org.academiadecodigo.haltistas.trumpvslatinos.gameBasics.GameGrid;
import org.academiadecodigo.haltistas.trumpvslatinos.gameBasics.KeyHandler;
import org.academiadecodigo.haltistas.trumpvslatinos.gameBasics.ScoreBoard;
import org.academiadecodigo.haltistas.trumpvslatinos.gameBasics.StartMenu;
import org.academiadecodigo.haltistas.trumpvslatinos.gameObjects.Latino;
import org.academiadecodigo.haltistas.trumpvslatinos.gameObjects.Money;
import org.academiadecodigo.haltistas.trumpvslatinos.gameObjects.Paper;
import org.academiadecodigo.haltistas.trumpvslatinos.gameObjects.Trump;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game {

    private GameGrid gameGrid;
    private Trump trump;
    private Money[] money;
    private Latino[] latino;
    private ScoreBoard scoreBoard;
    private StartMenu startMenu;
    private KeyHandler k;
    private boolean gameOver;

    public Game() {
        this.money = new Money[12];
        this.latino = new Latino[30];
    }

    /* public void initGame() {

         startMenu = new StartMenu("assets/start.png");

         k = new KeyHandler(trump);

         k.init();

     }*/


    public void startGame() throws InterruptedException {


        // k.start();

        GameGrid gameGrid = new GameGrid("assets/back.png");

        trump = new Trump(250, 760, "assets/trump.png");
        k = new KeyHandler(trump);

        for (int i = 0; i < latino.length; i++) {
            latino[i] = new Latino((int) Math.floor((Math.random() * 525 + 10)), -100, "assets/latino.png");
        }

        for (int i = 0; i < money.length; i++) {
            money[i] = new Money((int) Math.floor((Math.random() * 580 + 10)), -100, "assets/money.png");
        }


        //money = new Money(100, 10, "assets/money.png");


        scoreBoard = new ScoreBoard(70, 850);


        k.start();
        while (!gameOver) {
            trump.move();
            Thread.sleep(30);
            trump.paperShoot();
            moneyMove();
            latinMove();

        }

    }

    public void latinMove(){
        for (Latino l : latino) {
            if (l.getMove()) {
                l.move();
            }
            int move = (int) Math.floor(Math.random() * 700);
            if (move == 1) {
                l.setMove(true);
            }
        }
    }


    public void moneyMove(){
        for (Money m : money) {
            if (m.getMove()) {
                m.move();
            }
            int move = (int) Math.floor(Math.random() * 700);
            if (move == 1) {
                m.setMove(true);
            }
        }

    }

}

