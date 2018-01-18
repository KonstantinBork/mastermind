package com.sp.mastermind;

// TODO imports
import Integer;
import NumberFormatException;

public class CodeMaker {

    private static final String INPUT_TOO_LONG_TEXT = "";
    private static final String NOT_SUPPORTED_INPUT_TEXT = "";
    private final int CODE_SIZE = 4;
    private int[] code = new int[CODE_SIZE];

    public CodeMaker() {
        for(int i = 0; i < CODE_SIZE; i++) {

        }
    }

    public void loop() {
        boolean isRunning = true;
        while(isRunning) {
            int[] userInput = getInput();
            char[] resultOutput = evaluateInput();
        }
    }

    private int[] getInput() {
        String input = System.console.readLine();
        if(input.length() > CODE_SIZE) {
            System.out.println(INPUT_TOO_LONG_TEXT);
        }
        try {
            int[] result = new int[CODE_SIZE];
            for(int i = 0; i < CODE_SIZE; i++) {
                int currentColor = Integer.parseInt(input.charAt(i));
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

    private char[] evaluateInput() {
        return new char[CODE_SIZE];
    }
}
