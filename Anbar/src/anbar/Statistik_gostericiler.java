package anbar;

import com.orsoncharts.plot.CategoryPlot3D;
import com.orsoncharts.renderer.category.BarRenderer3D;
import java.util.Locale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.sql.*;
import database_src.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.title.Title;

public class Statistik_gostericiler extends javax.swing.JFrame {

    private Connection conn;
    private ResultSet rst;
    private PreparedStatement cst;
    private DbConnector connector;

    public Statistik_gostericiler() {
        initComponents();
        jPanel2.setFocusable(true);
        connector = new DbConnector();
        try {
            conn = connector.connectToDatabase();
        } catch (Exception ex) {
            Logger.getLogger(Statistik_gostericiler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Diagram4 = new javax.swing.JLabel();
        Diagram2 = new javax.swing.JLabel();
        Diagram5 = new javax.swing.JLabel();
        Diagram3 = new javax.swing.JLabel();
        Diagram1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        il1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        il2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        Kod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Statistic");
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Back");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 360, 62, 33);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        Diagram4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Diagram4.setForeground(new java.awt.Color(0, 0, 153));
        Diagram4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Diagram4.setText("Differences of quantities of exported products in between two  given dates");
        Diagram4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Diagram4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Diagram4MouseClicked(evt);
            }
        });
        jPanel1.add(Diagram4);
        Diagram4.setBounds(20, 120, 550, 30);

