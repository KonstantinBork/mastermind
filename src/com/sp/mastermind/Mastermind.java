package com.sp.mastermind;

import java.util.Scanner;

public class Mastermind {

    private static final String STARTUP_TEXT = "" +
            "Hallo bei Mastermind.\n" +
            "Wähle zunächst den Modus: (1) Codemaker, (2) Codebreaker, (0) Beenden\n" +
            "";
    private static final String GOODBYE_TEXT = "Bis bald.";

    public static void main(String[] args) {
        System.out.print(STARTUP_TEXT);
        int programMode = getProgramMode();
        switch (programMode) {
            case 0:
                System.out.println(GOODBYE_TEXT);
                break;
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
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int programMode;
        try {
            programMode = Integer.parseInt(input);
            while (programMode < 0 || programMode > 2) {
                System.out.println(MastermindUtils.NOT_SUPPORTED_INPUT_TEXT);
                input = scanner.nextLine();
                programMode = Integer.parseInt(input);
            }
            return programMode;
        } catch (NumberFormatException numberFormatException) {
            System.out.println(MastermindUtils.NOT_SUPPORTED_INPUT_TEXT);
            return getProgramMode();
        }
    }
}