package com.sp.mastermind;

public class Mastermind {

    private static final String STARTUP_TEXT = "";
    private static final String NOT_SUPPORTED_INPUT_TEXT = "";
    private static final String GOODBYE_TEXT = "";

    public static void main(String[] args) {
        System.out.print(STARTUP_TEXT);
        int programMode = getProgramMode();
        switch(programMode) {
            case 0:
                System.out.println(GOODBYE_TEXT);
            case 1:
                CodeMaker codeMaker = new CodeMaker();
                codeMaker.loop();
                break;
            case 2:
                CodeBreaker codeBreaker = new CodeBreaker();
                codeBreaker.loop();
                break;
            default:
                break;
        }
        System.exit(0);
    }

    private static int getProgramMode() {
        String input = System.console().readLine();
        int programMode;
        try {
            programMode = Integer.parseInt(input);
            while(programMode < 0 || programMode > 2) {
                System.out.print(NOT_SUPPORTED_INPUT_TEXT);
                input = System.console().readLine();
                programMode = Integer.parseInt(input);
            }
            return programMode;
        } catch (NumberFormatException numberFormatException) {
            System.out.print(NOT_SUPPORTED_INPUT_TEXT);
            return getProgramMode();
        }
    }
}