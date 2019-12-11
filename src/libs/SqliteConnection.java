/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author AlvaroDwi
 */
public class SqliteConnection {
    private Connection conn;
    private Statement stmt;
    
    public SqliteConnection() throws SQLException{
        String url = "jdbc:sqlite:"+System.getProperty("user.dir")+"\\absensi.db";
        System.out.println(url);
        try{
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Create,Update,Delete of CRUD
    public int executeQuery(String sql) throws SQLException{
        return stmt.executeUpdate(sql);
    }
    
    //Read of CRUD
    public ResultSet getQuery(String sql) throws SQLException{
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }
}
