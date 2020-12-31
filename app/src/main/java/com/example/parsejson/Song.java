package com.example.parsejson;

import android.provider.MediaStore;

public class Song  {
    private String title;
    private String Artist;
    private String CoverImage;
    private String songURL;

    public  Song(){

    }
    public Song(String title,String artist,String coverImage,String songUrl){
            this.title =title;
            this.Artist=artist;
            this.CoverImage=coverImage;
            this.songURL=songUrl;


    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getCoverImage() {
        return CoverImage;
    }

    public void setCoverImage(String coverImage) {
        CoverImage = coverImage;
    }

    public String getSongURL(String url) {
        return songURL;
    }

    public void setSongURL(String songURL) {
        this.songURL = songURL;
    }
}
