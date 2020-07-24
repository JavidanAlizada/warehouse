/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anbar;

import java.util.ArrayList;
import java.sql.*;
import anbar.*;

import database_src.DbConnector;
import java.awt.Event;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
public class Mehsul_ixrac extends javax.swing.JFrame {

   private Connection conn;
   private ResultSet rst;
   private PreparedStatement cst;
   private DbConnector db;
    
   private int totalProduct;
    private double totalWarehouse;
    private double totalSaleCost;
    private double totalProfit;
   
    public Mehsul_ixrac() {
        initComponents();
        
        db=new DbConnector();
       try {
           conn=db.connectToDatabase();
       }  catch (Exception ex) {
           Logger.getLogger(Mehsul_ixrac.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       showIxracMehsul();
     //  TOTAL();
    }

    
    private ArrayList<Mehsul_ixrac_Bean> getMehsul(){
    ArrayList<Mehsul_ixrac_Bean> list=new ArrayList<>();
    if(conn!=null){
    
        String sql="select ID ,Mehsul_ad ,m_Kod , ixrac_Yeshik_say , Say , Anbar_qiymeti , Satish_qiymeti , Tarix from mehsul_ixrac , mehsul_qeydiyyat where m_Kod=Mehsul_kod order by Tarix;";
        try {
            cst=conn.prepareStatement(sql);
            rst=cst.executeQuery();
            Mehsul_ixrac_Bean bean;
            while(rst.next()){
            bean=new Mehsul_ixrac_Bean(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getInt(5),rst.getDouble(6),rst.getDouble(7),rst.getString(8));
            list.add(bean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mehsul_ixrac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    else
    return null;
    }
    
    private void showIxracMehsul(){
        ArrayList<Mehsul_ixrac_Bean> list=getMehsul();
        DefaultTableModel model=(DefaultTableModel)ixracTable.getModel();
        Object[] row=new Object[8];
        for (int i = 0; i < list.size(); i++) {
            
            row[0]=list.get(i).getID();
            row[1]=list.get(i).getAd();
            row[2]=list.get(i).getKod();
            row[3]=list.get(i).getYeshik_say();
            row[4]=list.get(i).getSay();
            row[5]=list.get(i).getAnbar_qiymet()+" $";
            row[6]=list.get(i).getSatish_qiymet()+" $";
            row[7]=list.get(i).getTarix();
            model.addRow(row);
        }
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        ixracTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        axtarText = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        kod = new javax.swing.JTextField();
        say = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        productTotal = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        warehouseCostTotal = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        saleCostTotal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        profitTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Export");
        setResizable(false);
        getContentPane().setLayout(null);

        ixracTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Code", "Carton", "Quantity", "Warehouse Cost", "Sale Cost", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ixracTable);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(273, 10, 920, 410);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 40, 70, 30);

        axtarText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                axtarTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                axtarTextKeyReleased(evt);
            }
        });
        jPanel1.add(axtarText);
        axtarText.setBounds(70, 40, 110, 30);

        jButton2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButton2.setText("TOTAL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(190, 40, 71, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 60, 270, 110);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

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
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 10, 80, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 440, 100, 60);

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Product Return");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(10, 10, 210, 30);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Code");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(10, 90, 80, 30);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Quantity");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(10, 140, 80, 30);

        kod.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel3.add(kod);
        kod.setBounds(100, 90, 100, 30);

        say.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel3.add(say);
        say.setBounds(100, 140, 100, 30);
        jPanel3.add(jSeparator4);
        jSeparator4.setBounds(60, 40, 110, 10);

        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(130, 200, 90, 30);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(20, 180, 230, 240);

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Total Product");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(10, 40, 90, 30);

        productTotal.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        productTotal.setForeground(javax.swing.UIManager.getDefaults().getColor("nb.diff.unresolved.color"));
        productTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(productTotal);
        productTotal.setBounds(100, 40, 100, 30);
        jPanel4.add(jSeparator11);
        jSeparator11.setBounds(100, 60, 100, 10);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Total Warehouse Cost");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(220, 40, 150, 30);
        jPanel4.add(jSeparator7);
        jSeparator7.setBounds(370, 60, 110, 10);

        warehouseCostTotal.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        warehouseCostTotal.setForeground(javax.swing.UIManager.getDefaults().getColor("nb.diff.unresolved.color"));
        warehouseCostTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(warehouseCostTotal);
        warehouseCostTotal.setBounds(370, 40, 110, 30);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel8.setText("Total Sale Cost");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(500, 40, 110, 30);
        jPanel4.add(jSeparator10);
        jSeparator10.setBounds(610, 60, 100, 10);

        saleCostTotal.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        saleCostTotal.setForeground(javax.swing.UIManager.getDefaults().getColor("nb.diff.unresolved.color"));
        saleCostTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(saleCostTotal);
        saleCostTotal.setBounds(610, 40, 100, 30);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel9.setText("Total Profit");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(720, 40, 100, 30);
        jPanel4.add(jSeparator12);
        jSeparator12.setBounds(810, 60, 100, 10);

        profitTotal.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        profitTotal.setForeground(javax.swing.UIManager.getDefaults().getColor("nb.diff.unresolved.color"));
        profitTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(profitTotal);
        profitTotal.setBounds(810, 40, 100, 30);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(270, 420, 920, 90);

        setSize(new java.awt.Dimension(1212, 552));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    
    
     private ArrayList<Mehsul_ixrac_Bean> getIxracList(){
    
         ArrayList<Mehsul_ixrac_Bean> list=new ArrayList<>();
    if(conn!=null){
    
        String sql="select ID ,Mehsul_ad ,m_Kod , ixrac_Yeshik_say, Say ,Anbar_qiymeti , Satish_qiymeti , Tarix  from mehsul_ixrac ,mehsul_qeydiyyat where CAST(Tarix AS char) like ('%' || ? ||'%') and m_Kod=Mehsul_kod group by ID;";
        try {
            cst=conn.prepareStatement(sql);
            cst.setString(1,axtarText.getText());
            rst=cst.executeQuery();
            Mehsul_ixrac_Bean bean;
            while(rst.next()){
            bean=new Mehsul_ixrac_Bean(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getInt(5),rst.getDouble(6),rst.getDouble(7),rst.getString(8));
            list.add(bean);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mehsul_ixrac.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    else
    return null;
    
    }
    
 
    
     private void TOTAL() {
        ArrayList<Mehsul_ixrac_Bean> list = getIxracList();
     
        for (int i = 0; i < list.size(); i++) {
            totalWarehouse += (list.get(i).getAnbar_qiymet()* list.get(i).getSay());
            totalProduct += list.get(i).getSay();
            totalSaleCost += (list.get(i).getSatish_qiymet() * list.get(i).getSay());
            totalProfit += ((list.get(i).getSatish_qiymet() * list.get(i).getSay())-(list.get(i).getAnbar_qiymet() * list.get(i).getSay()) );
          }

       
        warehouseCostTotal.setText(String.valueOf(totalWarehouse )+" $");
        productTotal.setText(String.valueOf(totalProduct));
        saleCostTotal.setText(String.valueOf(totalSaleCost)+" $");
        profitTotal.setText(String.valueOf(totalProfit)+" $");
       
     }

    
    private void axtarTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_axtarTextKeyReleased

        
        
        DefaultTableModel model=(DefaultTableModel)ixracTable.getModel();
        String search=axtarText.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> sort=new TableRowSorter<>(model);
        ixracTable.setRowSorter(sort);
        sort.setRowFilter(javax.swing.RowFilter.regexFilter(search));
        
        
    }//GEN-LAST:event_axtarTextKeyReleased

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
      Ana_menyu men=new Ana_menyu();
      men.show();
      this.hide();

    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if(conn!=null){
            
            
            
            
            try {
         
                 String sql1 = "select miqdar from tutum where kod=?;";
                        cst = conn.prepareStatement(sql1);
                        cst.setString(1, kod.getText());
                        rst = cst.executeQuery();
                        if (rst.next()) {
                            int miqdar = rst.getInt(1);

                            String sql2 = "select um_Mehsul_sayi ,um_Yeshik_sayi from umumi_anbar where Mehsul_qeydiyyat_KOD=?";
                            cst = conn.prepareStatement(sql2);
                            cst.setString(1,kod.getText());
                            rst = cst.executeQuery();
                            if (rst.next()) {

                                int mal = rst.getInt(1);
                                int paket = rst.getInt(2);
                                int girilenDeyer = Integer.valueOf(say.getText());
                                int yeshikElave = (mal + girilenDeyer) / miqdar;
                               
                //  String sql="UPDATE mehsul_ixrac SET say = say-? WHERE ROWID IN(SELECT ROWID FROM mehsul_ixrac WHERE m_Kod = ? and say>0 ORDER BY say DESC LIMIT 1);";
                String sql="update mehsul_ixrac set Say=Say-? where m_Kod=? and Say>0 order by Say desc limit 1;";
                cst=conn.prepareStatement(sql);
                cst.setString(2,kod.getText());
                cst.setString(1,say.getText());
                int count=cst.executeUpdate();
                if(count>0){
                          String sql3 = "update umumi_anbar set um_Mehsul_sayi=um_Mehsul_sayi + ? , um_Yeshik_sayi=? where Mehsul_qeydiyyat_KOD=?;";
                                cst = conn.prepareStatement(sql3);
                                cst.setString(3, kod.getText());
                                cst.setString(1, say.getText());
                                cst.setString(2, String.valueOf(yeshikElave));
                                int count0 = cst.executeUpdate();
                                if (count0 > 0) {
                                    JOptionPane.showMessageDialog(null,"Product is returned back to warehouse");
                                    Mehsul_ixrac ix=new Mehsul_ixrac();
                                    this.hide();
                                    ix.show();
                                }}
                
                            }
                }
            } catch (Exception ex) {
                Logger.getLogger(Mehsul_ixrac.class.getName()).log(Level.SEVERE, null, ex);
            }
     
         /*   finally{
            
            if(conn!=null){
            
                try {
                    conn.close();
                } catch (SQLException ex) {
                   // Logger.getLogger(Mehsul_ixrac.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            
            }
        */}
     
    }//GEN-LAST:event_jButton1ActionPerformed

   
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        TOTAL();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void axtarTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_axtarTextKeyPressed
         totalProduct=0;
    totalWarehouse=0;
     totalSaleCost=0;
     totalProfit=0;
   
        
       warehouseCostTotal.setText(String.valueOf(totalWarehouse )+" $");
        productTotal.setText(String.valueOf(totalProduct));
        saleCostTotal.setText(String.valueOf(totalSaleCost)+" $");
        profitTotal.setText(String.valueOf(totalProfit)+" $");
    }//GEN-LAST:event_axtarTextKeyPressed

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
            java.util.logging.Logger.getLogger(Mehsul_ixrac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mehsul_ixrac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mehsul_ixrac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mehsul_ixrac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mehsul_ixrac().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField axtarText;
    private javax.swing.JTable ixracTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField kod;
    private javax.swing.JLabel productTotal;
    private javax.swing.JLabel profitTotal;
    private javax.swing.JLabel saleCostTotal;
    private javax.swing.JTextField say;
    private javax.swing.JLabel warehouseCostTotal;
    // End of variables declaration//GEN-END:variables
}
