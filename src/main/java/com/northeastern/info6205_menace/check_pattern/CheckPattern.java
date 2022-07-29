package com.northeastern.info6205_menace.check_pattern;

import com.northeastern.info6205_menace.classes.MatchBox;

import java.util.Hashtable;

import static com.northeastern.info6205_menace.utils.Utils.*;

public class CheckPattern {

//    public static Hashtable<String, String> heapOfMatchBox = new Hashtable<>();


    public static String getStringOfTheBoard(char[][] characters) {
        return String.valueOf(convertTwoDToOneDChar(characters, 9));
    }

    public static char[][] convertStringToBoard(String pattern){

        char[] characterArray = pattern.toCharArray();

        char[][] resultant = new char[3][3];

        int k = 0;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                resultant[i][j] = characterArray[k];
                k++;
            }
        }

        return resultant;

    }

    public static boolean checkThePatternIfExistsInHashTable(char[][] test, Hashtable<String, MatchBox> heapOfMatchBox) {

        char[][] original = test;

        if (heapOfMatchBox.containsKey(getStringOfTheBoard(original))) {
            return true;
        }

        char[][] originalTranspose = getTranspose(original);

        if (heapOfMatchBox.containsKey(getStringOfTheBoard(originalTranspose))) {
            return true;
        }

        char[][] columnSwapped = swapFirstAndThirdColumn(original);

        if (heapOfMatchBox.containsKey(getStringOfTheBoard(columnSwapped))) {
            return true;
        }

        char[][] columnSwappedTranspose = getTranspose(columnSwapped);

        if (heapOfMatchBox.containsKey(getStringOfTheBoard(columnSwappedTranspose))) {
            return true;
        }

        char[][] rowSwapped = swapFirstAndThirdRow(original);

        if (heapOfMatchBox.containsKey(getStringOfTheBoard(rowSwapped))) {
            return true;
        }

        char[][] rowSwappedTranspose = getTranspose(rowSwapped);

        if (heapOfMatchBox.containsKey(getStringOfTheBoard(rowSwappedTranspose))) {
            return true;
        }

        char[][] rowAndColumnSwapped = swapFirstAndThirdColumn(rowSwapped);

        if (heapOfMatchBox.containsKey(getStringOfTheBoard(rowAndColumnSwapped))) {
            return true;
        }

        char[][] rowAndColumnSwappedTranspose = getTranspose(rowAndColumnSwapped);

        if (heapOfMatchBox.containsKey(getStringOfTheBoard(rowAndColumnSwappedTranspose))) {
            return true;
        }

        return false;

    }


}
