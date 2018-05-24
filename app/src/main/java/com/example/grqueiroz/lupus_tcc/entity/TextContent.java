package com.example.grqueiroz.lupus_tcc.entity;

import android.support.annotation.StringRes;

/**
 * Created by gabriel-queiroz on 09/03/18.
 */

public class TextContent implements Content {
    private @StringRes int textId;
    private Boolean justify;

    public TextContent(@StringRes int textId) {
        this.textId = textId;
        this.justify = true;
    }

    public TextContent(@StringRes int textId, Boolean justify) {
        this.textId = textId;
        this.justify = justify;
    }

    @StringRes
    public int getTextId() {
        return textId;
    }

    public Boolean getJustify() {
        return justify;
    }
}
