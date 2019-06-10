package com.example.rizky.jogjaholiday;

public class PushComment {
    private String email;
    private String comment;
    private String id_wisata;
    private String jenis_wisata;

    PushComment(){

    }

    public PushComment(String email, String comment, String id_wisata, String jenis_wisata) {
        this.email = email;
        this.comment = comment;
        this.id_wisata = id_wisata;
        this.jenis_wisata = jenis_wisata;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getId_wisata() {
        return id_wisata;
    }

    public void setId_wisata(String id_wisata) {
        this.id_wisata = id_wisata;
    }

    public String getJenis_wisata() {
        return jenis_wisata;
    }

    public void setJenis_wisata(String jenis_wisata) {
        this.jenis_wisata = jenis_wisata;
    }
}


