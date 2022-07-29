package com.northeastern.info6205_menace.actual_implementation;

import com.northeastern.info6205_menace.classes.HeapOfMatchboxes;
import com.northeastern.info6205_menace.classes.MatchBox;
import com.northeastern.info6205_menace.classes.StorePickedUpMatchBox;
import com.northeastern.info6205_menace.implementation.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


import static com.northeastern.info6205_menace.check_pattern.CheckPattern.getStringOfTheBoard;
import static com.northeastern.info6205_menace.implementation.Board.getResult;
import static com.northeastern.info6205_menace.utils.Utils.convertIntegerToCoordinate;
import static com.northeastern.info6205_menace.utils.Utils.printBoard;

public class GameComputerVsComputerImplementation {

    Hashtable<Integer, HeapOfMatchboxes> heapOfMatchboxesHashtable = new Hashtable<>();

    HashMap<Integer, String> storeChanceAndPattern;

    HashMap<Integer, StorePickedUpMatchBox> storePickedUpMatchBoxHashMap;

    int[] scores = new int[3];

    Logger logger = LoggerFactory.getLogger(GameComputerVsComputerImplementation.class);


    public GameComputerVsComputerImplementation() {
        heapOfMatchboxesHashtable.put(0, new HeapOfMatchboxes());
        heapOfMatchboxesHashtable.put(1, new HeapOfMatchboxes());
        heapOfMatchboxesHashtable.put(2, new HeapOfMatchboxes());
        heapOfMatchboxesHashtable.put(3, new HeapOfMatchboxes());
        heapOfMatchboxesHashtable.put(4, new HeapOfMatchboxes());
        heapOfMatchboxesHashtable.put(5, new HeapOfMatchboxes());
    }

    public static void main(String[] args) {
        GameComputerVsComputerImplementation gameComputerVsComputerImplementation = new GameComputerVsComputerImplementation();

        gameComputerVsComputerImplementation.playGame(1000);
    }

    public char returnCharacter(int i) {
        if (i % 2 == 0) return 'O';
        else return 'X';
    }

    public void playGame(int games) {
        Board board = new Board(10, 3, 1, 2);

        int gamesPlayed = 0;

        while (gamesPlayed < games) {

            int i = 0;

            char[][] theBoard = {
                    {' ', ' ', ' '},
                    {' ', ' ', ' '},
                    {' ', ' ', ' '}
            };

            printBoard(theBoard);

            storeChanceAndPattern = new HashMap<>();

            storePickedUpMatchBoxHashMap = new HashMap<>();

            while (i < 9) {

                char character = returnCharacter(i);

                // Played by computer 1
                if (i % 2 == 0) {

                    System.out.println("Computer 1 Played: " + character);

                    theBoard = placeARandomBeadByComputer(theBoard, i, board.getAlpha());

                    //check if pattern exists
                    printBoard(theBoard);

                    // Get a random bead and place it on board

                }

                // Played by computer 2
                else {
                    System.out.println("Computer 2 Played: " + character);

                    theBoard = placeRandomBeadByComputer2(theBoard, i);

                    printBoard(theBoard);

                }

                if (getResult(theBoard, character)) {

                    if (character == 'O') {

                        System.out.println("Computer 1 Won");

                        rewardOrPunish(0, board);

                        scores[0] += 1;

                    } else if (character == 'X') {

                        System.out.println("Computer 2 Won");

                        rewardOrPunish(2, board);

                        scores[1] += 1;

                    }

                    break;
                }

                i++;
            }
            if (i == 9) {
                System.out.println("Draw");
                scores[2] += 1;
                rewardOrPunish(1, board);
            }

            gamesPlayed++;
        }


        for (int j = 0; j < scores.length; j++) {
            System.out.println(j + " :  " + scores[j]);
//            logger.info(j+" "+scores[j]);
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


    public char[][] placeRandomBeadByComputer2(char[][] existingBoard, int chance) {

        MatchBox matchBox = new MatchBox(10);
        int randomBead = matchBox.getRandomBeadFromBag();
        int[] getCoordinates = convertIntegerToCoordinate(randomBead);
        if (existingBoard[getCoordinates[0]][getCoordinates[1]] == ' ') {
            existingBoard[getCoordinates[0]][getCoordinates[1]] = returnCharacter(chance);
            return existingBoard;
        } else {
            matchBox.addParticularBeads(randomBead, 1);
            return placeRandomBeadByComputer2(existingBoard, chance);
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
                storeChanceAndPattern.put(chance / 2, matchBoxFoundPatternString);
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
                storeChanceAndPattern.put(chance / 2, getStringOfTheBoard(existingBoard));
                storePickedUpMatchBoxHashMap.put(chance / 2, new StorePickedUpMatchBox(pattern, randomBead));
                return existingBoard;
            } else {
                // Adding it back to the box
                newMatchBox.addParticularBeads(randomBead, 1);
                return placeARandomBeadByComputer(existingBoard, chance, alpha);
            }
        }

    }

    public Hashtable<Integer, HeapOfMatchboxes> getHeapOfMatchboxesHashtable() {
        return heapOfMatchboxesHashtable;
    }

    public void setHeapOfMatchboxesHashtable(Hashtable<Integer, HeapOfMatchboxes> heapOfMatchboxesHashtable) {
        this.heapOfMatchboxesHashtable = heapOfMatchboxesHashtable;
    }

    public HashMap<Integer, String> getStoreChanceAndPattern() {
        return storeChanceAndPattern;
    }

    public void setStoreChanceAndPattern(HashMap<Integer, String> storeChanceAndPattern) {
        this.storeChanceAndPattern = storeChanceAndPattern;
    }

    public HashMap<Integer, StorePickedUpMatchBox> getStorePickedUpMatchBoxHashMap() {
        return storePickedUpMatchBoxHashMap;
    }

    public void setStorePickedUpMatchBoxHashMap(HashMap<Integer, StorePickedUpMatchBox> storePickedUpMatchBoxHashMap) {
        this.storePickedUpMatchBoxHashMap = storePickedUpMatchBoxHashMap;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }
}
