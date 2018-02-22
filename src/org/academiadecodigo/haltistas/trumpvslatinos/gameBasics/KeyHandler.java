package org.academiadecodigo.haltistas.trumpvslatinos.gameBasics;

import org.academiadecodigo.haltistas.trumpvslatinos.Game;
import org.academiadecodigo.haltistas.trumpvslatinos.gameObjects.Direction;
import org.academiadecodigo.haltistas.trumpvslatinos.gameObjects.Trump;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyHandler implements KeyboardHandler {

    private KeyboardEvent right;
    private KeyboardEvent left;
    private KeyboardEvent start;
    private KeyboardEvent space;
    private Keyboard k;
    private Trump trump;
    private Game game;

    public KeyHandler(Trump trump, Game game) {
        this.trump = trump;
        this.game = game;

    }

    public void init() {
        k = new Keyboard(this);

        start = new KeyboardEvent();
        start.setKey(KeyboardEvent.KEY_S);
        start.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(start);

    }


    public void start() {
        k = new Keyboard(this);

        right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(right);

        KeyboardEvent rightRelease = new KeyboardEvent();
        rightRelease.setKey(KeyboardEvent.KEY_RIGHT);
        rightRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(rightRelease);

        left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(left);

        KeyboardEvent leftReRelease = new KeyboardEvent();
        leftReRelease.setKey(KeyboardEvent.KEY_LEFT);
        leftReRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(leftReRelease);

        space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(space);

        KeyboardEvent spaceRelease = new KeyboardEvent();
        spaceRelease.setKey(KeyboardEvent.KEY_SPACE);
        spaceRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(spaceRelease);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.equals(right)) {
            trump.setDirection(Direction.RIGHT);
            return;
        }


        if (keyboardEvent.equals(left)) {
            trump.setDirection(Direction.LEFT);
            return;

        }

        if (keyboardEvent.equals(start)) {
            game.start();
            return;
        }

        if (keyboardEvent.equals(space)) {
            trump.setShooting(true);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
