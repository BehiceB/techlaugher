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
@ManagedBean(name="mesajBean")
@SessionScoped
public class MesajGonderme {
   private static String gonderen;
   private String alici;
   private String mesaj;
  
   
   
   DataSource dataSource;

    public String getGonderen() {
        return gonderen;
    }

    public  static void setGonderen(String gonderen) {
        
        MesajGonderme.gonderen=gonderen;
    }

    public String getAlici() {
        return alici;
    }

    public  void setAlici(String alici) {
        this.alici = alici;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }
    
    
    public MesajGonderme() {
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
    
    public String gonder()throws SQLException {
        
    
              // check whether dataSource was injected by the server
    if ( dataSource == null )
    throw new SQLException( "Unable to obtain DataSource" );

 // obtain a connection from the connection pool
    Connection connection = dataSource.getConnection();

 // check whether connection was successful
 if ( connection == null )
 throw new SQLException( "Unable to connect to DataSource" );

 try
 {
     
 // create a PreparedStatement to insert a new address book entry
 PreparedStatement object2 =
 connection.prepareStatement( "INSERT INTO MESAJLAR " +
 "(GONDEREN,ALICI,MESAJ)" +
 "VALUES ( ?, ?, ?)" );

 // specify the PreparedStatement's arguments
 object2.setString( 1, getGonderen() );
 object2.setString( 2, getAlici());
 object2.setString( 3, getMesaj());
 
 object2.executeUpdate(); // executeQuery() yerine executeUpdate() yazılmalı.Çünkü insert into kullanılıyor.
 //return "index"; // go back to index.xhtml page
 } // end try
 finally
 {
 connection.close(); // return this connection to pool
 } // end finally
         
        return "message";
}
    
        public ResultSet yazdir()throws SQLException{
                
              // check whether dataSource was injected by the server
      if ( dataSource == null )
    throw new SQLException( "Unable to obtain DataSource" );

 // obtain a connection from the connection pool
    Connection connection = dataSource.getConnection();

 // check whether connection was successful
 if ( connection == null )
 throw new SQLException( "Unable to connect to DataSource" );

 try
 {
     
 // create a PreparedStatement to insert a new address book entry
 PreparedStatement object2 =connection.prepareStatement("select mesaj from mesajlar where gonderen=? and AlICI=? or GONDEREN=? AND ALICI=? ORDER BY ıd");
 object2.setString(1, getGonderen());
 object2.setString(2, getAlici());
 object2.setString(3, getAlici());
 object2.setString(4, getGonderen());
 
 CachedRowSet resultSet1=new com.sun.rowset.CachedRowSetImpl();
 resultSet1.populate(object2.executeQuery());
 return resultSet1;
 } // end try
 finally
 {
 connection.close(); // return this connection to pool
 } // end finally
 }
    
        
        public String gec(){
           return "yeni.xhtml";
        }
    
}
