package ru.innovationcampus.vsu26.xokets.first_sprint_game.monster;

import ru.innovationcampus.vsu26.xokets.first_sprint_game.WordGame;

import java.util.Random;
import java.util.Scanner;


public class Monster {
    protected static final Random rand = new Random();

    public static final String DEFAULT_MONSTER_ICON = "\uD83E\uDDDF";

    protected static final String WIN_MESSAGE = "Верно! Ты победил монстра";
    protected static final String LOSE_MESSAGE = "Ты проиграл эту битву!";

    protected int x;
    protected int y;
    protected String icon = DEFAULT_MONSTER_ICON;
    protected boolean isDefeated = false;

    public Monster(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Monster() {
        this(0, 0);
    }

    public Monster(int boardSize) {
        x = rand.nextInt(boardSize);
        y = rand.nextInt(1, 4);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean conflictPerson(int x, int y) {
        return this.x == x && this.y == y;
    }

    public boolean isDefeated() {
        return isDefeated;
    }

    public boolean generateMonsterTask(int key) {
        Scanner input = new Scanner(System.in);
        WordGame.start();
        System.out.println(WIN_MESSAGE);
        isDefeated = true;
        return true;
//        System.out.println(LOSE_MESSAGE);
//        return false;
    }
}
