package com.sp.mastermind;

import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class CodeMaker {

    private static final String STARTUP_TEXT = "Unterstützte Eingaben sind die Zahlen 1 bis 6.";
    private static final String SUCCESS_TEXT = "Die richtige Kombination wurde gefunden.";
    private int[] code;
    private String successString;

    CodeMaker() {
        Random random = new Random();
        code = new int[MastermindUtils.CODE_SIZE];
        for (int i = 0; i < MastermindUtils.CODE_SIZE; i++) {
            int temp = random.nextInt(MastermindUtils.NUMBER_OF_COLORS) + 1;
            while (MastermindUtils.arrayContains(temp, code)) {
                temp = random.nextInt(MastermindUtils.NUMBER_OF_COLORS) + 1;
            }
            code[i] = temp;
        }
        successString = String.join("", Collections.nCopies(MastermindUtils.CODE_SIZE, "b"));
    }

    public void loop() {
        System.out.println(STARTUP_TEXT);
        boolean isRunning = true;
        while (isRunning) {
            int[] userInput = getInput();
            String resultOutput = evaluateInput(userInput);
            System.out.println(resultOutput);
            if (resultOutput.equals(successString)) {
                isRunning = false;
                System.out.println(SUCCESS_TEXT);
            }
        }
    }

    private int[] getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.length() > MastermindUtils.CODE_SIZE) {
            System.out.println(MastermindUtils.INPUT_TOO_LONG_TEXT);
        }
        try {
            int[] result = new int[MastermindUtils.CODE_SIZE];
            for (int i = 0; i < MastermindUtils.CODE_SIZE; i++) {
                int currentColor = Integer.parseInt(String.valueOf(input.charAt(i)));
                if (currentColor > 6) {
                    System.out.println(MastermindUtils.NOT_SUPPORTED_INPUT_TEXT);
                    return getInput();
                }
                result[i] = currentColor;
            }
            return result;
        } catch (NumberFormatException numberFormatException) {
            System.out.println(MastermindUtils.NOT_SUPPORTED_INPUT_TEXT);
            return getInput();
        }
    }

    private String evaluateInput(int[] userInput) {
        int blackPegs = 0;
        int whitePegs = 0;
        for (int i = 0; i < MastermindUtils.CODE_SIZE; i++) {
            if (userInput[i] == code[i]) {
                blackPegs++;
            } else if (MastermindUtils.arrayContains(userInput[i], code)) {
                whitePegs++;
            }
        }
        return buildString(blackPegs, whitePegs);
    }

    private String buildString(int blackPegs, int whitePegs) {
        int dots = MastermindUtils.CODE_SIZE - blackPegs - whitePegs;
        return String.join("", Collections.nCopies(blackPegs, "b")) +
                String.join("", Collections.nCopies(whitePegs, "w")) +
                String.join("", Collections.nCopies(dots, "."));
    }
}