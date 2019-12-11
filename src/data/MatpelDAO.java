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
import model.Matpel;

/**
 *
 * @author AlvaroDwi
 */
public class MatpelDAO {
    //data access object
    private SqliteConnection conn;
    
    //initialize
    public MatpelDAO(SqliteConnection conn){
        this.conn = conn;
    }
    
    //get single matpel
    public Matpel getDetailMatpel(int id){
        String query = "SELECT * FROM matpel WHERE id = "+id;
        Matpel matpel = new Matpel();
        try {
            ResultSet rs = conn.getQuery(query);
            rs.next();
            //set data
            matpel.setId(rs.getInt("id"));
            matpel.setNama(rs.getString("nama"));
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return matpel;
    }
    
    //get all matpel
    public List<Matpel> getAllMatpel(){
        String query = "SELECT * FROM matpel";
        List<Matpel> listMatpel = new ArrayList<>();
        try{
            ResultSet rs = conn.getQuery(query);
            while(rs.next()){
                Matpel matpel = new Matpel();
                matpel.setId(rs.getInt("id"));
                matpel.setNama(rs.getString("nama"));
                //add matpel from db into list
                listMatpel.add(matpel);
            }
            rs.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return listMatpel;
    }
    
    //insert into matpel
    public void insertMatpel(Matpel matpel){
        String query = "INSERT INTO matpel(nama) VALUES ('"
                +matpel.getNama()+"')";
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
    
    //update into matpel
    public void updateMatpel(int id,Matpel matpel){
        String query = "UPDATE matpel SET "
                +"nama = '"+matpel.getNama()
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
    
    //delete Matpel - by Id
    public void deleteMatpel(int id){
        String query = "DELETE FROM matpel WHERE id = '"+id+"'";
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
