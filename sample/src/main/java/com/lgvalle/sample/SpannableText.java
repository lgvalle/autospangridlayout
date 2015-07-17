package com.lgvalle.sample;


import com.lgvalle.autospangridlayout.AutoSpannable;

/**
 * Created by lgvalle on 08/02/15.
 */
public interface SpannableText extends AutoSpannable {
    String getValue();
    void setValue(String value);
}
