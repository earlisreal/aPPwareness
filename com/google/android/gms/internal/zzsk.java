package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

class zzsk implements Logger {
    private boolean zzaaK;
    private int zzaeb;

    zzsk() {
        this.zzaeb = 2;
    }

    public void error(Exception exception) {
    }

    public void error(String str) {
    }

    public int getLogLevel() {
        return this.zzaeb;
    }

    public void info(String str) {
    }

    public void setLogLevel(int i) {
        this.zzaeb = i;
        if (!this.zzaaK) {
            String str = (String) zzsq.zzaek.get();
            Log.i((String) zzsq.zzaek.get(), new StringBuilder(String.valueOf(str).length() + 91).append("Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.").append(str).append(" DEBUG").toString());
            this.zzaaK = true;
        }
    }

    public void verbose(String str) {
    }

    public void warn(String str) {
    }
}
