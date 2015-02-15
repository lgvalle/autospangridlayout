package com.lgvalle.autospangridlayout;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;


/**
 * Created by lgvalle on 07/02/15.
 */
public class AutoSpannableTextImpl implements AutoSpannableText {
    private int fontSize;
    private String value;

    public AutoSpannableTextImpl(Context ctx, String value) {
        this.value = value;
        this.fontSize = ctx.getResources().getDimensionPixelSize(R.dimen.font_size);
    }

    @Override
    public float autoSpan() {
        Paint paint = new Paint();
        paint.setTextSize(fontSize);
        Rect textBounds = new Rect();
        paint.getTextBounds(value, 0, value.length(), textBounds);
        return paint.measureText(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
