/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import libs.SqliteConnection;
import model.User;

/**
 *
 * @author AlvaroDwi
 */
public class UserDAO {
    //data access object
    private SqliteConnection conn;
    
    //initialize
    public UserDAO(SqliteConnection conn){
        this.conn = conn;
    }
    
    //get single user
    public User getDetailUser(int id){
        String query = "SELECT * FROM user WHERE id = "+id;
        User user = new User();
        try {
            ResultSet rs = conn.getQuery(query);
            rs.next();
            //set data
            user.setId(rs.getInt("id"));
            user.setRole(rs.getString("role"));
            user.setNik(rs.getString("nik"));
            user.setName(rs.getString("name"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return user;
    }
    
    //get all user
    public List<User> getAllUser(){
        String query = "SELECT * FROM user";
        List<User> listUser = new ArrayList<>();
        try{
            ResultSet rs = conn.getQuery(query);
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setRole(rs.getString("role"));
                user.setNik(rs.getString("nik"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                //add user from db into list
                listUser.add(user);
            }
            rs.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listUser;
    }
    
    //insert into user
    public void insertUser(User user){
        String query = "INSERT INTO user(role,nik,name,username,password) VALUES ('"
                +user.getRole()+"','"
                +user.getNik()+"','"
                +user.getName()+"','"
                +user.getUsername()+"','"
                +user.getPassword()+"')";      
        System.out.println(query);
        try{
            int queryStatus = conn.executeQuery(query);
            if(queryStatus == 1){
                //success
            }else{
                //fail
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    //update into user
    public void updateUser(int id,User user){
        String query = "UPDATE user SET "
                +"nik = '"+user.getNik()+"',"
                +"name = '"+user.getName()+"',"
                +"role = '"+user.getRole()+"',"
                +"username = '"+user.getUsername()+"',"
                +"password = '"+user.getPassword()+"',"
                +" WHERE id = '"+id+"'";
        System.out.println(query);
        try{
            int queryStatus = conn.executeQuery(query);
            if(queryStatus == 1){
                //success
            }else{
                //fail
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    //delete User - by Id
    public void deleteUser(int id){
        String query = "DELETE FROM user WHERE id = '"+id+"'";
        try{
            int queryStatus = conn.executeQuery(query);
            if(queryStatus == 1){
                //success
            }else{
                //fail
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
