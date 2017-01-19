package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public interface zzua extends IInterface {

    public static abstract class zza extends Binder implements zzua {

        private static class zza implements zzua {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(com.google.android.gms.internal.zztr.zza com_google_android_gms_internal_zztr_zza, zzub com_google_android_gms_internal_zzub) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    if (com_google_android_gms_internal_zztr_zza != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_internal_zztr_zza.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzub != null ? com_google_android_gms_internal_zzub.asBinder() : null);
                    this.zzrp.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzub com_google_android_gms_internal_zzub) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzub != null ? com_google_android_gms_internal_zzub.asBinder() : null);
                    this.zzrp.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzub com_google_android_gms_internal_zzub, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzub != null ? com_google_android_gms_internal_zzub.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zzrp.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzub com_google_android_gms_internal_zzub, String str, zztx[] com_google_android_gms_internal_zztxArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzub != null ? com_google_android_gms_internal_zzub.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeTypedArray(com_google_android_gms_internal_zztxArr, 0);
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzub com_google_android_gms_internal_zzub, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzub != null ? com_google_android_gms_internal_zzub.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zzrp.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzub com_google_android_gms_internal_zzub, com.google.firebase.appindexing.internal.zza[] com_google_firebase_appindexing_internal_zzaArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzub != null ? com_google_android_gms_internal_zzub.asBinder() : null);
                    obtain.writeTypedArray(com_google_firebase_appindexing_internal_zzaArr, 0);
                    this.zzrp.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzub com_google_android_gms_internal_zzub) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    obtain.writeStrongBinder(com_google_android_gms_internal_zzub != null ? com_google_android_gms_internal_zzub.asBinder() : null);
                    this.zzrp.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzua zzan(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzua)) ? new zza(iBinder) : (zzua) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(com.google.android.gms.internal.zzub.zza.zzao(parcel.readStrongBinder()), parcel.readString(), (zztx[]) parcel.createTypedArray(zztx.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(com.google.android.gms.internal.zzub.zza.zzao(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zzb(com.google.android.gms.internal.zzub.zza.zzao(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_IN /*4*/:
                    parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(com.google.android.gms.internal.zzub.zza.zzao(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case Dimension.UNIT_MM /*5*/:
                    parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(parcel.readInt() != 0 ? (com.google.android.gms.internal.zztr.zza) com.google.android.gms.internal.zztr.zza.CREATOR.createFromParcel(parcel) : null, com.google.android.gms.internal.zzub.zza.zzao(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.LOGO_ONLY /*6*/:
                    parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(com.google.android.gms.internal.zzub.zza.zzao(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case BuyButtonText.DONATE_WITH /*7*/:
                    parcel.enforceInterface("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    zza(com.google.android.gms.internal.zzub.zza.zzao(parcel.readStrongBinder()), (com.google.firebase.appindexing.internal.zza[]) parcel.createTypedArray(com.google.firebase.appindexing.internal.zza.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(com.google.android.gms.internal.zztr.zza com_google_android_gms_internal_zztr_zza, zzub com_google_android_gms_internal_zzub) throws RemoteException;

    void zza(zzub com_google_android_gms_internal_zzub) throws RemoteException;

    void zza(zzub com_google_android_gms_internal_zzub, String str, String str2) throws RemoteException;

    void zza(zzub com_google_android_gms_internal_zzub, String str, zztx[] com_google_android_gms_internal_zztxArr) throws RemoteException;

    void zza(zzub com_google_android_gms_internal_zzub, boolean z) throws RemoteException;

    void zza(zzub com_google_android_gms_internal_zzub, com.google.firebase.appindexing.internal.zza[] com_google_firebase_appindexing_internal_zzaArr) throws RemoteException;

    void zzb(zzub com_google_android_gms_internal_zzub) throws RemoteException;
}
