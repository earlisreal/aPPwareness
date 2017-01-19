package com.github.paolorotolo.appintro;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ProgressBar;

public class ProgressIndicatorController implements IndicatorController {
    public static final int DEFAULT_COLOR = 1;
    private static final int FIRST_PAGE_NUM = 0;
    private ProgressBar mProgressBar;
    int selectedDotColor;
    int unselectedDotColor;

    public ProgressIndicatorController() {
        this.selectedDotColor = DEFAULT_COLOR;
        this.unselectedDotColor = DEFAULT_COLOR;
    }

    public View newInstance(@NonNull Context context) {
        this.mProgressBar = (ProgressBar) View.inflate(context, C0394R.layout.progress_indicator, null);
        if (this.selectedDotColor != DEFAULT_COLOR) {
            this.mProgressBar.getProgressDrawable().setColorFilter(this.selectedDotColor, Mode.SRC_IN);
        }
        if (this.unselectedDotColor != DEFAULT_COLOR) {
            this.mProgressBar.getIndeterminateDrawable().setColorFilter(this.unselectedDotColor, Mode.SRC_IN);
        }
        return this.mProgressBar;
    }

    public void initialize(int slideCount) {
        this.mProgressBar.setMax(slideCount);
        selectPosition(0);
    }

    public void selectPosition(int index) {
        this.mProgressBar.setProgress(index + DEFAULT_COLOR);
    }

    public void setSelectedIndicatorColor(int color) {
        this.selectedDotColor = color;
        if (this.mProgressBar != null) {
            this.mProgressBar.getProgressDrawable().setColorFilter(color, Mode.SRC_IN);
        }
    }

    public void setUnselectedIndicatorColor(int color) {
        this.unselectedDotColor = color;
        if (this.mProgressBar != null) {
            this.mProgressBar.getIndeterminateDrawable().setColorFilter(color, Mode.SRC_IN);
        }
    }
}
