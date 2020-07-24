
package anbar;

import java.sql.*;
import database_src.DbConnector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Mehsul_qeydiyyat extends javax.swing.JFrame {

    DbConnector  db_conn;
    Connection conn;
    PreparedStatement cst;
    
    
    public Mehsul_qeydiyyat() {
        initComponents();
       db_conn=new DbConnector();
        try {
            conn=db_conn.connectToDatabase();
        } catch (Exception ex) {
            Logger.getLogger(Mehsul_qeydiyyat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Mehsul_ad = new javax.swing.JLabel();
        Olchu = new javax.swing.JLabel();
        Mehsul_kod = new javax.swing.JLabel();
        Ad_text = new javax.swing.JTextField();
        Olchu_text = new javax.swing.JTextField();
        Kod_text = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Reng = new javax.swing.JLabel();
        Firma_text = new javax.swing.JTextField();
        Reng_text = new javax.swing.JTextField();
        Mehsul_qeydiyyat = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Product Register");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Console", 0, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.black);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Product Register");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 70, 250, 44);

        Mehsul_ad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Mehsul_ad.setText("Name");
        getContentPane().add(Mehsul_ad);
        Mehsul_ad.setBounds(70, 160, 60, 30);

        Olchu.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Olchu.setText("Size");
        getContentPane().add(Olchu);
        Olchu.setBounds(70, 260, 70, 30);

        Mehsul_kod.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Mehsul_kod.setText("Code");
        getContentPane().add(Mehsul_kod);
        Mehsul_kod.setBounds(70, 210, 60, 30);

        Ad_text.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(Ad_text);
        Ad_text.setBounds(140, 160, 120, 30);

        Olchu_text.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(Olchu_text);
        Olchu_text.setBounds(140, 260, 120, 30);

        Kod_text.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(Kod_text);
        Kod_text.setBounds(140, 210, 120, 30);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Supplier");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 360, 60, 30);

        Reng.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Reng.setText("Color");
        getContentPane().add(Reng);
        Reng.setBounds(70, 310, 50, 30);

        Firma_text.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(Firma_text);
        Firma_text.setBounds(140, 360, 120, 30);

        Reng_text.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        getContentPane().add(Reng_text);
        Reng_text.setBounds(140, 310, 120, 30);

        Mehsul_qeydiyyat.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Mehsul_qeydiyyat.setText("Register");
        Mehsul_qeydiyyat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mehsul_qeydiyyatActionPerformed(evt);
            }
        });
        getContentPane().add(Mehsul_qeydiyyat);
        Mehsul_qeydiyyat.setBounds(130, 420, 140, 40);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Back");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 470, 70, 30);

        setSize(new java.awt.Dimension(411, 552));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Mehsul_qeydiyyatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mehsul_qeydiyyatActionPerformed
     if(conn!=null){
     
         String sql="insert into mehsul_qeydiyyat(Mehsul_kod,Mehsul_ad,Mehsul_olcu,Mehsul_rengi,Istehsalci_firma,Qeydiyyat_tarixi) values(?,?,?,?,?,?);";
         String sql1="insert into umumi_anbar(Mehsul_qeydiyyat_KOD,um_Mehsul_sayi,um_Yeshik_sayi) values(?,0,0);";
         try {
             cst=conn.prepareStatement(sql);
             cst.setString(1,Kod_text.getText());
             cst.setString(2,Ad_text.getText());
             cst.setString(3,Olchu_text.getText());
             cst.setString(4,Reng_text.getText());
             cst.setString(5,Firma_text.getText());
             Timestamp st=new Timestamp(System.currentTimeMillis());
             cst.setString(6,String.valueOf(st));
             
             
             int count=cst.executeUpdate();
             if(count>0){
                 cst=conn.prepareStatement(sql1);
                 cst.setString(1,Kod_text.getText());
                 int count2=cst.executeUpdate();
                 if(count2>0){
                 JOptionPane.showMessageDialog(null,"Registration is completed");
                 Mehsul_qeydiyyat qeydiyyat=new Mehsul_qeydiyyat();
                 this.hide();
                 qeydiyyat.show();
             }
          else{
             JOptionPane.showMessageDialog(null,"Fail");
             }

             }
             else{
             JOptionPane.showMessageDialog(null,"Insert correctly");
             }
         } catch (SQLException ex) {
            Logger.getLogger(Mehsul_qeydiyyat.class.getName()).log(Level.SEVERE, null, ex);
              // JOptionPane.showMessageDialog(null,"Failure in registration.It can be happen because of  exist product inserting");
         
         }
       
     }
    }//GEN-LAST:event_Mehsul_qeydiyyatActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       Ana_menyu men=new Ana_menyu();
       men.show();
       this.hide();
    }//GEN-LAST:event_jLabel2MouseClicked
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
            java.util.logging.Logger.getLogger(Mehsul_qeydiyyat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mehsul_qeydiyyat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mehsul_qeydiyyat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mehsul_qeydiyyat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mehsul_qeydiyyat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Ad_text;
    private javax.swing.JTextField Firma_text;
    private javax.swing.JTextField Kod_text;
    private javax.swing.JLabel Mehsul_ad;
    private javax.swing.JLabel Mehsul_kod;
    private javax.swing.JButton Mehsul_qeydiyyat;
    private javax.swing.JLabel Olchu;
    private javax.swing.JTextField Olchu_text;
    private javax.swing.JLabel Reng;
    private javax.swing.JTextField Reng_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
