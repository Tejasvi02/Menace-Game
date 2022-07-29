package com.northeastern.info6205_menace.utils;

public class Utils {

    public static char[][] getTranspose(char[][] characterString) {

        char[][] result = new char[characterString.length][characterString[0].length];

        for (int i = 0; i < characterString.length; i++) {
            for (int j = 0; j < characterString[i].length; j++) {
                result[i][j] = characterString[j][i];
            }
        }

        return result;

    }

    public static char[] convertTwoDToOneDChar(char[][] characterString, int totalLength) {

        char[] result = new char[totalLength];

        int tempVariable = 0;

        for (char[] chars : characterString) {
            for (int j = 0; j < characterString[0].length; j++) {

                result[tempVariable] = chars[j];

                tempVariable++;
            }
        }

        return result;

    }

    public static void main(String[] args) {

        char[][] test1 = {
                {'O', 'O', 'O'},
                {'X', 'X', 'X'},
                {'X', 'X', 'X'},
        };

        printBoard(test1);

        printBoard(getTranspose(test1));

        char[] result = (convertTwoDToOneDChar(test1, 9));

        for (char character : result) {
            System.out.println("Value: " + character);
        }


    }

    public static void printBoard(char[][] characters) {

        System.out.println(characters[0][0] + "|" + characters[0][1] + "|" + characters[0][2]);
        System.out.println(characters[1][0] + "|" + characters[1][1] + "|" + characters[1][2]);
        System.out.println(characters[2][0] + "|" + characters[2][1] + "|" + characters[2][2]);

        System.out.println();

    }


    public static char[][] swapFirstAndThirdColumn(char[][] characters) {

        char[] column1 = new char[3];
        char[] column2 = new char[3];

        char[][] resultant = new char[3][3];

        for (int i = 0; i < 3; i++) {
            column1[i] = characters[i][0];
        }

        for (int i = 0; i < 3; i++) {
            column2[i] = characters[i][2];
        }

        for(int i = 0; i < 3; i ++){
            resultant[i][0] = column2[i];
        }

        for(int i = 0; i < 3; i++){
            resultant[i][2] = column1[i];
        }

        for(int i =0; i < 3; i++){
            resultant[i][1] = characters[i][1];
        }

        return resultant;

    }

    public static char[][] swapFirstAndThirdRow(char[][] characters){

        char[] rows1 = new char[3];
        char[] rows2 = new char[3];

        char[][] resultant = new char[3][3];

        rows1 = characters[0];
        rows2 = characters[2];

        resultant[0] = rows2;
        resultant[2] = rows1;
        resultant[1] = characters[1];

        return resultant;

    }

    public static int[] convertIntegerToCoordinate(int number) {

        int[] coordinates = new int[]{0, 0};

        switch (number) {
            case 0:
                coordinates[0] = 0;
                coordinates[1] = 0;
                return coordinates;
            case 1:
                coordinates[0] = 0;
                coordinates[1] = 1;
                return coordinates;
            case 2:
                coordinates[0] = 0;
                coordinates[1] = 2;
                return coordinates;
            case 3:
                coordinates[0] = 1;
                coordinates[1] = 0;
                return coordinates;
            case 4:
                coordinates[0] = 1;
                coordinates[1] = 1;
                return coordinates;
            case 5:
                coordinates[0] = 1;
                coordinates[1] = 2;
                return coordinates;
            case 6:
                coordinates[0] = 2;
                coordinates[1] = 0;
                return coordinates;
            case 7:
                coordinates[0] = 2;
                coordinates[1] = 1;
                return coordinates;
            case 8:
                coordinates[0] = 2;
                coordinates[1] = 2;
                return coordinates;
        }
        return coordinates;

    }

}
