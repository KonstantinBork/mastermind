package com.sp.mastermind;

public class MastermindUtils {

    static final int CODE_SIZE = 4;
    static final int NUMBER_OF_COLORS = 6;
    static final String INPUT_TOO_LONG_TEXT = "Die Eingabe ist leider zu lang. Es werden nur die ersten " +
            CODE_SIZE + " Buchstaben beachtet.";
    static final String NOT_SUPPORTED_INPUT_TEXT = "Die Eingabe wird nicht unterstützt!";

    static boolean arrayContains(int color, int[] code) {
        for (int i = 0; i < MastermindUtils.CODE_SIZE; i++) {
            if (color == code[i]) {
                return true;
            }
        }
        return false;
    }
}