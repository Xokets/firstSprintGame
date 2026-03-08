package ru.innovationcampus.vsu26.xokets.first_sprint_game;

import java.util.Random;
import java.util.Scanner;

public class BigMonster extends Monster {

    public static final String DEFAULT_BIG_MONSTER_ICON = "\uD83E\uDDDB";
    private final double EPSILON = 0.1;

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
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        switch (key) {
            case 1 -> {
                int num1 = rand.nextInt(-100, 101);
                int num2 = rand.nextInt(-100, 101);
                final int sum = num1 + num2;
                System.out.println("Реши пример: " + num1 + " + " + num2 + " = ?");
                int answer = input.nextInt();
                if (sum == answer) {
                    System.out.println(WIN_MESSAGE);
                    return true;
                }
                System.out.println(LOSE_MESSAGE);
                return false;
            }
            case 2 -> {
                int num1 = rand.nextInt(-200, 201);
                int num2 = rand.nextInt(1, 201);
                final double result = (double) num1 / num2;
                System.out.printf("Реши пример: %s : %s = ? (Ответ округли до десятых)", num1, num2);
                double answer = input.nextDouble();
                if (Math.abs(result - answer) < EPSILON) {
                    System.out.println(WIN_MESSAGE);
                    return true;
                }
                System.out.println(LOSE_MESSAGE);
                return false;
            }
            case 3 -> {
                final int result = rand.nextInt(100, 301);
                int num = result * result;
                System.out.printf("Реши пример: √%s = ?", num);
                int answer = input.nextInt();
                if (answer == result) {
                    System.out.println(WIN_MESSAGE);
                    return true;
                }
                System.out.println(LOSE_MESSAGE);
                return false;
            }
            case 4 -> {
                final int firstIndex = rand.nextInt(-10, 11);
                final int secondIndex = rand.nextInt(-10, 11);
                final int a, b, c, d;
                int[] numbers = new int[4];
                for (int number : numbers) {
                    number = rand.nextInt(-20, 21);
                }
                a = numbers[0];
                b = numbers[1];
                c = numbers[2];
                d = numbers[3];
                final int result = firstIndex * (a + b) + secondIndex * (c - d) - (b - d);
                System.out.printf("Реши пример: %s(%s + %s) + %s(%s - %s) - (%s + %s) = ?",
                        firstIndex,
                        a,
                        b,
                        secondIndex,
                        c,
                        d,
                        b,
                        d);
                int answer = input.nextInt();
                if (result == answer) {
                    System.out.println(WIN_MESSAGE);
                    return true;
                } else {
                    return false;
                }
            }
        }
        throw new IllegalStateException("Ошибка валидации уровня сложности");
    }
}
