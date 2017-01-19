package com.github.paolorotolo.appintro;

import android.support.annotation.ColorInt;

public interface ISlideBackgroundColorHolder {
    @ColorInt
    int getDefaultBackgroundColor();

    void setBackgroundColor(@ColorInt int i);
}
