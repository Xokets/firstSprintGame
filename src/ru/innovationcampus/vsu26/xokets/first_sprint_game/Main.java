package ru.innovationcampus.vsu26.xokets.first_sprint_game;

import ru.innovationcampus.vsu26.xokets.first_sprint_game.monster.BigMonster;
import ru.innovationcampus.vsu26.xokets.first_sprint_game.monster.Monster;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final Random rand = new Random();
    public static final String CASTLE = "🏰";
    public static final String VOID = "  ";
    public static final int SIZE = 5;

    private static final Scanner input = new Scanner(System.in);
    private static final String LEFT_BLOCK = "| ";
    private static final String RIGHT_BLOCK = " | ";
    private static final String WALL = "+ —— + —— + —— + —— + —— + ";

    private static final String INVALID_TURN = "Ход некорректный";


    public static void main(String... args) {
        final int monstersCount = SIZE * SIZE - SIZE - 5;
        Person person = new Person(SIZE);
        final String answer;

        System.out.println("Готовы ли вы начать игру? (Да/Нет)");

        answer = input.nextLine().toUpperCase();
        switch (answer) {
            case "ДА" -> {
                Board board = new Board();
                board.game(1);
//
//                int step = 0;
//                final int yCastleLoc = SIZE - 1;
//                final int xCastleLoc = rand.nextInt(0, SIZE);
//
//                System.out.println("Выберите сложность игры (Введите число от 1 до 5)");
//                int difficulty = input.nextInt();
//                if (!(difficulty > 0 && difficulty <= 5)) break;
//                System.out.println("Сложность установлена на " + difficulty);
//                String[][] board = new String[SIZE][SIZE];
//                for (int x = 0; x < SIZE; x++) {
//                    for (int y = 0; y < SIZE; y++) {
//                        board[x][y] = VOID;
//                    }
//                }
//                board[xCastleLoc][yCastleLoc] = CASTLE;
//                Monster[] monsters = new Monster[monstersCount];
//                Monster test;
//                for (int i = 0; i < monstersCount; i++) {
//                    if (rand.nextInt(3) < 2) {
//                        test = new Monster(SIZE);
//                        if (!(board[test.getX()][test.getY()].equals(VOID))) continue;
//                        monsters[i] = test;
//                        board[test.getX()][test.getY()] = Monster.DEFAULT_MONSTER_ICON;
//                    } else {
//                        test = new BigMonster(SIZE);
//                        if (!(board[test.getX()][test.getY()].equals(VOID))) continue;
//                        monsters[i] = test;
//                        board[test.getX()][test.getY()] = BigMonster.DEFAULT_BIG_MONSTER_ICON;
//                    }
//                }
//                //Цикл отвечающий за работу игры (катка)
//                while (person.getLive() > 0) {
//                    board[person.getX()][person.getY()] = person.getIcon();
//                    printBoard(board, person);
//                    System.out.println("Введите новую координату X, затем Y");
//                    int x = input.nextInt();
//                    int y = input.nextInt();
//                    if (person.isMoveCorrect(x, y)) {
//                        if (board[x][y].equals(VOID)) {
//                            movePersonOnBoard(board, person, x, y);
//                            step++;
//                            continue;
//                        }
//                    }
//                    if (person.getX() == xCastleLoc && person.getY() == yCastleLoc) {
//                        printBoard(board, person);
//                        System.out.println("Вы победили!");
//                        System.out.println("Кол-во ходов " + step);
//                        return;
//                    }
//                    for (Monster monster : monsters) {
//                        if (!person.isMoveCorrect(x, y)) {
//                            System.out.println(INVALID_TURN);
//                            break;
//                        }
//                        if (monster == null) continue;
//                        if (monster.isDefeated()) continue;
//                        if (!(monster.conflictPerson(x, y))) continue;
//                        if (!(monster.generateMonsterTask(difficulty))) {
//                            person.hit();
//                            break;
//                        }
//                        movePersonOnBoard(board, person, x, y);
//
//                        break;
//                    }
//                }
//                System.out.println("Вы погибли!");
            }
            case "НЕТ" -> System.out.println("Чем тебе игра-то не угодила? 😡");
            default -> System.out.println("Ответ некорректный");
        }
    }
//    private static void printSlot(String arg) { System.out.print(arg + RIGHT_BLOCK); }
//    private static void printSlot() { printSlot(VOID); }
//
//    private static void printBoard(String[][] board, Person person) {
//
//        for (int y = SIZE - 1; y >= 0; y--) {
//            System.out.println("\n" + WALL);
//            System.out.print(LEFT_BLOCK);
//            for (int x = 0; x < SIZE; x++) {
//                switch (board[x][y]) {
//                    case VOID -> printSlot();
//                    case Monster.DEFAULT_MONSTER_ICON -> printSlot(Monster.DEFAULT_MONSTER_ICON);
//                    case BigMonster.DEFAULT_BIG_MONSTER_ICON -> printSlot(BigMonster.DEFAULT_BIG_MONSTER_ICON);
//                    case CASTLE -> printSlot(CASTLE);
//                    case Person.DEFAULT_PERSON_ICON -> printSlot(Person.DEFAULT_PERSON_ICON);
//                }
//            }
//        }
//        System.out.println("\n" + WALL);
//        System.out.println("Жизни: " + person.getLive());
//        System.out.printf("\nX = %s\nY = %s\n", person.getX(), person.getY());
//    }
//    private static void movePersonOnBoard(String[][] board, Person person, int x, int y) {
//        board[person.getX()][person.getY()] = VOID;
//        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE) {
//            person.move(x, y);
//        } else {
//            System.out.println(INVALID_TURN);
//        }
//    }
}