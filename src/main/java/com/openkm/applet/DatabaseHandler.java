/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openkm.applet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author papamas
 */
public class DatabaseHandler {
    
    private  Connection c = null;
    private  Statement stmt = null;
    private  String Insert_sql = "INSERT INTO DOKUMEN (DESCRIPTION, PATH, FNAME) values (?, ?, ?)";
    private  String Select_sql = "SELECT ID,DESCRIPTION, PATH, FNAME FROM DOKUMEN";
    private  String Drop_sql   = "DROP TABLE IF EXISTS DOKUMEN;";
   
    
    public Connection connect(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:dokumen.db");
        } 
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );          
        }
        System.out.println("Opened database successfully");

        return c;
    }
    
    public void createTable(){
        try {              
        stmt = c.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS DOKUMEN " +
                        "(ID INTEGER PRIMARY KEY     AUTOINCREMENT," +
                        " DESCRIPTION            TEXT    NOT NULL, " + 
                        " PATH                   TEXT    NOT NULL, " + 
                        " FNAME                  TEXT    NOT NULL)"; 
            stmt.executeUpdate(sql);    
            stmt.close();
         } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );           
         }
         System.out.println("Table Dokumen created successfully");
    }
    
    
    public void insertTable() throws SQLException{
       PreparedStatement pstmt = c.prepareStatement(Insert_sql);
       c.setAutoCommit(false);
       DefaultComboBoxModel model  = JenisDokumenModel.getData();
       for(int i=0;i< model.getSize();i++) {
            Item item = (Item) model.getElementAt(i);            
            pstmt.setString(1,item.getDescription());
            pstmt.setString(2,item.getPath());
            pstmt.setString(3,item.getFname());            
            pstmt.addBatch();            
        }
        
        int[] result = pstmt.executeBatch();
        System.out.println("The number of rows inserted: "+ result.length);
        c.commit();      
    }
    
    public void selectAll() throws SQLException{            
        stmt = c.createStatement();
        ResultSet rs    = stmt.executeQuery(Select_sql);           
        // loop through the result set
        while (rs.next()) {
           System.out.println(rs.getInt("ID") +  "\t" + 
                              rs.getString("DESCRIPTION") + "\t" +
                              rs.getString("PATH") + "\t" +
                              rs.getString("FNAME")
                   );
        }    
      
    }
    
     public ResultSet getAll() throws SQLException{            
        System.out.println("==== call get all dokumen===");
        stmt = c.createStatement();
        ResultSet rs    = stmt.executeQuery(Select_sql);         
        return rs;
    }
    
    public void dropTable() throws SQLException{
        stmt = c.createStatement();
        stmt.executeUpdate(Drop_sql);    
       
   
    }
    
    public void close() throws SQLException{        
        stmt.close();
        c.close();
    }
}
