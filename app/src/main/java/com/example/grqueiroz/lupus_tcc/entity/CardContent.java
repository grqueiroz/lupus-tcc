package com.example.grqueiroz.lupus_tcc.entity;

/**
 * Created by gabriel-queiroz on 09/03/18.
 */

public class CardContent implements Content {
    private String title;
    private String destinationId;
    private ImageContent cardImage;
    private TextContent cardText;

    public CardContent(String title, String destinationId, ImageContent cardImage, TextContent cardText) {
        this.title = title;
        this.destinationId = destinationId;
        this.cardImage = cardImage;
        this.cardText = cardText;
    }

    public String getTitle() {
        return title;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public ImageContent getCardImage() {
        return cardImage;
    }

    public TextContent getCardText() {
        return cardText;
    }
}
