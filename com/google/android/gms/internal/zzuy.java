package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.games.GamesStatusCodes;

public class zzuy {
    public static PendingIntent zza(Context context, AuthCredentialsOptions authCredentialsOptions, HintRequest hintRequest) {
        zzac.zzb((Object) context, (Object) "context must not be null");
        zzac.zzb((Object) hintRequest, (Object) "request must not be null");
        return PendingIntent.getActivity(context, GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS, zzuu.zza(context, hintRequest, zza(authCredentialsOptions)), DriveFile.MODE_READ_ONLY);
    }

    public static PasswordSpecification zza(AuthCredentialsOptions authCredentialsOptions) {
        return (authCredentialsOptions == null || authCredentialsOptions.zzqt() == null) ? PasswordSpecification.zzaiy : authCredentialsOptions.zzqt();
    }
}
