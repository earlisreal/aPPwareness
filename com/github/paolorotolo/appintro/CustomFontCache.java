package com.github.paolorotolo.appintro;

import android.content.Context;
import android.graphics.Typeface;
import com.github.paolorotolo.appintro.util.LogHelper;
import java.util.Hashtable;

public class CustomFontCache {
    private static final String TAG;
    private static final Hashtable<String, Typeface> fCache;

    static {
        TAG = LogHelper.makeLogTag(CustomFontCache.class);
        fCache = new Hashtable();
    }

    public static Typeface get(String tfn, Context ctx) {
        Typeface tf = (Typeface) fCache.get(tfn);
        if (tf != null) {
            return tf;
        }
        try {
            tf = Typeface.createFromAsset(ctx.getAssets(), tfn);
            if (tf != null) {
                fCache.put(tfn, tf);
            }
            return tf;
        } catch (Exception e) {
            LogHelper.m21w(TAG, e.toString());
            return null;
        }
    }
}
