package com.sp.mastermind;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class CodeBreaker {

    private static final String STARTUP_TEXT = "Unterstützte Eingaben sind die Buchstaben b, w und das Zeichen \".\" .";
    private int[] code;
    private String successString;

    CodeBreaker() {
        code = new int[MastermindUtils.CODE_SIZE];
        for (int i = 0; i < MastermindUtils.CODE_SIZE; i++) {
            code[i] = i + 1;
        }
        successString = String.join("", Collections.nCopies(MastermindUtils.CODE_SIZE, "b"));
    }

    public void loop() {
        System.out.println(STARTUP_TEXT);
        System.out.print(arrayAsString());
        boolean isRunning = true;
        while (isRunning) {
            String userInput = getInput();
            if (userInput.equals(successString)) {
                isRunning = false;
            } else {
                changeCode();
                System.out.println(arrayAsString());
            }
        }
    }

    private String arrayAsString() {
        return Arrays.toString(code).replaceAll("\\[|\\]|,|\\s", "");
    }

    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.length() > MastermindUtils.CODE_SIZE) {
            System.out.println(MastermindUtils.INPUT_TOO_LONG_TEXT);
        }
        return input;
    }

    private void changeCode() {
        Random random = new Random();
        code = new int[MastermindUtils.CODE_SIZE];
        for (int i = 0; i < MastermindUtils.CODE_SIZE; i++) {
            int temp = random.nextInt(MastermindUtils.NUMBER_OF_COLORS) + 1;
            while (MastermindUtils.arrayContains(temp, code)) {
                temp = random.nextInt(MastermindUtils.NUMBER_OF_COLORS) + 1;
            }
            code[i] = temp;
        }
    }
}