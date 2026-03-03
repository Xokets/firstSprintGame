package ru.innovationcampus.vsu26.xokets.first_sprint_game;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Random rand = new Random();
    public static final int START_LOC = 3;
    public static final String YES_ANSWER = "ДА";
    public static final String NO_ANSWER = "НЕТ";
    public static final String PERSON = "🧙‍♀️";
    public static final String MONSTER = "🧟‍♂️";
    public static final String CASTLE = "🏰";
    public static final String VOID = " ";
    public static final int SIZE = 5;
    public static final int START_LIVES = 3;

    private static final String leftBlock = "| ";
    private static final String rightBlock = " | ";
    private static final String wall = "+ —— + —— + —— + —— + —— + ";

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
                int yCastleLoc = rand.nextInt(1, SIZE);
                int xCastleLoc = rand.nextInt(1, SIZE);
                int personLive = START_LIVES;

                System.out.println("Выберите сложность игры (Введите число от 1 до 5)");
                int difficulty = input.nextInt();
                if (!(difficulty > 0 && difficulty <= 5)) break;
                System.out.println("Сложность установлена на " + difficulty);
                String[][] board = new String[SIZE][SIZE];
                for (int y = 0; y < SIZE; y++) {
                    for (int x = 0; x < SIZE; x++) {
                        board[y][x] = VOID;
                    }
                }
                board[xPersonLoc][yPersonLoc] = PERSON;
                board[xCastleLoc][yCastleLoc] = CASTLE;
                while (personLive > 0) {
                    printBoard(board);
                    if (board[yPersonLoc][xPersonLoc].equals(CASTLE)) {
                        System.out.println("Вы победили!");
                        step++;
                        System.out.println("Кол-во ходов " + step);
                        return;
                    }

                }
            }
            case "НЕТ" -> System.out.println("Чем тебе игра-то не угодила?");
            default -> {
                System.out.println("Ваш ответ некоректный. Попробуйте ещё раз");
                main();
            }
        }
    }
    private static void printSlot(String arg) { System.out.print(arg + rightBlock); }
    private static void printSlot() { printSlot("  "); }

    private static boolean generateMonsterTask(int key) {
        if (key == 1) {
            int num1 = rand.nextInt(-100, 101);
            int num2 = rand.nextInt(-100, 101);
            int sum = num1 + num2;
            System.out.println("Реши пример: " + num1 + " + " + num2 + " = ?");
            int answer = input.nextInt();
            if (sum == answer) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            }
            System.out.println("Ты проиграл эту битву!");
            return false;
        } else {
            return false;
        }
    }

    private static void printBoard(String[][] board) {
        for (int y = 0; y < SIZE; y++) {
            System.out.println("\n" + wall);
            System.out.print(leftBlock);
            for (int x = 0; x < SIZE; x++) {
                switch (board[x][y]) {
                    case VOID -> printSlot();
                    case PERSON -> printSlot(PERSON);
                    case MONSTER -> printSlot(MONSTER);
                    case CASTLE -> printSlot(CASTLE);
                }
            }
        }
        System.out.println("\n" + wall);
    }
    private static void move(String[][] board, int xPersonLoc, int yPersonLoc) {
        //Ввод координат
        System.out.printf("Введите новое значение для x (текущее: %s)\n", xPersonLoc);
        int x = input.nextInt();
        int y = 0;
        boolean isCorrectX = x >= 0 && x < SIZE && Math.abs(xPersonLoc - x) == 1;
        boolean isCorrectY = y >= 0 && y < SIZE && Math.abs(yPersonLoc - y) == 1;
        if (x != xPersonLoc && isCorrectX) {
            System.out.println("Ход корректный");
            xPersonLoc = x;
        } else {
            System.out.printf("Введите новое значение для y (текущее: %s)\n", yPersonLoc);
            input.nextInt();
            if (isCorrectY) {

            }
        }
    }
}