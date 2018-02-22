package org.academiadecodigo.haltistas.trumpvslatinos.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public abstract class GameObject  {

    private boolean colide = false;
    private int x;
    private int y;
    private Picture picture;

    public GameObject (int x, int y, String source) {
        this.x = x;
        this.y = y;
        this.picture = new Picture(x,y,source);
        picture.draw();

    }


    public int getX1(){
        return x + picture.getWidth();
    }

    public int getY1(){
        return  y + picture.getHeight();
    }

    public int getXBottom(){
        return y + picture.getHeight();
    }

    public int getY1Bottom(){
        return y + picture.getWidth() + picture.getHeight();
    }

    public int getX () {
        return  picture.getX();
    }

    public int getY () {
        return  picture.getY();
    }

    public void setX (int x) {
        this.x = x;
    }

    public void setY (int y) {
        this.y = y;
    }

    public int getWidth(){
        return picture.getWidth();
    }

    public int getHeight(){
        return picture.getHeight();
    }

    public Picture getPicture() {
        return picture;
    }


    public void setColide (boolean colision ){
        colide = colision;
        System.out.println(colide);
    }

    public boolean colide (){
        return colide;
    }



}
