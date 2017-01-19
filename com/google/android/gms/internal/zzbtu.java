package com.google.android.gms.internal;

import com.github.paolorotolo.appintro.C0394R;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbtu extends zzbun<zzbtu> {
    public int day;
    public int hour;
    public int minutes;
    public int month;
    public int seconds;
    public int year;

    public zzbtu() {
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.hour = 0;
        this.minutes = 0;
        this.seconds = 0;
        this.zzcsg = -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbtu)) {
            return false;
        }
        zzbtu com_google_android_gms_internal_zzbtu = (zzbtu) obj;
        return (this.year == com_google_android_gms_internal_zzbtu.year && this.month == com_google_android_gms_internal_zzbtu.month && this.day == com_google_android_gms_internal_zzbtu.day && this.hour == com_google_android_gms_internal_zzbtu.hour && this.minutes == com_google_android_gms_internal_zzbtu.minutes && this.seconds == com_google_android_gms_internal_zzbtu.seconds) ? (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbtu.zzcrX == null || com_google_android_gms_internal_zzbtu.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbtu.zzcrX) : false;
    }

    public int hashCode() {
        int hashCode = (((((((((((((getClass().getName().hashCode() + 527) * 31) + this.year) * 31) + this.month) * 31) + this.day) * 31) + this.hour) * 31) + this.minutes) * 31) + this.seconds) * 31;
        int hashCode2 = (this.zzcrX == null || this.zzcrX.isEmpty()) ? 0 : this.zzcrX.hashCode();
        return hashCode2 + hashCode;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        if (this.year != 0) {
            com_google_android_gms_internal_zzbum.zzF(1, this.year);
        }
        if (this.month != 0) {
            com_google_android_gms_internal_zzbum.zzF(2, this.month);
        }
        if (this.day != 0) {
            com_google_android_gms_internal_zzbum.zzF(3, this.day);
        }
        if (this.hour != 0) {
            com_google_android_gms_internal_zzbum.zzF(4, this.hour);
        }
        if (this.minutes != 0) {
            com_google_android_gms_internal_zzbum.zzF(5, this.minutes);
        }
        if (this.seconds != 0) {
            com_google_android_gms_internal_zzbum.zzF(6, this.seconds);
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbtu zzaq(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        while (true) {
            int zzacu = com_google_android_gms_internal_zzbul.zzacu();
            switch (zzacu) {
                case MessageApi.FILTER_LITERAL /*0*/:
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    this.year = com_google_android_gms_internal_zzbul.zzacy();
                    continue;
                case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                    this.month = com_google_android_gms_internal_zzbul.zzacy();
                    continue;
                case C0394R.styleable.Toolbar_navigationIcon /*24*/:
                    this.day = com_google_android_gms_internal_zzbul.zzacy();
                    continue;
                case Message.MAX_TYPE_LENGTH /*32*/:
                    this.hour = com_google_android_gms_internal_zzbul.zzacy();
                    continue;
                case C0394R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                    this.minutes = com_google_android_gms_internal_zzbul.zzacy();
                    continue;
                case C0394R.styleable.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                    this.seconds = com_google_android_gms_internal_zzbul.zzacy();
                    continue;
                default:
                    if (!super.zza(com_google_android_gms_internal_zzbul, zzacu)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        return zzaq(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int zzv = super.zzv();
        if (this.year != 0) {
            zzv += zzbum.zzH(1, this.year);
        }
        if (this.month != 0) {
            zzv += zzbum.zzH(2, this.month);
        }
        if (this.day != 0) {
            zzv += zzbum.zzH(3, this.day);
        }
        if (this.hour != 0) {
            zzv += zzbum.zzH(4, this.hour);
        }
        if (this.minutes != 0) {
            zzv += zzbum.zzH(5, this.minutes);
        }
        return this.seconds != 0 ? zzv + zzbum.zzH(6, this.seconds) : zzv;
    }
}
