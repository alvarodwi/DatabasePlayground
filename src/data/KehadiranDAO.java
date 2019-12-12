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
import model.Kehadiran;
import utils.Constants;

/**
 *
 * @author AlvaroDwi
 */
public class KehadiranDAO {

    //data access object
    private SqliteConnection conn;

    //initialize
    public KehadiranDAO(SqliteConnection conn) {
        this.conn = conn;
    }

    //get single kehadiran
    public Kehadiran getDetailKehadiran(int id) {
        String query = "SELECT * FROM kehadiran WHERE id = " + id;
        Kehadiran kehadiran = new Kehadiran();
        try {
            ResultSet rs = conn.getQuery(query);
            rs.next();
            //set data
            kehadiran.setId(rs.getInt("id"));
            kehadiran.setIdSiswa(rs.getInt("id_siswa"));
            kehadiran.setIdRekapan(rs.getInt("id_rekapan"));
            kehadiran.setJamMasuk(rs.getString("jam_masuk"));
            kehadiran.setJamKeluar(rs.getString("jam_keluar"));
            kehadiran.setStatus(rs.getString("status_kehadiran"));
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return kehadiran;
    }

    //get all kehadiran
    public List<Kehadiran> getActiveKehadiran() {
        String query = "SELECT * FROM kehadiran WHERE id_rekapan IS NULL";
        List<Kehadiran> listKehadiran = new ArrayList<>();
        try {
            ResultSet rs = conn.getQuery(query);
            while (rs.next()) {
                Kehadiran kehadiran = new Kehadiran();
                kehadiran.setId(rs.getInt("id"));
                kehadiran.setIdSiswa(rs.getInt("id_siswa"));
                kehadiran.setIdRekapan(rs.getInt("id_rekapan"));
                kehadiran.setJamMasuk(rs.getString("jam_masuk"));
                kehadiran.setJamKeluar(rs.getString("jam_keluar"));
                kehadiran.setStatus(rs.getString("status"));
                //add kehadiran from db into list
                listKehadiran.add(kehadiran);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listKehadiran;
    }

    public List<Kehadiran> getKehadiranByRekapan(int idRekapan) {
        String query = "SELECT * FROM kehadiran WHERE id_rekapan = '" + idRekapan + "'";
        List<Kehadiran> listKehadiran = new ArrayList<>();
        try {
            ResultSet rs = conn.getQuery(query);
            while (rs.next()) {
                Kehadiran kehadiran = new Kehadiran();
                kehadiran.setId(rs.getInt("id"));
                kehadiran.setIdSiswa(rs.getInt("id_siswa"));
                kehadiran.setIdRekapan(rs.getInt("id_rekapan"));
                kehadiran.setJamMasuk(rs.getString("jam_masuk"));
                kehadiran.setJamKeluar(rs.getString("jam_keluar"));
                kehadiran.setStatus(rs.getString("status_kehadiran"));
                //add kehadiran from db into list
                listKehadiran.add(kehadiran);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listKehadiran;
    }

    //insert into kehadiran
    public void insertKehadiran(Kehadiran kehadiran) {
        String query = "INSERT INTO kehadiran(id_siswa,id_matpel,id_rekapan,jam_masuk,jam_keluar,status) VALUES ('"
                + kehadiran.getIdSiswa() + ","
                + kehadiran.getIdRekapan() + ","
                + kehadiran.getJamMasuk() + ","
                + kehadiran.getJamKeluar() + ","
                + kehadiran.getStatus() + "')";
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

    //update into kehadiran
    public void updateKehadiran(int id, Kehadiran kehadiran) {
        String query = "UPDATE kehadiran SET "
                + "id_siswa = '" + kehadiran.getIdSiswa() + "',"
                + "id_rekapan = '" + kehadiran.getIdRekapan() + "',"
                + "jam_masuk = '" + kehadiran.getJamMasuk() + "',"
                + "jam_keluar = '" + kehadiran.getJamKeluar() + "',"
                + "status_kehadiran = '" + kehadiran.getStatus() + "'"
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

    //delete Kehadiran - by Id
    public void deleteKehadiran(int id) {
        String query = "DELETE FROM kehadiran WHERE id = '" + id + "'";
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
