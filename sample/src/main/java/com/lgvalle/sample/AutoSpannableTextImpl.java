package com.lgvalle.sample;

import android.content.Context;
import android.graphics.Paint;
import android.util.Log;

import com.lgvalle.sample.sample.R;


/**
 * Created by lgvalle on 07/02/15.
 */
public class AutoSpannableTextImpl implements AutoSpannableText {
    private static final String TAG = AutoSpannableText.class.getSimpleName();
    private final float marginSize;
    private float fontSize;
    private String value;

    public AutoSpannableTextImpl(Context ctx, String value) {
        this.value = value;
        this.fontSize = ctx.getResources().getDimension(R.dimen.font_size);
        this.marginSize = ctx.getResources().getDimension(R.dimen.text_margin);
    }

    @Override
    public float autoSpan() {
        Paint paint = new Paint();
        paint.setTextSize(fontSize);
        //Rect textBounds = new Rect();
        //paint.getTextBounds(value, 0, value.length(), textBounds);
        float textMeasure = paint.measureText(value, 0, value.length());
        Log.d(TAG, "Measured: " + textMeasure);
        Log.d(TAG, "Margin:" + marginSize);
        return textMeasure + marginSize;
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
