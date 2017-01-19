package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzmb
public class zzkx implements zzkv {
    private final Context mContext;
    final Set<WebView> zzOG;

    /* renamed from: com.google.android.gms.internal.zzkx.1 */
    class C14011 implements Runnable {
        final /* synthetic */ String zzOH;
        final /* synthetic */ String zzOI;
        final /* synthetic */ zzkx zzOJ;

        /* renamed from: com.google.android.gms.internal.zzkx.1.1 */
        class C14001 extends WebViewClient {
            final /* synthetic */ C14011 zzOK;
            final /* synthetic */ WebView zzxR;

            C14001(C14011 c14011, WebView webView) {
                this.zzOK = c14011;
                this.zzxR = webView;
            }

            public void onPageFinished(WebView webView, String str) {
                zzpy.zzbc("Loading assets have finished");
                this.zzOK.zzOJ.zzOG.remove(this.zzxR);
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                zzpy.zzbe("Loading assets have failed.");
                this.zzOK.zzOJ.zzOG.remove(this.zzxR);
            }
        }

        C14011(zzkx com_google_android_gms_internal_zzkx, String str, String str2) {
            this.zzOJ = com_google_android_gms_internal_zzkx;
            this.zzOH = str;
            this.zzOI = str2;
        }

        public void run() {
            WebView zzij = this.zzOJ.zzij();
            zzij.setWebViewClient(new C14001(this, zzij));
            this.zzOJ.zzOG.add(zzij);
            zzij.loadDataWithBaseURL(this.zzOH, this.zzOI, "text/html", "UTF-8", null);
            zzpy.zzbc("Fetching assets finished.");
        }
    }

    public zzkx(Context context) {
        this.zzOG = Collections.synchronizedSet(new HashSet());
        this.mContext = context;
    }

    public void zza(String str, String str2, String str3) {
        zzpy.zzbc("Fetching assets for the given html");
        zzpi.zzWR.post(new C14011(this, str2, str3));
    }

    public WebView zzij() {
        WebView webView = new WebView(this.mContext);
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
    }
}
