package ru.innovationcampus.vsu26.xokets.first_sprint_game;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Random rand = new Random();
    public static final int START_LOC = 3;
    public static final String YES_ANSWER = "ДА";
    public static final String NO_ANSWER = "НЕТ";
    public static final String PERSON = "  🧙‍♀️  ";
    public static final String MONSTER = "  🧟‍♂️  ";
    public static final String CASTLE = "  🏰  ";
    public static final int SIZE = 25;
    public static final int START_LIVES = 3;

    private static final String leftBlock = " | ";
    private static final String rightBlock = " |";
    private static final String wall = " + —— + —— + —— + —— + —— + ";

    private static final Scanner input = new Scanner(System.in);


    public static void main(String... args) {
        final String answer;

        System.out.println("Готовы ли вы начать игру? (Да/Нет)");

        answer = input.nextLine().toUpperCase();
        switch (answer) {
            case "ДА" -> {

                int xPersonLoc = START_LOC;
                int yPersonLoc = START_LOC;
                int step = 0;
                int xCastleLoc = rand.nextInt(1, (SIZE + 1));
                int yCastleLoc = rand.nextInt(1, (SIZE + 1));
                int personLive = START_LIVES;

                System.out.println("Выберите сложность игры (Введите число от 1 до 5)");
                int difficulty = input.nextInt();
                if (!(difficulty > 0 && difficulty <= 5)) break;
                System.out.println("Сложность установлена на " + difficulty);
                while ((personLive > 0) && !(xPersonLoc == xCastleLoc && yPersonLoc == yCastleLoc)) {
//                    for (int y = 1; y <= SIZE; y++) {
//                        System.out.println(wall);
//                        for (int x = 1; x <= SIZE; x++) {
//                            System.out.print(leftBlock);
//
//                            if (yPersonLoc == y && xPersonLoc == x) {
//                                System.out.print(PERSON);
//                            } else if (yCastleLoc == y && xCastleLoc == x) {
//                                System.out.println(CASTLE);
//                            } else {
//                                System.out.print("  ");
//                            }
//                        }
//                        System.out.print(rightBlock);
//                    }
//                    System.out.println(wall);
//                    System.out.println("Выполните ход");
//                    input.nextInt();
                    String[] board = new String[SIZE * SIZE];
                }
            }
            case "НЕТ" -> System.out.println("Чем тебе игра-то не угодила?");
            default -> {
                System.out.println("Ваш ответ некоректный. Попробуйте ещё раз");
                main();
            }
        }
    }
//    String begin = "|    | |";
//    String end = " |    |";
//    String full = begin + monster + end;
}