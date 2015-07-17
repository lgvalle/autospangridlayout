package com.lgvalle.sample2;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by lgvalle on 09/07/15.
 */
public class SpannableImageImpl implements SpannableImage {

    private static final String TAG = SpannableImageImpl.class.getSimpleName();
    private ImageView imageView;
    private Bitmap bitmap;
    private String url;
    private int bitmapWidth;

    public SpannableImageImpl(ImageView imageView, String url) {
        this.imageView = imageView;
        this.url = url;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void setBitmapWidth(int width) {
        this.bitmapWidth = width;
    }

    @Override
    public int getBitmapWidth() {
        return bitmapWidth;
    }

    @Override
    public float autoSpan() {
        imageView.measure(imageView.getMeasuredWidth(),
                imageView.getMeasuredHeight());
        int span = bitmapWidth;
        Log.d(TAG, "span: "+span);
        return span;
    }
}
