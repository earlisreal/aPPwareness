package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;
import com.google.android.gms.internal.zzzv.zzb;

public final class StatsImpl implements Stats {

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadPlayerStatsResult> {

        /* renamed from: com.google.android.gms.games.internal.api.StatsImpl.LoadsImpl.1 */
        class C07271 implements LoadPlayerStatsResult {
            final /* synthetic */ Status zzamf;

            C07271(LoadsImpl loadsImpl, Status status) {
                this.zzamf = status;
            }

            public PlayerStats getPlayerStats() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        private LoadsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPlayerStatsResult zzaY(Status status) {
            return new C07271(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaY(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.StatsImpl.1 */
    class C07261 extends LoadsImpl {
        final /* synthetic */ boolean zzbaL;

        C07261(StatsImpl statsImpl, GoogleApiClient googleApiClient, boolean z) {
            this.zzbaL = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze((zzb) this, this.zzbaL);
        }
    }

    public PendingResult<LoadPlayerStatsResult> loadPlayerStats(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.zza(new C07261(this, googleApiClient, z));
    }
}
