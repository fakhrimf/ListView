package com.pwpb.listview;

public class Poster {
    int image;
    String name, album;

    public Poster(int image, String name, String album) {
        this.image = image;
        this.name = name;
        this.album = album;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getAlbum() {
        return album;
    }
}
