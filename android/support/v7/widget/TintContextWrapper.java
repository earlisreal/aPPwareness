package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatDelegate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TintContextWrapper extends ContextWrapper {
    private static final ArrayList<WeakReference<TintContextWrapper>> sCache;
    private final Resources mResources;
    private final Theme mTheme;

    static {
        sCache = new ArrayList();
    }

    public static Context wrap(@NonNull Context context) {
        if (!shouldWrap(context)) {
            return context;
        }
        TintContextWrapper wrapper;
        int count = sCache.size();
        for (int i = 0; i < count; i++) {
            WeakReference<TintContextWrapper> ref = (WeakReference) sCache.get(i);
            wrapper = ref != null ? (TintContextWrapper) ref.get() : null;
            if (wrapper != null && wrapper.getBaseContext() == context) {
                return wrapper;
            }
        }
        wrapper = new TintContextWrapper(context);
        sCache.add(new WeakReference(wrapper));
        return wrapper;
    }

    private static boolean shouldWrap(@NonNull Context context) {
        if ((context instanceof TintContextWrapper) || (context.getResources() instanceof TintResources) || (context.getResources() instanceof VectorEnabledTintResources)) {
            return false;
        }
        if (!AppCompatDelegate.isCompatVectorFromResourcesEnabled() || VERSION.SDK_INT <= 20) {
            return true;
        }
        return false;
    }

    private TintContextWrapper(@NonNull Context base) {
        super(base);
        if (VectorEnabledTintResources.shouldBeUsed()) {
            this.mResources = new VectorEnabledTintResources(this, base.getResources());
            this.mTheme = this.mResources.newTheme();
            this.mTheme.setTo(base.getTheme());
            return;
        }
        this.mResources = new TintResources(this, base.getResources());
        this.mTheme = null;
    }

    public Theme getTheme() {
        return this.mTheme == null ? super.getTheme() : this.mTheme;
    }

    public void setTheme(int resid) {
        if (this.mTheme == null) {
            super.setTheme(resid);
        } else {
            this.mTheme.applyStyle(resid, true);
        }
    }

    public Resources getResources() {
        return this.mResources;
    }
}
