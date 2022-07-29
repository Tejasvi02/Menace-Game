/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.northeastern.info6205_menace.gui;

import static com.northeastern.info6205_menace.check_pattern.CheckPattern.getStringOfTheBoard;
import com.northeastern.info6205_menace.classes.HeapOfMatchboxes;
import com.northeastern.info6205_menace.classes.MatchBox;
import com.northeastern.info6205_menace.classes.StorePickedUpMatchBox;
import com.northeastern.info6205_menace.implementation.Board;
import static com.northeastern.info6205_menace.implementation.Board.getResult;
import static com.northeastern.info6205_menace.utils.Utils.convertIntegerToCoordinate;
import static com.northeastern.info6205_menace.utils.Utils.printBoard;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import org.slf4j.LoggerFactory;

/**
 *
 * @author achyuthvarma
 */
public class CVsCJPanel3 extends javax.swing.JPanel {

    String noughtFileLocation = "src/resources/images/Noughts.png";
    String crossFileLocation = "src/resources/images/Cross.png";

    org.slf4j.Logger logger = LoggerFactory.getLogger(CVsCJPanel3.class);

    Hashtable<Integer, HeapOfMatchboxes> heapOfMatchBoxesHashTable = new Hashtable<>();

    HashMap<Integer, StorePickedUpMatchBox> storePickedMatchBoxHashMap;

    int delay = 1000;

    Board board = new Board(10, 2, 1, 1);

    int loopingVariable = 0;

    boolean gameCompleted = false;

    /**
     * Creates new form CVsCJPanel3
     */
    public CVsCJPanel3() {

        heapOfMatchBoxesHashTable.put(0, new HeapOfMatchboxes());
        heapOfMatchBoxesHashTable.put(1, new HeapOfMatchboxes());
        heapOfMatchBoxesHashTable.put(2, new HeapOfMatchboxes());
        heapOfMatchBoxesHashTable.put(3, new HeapOfMatchboxes());
        heapOfMatchBoxesHashTable.put(4, new HeapOfMatchboxes());
        heapOfMatchBoxesHashTable.put(5, new HeapOfMatchboxes());

        storePickedMatchBoxHashMap = new HashMap<>();

        initComponents();
    }

    char[][] theBoard = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        repeatButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        computer1MenaceLabel = new javax.swing.JLabel();
        scoreBoardLabel = new javax.swing.JLabel();
        computer2RandomLabel = new javax.swing.JLabel();
        drawLabel = new javax.swing.JLabel();
        computer1WonNumberLabel = new javax.swing.JLabel();
        computer2NumberWonLabel = new javax.swing.JLabel();
        drawNumberLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 0, 0));
        setForeground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        setPreferredSize(new java.awt.Dimension(1024, 900));

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("1");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("3");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("2");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("4");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("5");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("6");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("9");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("8");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("7");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        repeatButton.setText("Repeat");
        repeatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repeatButtonActionPerformed(evt);
            }
        });

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        computer1MenaceLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        computer1MenaceLabel.setForeground(new java.awt.Color(255, 255, 255));
        computer1MenaceLabel.setText("Computer 1 (MENACE)");

        scoreBoardLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        scoreBoardLabel.setForeground(new java.awt.Color(255, 255, 255));
        scoreBoardLabel.setText("Score Board");

        computer2RandomLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        computer2RandomLabel.setForeground(new java.awt.Color(255, 255, 255));
        computer2RandomLabel.setText("Computer 2 (Random)");

        drawLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        drawLabel.setForeground(new java.awt.Color(255, 255, 255));
        drawLabel.setText("Draw");

        computer1WonNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        computer1WonNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        computer1WonNumberLabel.setText("0");

        computer2NumberWonLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        computer2NumberWonLabel.setForeground(new java.awt.Color(255, 255, 255));
        computer2NumberWonLabel.setText("0");

        drawNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        drawNumberLabel.setForeground(new java.awt.Color(255, 255, 255));
        drawNumberLabel.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(startButton)
                        .addGap(27, 27, 27)
                        .addComponent(repeatButton)
                        .addGap(31, 31, 31)
                        .addComponent(resetButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(computer2RandomLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(drawLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(computer1MenaceLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(computer1WonNumberLabel)
                                    .addComponent(computer2NumberWonLabel)
                                    .addComponent(drawNumberLabel)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(scoreBoardLabel)
                                .addGap(30, 30, 30)))))
                .addGap(54, 296, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(scoreBoardLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(computer1WonNumberLabel)
                    .addComponent(computer1MenaceLabel))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(computer2RandomLabel)
                    .addComponent(computer2NumberWonLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(drawLabel)
                    .addComponent(drawNumberLabel)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 430, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(resetButton)
                    .addComponent(repeatButton))
                .addGap(81, 81, 81))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:

        setAnotherSet(delay);

    }//GEN-LAST:event_startButtonActionPerformed

    private void repeatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repeatButtonActionPerformed
        // TODO add your handling code here:

