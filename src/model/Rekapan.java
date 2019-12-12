/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Constants;
import utils.annotation.DisplayAs;

/**
 *
 * @author AlvaroDwi
 */
public class Rekapan {

    private int id; // ini juga autoincrement
    private int idMatpel;
    private String tanggal; // format YYYY-MM-DD
    //attributes
    private String namaMatpel;
    private String bulan; //eg: Januari
    private int tahun; // eg: 
    private String semester; // eg: Ganjil
    //helper
    private SimpleDateFormat sdfDatabase = new SimpleDateFormat("YYYY-MM-DD");
    private SimpleDateFormat sdfUI = new SimpleDateFormat("dd, MMMM YYYY");
    //getter

    @DisplayAs(value = Constants.ID, index = 0)
    public int getId() {
        return id;
    }

    public int getIdMatpel() {
        return idMatpel;
    }

    public String getTanggal() {
        return this.tanggal;
    }

    //setter
    public void setId(int id) {
        this.id = id;
    }

    public void setIdMatpel(int idMatpel) {
        this.idMatpel = idMatpel;
    }

    public void setTanggal(String tanggal) {
        this.extractDateStringAttribute(tanggal);
        this.tanggal = tanggal;
    }
    //attribute
    @DisplayAs(value = Constants.TANGGAL_REKAPAN, index = 1)
    public String getTanggalAttribute() {
        return this.formatDate(this.tanggal);
    }

    @DisplayAs(value = Constants.NAMA_MATPEL, index = 2)
    public String getNamaMatpelAttribute() {
        return this.namaMatpel;
    }

    @DisplayAs(value = Constants.BULAN_REKAPAN, index = 3)
    public String getBulanAttribute() {
        return this.bulan;
    }
    
    public int getTahunAttribute(){
        return this.tahun;
    }

    @DisplayAs(value = Constants.SEMESTER_REKAPAN, index = 4)
    public String getSemesterAttribute() {
        return this.semester + "/" + this.tahun;
    }
    
    public void setNamaMatpelAttribute(String namaMatpel) {
        this.namaMatpel = namaMatpel;
    }
    
    public void setBulanAttribute(String bulan) {
        this.bulan = bulan;
    }
    
    public void setTahunAttribute(int tahun){
        this.tahun = tahun;
    }
    
    public void setSemesterAttribute(String semester){
        this.semester = semester;
    }

    //formatter
    private void extractDateStringAttribute(String date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(convertStringToDate(date));

        setBulanAttribute(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));
        setTahunAttribute(calendar.get(Calendar.YEAR));
        setSemesterAttribute(determineSemester(calendar.get(Calendar.MONTH)));
    }

    private String determineSemester(int month) {
        if (month <= 6) {
            return "Ganjil";
        } else {
            return "Genap";
        }
    }

    private Date convertStringToDate(String date) {
        Date result = new Date();
        try {
            result = sdfDatabase.parse(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private String formatDate(String date) {
        Date targetDate = convertStringToDate(date);
        return sdfUI.format(targetDate);
    }
}
