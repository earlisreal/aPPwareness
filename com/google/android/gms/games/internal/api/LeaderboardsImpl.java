package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.internal.zzzv.zzb;

public final class LeaderboardsImpl implements Leaderboards {

    private static abstract class LoadScoresImpl extends BaseGamesApiMethodImpl<LoadScoresResult> {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadScoresImpl.1 */
        class C06571 implements LoadScoresResult {
            final /* synthetic */ Status zzamf;

            C06571(LoadScoresImpl loadScoresImpl, Status status) {
                this.zzamf = status;
            }

            public Leaderboard getLeaderboard() {
                return null;
            }

            public LeaderboardScoreBuffer getScores() {
                return new LeaderboardScoreBuffer(DataHolder.zzcD(14));
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        private LoadScoresImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadScoresResult zzaz(Status status) {
            return new C06571(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaz(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.10 */
    class AnonymousClass10 extends LoadScoresImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, null, null, 0, 0, 0, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.11 */
    class AnonymousClass11 extends LoadScoresImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, null, null, 0, 0, 0, false);
        }
    }

    private static abstract class LoadMetadataImpl extends BaseGamesApiMethodImpl<LeaderboardMetadataResult> {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadMetadataImpl.1 */
        class C06551 implements LeaderboardMetadataResult {
            final /* synthetic */ Status zzamf;

            C06551(LoadMetadataImpl loadMetadataImpl, Status status) {
                this.zzamf = status;
            }

            public LeaderboardBuffer getLeaderboards() {
                return new LeaderboardBuffer(DataHolder.zzcD(14));
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        private LoadMetadataImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LeaderboardMetadataResult zzax(Status status) {
            return new C06551(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzax(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.1 */
    class C06461 extends LoadMetadataImpl {
        final /* synthetic */ boolean zzbaL;

        C06461(LeaderboardsImpl leaderboardsImpl, GoogleApiClient googleApiClient, boolean z) {
            this.zzbaL = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzbaL);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.2 */
    class C06472 extends LoadMetadataImpl {
        final /* synthetic */ boolean zzbaL;
        final /* synthetic */ String zzbaS;

        C06472(LeaderboardsImpl leaderboardsImpl, GoogleApiClient googleApiClient, String str, boolean z) {
            this.zzbaS = str;
            this.zzbaL = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzbaS, this.zzbaL);
        }
    }

    private static abstract class LoadPlayerScoreImpl extends BaseGamesApiMethodImpl<LoadPlayerScoreResult> {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadPlayerScoreImpl.1 */
        class C06561 implements LoadPlayerScoreResult {
            final /* synthetic */ Status zzamf;

            C06561(LoadPlayerScoreImpl loadPlayerScoreImpl, Status status) {
                this.zzamf = status;
            }

            public LeaderboardScore getScore() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        private LoadPlayerScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPlayerScoreResult zzay(Status status) {
            return new C06561(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzay(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.3 */
    class C06483 extends LoadPlayerScoreImpl {
        final /* synthetic */ String zzbaS;
        final /* synthetic */ int zzbaT;
        final /* synthetic */ int zzbaU;

        C06483(LeaderboardsImpl leaderboardsImpl, GoogleApiClient googleApiClient, String str, int i, int i2) {
            this.zzbaS = str;
            this.zzbaT = i;
            this.zzbaU = i2;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, this.zzbaS, this.zzbaT, this.zzbaU);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.4 */
    class C06494 extends LoadScoresImpl {
        final /* synthetic */ boolean zzbaL;
        final /* synthetic */ String zzbaS;
        final /* synthetic */ int zzbaT;
        final /* synthetic */ int zzbaU;
        final /* synthetic */ int zzbaV;

        C06494(LeaderboardsImpl leaderboardsImpl, GoogleApiClient googleApiClient, String str, int i, int i2, int i3, boolean z) {
            this.zzbaS = str;
            this.zzbaT = i;
            this.zzbaU = i2;
            this.zzbaV = i3;
            this.zzbaL = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbaS, this.zzbaT, this.zzbaU, this.zzbaV, this.zzbaL);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.5 */
    class C06505 extends LoadScoresImpl {
        final /* synthetic */ boolean zzbaL;
        final /* synthetic */ String zzbaS;
        final /* synthetic */ int zzbaT;
        final /* synthetic */ int zzbaU;
        final /* synthetic */ int zzbaV;

        C06505(LeaderboardsImpl leaderboardsImpl, GoogleApiClient googleApiClient, String str, int i, int i2, int i3, boolean z) {
            this.zzbaS = str;
            this.zzbaT = i;
            this.zzbaU = i2;
            this.zzbaV = i3;
            this.zzbaL = z;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzbaS, this.zzbaT, this.zzbaU, this.zzbaV, this.zzbaL);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.6 */
    class C06516 extends LoadScoresImpl {
        final /* synthetic */ int zzbaV;
        final /* synthetic */ LeaderboardScoreBuffer zzbaW;
        final /* synthetic */ int zzbaX;

        C06516(LeaderboardsImpl leaderboardsImpl, GoogleApiClient googleApiClient, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
            this.zzbaW = leaderboardScoreBuffer;
            this.zzbaV = i;
            this.zzbaX = i2;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbaW, this.zzbaV, this.zzbaX);
        }
    }

    protected static abstract class SubmitScoreImpl extends BaseGamesApiMethodImpl<SubmitScoreResult> {

        /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.SubmitScoreImpl.1 */
        class C06581 implements SubmitScoreResult {
            final /* synthetic */ Status zzamf;

            C06581(SubmitScoreImpl submitScoreImpl, Status status) {
                this.zzamf = status;
            }

            public ScoreSubmissionData getScoreData() {
                return new ScoreSubmissionData(DataHolder.zzcD(14));
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        protected SubmitScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public SubmitScoreResult zzaA(Status status) {
            return new C06581(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaA(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.7 */
    class C06527 extends SubmitScoreImpl {
        final /* synthetic */ String zzbaS;
        final /* synthetic */ long zzbaY;
        final /* synthetic */ String zzbaZ;

        C06527(LeaderboardsImpl leaderboardsImpl, GoogleApiClient googleApiClient, String str, long j, String str2) {
            this.zzbaS = str;
            this.zzbaY = j;
            this.zzbaZ = str2;
            super(googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbaS, this.zzbaY, this.zzbaZ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.8 */
    class C06538 extends LoadMetadataImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, null, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl.9 */
    class C06549 extends LoadMetadataImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, null, false);
        }
    }

    public Intent getAllLeaderboardsIntent(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEe();
    }

    public Intent getLeaderboardIntent(GoogleApiClient googleApiClient, String str) {
        return getLeaderboardIntent(googleApiClient, str, -1);
    }

    public Intent getLeaderboardIntent(GoogleApiClient googleApiClient, String str, int i) {
        return getLeaderboardIntent(googleApiClient, str, i, -1);
    }

    public Intent getLeaderboardIntent(GoogleApiClient googleApiClient, String str, int i, int i2) {
        return Games.zzi(googleApiClient).zzl(str, i, i2);
    }

    public PendingResult<LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient googleApiClient, String str, int i, int i2) {
        return googleApiClient.zza(new C06483(this, googleApiClient, str, i, i2));
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient googleApiClient, String str, boolean z) {
        return googleApiClient.zza(new C06472(this, googleApiClient, str, z));
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.zza(new C06461(this, googleApiClient, z));
    }

    public PendingResult<LoadScoresResult> loadMoreScores(GoogleApiClient googleApiClient, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        return googleApiClient.zza(new C06516(this, googleApiClient, leaderboardScoreBuffer, i, i2));
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3) {
        return loadPlayerCenteredScores(googleApiClient, str, i, i2, i3, false);
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3, boolean z) {
        return googleApiClient.zza(new C06505(this, googleApiClient, str, i, i2, i3, z));
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3) {
        return loadTopScores(googleApiClient, str, i, i2, i3, false);
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3, boolean z) {
        return googleApiClient.zza(new C06494(this, googleApiClient, str, i, i2, i3, z));
    }

    public void submitScore(GoogleApiClient googleApiClient, String str, long j) {
        submitScore(googleApiClient, str, j, null);
    }

    public void submitScore(GoogleApiClient googleApiClient, String str, long j, String str2) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            try {
                zzb.zza(null, str, j, str2);
            } catch (RemoteException e) {
                GamesLog.zzE("LeaderboardsImpl", "service died");
            }
        }
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient googleApiClient, String str, long j) {
        return submitScoreImmediate(googleApiClient, str, j, null);
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient googleApiClient, String str, long j, String str2) {
        return googleApiClient.zzb(new C06527(this, googleApiClient, str, j, str2));
    }
}
