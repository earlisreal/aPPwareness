package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.drive.FileUploadPreferences;

public class zzbtm {
    private final byte[] zzcqh;
    private int zzcqi;
    private int zzcqj;

    public zzbtm(byte[] bArr) {
        int i;
        this.zzcqh = new byte[FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED];
        for (i = 0; i < FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED; i++) {
            this.zzcqh[i] = (byte) i;
        }
        i = 0;
        for (int i2 = 0; i2 < FileUploadPreferences.BATTERY_USAGE_UNRESTRICTED; i2++) {
            i = ((i + this.zzcqh[i2]) + bArr[i2 % bArr.length]) & MotionEventCompat.ACTION_MASK;
            byte b = this.zzcqh[i2];
            this.zzcqh[i2] = this.zzcqh[i];
            this.zzcqh[i] = b;
        }
        this.zzcqi = 0;
        this.zzcqj = 0;
    }

    public void zzY(byte[] bArr) {
        int i = this.zzcqi;
        int i2 = this.zzcqj;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & MotionEventCompat.ACTION_MASK;
            i2 = (i2 + this.zzcqh[i]) & MotionEventCompat.ACTION_MASK;
            byte b = this.zzcqh[i];
            this.zzcqh[i] = this.zzcqh[i2];
            this.zzcqh[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.zzcqh[(this.zzcqh[i] + this.zzcqh[i2]) & MotionEventCompat.ACTION_MASK]);
        }
        this.zzcqi = i;
        this.zzcqj = i2;
    }
}
