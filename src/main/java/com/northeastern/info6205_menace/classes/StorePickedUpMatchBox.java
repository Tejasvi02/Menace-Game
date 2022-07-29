package com.northeastern.info6205_menace.classes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StorePickedUpMatchBox {

    Logger logger = LoggerFactory.getLogger(StorePickedUpMatchBox.class);

    private String pattern;

    private int bead;

    public StorePickedUpMatchBox(String pattern, int bead) {

        logger.info("Storing " + bead + " for the given pattern" + pattern);

        this.pattern = pattern;
        this.bead = bead;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public int getBead() {
        return bead;
    }

    public void setBead(int bead) {
        this.bead = bead;
    }
}
