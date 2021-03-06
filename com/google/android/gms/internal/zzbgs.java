package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.wearable.MessageApi;

public interface zzbgs extends IInterface {

    public static abstract class zza extends Binder implements zzbgs {

        private static class zza implements zzbgs {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public zzbgr zza(zzd com_google_android_gms_dynamic_zzd, zzbgo com_google_android_gms_internal_zzbgo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
                    obtain.writeStrongBinder(com_google_android_gms_dynamic_zzd != null ? com_google_android_gms_dynamic_zzd.asBinder() : null);
                    if (com_google_android_gms_internal_zzbgo != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zzbgo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzbgr zzfg = com.google.android.gms.internal.zzbgr.zza.zzfg(obtain2.readStrongBinder());
                    return zzfg;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzbgs zzfh(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzbgs)) ? new zza(iBinder) : (zzbgs) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IBinder iBinder = null;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
                    zzbgr zza = zza(com.google.android.gms.dynamic.zzd.zza.zzcd(parcel.readStrongBinder()), parcel.readInt() != 0 ? (zzbgo) zzbgo.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (zza != null) {
                        iBinder = zza.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzbgr zza(zzd com_google_android_gms_dynamic_zzd, zzbgo com_google_android_gms_internal_zzbgo) throws RemoteException;
}
