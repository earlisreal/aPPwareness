package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.C0397R;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.zzn;
import com.google.android.gms.fitness.request.zzw;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;

public interface zzaog extends IInterface {

    public static abstract class zza extends Binder implements zzaog {

        private static class zza implements zzaog {
            private IBinder zzrp;

            zza(IBinder iBinder) {
                this.zzrp = iBinder;
            }

            public IBinder asBinder() {
                return this.zzrp;
            }

            public void zza(DataTypeCreateRequest dataTypeCreateRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (dataTypeCreateRequest != null) {
                        obtain.writeInt(1);
                        dataTypeCreateRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzn com_google_android_gms_fitness_request_zzn) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (com_google_android_gms_fitness_request_zzn != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzn.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzw com_google_android_gms_fitness_request_zzw) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (com_google_android_gms_fitness_request_zzw != null) {
                        obtain.writeInt(1);
                        com_google_android_gms_fitness_request_zzw.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzrp.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzaog zzcx(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaog)) ? new zza(iBinder) : (zzaog) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            zzw com_google_android_gms_fitness_request_zzw = null;
            switch (i) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    DataTypeCreateRequest dataTypeCreateRequest;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (parcel.readInt() != 0) {
                        dataTypeCreateRequest = (DataTypeCreateRequest) DataTypeCreateRequest.CREATOR.createFromParcel(parcel);
                    }
                    zza(dataTypeCreateRequest);
                    parcel2.writeNoException();
                    return true;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    zzn com_google_android_gms_fitness_request_zzn;
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzn = (zzn) zzn.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzn);
                    parcel2.writeNoException();
                    return true;
                case C0397R.styleable.MapAttrs_latLngBoundsNorthEastLongitude /*22*/:
                    parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    if (parcel.readInt() != 0) {
                        com_google_android_gms_fitness_request_zzw = (zzw) zzw.CREATOR.createFromParcel(parcel);
                    }
                    zza(com_google_android_gms_fitness_request_zzw);
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(DataTypeCreateRequest dataTypeCreateRequest) throws RemoteException;

    void zza(zzn com_google_android_gms_fitness_request_zzn) throws RemoteException;

    void zza(zzw com_google_android_gms_fitness_request_zzw) throws RemoteException;
}
