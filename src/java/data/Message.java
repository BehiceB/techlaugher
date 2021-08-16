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
public class Message {
    public String username;
    public String description;
    public int likeNum;
    public String conusername;
    public String conschool;
    public String conjob;

    public Message(String username, String description, int likeNum) {
        this.username = username;
        this.description = description;
        this.likeNum = likeNum;
    }

    public Message(String conusername, String conschool, String conjob) {
        this.conusername=conusername;
        this.conschool=conschool;
        this.conjob=conjob;
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

    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    
    
    
}
