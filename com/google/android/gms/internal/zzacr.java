package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.internal.zzack.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzacr extends zzacl {
    public static final Creator<zzacr> CREATOR;
    private final String mClassName;
    private final int mVersionCode;
    private final zzaco zzaFI;
    private final Parcel zzaFP;
    private final int zzaFQ;
    private int zzaFR;
    private int zzaFS;

    static {
        CREATOR = new zzacs();
    }

    zzacr(int i, Parcel parcel, zzaco com_google_android_gms_internal_zzaco) {
        this.mVersionCode = i;
        this.zzaFP = (Parcel) zzac.zzw(parcel);
        this.zzaFQ = 2;
        this.zzaFI = com_google_android_gms_internal_zzaco;
        if (this.zzaFI == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.zzaFI.zzxY();
        }
        this.zzaFR = 2;
    }

    private static SparseArray<Entry<String, zza<?, ?>>> zzX(Map<String, zza<?, ?>> map) {
        SparseArray<Entry<String, zza<?, ?>>> sparseArray = new SparseArray();
        for (Entry entry : map.entrySet()) {
            sparseArray.put(((zza) entry.getValue()).zzxQ(), entry);
        }
        return sparseArray;
    }

    private void zza(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case MessageApi.FILTER_LITERAL /*0*/:
            case MessageApi.FILTER_PREFIX /*1*/:
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
            case Dimension.UNIT_IN /*4*/:
            case Dimension.UNIT_MM /*5*/:
            case BuyButtonText.LOGO_ONLY /*6*/:
                stringBuilder.append(obj);
            case BuyButtonText.DONATE_WITH /*7*/:
                stringBuilder.append("\"").append(zzp.zzdC(obj.toString())).append("\"");
            case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                stringBuilder.append("\"").append(zzc.zzq((byte[]) obj)).append("\"");
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                stringBuilder.append("\"").append(zzc.zzr((byte[]) obj));
                stringBuilder.append("\"");
            case ConnectionResult.DEVELOPER_ERROR /*10*/:
                zzq.zza(stringBuilder, (HashMap) obj);
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void zza(StringBuilder stringBuilder, zza<?, ?> com_google_android_gms_internal_zzack_zza___, Parcel parcel, int i) {
        switch (com_google_android_gms_internal_zzack_zza___.zzxN()) {
            case MessageApi.FILTER_LITERAL /*0*/:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzack_zza___, zza(com_google_android_gms_internal_zzack_zza___, Integer.valueOf(zzb.zzg(parcel, i))));
            case MessageApi.FILTER_PREFIX /*1*/:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzack_zza___, zza(com_google_android_gms_internal_zzack_zza___, zzb.zzk(parcel, i)));
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzack_zza___, zza(com_google_android_gms_internal_zzack_zza___, Long.valueOf(zzb.zzi(parcel, i))));
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzack_zza___, zza(com_google_android_gms_internal_zzack_zza___, Float.valueOf(zzb.zzl(parcel, i))));
            case Dimension.UNIT_IN /*4*/:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzack_zza___, zza(com_google_android_gms_internal_zzack_zza___, Double.valueOf(zzb.zzn(parcel, i))));
            case Dimension.UNIT_MM /*5*/:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzack_zza___, zza(com_google_android_gms_internal_zzack_zza___, zzb.zzp(parcel, i)));
            case BuyButtonText.LOGO_ONLY /*6*/:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzack_zza___, zza(com_google_android_gms_internal_zzack_zza___, Boolean.valueOf(zzb.zzc(parcel, i))));
            case BuyButtonText.DONATE_WITH /*7*/:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzack_zza___, zza(com_google_android_gms_internal_zzack_zza___, zzb.zzq(parcel, i)));
            case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzack_zza___, zza(com_google_android_gms_internal_zzack_zza___, zzb.zzt(parcel, i)));
            case ConnectionResult.DEVELOPER_ERROR /*10*/:
                zzb(stringBuilder, (zza) com_google_android_gms_internal_zzack_zza___, zza(com_google_android_gms_internal_zzack_zza___, zzr(zzb.zzs(parcel, i))));
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + com_google_android_gms_internal_zzack_zza___.zzxN());
        }
    }

    private void zza(StringBuilder stringBuilder, String str, zza<?, ?> com_google_android_gms_internal_zzack_zza___, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (com_google_android_gms_internal_zzack_zza___.zzxT()) {
            zza(stringBuilder, com_google_android_gms_internal_zzack_zza___, parcel, i);
        } else {
            zzb(stringBuilder, com_google_android_gms_internal_zzack_zza___, parcel, i);
        }
    }

    private void zza(StringBuilder stringBuilder, Map<String, zza<?, ?>> map, Parcel parcel) {
        SparseArray zzX = zzX(map);
        stringBuilder.append('{');
        int zzaU = zzb.zzaU(parcel);
        Object obj = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            Entry entry = (Entry) zzX.get(zzb.zzcW(zzaT));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                zza(stringBuilder, (String) entry.getKey(), (zza) entry.getValue(), parcel, zzaT);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != zzaU) {
            throw new zzb.zza("Overread allowed size end=" + zzaU, parcel);
        }
        stringBuilder.append('}');
    }

    private void zzb(StringBuilder stringBuilder, zza<?, ?> com_google_android_gms_internal_zzack_zza___, Parcel parcel, int i) {
        if (com_google_android_gms_internal_zzack_zza___.zzxO()) {
            stringBuilder.append("[");
            switch (com_google_android_gms_internal_zzack_zza___.zzxN()) {
                case MessageApi.FILTER_LITERAL /*0*/:
                    com.google.android.gms.common.util.zzb.zza(stringBuilder, zzb.zzw(parcel, i));
                    break;
                case MessageApi.FILTER_PREFIX /*1*/:
                    com.google.android.gms.common.util.zzb.zza(stringBuilder, zzb.zzy(parcel, i));
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    com.google.android.gms.common.util.zzb.zza(stringBuilder, zzb.zzx(parcel, i));
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    com.google.android.gms.common.util.zzb.zza(stringBuilder, zzb.zzz(parcel, i));
                    break;
                case Dimension.UNIT_IN /*4*/:
                    com.google.android.gms.common.util.zzb.zza(stringBuilder, zzb.zzA(parcel, i));
                    break;
                case Dimension.UNIT_MM /*5*/:
                    com.google.android.gms.common.util.zzb.zza(stringBuilder, zzb.zzB(parcel, i));
                    break;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    com.google.android.gms.common.util.zzb.zza(stringBuilder, zzb.zzv(parcel, i));
                    break;
                case BuyButtonText.DONATE_WITH /*7*/:
                    com.google.android.gms.common.util.zzb.zza(stringBuilder, zzb.zzC(parcel, i));
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    Parcel[] zzG = zzb.zzG(parcel, i);
                    int length = zzG.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        zzG[i2].setDataPosition(0);
                        zza(stringBuilder, com_google_android_gms_internal_zzack_zza___.zzxV(), zzG[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (com_google_android_gms_internal_zzack_zza___.zzxN()) {
            case MessageApi.FILTER_LITERAL /*0*/:
                stringBuilder.append(zzb.zzg(parcel, i));
            case MessageApi.FILTER_PREFIX /*1*/:
                stringBuilder.append(zzb.zzk(parcel, i));
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                stringBuilder.append(zzb.zzi(parcel, i));
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                stringBuilder.append(zzb.zzl(parcel, i));
            case Dimension.UNIT_IN /*4*/:
                stringBuilder.append(zzb.zzn(parcel, i));
            case Dimension.UNIT_MM /*5*/:
                stringBuilder.append(zzb.zzp(parcel, i));
            case BuyButtonText.LOGO_ONLY /*6*/:
                stringBuilder.append(zzb.zzc(parcel, i));
            case BuyButtonText.DONATE_WITH /*7*/:
                stringBuilder.append("\"").append(zzp.zzdC(zzb.zzq(parcel, i))).append("\"");
            case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                stringBuilder.append("\"").append(zzc.zzq(zzb.zzt(parcel, i))).append("\"");
            case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                stringBuilder.append("\"").append(zzc.zzr(zzb.zzt(parcel, i)));
                stringBuilder.append("\"");
            case ConnectionResult.DEVELOPER_ERROR /*10*/:
                Bundle zzs = zzb.zzs(parcel, i);
                Set<String> keySet = zzs.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(zzp.zzdC(zzs.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                Parcel zzF = zzb.zzF(parcel, i);
                zzF.setDataPosition(0);
                zza(stringBuilder, com_google_android_gms_internal_zzack_zza___.zzxV(), zzF);
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void zzb(StringBuilder stringBuilder, zza<?, ?> com_google_android_gms_internal_zzack_zza___, Object obj) {
        if (com_google_android_gms_internal_zzack_zza___.zzxM()) {
            zzb(stringBuilder, (zza) com_google_android_gms_internal_zzack_zza___, (ArrayList) obj);
        } else {
            zza(stringBuilder, com_google_android_gms_internal_zzack_zza___.zzxL(), obj);
        }
    }

    private void zzb(StringBuilder stringBuilder, zza<?, ?> com_google_android_gms_internal_zzack_zza___, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            zza(stringBuilder, com_google_android_gms_internal_zzack_zza___.zzxL(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    public static HashMap<String, String> zzr(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        zzac.zzb(this.zzaFI, (Object) "Cannot convert to JSON on client side.");
        Parcel zzya = zzya();
        zzya.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        zza(stringBuilder, this.zzaFI.zzdA(this.mClassName), zzya);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzacs.zza(this, parcel, i);
    }

    public Object zzdw(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public boolean zzdx(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public Map<String, zza<?, ?>> zzxK() {
        return this.zzaFI == null ? null : this.zzaFI.zzdA(this.mClassName);
    }

    public Parcel zzya() {
        switch (this.zzaFR) {
            case MessageApi.FILTER_LITERAL /*0*/:
                this.zzaFS = com.google.android.gms.common.internal.safeparcel.zzc.zzaV(this.zzaFP);
                com.google.android.gms.common.internal.safeparcel.zzc.zzJ(this.zzaFP, this.zzaFS);
                this.zzaFR = 2;
                break;
            case MessageApi.FILTER_PREFIX /*1*/:
                com.google.android.gms.common.internal.safeparcel.zzc.zzJ(this.zzaFP, this.zzaFS);
                this.zzaFR = 2;
                break;
        }
        return this.zzaFP;
    }

    zzaco zzyb() {
        switch (this.zzaFQ) {
            case MessageApi.FILTER_LITERAL /*0*/:
                return null;
            case MessageApi.FILTER_PREFIX /*1*/:
                return this.zzaFI;
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return this.zzaFI;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.zzaFQ);
        }
    }
}
