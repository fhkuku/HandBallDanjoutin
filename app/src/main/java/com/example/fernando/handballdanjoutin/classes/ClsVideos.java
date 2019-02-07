package com.example.fernando.handballdanjoutin.classes;

public class ClsVideos {

    private String id;
    private String url;
    private String titre;

    public ClsVideos(String id, String url, String titre) {
        this.id = id;
        this.url = url;
        this.titre = titre;
    }

    public ClsVideos() {
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitre() {
        return titre;
    }
}
