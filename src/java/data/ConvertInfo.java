/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author Havvanur BOZÖMEROĞLU
 */
@ManagedBean(name="cevirBean")
@SessionScoped
public class mailiUsernameCevirme {
    
    static DataSource dataSource;
    
  
    
    public mailiUsernameCevirme() 
    {
               try
{
Context ctx = new InitialContext();
// kullandığımız database adı addressbook.
dataSource = (DataSource) ctx.lookup("jdbc/addressbook");
}
catch (NamingException e) 
{
e.printStackTrace();
}
    }
    
    
    
    
    public static String cevir(String email)throws SQLException{
        String username = null;
                
            try {
                String sql = "SELECT username FROM T_USER WHERE email = ?";

                PreparedStatement statement = Database.getConnection().prepareStatement(sql);
                statement.setString(1, email);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    username = rs.getString("username");
                }

                Database.close();

            } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        

        return username;
      
    
    
 }




}
