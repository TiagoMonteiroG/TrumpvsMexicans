package org.academiadecodigo.haltistas.trumpvslatinos;

import org.academiadecodigo.haltistas.trumpvslatinos.gameBasics.*;
import org.academiadecodigo.haltistas.trumpvslatinos.gameObjects.Latino;
import org.academiadecodigo.haltistas.trumpvslatinos.gameObjects.Money;
import org.academiadecodigo.haltistas.trumpvslatinos.gameObjects.Trump;

public class Game {

    private Trump trump;
    private Money[] money;
    private Latino[] latino;
    private StartMenu startMenu;
    private KeyHandler k;
    private boolean gameOver;
    private boolean gameStart = false;

    public Game() {
        this.money = new Money[10];
        this.latino = new Latino[20];
    }

    public void initGame() throws InterruptedException {

        GameGrid gameGrid = new GameGrid("assets/back.png");

        trump = new Trump(250, 760, "assets/trump.png");

        k = new KeyHandler(trump, this);
        k.init();

        startMenu = new StartMenu("assets/start.png");


        while (!gameStart) {
            Thread.sleep(100);
        }

        startGame();

    }


    public void startGame() throws InterruptedException {

        startMenu.hide();

        ScoreBoard scoreBoard = new ScoreBoard(70, 850);

        for (int i = 0; i < latino.length; i++) {
            latino[i] = new Latino((int) Math.floor((Math.random() * 525 + 20)), -100, "assets/latino.png", this);
        }

        for (int i = 0; i < money.length; i++) {
            money[i] = new Money((int) Math.floor((Math.random() * 580 + 10)), -100, "assets/money.png", scoreBoard);

        }

        CheckCollision checkCollision = new CheckCollision(latino, trump.getPaper(), money, trump);


        k.start();
        while (!gameOver) {

            trump.move();
            Thread.sleep(30);
            trump.paperShoot();

            latinMove();
            moneyMove();

            checkCollision.latinoCollision();
            checkCollision.trumpCollision();

        }

    }

    public void latinMove() {

        for (Latino l : latino) {
            if (l.getMove()) {
                l.move();
            }
            int move = (int) Math.floor(Math.random() * 200);
            if (move == 1) {
                l.setMove(true);
            }
        }
    }


    public void moneyMove() {

        for (Money m : money) {
            if (m.getMove()) {
                m.move();
            }
            int move = (int) Math.floor(Math.random() * 600);
            if (move == 1) {
                m.setMove(true);
            }
        }

    }

    public void setGameStart(boolean start) {
        gameStart = start;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}

