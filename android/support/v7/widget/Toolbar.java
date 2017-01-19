package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.C0236R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.CollapsibleActionView;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    private static final String TAG = "Toolbar";
    private Callback mActionMenuPresenterCallback;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private RtlSpacingHelper mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private MenuBuilder.Callback mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final android.support.v7.widget.ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private int mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private int mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* renamed from: android.support.v7.widget.Toolbar.1 */
    class C03351 implements android.support.v7.widget.ActionMenuView.OnMenuItemClickListener {
        C03351() {
        }

        public boolean onMenuItemClick(MenuItem item) {
            if (Toolbar.this.mOnMenuItemClickListener != null) {
                return Toolbar.this.mOnMenuItemClickListener.onMenuItemClick(item);
            }
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar.2 */
    class C03362 implements Runnable {
        C03362() {
        }

        public void run() {
            Toolbar.this.showOverflowMenu();
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar.3 */
    class C03373 implements OnClickListener {
        C03373() {
        }

        public void onClick(View v) {
            Toolbar.this.collapseActionView();
        }
    }

    private class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;

        ExpandedActionViewMenuPresenter() {
        }

        public void initForMenu(Context context, MenuBuilder menu) {
            if (!(this.mMenu == null || this.mCurrentExpandedItem == null)) {
                this.mMenu.collapseItemActionView(this.mCurrentExpandedItem);
            }
            this.mMenu = menu;
        }

        public MenuView getMenuView(ViewGroup root) {
            return null;
        }

        public void updateMenuView(boolean cleared) {
            if (this.mCurrentExpandedItem != null) {
                boolean found = false;
                if (this.mMenu != null) {
                    int count = this.mMenu.size();
                    for (int i = 0; i < count; i++) {
                        if (this.mMenu.getItem(i) == this.mCurrentExpandedItem) {
                            found = true;
                            break;
                        }
                    }
                }
                if (!found) {
                    collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
                }
            }
        }

        public void setCallback(Callback cb) {
        }

        public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
            return false;
        }

        public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        }

        public boolean flagActionItems() {
            return false;
        }

        public boolean expandItemActionView(MenuBuilder menu, MenuItemImpl item) {
            Toolbar.this.ensureCollapseButtonView();
            if (Toolbar.this.mCollapseButtonView.getParent() != Toolbar.this) {
                Toolbar.this.addView(Toolbar.this.mCollapseButtonView);
            }
            Toolbar.this.mExpandedActionView = item.getActionView();
            this.mCurrentExpandedItem = item;
            if (Toolbar.this.mExpandedActionView.getParent() != Toolbar.this) {
                LayoutParams lp = Toolbar.this.generateDefaultLayoutParams();
                lp.gravity = MediaRouterJellybean.ALL_ROUTE_TYPES | (Toolbar.this.mButtonGravity & C0394R.styleable.AppCompatTheme_spinnerStyle);
                lp.mViewType = 2;
                Toolbar.this.mExpandedActionView.setLayoutParams(lp);
                Toolbar.this.addView(Toolbar.this.mExpandedActionView);
            }
            Toolbar.this.removeChildrenForExpandedActionView();
            Toolbar.this.requestLayout();
            item.setActionViewExpanded(true);
            if (Toolbar.this.mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView) Toolbar.this.mExpandedActionView).onActionViewExpanded();
            }
            return true;
        }

        public boolean collapseItemActionView(MenuBuilder menu, MenuItemImpl item) {
            if (Toolbar.this.mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView) Toolbar.this.mExpandedActionView).onActionViewCollapsed();
            }
            Toolbar.this.removeView(Toolbar.this.mExpandedActionView);
            Toolbar.this.removeView(Toolbar.this.mCollapseButtonView);
            Toolbar.this.mExpandedActionView = null;
            Toolbar.this.addChildrenForExpandedActionView();
            this.mCurrentExpandedItem = null;
            Toolbar.this.requestLayout();
            item.setActionViewExpanded(false);
            return true;
        }

        public int getId() {
            return 0;
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onRestoreInstanceState(Parcelable state) {
        }
    }

    public static class LayoutParams extends android.support.v7.app.ActionBar.LayoutParams {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        int mViewType;

        public LayoutParams(@NonNull Context c, AttributeSet attrs) {
            super(c, attrs);
            this.mViewType = CUSTOM;
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.mViewType = CUSTOM;
            this.gravity = 8388627;
        }

        public LayoutParams(int width, int height, int gravity) {
            super(width, height);
            this.mViewType = CUSTOM;
            this.gravity = gravity;
        }

        public LayoutParams(int gravity) {
            this(-2, -1, gravity);
        }

        public LayoutParams(LayoutParams source) {
            super((android.support.v7.app.ActionBar.LayoutParams) source);
            this.mViewType = CUSTOM;
            this.mViewType = source.mViewType;
        }

        public LayoutParams(android.support.v7.app.ActionBar.LayoutParams source) {
            super(source);
            this.mViewType = CUSTOM;
        }

        public LayoutParams(MarginLayoutParams source) {
            super((android.view.ViewGroup.LayoutParams) source);
            this.mViewType = CUSTOM;
            copyMarginsFromCompat(source);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams source) {
            super(source);
            this.mViewType = CUSTOM;
        }

        void copyMarginsFromCompat(MarginLayoutParams source) {
            this.leftMargin = source.leftMargin;
            this.topMargin = source.topMargin;
            this.rightMargin = source.rightMargin;
            this.bottomMargin = source.bottomMargin;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR;
        int expandedMenuItemId;
        boolean isOverflowOpen;

        /* renamed from: android.support.v7.widget.Toolbar.SavedState.1 */
        static class C03381 implements ParcelableCompatCreatorCallbacks<SavedState> {
            C03381() {
            }

            public SavedState createFromParcel(Parcel in, ClassLoader loader) {
                return new SavedState(in, loader);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        }

        public SavedState(Parcel source) {
            this(source, null);
        }

        public SavedState(Parcel source, ClassLoader loader) {
            super(source, loader);
            this.expandedMenuItemId = source.readInt();
            this.isOverflowOpen = source.readInt() != 0;
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.expandedMenuItemId);
            out.writeInt(this.isOverflowOpen ? 1 : 0);
        }

        static {
            CREATOR = ParcelableCompat.newCreator(new C03381());
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, C0236R.attr.toolbarStyle);
    }

    public Toolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList();
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new C03351();
        this.mShowOverflowMenuRunnable = new C03362();
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs, C0236R.styleable.Toolbar, defStyleAttr, 0);
        this.mTitleTextAppearance = a.getResourceId(C0236R.styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = a.getResourceId(C0236R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = a.getInteger(C0236R.styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = a.getInteger(C0236R.styleable.Toolbar_buttonGravity, 48);
        int titleMargin = a.getDimensionPixelOffset(C0236R.styleable.Toolbar_titleMargin, 0);
        if (a.hasValue(C0236R.styleable.Toolbar_titleMargins)) {
            titleMargin = a.getDimensionPixelOffset(C0236R.styleable.Toolbar_titleMargins, titleMargin);
        }
        this.mTitleMarginBottom = titleMargin;
        this.mTitleMarginTop = titleMargin;
        this.mTitleMarginEnd = titleMargin;
        this.mTitleMarginStart = titleMargin;
        int marginStart = a.getDimensionPixelOffset(C0236R.styleable.Toolbar_titleMarginStart, -1);
        if (marginStart >= 0) {
            this.mTitleMarginStart = marginStart;
        }
        int marginEnd = a.getDimensionPixelOffset(C0236R.styleable.Toolbar_titleMarginEnd, -1);
        if (marginEnd >= 0) {
            this.mTitleMarginEnd = marginEnd;
        }
        int marginTop = a.getDimensionPixelOffset(C0236R.styleable.Toolbar_titleMarginTop, -1);
        if (marginTop >= 0) {
            this.mTitleMarginTop = marginTop;
        }
        int marginBottom = a.getDimensionPixelOffset(C0236R.styleable.Toolbar_titleMarginBottom, -1);
        if (marginBottom >= 0) {
            this.mTitleMarginBottom = marginBottom;
        }
        this.mMaxButtonHeight = a.getDimensionPixelSize(C0236R.styleable.Toolbar_maxButtonHeight, -1);
        int contentInsetStart = a.getDimensionPixelOffset(C0236R.styleable.Toolbar_contentInsetStart, RtlSpacingHelper.UNDEFINED);
        int contentInsetEnd = a.getDimensionPixelOffset(C0236R.styleable.Toolbar_contentInsetEnd, RtlSpacingHelper.UNDEFINED);
        int contentInsetLeft = a.getDimensionPixelSize(C0236R.styleable.Toolbar_contentInsetLeft, 0);
        int contentInsetRight = a.getDimensionPixelSize(C0236R.styleable.Toolbar_contentInsetRight, 0);
        ensureContentInsets();
        this.mContentInsets.setAbsolute(contentInsetLeft, contentInsetRight);
        if (!(contentInsetStart == Integer.MIN_VALUE && contentInsetEnd == Integer.MIN_VALUE)) {
            this.mContentInsets.setRelative(contentInsetStart, contentInsetEnd);
        }
        this.mContentInsetStartWithNavigation = a.getDimensionPixelOffset(C0236R.styleable.Toolbar_contentInsetStartWithNavigation, RtlSpacingHelper.UNDEFINED);
        this.mContentInsetEndWithActions = a.getDimensionPixelOffset(C0236R.styleable.Toolbar_contentInsetEndWithActions, RtlSpacingHelper.UNDEFINED);
        this.mCollapseIcon = a.getDrawable(C0236R.styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = a.getText(C0236R.styleable.Toolbar_collapseContentDescription);
        CharSequence title = a.getText(C0236R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(title)) {
            setTitle(title);
        }
        CharSequence subtitle = a.getText(C0236R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(subtitle)) {
            setSubtitle(subtitle);
        }
        this.mPopupContext = getContext();
        setPopupTheme(a.getResourceId(C0236R.styleable.Toolbar_popupTheme, 0));
        Drawable navIcon = a.getDrawable(C0236R.styleable.Toolbar_navigationIcon);
        if (navIcon != null) {
            setNavigationIcon(navIcon);
        }
        CharSequence navDesc = a.getText(C0236R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(navDesc)) {
            setNavigationContentDescription(navDesc);
        }
        Drawable logo = a.getDrawable(C0236R.styleable.Toolbar_logo);
        if (logo != null) {
            setLogo(logo);
        }
        CharSequence logoDesc = a.getText(C0236R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(logoDesc)) {
            setLogoDescription(logoDesc);
        }
        if (a.hasValue(C0236R.styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(a.getColor(C0236R.styleable.Toolbar_titleTextColor, -1));
        }
        if (a.hasValue(C0236R.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.getColor(C0236R.styleable.Toolbar_subtitleTextColor, -1));
        }
        a.recycle();
    }

    public void setPopupTheme(@StyleRes int resId) {
        if (this.mPopupTheme != resId) {
            this.mPopupTheme = resId;
            if (resId == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), resId);
            }
        }
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public void setTitleMargin(int start, int top, int end, int bottom) {
        this.mTitleMarginStart = start;
        this.mTitleMarginTop = top;
        this.mTitleMarginEnd = end;
        this.mTitleMarginBottom = bottom;
        requestLayout();
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public void setTitleMarginStart(int margin) {
        this.mTitleMarginStart = margin;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    public void setTitleMarginTop(int margin) {
        this.mTitleMarginTop = margin;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public void setTitleMarginEnd(int margin) {
        this.mTitleMarginEnd = margin;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public void setTitleMarginBottom(int margin) {
        this.mTitleMarginBottom = margin;
        requestLayout();
    }

    public void onRtlPropertiesChanged(int layoutDirection) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(layoutDirection);
        }
        ensureContentInsets();
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (layoutDirection != 1) {
            z = false;
        }
        rtlSpacingHelper.setDirection(z);
    }

    public void setLogo(@DrawableRes int resId) {
        setLogo(AppCompatResources.getDrawable(getContext(), resId));
    }

    public boolean canShowOverflowMenu() {
        return getVisibility() == 0 && this.mMenuView != null && this.mMenuView.isOverflowReserved();
    }

    public boolean isOverflowMenuShowing() {
        return this.mMenuView != null && this.mMenuView.isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowPending() {
        return this.mMenuView != null && this.mMenuView.isOverflowMenuShowPending();
    }

    public boolean showOverflowMenu() {
        return this.mMenuView != null && this.mMenuView.showOverflowMenu();
    }

    public boolean hideOverflowMenu() {
        return this.mMenuView != null && this.mMenuView.hideOverflowMenu();
    }

    public void setMenu(MenuBuilder menu, ActionMenuPresenter outerPresenter) {
        if (menu != null || this.mMenuView != null) {
            ensureMenuView();
            MenuBuilder oldMenu = this.mMenuView.peekMenu();
            if (oldMenu != menu) {
                if (oldMenu != null) {
                    oldMenu.removeMenuPresenter(this.mOuterActionMenuPresenter);
                    oldMenu.removeMenuPresenter(this.mExpandedMenuPresenter);
                }
                if (this.mExpandedMenuPresenter == null) {
                    this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
                }
                outerPresenter.setExpandedActionViewsExclusive(true);
                if (menu != null) {
                    menu.addMenuPresenter(outerPresenter, this.mPopupContext);
                    menu.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
                } else {
                    outerPresenter.initForMenu(this.mPopupContext, null);
                    this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
                    outerPresenter.updateMenuView(true);
                    this.mExpandedMenuPresenter.updateMenuView(true);
                }
                this.mMenuView.setPopupTheme(this.mPopupTheme);
                this.mMenuView.setPresenter(outerPresenter);
                this.mOuterActionMenuPresenter = outerPresenter;
            }
        }
    }

    public void dismissPopupMenus() {
        if (this.mMenuView != null) {
            this.mMenuView.dismissPopupMenus();
        }
    }

    public boolean isTitleTruncated() {
        if (this.mTitleTextView == null) {
            return false;
        }
        Layout titleLayout = this.mTitleTextView.getLayout();
        if (titleLayout == null) {
            return false;
        }
        int lineCount = titleLayout.getLineCount();
        for (int i = 0; i < lineCount; i++) {
            if (titleLayout.getEllipsisCount(i) > 0) {
                return true;
            }
        }
        return false;
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (!isChildOrHidden(this.mLogoView)) {
                addSystemView(this.mLogoView, true);
            }
        } else if (this.mLogoView != null && isChildOrHidden(this.mLogoView)) {
            removeView(this.mLogoView);
            this.mHiddenViews.remove(this.mLogoView);
        }
        if (this.mLogoView != null) {
            this.mLogoView.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        return this.mLogoView != null ? this.mLogoView.getDrawable() : null;
    }

    public void setLogoDescription(@StringRes int resId) {
        setLogoDescription(getContext().getText(resId));
    }

    public void setLogoDescription(CharSequence description) {
        if (!TextUtils.isEmpty(description)) {
            ensureLogoView();
        }
        if (this.mLogoView != null) {
            this.mLogoView.setContentDescription(description);
        }
    }

    public CharSequence getLogoDescription() {
        return this.mLogoView != null ? this.mLogoView.getContentDescription() : null;
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new AppCompatImageView(getContext());
        }
    }

    public boolean hasExpandedActionView() {
        return (this.mExpandedMenuPresenter == null || this.mExpandedMenuPresenter.mCurrentExpandedItem == null) ? false : true;
    }

    public void collapseActionView() {
        MenuItemImpl item = this.mExpandedMenuPresenter == null ? null : this.mExpandedMenuPresenter.mCurrentExpandedItem;
        if (item != null) {
            item.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public void setTitle(@StringRes int resId) {
        setTitle(getContext().getText(resId));
    }

    public void setTitle(CharSequence title) {
        if (!TextUtils.isEmpty(title)) {
            if (this.mTitleTextView == null) {
                Context context = getContext();
                this.mTitleTextView = new AppCompatTextView(context);
                this.mTitleTextView.setSingleLine();
                this.mTitleTextView.setEllipsize(TruncateAt.END);
                if (this.mTitleTextAppearance != 0) {
                    this.mTitleTextView.setTextAppearance(context, this.mTitleTextAppearance);
                }
                if (this.mTitleTextColor != 0) {
                    this.mTitleTextView.setTextColor(this.mTitleTextColor);
                }
            }
            if (!isChildOrHidden(this.mTitleTextView)) {
                addSystemView(this.mTitleTextView, true);
            }
        } else if (this.mTitleTextView != null && isChildOrHidden(this.mTitleTextView)) {
            removeView(this.mTitleTextView);
            this.mHiddenViews.remove(this.mTitleTextView);
        }
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setText(title);
        }
        this.mTitleText = title;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public void setSubtitle(@StringRes int resId) {
        setSubtitle(getContext().getText(resId));
    }

    public void setSubtitle(CharSequence subtitle) {
        if (!TextUtils.isEmpty(subtitle)) {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                this.mSubtitleTextView = new AppCompatTextView(context);
                this.mSubtitleTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TruncateAt.END);
                if (this.mSubtitleTextAppearance != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, this.mSubtitleTextAppearance);
                }
                if (this.mSubtitleTextColor != 0) {
                    this.mSubtitleTextView.setTextColor(this.mSubtitleTextColor);
                }
            }
            if (!isChildOrHidden(this.mSubtitleTextView)) {
                addSystemView(this.mSubtitleTextView, true);
            }
        } else if (this.mSubtitleTextView != null && isChildOrHidden(this.mSubtitleTextView)) {
            removeView(this.mSubtitleTextView);
            this.mHiddenViews.remove(this.mSubtitleTextView);
        }
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setText(subtitle);
        }
        this.mSubtitleText = subtitle;
    }

    public void setTitleTextAppearance(Context context, @StyleRes int resId) {
        this.mTitleTextAppearance = resId;
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setTextAppearance(context, resId);
        }
    }

    public void setSubtitleTextAppearance(Context context, @StyleRes int resId) {
        this.mSubtitleTextAppearance = resId;
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setTextAppearance(context, resId);
        }
    }

    public void setTitleTextColor(@ColorInt int color) {
        this.mTitleTextColor = color;
        if (this.mTitleTextView != null) {
            this.mTitleTextView.setTextColor(color);
        }
    }

    public void setSubtitleTextColor(@ColorInt int color) {
        this.mSubtitleTextColor = color;
        if (this.mSubtitleTextView != null) {
            this.mSubtitleTextView.setTextColor(color);
        }
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        return this.mNavButtonView != null ? this.mNavButtonView.getContentDescription() : null;
    }

    public void setNavigationContentDescription(@StringRes int resId) {
        setNavigationContentDescription(resId != 0 ? getContext().getText(resId) : null);
    }

    public void setNavigationContentDescription(@Nullable CharSequence description) {
        if (!TextUtils.isEmpty(description)) {
            ensureNavButtonView();
        }
        if (this.mNavButtonView != null) {
            this.mNavButtonView.setContentDescription(description);
        }
    }

    public void setNavigationIcon(@DrawableRes int resId) {
        setNavigationIcon(AppCompatResources.getDrawable(getContext(), resId));
    }

    public void setNavigationIcon(@Nullable Drawable icon) {
        if (icon != null) {
            ensureNavButtonView();
            if (!isChildOrHidden(this.mNavButtonView)) {
                addSystemView(this.mNavButtonView, true);
            }
        } else if (this.mNavButtonView != null && isChildOrHidden(this.mNavButtonView)) {
            removeView(this.mNavButtonView);
            this.mHiddenViews.remove(this.mNavButtonView);
        }
        if (this.mNavButtonView != null) {
            this.mNavButtonView.setImageDrawable(icon);
        }
    }

    @Nullable
    public Drawable getNavigationIcon() {
        return this.mNavButtonView != null ? this.mNavButtonView.getDrawable() : null;
    }

    public void setNavigationOnClickListener(OnClickListener listener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(listener);
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public void setOverflowIcon(@Nullable Drawable icon) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(icon);
    }

    @Nullable
    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.peekMenu() == null) {
            MenuBuilder menu = (MenuBuilder) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            menu.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            this.mMenuView = new ActionMenuView(getContext());
            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            LayoutParams lp = generateDefaultLayoutParams();
            lp.gravity = GravityCompat.END | (this.mButtonGravity & C0394R.styleable.AppCompatTheme_spinnerStyle);
            this.mMenuView.setLayoutParams(lp);
            addSystemView(this.mMenuView, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    public void inflateMenu(@MenuRes int resId) {
        getMenuInflater().inflate(resId, getMenu());
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener listener) {
        this.mOnMenuItemClickListener = listener;
    }

    public void setContentInsetsRelative(int contentInsetStart, int contentInsetEnd) {
        ensureContentInsets();
        this.mContentInsets.setRelative(contentInsetStart, contentInsetEnd);
    }

    public int getContentInsetStart() {
        return this.mContentInsets != null ? this.mContentInsets.getStart() : 0;
    }

    public int getContentInsetEnd() {
        return this.mContentInsets != null ? this.mContentInsets.getEnd() : 0;
    }

    public void setContentInsetsAbsolute(int contentInsetLeft, int contentInsetRight) {
        ensureContentInsets();
        this.mContentInsets.setAbsolute(contentInsetLeft, contentInsetRight);
    }

    public int getContentInsetLeft() {
        return this.mContentInsets != null ? this.mContentInsets.getLeft() : 0;
    }

    public int getContentInsetRight() {
        return this.mContentInsets != null ? this.mContentInsets.getRight() : 0;
    }

    public int getContentInsetStartWithNavigation() {
        if (this.mContentInsetStartWithNavigation != RtlSpacingHelper.UNDEFINED) {
            return this.mContentInsetStartWithNavigation;
        }
        return getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int insetStartWithNavigation) {
        if (insetStartWithNavigation < 0) {
            insetStartWithNavigation = RtlSpacingHelper.UNDEFINED;
        }
        if (insetStartWithNavigation != this.mContentInsetStartWithNavigation) {
            this.mContentInsetStartWithNavigation = insetStartWithNavigation;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        if (this.mContentInsetEndWithActions != RtlSpacingHelper.UNDEFINED) {
            return this.mContentInsetEndWithActions;
        }
        return getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int insetEndWithActions) {
        if (insetEndWithActions < 0) {
            insetEndWithActions = RtlSpacingHelper.UNDEFINED;
        }
        if (insetEndWithActions != this.mContentInsetEndWithActions) {
            this.mContentInsetEndWithActions = insetEndWithActions;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        boolean hasActions = false;
        if (this.mMenuView != null) {
            MenuBuilder mb = this.mMenuView.peekMenu();
            if (mb == null || !mb.hasVisibleItems()) {
                hasActions = false;
            } else {
                hasActions = true;
            }
        }
        if (hasActions) {
            return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ViewCompat.getLayoutDirection(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new AppCompatImageButton(getContext(), null, C0236R.attr.toolbarNavigationButtonStyle);
            LayoutParams lp = generateDefaultLayoutParams();
            lp.gravity = MediaRouterJellybean.ALL_ROUTE_TYPES | (this.mButtonGravity & C0394R.styleable.AppCompatTheme_spinnerStyle);
            this.mNavButtonView.setLayoutParams(lp);
        }
    }

    void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            this.mCollapseButtonView = new AppCompatImageButton(getContext(), null, C0236R.attr.toolbarNavigationButtonStyle);
            this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            LayoutParams lp = generateDefaultLayoutParams();
            lp.gravity = MediaRouterJellybean.ALL_ROUTE_TYPES | (this.mButtonGravity & C0394R.styleable.AppCompatTheme_spinnerStyle);
            lp.mViewType = 2;
            this.mCollapseButtonView.setLayoutParams(lp);
            this.mCollapseButtonView.setOnClickListener(new C03373());
        }
    }

    private void addSystemView(View v, boolean allowHide) {
        LayoutParams lp;
        android.view.ViewGroup.LayoutParams vlp = v.getLayoutParams();
        if (vlp == null) {
            lp = generateDefaultLayoutParams();
        } else if (checkLayoutParams(vlp)) {
            lp = (LayoutParams) vlp;
        } else {
            lp = generateLayoutParams(vlp);
        }
        lp.mViewType = 1;
        if (!allowHide || this.mExpandedActionView == null) {
            addView(v, lp);
            return;
        }
        v.setLayoutParams(lp);
        this.mHiddenViews.add(v);
    }

    protected Parcelable onSaveInstanceState() {
        SavedState state = new SavedState(super.onSaveInstanceState());
        if (!(this.mExpandedMenuPresenter == null || this.mExpandedMenuPresenter.mCurrentExpandedItem == null)) {
            state.expandedMenuItemId = this.mExpandedMenuPresenter.mCurrentExpandedItem.getItemId();
        }
        state.isOverflowOpen = isOverflowMenuShowing();
        return state;
    }

    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof SavedState) {
            SavedState ss = (SavedState) state;
            super.onRestoreInstanceState(ss.getSuperState());
            Menu menu = this.mMenuView != null ? this.mMenuView.peekMenu() : null;
            if (!(ss.expandedMenuItemId == 0 || this.mExpandedMenuPresenter == null || menu == null)) {
                MenuItem item = menu.findItem(ss.expandedMenuItemId);
                if (item != null) {
                    MenuItemCompat.expandActionView(item);
                }
            }
            if (ss.isOverflowOpen) {
                postShowOverflowMenu();
                return;
            }
            return;
        }
        super.onRestoreInstanceState(state);
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    public boolean onTouchEvent(MotionEvent ev) {
        int action = MotionEventCompat.getActionMasked(ev);
        if (action == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean handled = super.onTouchEvent(ev);
            if (action == 0 && !handled) {
                this.mEatingTouch = true;
            }
        }
        if (action == 1 || action == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent ev) {
        int action = MotionEventCompat.getActionMasked(ev);
        if (action == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean handled = super.onHoverEvent(ev);
            if (action == 9 && !handled) {
                this.mEatingHover = true;
            }
        }
        if (action == 10 || action == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    private void measureChildConstrained(View child, int parentWidthSpec, int widthUsed, int parentHeightSpec, int heightUsed, int heightConstraint) {
        MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        int childWidthSpec = getChildMeasureSpec(parentWidthSpec, (((getPaddingLeft() + getPaddingRight()) + lp.leftMargin) + lp.rightMargin) + widthUsed, lp.width);
        int childHeightSpec = getChildMeasureSpec(parentHeightSpec, (((getPaddingTop() + getPaddingBottom()) + lp.topMargin) + lp.bottomMargin) + heightUsed, lp.height);
        int childHeightMode = MeasureSpec.getMode(childHeightSpec);
        if (childHeightMode != 1073741824 && heightConstraint >= 0) {
            childHeightSpec = MeasureSpec.makeMeasureSpec(childHeightMode != 0 ? Math.min(MeasureSpec.getSize(childHeightSpec), heightConstraint) : heightConstraint, 1073741824);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    private int measureChildCollapseMargins(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed, int[] collapsingMargins) {
        MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        int leftDiff = lp.leftMargin - collapsingMargins[0];
        int rightDiff = lp.rightMargin - collapsingMargins[1];
        int hMargins = Math.max(0, leftDiff) + Math.max(0, rightDiff);
        collapsingMargins[0] = Math.max(0, -leftDiff);
        collapsingMargins[1] = Math.max(0, -rightDiff);
        child.measure(getChildMeasureSpec(parentWidthMeasureSpec, ((getPaddingLeft() + getPaddingRight()) + hMargins) + widthUsed, lp.width), getChildMeasureSpec(parentHeightMeasureSpec, (((getPaddingTop() + getPaddingBottom()) + lp.topMargin) + lp.bottomMargin) + heightUsed, lp.height));
        return child.getMeasuredWidth() + hMargins;
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (shouldLayout(child) && child.getMeasuredWidth() > 0 && child.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int marginStartIndex;
        int marginEndIndex;
        int i;
        int height = 0;
        int childState = 0;
        int[] collapsingMargins = this.mTempMargins;
        if (ViewUtils.isLayoutRtl(this)) {
            marginStartIndex = 1;
            marginEndIndex = 0;
        } else {
            marginStartIndex = 0;
            marginEndIndex = 1;
        }
        int navWidth = 0;
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, widthMeasureSpec, 0, heightMeasureSpec, 0, this.mMaxButtonHeight);
            navWidth = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
            i = 0;
            height = Math.max(i, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
            childState = ViewUtils.combineMeasuredStates(0, ViewCompat.getMeasuredState(this.mNavButtonView));
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, widthMeasureSpec, 0, heightMeasureSpec, 0, this.mMaxButtonHeight);
            navWidth = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
            i = height;
            height = Math.max(i, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
            childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(this.mCollapseButtonView));
        }
        int contentInsetStart = getCurrentContentInsetStart();
        int width = 0 + Math.max(contentInsetStart, navWidth);
        collapsingMargins[marginStartIndex] = Math.max(0, contentInsetStart - navWidth);
        int menuWidth = 0;
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, widthMeasureSpec, width, heightMeasureSpec, 0, this.mMaxButtonHeight);
            menuWidth = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
            i = height;
            height = Math.max(i, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
            childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(this.mMenuView));
        }
        int contentInsetEnd = getCurrentContentInsetEnd();
        width += Math.max(contentInsetEnd, menuWidth);
        collapsingMargins[marginEndIndex] = Math.max(0, contentInsetEnd - menuWidth);
        if (shouldLayout(this.mExpandedActionView)) {
            width += measureChildCollapseMargins(this.mExpandedActionView, widthMeasureSpec, width, heightMeasureSpec, 0, collapsingMargins);
            i = height;
            height = Math.max(i, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
            childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(this.mExpandedActionView));
        }
        if (shouldLayout(this.mLogoView)) {
            width += measureChildCollapseMargins(this.mLogoView, widthMeasureSpec, width, heightMeasureSpec, 0, collapsingMargins);
            i = height;
            height = Math.max(i, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
            childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(this.mLogoView));
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = getChildAt(i2);
            if (((LayoutParams) child.getLayoutParams()).mViewType == 0 && shouldLayout(child)) {
                width += measureChildCollapseMargins(child, widthMeasureSpec, width, heightMeasureSpec, 0, collapsingMargins);
                height = Math.max(height, child.getMeasuredHeight() + getVerticalMargins(child));
                childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(child));
            }
        }
        int titleWidth = 0;
        int titleHeight = 0;
        int titleVertMargins = this.mTitleMarginTop + this.mTitleMarginBottom;
        int titleHorizMargins = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            titleWidth = measureChildCollapseMargins(this.mTitleTextView, widthMeasureSpec, width + titleHorizMargins, heightMeasureSpec, titleVertMargins, collapsingMargins);
            titleWidth = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
            titleHeight = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
            childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(this.mTitleTextView));
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            i = titleWidth;
            titleWidth = Math.max(i, measureChildCollapseMargins(this.mSubtitleTextView, widthMeasureSpec, width + titleHorizMargins, heightMeasureSpec, titleHeight + titleVertMargins, collapsingMargins));
            titleHeight += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
            childState = ViewUtils.combineMeasuredStates(childState, ViewCompat.getMeasuredState(this.mSubtitleTextView));
        }
        width += titleWidth;
        height = Math.max(height, titleHeight) + (getPaddingTop() + getPaddingBottom());
        i = widthMeasureSpec;
        int measuredWidth = ViewCompat.resolveSizeAndState(Math.max(width + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, ViewCompat.MEASURED_STATE_MASK & childState);
        i = heightMeasureSpec;
        int measuredHeight = ViewCompat.resolveSizeAndState(Math.max(height, getSuggestedMinimumHeight()), i, childState << 16);
        if (shouldCollapse()) {
            measuredHeight = 0;
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onLayout(boolean r53, int r54, int r55, int r56, int r57) {
        /*
        r52 = this;
        r49 = android.support.v4.view.ViewCompat.getLayoutDirection(r52);
        r50 = 1;
        r0 = r49;
        r1 = r50;
        if (r0 != r1) goto L_0x0320;
    L_0x000c:
        r18 = 1;
    L_0x000e:
        r48 = r52.getWidth();
        r16 = r52.getHeight();
        r27 = r52.getPaddingLeft();
        r28 = r52.getPaddingRight();
        r29 = r52.getPaddingTop();
        r26 = r52.getPaddingBottom();
        r22 = r27;
        r32 = r48 - r28;
        r0 = r52;
        r12 = r0.mTempMargins;
        r49 = 0;
        r50 = 1;
        r51 = 0;
        r12[r50] = r51;
        r12[r49] = r51;
        r25 = android.support.v4.view.ViewCompat.getMinimumHeight(r52);
        if (r25 < 0) goto L_0x0324;
    L_0x003e:
        r49 = r57 - r55;
        r0 = r25;
        r1 = r49;
        r5 = java.lang.Math.min(r0, r1);
    L_0x0048:
        r0 = r52;
        r0 = r0.mNavButtonView;
        r49 = r0;
        r0 = r52;
        r1 = r49;
        r49 = r0.shouldLayout(r1);
        if (r49 == 0) goto L_0x006a;
    L_0x0058:
        if (r18 == 0) goto L_0x0327;
    L_0x005a:
        r0 = r52;
        r0 = r0.mNavButtonView;
        r49 = r0;
        r0 = r52;
        r1 = r49;
        r2 = r32;
        r32 = r0.layoutChildRight(r1, r2, r12, r5);
    L_0x006a:
        r0 = r52;
        r0 = r0.mCollapseButtonView;
        r49 = r0;
        r0 = r52;
        r1 = r49;
        r49 = r0.shouldLayout(r1);
        if (r49 == 0) goto L_0x008c;
    L_0x007a:
        if (r18 == 0) goto L_0x0339;
    L_0x007c:
        r0 = r52;
        r0 = r0.mCollapseButtonView;
        r49 = r0;
        r0 = r52;
        r1 = r49;
        r2 = r32;
        r32 = r0.layoutChildRight(r1, r2, r12, r5);
    L_0x008c:
        r0 = r52;
        r0 = r0.mMenuView;
        r49 = r0;
        r0 = r52;
        r1 = r49;
        r49 = r0.shouldLayout(r1);
        if (r49 == 0) goto L_0x00ae;
    L_0x009c:
        if (r18 == 0) goto L_0x034b;
    L_0x009e:
        r0 = r52;
        r0 = r0.mMenuView;
        r49 = r0;
        r0 = r52;
        r1 = r49;
        r2 = r22;
        r22 = r0.layoutChildLeft(r1, r2, r12, r5);
    L_0x00ae:
        r13 = r52.getCurrentContentInsetLeft();
        r14 = r52.getCurrentContentInsetRight();
        r49 = 0;
        r50 = 0;
        r51 = r13 - r22;
        r50 = java.lang.Math.max(r50, r51);
        r12[r49] = r50;
        r49 = 1;
        r50 = 0;
        r51 = r48 - r28;
        r51 = r51 - r32;
        r51 = r14 - r51;
        r50 = java.lang.Math.max(r50, r51);
        r12[r49] = r50;
        r0 = r22;
        r22 = java.lang.Math.max(r0, r13);
        r49 = r48 - r28;
        r49 = r49 - r14;
        r0 = r32;
        r1 = r49;
        r32 = java.lang.Math.min(r0, r1);
        r0 = r52;
        r0 = r0.mExpandedActionView;
        r49 = r0;
        r0 = r52;
        r1 = r49;
        r49 = r0.shouldLayout(r1);
        if (r49 == 0) goto L_0x0106;
    L_0x00f4:
        if (r18 == 0) goto L_0x035d;
    L_0x00f6:
        r0 = r52;
        r0 = r0.mExpandedActionView;
        r49 = r0;
        r0 = r52;
        r1 = r49;
        r2 = r32;
        r32 = r0.layoutChildRight(r1, r2, r12, r5);
    L_0x0106:
        r0 = r52;
        r0 = r0.mLogoView;
        r49 = r0;
        r0 = r52;
        r1 = r49;
        r49 = r0.shouldLayout(r1);
        if (r49 == 0) goto L_0x0128;
    L_0x0116:
        if (r18 == 0) goto L_0x036f;
    L_0x0118:
        r0 = r52;
        r0 = r0.mLogoView;
        r49 = r0;
        r0 = r52;
        r1 = r49;
        r2 = r32;
        r32 = r0.layoutChildRight(r1, r2, r12, r5);
    L_0x0128:
        r0 = r52;
        r0 = r0.mTitleTextView;
        r49 = r0;
        r0 = r52;
        r1 = r49;
        r20 = r0.shouldLayout(r1);
        r0 = r52;
        r0 = r0.mSubtitleTextView;
        r49 = r0;
        r0 = r52;
        r1 = r49;
        r19 = r0.shouldLayout(r1);
        r42 = 0;
        if (r20 == 0) goto L_0x0170;
    L_0x0148:
        r0 = r52;
        r0 = r0.mTitleTextView;
        r49 = r0;
        r24 = r49.getLayoutParams();
        r24 = (android.support.v7.widget.Toolbar.LayoutParams) r24;
        r0 = r24;
        r0 = r0.topMargin;
        r49 = r0;
        r0 = r52;
        r0 = r0.mTitleTextView;
        r50 = r0;
        r50 = r50.getMeasuredHeight();
        r49 = r49 + r50;
        r0 = r24;
        r0 = r0.bottomMargin;
        r50 = r0;
        r49 = r49 + r50;
        r42 = r42 + r49;
    L_0x0170:
        if (r19 == 0) goto L_0x019a;
    L_0x0172:
        r0 = r52;
        r0 = r0.mSubtitleTextView;
        r49 = r0;
        r24 = r49.getLayoutParams();
        r24 = (android.support.v7.widget.Toolbar.LayoutParams) r24;
        r0 = r24;
        r0 = r0.topMargin;
        r49 = r0;
        r0 = r52;
        r0 = r0.mSubtitleTextView;
        r50 = r0;
        r50 = r50.getMeasuredHeight();
        r49 = r49 + r50;
        r0 = r24;
        r0 = r0.bottomMargin;
        r50 = r0;
        r49 = r49 + r50;
        r42 = r42 + r49;
    L_0x019a:
        if (r20 != 0) goto L_0x019e;
    L_0x019c:
        if (r19 == 0) goto L_0x02e0;
    L_0x019e:
        if (r20 == 0) goto L_0x0381;
    L_0x01a0:
        r0 = r52;
        r0 = r0.mTitleTextView;
        r46 = r0;
    L_0x01a6:
        if (r19 == 0) goto L_0x0389;
    L_0x01a8:
        r0 = r52;
        r6 = r0.mSubtitleTextView;
    L_0x01ac:
        r47 = r46.getLayoutParams();
        r47 = (android.support.v7.widget.Toolbar.LayoutParams) r47;
        r7 = r6.getLayoutParams();
        r7 = (android.support.v7.widget.Toolbar.LayoutParams) r7;
        if (r20 == 0) goto L_0x01c6;
    L_0x01ba:
        r0 = r52;
        r0 = r0.mTitleTextView;
        r49 = r0;
        r49 = r49.getMeasuredWidth();
        if (r49 > 0) goto L_0x01d4;
    L_0x01c6:
        if (r19 == 0) goto L_0x038f;
    L_0x01c8:
        r0 = r52;
        r0 = r0.mSubtitleTextView;
        r49 = r0;
        r49 = r49.getMeasuredWidth();
        if (r49 <= 0) goto L_0x038f;
    L_0x01d4:
        r41 = 1;
    L_0x01d6:
        r0 = r52;
        r0 = r0.mGravity;
        r49 = r0;
        r49 = r49 & 112;
        switch(r49) {
            case 48: goto L_0x0393;
            case 80: goto L_0x03dd;
            default: goto L_0x01e1;
        };
    L_0x01e1:
        r49 = r16 - r29;
        r34 = r49 - r26;
        r49 = r34 - r42;
        r35 = r49 / 2;
        r0 = r47;
        r0 = r0.topMargin;
        r49 = r0;
        r0 = r52;
        r0 = r0.mTitleMarginTop;
        r50 = r0;
        r49 = r49 + r50;
        r0 = r35;
        r1 = r49;
        if (r0 >= r1) goto L_0x03a9;
    L_0x01fd:
        r0 = r47;
        r0 = r0.topMargin;
        r49 = r0;
        r0 = r52;
        r0 = r0.mTitleMarginTop;
        r50 = r0;
        r35 = r49 + r50;
    L_0x020b:
        r45 = r29 + r35;
    L_0x020d:
        if (r18 == 0) goto L_0x03f5;
    L_0x020f:
        if (r41 == 0) goto L_0x03f1;
    L_0x0211:
        r0 = r52;
        r0 = r0.mTitleMarginStart;
        r49 = r0;
    L_0x0217:
        r50 = 1;
        r50 = r12[r50];
        r31 = r49 - r50;
        r49 = 0;
        r0 = r49;
        r1 = r31;
        r49 = java.lang.Math.max(r0, r1);
        r32 = r32 - r49;
        r49 = 1;
        r50 = 0;
        r0 = r31;
        r0 = -r0;
        r51 = r0;
        r50 = java.lang.Math.max(r50, r51);
        r12[r49] = r50;
        r44 = r32;
        r39 = r32;
        if (r20 == 0) goto L_0x0285;
    L_0x023e:
        r0 = r52;
        r0 = r0.mTitleTextView;
        r49 = r0;
        r24 = r49.getLayoutParams();
        r24 = (android.support.v7.widget.Toolbar.LayoutParams) r24;
        r0 = r52;
        r0 = r0.mTitleTextView;
        r49 = r0;
        r49 = r49.getMeasuredWidth();
        r43 = r44 - r49;
        r0 = r52;
        r0 = r0.mTitleTextView;
        r49 = r0;
        r49 = r49.getMeasuredHeight();
        r40 = r45 + r49;
        r0 = r52;
        r0 = r0.mTitleTextView;
        r49 = r0;
        r0 = r49;
        r1 = r43;
        r2 = r45;
        r3 = r44;
        r4 = r40;
        r0.layout(r1, r2, r3, r4);
        r0 = r52;
        r0 = r0.mTitleMarginEnd;
        r49 = r0;
        r44 = r43 - r49;
        r0 = r24;
        r0 = r0.bottomMargin;
        r49 = r0;
        r45 = r40 + r49;
    L_0x0285:
        if (r19 == 0) goto L_0x02d6;
    L_0x0287:
        r0 = r52;
        r0 = r0.mSubtitleTextView;
        r49 = r0;
        r24 = r49.getLayoutParams();
        r24 = (android.support.v7.widget.Toolbar.LayoutParams) r24;
        r0 = r24;
        r0 = r0.topMargin;
        r49 = r0;
        r45 = r45 + r49;
        r0 = r52;
        r0 = r0.mSubtitleTextView;
        r49 = r0;
        r49 = r49.getMeasuredWidth();
        r38 = r39 - r49;
        r0 = r52;
        r0 = r0.mSubtitleTextView;
        r49 = r0;
        r49 = r49.getMeasuredHeight();
        r37 = r45 + r49;
        r0 = r52;
        r0 = r0.mSubtitleTextView;
        r49 = r0;
        r0 = r49;
        r1 = r38;
        r2 = r45;
        r3 = r39;
        r4 = r37;
        r0.layout(r1, r2, r3, r4);
        r0 = r52;
        r0 = r0.mTitleMarginEnd;
        r49 = r0;
        r39 = r39 - r49;
        r0 = r24;
        r0 = r0.bottomMargin;
        r49 = r0;
        r45 = r37 + r49;
    L_0x02d6:
        if (r41 == 0) goto L_0x02e0;
    L_0x02d8:
        r0 = r44;
        r1 = r39;
        r32 = java.lang.Math.min(r0, r1);
    L_0x02e0:
        r0 = r52;
        r0 = r0.mTempViews;
        r49 = r0;
        r50 = 3;
        r0 = r52;
        r1 = r49;
        r2 = r50;
        r0.addCustomViewsWithGravity(r1, r2);
        r0 = r52;
        r0 = r0.mTempViews;
        r49 = r0;
        r23 = r49.size();
        r17 = 0;
    L_0x02fd:
        r0 = r17;
        r1 = r23;
        if (r0 >= r1) goto L_0x04cc;
    L_0x0303:
        r0 = r52;
        r0 = r0.mTempViews;
        r49 = r0;
        r0 = r49;
        r1 = r17;
        r49 = r0.get(r1);
        r49 = (android.view.View) r49;
        r0 = r52;
        r1 = r49;
        r2 = r22;
        r22 = r0.layoutChildLeft(r1, r2, r12, r5);
        r17 = r17 + 1;
        goto L_0x02fd;
    L_0x0320:
        r18 = 0;
        goto L_0x000e;
    L_0x0324:
        r5 = 0;
        goto L_0x0048;
    L_0x0327:
        r0 = r52;
        r0 = r0.mNavButtonView;
        r49 = r0;
        r0 = r52;
        r1 = r49;
        r2 = r22;
        r22 = r0.layoutChildLeft(r1, r2, r12, r5);
        goto L_0x006a;
    L_0x0339:
        r0 = r52;
        r0 = r0.mCollapseButtonView;
        r49 = r0;
        r0 = r52;
        r1 = r49;
        r2 = r22;
        r22 = r0.layoutChildLeft(r1, r2, r12, r5);
        goto L_0x008c;
    L_0x034b:
        r0 = r52;
        r0 = r0.mMenuView;
        r49 = r0;
        r0 = r52;
        r1 = r49;
        r2 = r32;
        r32 = r0.layoutChildRight(r1, r2, r12, r5);
        goto L_0x00ae;
    L_0x035d:
        r0 = r52;
        r0 = r0.mExpandedActionView;
        r49 = r0;
        r0 = r52;
        r1 = r49;
        r2 = r22;
        r22 = r0.layoutChildLeft(r1, r2, r12, r5);
        goto L_0x0106;
    L_0x036f:
        r0 = r52;
        r0 = r0.mLogoView;
        r49 = r0;
        r0 = r52;
        r1 = r49;
        r2 = r22;
        r22 = r0.layoutChildLeft(r1, r2, r12, r5);
        goto L_0x0128;
    L_0x0381:
        r0 = r52;
        r0 = r0.mSubtitleTextView;
        r46 = r0;
        goto L_0x01a6;
    L_0x0389:
        r0 = r52;
        r6 = r0.mTitleTextView;
        goto L_0x01ac;
    L_0x038f:
        r41 = 0;
        goto L_0x01d6;
    L_0x0393:
        r49 = r52.getPaddingTop();
        r0 = r47;
        r0 = r0.topMargin;
        r50 = r0;
        r49 = r49 + r50;
        r0 = r52;
        r0 = r0.mTitleMarginTop;
        r50 = r0;
        r45 = r49 + r50;
        goto L_0x020d;
    L_0x03a9:
        r49 = r16 - r26;
        r49 = r49 - r42;
        r49 = r49 - r35;
        r36 = r49 - r29;
        r0 = r47;
        r0 = r0.bottomMargin;
        r49 = r0;
        r0 = r52;
        r0 = r0.mTitleMarginBottom;
        r50 = r0;
        r49 = r49 + r50;
        r0 = r36;
        r1 = r49;
        if (r0 >= r1) goto L_0x020b;
    L_0x03c5:
        r49 = 0;
        r0 = r7.bottomMargin;
        r50 = r0;
        r0 = r52;
        r0 = r0.mTitleMarginBottom;
        r51 = r0;
        r50 = r50 + r51;
        r50 = r50 - r36;
        r50 = r35 - r50;
        r35 = java.lang.Math.max(r49, r50);
        goto L_0x020b;
    L_0x03dd:
        r49 = r16 - r26;
        r0 = r7.bottomMargin;
        r50 = r0;
        r49 = r49 - r50;
        r0 = r52;
        r0 = r0.mTitleMarginBottom;
        r50 = r0;
        r49 = r49 - r50;
        r45 = r49 - r42;
        goto L_0x020d;
    L_0x03f1:
        r49 = 0;
        goto L_0x0217;
    L_0x03f5:
        if (r41 == 0) goto L_0x04c8;
    L_0x03f7:
        r0 = r52;
        r0 = r0.mTitleMarginStart;
        r49 = r0;
    L_0x03fd:
        r50 = 0;
        r50 = r12[r50];
        r21 = r49 - r50;
        r49 = 0;
        r0 = r49;
        r1 = r21;
        r49 = java.lang.Math.max(r0, r1);
        r22 = r22 + r49;
        r49 = 0;
        r50 = 0;
        r0 = r21;
        r0 = -r0;
        r51 = r0;
        r50 = java.lang.Math.max(r50, r51);
        r12[r49] = r50;
        r43 = r22;
        r38 = r22;
        if (r20 == 0) goto L_0x046b;
    L_0x0424:
        r0 = r52;
        r0 = r0.mTitleTextView;
        r49 = r0;
        r24 = r49.getLayoutParams();
        r24 = (android.support.v7.widget.Toolbar.LayoutParams) r24;
        r0 = r52;
        r0 = r0.mTitleTextView;
        r49 = r0;
        r49 = r49.getMeasuredWidth();
        r44 = r43 + r49;
        r0 = r52;
        r0 = r0.mTitleTextView;
        r49 = r0;
        r49 = r49.getMeasuredHeight();
        r40 = r45 + r49;
        r0 = r52;
        r0 = r0.mTitleTextView;
        r49 = r0;
        r0 = r49;
        r1 = r43;
        r2 = r45;
        r3 = r44;
        r4 = r40;
        r0.layout(r1, r2, r3, r4);
        r0 = r52;
        r0 = r0.mTitleMarginEnd;
        r49 = r0;
        r43 = r44 + r49;
        r0 = r24;
        r0 = r0.bottomMargin;
        r49 = r0;
        r45 = r40 + r49;
    L_0x046b:
        if (r19 == 0) goto L_0x04bc;
    L_0x046d:
        r0 = r52;
        r0 = r0.mSubtitleTextView;
        r49 = r0;
        r24 = r49.getLayoutParams();
        r24 = (android.support.v7.widget.Toolbar.LayoutParams) r24;
        r0 = r24;
        r0 = r0.topMargin;
        r49 = r0;
        r45 = r45 + r49;
        r0 = r52;
        r0 = r0.mSubtitleTextView;
        r49 = r0;
        r49 = r49.getMeasuredWidth();
        r39 = r38 + r49;
        r0 = r52;
        r0 = r0.mSubtitleTextView;
        r49 = r0;
        r49 = r49.getMeasuredHeight();
        r37 = r45 + r49;
        r0 = r52;
        r0 = r0.mSubtitleTextView;
        r49 = r0;
        r0 = r49;
        r1 = r38;
        r2 = r45;
        r3 = r39;
        r4 = r37;
        r0.layout(r1, r2, r3, r4);
        r0 = r52;
        r0 = r0.mTitleMarginEnd;
        r49 = r0;
        r38 = r39 + r49;
        r0 = r24;
        r0 = r0.bottomMargin;
        r49 = r0;
        r45 = r37 + r49;
    L_0x04bc:
        if (r41 == 0) goto L_0x02e0;
    L_0x04be:
        r0 = r43;
        r1 = r38;
        r22 = java.lang.Math.max(r0, r1);
        goto L_0x02e0;
    L_0x04c8:
        r49 = 0;
        goto L_0x03fd;
    L_0x04cc:
        r0 = r52;
        r0 = r0.mTempViews;
        r49 = r0;
        r50 = 5;
        r0 = r52;
        r1 = r49;
        r2 = r50;
        r0.addCustomViewsWithGravity(r1, r2);
        r0 = r52;
        r0 = r0.mTempViews;
        r49 = r0;
        r33 = r49.size();
        r17 = 0;
    L_0x04e9:
        r0 = r17;
        r1 = r33;
        if (r0 >= r1) goto L_0x050c;
    L_0x04ef:
        r0 = r52;
        r0 = r0.mTempViews;
        r49 = r0;
        r0 = r49;
        r1 = r17;
        r49 = r0.get(r1);
        r49 = (android.view.View) r49;
        r0 = r52;
        r1 = r49;
        r2 = r32;
        r32 = r0.layoutChildRight(r1, r2, r12, r5);
        r17 = r17 + 1;
        goto L_0x04e9;
    L_0x050c:
        r0 = r52;
        r0 = r0.mTempViews;
        r49 = r0;
        r50 = 1;
        r0 = r52;
        r1 = r49;
        r2 = r50;
        r0.addCustomViewsWithGravity(r1, r2);
        r0 = r52;
        r0 = r0.mTempViews;
        r49 = r0;
        r0 = r52;
        r1 = r49;
        r11 = r0.getViewListMeasuredWidth(r1, r12);
        r49 = r48 - r27;
        r49 = r49 - r28;
        r49 = r49 / 2;
        r30 = r27 + r49;
        r15 = r11 / 2;
        r8 = r30 - r15;
        r9 = r8 + r11;
        r0 = r22;
        if (r8 >= r0) goto L_0x056a;
    L_0x053d:
        r8 = r22;
    L_0x053f:
        r0 = r52;
        r0 = r0.mTempViews;
        r49 = r0;
        r10 = r49.size();
        r17 = 0;
    L_0x054b:
        r0 = r17;
        if (r0 >= r10) goto L_0x0573;
    L_0x054f:
        r0 = r52;
        r0 = r0.mTempViews;
        r49 = r0;
        r0 = r49;
        r1 = r17;
        r49 = r0.get(r1);
        r49 = (android.view.View) r49;
        r0 = r52;
        r1 = r49;
        r8 = r0.layoutChildLeft(r1, r8, r12, r5);
        r17 = r17 + 1;
        goto L_0x054b;
    L_0x056a:
        r0 = r32;
        if (r9 <= r0) goto L_0x053f;
    L_0x056e:
        r49 = r9 - r32;
        r8 = r8 - r49;
        goto L_0x053f;
    L_0x0573:
        r0 = r52;
        r0 = r0.mTempViews;
        r49 = r0;
        r49.clear();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    private int getViewListMeasuredWidth(List<View> views, int[] collapsingMargins) {
        int collapseLeft = collapsingMargins[0];
        int collapseRight = collapsingMargins[1];
        int width = 0;
        int count = views.size();
        for (int i = 0; i < count; i++) {
            View v = (View) views.get(i);
            LayoutParams lp = (LayoutParams) v.getLayoutParams();
            int l = lp.leftMargin - collapseLeft;
            int r = lp.rightMargin - collapseRight;
            int leftMargin = Math.max(0, l);
            int rightMargin = Math.max(0, r);
            collapseLeft = Math.max(0, -l);
            collapseRight = Math.max(0, -r);
            width += (v.getMeasuredWidth() + leftMargin) + rightMargin;
        }
        return width;
    }

    private int layoutChildLeft(View child, int left, int[] collapsingMargins, int alignmentHeight) {
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        int l = lp.leftMargin - collapsingMargins[0];
        left += Math.max(0, l);
        collapsingMargins[0] = Math.max(0, -l);
        int top = getChildTop(child, alignmentHeight);
        int childWidth = child.getMeasuredWidth();
        child.layout(left, top, left + childWidth, child.getMeasuredHeight() + top);
        return left + (lp.rightMargin + childWidth);
    }

    private int layoutChildRight(View child, int right, int[] collapsingMargins, int alignmentHeight) {
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        int r = lp.rightMargin - collapsingMargins[1];
        right -= Math.max(0, r);
        collapsingMargins[1] = Math.max(0, -r);
        int top = getChildTop(child, alignmentHeight);
        int childWidth = child.getMeasuredWidth();
        child.layout(right - childWidth, top, right, child.getMeasuredHeight() + top);
        return right - (lp.leftMargin + childWidth);
    }

    private int getChildTop(View child, int alignmentHeight) {
        int alignmentOffset;
        LayoutParams lp = (LayoutParams) child.getLayoutParams();
        int childHeight = child.getMeasuredHeight();
        if (alignmentHeight > 0) {
            alignmentOffset = (childHeight - alignmentHeight) / 2;
        } else {
            alignmentOffset = 0;
        }
        switch (getChildVerticalGravity(lp.gravity)) {
            case C0394R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                return getPaddingTop() - alignmentOffset;
            case C0394R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                return (((getHeight() - getPaddingBottom()) - childHeight) - lp.bottomMargin) - alignmentOffset;
            default:
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int spaceAbove = (((height - paddingTop) - paddingBottom) - childHeight) / 2;
                if (spaceAbove < lp.topMargin) {
                    spaceAbove = lp.topMargin;
                } else {
                    int spaceBelow = (((height - paddingBottom) - childHeight) - spaceAbove) - paddingTop;
                    if (spaceBelow < lp.bottomMargin) {
                        spaceAbove = Math.max(0, spaceAbove - (lp.bottomMargin - spaceBelow));
                    }
                }
                return paddingTop + spaceAbove;
        }
    }

    private int getChildVerticalGravity(int gravity) {
        int vgrav = gravity & C0394R.styleable.AppCompatTheme_spinnerStyle;
        switch (vgrav) {
            case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
            case C0394R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
            case C0394R.styleable.AppCompatTheme_panelMenuListWidth /*80*/:
                return vgrav;
            default:
                return this.mGravity & C0394R.styleable.AppCompatTheme_spinnerStyle;
        }
    }

    private void addCustomViewsWithGravity(List<View> views, int gravity) {
        boolean isRtl = true;
        if (ViewCompat.getLayoutDirection(this) != 1) {
            isRtl = false;
        }
        int childCount = getChildCount();
        int absGrav = GravityCompat.getAbsoluteGravity(gravity, ViewCompat.getLayoutDirection(this));
        views.clear();
        int i;
        View child;
        LayoutParams lp;
        if (isRtl) {
            for (i = childCount - 1; i >= 0; i--) {
                child = getChildAt(i);
                lp = (LayoutParams) child.getLayoutParams();
                if (lp.mViewType == 0 && shouldLayout(child) && getChildHorizontalGravity(lp.gravity) == absGrav) {
                    views.add(child);
                }
            }
            return;
        }
        for (i = 0; i < childCount; i++) {
            child = getChildAt(i);
            lp = (LayoutParams) child.getLayoutParams();
            if (lp.mViewType == 0 && shouldLayout(child) && getChildHorizontalGravity(lp.gravity) == absGrav) {
                views.add(child);
            }
        }
    }

    private int getChildHorizontalGravity(int gravity) {
        int ld = ViewCompat.getLayoutDirection(this);
        int hGrav = GravityCompat.getAbsoluteGravity(gravity, ld) & 7;
        switch (hGrav) {
            case MessageApi.FILTER_PREFIX /*1*/:
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
            case Dimension.UNIT_MM /*5*/:
                return hGrav;
            default:
                return ld == 1 ? 5 : 3;
        }
    }

    private boolean shouldLayout(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int getHorizontalMargins(View v) {
        MarginLayoutParams mlp = (MarginLayoutParams) v.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginStart(mlp) + MarginLayoutParamsCompat.getMarginEnd(mlp);
    }

    private int getVerticalMargins(View v) {
        MarginLayoutParams mlp = (MarginLayoutParams) v.getLayoutParams();
        return mlp.topMargin + mlp.bottomMargin;
    }

    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams p) {
        if (p instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) p);
        }
        if (p instanceof android.support.v7.app.ActionBar.LayoutParams) {
            return new LayoutParams((android.support.v7.app.ActionBar.LayoutParams) p);
        }
        if (p instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) p);
        }
        return new LayoutParams(p);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams p) {
        return super.checkLayoutParams(p) && (p instanceof LayoutParams);
    }

    private static boolean isCustomView(View child) {
        return ((LayoutParams) child.getLayoutParams()).mViewType == 0;
    }

    public DecorToolbar getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new ToolbarWidgetWrapper(this, true);
        }
        return this.mWrapper;
    }

    void removeChildrenForExpandedActionView() {
        for (int i = getChildCount() - 1; i >= 0; i--) {
            View child = getChildAt(i);
            if (!(((LayoutParams) child.getLayoutParams()).mViewType == 2 || child == this.mMenuView)) {
                removeViewAt(i);
                this.mHiddenViews.add(child);
            }
        }
    }

    void addChildrenForExpandedActionView() {
        for (int i = this.mHiddenViews.size() - 1; i >= 0; i--) {
            addView((View) this.mHiddenViews.get(i));
        }
        this.mHiddenViews.clear();
    }

    private boolean isChildOrHidden(View child) {
        return child.getParent() == this || this.mHiddenViews.contains(child);
    }

    public void setCollapsible(boolean collapsible) {
        this.mCollapsible = collapsible;
        requestLayout();
    }

    public void setMenuCallbacks(Callback pcb, MenuBuilder.Callback mcb) {
        this.mActionMenuPresenterCallback = pcb;
        this.mMenuBuilderCallback = mcb;
        if (this.mMenuView != null) {
            this.mMenuView.setMenuCallbacks(pcb, mcb);
        }
    }

    private void ensureContentInsets() {
        if (this.mContentInsets == null) {
            this.mContentInsets = new RtlSpacingHelper();
        }
    }
}
