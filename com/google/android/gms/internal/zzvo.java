package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

class zzvo implements ProxyResult {
    private Status zzahq;
    private ProxyResponse zzaiU;

    public zzvo(ProxyResponse proxyResponse) {
        this.zzaiU = proxyResponse;
        this.zzahq = Status.zzayh;
    }

    public zzvo(Status status) {
        this.zzahq = status;
    }

    public ProxyResponse getResponse() {
        return this.zzaiU;
    }

    public Status getStatus() {
        return this.zzahq;
    }
}
