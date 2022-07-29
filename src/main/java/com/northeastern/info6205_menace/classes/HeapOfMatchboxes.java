package com.northeastern.info6205_menace.classes;

import static com.northeastern.info6205_menace.check_pattern.CheckPattern.*;
import static com.northeastern.info6205_menace.utils.Utils.*;
import java.util.Hashtable;
import org.slf4j.LoggerFactory;

public class HeapOfMatchboxes {

    org.slf4j.Logger logger = LoggerFactory.getLogger(HeapOfMatchboxes.class);

    Hashtable<String, MatchBox> matchBoxes = new Hashtable<>();

    public HeapOfMatchboxes() {

    }

    public String getMatchBoxFromGivenBoardPattern(char[][] test) {

        logger.info("Checking for the matchbox with the given pattern");

        char[][] original = test;

        if (matchBoxes.containsKey(getStringOfTheBoard(original))) {
            return (getStringOfTheBoard(original));
        }

        char[][] originalTranspose = getTranspose(original);

        if (matchBoxes.containsKey(getStringOfTheBoard(originalTranspose))) {
            return getStringOfTheBoard(originalTranspose);
        }

        char[][] columnSwapped = swapFirstAndThirdColumn(original);

        if (matchBoxes.containsKey(getStringOfTheBoard(columnSwapped))) {
            return getStringOfTheBoard(columnSwapped);
        }

        char[][] columnSwappedTranspose = getTranspose(columnSwapped);

        if (matchBoxes.containsKey(getStringOfTheBoard(columnSwappedTranspose))) {
            return getStringOfTheBoard(columnSwappedTranspose);
        }

        char[][] rowSwapped = swapFirstAndThirdRow(original);

        if (matchBoxes.containsKey(getStringOfTheBoard(rowSwapped))) {
            return getStringOfTheBoard(rowSwapped);
        }

        char[][] rowSwappedTranspose = getTranspose(rowSwapped);

        if (matchBoxes.containsKey(getStringOfTheBoard(rowSwappedTranspose))) {
            return getStringOfTheBoard(rowSwappedTranspose);
        }

        char[][] rowAndColumnSwapped = swapFirstAndThirdColumn(rowSwapped);

        if (matchBoxes.containsKey(getStringOfTheBoard(rowAndColumnSwapped))) {
            return getStringOfTheBoard(rowAndColumnSwapped);
        }

        char[][] rowAndColumnSwappedTranspose = getTranspose(rowAndColumnSwapped);

        if (matchBoxes.containsKey(getStringOfTheBoard(rowAndColumnSwappedTranspose))) {
            return getStringOfTheBoard(rowAndColumnSwappedTranspose);
        }
        return null;
    }

    public MatchBox getMatchBoxFromGivenPattern(char[][] test) {

        char[][] original = test;

        if (matchBoxes.containsKey(getStringOfTheBoard(original))) {
            return matchBoxes.get(getStringOfTheBoard(original));
        }

        char[][] originalTranspose = getTranspose(original);

        if (matchBoxes.containsKey(getStringOfTheBoard(originalTranspose))) {
            return matchBoxes.get(originalTranspose);
        }

        char[][] columnSwapped = swapFirstAndThirdColumn(original);

        if (matchBoxes.containsKey(getStringOfTheBoard(columnSwapped))) {
            return matchBoxes.get(columnSwapped);
        }

        char[][] columnSwappedTranspose = getTranspose(columnSwapped);

        if (matchBoxes.containsKey(getStringOfTheBoard(columnSwappedTranspose))) {
            return matchBoxes.get(columnSwappedTranspose);
        }

        char[][] rowSwapped = swapFirstAndThirdRow(original);

        if (matchBoxes.containsKey(getStringOfTheBoard(rowSwapped))) {
            return matchBoxes.get(rowSwapped);
        }

        char[][] rowSwappedTranspose = getTranspose(rowSwapped);

        if (matchBoxes.containsKey(getStringOfTheBoard(rowSwappedTranspose))) {
            return matchBoxes.get(rowSwappedTranspose);
        }

        char[][] rowAndColumnSwapped = swapFirstAndThirdColumn(rowSwapped);

        if (matchBoxes.containsKey(getStringOfTheBoard(rowAndColumnSwapped))) {
            return matchBoxes.get(rowAndColumnSwapped);
        }

        char[][] rowAndColumnSwappedTranspose = getTranspose(rowAndColumnSwapped);

        if (matchBoxes.containsKey(getStringOfTheBoard(rowAndColumnSwappedTranspose))) {
            return matchBoxes.get(rowAndColumnSwappedTranspose);
        }
        return null;
    }

    public MatchBox getMatchBoxFromStringPattern(String pattern) {
        return getMatchBoxFromGivenPattern(convertStringToBoard(pattern));
    }

    public MatchBox addNewMatchBox(String pattern, int alpha) {

        logger.info("Added a new match box");

        MatchBox matchBox = new MatchBox(alpha);

        matchBoxes.put(pattern, matchBox);

        return matchBox;
    }

    public MatchBox addNewMatchBox(char[][] existingBoard, int alpha) {
        String pattern = getStringOfTheBoard(existingBoard);
        return addNewMatchBox(pattern, alpha);
    }

    public Hashtable<String, MatchBox> getMatchBoxes() {
        return matchBoxes;
    }

    public void setMatchBoxes(Hashtable<String, MatchBox> matchBoxes) {
        this.matchBoxes = matchBoxes;
    }
}
