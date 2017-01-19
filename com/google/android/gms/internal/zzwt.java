package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.zzc;
import com.google.android.gms.cast.framework.zzf;
import com.google.android.gms.cast.framework.zzg;
import com.google.android.gms.cast.framework.zzh;
import com.google.android.gms.cast.framework.zzl;
import com.google.android.gms.cast.framework.zzm;
import com.google.android.gms.cast.framework.zzq;
import com.google.android.gms.dynamic.zzd;
import java.util.Map;

public interface zzwt extends IInterface {
    zzc zza(zzd com_google_android_gms_dynamic_zzd, zzd com_google_android_gms_dynamic_zzd2, zzd com_google_android_gms_dynamic_zzd3, CastMediaOptions castMediaOptions) throws RemoteException;

    zzg zza(zzd com_google_android_gms_dynamic_zzd, CastOptions castOptions, zzwu com_google_android_gms_internal_zzwu, Map map) throws RemoteException;

    zzh zza(CastOptions castOptions, zzd com_google_android_gms_dynamic_zzd, zzf com_google_android_gms_cast_framework_zzf) throws RemoteException;

    zzl zza(zzd com_google_android_gms_dynamic_zzd, zzd com_google_android_gms_dynamic_zzd2, zzd com_google_android_gms_dynamic_zzd3) throws RemoteException;

    zzm zza(String str, String str2, zzq com_google_android_gms_cast_framework_zzq) throws RemoteException;

    zzxc zza(zzd com_google_android_gms_dynamic_zzd, zzxd com_google_android_gms_internal_zzxd, int i, int i2, boolean z, long j, int i3, int i4, int i5) throws RemoteException;
}
