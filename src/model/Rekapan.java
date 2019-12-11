/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AlvaroDwi
 */
public class Rekapan {
    private int id; // ini juga autoincrement
    private String tanggal; // format YYYY-MM-DD
    //biar gampang filternya
    private String bulan; //eg: Januari
    private String tahun; // eg: 
    private String semester; // eg: Ganjil

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggal() {
        return this.tanggal;
    }
    
    public String getTanggalFormatted(){
        return this.formatDate(this.tanggal);
    }

    public void setTanggal(String tanggal) {
        this.extractDateStringAttribute(tanggal);
        this.tanggal = tanggal;
    }
    
    private void extractDateStringAttribute(String date){
        //split date
        String[] splitDate = date.split("-");
        this.bulan = splitDate[1];
        this.tahun = splitDate[0];
        this.determineSemester(splitDate[1]);
    }
    
    private void determineSemester(String month){
        if(Integer.parseInt(month)<=6){
            this.semester = "Ganjil";
        }else{
            this.semester = "Genap";
        }
    }
    
    SimpleDateFormat sdfDatabase = new SimpleDateFormat("YYYY-MM-DD");
    SimpleDateFormat sdfUI = new SimpleDateFormat("dd, MMMM YYYY");

    private String formatDate(String date){
        Date formatted;
        String result = "";
        try {
            formatted = sdfDatabase.parse(date);
            result = sdfUI.format(formatted);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
