package ru.innovationcampus.vsu26.xokets.first_sprint_game.monster;

import java.util.Scanner;

public class SmallMonster extends Monster {

    public static final String DEFAULT_SMALL_MONSTER_ICON = "\uD83E\uDDDD\u200D";

    public SmallMonster(int x, int y) {
        super(x, y);
        icon = DEFAULT_SMALL_MONSTER_ICON;
    }

    public SmallMonster() {
        super();
        icon = DEFAULT_SMALL_MONSTER_ICON;
    }

    public SmallMonster(int boardSize) {
        super(boardSize);
        icon = DEFAULT_SMALL_MONSTER_ICON;
    }

    @Override
    public boolean generateMonsterTask(int key) {
        Scanner input = new Scanner(System.in);
        int num1 = rand.nextInt(0, 11);
        int num2 = rand.nextInt(0, 11);
        int result = num1 * num2;
        System.out.println("Реши пример: " + num1 + " * " + num2 + " = ?");
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
