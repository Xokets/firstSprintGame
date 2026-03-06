package ru.innovationcampus.vsu26.xokets.first_sprint_game;

import java.util.Random;

public class Person {

    public static final String ICON = "\uD83E\uDDD9\u200D";
    public static final int START_LIVES = 3;

    private int x;
    private int y;
    private int live;

    public Person() {
        this(0, 0);
    }

    public Person(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Person(int size) {
        Random rand = new Random();
        this.x = 0;
        this.y = rand.nextInt(size);
        this.live = START_LIVES;
    }

    public void move(int x, int y) {
            this.x = x;
            this.y = y;
    }

    public boolean isCorrectMove(int x, int y) {
        return this.x == x && Math.abs(this.y - y) == 1 || this.y == y && Math.abs(this.x - x) == 1;
    }

    public void hit() {
        if (live > 0) {
            live--;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLive() {
        return live;
    }
}
