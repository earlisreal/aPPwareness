package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.util.zzo;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@zzmb
public final class zzms extends zza {
    public static final Creator<zzms> CREATOR;
    final int mVersionCode;
    ParcelFileDescriptor zzSn;
    private Parcelable zzSo;
    private boolean zzSp;

    /* renamed from: com.google.android.gms.internal.zzms.1 */
    class C14311 implements Runnable {
        final /* synthetic */ OutputStream zzSq;
        final /* synthetic */ byte[] zzSr;

        C14311(zzms com_google_android_gms_internal_zzms, OutputStream outputStream, byte[] bArr) {
            this.zzSq = outputStream;
            this.zzSr = bArr;
        }

        public void run() {
            Throwable e;
            Closeable dataOutputStream;
            try {
                dataOutputStream = new DataOutputStream(this.zzSq);
                try {
                    dataOutputStream.writeInt(this.zzSr.length);
                    dataOutputStream.write(this.zzSr);
                    zzo.zzb(dataOutputStream);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        zzpy.zzb("Error transporting the ad response", e);
                        zzv.zzcN().zza(e, "LargeParcelTeleporter.pipeData.1");
                        if (dataOutputStream != null) {
                            zzo.zzb(this.zzSq);
                        } else {
                            zzo.zzb(dataOutputStream);
                        }
                    } catch (Throwable th) {
                        e = th;
                        if (dataOutputStream != null) {
                            zzo.zzb(this.zzSq);
                        } else {
                            zzo.zzb(dataOutputStream);
                        }
                        throw e;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                dataOutputStream = null;
                zzpy.zzb("Error transporting the ad response", e);
                zzv.zzcN().zza(e, "LargeParcelTeleporter.pipeData.1");
                if (dataOutputStream != null) {
                    zzo.zzb(dataOutputStream);
                } else {
                    zzo.zzb(this.zzSq);
                }
            } catch (Throwable th2) {
                e = th2;
                dataOutputStream = null;
                if (dataOutputStream != null) {
                    zzo.zzb(dataOutputStream);
                } else {
                    zzo.zzb(this.zzSq);
                }
                throw e;
            }
        }
    }

    static {
        CREATOR = new zzmt();
    }

    zzms(int i, ParcelFileDescriptor parcelFileDescriptor) {
        this.mVersionCode = i;
        this.zzSn = parcelFileDescriptor;
        this.zzSo = null;
        this.zzSp = true;
    }

    public zzms(SafeParcelable safeParcelable) {
        this.mVersionCode = 1;
        this.zzSn = null;
        this.zzSo = safeParcelable;
        this.zzSp = false;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.zzSn == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.zzSo.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                this.zzSn = zzj(marshall);
            } finally {
                obtain.recycle();
            }
        }
        zzmt.zza(this, parcel, i);
    }

    public <T extends SafeParcelable> T zza(Creator<T> creator) {
        if (this.zzSp) {
            if (this.zzSn == null) {
                zzpy.m28e("File descriptor is empty, returning null.");
                return null;
            }
            Closeable dataInputStream = new DataInputStream(new AutoCloseInputStream(this.zzSn));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr, 0, bArr.length);
                zzo.zzb(dataInputStream);
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.unmarshall(bArr, 0, bArr.length);
                    obtain.setDataPosition(0);
                    this.zzSo = (SafeParcelable) creator.createFromParcel(obtain);
                    this.zzSp = false;
                } finally {
                    obtain.recycle();
                }
            } catch (Throwable e) {
                throw new IllegalStateException("Could not read from parcel file descriptor", e);
            } catch (Throwable th) {
                zzo.zzb(dataInputStream);
            }
        }
        return (SafeParcelable) this.zzSo;
    }

    protected <T> ParcelFileDescriptor zzj(byte[] bArr) {
        Closeable autoCloseOutputStream;
        Throwable e;
        ParcelFileDescriptor parcelFileDescriptor = null;
        try {
            ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new AutoCloseOutputStream(createPipe[1]);
            try {
                new Thread(new C14311(this, autoCloseOutputStream, bArr)).start();
                return createPipe[0];
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            autoCloseOutputStream = parcelFileDescriptor;
            zzpy.zzb("Error transporting the ad response", e);
            zzv.zzcN().zza(e, "LargeParcelTeleporter.pipeData.2");
            zzo.zzb(autoCloseOutputStream);
            return parcelFileDescriptor;
        }
    }
}
