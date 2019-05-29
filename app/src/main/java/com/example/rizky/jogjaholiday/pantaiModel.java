package com.example.rizky.jogjaholiday;

public class pantaiModel {
    private String nama,alamat,deskripsi;
    int bintang;
    int gambar;

    public  pantaiModel(){

     }
    public pantaiModel(String nama, String alamat, int bintang, String deskripsi, int gambar) {
        this.nama = nama;
        this.alamat = alamat;
        this.bintang = bintang;
        this.deskripsi = deskripsi;
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

    public int getBintang() {
        return bintang;
    }

    public void setBintang(int bintang) {
        this.bintang = bintang;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
