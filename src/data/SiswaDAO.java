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
import java.util.logging.Level;
import java.util.logging.Logger;
import libs.SqliteConnection;
import model.Siswa;
import utils.Constants;

/**
 *
 * @author AlvaroDwi
 */
public class SiswaDAO {

    //data access object
    private SqliteConnection conn;

    //initialize
    public SiswaDAO(SqliteConnection conn) {
        this.conn = conn;
    }

    //get single siswa
    public Siswa getDetailSiswa(int id) {
        String query = "SELECT * FROM siswa WHERE id = " + id;
        Siswa siswa = new Siswa();
        try {
            ResultSet rs = conn.getQuery(query);
            rs.next();
            //set data
            siswa.setId(rs.getInt("id"));
            siswa.setNis(rs.getString("nis"));
            siswa.setNama(rs.getString("nama"));
            siswa.setJenisKelamin(rs.getString("jenis_kelamin"));
            siswa.setTempatLahir(rs.getString("tempat_lahir"));
            siswa.setTanggalLahir(rs.getString("tanggal_lahir"));
            siswa.setKelas(rs.getString("kelas"));
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return siswa;
    }

    //get all siswa
    public List<Siswa> getAllSiswa() {
        String query = "SELECT * FROM siswa";
        List<Siswa> listSiswa = new ArrayList<>();
        try {
            ResultSet rs = conn.getQuery(query);
            while (rs.next()) {
                Siswa siswa = new Siswa();
                siswa.setId(rs.getInt("id"));
                siswa.setNis(rs.getString("nis"));
                siswa.setNama(rs.getString("nama"));
                siswa.setJenisKelamin(rs.getString("jenis_kelamin"));
                siswa.setTempatLahir(rs.getString("tempat_lahir"));
                siswa.setTanggalLahir(rs.getString("tanggal_lahir"));
                siswa.setKelas(rs.getString("kelas"));
                //add siswa from db into list
                listSiswa.add(siswa);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listSiswa;
    }

    //insert into siswa
    public void insertSiswa(Siswa siswa) {
        String query = "INSERT INTO siswa VALUES ('"
                + siswa.getId() + "','"
                + siswa.getNis() + "','"
                + siswa.getNama() + "','"
                + siswa.getJenisKelamin() + "','"
                + siswa.getTempatLahir() + "','"
                + siswa.getTanggalLahir() + "','"
                + siswa.getKelas() + "')";

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

    //update into siswa
    public void updateSiswa(int id, Siswa siswa) {
        String query = "UPDATE siswa SET "
                + "nis = '" + siswa.getNis() + "',"
                + "nama = '" + siswa.getNama() + "',"
                + "jenis_kelamin = '" + siswa.getJenisKelamin() + "',"
                + "kelas = '" + siswa.getKelas() + "',"
                + "tempat_lahir = '" + siswa.getTempatLahir() + "',"
                + "tanggal_lahir = '" + siswa.getTanggalLahir() + "'"
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

    //delete Siswa - by Id
    public void deleteSiswa(int id) {
        String query = "DELETE FROM siswa WHERE id = '" + id + "'";
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
