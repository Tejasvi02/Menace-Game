package com.northeastern.info6205_menace.implementation;


import com.northeastern.info6205_menace.classes.MatchBox;
import org.junit.Test;

import java.util.Hashtable;

import static com.northeastern.info6205_menace.check_pattern.CheckPattern.*;

import static org.junit.Assert.*;


public class CheckPatternTestCases {

    @Test
    public void testPattern1(){

        Hashtable<String, MatchBox> hashtable = new Hashtable<>();

        char[][] test1 = {
                {'X', ' ', ' '},
                {'O', ' ', ' '},
                {' ', ' ', ' '},
        };

        hashtable.put(getStringOfTheBoard(test1), new MatchBox(5));

        char[][] test2 = {
                {'X', 'O', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };

        boolean found = checkThePatternIfExistsInHashTable(test2, hashtable);

        assertTrue(found);

    }

    @Test
    public void testPattern2(){

        Hashtable<String, MatchBox> hashtable = new Hashtable<>();

        char[][] test1 = {
                {'X', ' ', ' '},
                {'O', ' ', ' '},
                {' ', ' ', ' '},
        };

        hashtable.put(getStringOfTheBoard(test1), new MatchBox(5));

        char[][] test2 = {
                {'X', ' ', 'O'},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };

        boolean found = checkThePatternIfExistsInHashTable(test2, hashtable);

        assertFalse(found);

    }

    @Test
    public void testPattern3(){

        Hashtable<String, MatchBox> hashtable = new Hashtable<>();

        char[][] test1 = {
                {'X', ' ', ' '},
                {' ', 'O', ' '},
                {' ', ' ', ' '},
        };

        hashtable.put(getStringOfTheBoard(test1), new MatchBox(5));

        char[][] test2 = {
                {' ', ' ', ' '},
                {' ', 'O', ' '},
                {' ', ' ', 'X'},
        };

        boolean found = checkThePatternIfExistsInHashTable(test2, hashtable);

        assertTrue(found);

    }


    @Test
    public void testPattern4(){

        Hashtable<String, MatchBox> hashtable = new Hashtable<>();

        char[][] test1 = {
                {'X', ' ', ' '},
                {'X', ' ', ' '},
                {'X', ' ', ' '},
        };

        hashtable.put(getStringOfTheBoard(test1), new MatchBox(5));

        char[][] test2 = {
                {'X', 'X', 'X'},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };

        boolean found = checkThePatternIfExistsInHashTable(test2, hashtable);

        assertTrue(found);

    }

    @Test
    public void testPattern5(){

        Hashtable<String, MatchBox> hashtable = new Hashtable<>();

        char[][] test1 = {
                {'X', ' ', ' '},
                {'O', ' ', ' '},
                {' ', ' ', ' '},
        };

        hashtable.put(getStringOfTheBoard(test1), new MatchBox(5));

        char[][] test2 = {
                {'X', 'O', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };

        boolean found = checkThePatternIfExistsInHashTable(test2, hashtable);

        assertTrue(found);

    }

    @Test
    public void testPattern6(){

        Hashtable<String, MatchBox> hashtable = new Hashtable<>();

        char[][] test1 = {
                {'X', ' ', ' '},
                {'O', 'X', ' '},
                {' ', ' ', 'O'},
        };

        hashtable.put(getStringOfTheBoard(test1), new MatchBox(5));

        char[][] test2 = {
                {' ', ' ', 'O'},
                {'O', 'X', ' '},
                {'X', ' ', ' '},
        };

        boolean found = checkThePatternIfExistsInHashTable(test2, hashtable);

        assertTrue(found);

    }


}
