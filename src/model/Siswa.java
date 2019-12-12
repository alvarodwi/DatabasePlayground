/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;
import utils.Constants;
import utils.annotation.DisplayAs;

/**
 *
 * @author AlvaroDwi
 */
public class Siswa {

    //init variable
    private int id; //id dari rfid nya, tipe datanya apa coba?
    private String nis; //id siswa yang ditampilkan
    private String nama;
    private String kelas; //ini mau dipisah dengan jurusan gak?
//    private String jurusan;
    private String jenisKelamin;
    private String tempatLahir;
    private String tanggalLahir;

    //getter
    @DisplayAs(value = Constants.CARD_ID, index = 0)
    public int getId() {
        return id;
    }

    @DisplayAs(value = Constants.NIS, index = 1)
    public String getNis() {
        return nis;
    }

    @DisplayAs(value = Constants.NAMA, index = 2)
    public String getNama() {
        return nama;
    }

    @DisplayAs(value = Constants.JENKEL, index = 3)
    public String getJenisKelamin() {
        return jenisKelamin;
    }

    @DisplayAs(value = Constants.TEMPAT_LAHIR, index = 5)
    public String getTempatLahir() {
        return tempatLahir;
    }

    @DisplayAs(value = Constants.TANGGAL_LAHIR, index = 6)
    public String getTanggalLahir() {
        return tanggalLahir;
    }
    
    @DisplayAs(value = Constants.KELAS, index = 4)
    public String getKelas() {
        return kelas;
    }

    //setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public void setJenisKelamin(String jenis_kelamin) {
        this.jenisKelamin = jenis_kelamin;
    }

    public void setTempatLahir(String tempat_lahir) {
        this.tempatLahir = tempat_lahir;
    }

    public void setTanggalLahir(String tanggal_lahir) {
        this.tanggalLahir = tanggal_lahir;
    }
}
