/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import model.Kehadiran;
import model.Matpel;
import repository.AbsensiRepository;
import model.Siswa;
import model.User;

/**
 *
 * @author AlvaroDwi
 */
public class MainTesting {
    public static void main(String[] args){
        AbsensiRepository repo = new AbsensiRepository();
        
        Siswa thisSiswa = repo.siswaDao.getDetailSiswa(1);
        System.out.println(thisSiswa.getNama());
        
        List<Matpel> allMatpel = repo.matpelDao.getAllMatpel();
        
        allMatpel.forEach((matpel) -> {
            System.out.println(matpel.getNama());
        });
        
        List<Kehadiran> activeKehadiran = repo.kehadiranDao.getActiveKehadiran();
        
        activeKehadiran.forEach((presensi) -> {
            System.out.println(presensi.getStatus());
        });
        
        User newUser = new User();
        newUser.setName("Offy Sholehatun");
        newUser.setNik("666-666-666");
        newUser.setRole("Superadmin");
        newUser.setUsername("bunda");
        newUser.setPassword("ummi");
        repo.userDao.insertUser(newUser);
        
//        insert
//        Siswa newSiswa = new Siswa(10);
//        newSiswa.setNama("FAKHRI");
//        newSiswa.setKelas("RPL");
//        newSiswa.setNis("1718117119");
//        newSiswa.setJenisKelamin("L");
//        newSiswa.setTanggalLahir("April");
//        newSiswa.setTempatLahir("Bandung");
//        repo.siswaDao.insertSiswa(newSiswa);
//        update
//        thisSiswa.setNama("ALVARO");
//        repo.siswaDao.updateSiswa(thisSiswa.getId(), thisSiswa);
//        System.out.println(thisSiswa.getNama());
//        delete
//        repo.siswaDao.deleteSiswa(10);
    }
}
