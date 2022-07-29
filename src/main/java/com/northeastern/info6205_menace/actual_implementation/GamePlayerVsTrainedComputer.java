package com.northeastern.info6205_menace.actual_implementation;

import com.northeastern.info6205_menace.classes.HeapOfMatchboxes;
import com.northeastern.info6205_menace.classes.MatchBox;
import com.northeastern.info6205_menace.classes.StorePickedUpMatchBox;
import com.northeastern.info6205_menace.implementation.Board;
import com.northeastern.info6205_menace.implementation.GamePlayerVsComputer;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

import static com.northeastern.info6205_menace.check_pattern.CheckPattern.getStringOfTheBoard;
import static com.northeastern.info6205_menace.utils.Utils.convertIntegerToCoordinate;
import static com.northeastern.info6205_menace.utils.Utils.printBoard;
import static com.northeastern.info6205_menace.implementation.Board.getResult;

public class GamePlayerVsTrainedComputer {

    Hashtable<Integer, HeapOfMatchboxes> heapOfMatchboxesHashtable;

    HashMap<Integer, StorePickedUpMatchBox> storePickedUpMatchBoxHashMap;


    public GamePlayerVsTrainedComputer() {

        GameComputerVsComputerImplementation gameComputerVsComputerImplementation = new GameComputerVsComputerImplementation();

        gameComputerVsComputerImplementation.playGame(1024);

        heapOfMatchboxesHashtable = gameComputerVsComputerImplementation.getHeapOfMatchboxesHashtable();
        storePickedUpMatchBoxHashMap = gameComputerVsComputerImplementation.getStorePickedUpMatchBoxHashMap();

    }

    public static void main(String[] args) {
        GamePlayerVsTrainedComputer gamePlayerVsTrainedComputer = new GamePlayerVsTrainedComputer();
        gamePlayerVsTrainedComputer.playGame();
    }

    public void playGame() {

        Board board = new Board(10, 3, 2, 1);

        GameComputerVsComputerImplementation gameComputerVsComputerImplementation = new GameComputerVsComputerImplementation();

        Scanner scanner = new Scanner(System.in);

        while (true) {

            int i = 0;

            char[][] theBoard = {
                    {' ', ' ', ' '},
                    {' ', ' ', ' '},
                    {' ', ' ', ' '}
            };

            while (i < 9) {

                char character = returnCharacter(i);

                printBoard(theBoard);

                // Computer's turn
                if (i % 2 == 0) {
                    theBoard = placeARandomBeadByComputer(theBoard, i, board.getAlpha());
                }

                // Human's turn
                else {
                    theBoard = humanTurn(theBoard, i);
                }

                if(getResult(theBoard, character)){

                    if(character == 'O'){
                        System.out.println("Computer WON!!");
                        printBoard(theBoard);
                        rewardOrPunish(0, board);

                    }

                    else if(character == 'X'){
                        System.out.println("You WON!!");
                        printBoard(theBoard);
                        rewardOrPunish(2, board);
                    }
                    break;
                }


                i++;
            }

            if (i == 9) {
                System.out.println("Draw");
                rewardOrPunish(1, board);
            }


            System.out.println("Wanna play again? 0 - Yes, 1 - No");

            int givenNumber = scanner.nextInt();

            if (givenNumber == 1) {
                break;
            } else if (givenNumber < 0 || givenNumber > 1) {
                System.out.println("I said 0 or 1, you dimwit");
                break;
            }

        }


    }

    public void rewardOrPunish(int gameState, Board board) {

        // If Computer 1 wins the game
        if (gameState == 0) {
            addBeadsToMatchBox(board.getBeta());
        }
        // If Computer 1 draws the game
        else if (gameState == 1) {
            addBeadsToMatchBox(board.getDelta());
        }

        // If Computer 1 loses the game
        else if (gameState == 2) {
            removeBeadFromMatchBox(board.getGamma());
        }


    }

    public void addBeadsToMatchBox(int number) {

        for (Map.Entry<Integer, StorePickedUpMatchBox> mapEntrySet : storePickedUpMatchBoxHashMap.entrySet()) {

            MatchBox matchBox = heapOfMatchboxesHashtable.get(mapEntrySet.getKey()).getMatchBoxFromStringPattern(mapEntrySet.getValue().getPattern());

            matchBox.addParticularBeads(mapEntrySet.getValue().getBead(), number);

        }

    }

    public void removeBeadFromMatchBox(int number) {

        for (Map.Entry<Integer, StorePickedUpMatchBox> mapEntrySet : storePickedUpMatchBoxHashMap.entrySet()) {

            MatchBox matchBox = heapOfMatchboxesHashtable.get(mapEntrySet.getKey()).getMatchBoxFromStringPattern(mapEntrySet.getValue().getPattern());

            matchBox.removeBeadsByDelta(mapEntrySet.getValue().getBead(), number);

        }

    }


    public char[][] placeARandomBeadByComputer(char[][] existingBoard, int chance, int alpha) {

        MatchBox matchBox = heapOfMatchboxesHashtable.get(chance / 2).getMatchBoxFromGivenPattern(existingBoard);

        String matchBoxFoundPatternString = heapOfMatchboxesHashtable.get(chance / 2).getMatchBoxFromGivenBoardPattern(existingBoard);

        if (matchBox != null) {

            int randomBead = matchBox.getRandomBeadFromBag();
            int[] getCoordinates = convertIntegerToCoordinate(randomBead);

            // Checking if the place is empty
            if (existingBoard[getCoordinates[0]][getCoordinates[1]] == ' ') {
                existingBoard[getCoordinates[0]][getCoordinates[1]] = returnCharacter(chance);

                storePickedUpMatchBoxHashMap.put(chance / 2, new StorePickedUpMatchBox(matchBoxFoundPatternString, randomBead));
                return existingBoard;

            } else {
                // Adding it back to the box
                matchBox.addParticularBeads(randomBead, 1);
                return placeARandomBeadByComputer(existingBoard, chance, alpha);
            }

        } else {

            MatchBox newMatchBox = heapOfMatchboxesHashtable.get(chance / 2).addNewMatchBox(existingBoard, alpha);
            int randomBead = newMatchBox.getRandomBeadFromBag();
            int[] getCoordinates = convertIntegerToCoordinate(randomBead);
            String pattern = getStringOfTheBoard(existingBoard);

            if (existingBoard[getCoordinates[0]][getCoordinates[1]] == ' ') {
                existingBoard[getCoordinates[0]][getCoordinates[1]] = returnCharacter(chance);

                storePickedUpMatchBoxHashMap.put(chance / 2, new StorePickedUpMatchBox(pattern, randomBead));
                return existingBoard;
            } else {
                // Adding it back to the box
                newMatchBox.addParticularBeads(randomBead, 1);
                return placeARandomBeadByComputer(existingBoard, chance, alpha);
            }
        }

    }

    public char[][] humanTurn(char[][] board, int chance){
        Scanner scanner = new Scanner(System.in);

        Board.printBoard(board);

        System.out.print("Give first coordinate: ");

        int firstCoordinate = scanner.nextInt();

        System.out.println();

        System.out.print("Give second coordinate: ");

        int secondCoordinate = scanner.nextInt();

        if (board[firstCoordinate][secondCoordinate] == ' ') {
            board[firstCoordinate][secondCoordinate] = returnCharacter(chance);
            return board;
        } else {
            System.out.println("Please try again!!");
            return humanTurn(board, chance);
        }
    }


    public char returnCharacter(int i) {
        if (i % 2 == 0) return 'O';
        else return 'X';
    }

}
