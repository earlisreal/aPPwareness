package com.github.paolorotolo.appintro;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import java.lang.reflect.Field;

public final class AppIntroViewPager extends ViewPager {
    private static final int ON_ILLEGALLY_REQUESTED_NEXT_PAGE_MAX_INTERVAL = 1000;
    private float currentTouchDownX;
    private long illegallyRequestedNextPageLastCalled;
    private int lockPage;
    private ScrollerCustomDuration mScroller;
    private OnNextPageRequestedListener nextPageRequestedListener;
    private boolean nextPagingEnabled;
    private OnPageChangeListener pageChangeListener;
    private boolean pagingEnabled;

    public interface OnNextPageRequestedListener {
        boolean onCanRequestNextPage();

        void onIllegallyRequestedNextPage();
    }

    public AppIntroViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mScroller = null;
        this.pagingEnabled = true;
        this.nextPagingEnabled = true;
        this.lockPage = 0;
        initViewPagerScroller();
    }

    public void addOnPageChangeListener(OnPageChangeListener listener) {
        super.addOnPageChangeListener(listener);
        this.pageChangeListener = listener;
    }

    public void setCurrentItem(int item) {
        boolean invokeMeLater = false;
        if (super.getCurrentItem() == 0 && item == 0) {
            invokeMeLater = true;
        }
        super.setCurrentItem(item);
        if (invokeMeLater && this.pageChangeListener != null) {
            this.pageChangeListener.onPageSelected(0);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (event.getAction() == 0) {
            this.currentTouchDownX = event.getX();
            return super.onInterceptTouchEvent(event);
        } else if (!checkPagingState(event) && !checkCanRequestNextPage(event)) {
            return super.onInterceptTouchEvent(event);
        } else {
            checkIllegallyRequestedNextPage(event);
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == 0) {
            this.currentTouchDownX = event.getX();
            return super.onTouchEvent(event);
        } else if (!checkPagingState(event) && !checkCanRequestNextPage(event)) {
            return super.onTouchEvent(event);
        } else {
            checkIllegallyRequestedNextPage(event);
            return false;
        }
    }

    private boolean checkPagingState(MotionEvent event) {
        if (!this.pagingEnabled) {
            return true;
        }
        if (!this.nextPagingEnabled) {
            if (event.getAction() == 0) {
                this.currentTouchDownX = event.getX();
            }
            if (event.getAction() == 2 && detectSwipeToRight(event)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCanRequestNextPage(MotionEvent event) {
        return (this.nextPageRequestedListener == null || this.nextPageRequestedListener.onCanRequestNextPage()) ? false : true;
    }

    private void checkIllegallyRequestedNextPage(MotionEvent event) {
        if (event.getAction() == 2 && Math.abs(event.getX() - this.currentTouchDownX) >= ((float) 25) && System.currentTimeMillis() - this.illegallyRequestedNextPageLastCalled >= 1000) {
            this.illegallyRequestedNextPageLastCalled = System.currentTimeMillis();
            if (this.nextPageRequestedListener != null) {
                this.nextPageRequestedListener.onIllegallyRequestedNextPage();
            }
        }
    }

    private void initViewPagerScroller() {
        try {
            Field scroller = ViewPager.class.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            Field interpolator = ViewPager.class.getDeclaredField("sInterpolator");
            interpolator.setAccessible(true);
            this.mScroller = new ScrollerCustomDuration(getContext(), (Interpolator) interpolator.get(null));
            scroller.set(this, this.mScroller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean detectSwipeToRight(MotionEvent event) {
        try {
            float diffX = event.getX() - this.currentTouchDownX;
            if (Math.abs(diffX) <= 0.0f || diffX >= 0.0f) {
                return false;
            }
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public void setOnNextPageRequestedListener(OnNextPageRequestedListener nextPageRequestedListener) {
        this.nextPageRequestedListener = nextPageRequestedListener;
    }

    public void setScrollDurationFactor(double scrollFactor) {
        this.mScroller.setScrollDurationFactor(scrollFactor);
    }

    public boolean isNextPagingEnabled() {
        return this.nextPagingEnabled;
    }

    public void setNextPagingEnabled(boolean nextPagingEnabled) {
        this.nextPagingEnabled = nextPagingEnabled;
        if (!nextPagingEnabled) {
            this.lockPage = getCurrentItem();
        }
    }

    public boolean isPagingEnabled() {
        return this.pagingEnabled;
    }

    public void setPagingEnabled(boolean pagingEnabled) {
        this.pagingEnabled = pagingEnabled;
    }

    public int getLockPage() {
        return this.lockPage;
    }

    public void setLockPage(int lockPage) {
        this.lockPage = lockPage;
    }
}
