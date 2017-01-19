package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zzf;
import com.google.android.gms.internal.zzew.zza;
import java.util.HashMap;
import java.util.Map;

@zzmb
public class zzqu extends zza {
    private final zzqp zzGt;
    private boolean zzZA;
    private float zzZB;
    private float zzZC;
    private final float zzZw;
    private int zzZx;
    private zzex zzZy;
    private boolean zzZz;
    private final Object zzrN;
    private boolean zzrQ;

    /* renamed from: com.google.android.gms.internal.zzqu.1 */
    class C14941 implements Runnable {
        final /* synthetic */ Map zzZD;
        final /* synthetic */ zzqu zzZE;

        C14941(zzqu com_google_android_gms_internal_zzqu, Map map) {
            this.zzZE = com_google_android_gms_internal_zzqu;
            this.zzZD = map;
        }

        public void run() {
            this.zzZE.zzGt.zza("pubVideoCmd", this.zzZD);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzqu.2 */
    class C14952 implements Runnable {
        final /* synthetic */ zzqu zzZE;
        final /* synthetic */ int zzZF;
        final /* synthetic */ int zzZG;

        C14952(zzqu com_google_android_gms_internal_zzqu, int i, int i2) {
            this.zzZE = com_google_android_gms_internal_zzqu;
            this.zzZF = i;
            this.zzZG = i2;
        }

        public void run() {
            boolean z = false;
            synchronized (this.zzZE.zzrN) {
                boolean z2 = this.zzZF != this.zzZG;
                boolean z3 = !this.zzZE.zzZz && this.zzZG == 1;
                boolean z4 = z2 && this.zzZG == 1;
                boolean z5 = z2 && this.zzZG == 2;
                z2 = z2 && this.zzZG == 3;
                zzqu com_google_android_gms_internal_zzqu = this.zzZE;
                if (this.zzZE.zzZz || z3) {
                    z = true;
                }
                com_google_android_gms_internal_zzqu.zzZz = z;
                if (this.zzZE.zzZy == null) {
                    return;
                }
                if (z3) {
                    try {
                        this.zzZE.zzZy.zzeT();
                    } catch (Throwable e) {
                        zzpy.zzc("Unable to call onVideoStart()", e);
                    }
                }
                if (z4) {
                    try {
                        this.zzZE.zzZy.zzeU();
                    } catch (Throwable e2) {
                        zzpy.zzc("Unable to call onVideoPlay()", e2);
                    }
                }
                if (z5) {
                    try {
                        this.zzZE.zzZy.zzeV();
                    } catch (Throwable e22) {
                        zzpy.zzc("Unable to call onVideoPause()", e22);
                    }
                }
                if (z2) {
                    try {
                        this.zzZE.zzZy.onVideoEnd();
                    } catch (Throwable e222) {
                        zzpy.zzc("Unable to call onVideoEnd()", e222);
                    }
                }
            }
        }
    }

    public zzqu(zzqp com_google_android_gms_internal_zzqp, float f) {
        this.zzrN = new Object();
        this.zzrQ = true;
        this.zzGt = com_google_android_gms_internal_zzqp;
        this.zzZw = f;
    }

    private void zzbk(String str) {
        zzd(str, null);
    }

    private void zzd(String str, @Nullable Map<String, String> map) {
        Map hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzv.zzcJ().runOnUiThread(new C14941(this, hashMap));
    }

    private void zzk(int i, int i2) {
        zzv.zzcJ().runOnUiThread(new C14952(this, i, i2));
    }

    public float getAspectRatio() {
        float f;
        synchronized (this.zzrN) {
            f = this.zzZC;
        }
        return f;
    }

    public int getPlaybackState() {
        int i;
        synchronized (this.zzrN) {
            i = this.zzZx;
        }
        return i;
    }

    public boolean isMuted() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzZA;
        }
        return z;
    }

    public void pause() {
        zzbk("pause");
    }

    public void play() {
        zzbk("play");
    }

    public void zzP(boolean z) {
        synchronized (this.zzrN) {
            this.zzrQ = z;
        }
        zzd("initialState", zzf.zze("muteStart", z ? "1" : "0"));
    }

    public void zza(float f, int i, boolean z, float f2) {
        int i2;
        synchronized (this.zzrN) {
            this.zzZB = f;
            this.zzZA = z;
            i2 = this.zzZx;
            this.zzZx = i;
            this.zzZC = f2;
        }
        zzk(i2, i);
    }

    public void zza(zzex com_google_android_gms_internal_zzex) {
        synchronized (this.zzrN) {
            this.zzZy = com_google_android_gms_internal_zzex;
        }
    }

    public float zzeR() {
        return this.zzZw;
    }

    public float zzeS() {
        float f;
        synchronized (this.zzrN) {
            f = this.zzZB;
        }
        return f;
    }

    public void zzn(boolean z) {
        zzbk(z ? "mute" : "unmute");
    }
}
