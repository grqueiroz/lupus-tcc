package com.example.grqueiroz.lupus_tcc.entity;

import android.support.annotation.DrawableRes;

/**
 * Created by gabriel-queiroz on 09/03/18.
 */

public class ImageContent implements Content {
    private @DrawableRes int drawableResId;

    public ImageContent(@DrawableRes int drawableResId) {
        this.drawableResId = drawableResId;
    }

    @DrawableRes
    public int getDrawableResId() {
        return drawableResId;
    }
}
