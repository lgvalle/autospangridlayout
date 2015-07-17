package com.lgvalle.sample2;

import com.lgvalle.autospangridlayout.AutoSpannable;

/**
 * Created by lgvalle on 09/07/15.
 */
public interface SpannableImage extends AutoSpannable {
    String getUrl();

    void setUrl(String url);

    void setBitmapWidth(int width);

    int getBitmapWidth();
}
