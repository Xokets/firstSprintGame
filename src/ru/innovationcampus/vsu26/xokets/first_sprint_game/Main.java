package ru.innovationcampus.vsu26.xokets.first_sprint_game;

import java.util.Scanner;

public class Main {

    public static final int START_LOC = 0;
    public static final String YES_ANSWER = "ДА";
    public static final String NO_ANSWER = "НЕТ";

    private static final Scanner input = new Scanner(System.in);


    public static void main(String... args) {
        final String answer;

        System.out.println("Готовы ли вы начать игру? (Да/Нет)");

        answer = input.nextLine().toUpperCase();
        switch (answer) {
            case "ДА":
                int xLoc = START_LOC;
                int yLoc = START_LOC;
                int step = 0;
                int difficulty;
                break;
            case "НЕТ":
                System.out.println("Чем тебе игра то не угодила?");
                break;
            default:
                System.out.println("Ваш ответ некоректный. Попробуйте ещё раз");
                main();
        }
    }

    private void startGame() {
        System.out.println("Игра начата!");
        System.out.println("Выберите уровень сложности (Введите: 1-5)");
        int difficulty = input.nextInt();
    }

//    private boolean changeCoords(int x, int y) {
//
//    }
}