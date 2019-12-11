/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

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

    public Siswa(int id) {
        this.id = id;
    }
    
    public int getId(){
        return id;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenis_kelamin) {
        this.jenisKelamin = jenis_kelamin;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempat_lahir) {
        this.tempatLahir = tempat_lahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggal_lahir) {
        this.tanggalLahir = tanggal_lahir;
    }
}
