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
//ini tabel yang bakal paling banyak datanya
public class Kehadiran {

    //db column
    private int id; // bakal autoincrement
    //foreign key
    private int idSiswa;
    private int idRekapan; //kalo ini null, masuknya kehadiran hari ini (belum direkap)
    private String jamMasuk;
    private String jamKeluar;
    private String status; //yang status isinya Alpa,Sakit,Izin,Absen
    //attribute
    private String nisSiswa;
    private String namaSiswa;

    //getter
    @DisplayAs(value = Constants.ID, index = 0)
    public int getId() {
        return id;
    }

    public int getIdSiswa() {
        return idSiswa;
    }

    public int getIdRekapan() {
        return idRekapan;
    }

    @DisplayAs(value = Constants.JAM_MASUK, index = 2)
    public String getJamMasuk() {
        return jamMasuk;
    }

    @DisplayAs(value = Constants.JAM_KELUAR, index = 3)
    public String getJamKeluar() {
        return jamKeluar;
    }

    @DisplayAs(value = Constants.STATUS_KEHADIRAN, index = 4)
    public String getStatus() {
        return status;
    }
    
    @DisplayAs(value = Constants.NAMA_SISWA, index = 1)
    public String getNamaSiswaAttribute() {
        return this.namaSiswa;
    }
    
    @DisplayAs(value = Constants.DETAIL, index = 5)
    public String getDetailButtonAttribute(){
        return Constants.DETAIL;
    }

    public String getNisSiswaAttribute() {
        return this.nisSiswa;
    }

    //setter
    public void setId(int id) {
        this.id = id;
    }

    public void setIdSiswa(int idSiswa) {
        this.idSiswa = idSiswa;
    }

    public void setIdRekapan(int idRekapan) {
        this.idRekapan = idRekapan;
    }

    public void setJamMasuk(String jamMasuk) {
        this.jamMasuk = jamMasuk;
    }

    public void setJamKeluar(String jamKeluar) {
        this.jamKeluar = jamKeluar;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNamaSiswaAttribute(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }

    public void setNisSiswaAttribute(String nisSiswa) {
        this.nisSiswa = nisSiswa;
    }
}
