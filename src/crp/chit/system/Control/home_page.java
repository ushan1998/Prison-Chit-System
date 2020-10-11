/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crp.chit.system.Control;

import crp.chit.system.Dao.admin_dao;
import crp.chit.system.Dao.visits_dao;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Osura
 */
public class home_page extends javax.swing.JFrame {

    private static int result,v_id,row;
    private static int adminId =0;
    private static Vector v1=null;
    /**
     * Creates new form home_page
     */

    public home_page(int adminId) {
        initComponents();
        chitFill();
        this.adminId= adminId;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        REFRESH = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        APPROVE = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Chit_Table = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(1130, 600));

        jButton9.setBackground(new java.awt.Color(102, 102, 102));
        jButton9.setForeground(new java.awt.Color(240, 240, 240));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-family-48.png"))); // NOI18N
        jButton9.setText("Visitors");
        jButton9.setFocusPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        REFRESH.setBackground(new java.awt.Color(0, 204, 204));
        REFRESH.setForeground(new java.awt.Color(240, 240, 240));
        REFRESH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-sync-48.png"))); // NOI18N
        REFRESH.setText("Refresh");
        REFRESH.setFocusPainted(false);
        REFRESH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                REFRESHActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 0, 0));
        jButton8.setForeground(new java.awt.Color(240, 240, 240));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-unlike-48.png"))); // NOI18N
        jButton8.setText("Not Approve");
        jButton8.setFocusPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        APPROVE.setBackground(new java.awt.Color(0, 204, 0));
        APPROVE.setForeground(new java.awt.Color(240, 240, 240));
        APPROVE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-thumbs-up-48.png"))); // NOI18N
        APPROVE.setText("Approve");
        APPROVE.setFocusPainted(false);
        APPROVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                APPROVEActionPerformed(evt);
            }
        });

        Chit_Table.setBackground(new java.awt.Color(255, 255, 153));
        Chit_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Visit ID", "Time", "Date", "Place", "Status", "Relation To Prisoner", "Visitor Id", "Prisoner ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Chit_Table.setSurrendersFocusOnKeystroke(true);
        Chit_Table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Chit_Table);
        if (Chit_Table.getColumnModel().getColumnCount() > 0) {
            Chit_Table.getColumnModel().getColumn(0).setResizable(false);
            Chit_Table.getColumnModel().getColumn(1).setResizable(false);
            Chit_Table.getColumnModel().getColumn(2).setResizable(false);
            Chit_Table.getColumnModel().getColumn(3).setResizable(false);
            Chit_Table.getColumnModel().getColumn(4).setResizable(false);
            Chit_Table.getColumnModel().getColumn(5).setResizable(false);
            Chit_Table.getColumnModel().getColumn(5).setPreferredWidth(120);
            Chit_Table.getColumnModel().getColumn(6).setResizable(false);
            Chit_Table.getColumnModel().getColumn(7).setResizable(false);
        }

        jButton6.setBackground(new java.awt.Color(102, 102, 102));
        jButton6.setForeground(new java.awt.Color(240, 240, 240));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-leaving-queue-48.png"))); // NOI18N
        jButton6.setText("Moving Prisoners");
        jButton6.setToolTipText("");
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(102, 102, 102));
        jButton5.setForeground(new java.awt.Color(240, 240, 240));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-tv-48.png"))); // NOI18N
        jButton5.setText("Prison Display");
        jButton5.setFocusPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 102, 102));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(240, 240, 240));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-scale-of-justice-48.png"))); // NOI18N
        jButton4.setText("Courts");
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(240, 240, 240));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-businessman-48 (1).png"))); // NOI18N
        jButton3.setText("Admins");
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setForeground(new java.awt.Color(240, 240, 240));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-man-at-computer-48.png"))); // NOI18N
        jButton2.setText("Visits");
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setForeground(new java.awt.Color(240, 240, 240));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-prisoner-48.png"))); // NOI18N
        jButton1.setText("Prisoners");
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(251, 197, 49));

        jButton7.setBackground(new java.awt.Color(102, 102, 102));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-exit-filled-50 (1).png"))); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setFocusPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("STXinwei", 2, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126)
                .addComponent(jButton7)
                .addGap(52, 52, 52))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(jButton7)))
                .addContainerGap())
        );

        jButton10.setBackground(new java.awt.Color(102, 102, 102));
        jButton10.setForeground(new java.awt.Color(240, 240, 240));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8-tv-48.png"))); // NOI18N
        jButton10.setText("Visitors Display");
        jButton10.setFocusPainted(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(APPROVE)
                        .addGap(88, 88, 88)
                        .addComponent(jButton8)
                        .addGap(100, 100, 100)
                        .addComponent(REFRESH)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(APPROVE, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(REFRESH))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1152, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //To show a new prisoner interface.
        prisoner_interface p1 = new prisoner_interface(adminId);
        p1.show();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        //To show a new admin interface.
        admin_details_interface a1 = new admin_details_interface(adminId);
        a1.show();
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        //To show a new visits interface.
        visits_interface v1 = new visits_interface(adminId);
        v1.show();
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        //To show a new courts interface.
        courts_interface c1 = new courts_interface(adminId);
        c1.show();
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        //To show a new prison display.
        prison_display p_display = new prison_display(adminId);
        p_display.show();
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        //To show a new prisoner move interface.
        prisoner_move_interface move = new prisoner_move_interface(adminId);
        move.show();
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void REFRESHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_REFRESHActionPerformed

        //By calling this function each time the refresh button is clicked it will fill up the jTable if there's new chits to be approved.
        home_page home = new home_page(adminId);
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_REFRESHActionPerformed

    private void APPROVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_APPROVEActionPerformed
        try{
            
        //By pressing this button the selected row will be updated.
        row = Chit_Table.getSelectedRow(); 
        v_id = Integer.valueOf(Chit_Table.getValueAt(row, 0).toString());
        result = admin_dao.chitApprove(v_id,adminId);
        //If i returns a true/false value display the relavant message to user.
        if(result==1){
            JOptionPane.showMessageDialog(null, "Chit approved successfully","System",JOptionPane.INFORMATION_MESSAGE);
            home_page home = new home_page(adminId);
            home.setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Failed to approve the chit","System",JOptionPane.ERROR_MESSAGE);
            home_page home = new home_page(adminId);
            home.setVisible(true);
            dispose();
        }
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Please select a row","System",JOptionPane.ERROR_MESSAGE);
           e.printStackTrace();
       }
    }//GEN-LAST:event_APPROVEActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        //Click here to logout as an admin and go back to chit interface
        startup s1 = new startup();
        s1.setVisible(true);
        this.adminId = 0;
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        //click here to go to visitors page.
        visitors_interface v1 = new visitors_interface(adminId);
        v1.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try{
            // TODO add your handling code here:
        //click here to delete a visit.
        row = Chit_Table.getSelectedRow();
        v_id = Integer.valueOf(Chit_Table.getValueAt(row, 0).toString());
        result = visits_dao.deleteVisit(v_id);
        //if the result is true/false display relavant information to the user.
        if(result==1){
            JOptionPane.showMessageDialog(null, "Visit successfully deleted","System",JOptionPane.INFORMATION_MESSAGE);
            home_page home = new home_page(adminId);
            home.setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Failed to delete","System",JOptionPane.ERROR_MESSAGE);
        }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please select a row","System",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        visitor_display v1 = new visitor_display(adminId);
        v1.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home_page(adminId).setVisible(true);
            }
        });
    }
    //Call this method to get all the not approved chits and display in the jTable.
    public void chitFill(){
        v1 = admin_dao.getChits();
        DefaultTableModel model = (DefaultTableModel) Chit_Table.getModel();
        if(v1==null){
            
        }else{
            for(int i =0; i<v1.size(); i++){
            model.addRow((Vector) v1.get(i));
            }   
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton APPROVE;
    private javax.swing.JTable Chit_Table;
    private javax.swing.JButton REFRESH;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}