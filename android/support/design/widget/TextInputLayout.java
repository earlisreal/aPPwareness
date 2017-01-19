package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.annotation.VisibleForTesting;
import android.support.design.C0000R;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.Space;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.appcompat.C0236R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.TintTypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.cast.TextTrackStyle;

public class TextInputLayout extends LinearLayout {
    private static final int ANIMATION_DURATION = 200;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final String LOG_TAG = "TextInputLayout";
    private ValueAnimatorCompat mAnimator;
    final CollapsingTextHelper mCollapsingTextHelper;
    boolean mCounterEnabled;
    private int mCounterMaxLength;
    private int mCounterOverflowTextAppearance;
    private boolean mCounterOverflowed;
    private int mCounterTextAppearance;
    private TextView mCounterView;
    private ColorStateList mDefaultTextColor;
    EditText mEditText;
    private CharSequence mError;
    private boolean mErrorEnabled;
    private boolean mErrorShown;
    private int mErrorTextAppearance;
    TextView mErrorView;
    private ColorStateList mFocusedTextColor;
    private boolean mHasPasswordToggleTintList;
    private boolean mHasPasswordToggleTintMode;
    private boolean mHasReconstructedEditTextBackground;
    private CharSequence mHint;
    private boolean mHintAnimationEnabled;
    private boolean mHintEnabled;
    private boolean mHintExpanded;
    private boolean mInDrawableStateChanged;
    private LinearLayout mIndicatorArea;
    private int mIndicatorsAdded;
    private final FrameLayout mInputFrame;
    private Drawable mOriginalEditTextEndDrawable;
    private CharSequence mPasswordToggleContentDesc;
    private Drawable mPasswordToggleDrawable;
    private Drawable mPasswordToggleDummyDrawable;
    private boolean mPasswordToggleEnabled;
    private ColorStateList mPasswordToggleTintList;
    private Mode mPasswordToggleTintMode;
    private CheckableImageButton mPasswordToggleView;
    private boolean mPasswordToggledVisible;
    private Paint mTmpPaint;
    private final Rect mTmpRect;

    /* renamed from: android.support.design.widget.TextInputLayout.1 */
    class C00431 implements TextWatcher {
        C00431() {
        }

