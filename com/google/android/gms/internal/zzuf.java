package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.ActionResult;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

public final class zzuf implements AppIndexApi, zztz {
    private static final String TAG;

    private static abstract class zzb<T extends Result> extends com.google.android.gms.internal.zzzv.zza<T, zzud> {
        public zzb(GoogleApiClient googleApiClient) {
            super(zzti.zzafY, googleApiClient);
        }

        protected abstract void zza(zzua com_google_android_gms_internal_zzua) throws RemoteException;

        protected final void zza(zzud com_google_android_gms_internal_zzud) throws RemoteException {
            zza(com_google_android_gms_internal_zzud.zzqj());
        }
    }

    public static abstract class zzc<T extends Result> extends zzb<Status> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzuf.1 */
    class C15281 extends zzc<Status> {
        final /* synthetic */ zztx[] zzagW;

        C15281(zzuf com_google_android_gms_internal_zzuf, GoogleApiClient googleApiClient, zztx[] com_google_android_gms_internal_zztxArr) {
            this.zzagW = com_google_android_gms_internal_zztxArr;
            super(googleApiClient);
        }

        protected void zza(zzua com_google_android_gms_internal_zzua) throws RemoteException {
            com_google_android_gms_internal_zzua.zza(new zzd(this), null, this.zzagW);
        }
    }

    @Deprecated
    private static final class zza implements ActionResult {
        private zzuf zzagX;
        private PendingResult<Status> zzagY;
        private Action zzagZ;

        zza(zzuf com_google_android_gms_internal_zzuf, PendingResult<Status> pendingResult, Action action) {
            this.zzagX = com_google_android_gms_internal_zzuf;
            this.zzagY = pendingResult;
            this.zzagZ = action;
        }

        public PendingResult<Status> end(GoogleApiClient googleApiClient) {
            String packageName = googleApiClient.getContext().getPackageName();
            zztx zza = zzue.zza(this.zzagZ, System.currentTimeMillis(), packageName, 2);
            return this.zzagX.zza(googleApiClient, zza);
        }

        public PendingResult<Status> getPendingResult() {
            return this.zzagY;
        }
    }

    public static final class zzd extends zzuc<Status> {
        public zzd(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            super(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status);
        }

        public void zza(Status status) {
            this.zzagV.setResult(status);
        }
    }

    static {
        TAG = zzuf.class.getSimpleName();
    }

    public static Intent zza(String str, Uri uri) {
        zzb(str, uri);
        if (zzm(uri)) {
            return new Intent("android.intent.action.VIEW", uri);
        }
        if (zzn(uri)) {
            return new Intent("android.intent.action.VIEW", zzl(uri));
        }
        String valueOf = String.valueOf(uri);
        throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 70).append("appIndexingUri is neither an HTTP(S) URL nor an \"android-app://\" URL: ").append(valueOf).toString());
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, Action action, int i) {
        String packageName = googleApiClient.getContext().getPackageName();
        return zza(googleApiClient, zzue.zza(action, System.currentTimeMillis(), packageName, i));
    }

    private static void zzb(String str, Uri uri) {
        String valueOf;
        if (zzm(uri)) {
            if (uri.getHost().isEmpty()) {
                valueOf = String.valueOf(uri);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 98).append("AppIndex: The web URL must have a host (follow the format http(s)://<host>/<path>). Provided URI: ").append(valueOf).toString());
            }
        } else if (!zzn(uri)) {
            valueOf = String.valueOf(uri);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 176).append("AppIndex: The URI scheme must either be 'http(s)' or 'android-app'. If the latter, it must follow the format 'android-app://<package_name>/<scheme>/<host_path>'. Provided URI: ").append(valueOf).toString());
        } else if (str == null || str.equals(uri.getHost())) {
            List pathSegments = uri.getPathSegments();
            if (pathSegments.isEmpty() || ((String) pathSegments.get(0)).isEmpty()) {
                valueOf = String.valueOf(uri);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + Cast.MAX_NAMESPACE_LENGTH).append("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/<host_path>). Provided URI: ").append(valueOf).toString());
            }
        } else {
            valueOf = String.valueOf(uri);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 150).append("AppIndex: The android-app URI host must match the package name and follow the format android-app://<package_name>/<scheme>/<host_path>. Provided URI: ").append(valueOf).toString());
        }
    }

    private static Uri zzl(Uri uri) {
        List pathSegments = uri.getPathSegments();
        String str = (String) pathSegments.get(0);
        Builder builder = new Builder();
        builder.scheme(str);
        if (pathSegments.size() > 1) {
            builder.authority((String) pathSegments.get(1));
            for (int i = 2; i < pathSegments.size(); i++) {
                builder.appendPath((String) pathSegments.get(i));
            }
        } else {
            str = TAG;
            String valueOf = String.valueOf(uri);
            Log.e(str, new StringBuilder(String.valueOf(valueOf).length() + 88).append("The app URI must have the format: android-app://<package_name>/<scheme>/<path>. But got ").append(valueOf).toString());
        }
        builder.encodedQuery(uri.getEncodedQuery());
        builder.encodedFragment(uri.getEncodedFragment());
        return builder.build();
    }

    private static boolean zzm(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    private static boolean zzn(Uri uri) {
        return "android-app".equals(uri.getScheme());
    }

    public static void zzw(List<AppIndexingLink> list) {
        if (list != null) {
            for (AppIndexingLink appIndexingLink : list) {
                zzb(null, appIndexingLink.appIndexingUrl);
            }
        }
    }

    public ActionResult action(GoogleApiClient googleApiClient, Action action) {
        return new zza(this, zza(googleApiClient, action, 1), action);
    }

    public PendingResult<Status> end(GoogleApiClient googleApiClient, Action action) {
        return zza(googleApiClient, action, 2);
    }

    public PendingResult<Status> start(GoogleApiClient googleApiClient, Action action) {
        return zza(googleApiClient, action, 1);
    }

    public PendingResult<Status> view(GoogleApiClient googleApiClient, Activity activity, Intent intent, String str, Uri uri, List<AppIndexingLink> list) {
        String packageName = googleApiClient.getContext().getPackageName();
        zzw(list);
        return zza(googleApiClient, new zztx(packageName, intent, str, uri, null, list, 1));
    }

    public PendingResult<Status> view(GoogleApiClient googleApiClient, Activity activity, Uri uri, String str, Uri uri2, List<AppIndexingLink> list) {
        String packageName = googleApiClient.getContext().getPackageName();
        zzb(packageName, uri);
        return view(googleApiClient, activity, zza(packageName, uri), str, uri2, (List) list);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient googleApiClient, Activity activity, Intent intent) {
        String packageName = googleApiClient.getContext().getPackageName();
        return zza(googleApiClient, new com.google.android.gms.internal.zztx.zza().zza(zztx.zza(packageName, intent)).zzA(System.currentTimeMillis()).zzaQ(0).zzaR(2).zzqi());
    }

    public PendingResult<Status> viewEnd(GoogleApiClient googleApiClient, Activity activity, Uri uri) {
        return viewEnd(googleApiClient, activity, zza(googleApiClient.getContext().getPackageName(), uri));
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, zztx... com_google_android_gms_internal_zztxArr) {
        return googleApiClient.zza(new C15281(this, googleApiClient, com_google_android_gms_internal_zztxArr));
    }
}
