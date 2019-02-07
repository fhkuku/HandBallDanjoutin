package com.example.fernando.handballdanjoutin.classes;

public class ClsEquipes {


    public String id;
    public String nom;
    public String photo;

    public ClsEquipes() {
    }

    public ClsEquipes(String id, String nom, String photo) {
        this.id = id;
        this.nom = nom;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPhoto() {
        return photo;
    }
}
