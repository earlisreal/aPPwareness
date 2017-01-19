package com.github.paolorotolo.appintro;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.github.paolorotolo.appintro.util.LogHelper;

public abstract class AppIntro extends AppIntroBase {
    private static final String TAG;

    static {
        TAG = LogHelper.makeLogTag(AppIntro.class);
    }

    protected int getLayoutId() {
        return C0394R.layout.intro_layout;
    }

    public void setBarColor(@ColorInt int color) {
        ((LinearLayout) findViewById(C0394R.id.bottom)).setBackgroundColor(color);
    }

    public void setNextArrowColor(@ColorInt int color) {
        ((ImageButton) findViewById(C0394R.id.next)).setColorFilter(color);
    }

    public void setSeparatorColor(@ColorInt int color) {
        ((TextView) findViewById(C0394R.id.bottom_separator)).setBackgroundColor(color);
    }

    public void setSkipText(@Nullable CharSequence text) {
        ((TextView) findViewById(C0394R.id.skip)).setText(text);
    }

    public void setSkipTextTypeface(@Nullable String typeURL) {
        TextView skipText = (TextView) findViewById(C0394R.id.skip);
        if (CustomFontCache.get(typeURL, this) != null) {
            skipText.setTypeface(CustomFontCache.get(typeURL, this));
        }
    }

    public void setDoneText(@Nullable CharSequence text) {
        ((TextView) findViewById(C0394R.id.done)).setText(text);
    }

    public void setDoneTextTypeface(@Nullable String typeURL) {
        TextView doneText = (TextView) findViewById(C0394R.id.done);
        if (CustomFontCache.get(typeURL, this) != null) {
            doneText.setTypeface(CustomFontCache.get(typeURL, this));
        }
    }

    public void setColorDoneText(@ColorInt int colorDoneText) {
        ((TextView) findViewById(C0394R.id.done)).setTextColor(colorDoneText);
    }

    public void setColorSkipButton(@ColorInt int colorSkipButton) {
        ((TextView) findViewById(C0394R.id.skip)).setTextColor(colorSkipButton);
    }

    public void setImageNextButton(Drawable imageNextButton) {
        ((ImageView) findViewById(C0394R.id.next)).setImageDrawable(imageNextButton);
    }

    @Deprecated
    public void showDoneButton(boolean showDone) {
        setProgressButtonEnabled(showDone);
    }
}
