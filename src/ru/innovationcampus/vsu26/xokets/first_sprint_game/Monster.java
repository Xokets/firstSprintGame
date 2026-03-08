package ru.innovationcampus.vsu26.xokets.first_sprint_game;

import java.util.Random;
import java.util.Scanner;


public class Monster {
    private static final Random rand = new Random();

    public static final String DEFAULT_MONSTER_ICON = "\uD83E\uDDDF";

    protected static final String WIN_MESSAGE = "Верно! Ты победил монстра";
    protected static final String LOSE_MESSAGE = "Ты проиграл эту битву!";

    protected int x;
    protected int y;
    protected String icon = DEFAULT_MONSTER_ICON;

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

    public boolean generateMonsterTask(int key) {
        Scanner input = new Scanner(System.in);
        int num1 = rand.nextInt(-100, 101);
        int num2 = rand.nextInt(-100, 101);
        int sum = num1 + num2;
        System.out.println("Реши пример: " + num1 + " + " + num2 + " = ?");
        int answer = input.nextInt();
        if (sum == answer) {
            System.out.println(WIN_MESSAGE);
            return true;
        }
        System.out.println(LOSE_MESSAGE);
        return false;
    }
}
