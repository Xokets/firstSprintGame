//package ru.innovationcampus.vsu26.xokets.first_sprint_game;
//
//import java.sql.SQLOutput;
//import java.util.Random;
//import java.util.Scanner;
//
//public class Main {
//
//    private static final Random rand = new Random();
//    public static final int START_LOC = 3;
//    public static final String YES_ANSWER = "ДА";
//    public static final String NO_ANSWER = "НЕТ";
//    public static final String PERSON = "🧙‍♀️";
//    public static final String MONSTER = "🧟‍♂️";
//    public static final String CASTLE = "🏰";
//    public static final String VOID = "  ";
//    public static final int SIZE = 5;
//    public static final int START_LIVES = 3;
//
//    private static final String leftBlock = " | ";
//    private static final String rightBlock = " |";
//    private static final String wall = " + —— + —— + —— + —— + —— + ";
//
//    private static final Scanner input = new Scanner(System.in);
//
//
//    public static void main(String... args) {
//        final String answer;
//
//        System.out.println("Готовы ли вы начать игру? (Да/Нет)");
//
//        answer = input.nextLine().toUpperCase();
//        switch (answer) {
//            case "ДА" -> {
//
//                int xPersonLoc = START_LOC;
//                int yPersonLoc = START_LOC;
//                int step = 0;
//                int yCastleLoc = rand.nextInt(1, SIZE);
//                int xCastleLoc = rand.nextInt(1, SIZE);
//                int personLive = START_LIVES;
//
//                System.out.println("Выберите сложность игры (Введите число от 1 до 5)");
//                int difficulty = input.nextInt();
//                if (!(difficulty > 0 && difficulty <= 5)) break;
//                System.out.println("Сложность установлена на " + difficulty);
//                String[][] board = new String[SIZE][SIZE];
//                for (int y = 0; y < SIZE; y++) {
//                    for (int x = 0; x < SIZE; x++) {
//                        board[y][x] = VOID;
//                    }
//                }
//                board[xPersonLoc][yPersonLoc] = PERSON;
//                board[xCastleLoc][yCastleLoc] = CASTLE;
//                while ((personLive > 0) && !(xPersonLoc == xCastleLoc && yPersonLoc == yCastleLoc)) {
//                    System.out.println(wall);
//                    for (int y = 0; y < SIZE; y++) {
//                        if (y > 0 ) System.out.println();
//                        for (int x = 0; x < SIZE; x++) {
//                            switch (board[x][y]) {
//                                case VOID -> printSlot();
//                                case PERSON -> printSlot(PERSON);
//                                case MONSTER -> printSlot(MONSTER);
//                                case CASTLE -> printSlot(CASTLE);
//                            }
//                        }
//                    }
//                    System.out.println("Введите число для новой координаты X");
//                    int x = input.nextInt();
//                    if ((x - xPersonLoc))
//
//                }
//            }
//            case "НЕТ" -> System.out.println("Чем тебе игра-то не угодила?");
//            default -> {
//                System.out.println("Ваш ответ некоректный. Попробуйте ещё раз");
//                main();
//            }
//        }
//    }
//    private static void printSlot(String arg) { System.out.print(leftBlock + arg + rightBlock); }
//    private static void printSlot() { printSlot("  "); }
//
////    String begin = "|    | |";
////    String end = " |    |";
////    String full = begin + monster + end;
//}