package com.github.paolorotolo.appintro;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

class ViewPageTransformer implements PageTransformer {
    private static final float MIN_ALPHA_SLIDE = 0.35f;
    private static final float MIN_ALPHA_ZOOM = 0.5f;
    private static final float MIN_SCALE_DEPTH = 0.75f;
    private static final float MIN_SCALE_ZOOM = 0.85f;
    private static final float SCALE_FACTOR_SLIDE = 0.85f;
    private final TransformType mTransformType;

    /* renamed from: com.github.paolorotolo.appintro.ViewPageTransformer.1 */
    static /* synthetic */ class C03951 {
        static final /* synthetic */ int[] f14xf296bc34;

        static {
            f14xf296bc34 = new int[TransformType.values().length];
            try {
                f14xf296bc34[TransformType.FLOW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14xf296bc34[TransformType.SLIDE_OVER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14xf296bc34[TransformType.DEPTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f14xf296bc34[TransformType.ZOOM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f14xf296bc34[TransformType.FADE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    enum TransformType {
        FLOW,
        DEPTH,
        ZOOM,
        SLIDE_OVER,
        FADE
    }

    ViewPageTransformer(TransformType transformType) {
        this.mTransformType = transformType;
    }

    @SuppressLint({"NewApi"})
    public void transformPage(View page, float position) {
        float scale;
        float alpha;
        float translationX;
        switch (C03951.f14xf296bc34[this.mTransformType.ordinal()]) {
            case MessageApi.FILTER_PREFIX /*1*/:
                page.setRotationY(-30.0f * position);
                return;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                if (position < 0.0f && position > PlayerStats.UNSET_VALUE) {
                    scale = (Math.abs(Math.abs(position) - TextTrackStyle.DEFAULT_FONT_SCALE) * 0.14999998f) + SCALE_FACTOR_SLIDE;
                    alpha = Math.max(MIN_ALPHA_SLIDE, TextTrackStyle.DEFAULT_FONT_SCALE - Math.abs(position));
                    int pageWidth = page.getWidth();
                    float translateValue = position * ((float) (-pageWidth));
                    if (translateValue <= ((float) (-pageWidth))) {
                        translationX = 0.0f;
                        break;
                    } else {
                        translationX = translateValue;
                        break;
                    }
                }
                alpha = TextTrackStyle.DEFAULT_FONT_SCALE;
                scale = TextTrackStyle.DEFAULT_FONT_SCALE;
                translationX = 0.0f;
                break;
                break;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                if (position > 0.0f && position < TextTrackStyle.DEFAULT_FONT_SCALE) {
                    alpha = TextTrackStyle.DEFAULT_FONT_SCALE - position;
                    scale = MIN_SCALE_DEPTH + (0.25f * (TextTrackStyle.DEFAULT_FONT_SCALE - Math.abs(position)));
                    translationX = ((float) page.getWidth()) * (-position);
                    break;
                }
                alpha = TextTrackStyle.DEFAULT_FONT_SCALE;
                scale = TextTrackStyle.DEFAULT_FONT_SCALE;
                translationX = 0.0f;
                break;
                break;
            case Dimension.UNIT_IN /*4*/:
                if (position >= PlayerStats.UNSET_VALUE && position <= TextTrackStyle.DEFAULT_FONT_SCALE) {
                    scale = Math.max(SCALE_FACTOR_SLIDE, TextTrackStyle.DEFAULT_FONT_SCALE - Math.abs(position));
                    alpha = MIN_ALPHA_ZOOM + (((scale - SCALE_FACTOR_SLIDE) / 0.14999998f) * MIN_ALPHA_ZOOM);
                    float vMargin = (((float) page.getHeight()) * (TextTrackStyle.DEFAULT_FONT_SCALE - scale)) / 2.0f;
                    float hMargin = (((float) page.getWidth()) * (TextTrackStyle.DEFAULT_FONT_SCALE - scale)) / 2.0f;
                    if (position >= 0.0f) {
                        translationX = (-hMargin) + (vMargin / 2.0f);
                        break;
                    } else {
                        translationX = hMargin - (vMargin / 2.0f);
                        break;
                    }
                }
                alpha = TextTrackStyle.DEFAULT_FONT_SCALE;
                scale = TextTrackStyle.DEFAULT_FONT_SCALE;
                translationX = 0.0f;
                break;
                break;
            case Dimension.UNIT_MM /*5*/:
                if (position <= PlayerStats.UNSET_VALUE || position >= TextTrackStyle.DEFAULT_FONT_SCALE) {
                    page.setAlpha(0.0f);
                    page.setClickable(false);
                    return;
                } else if (position == 0.0f) {
                    page.setAlpha(TextTrackStyle.DEFAULT_FONT_SCALE);
                    page.setClickable(true);
                    return;
                } else {
                    page.setAlpha(TextTrackStyle.DEFAULT_FONT_SCALE - Math.abs(position));
                    return;
                }
            default:
                return;
        }
        page.setAlpha(alpha);
        page.setTranslationX(translationX);
        page.setScaleX(scale);
        page.setScaleY(scale);
    }
}
