package ru.innovationcampus.vsu26.xokets.first_sprint_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;

public class WordGame {

    private final List<String> words = new ArrayList<>();

    private static final Random rand = new Random();

    public static final short RIGHT_ANSWERS_COUNT = 3;
    public static final long TIME_TO_SHOW = 250L;

    public boolean start() {
        final Scanner input = new Scanner(System.in);
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
        words.add("abstract");
        words.add("implements");
        words.add("public static void main (String[] args)");
        words.add("BrokenBarrierException");
        words.add("switch");
        words.add("ExecutorService");
        words.add("extends");
        words.add("synchronized");
        words.add("volatile");

        int rightAnswers = 0;
        int wrongAnswers = 0;
        while (rightAnswers < RIGHT_ANSWERS_COUNT) {
            final String word = words.get(rand.nextInt(words.size()));
            System.out.println(word);
            try {
                Thread.sleep(TIME_TO_SHOW);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("\n\n\n\n\n\nЧитерить плохо\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            String answer;
            System.out.println("Введите слово, которое было показано");
            answer = input.nextLine();
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (word.equals(answer)) {
                rightAnswers++;
            } else {
                wrongAnswers++;
            }
        }
        return rightAnswers > wrongAnswers;
    }
}
