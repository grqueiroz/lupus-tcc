package com.example.grqueiroz.lupus_tcc.entity;

import android.support.annotation.StringRes;

import java.util.List;

/**
 * Created by gabriel-queiroz on 05/03/18.
 */

public class Session {

    private String id;
    private @StringRes int title;
    private List<Content> contentList;
    private String videoUrl;

    public Session(String id, @StringRes int title, List<Content> contentList, String videoUrl) {
        this.id = id;
        this.title = title;
        this.contentList = contentList;
        this.videoUrl = videoUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @StringRes int getTitle() {
        return title;
    }

    public void setTitle(@StringRes int title) {
        this.title = title;
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
