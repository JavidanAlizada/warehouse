package anbar;

import database_src.DbConnector;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class QeydiyyatMehsullar extends javax.swing.JFrame {
    
    private Connection conn;
    private ResultSet rst;
    private PreparedStatement cst;
    private DbConnector connector;
    
    public QeydiyyatMehsullar() {
        initComponents();
        connector = new DbConnector();
        try {
            conn = connector.connectToDatabase();
        }  catch (Exception ex) {
            Logger.getLogger(QeydiyyatMehsullar.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            getList();
        } catch (SQLException ex) {
            Logger.getLogger(QeydiyyatMehsullar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private ArrayList<QeydiyyatMehsulBean> mehsulList() throws SQLException {
        ArrayList<QeydiyyatMehsulBean> mehsulBeans = new ArrayList<>();
        if (conn != null) {
            
            String sql = "select * from mehsul_qeydiyyat order by Mehsul_ad";
            cst = conn.prepareStatement(sql);
            rst = cst.executeQuery();
            QeydiyyatMehsulBean bean;
            while (rst.next()) {
                bean = new QeydiyyatMehsulBean(rst.getString(2), rst.getString(1), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));
                mehsulBeans.add(bean);
            }
        }
        return mehsulBeans;
    }
    
    private void getList() throws SQLException {
        ArrayList<QeydiyyatMehsulBean> qeydiyyat = mehsulList();
        DefaultTableModel model = (DefaultTableModel) qeydiyyatTable.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < qeydiyyat.size(); i++) {
            row[0] = qeydiyyat.get(i).getAd();
            row[1] = qeydiyyat.get(i).getKod();
            row[2] = qeydiyyat.get(i).getOlcu();
            row[3] = qeydiyyat.get(i).getReng();
            row[4] = qeydiyyat.get(i).getTarix();
            row[5] = qeydiyyat.get(i).getFirma();
            model.addRow(row);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        qeydiyyatTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registered Products");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(null);

        qeydiyyatTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Code", "Size", "Color", "Register Date", "Supplier"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        qeydiyyatTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(qeydiyyatTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 0, 940, 480);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/iconfinder_arrow-back_216437.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 190, 24, 36);

        setSize(new java.awt.Dimension(990, 522));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
      
        Ana_menyu menyu=new Ana_menyu();
        menyu.show();
        this.hide();
                
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(QeydiyyatMehsullar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QeydiyyatMehsullar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QeydiyyatMehsullar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QeydiyyatMehsullar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QeydiyyatMehsullar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable qeydiyyatTable;
    // End of variables declaration//GEN-END:variables
}
