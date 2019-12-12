/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import utils.Constants;
import utils.annotation.DisplayAs;

/**
 *
 * @author AlvaroDwi
 */
public class User {

    private int id;
    private String nik;
    private String nama;
//    private String nip; private String nik;
    private String role; //eg: Guru, Superadmin
    private String username;
    private String password;

    //getter
    @DisplayAs(value = Constants.ID, index = 0)
    public int getId() {
        return id;
    }

    @DisplayAs(value = Constants.NIK, index = 2)
    public String getNik() {
        return nik;
    }

    @DisplayAs(value = Constants.NAMA, index = 3)
    public String getNama() {
        return nama;
    }

    @DisplayAs(value = Constants.ROLE, index = 4)
    public String getRole() {
        return role;
    }

    @DisplayAs(value = Constants.USERNAME, index = 1)
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    //setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
