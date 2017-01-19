package com.github.paolorotolo.appintro;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.games.stats.PlayerStats;

class FadePageTransformer implements PageTransformer {
    FadePageTransformer() {
    }

    public void transformPage(View view, float position) {
        view.setTranslationX(((float) view.getWidth()) * (-position));
        if (position <= PlayerStats.UNSET_VALUE || position >= TextTrackStyle.DEFAULT_FONT_SCALE) {
            view.setAlpha(0.0f);
            view.setClickable(false);
        } else if (position == 0.0f) {
            view.setAlpha(TextTrackStyle.DEFAULT_FONT_SCALE);
            view.setClickable(true);
        } else {
            view.setAlpha(TextTrackStyle.DEFAULT_FONT_SCALE - Math.abs(position));
        }
    }
}
