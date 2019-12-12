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
public class Matpel {

    private int id; //id matpel
    private String nama;

    //getter
    @DisplayAs(value = Constants.ID, index = 0)
    public int getId() {
        return id;
    }

    @DisplayAs(value = Constants.NAMA, index = 1)
    public String getNama() {
        return nama;
    }

    //setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setId(int id) {
        this.id = id;
    }

}
