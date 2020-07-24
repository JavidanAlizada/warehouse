
package anbar;

import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import database_src.DbConnector;
public class IdxalAnbarDuzenleme extends javax.swing.JFrame {

    private Connection conn;
    private DbConnector connector;
    private ResultSet rst;
    private PreparedStatement cst;
    
    public IdxalAnbarDuzenleme() {
        initComponents();
        connector=new DbConnector();
        try {
            conn=connector.connectToDatabase();
        }  catch (Exception ex) {
            Logger.getLogger(IdxalAnbarDuzenleme.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        kod = new javax.swing.JTextField();
        ad = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        text2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        text3 = new javax.swing.JTextField();
        text1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Satish_Qiymeti = new javax.swing.JLabel();
        text4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        geri = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setText("Check");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(170, 120, 80, 28);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Name");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(60, 80, 50, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Code");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 40, 40, 30);

        kod.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(kod);
        kod.setBounds(120, 40, 130, 30);

        ad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(ad);
        ad.setBounds(120, 80, 130, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 40, 290, 160);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        text2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        text2.setEnabled(false);
        text2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text2KeyTyped(evt);
            }
        });
        jPanel2.add(text2);
        text2.setBounds(250, 140, 90, 30);

        jButton2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton2.setText("Edit");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(610, 200, 90, 30);

        text3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        text3.setEnabled(false);
        text3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text3KeyTyped(evt);
            }
        });
        jPanel2.add(text3);
        text3.setBounds(560, 90, 120, 30);

        text1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        text1.setEnabled(false);
        text1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text1KeyTyped(evt);
            }
        });
        jPanel2.add(text1);
        text1.setBounds(250, 90, 90, 30);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Purchasing cost for each product ");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 90, 220, 30);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("CBM of Product(CubeMeter)");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(40, 140, 190, 30);

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setText("Warehouse cost");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(410, 90, 130, 30);

        Satish_Qiymeti.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Satish_Qiymeti.setText("Sale cost");
        jPanel2.add(Satish_Qiymeti);
        Satish_Qiymeti.setBounds(440, 140, 110, 30);

        text4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        text4.setEnabled(false);
        text4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text4KeyTyped(evt);
            }
        });
        jPanel2.add(text4);
        text4.setBounds(560, 140, 120, 30);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Edit  Imported Products Data");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 10, 350, 50);
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(20, 60, 320, 20);

        jTextField1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("$");
        jTextField1.setEnabled(false);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(680, 90, 30, 30);

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextField2.setForeground(java.awt.Color.black);
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("$");
        jTextField2.setEnabled(false);
        jPanel2.add(jTextField2);
        jTextField2.setBounds(340, 90, 30, 30);

        jTextField3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("$");
        jTextField3.setEnabled(false);
        jPanel2.add(jTextField3);
        jTextField3.setBounds(680, 140, 30, 30);

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("cbm");
        jTextField4.setEnabled(false);
        jPanel2.add(jTextField4);
        jTextField4.setBounds(340, 140, 30, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 200, 730, 240);

        geri.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        geri.setForeground(new java.awt.Color(0, 102, 102));
        geri.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        geri.setText("Back");
        geri.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        geri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                geriMouseClicked(evt);
            }
        });
        getContentPane().add(geri);
        geri.setBounds(10, 450, 80, 32);

        setSize(new java.awt.Dimension(760, 533));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    if (conn != null) {
            
            String sql ="select distinct Mehsulun_kodu , Mehsul_ad ,Yerindeki_qiymeti ,Yeshikin_kub_meteri , Mehsulun_son_qiymeti ,Satish_qiymeti from mehsul_idxal , mehsul_qeydiyyat where Mehsulun_kodu=? and Mehsul_ad=? and Mehsulun_kodu=Mehsul_kod;";
            try {
                cst = conn.prepareStatement(sql);
                
                cst.setString(1, kod.getText());
                cst.setString(2, ad.getText());
                rst = cst.executeQuery();
                if (rst.next()) {
                   text1.setEnabled(true);
                   text2.setEnabled(true);
                   text3.setEnabled(true);
                   text4.setEnabled(true);
                    
                    text1.setText(String.valueOf(rst.getDouble(3)));
                    text2.setText(String.valueOf(rst.getString(4)));
                    text3.setText(String.valueOf(rst.getDouble(5)));
                    text4.setText(String.valueOf(rst.getDouble(6)));
                    
                    
                } else {
                   JOptionPane.showMessageDialog(null, "This product does not exist in warehouse please insert correct information ");
                   kod.setText("");
                   ad.setText("");
                   text1.setText("");
                   text2.setText("");
                   text3.setText("");
                   text4.setText("");
                   
                }
            } catch (SQLException ex) {
                Logger.getLogger(Mehsul_idxal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void text1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text1KeyTyped
   char c = evt.getKeyChar();
        if ((Character.isAlphabetic(c))) {
            evt.consume();
        }
    }//GEN-LAST:event_text1KeyTyped

    private void text2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text2KeyTyped
   char c = evt.getKeyChar();
        if ((Character.isAlphabetic(c))) {
            evt.consume();
        }
    }//GEN-LAST:event_text2KeyTyped

    private void text3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text3KeyTyped
   char c = evt.getKeyChar();
        if ((Character.isAlphabetic(c))) {
            evt.consume();
        }
    }//GEN-LAST:event_text3KeyTyped

    private void text4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text4KeyTyped
   char c = evt.getKeyChar();
        if ((Character.isAlphabetic(c))) {
            evt.consume();
        }
    }//GEN-LAST:event_text4KeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

         if (conn != null) {
            
             String sql = "update mehsul_idxal set Yerindeki_qiymeti=?, Yeshikin_kub_meteri=? , Mehsulun_son_qiymeti=? , Satish_qiymeti=? where Mehsulun_kodu=?;";
              
            try {
                cst = conn.prepareStatement(sql);
                cst.setString(5,kod.getText());
                cst.setString(1,text1.getText());
                cst.setString(2,text2.getText());
                cst.setString(3,text3.getText());
                cst.setString(4,text4.getText());
                int count =cst.executeUpdate();
                if (count>0) {
                    JOptionPane.showMessageDialog(null,"Editing is successful");
                    IdxalAnbarDuzenleme duz=new IdxalAnbarDuzenleme();
                    duz.show();
                    this.hide();
                } else {
                   
                }
            } catch (SQLException ex) {
                Logger.getLogger(Mehsul_idxal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }        

    }//GEN-LAST:event_jButton2ActionPerformed

    private void geriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_geriMouseClicked

        Ana_menyu menyu=new Ana_menyu();
        menyu.show();
        this.hide();

    }//GEN-LAST:event_geriMouseClicked

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
            java.util.logging.Logger.getLogger(IdxalAnbarDuzenleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IdxalAnbarDuzenleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IdxalAnbarDuzenleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IdxalAnbarDuzenleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IdxalAnbarDuzenleme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Satish_Qiymeti;
    private javax.swing.JTextField ad;
    private javax.swing.JLabel geri;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField kod;
    private javax.swing.JTextField text1;
    private javax.swing.JTextField text2;
    private javax.swing.JTextField text3;
    private javax.swing.JTextField text4;
    // End of variables declaration//GEN-END:variables
}
