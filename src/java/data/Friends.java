/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author Havvanur BOZÖMEROĞLU
 */
@ManagedBean(name="arkadasBean")
@RequestScoped
public class Arkadaslar {
    private String arkadas1;
    private String arkadas2;
    private String arkadas3;
    private String arkadas4;
    
    public static String musername;

    public static String getMusername() {
        return musername;
    }

    public static void setMusername(String musername) {
        Arkadaslar.musername = musername;
    }

   
    
    
    

    public String getArkadas3() {
        return arkadas3;
    }

    public void setArkadas3(String arkadas3) {
        this.arkadas3 = arkadas3;
    }

    public String getArkadas4() {
        return arkadas4;
    }

    public void setArkadas4(String arkadas4) {
        this.arkadas4 = arkadas4;
    }
   

    public String getArkadas1() {
        return arkadas1;
    }

    public void setArkadas1(String arkadas1) {
        this.arkadas1 = arkadas1;
    }

    public String getArkadas2() {
        return arkadas2;
    }

    public void setArkadas2(String arkadas2) {
        this.arkadas2 = arkadas2;
    }
    
   
    DataSource dataSource;
    
     public String arkadas1()throws SQLException{
            
                
            try {
                String sql = "SELECT ARKADAS1 FROM ARKADASLAR WHERE HESAPSAHIBI = ?";

                PreparedStatement statement = Database.getConnection().prepareStatement(sql);
                statement.setString(1, musername);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    arkadas1 = rs.getString(1);
          
                }

                Database.close();

            } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        

        return arkadas1;
 }
     public String arkadas2()throws SQLException{
      
                
            try {
                String sql = "SELECT ARKADAS2 FROM ARKADASLAR WHERE HESAPSAHIBI = ?";

                PreparedStatement statement = Database.getConnection().prepareStatement(sql);
                statement.setString(1, musername);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    arkadas2 = rs.getString(1);
                }

                Database.close();

            } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        

        return arkadas2;
 }
     public String arkadas3()throws SQLException{
      
                
            try {
                String sql = "SELECT ARKADAS3 FROM ARKADASLAR WHERE HESAPSAHIBI = ?";

                PreparedStatement statement = Database.getConnection().prepareStatement(sql);
                statement.setString(1, musername);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    arkadas3 = rs.getString(1);
                }

                Database.close();

            } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        

        return arkadas3;
 
     }
     
     public  String arkadas4()throws SQLException{
       
                
            try {
                String sql = "SELECT ARKADAS4 FROM ARKADASLAR WHERE HESAPSAHIBI = ?";

                PreparedStatement statement = Database.getConnection().prepareStatement(sql);
                statement.setString(1, musername);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    arkadas4 = rs.getString(1);
                }

                Database.close();

            } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        

        return arkadas4;
 }
      
     
    
}

