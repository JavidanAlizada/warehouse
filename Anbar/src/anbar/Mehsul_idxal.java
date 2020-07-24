package anbar;

import database_src.DbConnector;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Mehsul_idxal extends javax.swing.JFrame {
    
    DbConnector db_conn;
    Connection conn;
    PreparedStatement cst;
    ResultSet rst;
    
    boolean verify = false;

    public Mehsul_idxal() {
        initComponents();
        
        db_conn = new DbConnector();
        try {
            conn = db_conn.connectToDatabase();
        }  catch (Exception ex) {
            Logger.getLogger(Mehsul_qeydiyyat.class.getName()).log(Level.SEVERE, null, ex);
        }
        jPanel2.setFocusable(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        dogrula_ad = new javax.swing.JTextField();
        dogrula_kod = new javax.swing.JTextField();
        dogrulama = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        geri = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Satish_Qiymeti = new javax.swing.JLabel();
        item = new javax.swing.JTextField();
        boxArea = new javax.swing.JTextField();
        box = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        itemCost = new javax.swing.JTextField();
        itemAmount = new javax.swing.JTextField();
        satish_qiymeti = new javax.swing.JTextField();
        qeydiyyatdan_kecir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Import page");
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/info-sign.png"))); // NOI18N
        info.setToolTipText("Qiymət təyin etmək üçün kod və ad daxil edin və doğrulayın");
        info.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(info);
        info.setBounds(160, 10, 30, 32);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Click here for extra info");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 10, 150, 30);

        jLabel14.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel14.setText("Name");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(10, 109, 50, 30);

        jLabel15.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel15.setText("Code");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(10, 70, 40, 30);

        dogrula_ad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel2.add(dogrula_ad);
        dogrula_ad.setBounds(60, 113, 110, 30);

        dogrula_kod.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel2.add(dogrula_kod);
        dogrula_kod.setBounds(60, 73, 110, 30);

        dogrulama.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        dogrulama.setText("Validate");
        dogrulama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dogrulamaActionPerformed(evt);
            }
        });
        jPanel2.add(dogrulama);
        dogrulama.setBounds(190, 130, 100, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(30, 90, 300, 170);

        jLabel1.setFont(new java.awt.Font("DialogInput", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Import Product");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(280, 10, 390, 70);

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
        geri.setBounds(20, 470, 80, 32);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Product quantity for each carton");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 120, 220, 30);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Purchasing cost for each product ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(80, 170, 220, 30);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("CBM of Product(CubeMeter)");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(100, 220, 190, 30);

        Satish_Qiymeti.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Satish_Qiymeti.setText("Sale cost");
        jPanel1.add(Satish_Qiymeti);
        Satish_Qiymeti.setBounds(190, 320, 110, 30);

        item.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        item.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itemKeyTyped(evt);
            }
        });
        jPanel1.add(item);
        item.setBounds(310, 120, 170, 30);

        boxArea.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        boxArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                boxAreaKeyTyped(evt);
            }
        });
        jPanel1.add(boxArea);
        boxArea.setBounds(310, 220, 170, 30);

        box.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        box.setToolTipText("");
        box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                boxKeyTyped(evt);
            }
        });
        jPanel1.add(box);
        box.setBounds(310, 70, 170, 30);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Enter data");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(210, 0, 170, 50);

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setText("Imported product quantity(with carton)");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(50, 70, 250, 30);

        jLabel12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel12.setText("Warehouse cost");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(160, 270, 130, 30);

        itemCost.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itemCostKeyTyped(evt);
            }
        });
        jPanel1.add(itemCost);
        itemCost.setBounds(310, 170, 170, 30);

        itemAmount.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itemAmountKeyTyped(evt);
            }
        });
        jPanel1.add(itemAmount);
        itemAmount.setBounds(310, 270, 170, 30);

        satish_qiymeti.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                satish_qiymetiKeyTyped(evt);
            }
        });
        jPanel1.add(satish_qiymeti);
        satish_qiymeti.setBounds(310, 320, 170, 30);

        qeydiyyatdan_kecir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        qeydiyyatdan_kecir.setText("Insert");
        qeydiyyatdan_kecir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qeydiyyatdan_kecirActionPerformed(evt);
            }
        });
        jPanel1.add(qeydiyyatdan_kecir);
        qeydiyyatdan_kecir.setBounds(470, 370, 170, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(330, 90, 650, 420);

        setSize(new java.awt.Dimension(1015, 556));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private int boxVar;
    private int itemVar;
   /* private double itemCostVar;
    private double boxAreaVar;
    private double cubeCostVar;
    private double itemPlacePaymentVar;
    private double transportationCostVar;
    private double totalAmountVar;
    private double itemAmountVar;
    */
    /*
    private double yerindeOdenilenMebleg() {
        
        boxVar = Integer.parseInt(box.getText());
        itemVar = Integer.parseInt(item.getText());
        itemCostVar = Double.parseDouble(itemCost.getText());
        itemPlacePaymentVar = boxVar * itemVar * itemCostVar;
        return itemPlacePaymentVar;
        
    }
    */
    /*
    private double umumiDashinmaXerci() {
        
        boxVar = Integer.parseInt(box.getText());
        boxAreaVar = Double.parseDouble(boxArea.getText());
        cubeCostVar = Double.parseDouble(cubeCost.getText());
        transportationCostVar = boxVar * boxAreaVar * cubeCostVar;
        return transportationCostVar;
    }
    */
    /*
    private double umumiSonMebleg() {
        
        totalAmountVar = yerindeOdenilenMebleg() + umumiDashinmaXerci();
        return totalAmountVar;
    }
    */
   /* 
    private double mehsulEdedineGoreSonQiymet() {
        double toplamMehsul = boxVar * itemVar;
        itemAmountVar = totalAmountVar / toplamMehsul;
        return itemAmountVar;
    }*/
    
    
   

    private void boxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxKeyTyped
        char c = evt.getKeyChar();
        if ((Character.isAlphabetic(c))) {
            evt.consume();
        }
    }//GEN-LAST:event_boxKeyTyped

    private void itemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemKeyTyped
        
        char c = evt.getKeyChar();
        if ((Character.isAlphabetic(c))) {
            evt.consume();
        }
    }//GEN-LAST:event_itemKeyTyped

    private void itemCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemCostKeyTyped
        char c = evt.getKeyChar();
        if ((Character.isAlphabetic(c))) {
            evt.consume();
        }
    }//GEN-LAST:event_itemCostKeyTyped

    private void boxAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxAreaKeyTyped
        char c = evt.getKeyChar();
        if ((Character.isAlphabetic(c))) {
            evt.consume();
        }
    }//GEN-LAST:event_boxAreaKeyTyped

    private void dogrulamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dogrulamaActionPerformed
        if (conn != null) {
            
            String sql = "select mehsul_qeydiyyat.Mehsul_kod , mehsul_qeydiyyat.Mehsul_ad from mehsul_qeydiyyat where mehsul_qeydiyyat.Mehsul_kod=? and mehsul_qeydiyyat.Mehsul_ad=?;";
            try {
                cst = conn.prepareStatement(sql);
                
                cst.setString(1, dogrula_kod.getText());
                cst.setString(2, dogrula_ad.getText());
                rst = cst.executeQuery();
                if (rst.next()) {
                    JOptionPane.showMessageDialog(null, "Product exists in warehouse");
                    verify = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Product does not exist in warehouse , please check info correctly");
                   dogrula_kod.setText("");
                   dogrula_ad.setText("");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Mehsul_idxal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }        
    }//GEN-LAST:event_dogrulamaActionPerformed

    private void satish_qiymetiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_satish_qiymetiKeyTyped
        char c = evt.getKeyChar();
        if ((Character.isAlphabetic(c))) {
            evt.consume();
        }
    }//GEN-LAST:event_satish_qiymetiKeyTyped

    private long mehsulSayi(){
    
        return Integer.valueOf(box.getText())*Integer.valueOf(item.getText());
    }

    private void qeydiyyatdan_kecirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qeydiyyatdan_kecirActionPerformed
        
        if (verify) {
            
            if (conn != null) {
                
                String sql = "insert into mehsul_idxal(Mehsulun_kodu,Yeshik_sayi,Mehsul_sayi,Yerindeki_qiymeti,Yeshikin_kub_meteri,Mehsulun_son_qiymeti,Satish_qiymeti,Idxal_tarixi) VALUES(?,?,?,?,?,?,?,?);";
                String sql0 ="update mehsul_idxal set Yerindeki_qiymeti=?,Yeshikin_kub_meteri=?,Mehsulun_son_qiymeti=?,Satish_qiymeti=? where Mehsulun_kodu=?"; 
                String sql1="update umumi_anbar set um_Mehsul_sayi=(select sum(Mehsul_sayi) from mehsul_idxal where Mehsul_qeydiyyat_KOD=Mehsulun_kodu group by Mehsulun_kodu having Mehsul_sayi>=0)";
                String sql2="update umumi_anbar set um_Yeshik_sayi=(select sum(Yeshik_sayi) from mehsul_idxal where Mehsul_qeydiyyat_KOD=Mehsulun_kodu group by Mehsulun_kodu having Yeshik_sayi>=0)";
                String sql3="insert INTO tutum(kod , miqdar) values (?,?);";
                try {
                    cst = conn.prepareStatement(sql);
                    cst.setString(1, dogrula_kod.getText());
                    cst.setString(2, box.getText());
                    cst.setString(3, String.valueOf(mehsulSayi()));
                    cst.setString(4, itemCost.getText());
                    cst.setString(5, boxArea.getText());
                    cst.setString(6, itemAmount.getText());
                    cst.setString(7, satish_qiymeti.getText());
                    Timestamp st=new Timestamp(System.currentTimeMillis());
                    
                    cst.setString(8,String.valueOf(st));
                    int count = cst.executeUpdate();
                    if (count > 0) {
                    cst = conn.prepareStatement(sql0);
                    cst.setString(5, dogrula_kod.getText());
                    cst.setString(1, itemCost.getText());
                    cst.setString(2, boxArea.getText());
                    cst.setString(3, itemAmount.getText());
                    cst.setString(4, satish_qiymeti.getText());
                    int count0 = cst.executeUpdate();
                    if(count0>0){
                        cst=conn.prepareStatement(sql1);
                       // cst.setString(1,dogrula_kod.getText());
                        int count2=cst.executeUpdate();
                        if(count2>0){
                         cst=conn.prepareStatement(sql2);
                       //  cst.setString(1,dogrula_kod.getText());
                        int count3=cst.executeUpdate();
                        if(count3>0){
                            cst=conn.prepareStatement(sql3);
                            cst.setString(1,dogrula_kod.getText());
                            cst.setString(2,item.getText());
                            int count4=cst.executeUpdate();
                            if(count4>0){
                            JOptionPane.showMessageDialog(null, "Registration is completed success");
                        Mehsul_idxal teyin = new Mehsul_idxal();
                        this.hide();
                        teyin.show();
                        }
                        }
                    }
                    }
                        else{
                         
                        //JOptionPane.showMessageDialog(null,"Error","Error",0);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Failure in Registration","Failure",0);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Mehsul_idxal.class.getName()).log(Level.SEVERE, null, ex);
                  ///    JOptionPane.showMessageDialog(null,"Səhvlik var");
                
                }
            }
            
        } else {
            
            JOptionPane.showMessageDialog(null, "Please verify product");
            
        }
    }//GEN-LAST:event_qeydiyyatdan_kecirActionPerformed

    private void geriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_geriMouseClicked
                
                Ana_menyu menyu=new Ana_menyu();
                menyu.show();
                this.hide();
                    
        
    }//GEN-LAST:event_geriMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
      
    }//GEN-LAST:event_formMouseClicked

    private void itemAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemAmountKeyTyped
        char c = evt.getKeyChar();
        if ((Character.isAlphabetic(c))) {
            evt.consume();
        }
    }//GEN-LAST:event_itemAmountKeyTyped

    
    
    /**/
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
            java.util.logging.Logger.getLogger(Mehsul_idxal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mehsul_idxal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mehsul_idxal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mehsul_idxal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mehsul_idxal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Satish_Qiymeti;
    private javax.swing.JTextField box;
    private javax.swing.JTextField boxArea;
    private javax.swing.JTextField dogrula_ad;
    private javax.swing.JTextField dogrula_kod;
    private javax.swing.JButton dogrulama;
    private javax.swing.JLabel geri;
    private javax.swing.JLabel info;
    private javax.swing.JTextField item;
    private javax.swing.JTextField itemAmount;
    private javax.swing.JTextField itemCost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton qeydiyyatdan_kecir;
    private javax.swing.JTextField satish_qiymeti;
    // End of variables declaration//GEN-END:variables
}
