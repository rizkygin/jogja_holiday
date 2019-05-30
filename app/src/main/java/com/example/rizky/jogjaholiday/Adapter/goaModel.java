package com.example.rizky.jogjaholiday.Adapter;

public class goaModel {

    private String nama,alamat,deskripsi;
    double bintang;
    int gambar;
    public goaModel(){

    }

    public goaModel(String nama, String alamat, String deskripsi, double bintang, int gambar) {
        this.nama = nama;
        this.alamat = alamat;
        this.deskripsi = deskripsi;
        this.bintang = bintang;
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public double getBintang() {
        return bintang;
    }

    public void setBintang(int bintang) {
        this.bintang = bintang;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