//        this.the = {
//        {' ', ' ', ' '},
//        {' ', ' ', ' '},
//        {' ', ' ', ''}
//        };
        char[][] theNewBoard = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        theBoard = theNewBoard;

        loopingVariable = 0;

        gameCompleted = false;

        resetButton.doClick();
        setAnotherSet(delay);

    }//GEN-LAST:event_repeatButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:

        jLabel1.setText("1");
        jLabel1.setIcon(null);
        jLabel2.setText("2");
        jLabel2.setIcon(null);
        jLabel3.setText("3");
        jLabel3.setIcon(null);
        jLabel4.setText("4");
        jLabel4.setIcon(null);
        jLabel5.setText("5");
        jLabel5.setIcon(null);
        jLabel6.setText("6");
        jLabel6.setIcon(null);
        jLabel7.setText("7");
        jLabel7.setIcon(null);
        jLabel8.setText("8");
        jLabel8.setIcon(null);
        jLabel9.setText("9");
        jLabel9.setIcon(null);

    }//GEN-LAST:event_resetButtonActionPerformed

    public void setAnotherSet(int newTimeDelay) {

        if (newTimeDelay > delay * 9 || gameCompleted) {
//            resetButton.doClick();

            gameCompleted = true;
            return;
        }

        Timer timer = new Timer(newTimeDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    System.out.println("Inside Loop: " + loopingVariable);
                    setImageForLabel(loopingVariable);
                    checkResults(theBoard, returnCharacter(loopingVariable));
                    loopingVariable++;

                } catch (IOException ex) {
                    Logger.getLogger(CVsCJPanel3.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        timer.setRepeats(false);
        timer.start();

        if (gameCompleted) {
            timer.stop();
        } else {
            setAnotherSet(newTimeDelay + 1000);
        }

    }

    public void checkResults(char[][] theBoard, char character) {

        System.out.println("Inside Check Results");

        if (getResult(theBoard, 'O')) {

            System.out.println("Computer 1 won");
            gameCompleted = true;

            printBoard(theBoard);

            Integer currentScore = Integer.parseInt(computer1WonNumberLabel.getText());

            computer1WonNumberLabel.setText(String.valueOf(++currentScore));

            rewardOrPunish(0, board);
            repeatButton.doClick();

        } else if (getResult(theBoard, 'X')) {

            System.out.println("Computer 2 Won");
            gameCompleted = true;

            printBoard(theBoard);

            Integer currentScore = Integer.parseInt(computer2NumberWonLabel.getText());

            computer2NumberWonLabel.setText(String.valueOf(++currentScore));

            rewardOrPunish(2, board);
            repeatButton.doClick();

        } else if (loopingVariable > 8) {
            System.out.println("Draw");
            gameCompleted = true;

            printBoard(theBoard);

            Integer currentScore = Integer.parseInt(drawNumberLabel.getText());

            drawNumberLabel.setText(String.valueOf(++currentScore));

            rewardOrPunish(1, board);
            repeatButton.doClick();

        }

    }

    public char returnCharacter(int i) {

        if (i % 2 == 0) {
            return 'O';
        } else {
            return 'X';
        }

    }

    public void setImageForLabel(int chance) throws IOException {

        String imageLocation = chance % 2 == 0 ? noughtFileLocation : crossFileLocation;

        BufferedImage myPicture = ImageIO.read(new File(imageLocation));

        ImageIcon imageIcon = new ImageIcon(myPicture);

        Image image = imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        if (loopingVariable % 2 == 0) {
            theBoard = placeARandomBeadByComputer(theBoard, chance, board.getAlpha(), new ImageIcon(image));
        } else {
            theBoard = placeRandomBeadByComputer2(theBoard, chance, new ImageIcon(image));
        }
//        setImageIconToParticularLabel(chance, new ImageIcon(image));

    }

    public char[][] placeARandomBeadByComputer(char[][] existingBoard, int chance, int alpha, ImageIcon imageIcon) {

        logger.info("Placing a random bead and picking it from matchbox");

        MatchBox matchBox = heapOfMatchBoxesHashTable.get(chance / 2).getMatchBoxFromGivenPattern(existingBoard);

        String matchBoxFoundPatternString = heapOfMatchBoxesHashTable.get(chance / 2).getMatchBoxFromGivenBoardPattern(existingBoard);

        if (matchBox != null) {

            logger.info("Matchbox found");

            int randomBead = matchBox.getRandomBeadFromBag();
            int[] getCoordinates = convertIntegerToCoordinate(randomBead);

            // Checking if the place is empty
            if (existingBoard[getCoordinates[0]][getCoordinates[1]] == ' ') {
                existingBoard[getCoordinates[0]][getCoordinates[1]] = returnCharacter(chance);

                storePickedMatchBoxHashMap.put(chance / 2, new StorePickedUpMatchBox(matchBoxFoundPatternString, randomBead));

                setImageIconToParticularLabel(changeCoordinatesToNumber(getCoordinates), imageIcon);

                return existingBoard;

            } else {
                // Adding it back to the box
                matchBox.addParticularBeads(randomBead, 1);
                return placeARandomBeadByComputer(existingBoard, chance, alpha, imageIcon);
            }

        } else {

            logger.info("Matchbox not found, inserting new one");

            MatchBox newMatchBox = heapOfMatchBoxesHashTable.get(chance / 2).addNewMatchBox(existingBoard, alpha);
            int randomBead = newMatchBox.getRandomBeadFromBag();
            int[] getCoordinates = convertIntegerToCoordinate(randomBead);
            String pattern = getStringOfTheBoard(existingBoard);

            if (existingBoard[getCoordinates[0]][getCoordinates[1]] == ' ') {

                logger.info("Inserting it to the board");

                existingBoard[getCoordinates[0]][getCoordinates[1]] = returnCharacter(chance);

                storePickedMatchBoxHashMap.put(chance / 2, new StorePickedUpMatchBox(pattern, randomBead));

                setImageIconToParticularLabel(changeCoordinatesToNumber(getCoordinates), imageIcon);

                return existingBoard;
            } else {
                // Adding it back to the box
                newMatchBox.addParticularBeads(randomBead, 1);
                return placeARandomBeadByComputer(existingBoard, chance, alpha, imageIcon);
            }
        }

    }

    public char[][] placeRandomBeadByComputer2(char[][] existingBoard, int chance, ImageIcon imageIcon) {

        logger.info("Randomly inserting it to board ");

        MatchBox matchBox = new MatchBox(10);
        int randomBead = matchBox.getRandomBeadFromBag();
        int[] getCoordinates = convertIntegerToCoordinate(randomBead);
        if (existingBoard[getCoordinates[0]][getCoordinates[1]] == ' ') {

            existingBoard[getCoordinates[0]][getCoordinates[1]] = returnCharacter(chance);
            setImageIconToParticularLabel(changeCoordinatesToNumber(getCoordinates), imageIcon);
            return existingBoard;
        } else {
            matchBox.addParticularBeads(randomBead, 1);
            return placeRandomBeadByComputer2(existingBoard, chance, imageIcon);
        }
    }

    public int changeCoordinatesToNumber(int[] number) {

        if (number[0] == 0 && number[1] == 0) {
            return 1;
        } else if (number[0] == 0 && number[1] == 1) {
            return 2;
        } else if (number[0] == 0 && number[1] == 2) {
            return 3;
        } else if (number[0] == 1 && number[1] == 0) {
            return 4;
        } else if (number[0] == 1 && number[1] == 1) {
            return 5;
        } else if (number[0] == 1 && number[1] == 2) {
            return 6;
        } else if (number[0] == 2 && number[1] == 0) {
            return 7;
        } else if (number[0] == 2 && number[1] == 1) {
            return 8;
        } else if (number[0] == 2 && number[1] == 2) {
            return 9;
        } else {
            return -1;
        }

    }

    public void setImageIconToParticularLabel(int number, ImageIcon imageIcon) {

        switch (number) {
            case 1:
                jLabel1.setIcon(imageIcon);
                jLabel1.setText("");
                break;

            case 2:
                jLabel2.setIcon(imageIcon);
                jLabel2.setText("");
                break;

            case 3:
                jLabel3.setIcon(imageIcon);
                jLabel3.setText("");
                break;
            case 4:
                jLabel4.setIcon(imageIcon);
                jLabel4.setText("");
                break;
            case 5:
                jLabel5.setIcon(imageIcon);
                jLabel5.setText("");
                break;
            case 6:
                jLabel6.setIcon(imageIcon);
                jLabel6.setText("");
                break;
            case 7:
                jLabel7.setIcon(imageIcon);
                jLabel7.setText("");
                break;
            case 8:
                jLabel8.setIcon(imageIcon);
                jLabel8.setText("");
                break;
            case 9:
                jLabel9.setIcon(imageIcon);
                jLabel9.setText("");
                break;

            default:
                throw new AssertionError();
        }

    }

    public void rewardOrPunish(int gameState, Board board) {

        // If Computer 1 wins the game
        if (gameState == 0) {
            logger.info("MENACE Won!!");
            logger.info("Rewarding " + board.getBeta() + " beads to picked up matchboxes");
            addBeadsToMatchBox(board.getBeta());
        } // If Computer 1 draws the game
        else if (gameState == 1) {
            logger.info("It is a draw!!");
            logger.info("Rewarding " + board.getDelta() + " beads to picked up matchboxes");

            addBeadsToMatchBox(board.getDelta());
        } // If Computer 1 loses the game
        else if (gameState == 2) {

            logger.info("MENACE LOST");
            logger.info("Punishing and removing " + board.getGamma() + " beads from the picked up matchboxes");

            removeBeadFromMatchBox(board.getGamma());
        }

    }

    public void addBeadsToMatchBox(int number) {

        for (Map.Entry<Integer, StorePickedUpMatchBox> mapEntrySet : storePickedMatchBoxHashMap.entrySet()) {

            MatchBox matchBox = heapOfMatchBoxesHashTable.get(mapEntrySet.getKey()).getMatchBoxFromStringPattern(mapEntrySet.getValue().getPattern());

            matchBox.addParticularBeads(mapEntrySet.getValue().getBead(), number);

        }

    }

    public void removeBeadFromMatchBox(int number) {

        logger.info("Removing " + board.getBeta());

        for (Map.Entry<Integer, StorePickedUpMatchBox> mapEntrySet : storePickedMatchBoxHashMap.entrySet()) {

            MatchBox matchBox = heapOfMatchBoxesHashTable.get(mapEntrySet.getKey()).getMatchBoxFromStringPattern(mapEntrySet.getValue().getPattern());

            matchBox.removeBeadsByDelta(mapEntrySet.getValue().getBead(), number);

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel computer1MenaceLabel;
    private javax.swing.JLabel computer1WonNumberLabel;
    private javax.swing.JLabel computer2NumberWonLabel;
    private javax.swing.JLabel computer2RandomLabel;
    private javax.swing.JLabel drawLabel;
    private javax.swing.JLabel drawNumberLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton repeatButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel scoreBoardLabel;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}