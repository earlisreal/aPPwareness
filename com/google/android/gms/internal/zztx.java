package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.plus.PlusShare;
import java.util.List;
import java.util.Locale;
import java.util.zip.CRC32;

public class zztx extends com.google.android.gms.common.internal.safeparcel.zza {
    public static final Creator<zztx> CREATOR;
    final int mVersionCode;
    public final String zzAD;
    final zztl zzagO;
    final long zzagP;
    int zzagQ;
    final zztj zzagR;
    final boolean zzagS;
    int zzagT;
    int zzagU;

    public static final class zza {
        private zztl zzagO;
        private long zzagP;
        private int zzagQ;
        private zztj zzagR;
        private boolean zzagS;
        private int zzagT;
        private int zzagU;

        public zza() {
            this.zzagP = -1;
            this.zzagQ = -1;
            this.zzagT = -1;
            this.zzagS = false;
            this.zzagU = 0;
        }

        public zza zzA(long j) {
            this.zzagP = j;
            return this;
        }

        public zza zza(zztj com_google_android_gms_internal_zztj) {
            this.zzagR = com_google_android_gms_internal_zztj;
            return this;
        }

        public zza zza(zztl com_google_android_gms_internal_zztl) {
            this.zzagO = com_google_android_gms_internal_zztl;
            return this;
        }

        public zza zzaQ(int i) {
            this.zzagQ = i;
            return this;
        }

        public zza zzaR(int i) {
            this.zzagU = i;
            return this;
        }

        public zza zzaa(boolean z) {
            this.zzagS = z;
            return this;
        }

        public zztx zzqi() {
            return new zztx(this.zzagP, this.zzagQ, null, this.zzagR, this.zzagS, this.zzagT, this.zzagU, null);
        }
    }

    static {
        CREATOR = new zzty();
    }

    zztx(int i, zztl com_google_android_gms_internal_zztl, long j, int i2, String str, zztj com_google_android_gms_internal_zztj, boolean z, int i3, int i4) {
        this.mVersionCode = i;
        this.zzagO = com_google_android_gms_internal_zztl;
        this.zzagP = j;
        this.zzagQ = i2;
        this.zzAD = str;
        this.zzagR = com_google_android_gms_internal_zztj;
        this.zzagS = z;
        this.zzagT = i3;
        this.zzagU = i4;
    }

    private zztx(zztl com_google_android_gms_internal_zztl, long j, int i, String str, zztj com_google_android_gms_internal_zztj, boolean z, int i2, int i3) {
        this(1, com_google_android_gms_internal_zztl, j, i, str, com_google_android_gms_internal_zztj, z, i2, i3);
    }

    public zztx(String str, Intent intent, String str2, Uri uri, String str3, List<AppIndexingLink> list, int i) {
        this(1, zza(str, intent), System.currentTimeMillis(), 0, null, zza(intent, str2, uri, str3, list).zzqe(), false, -1, i);
    }

    public static com.google.android.gms.internal.zztj.zza zza(Intent intent, String str, Uri uri, String str2, List<AppIndexingLink> list) {
        com.google.android.gms.internal.zztj.zza com_google_android_gms_internal_zztj_zza = new com.google.android.gms.internal.zztj.zza();
        com_google_android_gms_internal_zztj_zza.zza(zzco(str));
        if (uri != null) {
            com_google_android_gms_internal_zztj_zza.zza(zzk(uri));
        }
        if (list != null) {
            com_google_android_gms_internal_zztj_zza.zza(zzv(list));
        }
        String action = intent.getAction();
        if (action != null) {
            com_google_android_gms_internal_zztj_zza.zza(zzt("intent_action", action));
        }
        action = intent.getDataString();
        if (action != null) {
            com_google_android_gms_internal_zztj_zza.zza(zzt("intent_data", action));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            com_google_android_gms_internal_zztj_zza.zza(zzt("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            action = extras.getString("intent_extra_data_key");
            if (action != null) {
                com_google_android_gms_internal_zztj_zza.zza(zzt("intent_extra_data", action));
            }
        }
        return com_google_android_gms_internal_zztj_zza.zzck(str2).zzX(true);
    }

    public static zztl zza(String str, Intent intent) {
        return zzs(str, zzg(intent));
    }

    private static zztn zzco(String str) {
        return new zztn(str, new com.google.android.gms.internal.zztv.zza(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).zzaO(1).zzZ(true).zzcn("name").zzqh(), "text1");
    }

    private static String zzg(Intent intent) {
        String toUri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(toUri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    private static zztn zzk(Uri uri) {
        return new zztn(uri.toString(), new com.google.android.gms.internal.zztv.zza("web_url").zzaO(4).zzY(true).zzcn(PlusShare.KEY_CALL_TO_ACTION_URL).zzqh());
    }

    private static zztl zzs(String str, String str2) {
        return new zztl(str, BuildConfig.FLAVOR, str2);
    }

    private static zztn zzt(String str, String str2) {
        return new zztn(str2, new com.google.android.gms.internal.zztv.zza(str).zzY(true).zzqh(), str);
    }

    private static zztn zzv(List<AppIndexingLink> list) {
        zzbut com_google_android_gms_internal_zzaqa_zza = new com.google.android.gms.internal.zzaqa.zza();
        com.google.android.gms.internal.zzaqa.zza.zza[] com_google_android_gms_internal_zzaqa_zza_zzaArr = new com.google.android.gms.internal.zzaqa.zza.zza[list.size()];
        for (int i = 0; i < com_google_android_gms_internal_zzaqa_zza_zzaArr.length; i++) {
            com_google_android_gms_internal_zzaqa_zza_zzaArr[i] = new com.google.android.gms.internal.zzaqa.zza.zza();
            AppIndexingLink appIndexingLink = (AppIndexingLink) list.get(i);
            com_google_android_gms_internal_zzaqa_zza_zzaArr[i].zzbgB = appIndexingLink.appIndexingUrl.toString();
            com_google_android_gms_internal_zzaqa_zza_zzaArr[i].viewId = appIndexingLink.viewId;
            if (appIndexingLink.webUrl != null) {
                com_google_android_gms_internal_zzaqa_zza_zzaArr[i].zzbgC = appIndexingLink.webUrl.toString();
            }
        }
        com_google_android_gms_internal_zzaqa_zza.zzbgz = com_google_android_gms_internal_zzaqa_zza_zzaArr;
        return new zztn(zzbut.zzf(com_google_android_gms_internal_zzaqa_zza), new com.google.android.gms.internal.zztv.zza("outlinks").zzY(true).zzcn(".private:outLinks").zzcm("blob").zzqh());
    }

    public String toString() {
        return String.format(Locale.US, "UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[]{this.zzagO, Long.valueOf(this.zzagP), Integer.valueOf(this.zzagQ), Integer.valueOf(this.zzagU)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzty.zza(this, parcel, i);
    }
}
