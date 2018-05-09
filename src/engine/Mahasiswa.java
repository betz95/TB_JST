/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

/**
 *
 * @author Ermengarde
 */
public class Mahasiswa {
    private String nama;
    private int gender;
    private int kotaAsal;
    private int frekuensiAkses;
    private int jurusan;
    private int hobi;
    private String jenisApkOnline;
    private String cluster;

    public Mahasiswa(String nama, int gender, int kotaAsal, int frekuensiAkses, int jurusan, int hobi, String jenisApkOnline) {
        this.nama = nama;
        this.gender = gender;
        this.kotaAsal = kotaAsal;
        this.frekuensiAkses = frekuensiAkses;
        this.jurusan = jurusan;
        this.hobi = hobi;
        this.jenisApkOnline = jenisApkOnline;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getKotaAsal() {
        return kotaAsal;
    }

    public void setKotaAsal(int kotaAsal) {
        this.kotaAsal = kotaAsal;
    }

    public int getFrekuensiAkses() {
        return frekuensiAkses;
    }

    public void setFrekuensiAkses(int frekuensiAkses) {
        this.frekuensiAkses = frekuensiAkses;
    }

    public int getJurusan() {
        return jurusan;
    }

    public void setJurusan(int jurusan) {
        this.jurusan = jurusan;
    }

    public int getHobi() {
        return hobi;
    }

    public void setHobi(int hobi) {
        this.hobi = hobi;
    }

    public String getJenisApkOnline() {
        return jenisApkOnline;
    }

    public void setJenisApkOnline(String jenisApkOnline) {
        this.jenisApkOnline = jenisApkOnline;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }
}
