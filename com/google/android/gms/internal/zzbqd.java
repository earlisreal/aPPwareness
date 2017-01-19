package com.google.android.gms.internal;

public class zzbqd<T, U> {
    private final T first;
    private final U second;

    public zzbqd(T t, U u) {
        this.first = t;
        this.second = u;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzbqd com_google_android_gms_internal_zzbqd = (zzbqd) obj;
        if (this.first == null ? com_google_android_gms_internal_zzbqd.first != null : !this.first.equals(com_google_android_gms_internal_zzbqd.first)) {
            return false;
        }
        if (this.second != null) {
            if (this.second.equals(com_google_android_gms_internal_zzbqd.second)) {
                return true;
            }
        } else if (com_google_android_gms_internal_zzbqd.second == null) {
            return true;
        }
        return false;
    }

    public T getFirst() {
        return this.first;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.first != null ? this.first.hashCode() : 0) * 31;
        if (this.second != null) {
            i = this.second.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        String valueOf = String.valueOf(this.first);
        String valueOf2 = String.valueOf(this.second);
        return new StringBuilder((String.valueOf(valueOf).length() + 7) + String.valueOf(valueOf2).length()).append("Pair(").append(valueOf).append(",").append(valueOf2).append(")").toString();
    }

    public U zzZZ() {
        return this.second;
    }
}
