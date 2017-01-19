package com.google.android.gms.internal;

import com.google.android.gms.common.zzc;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;

public class zzrv {
    public static final String VERSION;
    public static final String zzacP;

    static {
        VERSION = String.valueOf(zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE / CardNetwork.OTHER).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
        String str = "ma";
        String valueOf = String.valueOf(VERSION);
        zzacP = valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }
}
