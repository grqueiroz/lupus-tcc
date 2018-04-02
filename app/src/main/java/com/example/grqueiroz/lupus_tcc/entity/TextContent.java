package com.example.grqueiroz.lupus_tcc.entity;

import android.support.annotation.StringRes;

/**
 * Created by gabriel-queiroz on 09/03/18.
 */

public class TextContent implements Content {
    private @StringRes int textId;
    private Boolean isTitle;
    private Boolean justify;

    public TextContent(@StringRes int textId) {
        this.textId = textId;
        this.isTitle = false;
        this.justify = true;
    }

    public TextContent(@StringRes int textId, Boolean isTitle) {
        this.textId = textId;
        this.isTitle = isTitle;
        this.justify = !isTitle;
    }

    public TextContent(@StringRes int textId, Boolean isTitle, Boolean justify) {
        this.textId = textId;
        this.isTitle = isTitle;
        this.justify = justify;
    }

    @StringRes
    public int getTextId() {
        return textId;
    }

    public Boolean getIsTitle() {
        return isTitle;
    }

    public Boolean getJustify() {
        return justify;
    }
}
