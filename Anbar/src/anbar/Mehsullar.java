package anbar;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import database_src.DbConnector;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Mehsullar extends javax.swing.JFrame {
   
    private Connection conn;
    private PreparedStatement cst;
    private ResultSet rst;
    DbConnector connector;

    public Mehsullar() {
        initComponents();
        connector = new DbConnector();
        try {
            conn = connector.connectToDatabase();
        } catch (Exception ex) {
            Logger.getLogger(Mehsullar.class.getName()).log(Level.SEVERE, null, ex);
        }
        mehsullarGoster();
    }

    private ArrayList<Mehsullar_Bean> mehsulList() {
        if (conn != null) {
            ArrayList<Mehsullar_Bean> list = new ArrayList<>();
            String sql = "select distinct Mehsul_kod , Mehsul_ad , um_Yeshik_sayi, um_Mehsul_sayi , Mehsulun_son_qiymeti , Satish_qiymeti from mehsul_qeydiyyat , mehsul_idxal ,umumi_anbar where Mehsulun_kodu=Mehsul_kod and Mehsul_qeydiyyat_KOD=Mehsul_kod order by Mehsul_Kod";
            try {
                cst = conn.prepareStatement(sql);
                rst = cst.executeQuery();
                Mehsullar_Bean bean;
                while (rst.next()) {
                    bean = new Mehsullar_Bean(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getInt(4),
                            rst.getDouble(5), rst.getDouble(6));
                    list.add(bean);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Mehsullar.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
        }
        System.out.println("connection error");
        return null;
    }

    private void mehsullarGoster() {
        ArrayList<Mehsullar_Bean> list = mehsulList();
        DefaultTableModel model = (DefaultTableModel) mehsul_table.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getAd();
            row[1] = list.get(i).getKod();
            row[2] = list.get(i).getYeshik_say();
            row[3] = list.get(i).getSay();
            row[4] = list.get(i).getAnbar_qiymet() + " $";
            row[5] = list.get(i).getSatish_qiymet() + " $";
            model.addRow(row);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Axtar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        mehsul_table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Ad1 = new javax.swing.JTextField();
        Say1 = new javax.swing.JTextField();
        Anbar_qiymet1 = new javax.swing.JTextField();
        Satish_qiymet1 = new javax.swing.JTextField();
        Kod1 = new javax.swing.JTextField();
        ixrac = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Products");
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Search(Enter code)");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 10, 110, 30);

        Axtar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Axtar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AxtarKeyPressed(evt);
            }
        });
        jPanel1.add(Axtar);
        Axtar.setBounds(140, 10, 130, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 140, 300, 50);

        mehsul_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Carton", "Quantity", "Warehouse Cost", "Sale Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        mehsul_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mehsul_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(mehsul_table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(313, 0, 690, 510);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Name");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 60, 60, 30);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Quantity");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 100, 60, 30);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Buy Price");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 140, 100, 30);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Sell Price");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 180, 100, 30);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Code");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 20, 60, 30);

        Ad1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Ad1.setEnabled(false);
        Ad1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Ad1FocusGained(evt);
            }
        });
        jPanel2.add(Ad1);
        Ad1.setBounds(120, 60, 120, 30);

        Say1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Say1.setEnabled(false);
        Say1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Say1KeyTyped(evt);
            }
        });
        jPanel2.add(Say1);
        Say1.setBounds(120, 100, 120, 30);

        Anbar_qiymet1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Anbar_qiymet1.setEnabled(false);
        Anbar_qiymet1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Anbar_qiymet1FocusGained(evt);
            }
        });
        jPanel2.add(Anbar_qiymet1);
        Anbar_qiymet1.setBounds(120, 140, 120, 30);

        Satish_qiymet1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Satish_qiymet1.setEnabled(false);
        Satish_qiymet1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Satish_qiymet1FocusGained(evt);
            }
        });
        jPanel2.add(Satish_qiymet1);
        Satish_qiymet1.setBounds(120, 180, 120, 30);

        Kod1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Kod1.setEnabled(false);
        Kod1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Kod1FocusGained(evt);
            }
        });
        jPanel2.add(Kod1);
        Kod1.setBounds(120, 20, 120, 30);

        ixrac.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ixrac.setText("Export");
        ixrac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ixracActionPerformed(evt);
            }
        });
        jPanel2.add(ixrac);
        ixrac.setBounds(203, 230, 80, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 200, 300, 270);

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
        jLabel2.setBounds(10, 470, 70, 40);

        setSize(new java.awt.Dimension(1027, 551));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mehsul_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mehsul_tableMouseClicked
        try {
            int row = mehsul_table.getSelectedRow();
            String Table_Click = mehsul_table.getModel().getValueAt(row, 0).toString();
            String sql = "select DISTINCT Mehsul_kod , Mehsul_ad ,um_Mehsul_sayi , Mehsulun_son_qiymeti ,Satish_qiymeti from mehsul_qeydiyyat , mehsul_idxal ,umumi_anbar where Mehsulun_kodu=Mehsul_kod and Mehsul_qeydiyyat_KOD=Mehsul_kod and Mehsul_kod=?";
            cst = conn.prepareStatement(sql);
            cst.setString(1, Table_Click);
            rst = cst.executeQuery();
            if (rst.next()) {
                Kod1.setEnabled(true);
                Ad1.setEnabled(true);
                Say1.setEnabled(true);
                Anbar_qiymet1.setEnabled(true);
                Satish_qiymet1.setEnabled(true);

                Kod1.setText(rst.getString("Mehsul_kod"));
                Ad1.setText(rst.getString("Mehsul_ad"));
                Say1.setText(String.valueOf(rst.getInt("um_Mehsul_sayi")));
                Anbar_qiymet1.setText(String.valueOf(rst.getDouble("Mehsulun_son_qiymeti")) + " $");
                Satish_qiymet1.setText(String.valueOf(rst.getDouble("Satish_qiymeti")) + " $");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_mehsul_tableMouseClicked

    private void Kod1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Kod1FocusGained
        Kod1.setEnabled(false);
    }//GEN-LAST:event_Kod1FocusGained

    private void Ad1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Ad1FocusGained
        Ad1.setEnabled(false);
    }//GEN-LAST:event_Ad1FocusGained

    private void Anbar_qiymet1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Anbar_qiymet1FocusGained
        Anbar_qiymet1.setEnabled(false);
    }//GEN-LAST:event_Anbar_qiymet1FocusGained

    private void Satish_qiymet1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Satish_qiymet1FocusGained
        Satish_qiymet1.setEnabled(false);
    }//GEN-LAST:event_Satish_qiymet1FocusGained

      
    private void ixracActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ixracActionPerformed
        try {

            if (conn != null) {

                String sqlSay = "select um_Mehsul_sayi from umumi_anbar where Mehsul_qeydiyyat_KOD=?";
                cst = conn.prepareStatement(sqlSay);
                cst.setString(1, Kod1.getText());
                rst = cst.executeQuery();
                if (rst.next()) {

                    String sayGoster = rst.getString(1);
                    int sayInteger = Integer.valueOf(sayGoster);
                    int bizimSay = Integer.valueOf(Say1.getText());
                    if (bizimSay <= sayInteger && bizimSay >= 0) {

                        String sql1 = "select miqdar from tutum where kod=?;";
                        cst = conn.prepareStatement(sql1);
                        cst.setString(1, Kod1.getText());
                        rst = cst.executeQuery();
                        if (rst.next()) {
                            int miqdar = rst.getInt(1);

                            String sql2 = "select um_Mehsul_sayi ,um_Yeshik_sayi from umumi_anbar where Mehsul_qeydiyyat_KOD=?";
                            cst = conn.prepareStatement(sql2);
                            cst.setString(1, Kod1.getText());
                            rst = cst.executeQuery();
                            if (rst.next()) {

                                int mal = rst.getInt(1);
                                int paket = rst.getInt(2);
                                int girilenDeyer = Integer.valueOf(Say1.getText());
                                int yeshikCix = (mal - girilenDeyer) / miqdar;
                                int yeshikCix1 = paket - yeshikCix;

                                String sql = "update umumi_anbar set um_Mehsul_sayi=um_Mehsul_sayi - ? , um_Yeshik_sayi=? where Mehsul_qeydiyyat_KOD=?;";
                                cst = conn.prepareStatement(sql);
                                cst.setString(3, Kod1.getText());
                                cst.setString(1, Say1.getText());
                                cst.setString(2, String.valueOf(yeshikCix));
                                int count0 = cst.executeUpdate();
                                if (count0 > 0) {

                                    String sql3 = "insert into mehsul_ixrac(m_Kod,ixrac_Yeshik_say,Say,Anbar_qiymeti,Satish_qiymeti,Tarix) values(?,?,?,?,?,?);";
                                    cst = conn.prepareStatement(sql3);
                                    cst.setString(1, Kod1.getText());
                                    cst.setString(2, String.valueOf(yeshikCix1));
                                    cst.setString(3, Say1.getText());
                                    cst.setString(4, Anbar_qiymet1.getText().substring(0, Anbar_qiymet1.getText().length() - 1));
                                    cst.setString(5, Satish_qiymet1.getText().substring(0, Satish_qiymet1.getText().length() - 1));
                                    Timestamp st=new Timestamp(System.currentTimeMillis());
                                    cst.setString(6,String.valueOf(st));
                                    int count1 = cst.executeUpdate();
                                    if (count1 > 0) {

                                        JOptionPane.showMessageDialog(null, "Operation is completed");
                                        Mehsullar meh = new Mehsullar();
                                        this.hide();
                                        meh.show();

                                    }
                                    else{JOptionPane.showMessageDialog(null,"6");}

                                }
                                else{JOptionPane.showMessageDialog(null,"5");}
                            }
                            else{JOptionPane.showMessageDialog(null,"4");}
                        }
                        else{JOptionPane.showMessageDialog(null,"3");}
                    }
                    else{JOptionPane.showMessageDialog(null,"2");}
                }
                else{JOptionPane.showMessageDialog(null,"1");}
            }
        } catch (Exception e) {
   e.printStackTrace();
        }

      
        

    }//GEN-LAST:event_ixracActionPerformed

    private void Say1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Say1KeyTyped

        char c = evt.getKeyChar();
        if ((Character.isAlphabetic(c))) {
            evt.consume();
        }
    }//GEN-LAST:event_Say1KeyTyped

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        Ana_menyu men = new Ana_menyu();
        men.show();
        this.hide();

    }//GEN-LAST:event_jLabel2MouseClicked

    private void AxtarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AxtarKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (conn != null) {

                String sql = "select DISTINCT Mehsul_kod , Mehsul_ad , um_Mehsul_sayi , Mehsulun_son_qiymeti , Satish_qiymeti from mehsul_qeydiyyat , mehsul_idxal ,umumi_anbar where Mehsulun_kodu=Mehsul_kod and Mehsul_qeydiyyat_KOD=Mehsul_kod and Mehsul_kod=?";
                try {
                    cst = conn.prepareStatement(sql);
                    cst.setString(1, Axtar.getText());
                    rst = cst.executeQuery();
                    if (rst.next()) {
                        Kod1.setEnabled(true);
                        Ad1.setEnabled(true);
                        Say1.setEnabled(true);
                        Anbar_qiymet1.setEnabled(true);
                        Satish_qiymet1.setEnabled(true);

                        Kod1.setText(rst.getString(1));
                        Ad1.setText(rst.getString(2));
                        Say1.setText(String.valueOf(rst.getInt(3)));
                        Anbar_qiymet1.setText(String.valueOf(rst.getDouble(4) + " $"));
                        Satish_qiymet1.setText(String.valueOf(rst.getDouble(5) + " $"));

                    } else {
                        Kod1.setText("");
                        Ad1.setText("");
                        Say1.setText("");
                        Anbar_qiymet1.setText("");
                        Satish_qiymet1.setText("");

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Mehsullar.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

    }//GEN-LAST:event_AxtarKeyPressed

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
            java.util.logging.Logger.getLogger(Mehsullar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mehsullar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mehsullar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mehsullar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mehsullar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Ad1;
    private javax.swing.JTextField Anbar_qiymet1;
    private javax.swing.JTextField Axtar;
    private javax.swing.JTextField Kod1;
    private javax.swing.JTextField Satish_qiymet1;
    private javax.swing.JTextField Say1;
    private javax.swing.JButton ixrac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mehsul_table;
    // End of variables declaration//GEN-END:variables
}
