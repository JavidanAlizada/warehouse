package anbar;

import database_src.DbConnector;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Girish extends javax.swing.JFrame {

    DbConnector dbconn;
    Connection conn;
    PreparedStatement cst;
    ResultSet rst;
    

    public Girish() {
        initComponents();
        try {
            dbconn = new DbConnector();
            conn = dbconn.connectToDatabase();
        } catch (Exception ex) {
            Logger.getLogger(Girish.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        şifrə = new javax.swing.JPasswordField();
        ad = new javax.swing.JTextField();
        qeydiyyat = new javax.swing.JButton();
        check = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Engravers MT", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Login");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 40, 150, 40);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Admin");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(210, 80, 60, 34);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Password");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(190, 130, 90, 30);

        şifrə.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        şifrə.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                şifrəKeyPressed(evt);
            }
        });
        jPanel1.add(şifrə);
        şifrə.setBounds(280, 130, 148, 33);

        ad.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        jPanel1.add(ad);
        ad.setBounds(280, 80, 148, 34);

        qeydiyyat.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        qeydiyyat.setText("Log in");
        qeydiyyat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        qeydiyyat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qeydiyyatActionPerformed(evt);
            }
        });
        jPanel1.add(qeydiyyat);
        qeydiyyat.setBounds(278, 180, 150, 34);

        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        jPanel1.add(check);
        check.setBounds(430, 130, 21, 33);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/iconfinder_Cancel_1493282 (1).png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5);
        jLabel5.setBounds(440, 10, 20, 20);
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(40, 80, 130, 10);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 470, 240);

        setSize(new java.awt.Dimension(488, 259));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void qeydiyyatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qeydiyyatActionPerformed
  if(conn!=null){
              
                
                String sql="select*from qeydiyyat where qeydiyyat.ad=? and qeydiyyat.sifre=?;";
                try {
                    cst=conn.prepareStatement(sql);
                
                cst.setString(1,ad.getText());
                
                cst.setString(2,şifrə.getText());
                
                rst=cst.executeQuery();
                if(true){
                 Ana_menyu men=new Ana_menyu();
                  
                 men.show();
                 this.hide();
                }
                else{
                 JOptionPane.showMessageDialog(null, "You have an error");
                }
                }
                catch (SQLException ex) {
                    Logger.getLogger(Girish.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }


    }//GEN-LAST:event_qeydiyyatActionPerformed

    private void şifrəKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_şifrəKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
         
           if(conn!=null){
              
                
                String sql="select*from qeydiyyat where qeydiyyat.ad=? and qeydiyyat.sifre=?;";
                try {
                    cst=conn.prepareStatement(sql);
                
                cst.setString(1,ad.getText());
                
                cst.setString(2,şifrə.getText());
                
                rst=cst.executeQuery();
                if(rst.next()){
                 Ana_menyu men=new Ana_menyu();
                  
                 men.show();
                 this.hide();
                }
                else{
                 JOptionPane.showMessageDialog(null, "You have an error");
                }
                }
                catch (SQLException ex) {
                    Logger.getLogger(Girish.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
        }


    }//GEN-LAST:event_şifrəKeyPressed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        if (check.isSelected()) {
            şifrə.setEchoChar((char) 0);
        } else {
            şifrə.setEchoChar('*');
        }
    }//GEN-LAST:event_checkActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Girish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Girish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Girish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Girish.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Girish().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ad;
    private javax.swing.JCheckBox check;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton qeydiyyat;
    private javax.swing.JPasswordField şifrə;
    // End of variables declaration//GEN-END:variables
}
