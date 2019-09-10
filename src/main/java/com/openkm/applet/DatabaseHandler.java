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

/**
 *
 * @author papamas
 */
public class DatabaseHandler {
    
    private  Connection c = null;
    private Statement stmt = null;
    
    public DatabaseHandler() {
         createTable(); 
    }
    
    public Connection connect(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:dokumen.db");
        } 
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Opened database successfully");

        return c;
    }
    
    public void createTable(){
        try {
        
        c = connect();
        stmt = c.createStatement();
        String sql = "CREATE TABLE DOKUMEN " +
                        "(ID INTEGER PRIMARY KEY     AUTOINCREMENT," +
                        " DESCRIPTION            TEXT    NOT NULL, " + 
                        " PATH                   TEXT    NOT NULL, " + 
                        " FNAME                  TEXT    NOT NULL)"; 
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
         } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
         }
         System.out.println("Table Dokumen created successfully");
    }
    
    
    public void insertTable() throws SQLException{
        String sql = "insert into DOKUMEN (DESCRIPTION, PATH, FNAME) values (?, ?, ?)";
        PreparedStatement pstmt = c.prepareStatement(sql);
        pstmt.setString(1,"Kartu Pendaftaran Ulang PNS (KARDAF) Tahun 1974");
        pstmt.setString(2,"PUPNS");
        pstmt.setString(3,"PUPNS_1974");

    }
}
