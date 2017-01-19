package android.support.v4.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.media.TransportMediator;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.FocusStrategy.BoundsAdapter;
import android.support.v4.widget.FocusStrategy.CollectionAdapter;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.C0397R;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import java.util.List;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS;
    private static final BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER;
    private static final CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER;
    private int mAccessibilityFocusedVirtualViewId;
    private final View mHost;
    private int mHoveredVirtualViewId;
    private int mKeyboardFocusedVirtualViewId;
    private final AccessibilityManager mManager;
    private MyNodeProvider mNodeProvider;
    private final int[] mTempGlobalRect;
    private final Rect mTempParentRect;
    private final Rect mTempScreenRect;
    private final Rect mTempVisibleRect;

    /* renamed from: android.support.v4.widget.ExploreByTouchHelper.1 */
    static class C01741 implements BoundsAdapter<AccessibilityNodeInfoCompat> {
        C01741() {
        }

        public void obtainBounds(AccessibilityNodeInfoCompat node, Rect outBounds) {
            node.getBoundsInParent(outBounds);
        }
    }

    /* renamed from: android.support.v4.widget.ExploreByTouchHelper.2 */
    static class C01752 implements CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> {
        C01752() {
        }

        public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> collection, int index) {
            return (AccessibilityNodeInfoCompat) collection.valueAt(index);
        }

        public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> collection) {
            return collection.size();
        }
    }

    private class MyNodeProvider extends AccessibilityNodeProviderCompat {
        MyNodeProvider() {
        }

        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int virtualViewId) {
            return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(virtualViewId));
        }

        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            return ExploreByTouchHelper.this.performAction(virtualViewId, action, arguments);
        }
    }

    protected abstract int getVirtualViewAt(float f, float f2);

    protected abstract void getVisibleVirtualViews(List<Integer> list);

    protected abstract boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle);

    protected abstract void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    static {
        INVALID_PARENT_BOUNDS = new Rect(Strategy.TTL_SECONDS_INFINITE, Strategy.TTL_SECONDS_INFINITE, INVALID_ID, INVALID_ID);
        NODE_ADAPTER = new C01741();
        SPARSE_VALUES_ADAPTER = new C01752();
    }

    public ExploreByTouchHelper(View host) {
        this.mTempScreenRect = new Rect();
        this.mTempParentRect = new Rect();
        this.mTempVisibleRect = new Rect();
        this.mTempGlobalRect = new int[2];
        this.mAccessibilityFocusedVirtualViewId = INVALID_ID;
        this.mKeyboardFocusedVirtualViewId = INVALID_ID;
        this.mHoveredVirtualViewId = INVALID_ID;
        if (host == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.mHost = host;
        this.mManager = (AccessibilityManager) host.getContext().getSystemService("accessibility");
        host.setFocusable(true);
        if (ViewCompat.getImportantForAccessibility(host) == 0) {
            ViewCompat.setImportantForAccessibility(host, 1);
        }
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new MyNodeProvider();
        }
        return this.mNodeProvider;
    }

    public final boolean dispatchHoverEvent(@NonNull MotionEvent event) {
        boolean z = true;
        if (!this.mManager.isEnabled() || !AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager)) {
            return false;
        }
        switch (event.getAction()) {
            case BuyButtonText.DONATE_WITH /*7*/:
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                int virtualViewId = getVirtualViewAt(event.getX(), event.getY());
                updateHoveredVirtualView(virtualViewId);
                if (virtualViewId == INVALID_ID) {
                    z = false;
                }
                return z;
            case ConnectionResult.DEVELOPER_ERROR /*10*/:
                if (this.mAccessibilityFocusedVirtualViewId == INVALID_ID) {
                    return false;
                }
                updateHoveredVirtualView(INVALID_ID);
                return true;
            default:
                return false;
        }
    }

    public final boolean dispatchKeyEvent(@NonNull KeyEvent event) {
        boolean handled = false;
        if (event.getAction() == 1) {
            return false;
        }
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
            case ConnectionResult.RESTRICTED_PROFILE /*20*/:
            case C0397R.styleable.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
            case C0397R.styleable.MapAttrs_latLngBoundsNorthEastLongitude /*22*/:
                if (!KeyEventCompat.hasNoModifiers(event)) {
                    return false;
                }
                int direction = keyToDirection(keyCode);
                int count = event.getRepeatCount() + 1;
                for (int i = 0; i < count && moveFocus(direction, null); i++) {
                    handled = true;
                }
                return handled;
            case C0394R.styleable.Toolbar_collapseContentDescription /*23*/:
            case C0394R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                if (!KeyEventCompat.hasNoModifiers(event) || event.getRepeatCount() != 0) {
                    return false;
                }
                clickKeyboardFocusedVirtualView();
                return true;
            case C0394R.styleable.AppCompatTheme_popupMenuStyle /*61*/:
                if (KeyEventCompat.hasNoModifiers(event)) {
                    return moveFocus(2, null);
                }
                if (KeyEventCompat.hasModifiers(event, 1)) {
                    return moveFocus(1, null);
                }
                return false;
            default:
                return false;
        }
    }

    public final void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        if (this.mKeyboardFocusedVirtualViewId != INVALID_ID) {
            clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
        }
        if (gainFocus) {
            moveFocus(direction, previouslyFocusedRect);
        }
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    private static int keyToDirection(int keyCode) {
        switch (keyCode) {
            case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                return 33;
            case C0397R.styleable.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                return 17;
            case C0397R.styleable.MapAttrs_latLngBoundsNorthEastLongitude /*22*/:
                return 66;
            default:
                return TransportMediator.KEYCODE_MEDIA_RECORD;
        }
    }

    private void getBoundsInParent(int virtualViewId, Rect outBounds) {
        obtainAccessibilityNodeInfo(virtualViewId).getBoundsInParent(outBounds);
    }

    private boolean moveFocus(int direction, @Nullable Rect previouslyFocusedRect) {
        AccessibilityNodeInfoCompat focusedNode;
        AccessibilityNodeInfoCompat nextFocusedNode;
        int nextFocusedNodeId;
        SparseArrayCompat<AccessibilityNodeInfoCompat> allNodes = getAllNodes();
        int focusedNodeId = this.mKeyboardFocusedVirtualViewId;
        if (focusedNodeId == INVALID_ID) {
            focusedNode = null;
        } else {
            focusedNode = (AccessibilityNodeInfoCompat) allNodes.get(focusedNodeId);
        }
        switch (direction) {
            case MessageApi.FILTER_PREFIX /*1*/:
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                nextFocusedNode = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInRelativeDirection(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, focusedNode, direction, ViewCompat.getLayoutDirection(this.mHost) == 1, false);
                break;
            case ConnectionResult.SIGN_IN_FAILED /*17*/:
            case C0394R.styleable.AppCompatTheme_actionModeCopyDrawable /*33*/:
            case C0394R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
            case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                Rect selectedRect = new Rect();
                if (this.mKeyboardFocusedVirtualViewId != INVALID_ID) {
                    getBoundsInParent(this.mKeyboardFocusedVirtualViewId, selectedRect);
                } else if (previouslyFocusedRect != null) {
                    selectedRect.set(previouslyFocusedRect);
                } else {
                    guessPreviouslyFocusedRect(this.mHost, direction, selectedRect);
                }
                nextFocusedNode = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInAbsoluteDirection(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, focusedNode, selectedRect, direction);
                break;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        if (nextFocusedNode == null) {
            nextFocusedNodeId = INVALID_ID;
        } else {
            nextFocusedNodeId = allNodes.keyAt(allNodes.indexOfValue(nextFocusedNode));
        }
        return requestKeyboardFocusForVirtualView(nextFocusedNodeId);
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
        List<Integer> virtualViewIds = new ArrayList();
        getVisibleVirtualViews(virtualViewIds);
        SparseArrayCompat<AccessibilityNodeInfoCompat> allNodes = new SparseArrayCompat();
        for (int virtualViewId = 0; virtualViewId < virtualViewIds.size(); virtualViewId++) {
            allNodes.put(virtualViewId, createNodeForChild(virtualViewId));
        }
        return allNodes;
    }

    private static Rect guessPreviouslyFocusedRect(@NonNull View host, int direction, @NonNull Rect outBounds) {
        int w = host.getWidth();
        int h = host.getHeight();
        switch (direction) {
            case ConnectionResult.SIGN_IN_FAILED /*17*/:
                outBounds.set(w, 0, w, h);
                break;
            case C0394R.styleable.AppCompatTheme_actionModeCopyDrawable /*33*/:
                outBounds.set(0, h, w, h);
                break;
            case C0394R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                outBounds.set(HOST_ID, 0, HOST_ID, h);
                break;
            case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                outBounds.set(0, HOST_ID, w, HOST_ID);
                break;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return outBounds;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        return this.mKeyboardFocusedVirtualViewId != INVALID_ID && onPerformActionForVirtualView(this.mKeyboardFocusedVirtualViewId, 16, null);
    }

    public final boolean sendEventForVirtualView(int virtualViewId, int eventType) {
        if (virtualViewId == INVALID_ID || !this.mManager.isEnabled()) {
            return false;
        }
        ViewParent parent = this.mHost.getParent();
        if (parent == null) {
            return false;
        }
        return ViewParentCompat.requestSendAccessibilityEvent(parent, this.mHost, createEvent(virtualViewId, eventType));
    }

    public final void invalidateRoot() {
        invalidateVirtualView(HOST_ID, 1);
    }

    public final void invalidateVirtualView(int virtualViewId) {
        invalidateVirtualView(virtualViewId, 0);
    }

    public final void invalidateVirtualView(int virtualViewId, int changeTypes) {
        if (virtualViewId != INVALID_ID && this.mManager.isEnabled()) {
            ViewParent parent = this.mHost.getParent();
            if (parent != null) {
                AccessibilityEvent event = createEvent(virtualViewId, ItemAnimator.FLAG_MOVED);
                AccessibilityEventCompat.setContentChangeTypes(event, changeTypes);
                ViewParentCompat.requestSendAccessibilityEvent(parent, this.mHost, event);
            }
        }
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    protected void onVirtualViewKeyboardFocusChanged(int virtualViewId, boolean hasFocus) {
    }

    private void updateHoveredVirtualView(int virtualViewId) {
        if (this.mHoveredVirtualViewId != virtualViewId) {
            int previousVirtualViewId = this.mHoveredVirtualViewId;
            this.mHoveredVirtualViewId = virtualViewId;
            sendEventForVirtualView(virtualViewId, Cast.MAX_NAMESPACE_LENGTH);
            sendEventForVirtualView(previousVirtualViewId, FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED);
        }
    }

    private AccessibilityEvent createEvent(int virtualViewId, int eventType) {
        switch (virtualViewId) {
            case HOST_ID /*-1*/:
                return createEventForHost(eventType);
            default:
                return createEventForChild(virtualViewId, eventType);
        }
    }

    private AccessibilityEvent createEventForHost(int eventType) {
        AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
        ViewCompat.onInitializeAccessibilityEvent(this.mHost, event);
        return event;
    }

    public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(host, event);
        onPopulateEventForHost(event);
    }

    private AccessibilityEvent createEventForChild(int virtualViewId, int eventType) {
        AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
        AccessibilityRecordCompat record = AccessibilityEventCompat.asRecord(event);
        AccessibilityNodeInfoCompat node = obtainAccessibilityNodeInfo(virtualViewId);
        record.getText().add(node.getText());
        record.setContentDescription(node.getContentDescription());
        record.setScrollable(node.isScrollable());
        record.setPassword(node.isPassword());
        record.setEnabled(node.isEnabled());
        record.setChecked(node.isChecked());
        onPopulateEventForVirtualView(virtualViewId, event);
        if (event.getText().isEmpty() && event.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        record.setClassName(node.getClassName());
        record.setSource(this.mHost, virtualViewId);
        event.setPackageName(this.mHost.getContext().getPackageName());
        return event;
    }

    @NonNull
    AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int virtualViewId) {
        if (virtualViewId == HOST_ID) {
            return createNodeForHost();
        }
        return createNodeForChild(virtualViewId);
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat info = AccessibilityNodeInfoCompat.obtain(this.mHost);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, info);
        ArrayList<Integer> virtualViewIds = new ArrayList();
        getVisibleVirtualViews(virtualViewIds);
        if (info.getChildCount() <= 0 || virtualViewIds.size() <= 0) {
            int count = virtualViewIds.size();
            for (int i = 0; i < count; i++) {
                info.addChild(this.mHost, ((Integer) virtualViewIds.get(i)).intValue());
            }
            return info;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
        super.onInitializeAccessibilityNodeInfo(host, info);
        onPopulateNodeForHost(info);
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForChild(int virtualViewId) {
        AccessibilityNodeInfoCompat node = AccessibilityNodeInfoCompat.obtain();
        node.setEnabled(true);
        node.setFocusable(true);
        node.setClassName(DEFAULT_CLASS_NAME);
        node.setBoundsInParent(INVALID_PARENT_BOUNDS);
        node.setBoundsInScreen(INVALID_PARENT_BOUNDS);
        onPopulateNodeForVirtualView(virtualViewId, node);
        if (node.getText() == null && node.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        node.getBoundsInParent(this.mTempParentRect);
        if (this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = node.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else if ((actions & Cast.MAX_NAMESPACE_LENGTH) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        } else {
            boolean isFocused;
            node.setPackageName(this.mHost.getContext().getPackageName());
            node.setSource(this.mHost, virtualViewId);
            node.setParent(this.mHost);
            if (this.mAccessibilityFocusedVirtualViewId == virtualViewId) {
                node.setAccessibilityFocused(true);
                node.addAction((int) Cast.MAX_NAMESPACE_LENGTH);
            } else {
                node.setAccessibilityFocused(false);
                node.addAction(64);
            }
            if (this.mKeyboardFocusedVirtualViewId == virtualViewId) {
                isFocused = true;
            } else {
                isFocused = false;
            }
            if (isFocused) {
                node.addAction(2);
            } else if (node.isFocusable()) {
                node.addAction(1);
            }
            node.setFocused(isFocused);
            if (intersectVisibleToUser(this.mTempParentRect)) {
                node.setVisibleToUser(true);
                node.setBoundsInParent(this.mTempParentRect);
            }
            node.getBoundsInScreen(this.mTempScreenRect);
            if (this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
                this.mHost.getLocationOnScreen(this.mTempGlobalRect);
                node.getBoundsInParent(this.mTempScreenRect);
                this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                node.setBoundsInScreen(this.mTempScreenRect);
            }
            return node;
        }
    }

    boolean performAction(int virtualViewId, int action, Bundle arguments) {
        switch (virtualViewId) {
            case HOST_ID /*-1*/:
                return performActionForHost(action, arguments);
            default:
                return performActionForChild(virtualViewId, action, arguments);
        }
    }

    private boolean performActionForHost(int action, Bundle arguments) {
        return ViewCompat.performAccessibilityAction(this.mHost, action, arguments);
    }

    private boolean performActionForChild(int virtualViewId, int action, Bundle arguments) {
        switch (action) {
            case MessageApi.FILTER_PREFIX /*1*/:
                return requestKeyboardFocusForVirtualView(virtualViewId);
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return clearKeyboardFocusForVirtualView(virtualViewId);
            case C0394R.styleable.AppCompatTheme_editTextBackground /*64*/:
                return requestAccessibilityFocus(virtualViewId);
            case Cast.MAX_NAMESPACE_LENGTH /*128*/:
                return clearAccessibilityFocus(virtualViewId);
            default:
                return onPerformActionForVirtualView(virtualViewId, action, arguments);
        }
    }

    private boolean intersectVisibleToUser(Rect localRect) {
        if (localRect == null || localRect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent viewParent = this.mHost.getParent();
        while (viewParent instanceof View) {
            View view = (View) viewParent;
            if (ViewCompat.getAlpha(view) <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            viewParent = view.getParent();
        }
        if (viewParent == null || !this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
            return false;
        }
        return localRect.intersect(this.mTempVisibleRect);
    }

    private boolean requestAccessibilityFocus(int virtualViewId) {
        if (!this.mManager.isEnabled() || !AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager) || this.mAccessibilityFocusedVirtualViewId == virtualViewId) {
            return false;
        }
        if (this.mAccessibilityFocusedVirtualViewId != INVALID_ID) {
            clearAccessibilityFocus(this.mAccessibilityFocusedVirtualViewId);
        }
        this.mAccessibilityFocusedVirtualViewId = virtualViewId;
        this.mHost.invalidate();
        sendEventForVirtualView(virtualViewId, AccessibilityNodeInfoCompat.ACTION_PASTE);
        return true;
    }

    private boolean clearAccessibilityFocus(int virtualViewId) {
        if (this.mAccessibilityFocusedVirtualViewId != virtualViewId) {
            return false;
        }
        this.mAccessibilityFocusedVirtualViewId = INVALID_ID;
        this.mHost.invalidate();
        sendEventForVirtualView(virtualViewId, ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH);
        return true;
    }

    public final boolean requestKeyboardFocusForVirtualView(int virtualViewId) {
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || this.mKeyboardFocusedVirtualViewId == virtualViewId) {
            return false;
        }
        if (this.mKeyboardFocusedVirtualViewId != INVALID_ID) {
            clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
        }
        this.mKeyboardFocusedVirtualViewId = virtualViewId;
        onVirtualViewKeyboardFocusChanged(virtualViewId, true);
        sendEventForVirtualView(virtualViewId, 8);
        return true;
    }

    public final boolean clearKeyboardFocusForVirtualView(int virtualViewId) {
        if (this.mKeyboardFocusedVirtualViewId != virtualViewId) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = INVALID_ID;
        onVirtualViewKeyboardFocusChanged(virtualViewId, false);
        sendEventForVirtualView(virtualViewId, 8);
        return true;
    }

    protected void onPopulateEventForVirtualView(int virtualViewId, AccessibilityEvent event) {
    }

    protected void onPopulateEventForHost(AccessibilityEvent event) {
    }

    protected void onPopulateNodeForHost(AccessibilityNodeInfoCompat node) {
    }
}
