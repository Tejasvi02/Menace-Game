/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.northeastern.info6205_menace.classes;

import com.northeastern.info6205_menace.adt.BagInterface;
import com.northeastern.info6205_menace.adt.Bag_Array;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author achyuthvarma This class is used to store the number of each colored
 * beads
 */
public class MatchBox {

    Logger logger = LoggerFactory.getLogger(MatchBox.class.getName());

    BagInterface<Integer> bag = new Bag_Array<Integer>();

    public MatchBox(int eachColourNumberOfBeads) {

        logger.info("Given Alpha as " + eachColourNumberOfBeads);

        logger.info("Inserting the beads inside the matchbox");

        for (int i = 0; i < eachColourNumberOfBeads; i++) {
            int j = 0;
            while (j < 9) {
                bag.add(j);
                j++;
            }
        }

    }

    public int getRandomBeadFromBag() {

        logger.info("Getting a random bead from bag");

        if (bag.isEmpty()) {
            throw new RuntimeException("Bag is Empty!!");
        }

        Random random = new Random();

//        logger.info(bag.size()+"");
        int pickRandom = random.nextInt(bag.size());

        return bag.grabByIndex(pickRandom);
    }

    public int getRandomBeadFromBag(int beadNumber) {

        logger.info("Getting a particular random bead from bag: " + beadNumber);

        if (bag.isEmpty()) {
            throw new RuntimeException("Bag is Empty!!");
        }

//        Random random = new Random();
//
//        int pickRandom = random.nextInt(bag.size());
        return bag.grab(beadNumber);
    }

    public void removeBeadsByDelta(int beadNumber, int delta) {
        logger.info("Removing the bead by the given delta value: " + delta);

        try {
            for (int i = 0; i < delta; i++) {
                getRandomBeadFromBag(beadNumber);
            }
        } catch (RuntimeException e) {
            System.out.println("Pass it off");
        }
    }

    public void addParticularBeads(int beadNumber, int multiple) {

        logger.info("Giving multiple number of beads: " + beadNumber + " of multiple " + multiple);

        for (int i = 0; i < multiple; i++) {
            bag.add(beadNumber);
        }
    }

    public int getTotalMatchBoxSize() {
        return bag.size();
    }

}
