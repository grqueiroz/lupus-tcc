package com.example.grqueiroz.lupus_tcc.entity;

import android.support.annotation.StringRes;

/**
 * Created by gabriel-queiroz on 09/03/18.
 */

public class TextContent implements Content {
    private @StringRes int textId;
    private Boolean isTitle;

    public TextContent(@StringRes int textId) {
        this.textId = textId;
        this.isTitle = false;
    }

    public TextContent(@StringRes int textId, Boolean isTitle) {
        this.textId = textId;
        this.isTitle = isTitle;
    }

    @StringRes
    public int getTextId() {
        return textId;
    }

    public Boolean getIsTitle() {
        return isTitle;
    }
}
