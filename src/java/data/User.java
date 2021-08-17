/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Havvanur BOZÖMEROĞLU
 */

import static data.Arkadaslar.setMusername;
import static data.MesajGonderme.setGonderen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.sql.rowset.CachedRowSet;



@ManagedBean(name = "user")
@SessionScoped
public final class user {

    static int id;
    String firstname;
    String lastname;
    String username;
    String email;
    String password;
    String remember;
    String agreeterms;

    

    String visibility_logs; // Kayıt ol ve giriş yap butonları için
    String visibility_user;

    String school;
    String job;
    String conusername;
    String conschool;
    String conjob;

    static boolean logged;

    public user() {
        logged = false;
        
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getConusername() {
        return conusername;
    }

    public void setConusername(String conusername) {
        this.conusername = conusername;
    }

    public String getConschool() {
        return conschool;
    }

    public void setConschool(String conschool) {
        this.conschool = conschool;
    }

    public String getConjob() {
        return conjob;
    }

    public void setConjob(String conjob) {
        this.conjob = conjob;
    }


 

    public String getHiddenPassword() {
        String hiddenPass = "";
        
        if (password != null && !password.isEmpty()) {
            for (int i = 0; i < password.length(); i++) {
                hiddenPass += "*";
            }
        }
        return hiddenPass;
    }

    public String logOut() {
       

        return "index";
    }

    public String checkUser() throws SQLException {
        boolean error = false;

        if (!UserFonksiyonlari.checkEmail(email)) {
            
            error = true;
        } else if (!UserFonksiyonlari.checkPassword(password)) {
            
            error = true;
        }

        if (!error) {
            setUsername(mailiUsernameCevirme.cevir(email));
            setMusername(mailiUsernameCevirme.cevir(email));
            setGonderen(mailiUsernameCevirme.cevir(email));
            logged = true;
            return "mainpage"; // Sayfaya bağlanma
        }

        return "index";
    }

    
    CachedRowSet rowSet=null; 
  
    public ResultSet showCon() throws SQLException
 {
 // check whether dataSource was injected by the server
 
try {
      String sql = "SELECT  CONNECTIONS.conusername,CONNECTIONS.conschool,CONNECTIONS.conjob from CONNECTIONS where mainusername='"+username+"'  ";
          PreparedStatement ps = Database.getConnection().prepareStatement(sql);
         // ResultSet rs=ps.executeQuery(sql);
            
 // create a PreparedStatement to insert a new address book entry
 
// ps.setString(1,"CyberSecurity");
 rowSet = new com.sun.rowset.CachedRowSetImpl();
 rowSet.populate( ps.executeQuery() );
return rowSet;
 } // end try
 finally
 {
 Database.close(); // return this connection to pool
 } // end finally
 } 
    
    
  /*  
    CachedRowSet rowSet=null; 
    public ArrayList showCon() throws SQLException{
       Post p=new Post();
       this.username=PostFonksiyonlari.getUsername(p.email);
            try {
                  String sql = "SELECT  CONNECTIONS.conusername,CONNECTIONS.conschool,CONNECTIONS.conjob from CONNECTIONS where mainusername='"+username+"'  ";
                  PreparedStatement ps = Database.getConnection().prepareStatement(sql);
                  rowSet = new com.sun.rowset.CachedRowSetImpl();
                  rowSet.populate( ps.executeQuery() );
                  ArrayList<Message> List = new ArrayList<>();
                  while(rowSet.next()) {
                    
                    List.add(new Message(rowSet.getString(1), rowSet.getString(2), rowSet.getString(3)));
                    
                  }
                  
                  
                  return List;
             }finally{
                Database.close(); 
             } 
        }
   
*/
    public void reset() {
        id = 0;
        email = null;
        username = null;
        password = null;
       
    }
    

    /**
     * Kayıl ol butonu eylemi
     *
     * @return Yönlendirilecek sayfa
     */
    public String register() {
        boolean error = false;

        if (!UserFonksiyonlari.isNewEmail(email)) {
            error = true;
        }
        if (!UserFonksiyonlari.isNewUsername(username)) {
            
            error = true;
        }
        

        if (!error) {
            UserFonksiyonlari.createUser(username, firstname, lastname, password,  email);

            id = UserFonksiyonlari.getId();

            logged = true;

            return "mainpage?faces-redirect=true"; // Sayfaya bağlanma
        }

        return "javascript:void(0)";
    }


    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean login) {
        this.logged = login;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        user.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }

