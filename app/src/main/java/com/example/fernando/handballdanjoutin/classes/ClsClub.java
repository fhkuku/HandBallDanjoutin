package com.example.fernando.handballdanjoutin.classes;

public class ClsClub {

    private String idclub;
    private String url;
    private String nom;

    public ClsClub(String idclub, String url, String nom) {
        this.idclub = idclub;
        this.url = url;
        this.nom = nom;
    }


    public ClsClub() {
    }

    public String getIdclub() {
        return idclub;
    }

    public String getUrl() {
        return url;
    }

    public String getNom() {
        return nom;
    }
}
