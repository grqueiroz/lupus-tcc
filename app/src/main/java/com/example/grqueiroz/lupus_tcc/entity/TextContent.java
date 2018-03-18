package com.example.grqueiroz.lupus_tcc.entity;

import android.support.annotation.StringRes;

/**
 * Created by gabriel-queiroz on 09/03/18.
 */

public class TextContent implements Content {
    private @StringRes int textId;

    public TextContent(@StringRes int textId) {
        this.textId = textId;
    }

    @StringRes
    public int getTextId() {
        return textId;
    }
}
