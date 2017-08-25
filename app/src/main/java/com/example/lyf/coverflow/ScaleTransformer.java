package com.example.lyf.coverflow;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by 刘宇飞 on 2017/8/24.
 * 邮箱：3494576680@qq.com
 * 描述：
 */

public class ScaleTransformer implements ViewPager.PageTransformer {
    private Context context;
    private float elevation;
    private static final float MIN_SCALE = 0.8f;
    private static final float MIN_ALPHA = 0.5f;

    public ScaleTransformer(Context context) {
        this.context = context;
        elevation = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                0, context.getResources().getDisplayMetrics());
    }

    @Override
    public void transformPage(View page, float position) {
        if (position < -1 || position > 1) {
            page.setScaleX(MIN_SCALE);
            page.setScaleY(MIN_SCALE);
        } else  {
            if (position < 0) {
                ((CardView) page).setCardElevation((1 + position) * elevation);
                float scaleX = 1 + 0.2f * position;
                page.setScaleX(scaleX);
                page.setScaleY(scaleX);
            } else {
                ((CardView) page).setCardElevation((1 - position) * elevation);
                float scaleX = 1 - 0.2f * position;
                page.setScaleX(scaleX);
                page.setScaleY(scaleX);
            }
        }
    }
}