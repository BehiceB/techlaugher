package data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Havvanur BOZÖMEROĞLU
 */

public class Database {
    /**
     * Database Bağlantısı
     */
    private static Connection connection = null;
    
    /**
     * Database Kullanıcı Adı
     */
    private static final String USERNAME = "APP";
    
    /**
     * Database Şifre
     */
    private static final String PASSWORD = "APP";
    
    /**
     * Database'e bağlantı oluşturma
     * @throws SQLException 
     */
    private static void connect() throws SQLException {
        if (connection != null){
            close();
            connection = null;
        }
        
       connection = DriverManager.getConnection("jdbc:derby://localhost:1527/addressbook", USERNAME, PASSWORD);
    }
    
    /**
     * Bağlantıyı kapatma
     * @throws SQLException 
     */
    public static void close() throws SQLException {
        if (connection != null)
            connection.close();
        
        connection = null;
    }
    
    /**
     * Bağlantıyı döndürme (yoksa oluşturma)
     * @return Bağlantı
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null)
            connect();
        
        return connection;
    }
    
    public static String getStringValue(String query) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        String temp = "";
        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/addressbook", USERNAME, PASSWORD);
            stat = conn.createStatement();
            rs = stat.executeQuery(query);

            if (rs.next()) {
                temp = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return temp;

    }
}

