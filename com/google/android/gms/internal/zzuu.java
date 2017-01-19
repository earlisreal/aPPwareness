package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;

public final class zzuu {
    public static Intent zza(Context context, HintRequest hintRequest, PasswordSpecification passwordSpecification) {
        return new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("com.google.android.gms.credentials.RequestType", "Hints").putExtra("com.google.android.gms.credentials.HintRequest", hintRequest).putExtra("com.google.android.gms.credentials.PasswordSpecification", passwordSpecification);
    }
}
