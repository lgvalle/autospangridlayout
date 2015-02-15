package com.lgvalle.autospangridlayout;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

/**
 * Created by lgvalle on 07/02/15.
 */
public class RegularGridLayoutManager extends GridLayoutManager {
    public RegularGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
    }
}
