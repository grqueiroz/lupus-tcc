package com.example.grqueiroz.lupus_tcc.entity;

/**
 * Created by gabriel-queiroz on 09/03/18.
 */

public class ButtonContent implements Content {
    private String title;
    private String destinationId;

    public ButtonContent(String title, String destinationId) {
        this.title = title;
        this.destinationId = destinationId;
    }

    public String getTitle() {
        return title;
    }

    public String getDestinationId() {
        return destinationId;
    }
}
