package ru.innovationcampus.vsu26.xokets.first_sprint_game.monster;

import java.util.Locale;
import java.util.Scanner;

public class BigMonster extends Monster {

    public static final String DEFAULT_BIG_MONSTER_ICON = "\uD83E\uDDDB";

    public BigMonster(int x, int y) {
        super(x, y);
        icon = DEFAULT_BIG_MONSTER_ICON;
    }

    public BigMonster() {
        this(0, 0);
    }

    public BigMonster(int boardSize) {
        super(boardSize);
        icon = DEFAULT_BIG_MONSTER_ICON;
    }

    @Override
    public boolean generateMonsterTask(int key) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);
        switch (key) {
            case 1 -> {
                int num1 = rand.nextInt(-100, 101);
                int num2 = rand.nextInt(-100, 101);
                final int sum = num1 + num2;
                System.out.println("Реши пример: " + num1 + " + " + num2 + " = ?\n");
                int answer = input.nextInt();
                if (sum == answer) {
                    System.out.println(WIN_MESSAGE);
                    isDefeated = true;
                    return true;
                }
                System.out.println(LOSE_MESSAGE);
                return false;
            }
            case 2 -> {
                int num1 = rand.nextInt(-200, 201);
                int num2 = rand.nextInt(1, 201);
                final double result = (double) num1 / num2;
                System.out.printf("Реши пример: %s : %s = ? (Ответ округли до целых)\n", num1, num2);
                double answer = input.nextInt();
                if (answer == (int) Math.round(result)) {
                    System.out.println(WIN_MESSAGE);
                    isDefeated = true;
                    return true;
                }
                System.out.println(LOSE_MESSAGE);
                return false;
            }
            case 3 -> {
                final int result = rand.nextInt(100, 301);
                int num = result * result;
                System.out.printf("Реши пример: √%s = ?\n", num);
                int answer = input.nextInt();
                if (answer == result) {
                    System.out.println(WIN_MESSAGE);
                    isDefeated = true;
                    return true;
                }
                System.out.println(LOSE_MESSAGE);
                return false;
            }
            case 4 -> {
                int a = rand.nextInt(-1_000, 1_001);
                int b = rand.nextInt(-1_000, 1_001);
                final int result = a - b;
                System.out.printf("Реши пример: %s - %s\n", a, b);
                int answer = input.nextInt();
                if (result == answer) {
                    System.out.println(WIN_MESSAGE);
                    isDefeated = true;
                    return true;
                }
                System.out.println(LOSE_MESSAGE);
                return false;
            }
            case 5 -> {
                int a = rand.nextInt(-1_000, 1_001);
                int b = rand.nextInt(-1_000, 1_001);
                int c = rand.nextInt(-10, 11);
                final int result = (a - b) * c;
                System.out.printf("Реши пример: (%s - %s) * %s\n", a, b, c);
                int answer = input.nextInt();
                if (result == answer) {
                    System.out.println(WIN_MESSAGE);
                    isDefeated = true;
                    return true;
                }
                System.out.println(LOSE_MESSAGE);
                return false;
            }
        }
        throw new IllegalStateException("Ошибка валидации уровня сложности");
    }
}
