/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.northeastern.info6205_menace.gui;

import static com.northeastern.info6205_menace.check_pattern.CheckPattern.getStringOfTheBoard;
import com.northeastern.info6205_menace.classes.HeapOfMatchboxes;
import com.northeastern.info6205_menace.classes.MatchBox;
import com.northeastern.info6205_menace.classes.StorePickedUpMatchBox;
import com.northeastern.info6205_menace.implementation.Board;
import com.northeastern.info6205_menace.utils.Utils;
import static com.northeastern.info6205_menace.utils.Utils.convertIntegerToCoordinate;
import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author kashr
 */
public class CtoCJPanel extends javax.swing.JPanel {

    Logger logger = LoggerFactory.getLogger(CtoCJPanel.class);

    Hashtable<Integer, HeapOfMatchboxes> heapOfMatchBoxesHashtable = new Hashtable<>();

    HashMap<Integer, String> storeChanceAndPattern;

    HashMap<Integer, StorePickedUpMatchBox> storePickedUpMatchBoxHashMap;

    int temp = 0;

    /**
     * Creates new form CtoCJPanel
     */
    public CtoCJPanel() {
        initComponents();

        heapOfMatchBoxesHashtable.put(0, new HeapOfMatchboxes());
        heapOfMatchBoxesHashtable.put(1, new HeapOfMatchboxes());
        heapOfMatchBoxesHashtable.put(2, new HeapOfMatchboxes());
        heapOfMatchBoxesHashtable.put(3, new HeapOfMatchboxes());
        heapOfMatchBoxesHashtable.put(4, new HeapOfMatchboxes());
        heapOfMatchBoxesHashtable.put(5, new HeapOfMatchboxes());

    }
    char[][] game = new char[][]{
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}};

    public char returnCharacter(int i) {
        if (i % 2 == 0) {
            return 'O';
        } else {
            return 'X';
        }
    }

    public void playGame() throws InterruptedException {

        char[][] theBoard = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}};

        Board board = new Board(10, 3, 1, 2);

        System.out.println("Inside Play Game Method");

        storeChanceAndPattern = new HashMap<>();

        storePickedUpMatchBoxHashMap = new HashMap<>();

        int i = 0;

        button1.doClick();

        while (i < 9) {

            char character = returnCharacter(i);

            if (i % 2 == 0) {
                Thread.sleep(1000);

                logger.info("Computer 1's turn");

                theBoard = placeARandomBeadByComputer(theBoard, i, board.getAlpha());

            } else {
                Thread.sleep(1000);

                logger.info("Computer 2's Turn");

                theBoard = placeRandomBeadByComputer2(theBoard, i);

            }

            i++;
            temp++;

        }

        if (i == 9) {
            logger.info("Draw!!");
        }

        temp = 0;
    }

    public char[][] placeARandomBeadByComputer(char[][] existingBoard, int chance, int alpha) {

        MatchBox matchBox = heapOfMatchBoxesHashtable.get(chance / 2).getMatchBoxFromGivenPattern(existingBoard);

        String matchBoxFoundPattern = heapOfMatchBoxesHashtable.get(chance / 2).getMatchBoxFromGivenBoardPattern(existingBoard);

        // If a matchbox with the current existing patternalready exists
        if (matchBox != null) {

            int randomBead = matchBox.getRandomBeadFromBag();

            int[] getCoordinates = Utils.convertIntegerToCoordinate(randomBead);

            if (existingBoard[getCoordinates[0]][getCoordinates[1]] == ' ') {

                setButtonTextDependingOnCoordinates(getCoordinates, 'O');
                existingBoard[getCoordinates[0]][getCoordinates[1]] = returnCharacter(chance);

                storePickedUpMatchBoxHashMap.put(chance / 2, new StorePickedUpMatchBox(matchBoxFoundPattern, randomBead));
                return existingBoard;

            } else {
                matchBox.addParticularBeads(randomBead, 1);
                return placeARandomBeadByComputer(existingBoard, chance, alpha);
            }

        } // If it is not found
        else {

            MatchBox newMatchBox = heapOfMatchBoxesHashtable.get(chance / 2).addNewMatchBox(existingBoard, alpha);
            int randomBead = newMatchBox.getRandomBeadFromBag();
            int[] getCoordinates = Utils.convertIntegerToCoordinate(randomBead);

            String newMatchBoxPattern = getStringOfTheBoard(existingBoard);

            if (existingBoard[getCoordinates[0]][getCoordinates[1]] == ' ') {

                setButtonTextDependingOnCoordinates(getCoordinates, 'O');
                existingBoard[getCoordinates[0]][getCoordinates[1]] = returnCharacter(chance);

                storePickedUpMatchBoxHashMap.put(chance / 2, new StorePickedUpMatchBox(newMatchBoxPattern, randomBead));

                return existingBoard;

            } else {
                // Adding it back to the matchbox cause the place to put 'O' has already been occupied

                newMatchBox.addParticularBeads(randomBead, alpha);
                return placeARandomBeadByComputer(existingBoard, chance, alpha);
            }

        }

    }

    public void setButtonTextDependingOnCoordinates(int[] coordinates, char character) {

        if (coordinates[0] == 0 && coordinates[1] == 0) {

//            button1.setText(String.valueOf(character));
            button1.doClick(1);

        } else if (coordinates[0] == 0 && coordinates[1] == 1) {

//            button2.setText(String.valueOf(character));
            button2.doClick(1);

        } else if (coordinates[0] == 0 && coordinates[1] == 2) {

//            button3.setText(String.valueOf(character));
            button3.doClick(1);

        } else if (coordinates[0] == 1 && coordinates[1] == 0) {

//            button4.setText(String.valueOf(character));
            button4.doClick(1);

        } else if (coordinates[0] == 1 && coordinates[1] == 1) {

//            button5.setText(String.valueOf(character));
            button5.doClick(1);

        } else if (coordinates[0] == 1 && coordinates[1] == 2) {

//            button6.setText(String.valueOf(character));
            button6.doClick(1);

        } else if (coordinates[0] == 2 && coordinates[1] == 0) {

//            button7.setText(String.valueOf(character));
            button7.doClick(1);

        } else if (coordinates[0] == 2 && coordinates[1] == 1) {

//            button8.setText(String.valueOf(character));
            button8.doClick(1);

        } else if (coordinates[0] == 2 && coordinates[1] == 2) {

//            button9.setText(String.valueOf(character));
            button9.doClick(1);

        }

    }

    public char[][] placeRandomBeadByComputer2(char[][] existingBoard, int chance) {

        MatchBox matchBox = new MatchBox(10);
        int randomBead = matchBox.getRandomBeadFromBag();
        int[] getCoordinates = convertIntegerToCoordinate(randomBead);
        if (existingBoard[getCoordinates[0]][getCoordinates[1]] == ' ') {
            setButtonTextDependingOnCoordinates(getCoordinates, 'X');
            existingBoard[getCoordinates[0]][getCoordinates[1]] = returnCharacter(chance);
            return existingBoard;
        } else {
            matchBox.addParticularBeads(randomBead, 1);
            return placeRandomBeadByComputer2(existingBoard, chance);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        button7 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();
        p1win = new javax.swing.JTextField();
        noofdraw = new javax.swing.JTextField();
        totalmatch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        p2win = new javax.swing.JTextField();
        startButton = new javax.swing.JButton();

        button1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button1.setMaximumSize(new java.awt.Dimension(30, 30));
        button1.setMinimumSize(new java.awt.Dimension(30, 30));
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button2.setMaximumSize(new java.awt.Dimension(30, 30));
        button2.setMinimumSize(new java.awt.Dimension(30, 30));
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button3.setMaximumSize(new java.awt.Dimension(30, 30));
        button3.setMinimumSize(new java.awt.Dimension(30, 30));
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button4.setMaximumSize(new java.awt.Dimension(30, 30));
        button4.setMinimumSize(new java.awt.Dimension(30, 30));
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button5.setMaximumSize(new java.awt.Dimension(30, 30));
        button5.setMinimumSize(new java.awt.Dimension(30, 30));
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        button6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button6.setMaximumSize(new java.awt.Dimension(30, 30));
        button6.setMinimumSize(new java.awt.Dimension(30, 30));
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        button7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button7.setMaximumSize(new java.awt.Dimension(30, 30));
        button7.setMinimumSize(new java.awt.Dimension(30, 30));
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        button8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button8.setMaximumSize(new java.awt.Dimension(30, 30));
        button8.setMinimumSize(new java.awt.Dimension(30, 30));
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        button9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        button9.setMaximumSize(new java.awt.Dimension(30, 30));
        button9.setMinimumSize(new java.awt.Dimension(30, 30));
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Computer1 Win:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Computer2 Win:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Draw Match:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Total Match:");

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        startButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                startButtonKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(button4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(button8, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                    .addComponent(button5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(p2win, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(noofdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totalmatch, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(p1win))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(startButton)
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(p1win, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(p2win, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(noofdraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(totalmatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(162, 162, 162))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        // TODO add your handling code here:
        button2.setText(temp % 2 == 0 ? "O" : "X");
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        // TODO add your handling code here:
        button3.setText(temp % 2 == 0 ? "O" : "X");
    }//GEN-LAST:event_button6ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        // TODO add your handling code here:
        button4.setText(temp % 2 == 0 ? "O" : "X");
    }//GEN-LAST:event_button7ActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        // TODO add your handling code here:
        button8.setText(temp % 2 == 0 ? "O" : "X");
    }//GEN-LAST:event_button8ActionPerformed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
        // TODO add your handling code here:
        button9.setText(temp % 2 == 0 ? "O" : "X");
    }//GEN-LAST:event_button9ActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed

        System.out.println("Start Button Action Performed");
        try {
            playGame();
        } catch (InterruptedException ex) {
            java.util.logging.Logger.getLogger(CtoCJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_startButtonActionPerformed

    private void startButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_startButtonKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_startButtonKeyPressed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:

        button1.setText(temp % 2 == 0 ? "O" : "X");

    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        button2.setText(temp % 2 == 0 ? "O" : "X");
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });

//        button3.setText(temp % 2 == 0 ? "O" : "X");
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
        button4.setText(temp % 2 == 0 ? "O" : "X");
    }//GEN-LAST:event_button4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField noofdraw;
    private javax.swing.JTextField p1win;
    private javax.swing.JTextField p2win;
    private javax.swing.JButton startButton;
    private javax.swing.JTextField totalmatch;
    // End of variables declaration//GEN-END:variables
}