    public String getAgreeterms() {
        return agreeterms;
    }

    public void setAgreeterms(String agreeterms) {
        this.agreeterms = agreeterms;
    }

    
   /* public String sayfaGecisi() {
       if(logged==true){
        
           try {
               setUsername(mailiUsernameCevirme.cevir(email));
               setMusername(mailiUsernameCevirme.cevir(email));
               setGonderen(mailiUsernameCevirme.cevir(email));
           
           } catch (SQLException ex) {
               
           }
          return "message.xhtml";
       }
       else{
         return "index.xhtml";
       }
    }*/

    public String getVisibility_logs() {
        if (logged) {
            visibility_logs = "invisible";
        } else {
            visibility_logs = "visible";
        }
        return visibility_logs;
    }

    public void setVisibility_logs(String visiblity_logs) {
        this.visibility_logs = visiblity_logs;
    }

    public String getVisibility_user() {
        if (logged) {
            visibility_user = "visible";
        } else {
            visibility_user = "invisible";
        }
        return visibility_user;
    }

    public void setVisibility_user(String visibility_userPic) {
        this.visibility_user = visibility_userPic;
    }

    
    public String search2() throws SQLException{
      //  Post p=new Post();
    //   this.username=PostFonksiyonlari.getUsername(p.email);
    
           

            try{
                
            
           String sql = "SELECT  CONNECTIONS.conusername  from CONNECTIONS where CONNECTIONS.conusername=? and  mainusername='"+username+"'   ";
           PreparedStatement ps = Database.getConnection().prepareStatement(sql);
           ps.setString(1,getConusername());
            ResultSet rs = ps.executeQuery();
           if(rs.next()){
            return "otheprofil";
        }
        return "search";
            } 
            finally{
            Database.close(); 
            } 
            } 
    
   public String updateInfo() throws SQLException{
      
          try {
              
              
                String sql = "UPDATE T_USER set userId=?,firstname=?,lastname=?,"
                        + "username=?,email=?,password=?,school=?,job=? WHERE email='"+email+"'";

                PreparedStatement ps = Database.getConnection().prepareStatement(sql);
                ps.setInt(1,getId());
                ps.setString(2,getFirstname());
                ps.setString(3,getLastname());
                ps.setString(4,getUsername());
                ps.setString(5,getEmail());
                ps.setString(6,getPassword());
                ps.setString(7,getSchool());
                ps.setString(8,getJob());
              
                ps.executeUpdate();
              //  }
           
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
     
        }
            return "profil.xhtml";
    }
    
     public static void main(String args[]){
         
   
    }
     
     /*
     
     public  void Firstname2(){
       
        String field = "";

        
            try {
                String sql = "SELECT firstname FROM T_USER WHERE username=? ";

                PreparedStatement statement = Database.getConnection().prepareStatement(sql);
                 statement.setString(1, username);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    field = rs.getString(1);
                }

                Database.close();
        
        
            
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
     
        }
           this.firstname = field;
    }
   
     public  String Lastname2(){
       
        String field = "";

        
            try {
                String sql = "SELECT lastname FROM USERINFO WHERE username=? ";

                PreparedStatement statement = Database.getConnection().prepareStatement(sql);
                 statement.setString(1, username);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    field = rs.getString(1);
                }

                Database.close();
        
        
            
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
     
        }
            return field;
    }
     
     
     
   public  String Job2(){
       
        String field = "";

        
            try {
                String sql = "SELECT job FROM USERINFO WHERE username=? ";

                PreparedStatement statement = Database.getConnection().prepareStatement(sql);
                 statement.setString(1, username);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    field = rs.getString(1);
                }

                Database.close();
        
        
            
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
     
        }
            return field;
    }
     
   public  String School2(){
       
        String field = "";

        
            try {
                String sql = "SELECT school FROM USERINFO WHERE username=? ";

                PreparedStatement statement = Database.getConnection().prepareStatement(sql);
                 statement.setString(1, username);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    field = rs.getString(1);
                }

                Database.close();
        
        
            
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
     
        }
            return field;
    }
     */
     
}
