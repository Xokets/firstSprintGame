package ru.innovationcampus.vsu26.xokets.first_sprint_game;

public class Monster {

    public static final String DEFAULT_MONSTER_ICON = "\uD83E\uDDDF";

    private int x;
    private int y;
    private String icon = DEFAULT_MONSTER_ICON;

    public Monster(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Monster() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