        public void afterTextChanged(Editable s) {
            TextInputLayout.this.updateLabelState(true);
            if (TextInputLayout.this.mCounterEnabled) {
                TextInputLayout.this.updateCounter(s.length());
            }
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout.2 */
    class C00442 extends ViewPropertyAnimatorListenerAdapter {
        C00442() {
        }

        public void onAnimationStart(View view) {
            view.setVisibility(0);
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout.3 */
    class C00453 extends ViewPropertyAnimatorListenerAdapter {
        final /* synthetic */ CharSequence val$error;

        C00453(CharSequence charSequence) {
            this.val$error = charSequence;
        }

        public void onAnimationEnd(View view) {
            TextInputLayout.this.mErrorView.setText(this.val$error);
            view.setVisibility(4);
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout.4 */
    class C00464 implements OnClickListener {
        C00464() {
        }

        public void onClick(View view) {
            TextInputLayout.this.passwordVisibilityToggleRequested();
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout.5 */
    class C00475 implements AnimatorUpdateListener {
        C00475() {
        }

        public void onAnimationUpdate(ValueAnimatorCompat animator) {
            TextInputLayout.this.mCollapsingTextHelper.setExpansionFraction(animator.getAnimatedFloatValue());
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR;
        CharSequence error;

        /* renamed from: android.support.design.widget.TextInputLayout.SavedState.1 */
        static class C00481 implements ParcelableCompatCreatorCallbacks<SavedState> {
            C00481() {
            }

            public SavedState createFromParcel(Parcel in, ClassLoader loader) {
                return new SavedState(in, loader);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        }

        SavedState(Parcelable superState) {
            super(superState);
        }

        public SavedState(Parcel source, ClassLoader loader) {
            super(source, loader);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        }

        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            TextUtils.writeToParcel(this.error, dest, flags);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + "}";
        }

        static {
            CREATOR = ParcelableCompat.newCreator(new C00481());
        }
    }

    private class TextInputAccessibilityDelegate extends AccessibilityDelegateCompat {
        TextInputAccessibilityDelegate() {
        }

        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            super.onInitializeAccessibilityEvent(host, event);
            event.setClassName(TextInputLayout.class.getSimpleName());
        }

        public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            super.onPopulateAccessibilityEvent(host, event);
            CharSequence text = TextInputLayout.this.mCollapsingTextHelper.getText();
            if (!TextUtils.isEmpty(text)) {
                event.getText().add(text);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setClassName(TextInputLayout.class.getSimpleName());
            CharSequence text = TextInputLayout.this.mCollapsingTextHelper.getText();
            if (!TextUtils.isEmpty(text)) {
                info.setText(text);
            }
            if (TextInputLayout.this.mEditText != null) {
                info.setLabelFor(TextInputLayout.this.mEditText);
            }
            CharSequence error = TextInputLayout.this.mErrorView != null ? TextInputLayout.this.mErrorView.getText() : null;
            if (!TextUtils.isEmpty(error)) {
                info.setContentInvalid(true);
                info.setError(error);
            }
        }
    }

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextInputLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        boolean z;
        super(context, attrs);
        this.mTmpRect = new Rect();
        this.mCollapsingTextHelper = new CollapsingTextHelper(this);
        ThemeUtils.checkAppCompatTheme(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.mInputFrame = new FrameLayout(context);
        this.mInputFrame.setAddStatesFromChildren(true);
        addView(this.mInputFrame);
        this.mCollapsingTextHelper.setTextSizeInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.mCollapsingTextHelper.setPositionInterpolator(new AccelerateInterpolator());
        this.mCollapsingTextHelper.setCollapsedTextGravity(8388659);
        if (this.mCollapsingTextHelper.getExpansionFraction() == TextTrackStyle.DEFAULT_FONT_SCALE) {
            z = true;
        } else {
            z = false;
        }
        this.mHintExpanded = z;
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs, C0000R.styleable.TextInputLayout, defStyleAttr, C0000R.style.Widget_Design_TextInputLayout);
        this.mHintEnabled = a.getBoolean(C0000R.styleable.TextInputLayout_hintEnabled, true);
        setHint(a.getText(C0000R.styleable.TextInputLayout_android_hint));
        this.mHintAnimationEnabled = a.getBoolean(C0000R.styleable.TextInputLayout_hintAnimationEnabled, true);
        if (a.hasValue(C0000R.styleable.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateList = a.getColorStateList(C0000R.styleable.TextInputLayout_android_textColorHint);
            this.mFocusedTextColor = colorStateList;
            this.mDefaultTextColor = colorStateList;
        }
        if (a.getResourceId(C0000R.styleable.TextInputLayout_hintTextAppearance, INVALID_MAX_LENGTH) != INVALID_MAX_LENGTH) {
            setHintTextAppearance(a.getResourceId(C0000R.styleable.TextInputLayout_hintTextAppearance, 0));
        }
        this.mErrorTextAppearance = a.getResourceId(C0000R.styleable.TextInputLayout_errorTextAppearance, 0);
        boolean errorEnabled = a.getBoolean(C0000R.styleable.TextInputLayout_errorEnabled, false);
        boolean counterEnabled = a.getBoolean(C0000R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(a.getInt(C0000R.styleable.TextInputLayout_counterMaxLength, INVALID_MAX_LENGTH));
        this.mCounterTextAppearance = a.getResourceId(C0000R.styleable.TextInputLayout_counterTextAppearance, 0);
        this.mCounterOverflowTextAppearance = a.getResourceId(C0000R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        this.mPasswordToggleEnabled = a.getBoolean(C0000R.styleable.TextInputLayout_passwordToggleEnabled, true);
        this.mPasswordToggleDrawable = a.getDrawable(C0000R.styleable.TextInputLayout_passwordToggleDrawable);
        this.mPasswordToggleContentDesc = a.getText(C0000R.styleable.TextInputLayout_passwordToggleContentDescription);
        if (a.hasValue(C0000R.styleable.TextInputLayout_passwordToggleTint)) {
            this.mHasPasswordToggleTintList = true;
            this.mPasswordToggleTintList = a.getColorStateList(C0000R.styleable.TextInputLayout_passwordToggleTint);
        }
        if (a.hasValue(C0000R.styleable.TextInputLayout_passwordToggleTintMode)) {
            this.mHasPasswordToggleTintMode = true;
            this.mPasswordToggleTintMode = ViewUtils.parseTintMode(a.getInt(C0000R.styleable.TextInputLayout_passwordToggleTintMode, INVALID_MAX_LENGTH), null);
        }
        a.recycle();
        setErrorEnabled(errorEnabled);
        setCounterEnabled(counterEnabled);
        applyPasswordToggleTint();
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setAccessibilityDelegate(this, new TextInputAccessibilityDelegate());
    }

    public void addView(View child, int index, LayoutParams params) {
        if (child instanceof EditText) {
            this.mInputFrame.addView(child, new FrameLayout.LayoutParams(params));
            this.mInputFrame.setLayoutParams(params);
            updateInputLayoutMargins();
            setEditText((EditText) child);
            return;
        }
        super.addView(child, index, params);
    }

    public void setTypeface(@Nullable Typeface typeface) {
        this.mCollapsingTextHelper.setTypefaces(typeface);
    }

    @NonNull
    public Typeface getTypeface() {
        return this.mCollapsingTextHelper.getCollapsedTypeface();
    }

    private void setEditText(EditText editText) {
        if (this.mEditText != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (!(editText instanceof TextInputEditText)) {
            Log.i(LOG_TAG, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.mEditText = editText;
        if (!hasPasswordTransformation()) {
            this.mCollapsingTextHelper.setTypefaces(this.mEditText.getTypeface());
        }
        this.mCollapsingTextHelper.setExpandedTextSize(this.mEditText.getTextSize());
        int editTextGravity = this.mEditText.getGravity();
        this.mCollapsingTextHelper.setCollapsedTextGravity((GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK & editTextGravity) | 48);
        this.mCollapsingTextHelper.setExpandedTextGravity(editTextGravity);
        this.mEditText.addTextChangedListener(new C00431());
        if (this.mDefaultTextColor == null) {
            this.mDefaultTextColor = this.mEditText.getHintTextColors();
        }
        if (this.mHintEnabled && TextUtils.isEmpty(this.mHint)) {
            setHint(this.mEditText.getHint());
            this.mEditText.setHint(null);
        }
        if (this.mCounterView != null) {
            updateCounter(this.mEditText.getText().length());
        }
        if (this.mIndicatorArea != null) {
            adjustIndicatorPadding();
        }
        updatePasswordToggleView();
        updateLabelState(false);
    }

    private void updateInputLayoutMargins() {
        int newTopMargin;
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) this.mInputFrame.getLayoutParams();
        if (this.mHintEnabled) {
            if (this.mTmpPaint == null) {
                this.mTmpPaint = new Paint();
            }
            this.mTmpPaint.setTypeface(this.mCollapsingTextHelper.getCollapsedTypeface());
            this.mTmpPaint.setTextSize(this.mCollapsingTextHelper.getCollapsedTextSize());
            newTopMargin = (int) (-this.mTmpPaint.ascent());
        } else {
            newTopMargin = 0;
        }
        if (newTopMargin != lp.topMargin) {
            lp.topMargin = newTopMargin;
            this.mInputFrame.requestLayout();
        }
    }

    void updateLabelState(boolean animate) {
        boolean hasText;
        boolean isEnabled = isEnabled();
        if (this.mEditText == null || TextUtils.isEmpty(this.mEditText.getText())) {
            hasText = false;
        } else {
            hasText = true;
        }
        boolean isFocused = arrayContains(getDrawableState(), 16842908);
        boolean isErrorShowing;
        if (TextUtils.isEmpty(getError())) {
            isErrorShowing = false;
        } else {
            isErrorShowing = true;
        }
        if (this.mDefaultTextColor != null) {
            this.mCollapsingTextHelper.setExpandedTextColor(this.mDefaultTextColor);
        }
        if (isEnabled && this.mCounterOverflowed && this.mCounterView != null) {
            this.mCollapsingTextHelper.setCollapsedTextColor(this.mCounterView.getTextColors());
        } else if (isEnabled && isFocused && this.mFocusedTextColor != null) {
            this.mCollapsingTextHelper.setCollapsedTextColor(this.mFocusedTextColor);
        } else if (this.mDefaultTextColor != null) {
            this.mCollapsingTextHelper.setCollapsedTextColor(this.mDefaultTextColor);
        }
        if (hasText || (isEnabled() && (isFocused || isErrorShowing))) {
            collapseHint(animate);
        } else {
            expandHint(animate);
        }
    }

    @Nullable
    public EditText getEditText() {
        return this.mEditText;
    }

    public void setHint(@Nullable CharSequence hint) {
        if (this.mHintEnabled) {
            setHintInternal(hint);
            sendAccessibilityEvent(ItemAnimator.FLAG_MOVED);
        }
    }

    private void setHintInternal(CharSequence hint) {
        this.mHint = hint;
        this.mCollapsingTextHelper.setText(hint);
    }

    @Nullable
    public CharSequence getHint() {
        return this.mHintEnabled ? this.mHint : null;
    }

    public void setHintEnabled(boolean enabled) {
        if (enabled != this.mHintEnabled) {
            this.mHintEnabled = enabled;
            CharSequence editTextHint = this.mEditText.getHint();
            if (!this.mHintEnabled) {
                if (!TextUtils.isEmpty(this.mHint) && TextUtils.isEmpty(editTextHint)) {
                    this.mEditText.setHint(this.mHint);
                }
                setHintInternal(null);
            } else if (!TextUtils.isEmpty(editTextHint)) {
                if (TextUtils.isEmpty(this.mHint)) {
                    setHint(editTextHint);
                }
                this.mEditText.setHint(null);
            }
            if (this.mEditText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public boolean isHintEnabled() {
        return this.mHintEnabled;
    }

    public void setHintTextAppearance(@StyleRes int resId) {
        this.mCollapsingTextHelper.setCollapsedTextAppearance(resId);
        this.mFocusedTextColor = this.mCollapsingTextHelper.getCollapsedTextColor();
        if (this.mEditText != null) {
            updateLabelState(false);
            updateInputLayoutMargins();
        }
    }

    private void addIndicator(TextView indicator, int index) {
        if (this.mIndicatorArea == null) {
            this.mIndicatorArea = new LinearLayout(getContext());
            this.mIndicatorArea.setOrientation(0);
            addView(this.mIndicatorArea, INVALID_MAX_LENGTH, -2);
            this.mIndicatorArea.addView(new Space(getContext()), new LinearLayout.LayoutParams(0, 0, TextTrackStyle.DEFAULT_FONT_SCALE));
            if (this.mEditText != null) {
                adjustIndicatorPadding();
            }
        }
        this.mIndicatorArea.setVisibility(0);
        this.mIndicatorArea.addView(indicator, index);
        this.mIndicatorsAdded++;
    }

    private void adjustIndicatorPadding() {
        ViewCompat.setPaddingRelative(this.mIndicatorArea, ViewCompat.getPaddingStart(this.mEditText), 0, ViewCompat.getPaddingEnd(this.mEditText), this.mEditText.getPaddingBottom());
    }

    private void removeIndicator(TextView indicator) {
        if (this.mIndicatorArea != null) {
            this.mIndicatorArea.removeView(indicator);
            int i = this.mIndicatorsAdded + INVALID_MAX_LENGTH;
            this.mIndicatorsAdded = i;
            if (i == 0) {
                this.mIndicatorArea.setVisibility(8);
            }
        }
    }

    public void setErrorEnabled(boolean enabled) {
        if (this.mErrorEnabled != enabled) {
            if (this.mErrorView != null) {
                ViewCompat.animate(this.mErrorView).cancel();
            }
            if (enabled) {
                this.mErrorView = new TextView(getContext());
                boolean useDefaultColor = false;
                try {
                    this.mErrorView.setTextAppearance(getContext(), this.mErrorTextAppearance);
                    if (VERSION.SDK_INT >= 23 && this.mErrorView.getTextColors().getDefaultColor() == -65281) {
                        useDefaultColor = true;
                    }
                } catch (Exception e) {
                    useDefaultColor = true;
                }
                if (useDefaultColor) {
                    this.mErrorView.setTextAppearance(getContext(), C0236R.style.TextAppearance_AppCompat_Caption);
                    this.mErrorView.setTextColor(ContextCompat.getColor(getContext(), C0000R.color.design_textinput_error_color_light));
                }
                this.mErrorView.setVisibility(4);
                ViewCompat.setAccessibilityLiveRegion(this.mErrorView, 1);
                addIndicator(this.mErrorView, 0);
            } else {
                this.mErrorShown = false;
                updateEditTextBackground();
                removeIndicator(this.mErrorView);
                this.mErrorView = null;
            }
            this.mErrorEnabled = enabled;
        }
    }

    public boolean isErrorEnabled() {
        return this.mErrorEnabled;
    }

    public void setError(@Nullable CharSequence error) {
        boolean z = ViewCompat.isLaidOut(this) && isEnabled() && (this.mErrorView == null || !TextUtils.equals(this.mErrorView.getText(), error));
        setError(error, z);
    }

    private void setError(@Nullable CharSequence error, boolean animate) {
        boolean z = true;
        this.mError = error;
        if (!this.mErrorEnabled) {
            if (!TextUtils.isEmpty(error)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (TextUtils.isEmpty(error)) {
            z = false;
        }
        this.mErrorShown = z;
        ViewCompat.animate(this.mErrorView).cancel();
        if (this.mErrorShown) {
            this.mErrorView.setText(error);
            this.mErrorView.setVisibility(0);
            if (animate) {
                if (ViewCompat.getAlpha(this.mErrorView) == TextTrackStyle.DEFAULT_FONT_SCALE) {
                    ViewCompat.setAlpha(this.mErrorView, 0.0f);
                }
                ViewCompat.animate(this.mErrorView).alpha(TextTrackStyle.DEFAULT_FONT_SCALE).setDuration(200).setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR).setListener(new C00442()).start();
            } else {
                ViewCompat.setAlpha(this.mErrorView, TextTrackStyle.DEFAULT_FONT_SCALE);
            }
        } else if (this.mErrorView.getVisibility() == 0) {
            if (animate) {
                ViewCompat.animate(this.mErrorView).alpha(0.0f).setDuration(200).setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR).setListener(new C00453(error)).start();
            } else {
                this.mErrorView.setText(error);
                this.mErrorView.setVisibility(4);
            }
        }
        updateEditTextBackground();
        updateLabelState(animate);
    }

    public void setCounterEnabled(boolean enabled) {
        if (this.mCounterEnabled != enabled) {
            if (enabled) {
                this.mCounterView = new TextView(getContext());
                this.mCounterView.setMaxLines(1);
                try {
                    this.mCounterView.setTextAppearance(getContext(), this.mCounterTextAppearance);
                } catch (Exception e) {
                    this.mCounterView.setTextAppearance(getContext(), C0236R.style.TextAppearance_AppCompat_Caption);
                    this.mCounterView.setTextColor(ContextCompat.getColor(getContext(), C0000R.color.design_textinput_error_color_light));
                }
                addIndicator(this.mCounterView, INVALID_MAX_LENGTH);
                if (this.mEditText == null) {
                    updateCounter(0);
                } else {
                    updateCounter(this.mEditText.getText().length());
                }
            } else {
                removeIndicator(this.mCounterView);
                this.mCounterView = null;
            }
            this.mCounterEnabled = enabled;
        }
    }

    public boolean isCounterEnabled() {
        return this.mCounterEnabled;
    }

    public void setCounterMaxLength(int maxLength) {
        if (this.mCounterMaxLength != maxLength) {
            if (maxLength > 0) {
                this.mCounterMaxLength = maxLength;
            } else {
                this.mCounterMaxLength = INVALID_MAX_LENGTH;
            }
            if (this.mCounterEnabled) {
                updateCounter(this.mEditText == null ? 0 : this.mEditText.getText().length());
            }
        }
    }

    public void setEnabled(boolean enabled) {
        recursiveSetEnabled(this, enabled);
        super.setEnabled(enabled);
    }

    private static void recursiveSetEnabled(ViewGroup vg, boolean enabled) {
        int count = vg.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = vg.getChildAt(i);
            child.setEnabled(enabled);
            if (child instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) child, enabled);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.mCounterMaxLength;
    }

    void updateCounter(int length) {
        boolean wasCounterOverflowed = this.mCounterOverflowed;
        if (this.mCounterMaxLength == INVALID_MAX_LENGTH) {
            this.mCounterView.setText(String.valueOf(length));
            this.mCounterOverflowed = false;
        } else {
            this.mCounterOverflowed = length > this.mCounterMaxLength;
            if (wasCounterOverflowed != this.mCounterOverflowed) {
                this.mCounterView.setTextAppearance(getContext(), this.mCounterOverflowed ? this.mCounterOverflowTextAppearance : this.mCounterTextAppearance);
            }
            this.mCounterView.setText(getContext().getString(C0000R.string.character_counter_pattern, new Object[]{Integer.valueOf(length), Integer.valueOf(this.mCounterMaxLength)}));
        }
        if (this.mEditText != null && wasCounterOverflowed != this.mCounterOverflowed) {
            updateLabelState(false);
            updateEditTextBackground();
        }
    }

    private void updateEditTextBackground() {
        if (this.mEditText != null) {
            Drawable editTextBackground = this.mEditText.getBackground();
            if (editTextBackground != null) {
                ensureBackgroundDrawableStateWorkaround();
                if (DrawableUtils.canSafelyMutateDrawable(editTextBackground)) {
                    editTextBackground = editTextBackground.mutate();
                }
                if (this.mErrorShown && this.mErrorView != null) {
                    editTextBackground.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.mErrorView.getCurrentTextColor(), Mode.SRC_IN));
                } else if (!this.mCounterOverflowed || this.mCounterView == null) {
                    DrawableCompat.clearColorFilter(editTextBackground);
                    this.mEditText.refreshDrawableState();
                } else {
                    editTextBackground.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.mCounterView.getCurrentTextColor(), Mode.SRC_IN));
                }
            }
        }
    }

    private void ensureBackgroundDrawableStateWorkaround() {
        int sdk = VERSION.SDK_INT;
        if (sdk == 21 || sdk == 22) {
            Drawable bg = this.mEditText.getBackground();
            if (bg != null && !this.mHasReconstructedEditTextBackground) {
                Drawable newBg = bg.getConstantState().newDrawable();
                if (bg instanceof DrawableContainer) {
                    this.mHasReconstructedEditTextBackground = DrawableUtils.setContainerConstantState((DrawableContainer) bg, newBg.getConstantState());
                }
                if (!this.mHasReconstructedEditTextBackground) {
                    this.mEditText.setBackgroundDrawable(newBg);
                    this.mHasReconstructedEditTextBackground = true;
                }
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState ss = new SavedState(super.onSaveInstanceState());
        if (this.mErrorShown) {
            ss.error = getError();
        }
        return ss;
    }

    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof SavedState) {
            SavedState ss = (SavedState) state;
            super.onRestoreInstanceState(ss.getSuperState());
            setError(ss.error);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(state);
    }

    @Nullable
    public CharSequence getError() {
        return this.mErrorEnabled ? this.mError : null;
    }

    public boolean isHintAnimationEnabled() {
        return this.mHintAnimationEnabled;
    }

    public void setHintAnimationEnabled(boolean enabled) {
        this.mHintAnimationEnabled = enabled;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mHintEnabled) {
            this.mCollapsingTextHelper.draw(canvas);
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        updatePasswordToggleView();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void updatePasswordToggleView() {
        if (this.mEditText != null) {
            Drawable[] compounds;
            if (shouldShowPasswordIcon()) {
                if (this.mPasswordToggleView == null) {
                    this.mPasswordToggleView = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(C0000R.layout.design_text_input_password_icon, this.mInputFrame, false);
                    this.mPasswordToggleView.setImageDrawable(this.mPasswordToggleDrawable);
                    this.mPasswordToggleView.setContentDescription(this.mPasswordToggleContentDesc);
                    this.mInputFrame.addView(this.mPasswordToggleView);
                    this.mPasswordToggleView.setOnClickListener(new C00464());
                }
                this.mPasswordToggleView.setVisibility(0);
                if (this.mPasswordToggleDummyDrawable == null) {
                    this.mPasswordToggleDummyDrawable = new ColorDrawable();
                }
                this.mPasswordToggleDummyDrawable.setBounds(0, 0, this.mPasswordToggleView.getMeasuredWidth(), 1);
                compounds = TextViewCompat.getCompoundDrawablesRelative(this.mEditText);
                if (compounds[2] != this.mPasswordToggleDummyDrawable) {
                    this.mOriginalEditTextEndDrawable = compounds[2];
                }
                TextViewCompat.setCompoundDrawablesRelative(this.mEditText, compounds[0], compounds[1], this.mPasswordToggleDummyDrawable, compounds[3]);
                this.mPasswordToggleView.setPadding(this.mEditText.getPaddingLeft(), this.mEditText.getPaddingTop(), this.mEditText.getPaddingRight(), this.mEditText.getPaddingBottom());
                return;
            }
            if (this.mPasswordToggleView != null && this.mPasswordToggleView.getVisibility() == 0) {
                this.mPasswordToggleView.setVisibility(8);
            }
            compounds = TextViewCompat.getCompoundDrawablesRelative(this.mEditText);
            if (compounds[2] == this.mPasswordToggleDummyDrawable) {
                TextViewCompat.setCompoundDrawablesRelative(this.mEditText, compounds[0], compounds[1], this.mOriginalEditTextEndDrawable, compounds[3]);
            }
        }
    }

    public void setPasswordVisibilityToggleDrawable(@DrawableRes int resId) {
        setPasswordVisibilityToggleDrawable(resId != 0 ? AppCompatResources.getDrawable(getContext(), resId) : null);
    }

    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable icon) {
        this.mPasswordToggleDrawable = icon;
        if (this.mPasswordToggleView != null) {
            this.mPasswordToggleView.setImageDrawable(icon);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(@StringRes int resId) {
        setPasswordVisibilityToggleContentDescription(resId != 0 ? getResources().getText(resId) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence description) {
        this.mPasswordToggleContentDesc = description;
        if (this.mPasswordToggleView != null) {
            this.mPasswordToggleView.setContentDescription(description);
        }
    }

    @Nullable
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.mPasswordToggleDrawable;
    }

    @Nullable
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.mPasswordToggleContentDesc;
    }

    public boolean isPasswordVisibilityToggleEnabled() {
        return this.mPasswordToggleEnabled;
    }

    public void setPasswordVisibilityToggleEnabled(boolean enabled) {
        if (this.mPasswordToggleEnabled != enabled) {
            this.mPasswordToggleEnabled = enabled;
            if (!(enabled || !this.mPasswordToggledVisible || this.mEditText == null)) {
                this.mEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.mPasswordToggledVisible = false;
            updatePasswordToggleView();
        }
    }

    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList tintList) {
        this.mPasswordToggleTintList = tintList;
        this.mHasPasswordToggleTintList = true;
        applyPasswordToggleTint();
    }

    public void setPasswordVisibilityToggleTintMode(@Nullable Mode mode) {
        this.mPasswordToggleTintMode = mode;
        this.mHasPasswordToggleTintMode = true;
        applyPasswordToggleTint();
    }

    void passwordVisibilityToggleRequested() {
        if (this.mPasswordToggleEnabled) {
            int selection = this.mEditText.getSelectionEnd();
            if (hasPasswordTransformation()) {
                this.mEditText.setTransformationMethod(null);
                this.mPasswordToggledVisible = true;
            } else {
                this.mEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.mPasswordToggledVisible = false;
            }
            this.mPasswordToggleView.setChecked(this.mPasswordToggledVisible);
            this.mEditText.setSelection(selection);
        }
    }

    private boolean hasPasswordTransformation() {
        return this.mEditText != null && (this.mEditText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private boolean shouldShowPasswordIcon() {
        return this.mPasswordToggleEnabled && (hasPasswordTransformation() || this.mPasswordToggledVisible);
    }

    private void applyPasswordToggleTint() {
        if (this.mPasswordToggleDrawable == null) {
            return;
        }
        if (this.mHasPasswordToggleTintList || this.mHasPasswordToggleTintMode) {
            this.mPasswordToggleDrawable = DrawableCompat.wrap(this.mPasswordToggleDrawable).mutate();
            if (this.mHasPasswordToggleTintList) {
                DrawableCompat.setTintList(this.mPasswordToggleDrawable, this.mPasswordToggleTintList);
            }
            if (this.mHasPasswordToggleTintMode) {
                DrawableCompat.setTintMode(this.mPasswordToggleDrawable, this.mPasswordToggleTintMode);
            }
            if (this.mPasswordToggleView != null && this.mPasswordToggleView.getDrawable() != this.mPasswordToggleDrawable) {
                this.mPasswordToggleView.setImageDrawable(this.mPasswordToggleDrawable);
            }
        }
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.mHintEnabled && this.mEditText != null) {
            Rect rect = this.mTmpRect;
            ViewGroupUtils.getDescendantRect(this, this.mEditText, rect);
            int l = rect.left + this.mEditText.getCompoundPaddingLeft();
            int r = rect.right - this.mEditText.getCompoundPaddingRight();
            this.mCollapsingTextHelper.setExpandedBounds(l, rect.top + this.mEditText.getCompoundPaddingTop(), r, rect.bottom - this.mEditText.getCompoundPaddingBottom());
            this.mCollapsingTextHelper.setCollapsedBounds(l, getPaddingTop(), r, (bottom - top) - getPaddingBottom());
            this.mCollapsingTextHelper.recalculate();
        }
    }

    private void collapseHint(boolean animate) {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (animate && this.mHintAnimationEnabled) {
            animateToExpansionFraction(TextTrackStyle.DEFAULT_FONT_SCALE);
        } else {
            this.mCollapsingTextHelper.setExpansionFraction(TextTrackStyle.DEFAULT_FONT_SCALE);
        }
        this.mHintExpanded = false;
    }

    protected void drawableStateChanged() {
        boolean z = true;
        if (!this.mInDrawableStateChanged) {
            this.mInDrawableStateChanged = true;
            super.drawableStateChanged();
            int[] state = getDrawableState();
            boolean changed = false;
            if (!(ViewCompat.isLaidOut(this) && isEnabled())) {
                z = false;
            }
            updateLabelState(z);
            updateEditTextBackground();
            if (this.mCollapsingTextHelper != null) {
                changed = false | this.mCollapsingTextHelper.setState(state);
            }
            if (changed) {
                invalidate();
            }
            this.mInDrawableStateChanged = false;
        }
    }

    private void expandHint(boolean animate) {
        if (this.mAnimator != null && this.mAnimator.isRunning()) {
            this.mAnimator.cancel();
        }
        if (animate && this.mHintAnimationEnabled) {
            animateToExpansionFraction(0.0f);
        } else {
            this.mCollapsingTextHelper.setExpansionFraction(0.0f);
        }
        this.mHintExpanded = true;
    }

    private void animateToExpansionFraction(float target) {
        if (this.mCollapsingTextHelper.getExpansionFraction() != target) {
            if (this.mAnimator == null) {
                this.mAnimator = ViewUtils.createAnimator();
                this.mAnimator.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
                this.mAnimator.setDuration(200);
                this.mAnimator.addUpdateListener(new C00475());
            }
            this.mAnimator.setFloatValues(this.mCollapsingTextHelper.getExpansionFraction(), target);
            this.mAnimator.start();
        }
    }

    @VisibleForTesting
    final boolean isHintExpanded() {
        return this.mHintExpanded;
    }

    private static boolean arrayContains(int[] array, int value) {
        for (int v : array) {
            if (v == value) {
                return true;
            }
        }
        return false;
    }
}
