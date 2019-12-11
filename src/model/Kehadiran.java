/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author AlvaroDwi
 */
//ini tabel yang bakal paling banyak datanya
public class Kehadiran {
    private int id; // bakal autoincrement
    //foreign key
    private int idSiswa;
    private int idMatpel;
    private int idRekapan; //kalo ini null, masuknya kehadiran hari ini (belum direkap)
    private String jamMasuk;
    private String jamKeluar;
    private String status; //yang status isinya Alpa,Sakit,Izin,Absen

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(int idSiswa) {
        this.idSiswa = idSiswa;
    }

    public int getIdMatpel() {
        return idMatpel;
    }

    public void setIdMatpel(int idMatpel) {
        this.idMatpel = idMatpel;
    }

    public int getIdRekapan() {
        return idRekapan;
    }

    public void setIdRekapan(int idRekapan) {
        this.idRekapan = idRekapan;
    }

    public String getJamMasuk() {
        return jamMasuk;
    }

    public void setJamMasuk(String jamMasuk) {
        this.jamMasuk = jamMasuk;
    }

    public String getJamKeluar() {
        return jamKeluar;
    }

    public void setJamKeluar(String jamKeluar) {
        this.jamKeluar = jamKeluar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
