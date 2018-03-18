package com.example.grqueiroz.lupus_tcc.entity;

import java.util.List;

/**
 * Created by gabriel-queiroz on 05/03/18.
 */

public class Session {

    private String id;
    private List<Content> contentList;
    private String videoUrl;

    public Session(String id, List<Content> contentList, String videoUrl) {
        this.id = id;
        this.contentList = contentList;
        this.videoUrl = videoUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
