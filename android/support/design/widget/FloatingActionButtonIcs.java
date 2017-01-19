package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.cast.TextTrackStyle;

class FloatingActionButtonIcs extends FloatingActionButtonGingerbread {
    private float mRotation;

    /* renamed from: android.support.design.widget.FloatingActionButtonIcs.1 */
    class C00211 extends AnimatorListenerAdapter {
        private boolean mCancelled;
        final /* synthetic */ boolean val$fromUser;
        final /* synthetic */ InternalVisibilityChangedListener val$listener;

        C00211(boolean z, InternalVisibilityChangedListener internalVisibilityChangedListener) {
            this.val$fromUser = z;
            this.val$listener = internalVisibilityChangedListener;
        }

        public void onAnimationStart(Animator animation) {
            FloatingActionButtonIcs.this.mView.internalSetVisibility(0, this.val$fromUser);
            this.mCancelled = false;
        }

        public void onAnimationCancel(Animator animation) {
            this.mCancelled = true;
        }

        public void onAnimationEnd(Animator animation) {
            FloatingActionButtonIcs.this.mAnimState = 0;
            if (!this.mCancelled) {
                FloatingActionButtonIcs.this.mView.internalSetVisibility(8, this.val$fromUser);
                if (this.val$listener != null) {
                    this.val$listener.onHidden();
                }
            }
        }
    }

    /* renamed from: android.support.design.widget.FloatingActionButtonIcs.2 */
    class C00222 extends AnimatorListenerAdapter {
        final /* synthetic */ boolean val$fromUser;
        final /* synthetic */ InternalVisibilityChangedListener val$listener;

        C00222(boolean z, InternalVisibilityChangedListener internalVisibilityChangedListener) {
            this.val$fromUser = z;
            this.val$listener = internalVisibilityChangedListener;
        }

        public void onAnimationStart(Animator animation) {
            FloatingActionButtonIcs.this.mView.internalSetVisibility(0, this.val$fromUser);
        }

        public void onAnimationEnd(Animator animation) {
            FloatingActionButtonIcs.this.mAnimState = 0;
            if (this.val$listener != null) {
                this.val$listener.onShown();
            }
        }
    }

    FloatingActionButtonIcs(VisibilityAwareImageButton view, ShadowViewDelegate shadowViewDelegate, Creator animatorCreator) {
        super(view, shadowViewDelegate, animatorCreator);
        this.mRotation = this.mView.getRotation();
    }

    boolean requirePreDrawListener() {
        return true;
    }

    void onPreDraw() {
        float rotation = this.mView.getRotation();
        if (this.mRotation != rotation) {
            this.mRotation = rotation;
            updateFromViewRotation();
        }
    }

    void hide(@Nullable InternalVisibilityChangedListener listener, boolean fromUser) {
        if (!isOrWillBeHidden()) {
            this.mView.animate().cancel();
            if (shouldAnimateVisibilityChange()) {
                this.mAnimState = 1;
                this.mView.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR).setListener(new C00211(fromUser, listener));
                return;
            }
            this.mView.internalSetVisibility(8, fromUser);
            if (listener != null) {
                listener.onHidden();
            }
        }
    }

    void show(@Nullable InternalVisibilityChangedListener listener, boolean fromUser) {
        if (!isOrWillBeShown()) {
            this.mView.animate().cancel();
            if (shouldAnimateVisibilityChange()) {
                this.mAnimState = 2;
                if (this.mView.getVisibility() != 0) {
                    this.mView.setAlpha(0.0f);
                    this.mView.setScaleY(0.0f);
                    this.mView.setScaleX(0.0f);
                }
                this.mView.animate().scaleX(TextTrackStyle.DEFAULT_FONT_SCALE).scaleY(TextTrackStyle.DEFAULT_FONT_SCALE).alpha(TextTrackStyle.DEFAULT_FONT_SCALE).setDuration(200).setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR).setListener(new C00222(fromUser, listener));
                return;
            }
            this.mView.internalSetVisibility(0, fromUser);
            this.mView.setAlpha(TextTrackStyle.DEFAULT_FONT_SCALE);
            this.mView.setScaleY(TextTrackStyle.DEFAULT_FONT_SCALE);
            this.mView.setScaleX(TextTrackStyle.DEFAULT_FONT_SCALE);
            if (listener != null) {
                listener.onShown();
            }
        }
    }

    private boolean shouldAnimateVisibilityChange() {
        return ViewCompat.isLaidOut(this.mView) && !this.mView.isInEditMode();
    }

    private void updateFromViewRotation() {
        if (VERSION.SDK_INT == 19) {
            if (this.mRotation % 90.0f != 0.0f) {
                if (this.mView.getLayerType() != 1) {
                    this.mView.setLayerType(1, null);
                }
            } else if (this.mView.getLayerType() != 0) {
                this.mView.setLayerType(0, null);
            }
        }
        if (this.mShadowDrawable != null) {
            this.mShadowDrawable.setRotation(-this.mRotation);
        }
        if (this.mBorderDrawable != null) {
            this.mBorderDrawable.setRotation(-this.mRotation);
        }
    }
}