        Diagram2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Diagram2.setForeground(new java.awt.Color(0, 0, 153));
        Diagram2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Diagram2.setText(" Distribution of expenses of imported products for every month");
        Diagram2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Diagram2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Diagram2MouseClicked(evt);
            }
        });
        jPanel1.add(Diagram2);
        Diagram2.setBounds(40, 20, 530, 30);

        Diagram5.setForeground(new java.awt.Color(0, 0, 153));
        Diagram5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Diagram5.setText(" Exporting numbers of this product for months by based on in between two given dates and product code");
        Diagram5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Diagram5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Diagram5MouseClicked(evt);
            }
        });
        jPanel1.add(Diagram5);
        Diagram5.setBounds(-20, 170, 620, 30);

        Diagram3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Diagram3.setForeground(new java.awt.Color(0, 0, 153));
        Diagram3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Diagram3.setText("Differences of revenues of exported products in between two  given dates");
        Diagram3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Diagram3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Diagram3MouseClicked(evt);
            }
        });
        jPanel1.add(Diagram3);
        Diagram3.setBounds(60, 70, 510, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(110, 180, 580, 220);

        Diagram1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Diagram1.setForeground(new java.awt.Color(0, 0, 153));
        Diagram1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Diagram1.setText("Compare among quantities of products in the warehouse(on the pie chart)");
        Diagram1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Diagram1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Diagram1MouseClicked(evt);
            }
        });
        getContentPane().add(Diagram1);
        Diagram1.setBounds(110, 20, 550, 30);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        il1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                il1KeyTyped(evt);
            }
        });
        jPanel2.add(il1);
        il1.setBounds(270, 60, 100, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("From year");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(190, 60, 70, 30);

        il2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                il2KeyTyped(evt);
            }
        });
        jPanel2.add(il2);
        il2.setBounds(440, 60, 100, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("To year");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(380, 60, 50, 30);

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setForeground(new java.awt.Color(102, 153, 255));
        jPanel4.setLayout(null);

        Kod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                KodKeyTyped(evt);
            }
        });
        jPanel4.add(Kod);
        Kod.setBounds(60, 20, 100, 30);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Code");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(0, 20, 50, 30);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(10, 10, 170, 80);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(110, 70, 580, 100);
        getContentPane().add(jPanel3);
        jPanel3.setBounds(20, 30, 10, 10);

        setSize(new java.awt.Dimension(714, 450));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Ana_menyu men = new Ana_menyu();
        men.show();
        this.hide();

    }//GEN-LAST:event_jLabel1MouseClicked

    private void Diagram1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Diagram1MouseClicked

        DefaultPieDataset dataset = new DefaultPieDataset();
        ArrayList<MehsulAdVeSay> list = getAdVeSay();
        for (int i = 0; i < list.size(); i++) {
            dataset.setValue(list.get(i).getName(), list.get(i).getSay());

        }
        JFreeChart chart = ChartFactory.createPieChart3D("Indexes of products with percentage", dataset, true, true, true);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();

        ChartFrame frame = new ChartFrame("Statistical index", chart);
        frame.setSize(1200, 550);
        frame.setVisible(true);

    }//GEN-LAST:event_Diagram1MouseClicked

    private ArrayList<MehsulAdVeSay> getAdVeSay() {
        ArrayList<MehsulAdVeSay> list = new ArrayList<>();

        if (conn != null) {            //Mehsul_ad     //Mehsul_qeydiyyat_KOD
            String sql ="select (Mehsul_ad , Mehsul_qeydiyyat_KOD) as Mehsul_ID,sum(um_Mehsul_sayi) from mehsul_qeydiyyat , umumi_anbar where Mehsul_kod=Mehsul_qeydiyyat_KOD group by Mehsul_qeydiyyat_kod";
            try {
                cst = conn.prepareStatement(sql);
                rst = cst.executeQuery();
                MehsulAdVeSay adVeSay;
                while (rst.next()) {
                    adVeSay = new MehsulAdVeSay(rst.getString(1), rst.getInt(2));
                    list.add(adVeSay);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Statistik_gostericiler.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
        } else {
            System.out.println("Connection is null");
        }

        return null;
    }

    private ArrayList<Diagram2Bean> getDiagram() throws SQLException {
        ArrayList<Diagram2Bean> list = new ArrayList<>();

        if (conn != null) {

            String sql = "select sum((Mehsul_sayi * Mehsulun_son_qiymeti)) from  mehsul_idxal where CAST(Idxal_tarixi AS char) like ('%'||?||'-'||?||'%');";
            cst = conn.prepareStatement(sql);
            Diagram2Bean bean;
            String[] aylar = new String[]{"Januar", "Februar", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            for (int i = 1; i <= 12; i++) {

                if (i < 10) {

                    cst.setString(1, il1.getText());
                    cst.setString(2, "0" + i);
                    rst = cst.executeQuery();
                   while (rst.next()) {
                        bean = new Diagram2Bean(rst.getDouble(1), aylar[i - 1]);
                        list.add(bean);
                    }
                } else if (i >= 10) {

                    cst.setString(1, il1.getText());
                    cst.setString(2, "" + i);
                    rst = cst.executeQuery();
                    while (rst.next()) {
                        bean = new Diagram2Bean(rst.getDouble(1), aylar[i - 1]);
                        list.add(bean);
                    }
                }

            }

        }
        return list;
    }
    
    
    
    private ArrayList<Diagram3Bean> getDiagram3Bean() throws SQLException{
    
        ArrayList<Diagram3Bean>list=new ArrayList<>();
        
        if(conn!=null){
        
            String sql="select sum(((Satish_qiymeti-Anbar_qiymeti)*Say)),Mehsul_kod from mehsul_ixrac , mehsul_qeydiyyat where Mehsul_kod=m_Kod and  CAST(Tarix AS char) like ('%'||?||'%') group by Mehsul_kod;";
            cst=conn.prepareStatement(sql);
            cst.setString(1,il1.getText());
            rst=cst.executeQuery();
            Diagram3Bean bean;
            while(rst.next()){
            bean=new Diagram3Bean(rst.getDouble(1),rst.getString(2));
            list.add(bean);
            }
        
        }
        
        
        
    return list;
    }
    
    private ArrayList<Diagram4Bean> getDiagram4Bean() throws SQLException{
    
        ArrayList<Diagram4Bean> list=new ArrayList<>();
        
         if(conn!=null){
        
            String sql="select  sum(Say), Mehsul_kod from mehsul_ixrac , mehsul_qeydiyyat where Mehsul_kod=m_Kod and  CAST(Tarix AS char) like ('%'||?||'%') group by Mehsul_kod;";
            cst=conn.prepareStatement(sql);
            cst.setString(1,il1.getText());
            rst=cst.executeQuery();
            Diagram4Bean bean;
            while(rst.next()){
            bean=new Diagram4Bean(rst.getInt(1),rst.getString(2));
            list.add(bean);
            }
        
        }
                
        
    return list;
    }
    
     private ArrayList<Diagram5Bean> getDiagram5() throws SQLException {
        ArrayList<Diagram5Bean> list = new ArrayList<>();

        if (conn != null) {

            String sql = "select sum(Say) from mehsul_ixrac where CAST(Tarix AS char) like ('%'||?||'-'||?||'%') and m_Kod=? ";
            cst = conn.prepareStatement(sql);
            Diagram5Bean bean;
            String[] aylar = new String[]{"Januar", "Februar", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            for (int i = 1; i <= 12; i++) {

                if (i < 10) {

                    cst.setString(1, il1.getText());
                    cst.setString(2, "0" + i);
                    cst.setString(3,Kod.getText());
                    rst = cst.executeQuery();
                   while (rst.next()) {
                        bean = new Diagram5Bean(rst.getInt(1), aylar[i - 1]);
                        list.add(bean);
                    }
                } else if (i >= 10) {

                    cst.setString(1, il1.getText());
                    cst.setString(2, "" + i);
                    cst.setString(3,Kod.getText());
                    rst = cst.executeQuery();
                    while (rst.next()) {
                        bean = new Diagram5Bean(rst.getInt(1), aylar[i - 1]);
                        list.add(bean);
                    }
                }

            }

        }
        return list;
    }
    
    private void Diagram2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Diagram2MouseClicked
        //Burda girilecek iki il araliginda olan mehsul idxali deyerlerinin aylara esasen gostericisidir
        // bununla iki il arasinda hansi ayda daha cox ve ya hansi ayda daha az mehsul idxalina pul xerclendiyi gosterilir

        try {
            if (conn != null) {
                if (Integer.valueOf(il1.getText()) >= 0 && Integer.valueOf(il2.getText()) >= 0
                        && il1.getText().length() == 4 && il2.getText().length() == 4
                        && Integer.valueOf(il2.getText()) - Integer.valueOf(il1.getText()) == 1) {

                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                    ArrayList<Diagram2Bean> list = getDiagram();

                    for (int i = 0; i < list.size(); i++) {

                        dataset.addValue(list.get(i).getPaymentForImportPerMonth(), "Expenses", list.get(i).getAylar());
                    }
                    JFreeChart chart = ChartFactory.createBarChart3D(" Distribution of expenses of imported products for every month", "Months", "Expenses", dataset, PlotOrientation.VERTICAL, false, true, false);

                    CategoryPlot plot = (CategoryPlot) chart.getPlot();

                    ChartFrame frame = new ChartFrame("Diagram1", chart);
                    frame.setVisible(true);
                    frame.setSize(450, 350);
                } else {
                    JOptionPane.showMessageDialog(null, "Insert dates correctly");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
           // JOptionPane.showMessageDialog(null, "Xəta var");
        }

    }//GEN-LAST:event_Diagram2MouseClicked

    private void Diagram4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Diagram4MouseClicked

         
       /*Burda girilmiş tarixlərə əsasən anbardan çıxan(ixrac) mallarından gələn
        */
        try {
            if (conn != null) {
                if (Integer.valueOf(il1.getText()) >= 0 && Integer.valueOf(il2.getText()) >= 0
                        && il1.getText().length() == 4 && il2.getText().length() == 4
                        && Integer.valueOf(il2.getText()) - Integer.valueOf(il1.getText()) == 1) {

                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                    ArrayList<Diagram4Bean> list = getDiagram4Bean();

                    for (int i = 0; i < list.size(); i++) {

                        dataset.addValue(list.get(i).getSay(), "Quantities", list.get(i).getKodlar());
                    }
                    JFreeChart chart = ChartFactory.createBarChart3D("quantities of exported products", "Product code", "Quantity", dataset, PlotOrientation.VERTICAL, false, true, false);

                    CategoryPlot plot = (CategoryPlot) chart.getPlot();

                    ChartFrame frame = new ChartFrame("Diagram3", chart);
                    frame.setVisible(true);
                    frame.setSize(450, 350);
                } else {
                    JOptionPane.showMessageDialog(null, "İnsert dates correctly");
                }
            }
        } catch (Exception e) {
e.printStackTrace();
//JOptionPane.showMessageDialog(null, "Failure");
        }
    }//GEN-LAST:event_Diagram4MouseClicked

    private void Diagram5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Diagram5MouseClicked
         
           //Burda girilecek iki il araliginda olan mehsul idxali deyerlerinin aylara esasen gostericisidir
        // bununla iki il arasinda hansi ayda daha cox ve ya hansi ayda daha az mehsul idxalina pul xerclendiyi gosterilir

        try {
            if (conn != null) {
                if (Integer.valueOf(il1.getText()) >= 0 && Integer.valueOf(il2.getText()) >= 0
                        && il1.getText().length() == 4 && il2.getText().length() == 4
                        && Integer.valueOf(il2.getText()) - Integer.valueOf(il1.getText()) == 1) {

                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                    ArrayList<Diagram5Bean> list = getDiagram5();

                    for (int i = 0; i < list.size(); i++) {

                        dataset.addValue(list.get(i).getSay(), "Quantities", list.get(i).getAylar());
                    }
                    JFreeChart chart = ChartFactory.createBarChart3D(" Distribution exported products for every month", "Months", "Quantities", dataset, PlotOrientation.VERTICAL, false, true, false);

                    CategoryPlot plot = (CategoryPlot) chart.getPlot();

                    ChartFrame frame = new ChartFrame("Diagram5", chart);
                    frame.setVisible(true);
                    frame.setSize(450, 350);
                } else {
                    JOptionPane.showMessageDialog(null, "Insert dates correctly");
                }
            }
        } catch (Exception e) {
          //  JOptionPane.showMessageDialog(null, "Failure");
        e.printStackTrace();
        
        }
        
         
    }//GEN-LAST:event_Diagram5MouseClicked

    private void Diagram3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Diagram3MouseClicked
     
        
       /*Burda girilmiş tarixlərə əsasən anbardan çıxan(ixrac) mallarından gələn
        *gəlir fərqləri göstərilir.
        *Beləki bu diagramda verilmiş  tarixlər arasında ixrac mallarının satış qiymətindən anbar qiyməti
        *çıxılır və onlar hər bir məhsula görə sıralanır.
        */
        try {
            if (conn != null) {
                if (Integer.valueOf(il1.getText()) >= 0 && Integer.valueOf(il2.getText()) >= 0
                        && il1.getText().length() == 4 && il2.getText().length() == 4
                        && Integer.valueOf(il2.getText()) - Integer.valueOf(il1.getText()) == 1) {

                    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                    ArrayList<Diagram3Bean> list = getDiagram3Bean();

                    for (int i = 0; i < list.size(); i++) {

                        dataset.addValue(list.get(i).getSum(), "Revenues", list.get(i).getID());
                    }
                    JFreeChart chart = ChartFactory.createBarChart3D("Obtainable revenues of exported products", "Product Code", "Revenue", dataset, PlotOrientation.VERTICAL, false, true, false);

                    CategoryPlot plot = (CategoryPlot) chart.getPlot();

                    ChartFrame frame = new ChartFrame("Diagram2", chart);
                    frame.setVisible(true);
                    frame.setSize(450, 350);
                } else {
                    JOptionPane.showMessageDialog(null, "Insert dates correctly");
                }
            }
        } catch (Exception e) {
          //  JOptionPane.showMessageDialog(null, "Failure");
        
        e.printStackTrace();
        }
    }//GEN-LAST:event_Diagram3MouseClicked

    private void il1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_il1KeyTyped
        char c = evt.getKeyChar();
        if ((Character.isAlphabetic(c))) {
            evt.consume();
        }
    }//GEN-LAST:event_il1KeyTyped

    private void il2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_il2KeyTyped

        char c = evt.getKeyChar();
        if ((Character.isAlphabetic(c))) {
            evt.consume();
        }

    }//GEN-LAST:event_il2KeyTyped

    private void KodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KodKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_KodKeyTyped

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
            java.util.logging.Logger.getLogger(Statistik_gostericiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Statistik_gostericiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Statistik_gostericiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Statistik_gostericiler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Statistik_gostericiler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Diagram1;
    private javax.swing.JLabel Diagram2;
    private javax.swing.JLabel Diagram3;
    private javax.swing.JLabel Diagram4;
    private javax.swing.JLabel Diagram5;
    private javax.swing.JTextField Kod;
    private javax.swing.JTextField il1;
    private javax.swing.JTextField il2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
