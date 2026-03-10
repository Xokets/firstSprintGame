package ru.innovationcampus.vsu26.xokets.first_sprint_game;

import ru.innovationcampus.vsu26.xokets.first_sprint_game.monster.BigMonster;
import ru.innovationcampus.vsu26.xokets.first_sprint_game.monster.Monster;

import java.util.Random;
import java.util.Scanner;

public class Board {

    private static final Random rand = new Random();
    public static final String CASTLE = "🏰";
    public static final String VOID = "  ";
    public static final int DEFAULT_SIZE = 5;
    private static final Scanner input = new Scanner(System.in);
    private static final String LEFT_BLOCK = "| ";
    private static final String RIGHT_BLOCK = " | ";
    private static final String WALL = "+ —— + —— + —— + —— + —— + ";

    private static final String INVALID_TURN = "Ход некорректный";

    private int size;
    private int step;
    private final int castleY = size - 1;
    private final int castleX = rand.nextInt(0, size);
    private String[][] board;

    public Board() {
        this(DEFAULT_SIZE);
    }

    public Board(int size) {
        this.size = size;
        step = 0;
        board = new String[size][size];
    }

    public int getSize() {
        return size;
    }

    public void game(int difficulty) {

        //Объявление нужных переменных
        final Person person = new Person(size);
        final int monstersCount = size * size - size - 5;

        board[castleX][castleY] = CASTLE;

        //Заполнение массива "пустотой"
        String[][] board = new String[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                board[x][y] = VOID;
            }
        }

        //Добавление монстров в массив
        Monster[] monsters = new Monster[monstersCount];
        Monster test;
        for (int i = 0; i < monstersCount; i++) {
            if (rand.nextInt(3) < 2) {
                test = new Monster(size);
                if (!(board[test.getX()][test.getY()].equals(VOID))) continue;
                monsters[i] = test;
                board[test.getX()][test.getY()] = Monster.DEFAULT_MONSTER_ICON;
            } else {
                test = new BigMonster(size);
                if (!(board[test.getX()][test.getY()].equals(VOID))) continue;
                monsters[i] = test;
                board[test.getX()][test.getY()] = BigMonster.DEFAULT_BIG_MONSTER_ICON;
            }
        }

        while (person.getLive() > 0) {
            board[person.getX()][person.getY()] = person.getIcon();
            printBoard(person);
            System.out.println("Введите новую координату X, затем Y");
            int x = input.nextInt();
            int y = input.nextInt();
            if (person.isMoveCorrect(x, y)) {
                if (board[x][y].equals(VOID)) {
                    movePersonOnBoard(size, board, person, x, y);
                    step++;
                    continue;
                }
            }
            if (person.getX() == castleX && person.getY() == castleY) {
                printBoard(person);
                System.out.println("Вы победили!");
                System.out.println("Кол-во ходов " + step);
                return;
            }
            for (Monster monster : monsters) {
                if (!person.isMoveCorrect(x, y)) {
                    System.out.println(INVALID_TURN);
                    break;
                }
                if (monster == null) continue;
                if (monster.isDefeated()) continue;
                if (!(monster.conflictPerson(x, y))) continue;
                if (!(monster.generateMonsterTask(difficulty))) {
                    person.hit();
                    break;
                }
                movePersonOnBoard(size, board, person, x, y);

                break;
            }
        }
        System.out.println("Вы погибли!");

    }

    private static void printSlot(String arg) {
        System.out.print(arg + RIGHT_BLOCK);
    }

    private static void printSlot() {
        printSlot(VOID);
    }

    private void printBoard(Person person) {

        for (int y = size - 1; y >= 0; y--) {
            System.out.println("\n" + WALL);
            System.out.print(LEFT_BLOCK);
            for (int x = 0; x < size; x++) {
                switch (board[x][y]) {
                    case VOID -> printSlot();
                    case Monster.DEFAULT_MONSTER_ICON -> printSlot(Monster.DEFAULT_MONSTER_ICON);
                    case BigMonster.DEFAULT_BIG_MONSTER_ICON -> printSlot(BigMonster.DEFAULT_BIG_MONSTER_ICON);
                    case CASTLE -> printSlot(CASTLE);
                    case Person.DEFAULT_PERSON_ICON -> printSlot(Person.DEFAULT_PERSON_ICON);
                }
            }
        }
        System.out.println("\n" + WALL);
        System.out.println("Жизни: " + person.getLive());
    }

    private static void movePersonOnBoard(int size, String[][] board, Person person, int x, int y) {
        board[person.getX()][person.getY()] = VOID;
        if (x >= 0 && x < size && y >= 0 && y < size) {
            person.move(x, y);
        } else {
            System.out.println(INVALID_TURN);
        }
    }
}