package com.example.fernando.handballdanjoutin.classes;

public class ClsUser {


    private String id;
    private String nom;
    private String img;
    private String email;
    private String idtype;
    private String rol;
    private String idclub;


    public ClsUser(String id, String nom, String img, String email, String idtype, String rol, String idclub) {

        this.id = id;
        this.nom = nom;
        this.img = img;
        this.email = email;
        this.idtype = idtype;
        this.rol = rol;
        this.idclub = idclub;
    }

    public ClsUser() {

    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getImg() {
        return img;
    }

    public String getEmail() {
        return email;
    }

    public String getIdtype() {
        return idtype;
    }

    public String getRol() {
        return rol;
    }

    public String getIdclub() {
        return idclub;
    }
}
