package com.example.grqueiroz.lupus_tcc.entity;

/**
 * Created by gabriel-queiroz on 09/03/18.
 */

public class CardContent implements Content {
    private String destinationId;
    private ImageContent cardImage;
    private TextContent cardText;

    public CardContent(String destinationId, ImageContent cardImage, TextContent cardText) {
        this.destinationId = destinationId;
        this.cardImage = cardImage;
        this.cardText = cardText;
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
