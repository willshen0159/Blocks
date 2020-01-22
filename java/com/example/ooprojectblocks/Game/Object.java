package com.example.ooprojectblocks.Game;

import android.app.Activity;
import android.widget.ImageView;

import java.util.List;

public abstract class Object {

    private String type;

    private int state;
    private int x;
    private int y;
    private String color;
    private int height;
    private int width;

    public ImageView image;

    private ContactBehavior beh;

    public Object() {}

    public Object(int x, int y, int width, int height, String color) {
        this.state = 0;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getState() {
        return state;
    }

    public void setState(int s) {
        this.state = s;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        // 更改物件x時同時修改圖片x
        this.image.setX(x);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        // 更改物件y時同時修改圖片y
        this.image.setY(y);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setContactBehavior(ContactBehavior beh) {
        this.beh = beh;
    }
    // Strategy pattern的概念
    public void contact(List<Object> objects, Object o, Hero hero) {
        beh.perform(objects, o, hero);
        this.setState(-1);
    }
}
