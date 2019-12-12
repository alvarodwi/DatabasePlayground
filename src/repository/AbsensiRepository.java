/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import data.KehadiranDAO;
import data.MatpelDAO;
import data.RekapanDAO;
import data.SiswaDAO;
import data.UserDAO;
import java.sql.SQLException;
import libs.SqliteConnection;
import model.Siswa;
import model.User;

/**
 *
 * @author AlvaroDwi
 */
public class AbsensiRepository {

    //dao access
    public SiswaDAO siswaDao;
    public MatpelDAO matpelDao;
    public RekapanDAO rekapanDao;
    public KehadiranDAO kehadiranDao;
    public UserDAO userDao;

    private User activeUser;

    public AbsensiRepository() {
        try {
            SqliteConnection conn = new SqliteConnection();
            //dao init
            siswaDao = new SiswaDAO(conn);
            matpelDao = new MatpelDAO(conn);
            rekapanDao = new RekapanDAO(conn);
            kehadiranDao = new KehadiranDAO(conn);
            userDao = new UserDAO(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //get logged in user data
    public User getActiveUser() {
        return this.activeUser;
    }

    //set user data after login
    public void setActiveUser(User user) {
        this.activeUser = user;
    }

    //reset user data after logout
    public void resetActiveUser() {
        this.activeUser = null;
    }
}
