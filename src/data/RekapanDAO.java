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
import model.Rekapan;
import utils.Constants;

/**
 *
 * @author AlvaroDwi
 */
public class RekapanDAO {

    //data access object
    private SqliteConnection conn;

    //initialize
    public RekapanDAO(SqliteConnection conn) {
        this.conn = conn;
    }

    //get single rekapan
    public Rekapan getDetailRekapan(int id) {
        String query = "SELECT * FROM rekapan WHERE id = " + id;
        Rekapan rekapan = new Rekapan();
        try {
            ResultSet rs = conn.getQuery(query);
            rs.next();
            //set data
            rekapan.setId(rs.getInt("id"));
            rekapan.setIdMatpel(rs.getInt("id_matpel"));
            rekapan.setTanggal(rs.getString("tanggal"));
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rekapan;
    }

    //get all rekapan
    public List<Rekapan> getAllRekapan() {
        String query = "SELECT * FROM rekapan";
        List<Rekapan> listRekapan = new ArrayList<>();
        try {
            ResultSet rs = conn.getQuery(query);
            while (rs.next()) {
                Rekapan rekapan = new Rekapan();
                rekapan.setId(rs.getInt("id"));
                rekapan.setIdMatpel(rs.getInt("id_matpel"));
                rekapan.setTanggal(rs.getString("tanggal"));
                //add rekapan from db into list
                listRekapan.add(rekapan);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listRekapan;
    }

    //insert into rekapan
    public void insertRekapan(Rekapan rekapan) {
        String query = "INSERT INTO rekapan('tanggal') VALUES ('"
                + rekapan.getIdMatpel() + ","
                + rekapan.getTanggal() + "')";
        System.out.println(query);
        try {
            int queryStatus = conn.executeQuery(query);
            if (queryStatus == 1) {
                //success
            } else {
                //fail
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //update into rekapan
    public void updateRekapan(int id, Rekapan rekapan) {
        String query = "UPDATE rekapan SET "
                + "id_matpel = '" + rekapan.getIdMatpel() + "',"
                + "tanggal = '" + rekapan.getTanggal() + "'"
                + " WHERE id = '" + id + "'";
        System.out.println(query);
        try {
            int queryStatus = conn.executeQuery(query);
            if (queryStatus == 1) {
                //success
            } else {
                //fail
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //delete Rekapan - by Id
    public void deleteRekapan(int id) {
        String query = "DELETE FROM rekapan WHERE id = '" + id + "'";
        try {
            int queryStatus = conn.executeQuery(query);
            if (queryStatus == 1) {
                //success
            } else {
                //fail
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
