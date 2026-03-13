package ru.innovationcampus.vsu26.xokets.first_sprint_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordGame {

    private static final List<String> words = new ArrayList<>();
    private static final Random rand = new Random();
    public static final short RIGHT_ANSWERS_COUNT = 5;

    public static boolean start() {

        Scanner input = new Scanner(System.in);

        words.add("Thread");
        words.add("transient");
        words.add("int");
        words.add("final");
        words.add("HashMap");
        words.add("static");
        words.add("new");
        words.add("InputStream");
        words.add("StringBuffer");
        words.add("long");
        words.add("Set");
        words.add("Object");
        words.add("InterruptedException");
        words.add("class");
        words.add("void");
        words.add("Scanner");
        words.add("File");
        words.add("InputStreamReader");
        words.add("IOException");

        int rightAnswers = 0;
        int wrongAnswers = 0;
        String word;
        while (rightAnswers < RIGHT_ANSWERS_COUNT) {
            word = words.get(rand.nextInt(words.size()));
            System.out.println("Введите слово: \"" + word + "\"");
            String answer = input.nextLine();
            if (word.equals(answer)) {
                rightAnswers++;
            } else {
                wrongAnswers++;
            }
        }
        try {
            if ((rightAnswers / wrongAnswers) > 1) {
                return true;
            }
        } catch (ArithmeticException e) {
            return true;
        }
        return false;
    }
}
