package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzd;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.concurrent.TimeUnit;

public interface HistoryApi {

    public static class ViewIntentBuilder {
        private long zzaIZ;
        private long zzaJa;
        private final DataType zzaQI;
        private DataSource zzaQJ;
        private String zzaQK;
        private final Context zzqr;

        public ViewIntentBuilder(Context context, DataType dataType) {
            this.zzqr = context;
            this.zzaQI = dataType;
        }

        private Intent zzk(Intent intent) {
            if (this.zzaQK == null) {
                return intent;
            }
            Intent intent2 = new Intent(intent).setPackage(this.zzaQK);
            ResolveInfo resolveActivity = this.zzqr.getPackageManager().resolveActivity(intent2, 0);
            if (resolveActivity == null) {
                return intent;
            }
            intent2.setComponent(new ComponentName(this.zzaQK, resolveActivity.activityInfo.name));
            return intent2;
        }

        public Intent build() {
            boolean z = true;
            zzac.zza(this.zzaIZ > 0, (Object) "Start time must be set");
            if (this.zzaJa <= this.zzaIZ) {
                z = false;
            }
            zzac.zza(z, (Object) "End time must be set and after start time");
            Intent intent = new Intent(Fitness.ACTION_VIEW);
            intent.setType(DataType.getMimeType(this.zzaQJ.getDataType()));
            intent.putExtra(Fitness.EXTRA_START_TIME, this.zzaIZ);
            intent.putExtra(Fitness.EXTRA_END_TIME, this.zzaJa);
            zzd.zza(this.zzaQJ, intent, DataSource.EXTRA_DATA_SOURCE);
            return zzk(intent);
        }

        public ViewIntentBuilder setDataSource(DataSource dataSource) {
            zzac.zzb(dataSource.getDataType().equals(this.zzaQI), "Data source %s is not for the data type %s", dataSource, this.zzaQI);
            this.zzaQJ = dataSource;
            return this;
        }

        public ViewIntentBuilder setPreferredApplication(String str) {
            this.zzaQK = str;
            return this;
        }

        public ViewIntentBuilder setTimeInterval(long j, long j2, TimeUnit timeUnit) {
            this.zzaIZ = timeUnit.toMillis(j);
            this.zzaJa = timeUnit.toMillis(j2);
            return this;
        }
    }

    PendingResult<Status> deleteData(GoogleApiClient googleApiClient, DataDeleteRequest dataDeleteRequest);

    PendingResult<Status> insertData(GoogleApiClient googleApiClient, DataSet dataSet);

    PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient googleApiClient, DataType dataType);

    PendingResult<DailyTotalResult> readDailyTotalFromLocalDevice(GoogleApiClient googleApiClient, DataType dataType);

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.BODY_SENSORS"}, conditional = true)
    PendingResult<DataReadResult> readData(GoogleApiClient googleApiClient, DataReadRequest dataReadRequest);

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.BODY_SENSORS"}, conditional = true)
    PendingResult<Status> registerDataUpdateListener(GoogleApiClient googleApiClient, DataUpdateListenerRegistrationRequest dataUpdateListenerRegistrationRequest);

    PendingResult<Status> unregisterDataUpdateListener(GoogleApiClient googleApiClient, PendingIntent pendingIntent);

    PendingResult<Status> updateData(GoogleApiClient googleApiClient, DataUpdateRequest dataUpdateRequest);
}
