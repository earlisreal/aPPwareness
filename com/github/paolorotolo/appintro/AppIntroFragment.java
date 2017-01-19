package com.github.paolorotolo.appintro;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import com.google.android.gms.plus.PlusShare;

public final class AppIntroFragment extends AppIntroBaseFragment {
    public static AppIntroFragment newInstance(CharSequence title, CharSequence description, @DrawableRes int imageDrawable, @ColorInt int bgColor) {
        return newInstance(title, description, imageDrawable, bgColor, 0, 0);
    }

    public static AppIntroFragment newInstance(CharSequence title, CharSequence description, @DrawableRes int imageDrawable, @ColorInt int bgColor, @ColorInt int titleColor, @ColorInt int descColor) {
        AppIntroFragment slide = new AppIntroFragment();
        Bundle args = new Bundle();
        args.putString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, title.toString());
        args.putString("title_typeface", null);
        args.putString("desc", description.toString());
        args.putString("desc_typeface", null);
        args.putInt("drawable", imageDrawable);
        args.putInt("bg_color", bgColor);
        args.putInt("title_color", titleColor);
        args.putInt("desc_color", descColor);
        slide.setArguments(args);
        return slide;
    }

    public static AppIntroFragment newInstance(CharSequence title, String titleTypeface, CharSequence description, String descTypeface, @DrawableRes int imageDrawable, @ColorInt int bgColor) {
        return newInstance(title, titleTypeface, description, descTypeface, imageDrawable, bgColor, 0, 0);
    }

    public static AppIntroFragment newInstance(CharSequence title, String titleTypeface, CharSequence description, String descTypeface, @DrawableRes int imageDrawable, @ColorInt int bgColor, @ColorInt int titleColor, @ColorInt int descColor) {
        AppIntroFragment slide = new AppIntroFragment();
        Bundle args = new Bundle();
        args.putString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, title.toString());
        args.putString("title_typeface", titleTypeface);
        args.putString("desc", description.toString());
        args.putString("desc_typeface", descTypeface);
        args.putInt("drawable", imageDrawable);
        args.putInt("bg_color", bgColor);
        args.putInt("title_color", titleColor);
        args.putInt("desc_color", descColor);
        slide.setArguments(args);
        return slide;
    }

    protected int getLayoutId() {
        return C0394R.layout.fragment_intro;
    }
}
