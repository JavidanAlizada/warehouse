package anbar;

import database_src.DbConnector;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Ana_menyu extends javax.swing.JFrame {

    private Connection conn;
    private DbConnector dbconn;
    private PreparedStatement cst;
    private ResultSet rst;

    private int totalProduct;
    private double totalWarehouse;
    private double totalSaleCost;
    private double totalProfit;

    public Ana_menyu() {

        initComponents();
        dbconn = new DbConnector();
        try {
            conn = dbconn.connectToDatabase();
        }  catch (Exception ex) {
            Logger.getLogger(Ana_menyu.class.getName()).log(Level.SEVERE, null, ex);
        }
        getList();
        TOTAL();
    }

    private String queryAnaMenyu(){
    
    return "select DISTINCT Mehsul_ad , Mehsul_kod ,um_Yeshik_sayi , um_Mehsul_sayi , \n" +
"Mehsul_rengi,Mehsul_olcu,Istehsalci_firma, Mehsulun_son_qiymeti , Satish_qiymeti\n" +
"from mehsul_qeydiyyat , mehsul_idxal ,umumi_anbar \n" +
"where Mehsulun_kodu=Mehsul_kod and Mehsul_qeydiyyat_KOD=Mehsul_kod order by Mehsul_kod;";
    }
    
    private ArrayList<AnaMenyuBean> getAnaMenyu() {

        ArrayList<AnaMenyuBean> list = new ArrayList<>();

        if (conn != null) {

            String sql = queryAnaMenyu();
            try {
                cst = conn.prepareStatement(sql);
                rst = cst.executeQuery();
                AnaMenyuBean bean;
                while (rst.next()) {
                    bean = new AnaMenyuBean(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getInt(4),
                            rst.getString(5), rst.getString(6), rst.getString(7), rst.getDouble(8), rst.getDouble(9));
                    list.add(bean);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Ana_menyu.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
        }

        return null;

    }

    private void TOTAL() {
        ArrayList<AnaMenyuBean> list = getAnaMenyu();
     
        for (int i = 0; i < list.size(); i++) {
            totalWarehouse += (list.get(i).getAnbarQiymeti() * list.get(i).getSay());
            totalProduct += list.get(i).getSay();
            totalSaleCost += (list.get(i).getSatishQiymeti() * list.get(i).getSay());
            totalProfit += ((list.get(i).getSatishQiymeti() * list.get(i).getSay())-(list.get(i).getAnbarQiymeti() * list.get(i).getSay()) );
        }

        warehouseCostTotal.setText(String.valueOf(totalWarehouse )+" $");
        productTotal.setText(String.valueOf(totalProduct));
        saleCostTotal.setText(String.valueOf(totalSaleCost)+" $");
        profitTotal.setText(String.valueOf(totalProfit)+" $");
    }

    private void getList() {
        ArrayList<AnaMenyuBean> list = getAnaMenyu();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] row = new Object[9];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getAd();
            row[1] = list.get(i).getKod();
            row[2] = list.get(i).getYeshik_sayi();
            row[3] = list.get(i).getSay();
            row[4] = list.get(i).getReng();
            row[5] = list.get(i).getOlcu();
            row[6] = list.get(i).getIstehsalciFirma();
            row[7] = list.get(i).getAnbarQiymeti() + " $";
            row[8] = list.get(i).getSatishQiymeti() + " $";
            model.addRow(row);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        mehsullar = new javax.swing.JLabel();
        mehsul_ixrac = new javax.swing.JLabel();
        mehsul_idxal = new javax.swing.JLabel();
        statistik_gosterici = new javax.swing.JLabel();
        mehsul_qeydiyyat = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        qeydiyyatMehsullarihamsi = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        warehouseCostTotal = new javax.swing.JLabel();
        saleCostTotal = new javax.swing.JLabel();
        profitTotal = new javax.swing.JLabel();
        productTotal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Page");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Code", "Carton", "Quantity", "Color", "Size", "Supplier", "Warehouse Cost", "Sale Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        mehsullar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        mehsullar.setText("All products");
        mehsullar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mehsullar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mehsullarMouseClicked(evt);
            }
        });
        jPanel1.add(mehsullar);
        mehsullar.setBounds(10, 100, 160, 30);

        mehsul_ixrac.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        mehsul_ixrac.setText("Export Product");
        mehsul_ixrac.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mehsul_ixrac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mehsul_ixracMouseClicked(evt);
            }
        });
        jPanel1.add(mehsul_ixrac);
        mehsul_ixrac.setBounds(10, 200, 160, 30);

        mehsul_idxal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        mehsul_idxal.setText("Import Product");
        mehsul_idxal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mehsul_idxal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mehsul_idxalMouseClicked(evt);
            }
        });
        jPanel1.add(mehsul_idxal);
        mehsul_idxal.setBounds(10, 150, 160, 30);

        statistik_gosterici.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        statistik_gosterici.setText("Statistic");
        statistik_gosterici.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        statistik_gosterici.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                statistik_gostericiMouseClicked(evt);
            }
        });
        jPanel1.add(statistik_gosterici);
        statistik_gosterici.setBounds(10, 310, 160, 30);

        mehsul_qeydiyyat.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        mehsul_qeydiyyat.setText("Register Product");
        mehsul_qeydiyyat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mehsul_qeydiyyat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mehsul_qeydiyyatMouseClicked(evt);
            }
        });
        jPanel1.add(mehsul_qeydiyyat);
        mehsul_qeydiyyat.setBounds(10, 50, 170, 20);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 390, 160, 10);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(10, 180, 120, 10);
        jPanel1.add(jSeparator4);
        jSeparator4.setBounds(10, 70, 110, 10);
        jPanel1.add(jSeparator5);
        jSeparator5.setBounds(10, 230, 120, 10);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/iconfinder_arrow-right_227601.png"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(150, 150, 20, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/iconfinder_arrow-right_227601.png"))); // NOI18N
        jPanel1.add(jLabel8);
        jLabel8.setBounds(150, 100, 20, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/iconfinder_arrow-right_227601.png"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(150, 50, 20, 30);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/iconfinder_arrow-right_227601.png"))); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(150, 310, 20, 30);
        jPanel1.add(jSeparator6);
        jSeparator6.setBounds(10, 130, 100, 10);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/iconfinder_arrow-right_227601.png"))); // NOI18N
        jPanel1.add(jLabel11);
        jLabel11.setBounds(150, 200, 20, 30);

        qeydiyyatMehsullarihamsi.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        qeydiyyatMehsullarihamsi.setText("Registered Products");
        qeydiyyatMehsullarihamsi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        qeydiyyatMehsullarihamsi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qeydiyyatMehsullarihamsiMouseClicked(evt);
            }
        });
        jPanel1.add(qeydiyyatMehsullarihamsi);
        qeydiyyatMehsullarihamsi.setBounds(10, 260, 160, 30);
        jPanel1.add(jSeparator8);
        jSeparator8.setBounds(10, 290, 150, 10);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/iconfinder_arrow-right_227601.png"))); // NOI18N
        jPanel1.add(jLabel12);
        jLabel12.setBounds(150, 260, 20, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel2.setText("Edit Imported Product Data");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 360, 170, 30);
        jPanel1.add(jSeparator9);
        jSeparator9.setBounds(10, 340, 120, 10);

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Total Profit");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(720, 40, 100, 30);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Total Sale Cost");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(500, 40, 110, 30);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Total Product");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 40, 90, 30);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Total Warehouse Cost");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(220, 40, 150, 30);
        jPanel2.add(jSeparator7);
        jSeparator7.setBounds(370, 60, 110, 10);
        jPanel2.add(jSeparator10);
        jSeparator10.setBounds(610, 60, 100, 10);
        jPanel2.add(jSeparator11);
        jSeparator11.setBounds(100, 60, 100, 10);
        jPanel2.add(jSeparator12);
        jSeparator12.setBounds(810, 60, 100, 10);

        warehouseCostTotal.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        warehouseCostTotal.setForeground(javax.swing.UIManager.getDefaults().getColor("nb.diff.unresolved.color"));
        warehouseCostTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(warehouseCostTotal);
        warehouseCostTotal.setBounds(370, 40, 110, 30);

        saleCostTotal.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        saleCostTotal.setForeground(javax.swing.UIManager.getDefaults().getColor("nb.diff.unresolved.color"));
        saleCostTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(saleCostTotal);
        saleCostTotal.setBounds(610, 40, 100, 30);

        profitTotal.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        profitTotal.setForeground(javax.swing.UIManager.getDefaults().getColor("nb.diff.unresolved.color"));
        profitTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(profitTotal);
        profitTotal.setBounds(810, 40, 100, 30);

        productTotal.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        productTotal.setForeground(javax.swing.UIManager.getDefaults().getColor("nb.diff.unresolved.color"));
        productTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(productTotal);
        productTotal.setBounds(100, 40, 100, 30);

        jLabel1.setFont(new java.awt.Font("Eras Medium ITC", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Page links");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(9, 9, 9))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                .addGap(3, 3, 3))
        );

        setSize(new java.awt.Dimension(1146, 602));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mehsul_qeydiyyatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mehsul_qeydiyyatMouseClicked
        Mehsul_qeydiyyat qeyd = new Mehsul_qeydiyyat();
        qeyd.show();
        this.hide();
    }//GEN-LAST:event_mehsul_qeydiyyatMouseClicked

    private void mehsullarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mehsullarMouseClicked
        Mehsullar meh = new Mehsullar();
        meh.show();
        this.hide();
    }//GEN-LAST:event_mehsullarMouseClicked

    private void mehsul_idxalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mehsul_idxalMouseClicked
        Mehsul_idxal idxal = new Mehsul_idxal();
        idxal.show();
        this.hide();

    }//GEN-LAST:event_mehsul_idxalMouseClicked

    private void mehsul_ixracMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mehsul_ixracMouseClicked
        Mehsul_ixrac ixrac = new Mehsul_ixrac();
        ixrac.show();
        this.hide();
    }//GEN-LAST:event_mehsul_ixracMouseClicked

    private void statistik_gostericiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statistik_gostericiMouseClicked
        Statistik_gostericiler gost = new Statistik_gostericiler();
        gost.show();
        this.hide();
    }//GEN-LAST:event_statistik_gostericiMouseClicked

    private void qeydiyyatMehsullarihamsiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qeydiyyatMehsullarihamsiMouseClicked
        QeydiyyatMehsullar gost = new QeydiyyatMehsullar();
        gost.show();
        this.hide();
    }//GEN-LAST:event_qeydiyyatMehsullarihamsiMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        IdxalAnbarDuzenleme idxal = new IdxalAnbarDuzenleme();
        idxal.show();
        this.hide();
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(Ana_menyu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ana_menyu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ana_menyu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ana_menyu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ana_menyu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel mehsul_idxal;
    private javax.swing.JLabel mehsul_ixrac;
    private javax.swing.JLabel mehsul_qeydiyyat;
    private javax.swing.JLabel mehsullar;
    private javax.swing.JLabel productTotal;
    private javax.swing.JLabel profitTotal;
    private javax.swing.JLabel qeydiyyatMehsullarihamsi;
    private javax.swing.JLabel saleCostTotal;
    private javax.swing.JLabel statistik_gosterici;
    private javax.swing.JTable table;
    private javax.swing.JLabel warehouseCostTotal;
    // End of variables declaration//GEN-END:variables
}
