package ru.innovationcampus.vsu26.xokets.first_sprint_game;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Random rand = new Random();
    public static final String CASTLE = "🏰";
    public static final String VOID = "  ";
    public static final int SIZE = 5;

    private static final Scanner input = new Scanner(System.in);
    private static final String leftBlock = "| ";
    private static final String rightBlock = " | ";
    private static final String wall = "+ —— + —— + —— + —— + —— + ";


    public static void main(String... args) {
        Person person = new Person(SIZE);
        final String answer;

        System.out.println("Готовы ли вы начать игру? (Да/Нет)");

        answer = input.nextLine().toUpperCase();
        switch (answer) {
            case "ДА" -> {

                int step = 0;
                final int yCastleLoc = SIZE - 1;
                final int xCastleLoc = rand.nextInt(0, SIZE);

                System.out.println("Выберите сложность игры (Введите число от 1 до 5)");
                int difficulty = input.nextInt();
                if (!(difficulty > 0 && difficulty <= 5)) break;
                System.out.println("Сложность установлена на " + difficulty);
                String[][] board = new String[SIZE][SIZE];
                for (int x = 0; x < SIZE; x++) {
                    for (int y = 0; y < SIZE; y++) {
                        board[x][y] = VOID;
                    }
                }
                board[xCastleLoc][yCastleLoc] = CASTLE;
                while (person.getLive() > 0) {
                    board[person.getX()][person.getY()] = person.getIcon();
                    printBoard(board, person);
                    System.out.println("Введите новую координату X, затем Y");
                    int x = input.nextInt();
                    int y = input.nextInt();
                    if (person.isMoveCorrect(x, y)) {
                        movePersonOnBoard(board, person, x, y);
                        step++;
                    } else {
                        System.out.println("Ход некорректный");
                        continue;
                    }
                    if (person.getX() == xCastleLoc && person.getY() == yCastleLoc) {
                        printBoard(board, person);
                        System.out.println("Вы победили!");
                        System.out.println("Кол-во ходов " + step);
                        return;
                    }

                }
            }
            case "НЕТ" -> System.out.println("Чем тебе игра-то не угодила? 😡");
            default -> System.out.println("Ответ некорректный");
        }
    }
    private static void printSlot(String arg) { System.out.print(arg + rightBlock); }
    private static void printSlot() { printSlot(VOID); }

    private static boolean generateMonsterTask(int difficulty) {
        Scanner input = new Scanner(System.in);
        if (difficulty == 1) {
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

    private static void printBoard(String[][] board, Person person) {

        for (int y = SIZE - 1; y >= 0; y--) {
            System.out.println("\n" + wall);
            System.out.print(leftBlock);
            for (int x = 0; x < SIZE; x++) {
                switch (board[x][y]) {
                    case VOID -> printSlot();
                    case Monster.DEFAULT_MONSTER_ICON -> printSlot(Monster.DEFAULT_MONSTER_ICON);
                    case CASTLE -> printSlot(CASTLE);
                    case Person.DEFAULT_PERSON_ICON -> printSlot(Person.DEFAULT_PERSON_ICON);
                }
            }
        }
        System.out.println("\n" + wall);
        System.out.println("Жизни: " + person.getLive());
        System.out.printf("\nX = %s\nY = %s\n", person.getX(), person.getY());
    }
    private static void movePersonOnBoard(String[][] board, Person person, int x, int y) {
        board[person.getX()][person.getY()] = VOID;
        person.move(x, y);
    }
}