package com.google.android.gms.internal;

import com.google.android.gms.internal.zzax.zza;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class zzbx {
    protected static final String TAG;
    private final String className;
    private final zzbc zzpC;
    private final String zzrh;
    private final int zzri;
    private volatile Method zzrj;
    private List<Class> zzrk;
    private CountDownLatch zzrl;

    /* renamed from: com.google.android.gms.internal.zzbx.1 */
    class C12411 implements Runnable {
        final /* synthetic */ zzbx zzrm;

        C12411(zzbx com_google_android_gms_internal_zzbx) {
            this.zzrm = com_google_android_gms_internal_zzbx;
        }

        public void run() {
            this.zzrm.zzbm();
        }
    }

    static {
        TAG = zzbx.class.getSimpleName();
    }

    public zzbx(zzbc com_google_android_gms_internal_zzbc, String str, String str2, List<Class> list) {
        this.zzri = 2;
        this.zzrj = null;
        this.zzrl = new CountDownLatch(1);
        this.zzpC = com_google_android_gms_internal_zzbc;
        this.className = str;
        this.zzrh = str2;
        this.zzrk = new ArrayList(list);
        this.zzpC.zzaJ().submit(new C12411(this));
    }

    private void zzbm() {
        try {
            Class loadClass = this.zzpC.zzaK().loadClass(zzd(this.zzpC.zzaM(), this.className));
            if (loadClass != null) {
                this.zzrj = loadClass.getMethod(zzd(this.zzpC.zzaM(), this.zzrh), (Class[]) this.zzrk.toArray(new Class[this.zzrk.size()]));
                if (this.zzrj == null) {
                    this.zzrl.countDown();
                } else {
                    this.zzrl.countDown();
                }
            }
        } catch (zza e) {
        } catch (UnsupportedEncodingException e2) {
        } catch (ClassNotFoundException e3) {
        } catch (NoSuchMethodException e4) {
        } catch (NullPointerException e5) {
        } finally {
            this.zzrl.countDown();
        }
    }

    private String zzd(byte[] bArr, String str) throws zza, UnsupportedEncodingException {
        return new String(this.zzpC.zzaL().zzc(bArr, str), "UTF-8");
    }

    public Method zzbn() {
        if (this.zzrj != null) {
            return this.zzrj;
        }
        try {
            return this.zzrl.await(2, TimeUnit.SECONDS) ? this.zzrj : null;
        } catch (InterruptedException e) {
            return null;
        }
    }
}
