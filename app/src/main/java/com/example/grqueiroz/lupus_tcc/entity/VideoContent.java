package com.example.grqueiroz.lupus_tcc.entity;

/**
 * Created by gabriel-queiroz on 06/05/18.
 */

public class VideoContent implements Content {

    private String url;

    public VideoContent(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
