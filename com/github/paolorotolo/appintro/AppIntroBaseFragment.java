package com.github.paolorotolo.appintro;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.paolorotolo.appintro.util.LogHelper;

public abstract class AppIntroBaseFragment extends Fragment implements ISlideSelectionListener, ISlideBackgroundColorHolder {
    protected static final String ARG_BG_COLOR = "bg_color";
    protected static final String ARG_DESC = "desc";
    protected static final String ARG_DESC_COLOR = "desc_color";
    protected static final String ARG_DESC_TYPEFACE = "desc_typeface";
    protected static final String ARG_DRAWABLE = "drawable";
    protected static final String ARG_TITLE = "title";
    protected static final String ARG_TITLE_COLOR = "title_color";
    protected static final String ARG_TITLE_TYPEFACE = "title_typeface";
    private static final String TAG;
    private int bgColor;
    private int descColor;
    private String descTypeface;
    private String description;
    private int drawable;
    private int layoutId;
    private LinearLayout mainLayout;
    private String title;
    private int titleColor;
    private String titleTypeface;

    @LayoutRes
    protected abstract int getLayoutId();

    static {
        TAG = LogHelper.makeLogTag(AppIntroBaseFragment.class);
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        int i = 0;
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if (getArguments() != null && getArguments().size() != 0) {
            int i2;
            this.drawable = getArguments().getInt(ARG_DRAWABLE);
            this.title = getArguments().getString(ARG_TITLE);
            this.titleTypeface = getArguments().containsKey(ARG_TITLE_TYPEFACE) ? getArguments().getString(ARG_TITLE_TYPEFACE) : BuildConfig.FLAVOR;
            this.description = getArguments().getString(ARG_DESC);
            this.descTypeface = getArguments().containsKey(ARG_DESC_TYPEFACE) ? getArguments().getString(ARG_DESC_TYPEFACE) : BuildConfig.FLAVOR;
            this.bgColor = getArguments().getInt(ARG_BG_COLOR);
            if (getArguments().containsKey(ARG_TITLE_COLOR)) {
                i2 = getArguments().getInt(ARG_TITLE_COLOR);
            } else {
                i2 = 0;
            }
            this.titleColor = i2;
            if (getArguments().containsKey(ARG_DESC_COLOR)) {
                i = getArguments().getInt(ARG_DESC_COLOR);
            }
            this.descColor = i;
        }
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            this.drawable = savedInstanceState.getInt(ARG_DRAWABLE);
            this.title = savedInstanceState.getString(ARG_TITLE);
            this.titleTypeface = savedInstanceState.getString(ARG_TITLE_TYPEFACE);
            this.description = savedInstanceState.getString(ARG_DESC);
            this.descTypeface = savedInstanceState.getString(ARG_DESC_TYPEFACE);
            this.bgColor = savedInstanceState.getInt(ARG_BG_COLOR);
            this.titleColor = savedInstanceState.getInt(ARG_TITLE_COLOR);
            this.descColor = savedInstanceState.getInt(ARG_DESC_COLOR);
        }
    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(getLayoutId(), container, false);
        TextView t = (TextView) v.findViewById(C0394R.id.title);
        TextView d = (TextView) v.findViewById(C0394R.id.description);
        ImageView i = (ImageView) v.findViewById(C0394R.id.image);
        this.mainLayout = (LinearLayout) v.findViewById(C0394R.id.main);
        t.setText(this.title);
        if (this.titleColor != 0) {
            t.setTextColor(this.titleColor);
        }
        if (!(this.titleTypeface == null || !this.titleTypeface.equals(BuildConfig.FLAVOR) || CustomFontCache.get(this.titleTypeface, getContext()) == null)) {
            t.setTypeface(CustomFontCache.get(this.titleTypeface, getContext()));
        }
        d.setText(this.description);
        if (this.descColor != 0) {
            d.setTextColor(this.descColor);
        }
        if (!(this.descTypeface == null || !this.descTypeface.equals(BuildConfig.FLAVOR) || CustomFontCache.get(this.descTypeface, getContext()) == null)) {
            d.setTypeface(CustomFontCache.get(this.descTypeface, getContext()));
        }
        i.setImageResource(this.drawable);
        this.mainLayout.setBackgroundColor(this.bgColor);
        return v;
    }

    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(ARG_DRAWABLE, this.drawable);
        outState.putString(ARG_TITLE, this.title);
        outState.putString(ARG_DESC, this.description);
        outState.putInt(ARG_BG_COLOR, this.bgColor);
        outState.putInt(ARG_TITLE_COLOR, this.titleColor);
        outState.putInt(ARG_DESC_COLOR, this.descColor);
        super.onSaveInstanceState(outState);
    }

    public void onSlideDeselected() {
        String str = TAG;
        Object[] objArr = new Object[1];
        objArr[0] = String.format("Slide %s has been deselected.", new Object[]{this.title});
        LogHelper.m15d(str, objArr);
    }

    public void onSlideSelected() {
        String str = TAG;
        Object[] objArr = new Object[1];
        objArr[0] = String.format("Slide %s has been selected.", new Object[]{this.title});
        LogHelper.m15d(str, objArr);
    }

    public int getDefaultBackgroundColor() {
        return this.bgColor;
    }

    public void setBackgroundColor(@ColorInt int backgroundColor) {
        this.mainLayout.setBackgroundColor(backgroundColor);
    }
}
