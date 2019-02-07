package com.example.fernando.handballdanjoutin.classes;

public class ClsLiens {


    public String id;
    public String nom;
    public String url;
    public String photo;

    public ClsLiens() {
    }

    public ClsLiens(String id,String url, String nom, String photo) {
        this.id = id;
        this.nom = nom;
        this.url = url;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getUrl() {
        return url;
    }

    public String getPhoto() {
        return photo;
    }
}
