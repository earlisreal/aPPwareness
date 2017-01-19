package com.google.android.gms.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

public final class zzuv implements CredentialRequestResult {
    private final Status zzahq;
    private final Credential zzaiH;

    public zzuv(Status status, Credential credential) {
        this.zzahq = status;
        this.zzaiH = credential;
    }

    public static zzuv zzi(Status status) {
        return new zzuv(status, null);
    }

    public Credential getCredential() {
        return this.zzaiH;
    }

    public Status getStatus() {
        return this.zzahq;
    }
}
