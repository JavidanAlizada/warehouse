
package database_src;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DbConnector {
    
    private static String driver="org.h2.Driver";
    private static String url="jdbc:h2:file:C:/Users/111/Desktop/Anbar/anbardb;IFEXISTS=FALSE";
    private static String user="sa";
    private static String password="";
    
    private static Connection conn;
    private static PreparedStatement pst;
    private static ResultSet rst;
    
    
    public  static   Connection connectToDatabase(){
      try{
        Class.forName(driver);
        conn=DriverManager.getConnection(url,user, password);
        if(conn!=null){
            System.out.println("Connected");
        }
        else{
            System.out.println("Fail");
        }
      }
      catch(Exception e){
      JOptionPane.showMessageDialog(null, e);
      //e.printStackTrace();
      
      }
    return conn;

       }
    
    
 
   
   
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println(connectToDatabase());
        
        
        
        
        
    }
}
