package ru.innovationcampus.vsu26.xokets.first_sprint_game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final int SIZE = 5;
    public static final String INVALID_ANSWER = "Ответ некорректный";

    public static void main(String... args) {

        final Scanner input = new Scanner(System.in);
        final String answer;

        System.out.println("Готовы ли вы начать игру? (Да/Нет)");

        answer = input.nextLine().toUpperCase();
        switch (answer) {
            case "ДА" -> {
                Board board = new Board(SIZE);
                System.out.println("Выберите сложность игры (Введите число от 1 до 5)");
                int difficulty;
                while (true) {
                    difficulty = input.nextInt();
                    if (!(difficulty > 0 && difficulty <= 5)) {
                        System.out.println(INVALID_ANSWER);
                        continue;
                    }
                    break;
                }
                System.out.println("Сложность установлена на " + difficulty);
                board.game(difficulty);
            }
            case "НЕТ" -> System.out.println("Чем тебе игра-то не угодила? 😡");
            default -> System.out.println(INVALID_ANSWER);
        }
    }
}