package com.sp.mastermind;

import java.util.Collections;
import java.util.Random;

public class CodeMaker {

    private static final String INPUT_TOO_LONG_TEXT = "";
    private static final String NOT_SUPPORTED_INPUT_TEXT = "";
    private static final int CODE_SIZE = 4;
    private static final int NUMBER_OF_COLORS = 6;
    private int[] code = new int[CODE_SIZE];
    private String successString;

    CodeMaker() {
        Random random = new Random();
        for(int i = 0; i < CODE_SIZE; i++) {
            code[i] = random.nextInt(NUMBER_OF_COLORS) + 1;
        }
        successString = String.join("", Collections.nCopies(CODE_SIZE, "b"));
    }

    public void loop() {
        boolean isRunning = true;
        while(isRunning) {
            int[] userInput = getInput();
            String resultOutput = evaluateInput(userInput);
            if(resultOutput.equals(successString)) {
                isRunning = false;
            }
        }
    }

    private int[] getInput() {
        String input = System.console().readLine();
        if(input.length() > CODE_SIZE) {
            System.out.println(INPUT_TOO_LONG_TEXT);
        }
        try {
            int[] result = new int[CODE_SIZE];
            for(int i = 0; i < CODE_SIZE; i++) {
                int currentColor = Integer.parseInt(String.valueOf(input.charAt(i)));
                if(currentColor > 6) {
                    System.out.print(NOT_SUPPORTED_INPUT_TEXT);
                    return getInput();
                }
                result[i] = currentColor;
            }
            return result;
        } catch(NumberFormatException numberFormatException) {
            System.out.print(NOT_SUPPORTED_INPUT_TEXT);
            return getInput();
        }
    }

    private String evaluateInput(int[] userInput) {
        int blackPegs = 0;
        int whitePegs = 0;
        for(int i = 0; i < CODE_SIZE; i++) {
            if(userInput[i] == code[i]) {
                blackPegs++;
            } else if(arrayContains(userInput[i])) {
                whitePegs++;
            }
        }
        return buildString(blackPegs, whitePegs);
    }

    private boolean arrayContains(int color) {
        for(int i = 0; i < CODE_SIZE; i++) {
            if(color == code[i]) {
                return true;
            }
        }
        return false;
    }

    private String buildString(int blackPegs, int whitePegs) {
        int dots = CODE_SIZE - blackPegs - whitePegs;
        return String.join("", Collections.nCopies(blackPegs, "b")) +
            String.join("", Collections.nCopies(whitePegs, "w")) +
                String.join("", Collections.nCopies(dots, "."));
    }
}