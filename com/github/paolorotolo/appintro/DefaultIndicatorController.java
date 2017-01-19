package com.github.paolorotolo.appintro;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.List;

class DefaultIndicatorController implements IndicatorController {
    public static final int DEFAULT_COLOR = 1;
    private static final int FIRST_PAGE_NUM = 0;
    private Context mContext;
    int mCurrentPosition;
    private LinearLayout mDotLayout;
    private List<ImageView> mDots;
    private int mSlideCount;
    int selectedDotColor;
    int unselectedDotColor;

    DefaultIndicatorController() {
        this.selectedDotColor = DEFAULT_COLOR;
        this.unselectedDotColor = DEFAULT_COLOR;
    }

    public View newInstance(@NonNull Context context) {
        this.mContext = context;
        this.mDotLayout = (LinearLayout) View.inflate(context, C0394R.layout.default_indicator, null);
        return this.mDotLayout;
    }

    public void initialize(int slideCount) {
        this.mDots = new ArrayList();
        this.mSlideCount = slideCount;
        this.selectedDotColor = -1;
        this.unselectedDotColor = -1;
        for (int i = 0; i < slideCount; i += DEFAULT_COLOR) {
            ImageView dot = new ImageView(this.mContext);
            dot.setImageDrawable(ContextCompat.getDrawable(this.mContext, C0394R.drawable.indicator_dot_grey));
            this.mDotLayout.addView(dot, new LayoutParams(-2, -2));
            this.mDots.add(dot);
        }
        selectPosition(0);
    }

    public void selectPosition(int index) {
        this.mCurrentPosition = index;
        int i = 0;
        while (i < this.mSlideCount) {
            Drawable drawable = ContextCompat.getDrawable(this.mContext, i == index ? C0394R.drawable.indicator_dot_white : C0394R.drawable.indicator_dot_grey);
            if (this.selectedDotColor != DEFAULT_COLOR && i == index) {
                drawable.mutate().setColorFilter(this.selectedDotColor, Mode.SRC_IN);
            }
            if (!(this.unselectedDotColor == DEFAULT_COLOR || i == index)) {
                drawable.mutate().setColorFilter(this.unselectedDotColor, Mode.SRC_IN);
            }
            ((ImageView) this.mDots.get(i)).setImageDrawable(drawable);
            i += DEFAULT_COLOR;
        }
    }

    public void setSelectedIndicatorColor(int color) {
        this.selectedDotColor = color;
        selectPosition(this.mCurrentPosition);
    }

    public void setUnselectedIndicatorColor(int color) {
        this.unselectedDotColor = color;
        selectPosition(this.mCurrentPosition);
    }
}
