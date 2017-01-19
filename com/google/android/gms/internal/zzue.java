package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.internal.zzaqa.zzb;
import com.google.android.gms.internal.zzaqa.zzc;
import com.google.android.gms.internal.zzaqa.zzd;
import com.google.android.gms.internal.zztv.zza;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.List;

public class zzue {
    public static zztn zza(String str, zzc com_google_android_gms_internal_zzaqa_zzc) {
        return new zztn(zzbut.zzf(com_google_android_gms_internal_zzaqa_zzc), new zza(str).zzY(true).zzcn(str).zzcm("blob").zzqh());
    }

    public static zztx zza(Action action, long j, String str, int i) {
        int i2;
        boolean z = false;
        Bundle bundle = new Bundle();
        bundle.putAll(action.zzqk());
        Bundle bundle2 = bundle.getBundle("object");
        Uri parse = bundle2.containsKey("id") ? Uri.parse(bundle2.getString("id")) : null;
        String string = bundle2.getString("name");
        String string2 = bundle2.getString("type");
        Intent zza = zzuf.zza(str, Uri.parse(bundle2.getString(PlusShare.KEY_CALL_TO_ACTION_URL)));
        zztj.zza zza2 = zztx.zza(zza, string, parse, string2, null);
        if (bundle.containsKey(".private:ssbContext")) {
            zza2.zza(zztn.zzl(bundle.getByteArray(".private:ssbContext")));
            bundle.remove(".private:ssbContext");
        }
        if (bundle.containsKey(".private:accountName")) {
            zza2.zzb(new Account(bundle.getString(".private:accountName"), GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            bundle.remove(".private:accountName");
        }
        if (bundle.containsKey(".private:isContextOnly") && bundle.getBoolean(".private:isContextOnly")) {
            i2 = 4;
            bundle.remove(".private:isContextOnly");
        } else {
            i2 = 0;
        }
        if (bundle.containsKey(".private:isDeviceOnly")) {
            z = bundle.getBoolean(".private:isDeviceOnly", false);
            bundle.remove(".private:isDeviceOnly");
        }
        zza2.zza(zza(".private:action", zzj(bundle)));
        return new zztx.zza().zza(zztx.zza(str, zza)).zzA(j).zzaQ(i2).zza(zza2.zzqe()).zzaa(z).zzaR(i).zzqi();
    }

    private static zzb zzb(String str, Bundle bundle) {
        zzb com_google_android_gms_internal_zzaqa_zzb = new zzb();
        com_google_android_gms_internal_zzaqa_zzb.name = str;
        com_google_android_gms_internal_zzaqa_zzb.zzbgE = new zzd();
        com_google_android_gms_internal_zzaqa_zzb.zzbgE.zzbgJ = zzj(bundle);
        return com_google_android_gms_internal_zzaqa_zzb;
    }

    private static zzb zzh(String str, boolean z) {
        zzb com_google_android_gms_internal_zzaqa_zzb = new zzb();
        com_google_android_gms_internal_zzaqa_zzb.name = str;
        com_google_android_gms_internal_zzaqa_zzb.zzbgE = new zzd();
        com_google_android_gms_internal_zzaqa_zzb.zzbgE.zzbgG = z;
        return com_google_android_gms_internal_zzaqa_zzb;
    }

    public static zzc zzj(Bundle bundle) {
        List arrayList = new ArrayList();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof String) {
                arrayList.add(zzu(str, (String) obj));
            } else if (obj instanceof Bundle) {
                arrayList.add(zzb(str, (Bundle) obj));
            } else if (obj instanceof String[]) {
                for (String str2 : (String[]) obj) {
                    if (str2 != null) {
                        arrayList.add(zzu(str, str2));
                    }
                }
            } else if (obj instanceof Bundle[]) {
                for (Bundle bundle2 : (Bundle[]) obj) {
                    if (bundle2 != null) {
                        arrayList.add(zzb(str, bundle2));
                    }
                }
            } else if (obj instanceof Boolean) {
                arrayList.add(zzh(str, ((Boolean) obj).booleanValue()));
            } else {
                String valueOf = String.valueOf(obj);
                Log.e("SearchIndex", new StringBuilder(String.valueOf(valueOf).length() + 19).append("Unsupported value: ").append(valueOf).toString());
            }
        }
        zzc com_google_android_gms_internal_zzaqa_zzc = new zzc();
        if (bundle.containsKey("type")) {
            com_google_android_gms_internal_zzaqa_zzc.type = bundle.getString("type");
        }
        com_google_android_gms_internal_zzaqa_zzc.zzbgF = (zzb[]) arrayList.toArray(new zzb[arrayList.size()]);
        return com_google_android_gms_internal_zzaqa_zzc;
    }

    private static zzb zzu(String str, String str2) {
        zzb com_google_android_gms_internal_zzaqa_zzb = new zzb();
        com_google_android_gms_internal_zzaqa_zzb.name = str;
        com_google_android_gms_internal_zzaqa_zzb.zzbgE = new zzd();
        com_google_android_gms_internal_zzaqa_zzb.zzbgE.zzaFy = str2;
        return com_google_android_gms_internal_zzaqa_zzb;
    }
}
