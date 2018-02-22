package org.academiadecodigo.haltistas.trumpvslatinos;

import org.academiadecodigo.haltistas.trumpvslatinos.gameBasics.*;
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
    private boolean gameStart = false;

    public Game() {
        this.money = new Money[20];
        this.latino = new Latino[5];
    }

    /*public void initGame() throws InterruptedException {
        k = new KeyHandler(trump);
        k.init();

         startMenu = new StartMenu("assets/start.png");


        if (gameStart) {
            startGame();
            return;
        }

     }*/


    public void startGame() throws InterruptedException {


        GameGrid gameGrid = new GameGrid("assets/back.png");

        trump = new Trump(250, 760, "assets/trump.png");
        k = new KeyHandler(trump);

        for (int i = 0; i < latino.length; i++) {
            latino[i] = new Latino((int) Math.floor((Math.random() * 525 + 20)), -100, "assets/latino.png");
        }

        for (int i = 0; i < money.length; i++) {
            money[i] = new Money((int) Math.floor((Math.random() * 580 + 10)), -100, "assets/money.png");

        }

        CheckCollision checkCollision = new CheckCollision (latino, trump.getPaper(), money, trump );


        scoreBoard = new ScoreBoard(70, 850);


        k.start();
        while (!gameOver) {

            trump.move();
            Thread.sleep(30);
            trump.paperShoot();

            checkCollision.latinoCollision();
            checkCollision.trumpCollision();

            moneyMove();
            latinMove();

        }

    }

    public void latinMove(){

        for (Latino l : latino) {
            if (l.getMove()) {
                l.move();
            }
            int move = (int) Math.floor(Math.random() * 50);
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
            int move = (int) Math.floor(Math.random() * 50);
            if (move == 1) {
                m.setMove(true);
            }
        }

    }

    public void setGameStart (boolean start) {
        gameStart = start;
    }

}

