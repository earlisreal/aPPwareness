package android.support.v7.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.widget.ListView;
import com.google.android.gms.cast.TextTrackStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class OverlayListView extends ListView {
    private final List<OverlayObject> mOverlayObjects;

    public static class OverlayObject {
        private BitmapDrawable mBitmap;
        private float mCurrentAlpha;
        private Rect mCurrentBounds;
        private int mDeltaY;
        private long mDuration;
        private float mEndAlpha;
        private Interpolator mInterpolator;
        private boolean mIsAnimationEnded;
        private boolean mIsAnimationStarted;
        private OnAnimationEndListener mListener;
        private float mStartAlpha;
        private Rect mStartRect;
        private long mStartTime;

        public interface OnAnimationEndListener {
            void onAnimationEnd();
        }

        public OverlayObject(BitmapDrawable bitmap, Rect startRect) {
            this.mCurrentAlpha = TextTrackStyle.DEFAULT_FONT_SCALE;
            this.mStartAlpha = TextTrackStyle.DEFAULT_FONT_SCALE;
            this.mEndAlpha = TextTrackStyle.DEFAULT_FONT_SCALE;
            this.mBitmap = bitmap;
            this.mStartRect = startRect;
            this.mCurrentBounds = new Rect(startRect);
            if (this.mBitmap != null && this.mCurrentBounds != null) {
                this.mBitmap.setAlpha((int) (this.mCurrentAlpha * 255.0f));
                this.mBitmap.setBounds(this.mCurrentBounds);
            }
        }

        public BitmapDrawable getBitmapDrawable() {
            return this.mBitmap;
        }

        public boolean isAnimationStarted() {
            return this.mIsAnimationStarted;
        }

        public OverlayObject setAlphaAnimation(float startAlpha, float endAlpha) {
            this.mStartAlpha = startAlpha;
            this.mEndAlpha = endAlpha;
            return this;
        }

        public OverlayObject setTranslateYAnimation(int deltaY) {
            this.mDeltaY = deltaY;
            return this;
        }

        public OverlayObject setDuration(long duration) {
            this.mDuration = duration;
            return this;
        }

        public OverlayObject setInterpolator(Interpolator interpolator) {
            this.mInterpolator = interpolator;
            return this;
        }

        public OverlayObject setAnimationEndListener(OnAnimationEndListener listener) {
            this.mListener = listener;
            return this;
        }

        public void startAnimation(long startTime) {
            this.mStartTime = startTime;
            this.mIsAnimationStarted = true;
        }

        public void stopAnimation() {
            this.mIsAnimationStarted = true;
            this.mIsAnimationEnded = true;
            if (this.mListener != null) {
                this.mListener.onAnimationEnd();
            }
        }

        public boolean update(long currentTime) {
            boolean z = true;
            if (this.mIsAnimationEnded) {
                return false;
            }
            float interpolatedTime;
            float normalizedTime = Math.max(0.0f, Math.min(TextTrackStyle.DEFAULT_FONT_SCALE, ((float) (currentTime - this.mStartTime)) / ((float) this.mDuration)));
            if (!this.mIsAnimationStarted) {
                normalizedTime = 0.0f;
            }
            if (this.mInterpolator == null) {
                interpolatedTime = normalizedTime;
            } else {
                interpolatedTime = this.mInterpolator.getInterpolation(normalizedTime);
            }
            int deltaY = (int) (((float) this.mDeltaY) * interpolatedTime);
            this.mCurrentBounds.top = this.mStartRect.top + deltaY;
            this.mCurrentBounds.bottom = this.mStartRect.bottom + deltaY;
            this.mCurrentAlpha = this.mStartAlpha + ((this.mEndAlpha - this.mStartAlpha) * interpolatedTime);
            if (!(this.mBitmap == null || this.mCurrentBounds == null)) {
                this.mBitmap.setAlpha((int) (this.mCurrentAlpha * 255.0f));
                this.mBitmap.setBounds(this.mCurrentBounds);
            }
            if (this.mIsAnimationStarted && normalizedTime >= TextTrackStyle.DEFAULT_FONT_SCALE) {
                this.mIsAnimationEnded = true;
                if (this.mListener != null) {
                    this.mListener.onAnimationEnd();
                }
            }
            if (this.mIsAnimationEnded) {
                z = false;
            }
            return z;
        }
    }

    public OverlayListView(Context context) {
        super(context);
        this.mOverlayObjects = new ArrayList();
    }

    public OverlayListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mOverlayObjects = new ArrayList();
    }

    public OverlayListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mOverlayObjects = new ArrayList();
    }

    public void addOverlayObject(OverlayObject object) {
        this.mOverlayObjects.add(object);
    }

    public void startAnimationAll() {
        for (OverlayObject object : this.mOverlayObjects) {
            if (!object.isAnimationStarted()) {
                object.startAnimation(getDrawingTime());
            }
        }
    }

    public void stopAnimationAll() {
        for (OverlayObject object : this.mOverlayObjects) {
            object.stopAnimation();
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mOverlayObjects.size() > 0) {
            Iterator<OverlayObject> it = this.mOverlayObjects.iterator();
            while (it.hasNext()) {
                OverlayObject object = (OverlayObject) it.next();
                BitmapDrawable bitmap = object.getBitmapDrawable();
                if (bitmap != null) {
                    bitmap.draw(canvas);
                }
                if (!object.update(getDrawingTime())) {
                    it.remove();
                }
            }
        }
    }
}
