package com.example.grqueiroz.lupus_tcc.entity;

import android.support.annotation.StringRes;

import java.util.List;

/**
 * Created by gabriel-queiroz on 05/03/18.
 */

public class Session {

    private String id;
    private @StringRes int mainTopicTitle;
    private List<Content> contentList;
    private String videoUrl;

    public Session(String id, @StringRes int mainTopicTitle, List<Content> contentList, String videoUrl) {
        this.id = id;
        this.mainTopicTitle = mainTopicTitle;
        this.contentList = contentList;
        this.videoUrl = videoUrl;
    }

    public Session(String id, @StringRes int mainTopicTitle, List<Content> contentList) {
        this.id = id;
        this.mainTopicTitle = mainTopicTitle;
        this.contentList = contentList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @StringRes int getMainTopicTitle() {
        return mainTopicTitle;
    }

    public void setMainTopicTitle(@StringRes int mainTopicTitle) {
        this.mainTopicTitle = mainTopicTitle;
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
