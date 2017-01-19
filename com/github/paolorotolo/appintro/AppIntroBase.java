package com.github.paolorotolo.appintro;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.PageTransformer;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.github.paolorotolo.appintro.AppIntroViewPager.OnNextPageRequestedListener;
import com.github.paolorotolo.appintro.util.LogHelper;
import com.google.android.gms.nearby.connection.Connections;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public abstract class AppIntroBase extends AppCompatActivity implements OnNextPageRequestedListener {
    public static final int DEFAULT_COLOR = 1;
    private static final int DEFAULT_SCROLL_DURATION_FACTOR = 1;
    private static final String INSTANCE_DATA_COLOR_TRANSITIONS_ENABLED = "com.github.paolorotolo.appintro_color_transitions_enabled";
    private static final String INSTANCE_DATA_IMMERSIVE_MODE_ENABLED = "com.github.paolorotolo.appintro_immersive_mode_enabled";
    private static final String INSTANCE_DATA_IMMERSIVE_MODE_STICKY = "com.github.paolorotolo.appintro_immersive_mode_sticky";
    private static final int PERMISSIONS_REQUEST_ALL_PERMISSIONS = 1;
    private static final String TAG;
    private boolean areColorTransitionsEnabled;
    private final ArgbEvaluator argbEvaluator;
    protected View backButton;
    protected boolean baseProgressButtonEnabled;
    private int currentlySelectedItem;
    protected View doneButton;
    protected final List<Fragment> fragments;
    private GestureDetectorCompat gestureDetector;
    private boolean isGoBackLockEnabled;
    private boolean isImmersiveModeEnabled;
    private boolean isImmersiveModeSticky;
    protected boolean isVibrateOn;
    protected boolean isWizardMode;
    protected IndicatorController mController;
    protected PagerAdapter mPagerAdapter;
    protected Vibrator mVibrator;
    protected View nextButton;
    protected AppIntroViewPager pager;
    protected ArrayList<PermissionObject> permissionsArray;
    protected boolean progressButtonEnabled;
    protected int savedCurrentItem;
    protected int selectedIndicatorColor;
    protected boolean showBackButtonWithDone;
    protected View skipButton;
    protected boolean skipButtonEnabled;
    protected int slidesNumber;
    protected int unselectedIndicatorColor;
    protected int vibrateIntensity;

    /* renamed from: com.github.paolorotolo.appintro.AppIntroBase.1 */
    class C03901 implements OnClickListener {
        C03901() {
        }

        public void onClick(@NonNull View v) {
            if (AppIntroBase.this.isVibrateOn) {
                AppIntroBase.this.mVibrator.vibrate((long) AppIntroBase.this.vibrateIntensity);
            }
            Fragment currentFragment = AppIntroBase.this.mPagerAdapter.getItem(AppIntroBase.this.pager.getCurrentItem());
            if (AppIntroBase.this.handleBeforeSlideChanged()) {
                AppIntroBase.this.handleSlideChanged(currentFragment, null);
                AppIntroBase.this.onDonePressed(currentFragment);
                return;
            }
            AppIntroBase.this.handleIllegalSlideChangeAttempt();
        }
    }

    /* renamed from: com.github.paolorotolo.appintro.AppIntroBase.2 */
    class C03912 implements OnClickListener {
        C03912() {
        }

        public void onClick(@NonNull View v) {
            if (AppIntroBase.this.isVibrateOn) {
                AppIntroBase.this.mVibrator.vibrate((long) AppIntroBase.this.vibrateIntensity);
            }
            AppIntroBase.this.onSkipPressed(AppIntroBase.this.mPagerAdapter.getItem(AppIntroBase.this.pager.getCurrentItem()));
        }
    }

    /* renamed from: com.github.paolorotolo.appintro.AppIntroBase.3 */
    class C03923 implements OnClickListener {
        C03923() {
        }

        public void onClick(View view) {
            if (AppIntroBase.this.pager.getCurrentItem() > 0) {
                AppIntroBase.this.pager.setCurrentItem(AppIntroBase.this.pager.getCurrentItem() - 1);
            }
        }
    }

    /* renamed from: com.github.paolorotolo.appintro.AppIntroBase.4 */
    class C03934 implements Runnable {
        C03934() {
        }

        public void run() {
            AppIntroBase.this.handleSlideChanged(null, AppIntroBase.this.mPagerAdapter.getItem(AppIntroBase.this.pager.getCurrentItem()));
        }
    }

    private final class NextButtonOnClickListener implements OnClickListener {
        private NextButtonOnClickListener() {
        }

        public void onClick(View v) {
            if (AppIntroBase.this.isVibrateOn) {
                AppIntroBase.this.mVibrator.vibrate((long) AppIntroBase.this.vibrateIntensity);
            }
            if (AppIntroBase.this.handleBeforeSlideChanged()) {
                boolean requestPermission = false;
                int position = 0;
                if (0 < AppIntroBase.this.permissionsArray.size()) {
                    requestPermission = AppIntroBase.this.pager.getCurrentItem() + AppIntroBase.PERMISSIONS_REQUEST_ALL_PERMISSIONS == ((PermissionObject) AppIntroBase.this.permissionsArray.get(0)).getPosition();
                    position = 0;
                }
                if (!requestPermission) {
                    AppIntroBase.this.pager.setCurrentItem(AppIntroBase.this.pager.getCurrentItem() + AppIntroBase.PERMISSIONS_REQUEST_ALL_PERMISSIONS);
                    AppIntroBase.this.onNextPressed();
                    return;
                } else if (VERSION.SDK_INT >= 23) {
                    AppIntroBase.this.requestPermissions(((PermissionObject) AppIntroBase.this.permissionsArray.get(position)).getPermission(), AppIntroBase.PERMISSIONS_REQUEST_ALL_PERMISSIONS);
                    AppIntroBase.this.permissionsArray.remove(position);
                    return;
                } else {
                    AppIntroBase.this.pager.setCurrentItem(AppIntroBase.this.pager.getCurrentItem() + AppIntroBase.PERMISSIONS_REQUEST_ALL_PERMISSIONS);
                    AppIntroBase.this.onNextPressed();
                    return;
                }
            }
            AppIntroBase.this.handleIllegalSlideChangeAttempt();
        }
    }

    private final class PagerOnPageChangeListener implements OnPageChangeListener {
        private PagerOnPageChangeListener() {
        }

        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (AppIntroBase.this.areColorTransitionsEnabled && position < AppIntroBase.this.mPagerAdapter.getCount() - 1) {
                if ((AppIntroBase.this.mPagerAdapter.getItem(position) instanceof ISlideBackgroundColorHolder) && (AppIntroBase.this.mPagerAdapter.getItem(position + AppIntroBase.PERMISSIONS_REQUEST_ALL_PERMISSIONS) instanceof ISlideBackgroundColorHolder)) {
                    Fragment currentSlide = AppIntroBase.this.mPagerAdapter.getItem(position);
                    Fragment nextSlide = AppIntroBase.this.mPagerAdapter.getItem(position + AppIntroBase.PERMISSIONS_REQUEST_ALL_PERMISSIONS);
                    ISlideBackgroundColorHolder currentSlideCasted = (ISlideBackgroundColorHolder) currentSlide;
                    ISlideBackgroundColorHolder nextSlideCasted = (ISlideBackgroundColorHolder) nextSlide;
                    if (currentSlide.isAdded() && nextSlide.isAdded()) {
                        int newColor = ((Integer) AppIntroBase.this.argbEvaluator.evaluate(positionOffset, Integer.valueOf(currentSlideCasted.getDefaultBackgroundColor()), Integer.valueOf(nextSlideCasted.getDefaultBackgroundColor()))).intValue();
                        currentSlideCasted.setBackgroundColor(newColor);
                        nextSlideCasted.setBackgroundColor(newColor);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Color transitions are only available if all slides implement ISlideBackgroundColorHolder.");
            }
        }

        public void onPageSelected(int position) {
            if (AppIntroBase.this.slidesNumber > AppIntroBase.PERMISSIONS_REQUEST_ALL_PERMISSIONS) {
                AppIntroBase.this.mController.selectPosition(position);
            }
            if (AppIntroBase.this.pager.isNextPagingEnabled()) {
                AppIntroBase.this.setProgressButtonEnabled(AppIntroBase.this.progressButtonEnabled);
            } else if (AppIntroBase.this.pager.getCurrentItem() != AppIntroBase.this.pager.getLockPage()) {
                AppIntroBase.this.setProgressButtonEnabled(AppIntroBase.this.baseProgressButtonEnabled);
                AppIntroBase.this.pager.setNextPagingEnabled(true);
            } else {
                AppIntroBase.this.setProgressButtonEnabled(AppIntroBase.this.progressButtonEnabled);
            }
            AppIntroBase.this.onPageSelected(position);
            if (AppIntroBase.this.slidesNumber > 0) {
                if (AppIntroBase.this.currentlySelectedItem == -1) {
                    AppIntroBase.this.handleSlideChanged(null, AppIntroBase.this.mPagerAdapter.getItem(position));
                } else {
                    AppIntroBase.this.handleSlideChanged(AppIntroBase.this.mPagerAdapter.getItem(AppIntroBase.this.currentlySelectedItem), AppIntroBase.this.mPagerAdapter.getItem(AppIntroBase.this.pager.getCurrentItem()));
                }
            }
            AppIntroBase.this.currentlySelectedItem = position;
        }

        public void onPageScrollStateChanged(int state) {
        }
    }

    private final class WindowGestureListener extends SimpleOnGestureListener {
        private WindowGestureListener() {
        }

        public boolean onSingleTapUp(MotionEvent e) {
            if (AppIntroBase.this.isImmersiveModeEnabled && !AppIntroBase.this.isImmersiveModeSticky) {
                AppIntroBase.this.setImmersiveMode(true, false);
            }
            return false;
        }
    }

    protected abstract int getLayoutId();

    public AppIntroBase() {
        this.fragments = new Vector();
        this.argbEvaluator = new ArgbEvaluator();
        this.vibrateIntensity = 20;
        this.selectedIndicatorColor = PERMISSIONS_REQUEST_ALL_PERMISSIONS;
        this.unselectedIndicatorColor = PERMISSIONS_REQUEST_ALL_PERMISSIONS;
        this.permissionsArray = new ArrayList();
        this.isVibrateOn = false;
        this.baseProgressButtonEnabled = true;
        this.progressButtonEnabled = true;
        this.skipButtonEnabled = true;
        this.isWizardMode = false;
        this.showBackButtonWithDone = false;
        this.isGoBackLockEnabled = false;
        this.isImmersiveModeEnabled = false;
        this.isImmersiveModeSticky = false;
        this.areColorTransitionsEnabled = false;
        this.currentlySelectedItem = -1;
    }

    static {
        TAG = LogHelper.makeLogTag(AppIntroBase.class);
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(PERMISSIONS_REQUEST_ALL_PERMISSIONS);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        this.gestureDetector = new GestureDetectorCompat(this, new WindowGestureListener());
        this.nextButton = findViewById(C0394R.id.next);
        this.doneButton = findViewById(C0394R.id.done);
        this.skipButton = findViewById(C0394R.id.skip);
        this.backButton = findViewById(C0394R.id.back);
        this.mVibrator = (Vibrator) getSystemService("vibrator");
        this.mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), this.fragments);
        this.pager = (AppIntroViewPager) findViewById(C0394R.id.view_pager);
        this.doneButton.setOnClickListener(new C03901());
        this.skipButton.setOnClickListener(new C03912());
        this.nextButton.setOnClickListener(new NextButtonOnClickListener());
        this.backButton.setOnClickListener(new C03923());
        this.pager.setAdapter(this.mPagerAdapter);
        this.pager.addOnPageChangeListener(new PagerOnPageChangeListener());
        this.pager.setOnNextPageRequestedListener(this);
        setScrollDurationFactor(PERMISSIONS_REQUEST_ALL_PERMISSIONS);
    }

    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (this.fragments.size() == 0) {
            init(null);
        }
        this.pager.setCurrentItem(this.savedCurrentItem);
        this.pager.post(new C03934());
        this.slidesNumber = this.fragments.size();
        setProgressButtonEnabled(this.progressButtonEnabled);
        initController();
    }

    public void onBackPressed() {
        if (!this.isGoBackLockEnabled) {
            super.onBackPressed();
        }
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && this.isImmersiveModeEnabled) {
            setImmersiveMode(true, this.isImmersiveModeSticky);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        if (this.isImmersiveModeEnabled) {
            this.gestureDetector.onTouchEvent(event);
        }
        return super.dispatchTouchEvent(event);
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("baseProgressButtonEnabled", this.baseProgressButtonEnabled);
        outState.putBoolean("progressButtonEnabled", this.progressButtonEnabled);
        outState.putBoolean("nextEnabled", this.pager.isPagingEnabled());
        outState.putBoolean("nextPagingEnabled", this.pager.isNextPagingEnabled());
        outState.putBoolean("skipButtonEnabled", this.skipButtonEnabled);
        outState.putInt("lockPage", this.pager.getLockPage());
        outState.putInt("currentItem", this.pager.getCurrentItem());
        outState.putBoolean(INSTANCE_DATA_IMMERSIVE_MODE_ENABLED, this.isImmersiveModeEnabled);
        outState.putBoolean(INSTANCE_DATA_IMMERSIVE_MODE_STICKY, this.isImmersiveModeSticky);
        outState.putBoolean(INSTANCE_DATA_COLOR_TRANSITIONS_ENABLED, this.areColorTransitionsEnabled);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.baseProgressButtonEnabled = savedInstanceState.getBoolean("baseProgressButtonEnabled");
        this.progressButtonEnabled = savedInstanceState.getBoolean("progressButtonEnabled");
        this.skipButtonEnabled = savedInstanceState.getBoolean("skipButtonEnabled");
        this.savedCurrentItem = savedInstanceState.getInt("currentItem");
        this.pager.setPagingEnabled(savedInstanceState.getBoolean("nextEnabled"));
        this.pager.setNextPagingEnabled(savedInstanceState.getBoolean("nextPagingEnabled"));
        this.pager.setLockPage(savedInstanceState.getInt("lockPage"));
        this.isImmersiveModeEnabled = savedInstanceState.getBoolean(INSTANCE_DATA_IMMERSIVE_MODE_ENABLED);
        this.isImmersiveModeSticky = savedInstanceState.getBoolean(INSTANCE_DATA_IMMERSIVE_MODE_STICKY);
        this.areColorTransitionsEnabled = savedInstanceState.getBoolean(INSTANCE_DATA_COLOR_TRANSITIONS_ENABLED);
    }

    public boolean onCanRequestNextPage() {
        return handleBeforeSlideChanged();
    }

    public void onIllegallyRequestedNextPage() {
        handleIllegalSlideChangeAttempt();
    }

    private void initController() {
        if (this.mController == null) {
            this.mController = new DefaultIndicatorController();
        }
        ((FrameLayout) findViewById(C0394R.id.indicator_container)).addView(this.mController.newInstance(this));
        this.mController.initialize(this.slidesNumber);
        if (this.selectedIndicatorColor != PERMISSIONS_REQUEST_ALL_PERMISSIONS) {
            this.mController.setSelectedIndicatorColor(this.selectedIndicatorColor);
        }
        if (this.unselectedIndicatorColor != PERMISSIONS_REQUEST_ALL_PERMISSIONS) {
            this.mController.setUnselectedIndicatorColor(this.unselectedIndicatorColor);
        }
        this.mController.selectPosition(this.currentlySelectedItem);
    }

    private void handleIllegalSlideChangeAttempt() {
        Fragment currentFragment = this.mPagerAdapter.getItem(this.pager.getCurrentItem());
        if (currentFragment != null && (currentFragment instanceof ISlidePolicy)) {
            ISlidePolicy slide = (ISlidePolicy) currentFragment;
            if (!slide.isPolicyRespected()) {
                slide.onUserIllegallyRequestedNextPage();
            }
        }
    }

    private boolean handleBeforeSlideChanged() {
        Fragment currentFragment = this.mPagerAdapter.getItem(this.pager.getCurrentItem());
        String str = TAG;
        Object[] objArr = new Object[PERMISSIONS_REQUEST_ALL_PERMISSIONS];
        Object[] objArr2 = new Object[PERMISSIONS_REQUEST_ALL_PERMISSIONS];
        objArr2[0] = currentFragment;
        objArr[0] = String.format("User wants to move away from slide: %s. Checking if this should be allowed...", objArr2);
        LogHelper.m15d(str, objArr);
        if (currentFragment instanceof ISlidePolicy) {
            ISlidePolicy slide = (ISlidePolicy) currentFragment;
            str = TAG;
            objArr = new Object[PERMISSIONS_REQUEST_ALL_PERMISSIONS];
            objArr[0] = "Current fragment implements ISlidePolicy.";
            LogHelper.m15d(str, objArr);
            if (!slide.isPolicyRespected()) {
                str = TAG;
                Object[] objArr3 = new Object[PERMISSIONS_REQUEST_ALL_PERMISSIONS];
                objArr3[0] = "Slide policy not respected, denying change request.";
                LogHelper.m15d(str, objArr3);
                return false;
            }
        }
        str = TAG;
        objArr = new Object[PERMISSIONS_REQUEST_ALL_PERMISSIONS];
        objArr[0] = "Change request will be allowed.";
        LogHelper.m15d(str, objArr);
        return true;
    }

    private void handleSlideChanged(Fragment oldFragment, Fragment newFragment) {
        if (oldFragment != null && (oldFragment instanceof ISlideSelectionListener)) {
            ((ISlideSelectionListener) oldFragment).onSlideDeselected();
        }
        if (newFragment != null && (newFragment instanceof ISlideSelectionListener)) {
            ((ISlideSelectionListener) newFragment).onSlideSelected();
        }
        onSlideChanged(oldFragment, newFragment);
    }

    protected void onPageSelected(int position) {
    }

    public void showSkipButton(boolean showButton) {
        this.skipButtonEnabled = showButton;
        setButtonState(this.skipButton, showButton);
    }

    public boolean isSkipButtonEnabled() {
        return this.skipButtonEnabled;
    }

    public void onSkipPressed(Fragment currentFragment) {
        onSkipPressed();
    }

    protected void setScrollDurationFactor(int factor) {
        this.pager.setScrollDurationFactor((double) factor);
    }

    protected void setButtonState(View button, boolean show) {
        if (show) {
            button.setVisibility(0);
        } else {
            button.setVisibility(4);
        }
    }

    public AppIntroViewPager getPager() {
        return this.pager;
    }

    @NonNull
    public List<Fragment> getSlides() {
        return this.mPagerAdapter.getFragments();
    }

    public void addSlide(@NonNull Fragment fragment) {
        this.fragments.add(fragment);
        if (this.isWizardMode) {
            setOffScreenPageLimit(this.fragments.size());
        }
        this.mPagerAdapter.notifyDataSetChanged();
    }

    public boolean isProgressButtonEnabled() {
        return this.progressButtonEnabled;
    }

    public void setProgressButtonEnabled(boolean progressButtonEnabled) {
        this.progressButtonEnabled = progressButtonEnabled;
        if (!progressButtonEnabled) {
            setButtonState(this.nextButton, false);
            setButtonState(this.doneButton, false);
            setButtonState(this.backButton, false);
            setButtonState(this.skipButton, false);
        } else if (this.pager.getCurrentItem() == this.slidesNumber - 1) {
            setButtonState(this.nextButton, false);
            setButtonState(this.doneButton, true);
            if (this.isWizardMode) {
                setButtonState(this.backButton, this.showBackButtonWithDone);
            } else {
                setButtonState(this.skipButton, false);
            }
        } else {
            setButtonState(this.nextButton, true);
            setButtonState(this.doneButton, false);
            if (!this.isWizardMode) {
                setButtonState(this.skipButton, this.skipButtonEnabled);
            } else if (this.pager.getCurrentItem() == 0) {
                setButtonState(this.backButton, false);
            } else {
                setButtonState(this.backButton, this.isWizardMode);
            }
        }
    }

    public void setOffScreenPageLimit(int limit) {
        this.pager.setOffscreenPageLimit(limit);
    }

    public void init(@Nullable Bundle savedInstanceState) {
    }

    public void onNextPressed() {
    }

    public void onDonePressed() {
    }

    public void onSkipPressed() {
    }

    public void onSlideChanged() {
    }

    public void onDonePressed(Fragment currentFragment) {
        onDonePressed();
    }

    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        onSlideChanged();
    }

    public boolean onKeyDown(int code, KeyEvent event) {
        if (code != 66 && code != 96 && code != 23) {
            return super.onKeyDown(code, event);
        }
        ViewPager vp = (ViewPager) findViewById(C0394R.id.view_pager);
        if (vp.getCurrentItem() == vp.getAdapter().getCount() - 1) {
            onDonePressed((Fragment) this.fragments.get(vp.getCurrentItem()));
        } else {
            vp.setCurrentItem(vp.getCurrentItem() + PERMISSIONS_REQUEST_ALL_PERMISSIONS);
        }
        return false;
    }

    public void setNavBarColor(String Color) {
        if (VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(Color.parseColor(Color));
        }
    }

    public void setNavBarColor(@ColorRes int color) {
        if (VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, color));
        }
    }

    public void showStatusBar(boolean isVisible) {
        if (isVisible) {
            getWindow().clearFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        } else {
            getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        }
    }

    public void setVibrate(boolean vibrationEnabled) {
        this.isVibrateOn = vibrationEnabled;
    }

    public boolean getWizardMode() {
        return this.isWizardMode;
    }

    public void setWizardMode(boolean wizardMode) {
        boolean z = false;
        this.isWizardMode = wizardMode;
        this.skipButtonEnabled = false;
        View view = this.skipButton;
        if (!wizardMode) {
            z = true;
        }
        setButtonState(view, z);
    }

    public boolean getBackButtonVisibilityWithDone() {
        return this.isWizardMode;
    }

    public void setBackButtonVisibilityWithDone(boolean show) {
        this.showBackButtonWithDone = show;
    }

    public void setVibrateIntensity(int intensity) {
        this.vibrateIntensity = intensity;
    }

    public void setProgressIndicator() {
        this.mController = new ProgressIndicatorController();
    }

    public void setCustomIndicator(@NonNull IndicatorController controller) {
        this.mController = controller;
    }

    public void setColorTransitionsEnabled(boolean colorTransitionsEnabled) {
        this.areColorTransitionsEnabled = colorTransitionsEnabled;
    }

    public void setFadeAnimation() {
        this.pager.setPageTransformer(true, new ViewPageTransformer(TransformType.FADE));
    }

    public void setZoomAnimation() {
        this.pager.setPageTransformer(true, new ViewPageTransformer(TransformType.ZOOM));
    }

    public void setFlowAnimation() {
        this.pager.setPageTransformer(true, new ViewPageTransformer(TransformType.FLOW));
    }

    public void setSlideOverAnimation() {
        this.pager.setPageTransformer(true, new ViewPageTransformer(TransformType.SLIDE_OVER));
    }

    public void setDepthAnimation() {
        this.pager.setPageTransformer(true, new ViewPageTransformer(TransformType.DEPTH));
    }

    public void setCustomTransformer(@Nullable PageTransformer transformer) {
        this.pager.setPageTransformer(true, transformer);
    }

    public void setIndicatorColor(int selectedIndicatorColor, int unselectedIndicatorColor) {
        this.selectedIndicatorColor = selectedIndicatorColor;
        this.unselectedIndicatorColor = unselectedIndicatorColor;
        if (this.mController != null) {
            if (selectedIndicatorColor != PERMISSIONS_REQUEST_ALL_PERMISSIONS) {
                this.mController.setSelectedIndicatorColor(selectedIndicatorColor);
            }
            if (unselectedIndicatorColor != PERMISSIONS_REQUEST_ALL_PERMISSIONS) {
                this.mController.setUnselectedIndicatorColor(unselectedIndicatorColor);
            }
        }
    }

    public void setNextPageSwipeLock(boolean lockEnable) {
        boolean z = false;
        if (lockEnable) {
            this.baseProgressButtonEnabled = this.progressButtonEnabled;
            setProgressButtonEnabled(false);
        } else {
            setProgressButtonEnabled(this.baseProgressButtonEnabled);
        }
        AppIntroViewPager appIntroViewPager = this.pager;
        if (!lockEnable) {
            z = true;
        }
        appIntroViewPager.setNextPagingEnabled(z);
    }

    public void setSwipeLock(boolean lockEnable) {
        if (lockEnable) {
            this.baseProgressButtonEnabled = this.progressButtonEnabled;
        } else {
            setProgressButtonEnabled(this.baseProgressButtonEnabled);
        }
        this.pager.setPagingEnabled(!lockEnable);
    }

    public void setGoBackLock(boolean lockEnabled) {
        this.isGoBackLockEnabled = lockEnabled;
    }

    public void setImmersiveMode(boolean isEnabled) {
        setImmersiveMode(isEnabled, false);
    }

    public void setImmersiveMode(boolean isEnabled, boolean isSticky) {
        if (VERSION.SDK_INT < 19) {
            return;
        }
        if (!isEnabled && this.isImmersiveModeEnabled) {
            getWindow().getDecorView().setSystemUiVisibility(1792);
            this.isImmersiveModeEnabled = false;
        } else if (isEnabled) {
            int flags;
            if (isSticky) {
                flags = 1798 | Connections.MAX_RELIABLE_MESSAGE_LEN;
                this.isImmersiveModeSticky = true;
            } else {
                flags = 1798 | ItemAnimator.FLAG_MOVED;
                this.isImmersiveModeSticky = false;
            }
            getWindow().getDecorView().setSystemUiVisibility(flags);
            this.isImmersiveModeEnabled = true;
        }
    }

    public void askForPermissions(String[] permissions, int slidesNumber) {
        if (VERSION.SDK_INT < 23) {
            return;
        }
        if (slidesNumber == 0) {
            Toast.makeText(getBaseContext(), "Invalid Slide Number", 0).show();
            return;
        }
        this.permissionsArray.add(new PermissionObject(permissions, slidesNumber));
        setSwipeLock(true);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ALL_PERMISSIONS /*1*/:
                this.pager.setCurrentItem(this.pager.getCurrentItem() + PERMISSIONS_REQUEST_ALL_PERMISSIONS);
            default:
                String str = TAG;
                Object[] objArr = new Object[PERMISSIONS_REQUEST_ALL_PERMISSIONS];
                objArr[0] = "Unexpected request code";
                LogHelper.m17e(str, objArr);
        }
    }
}
