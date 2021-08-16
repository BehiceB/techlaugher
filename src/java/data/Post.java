/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;



import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.rowset.CachedRowSet;
/**
 *
 * @author Havvanur BOZÖMEROĞLU
 */
@ManagedBean(name = "post")
@SessionScoped
public class Post {
    static int postId;
   
    String username;
    String email;
    int likeNum;
    int savedNum;
    String comment;
    String commenter;
    String description;
    String field;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        Post.postId = postId;
    }

   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getSavedNum() {
        return savedNum;
    }

    public void setSavedNum(int savedNum) {
        this.savedNum = savedNum;
    }

    
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }
    
    
    
     
     
    
    public String addPostText(){
       
        
        username = PostFonksiyonlari.getUsername(email);
        
        PostFonksiyonlari.addPost( username, description, field);
        return "mainpage";
    }
    
 
    
    
   public String addPostText2(){
       
        
        username = PostFonksiyonlari.getUsername(email);
        
        PostFonksiyonlari.addPost( username, description, field);
        return "profil";
    }

   
    
    
    
   public  String mainpagePost() {
        PostFonksiyonlari.GetFollowTweets();
        return "mainpage";
    }
    
    
  CachedRowSet rowSet=null; 
        public ArrayList bul() throws SQLException{
            try {
                  String sql = "SELECT  POST.username,POST.description,POST.likeNum from POST where field='Al' order by postId DESC ";
                  PreparedStatement ps = Database.getConnection().prepareStatement(sql);
                  rowSet = new com.sun.rowset.CachedRowSetImpl();
                  rowSet.populate( ps.executeQuery() );
                  ArrayList<Message> List = new ArrayList<>();
                  while(rowSet.next()) {
                    
                    List.add(new Message(rowSet.getString(1), rowSet.getString(2), rowSet.getInt(3)));
                    
                  }
                  
                  
                  return List;
             }finally{
                Database.close(); 
             } 
        } 

         public ArrayList bulCyber() throws SQLException{
            try {
                  String sql = "SELECT  POST.username,POST.description,POST.likeNum from POST where field='CyberSecurity' order by postId DESC ";
                  PreparedStatement ps = Database.getConnection().prepareStatement(sql);
                  rowSet = new com.sun.rowset.CachedRowSetImpl();
                  rowSet.populate( ps.executeQuery() );
                  ArrayList<Message> List = new ArrayList<>();
                  while(rowSet.next()) {
                    
                    List.add(new Message(rowSet.getString(1), rowSet.getString(2), rowSet.getInt(3)));
                    
                  }
                  
                  
                  return List;
             }finally{
                Database.close(); 
             } 
        } 
    
          public ArrayList bulFun() throws SQLException{
            try {
                  String sql = "SELECT  POST.username,POST.description,POST.likeNum from POST where field='Fun' order by postId DESC ";
                  PreparedStatement ps = Database.getConnection().prepareStatement(sql);
                  rowSet = new com.sun.rowset.CachedRowSetImpl();
                  rowSet.populate( ps.executeQuery() );
                  ArrayList<Message> List = new ArrayList<>();
                  while(rowSet.next()) {
                    
                    List.add(new Message(rowSet.getString(1), rowSet.getString(2), rowSet.getInt(3)));
                    
                  }
                  
                  
                  return List;
             }finally{
                Database.close(); 
             } 
        } 
          
          
           public ArrayList bulGame() throws SQLException{
            try {
                  String sql = "SELECT  POST.username,POST.description,POST.likeNum from POST where field='Game' order by postId DESC ";
                  PreparedStatement ps = Database.getConnection().prepareStatement(sql);
                  rowSet = new com.sun.rowset.CachedRowSetImpl();
                  rowSet.populate( ps.executeQuery() );
                  ArrayList<Message> List = new ArrayList<>();
                  while(rowSet.next()) {
                    
                    List.add(new Message(rowSet.getString(1), rowSet.getString(2), rowSet.getInt(3)));
                    
                  }
                  
                  
                  return List;
             }finally{
                Database.close(); 
             } 
        } 
          
           public ArrayList bulWeb() throws SQLException{
            try {
                  String sql = "SELECT  POST.username,POST.description,POST.likeNum from POST where field='Web-Mobile' order by postId DESC ";
                  PreparedStatement ps = Database.getConnection().prepareStatement(sql);
                  rowSet = new com.sun.rowset.CachedRowSetImpl();
                  rowSet.populate( ps.executeQuery() );
                  ArrayList<Message> List = new ArrayList<>();
                  while(rowSet.next()) {
                    
                    List.add(new Message(rowSet.getString(1), rowSet.getString(2), rowSet.getInt(3)));
                    
                  }
                  
                  
                  return List;
             }finally{
                Database.close(); 
             } 
        } 
          
           public ArrayList bulMyPost() throws SQLException{
            String username = PostFonksiyonlari.getUsername(email);
               try {
                  String sql = "SELECT  POST.username,POST.description,POST.likeNum from POST where username='"+username+"' order by postId DESC ";
                  PreparedStatement ps = Database.getConnection().prepareStatement(sql);
                  rowSet = new com.sun.rowset.CachedRowSetImpl();
                  rowSet.populate( ps.executeQuery() );
                  ArrayList<Message> List = new ArrayList<>();
                  while(rowSet.next()) {
                    
                    List.add(new Message(rowSet.getString(1), rowSet.getString(2), rowSet.getInt(3)));
                    
                  }
                  
                  
                  return List;
             }finally{
                Database.close(); 
             } 
        } 
           
       public void likeNumIncrease() throws SQLException{
            try {
                    int postId = PostFonksiyonlari.getPostIdd(description);
                
                    int oldLikeNum = 0; 
                    String sql = "SELECT likeNum FROM POST WHERE postId=? ";
                    PreparedStatement statement = data.Database.getConnection().prepareStatement(sql);
                    statement.setInt(1, postId);
                    ResultSet rs = statement.executeQuery();
                    if (rs.next()) {
                         oldLikeNum = rs.getInt(1);
                    }
                    
                    oldLikeNum = oldLikeNum + 1;
                    
                  
                   
                   String sql2 = "UPDATE POST SET likeNum =?   WHERE postId=" + postId + " ";
                    PreparedStatement statement2 = data.Database.getConnection().prepareStatement(sql2);
                    statement2.setInt(1, oldLikeNum);
                    statement2.executeUpdate();
                   
                  
             }finally{
                Database.close(); 
             } 
       }
       
       
       
           
           
}
