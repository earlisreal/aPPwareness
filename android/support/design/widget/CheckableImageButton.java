package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.appcompat.C0236R;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    private static final int[] DRAWABLE_STATE_CHECKED;
    private boolean mChecked;

    /* renamed from: android.support.design.widget.CheckableImageButton.1 */
    class C00131 extends AccessibilityDelegateCompat {
        C00131() {
        }

        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            super.onInitializeAccessibilityEvent(host, event);
            event.setChecked(CheckableImageButton.this.isChecked());
        }

        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
            super.onInitializeAccessibilityNodeInfo(host, info);
            info.setCheckable(true);
            info.setChecked(CheckableImageButton.this.isChecked());
        }
    }

    static {
        DRAWABLE_STATE_CHECKED = new int[]{16842912};
    }

    public CheckableImageButton(Context context) {
        this(context, null);
    }

    public CheckableImageButton(Context context, AttributeSet attrs) {
        this(context, attrs, C0236R.attr.imageButtonStyle);
    }

    public CheckableImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ViewCompat.setAccessibilityDelegate(this, new C00131());
    }

    public void setChecked(boolean checked) {
        if (this.mChecked != checked) {
            this.mChecked = checked;
            refreshDrawableState();
            sendAccessibilityEvent(ItemAnimator.FLAG_MOVED);
        }
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void toggle() {
        setChecked(!this.mChecked);
    }

    public int[] onCreateDrawableState(int extraSpace) {
        if (this.mChecked) {
            return mergeDrawableStates(super.onCreateDrawableState(DRAWABLE_STATE_CHECKED.length + extraSpace), DRAWABLE_STATE_CHECKED);
        }
        return super.onCreateDrawableState(extraSpace);
    }
}
