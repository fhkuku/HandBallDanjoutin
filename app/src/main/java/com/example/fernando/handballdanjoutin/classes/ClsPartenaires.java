package com.example.fernando.handballdanjoutin.classes;

public class ClsPartenaires {
    public String id;
    public String nom;
    public String liens;
    public String photo;
    public String addresse;
    public  String telephone;
    public String url;

    public ClsPartenaires(String nom, String addresse, String telephone, String url,String id) {
        this.id = id;
        this.nom = nom;
        this.addresse = addresse;
        this.telephone = telephone;
        this.url = url;
    }

    public ClsPartenaires() {
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getLiens() {
        return liens;
    }

    public String getPhoto() {
        return photo;
    }

    public String getAddresse() {
        return addresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getUrl() {
        return url;
    }
}
