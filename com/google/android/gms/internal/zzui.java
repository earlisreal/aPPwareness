package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.common.api.Status;

public class zzui implements AppInviteInvitationResult {
    private final Status zzahq;
    private final Intent zzahr;

    public zzui(Status status, Intent intent) {
        this.zzahq = status;
        this.zzahr = intent;
    }

    public Intent getInvitationIntent() {
        return this.zzahr;
    }

    public Status getStatus() {
        return this.zzahq;
    }
}
