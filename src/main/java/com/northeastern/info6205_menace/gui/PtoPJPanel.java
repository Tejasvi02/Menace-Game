/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.northeastern.info6205_menace.gui;

/**
 *
 * @author kashr
 */
public class PtoPJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PtoPJPanel
     */
    public PtoPJPanel() {
        initComponents();
    }
    char[][] game = new char[][]{{' ', ' ',' '}, {' ', ' ',' '},{' ', ' ',' '}};
    int[] rows= new int[3];
    int[] column= new int[3];
    int diagonal =0 , antidiagonal =0 ;
    
    public void checkforwin(int row, int col){
         if (rows[row] == 3 ||
               (column[col]) == 3 ||
               (diagonal) == 3 ||
               (antidiagonal) == 3) {
             checkwin.setText("Player O won!!");
              }
         else if (rows[row] == -3 ||
               (column[col]) == -3 ||
               (diagonal) == -3 ||
               (antidiagonal) == -3){
             checkwin.setText("Player X won!!");
         }
         else if(temp>8)
             checkwin.setText("It is a draw match");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    int temp=0;
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
        checkwin = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(102, 0, 0));

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

        checkwin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        checkwin.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(button4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(button5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button6, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addComponent(checkwin, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkwin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        // TODO add your handling code here:
           if(button5.getText().equals(""))
           {
               if(temp%2==0){
           rows[1]++;
           column[1]++;
           diagonal++;
           antidiagonal++;
        button5.setText("O");}
           else{
           rows[1]--;
           column[1]--;
           diagonal--;
           antidiagonal--;
               button5.setText("X");
           }
        temp++;
        checkforwin(1,1);
           }
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        // TODO add your handling code here:
        if(button6.getText().equals(""))
           {
           if(temp%2==0){
              rows[1]++;
              column[2]++;
        button6.setText("O");}
           else{
                rows[1]--;
                column[2]--;

               button6.setText("X");
           }
        temp++;
        checkforwin(1,2);
           }
    }//GEN-LAST:event_button6ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        // TODO add your handling code here:
        if(button7.getText().equals(""))
           {
           if(temp%2==0){
               rows[2]++;
              column[0]++;
              antidiagonal++;
             button7.setText("O");}
           else{   
               rows[2]--;
              column[0]--;
              antidiagonal--;
               button7.setText("X");
           }
        temp++;
        checkforwin(2,0);
           }
    }//GEN-LAST:event_button7ActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        // TODO add your handling code here:
        if(button8.getText().equals(""))
           {
                 if(temp%2==0){
                     rows[2]++;
                     column[1]++;
                     button8.setText("O");}
        else {
                rows[2]--;
                column[1]--;
                 button8.setText("X");
                 }
        temp++;
    checkforwin(2,1);
           }
    }//GEN-LAST:event_button8ActionPerformed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
        // TODO add your handling code here:
        if(button9.getText().equals(""))
           {
             if(temp%2==0){
                 rows[2]++;
                 column[2]++;
                 diagonal++;
                  button9.setText("O");
             }
        else {
                 rows[2]--;
                 column[2]--;
                 diagonal--;
                 button9.setText("X");
             }
        temp++;
        checkforwin(2,2);
           }
    }//GEN-LAST:event_button9ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        if(button1.getText().equals(""))
           {
        if(temp%2==0){
           // game[0][0]='O';
           rows[0]++;
           column[0]++;
           diagonal++;
        button1.setText("O");}
        else {
           // game[0][0]='X';
            rows[0]--;
           column[0]--;
           diagonal--;
            button1.setText("X");
        }
        temp++;
        checkforwin(0,0);
    }
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        if(button2.getText().equals(""))
           {
           if(temp%2==0){
           rows[0]++;
           column[1]++;
           
        button2.setText("O");}
        else {
           rows[0]--;
           column[1]--;
           
               button2.setText("X");}
        temp++;
        checkforwin(0,1);
           }
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        if(button3.getText().equals(""))
           {
                if(temp%2==0){
           rows[0]++;
           column[2]++;
           antidiagonal++;
        button3.setText("O");}
        else {
           rows[0]--;
           column[2]--;
           antidiagonal--;
                    button3.setText("X");
                }
        temp++;
        checkforwin(0,2);
           }
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
        if(button4.getText().equals(""))
           {
                  if(temp%2==0){
                      rows[1]++;
                      column[0]++;
        button4.setText("O");}
        else {
                      rows[1]--;
                      column[0]--;
                      button4.setText("X");
                  }
        temp++;
        checkforwin(1,0);
           }
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
    private javax.swing.JLabel checkwin;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
