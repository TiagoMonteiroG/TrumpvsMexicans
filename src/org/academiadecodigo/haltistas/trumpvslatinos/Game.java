package org.academiadecodigo.haltistas.trumpvslatinos;

import org.academiadecodigo.haltistas.trumpvslatinos.gameBasics.*;
import org.academiadecodigo.haltistas.trumpvslatinos.gameObjects.GameObject;
import org.academiadecodigo.haltistas.trumpvslatinos.gameObjects.Latino;
import org.academiadecodigo.haltistas.trumpvslatinos.gameObjects.Money;
import org.academiadecodigo.haltistas.trumpvslatinos.gameObjects.Trump;

public class Game {

    private Trump trump;
    private Money[] money;
    private Latino[] latino;
    private StartMenu startMenu;
    private KeyHandler k;
    private boolean playing;
    private GameGrid gameGrid;


    public Game() {
        this.money = new Money[10];
        this.latino = new Latino[20];
    }

    public void initGame() throws InterruptedException {

        gameGrid = new GameGrid("assets/back.png");

        trump = new Trump(250, 760, "assets/trump.png");

        k = new KeyHandler(trump, this);
        k.init();

        startMenu = new StartMenu("assets/start.png");

        while (!playing) {
            Thread.sleep(100);
        }

        startGame();
    }

    public void prepare() {

        ScoreBoard scoreBoard = new ScoreBoard(70, 850);

        for (int i = 0; i < latino.length; i++) {
            latino[i] = new Latino((int) Math.floor((Math.random() * 510 + 20)), -100, "assets/latino.png", this);
        }

        for (int i = 0; i < money.length; i++) {
            money[i] = new Money((int) Math.floor((Math.random() * 580 + 10)), -100, "assets/money.png", scoreBoard);

        }

    }

    public void startGame() throws InterruptedException {

        startMenu.hide();
        prepare();

        CheckCollision checkCollision = new CheckCollision(latino, trump.getPaper(), money, trump);

        k.start();
        while (playing) {

            trump.move();
            Thread.sleep(30);
            trump.paperShoot();

            latinMove();
            moneyMove();

            checkCollision.latinoCollision();
            checkCollision.trumpCollision();

        }

        restartGame();
        resetElements();
        initGame();
    }

    public void restartGame() throws InterruptedException {
        gameGrid = new GameGrid("assets/over.png");

        k.init();

        while (!playing) {

            Thread.sleep(100);
        }
    }

    public void resetElements() {

        clear(latino);
        clear(money);
        clearTrump(trump);
        clearGrid(gameGrid);

    }

    private void clear(GameObject[] objects) {
        for (int i = 0; i < objects.length; i++) {
            objects[i].getPicture().delete();
            objects[i] = null;
        }
    }

    private void clearTrump(GameObject object) {
        object.getPicture().delete();
    }

    private void clearGrid(GameGrid gameGrid) {
        gameGrid.getPicture().delete();
    }

    public void latinMove() {

        for (Latino l : latino) {
            if (l.canMove()) {
                l.move();
            }
            int move = (int) Math.floor(Math.random() * 200);
            if (move == 1) {
                l.start();
            }
        }
    }

    public void moneyMove() {

        for (Money m : money) {
            if (m.canMove()) {
                m.move();
            }
            int move = (int) Math.floor(Math.random() * 600);
            if (move == 1) {
                m.start();
            }
        }

    }

    public void start() {
        playing = true;
    }

    public void stop() {
        playing = false;
    }

}

