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
import com.google.android.gms.games.Games.StatusImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadStockProfileImagesResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.Players.UpdateGamerProfileResult;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.player.ProfileSettingsEntity;
import com.google.android.gms.internal.zzzv.zzb;

public final class PlayersImpl implements Players {

    static abstract class LoadPlayersImpl extends BaseGamesApiMethodImpl<LoadPlayersResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadPlayersImpl.1 */
        class C06791 implements LoadPlayersResult {
            final /* synthetic */ Status zzamf;

            C06791(LoadPlayersImpl loadPlayersImpl, Status status) {
                this.zzamf = status;
            }

            public PlayerBuffer getPlayers() {
                return new PlayerBuffer(DataHolder.zzcD(14));
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        LoadPlayersImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPlayersResult zzaF(Status status) {
            return new C06791(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaF(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.10 */
    class AnonymousClass10 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "nearby", null, 0, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.11 */
    class AnonymousClass11 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", null, 0, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.12 */
    class AnonymousClass12 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", null, 0, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.13 */
    class AnonymousClass13 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, 0, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.14 */
    class AnonymousClass14 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, 0, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.15 */
    class AnonymousClass15 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, 0, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.16 */
    class AnonymousClass16 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, 0, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.17 */
    class AnonymousClass17 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, 0, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.18 */
    class AnonymousClass18 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, 0, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.19 */
    class AnonymousClass19 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, null, 0, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.1 */
    class C06701 extends LoadPlayersImpl {
        final /* synthetic */ String zzaul;

        C06701(PlayersImpl playersImpl, GoogleApiClient googleApiClient, String str) {
            this.zzaul = str;
            super(googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaul, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.20 */
    class AnonymousClass20 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, null, 0, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.21 */
    class AnonymousClass21 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, null, null, 0, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.22 */
    class AnonymousClass22 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, null, null, 0, true, false);
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends BaseGamesApiMethodImpl<LoadXpForGameCategoriesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpForGameCategoriesResultImpl.1 */
        class C06811 implements LoadXpForGameCategoriesResult {
            final /* synthetic */ Status zzamf;

            C06811(LoadXpForGameCategoriesResultImpl loadXpForGameCategoriesResultImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        public LoadXpForGameCategoriesResult zzaI(Status status) {
            return new C06811(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaI(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.23 */
    class AnonymousClass23 extends LoadXpForGameCategoriesResultImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl((zzb) this, null);
        }
    }

    private static abstract class LoadXpStreamResultImpl extends BaseGamesApiMethodImpl<LoadXpStreamResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpStreamResultImpl.1 */
        class C06821 implements LoadXpStreamResult {
            final /* synthetic */ Status zzamf;

            C06821(LoadXpStreamResultImpl loadXpStreamResultImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        public LoadXpStreamResult zzaJ(Status status) {
            return new C06821(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaJ(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.24 */
    class AnonymousClass24 extends LoadXpStreamResultImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, null, 0);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.25 */
    class AnonymousClass25 extends LoadXpStreamResultImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze((zzb) this, null, 0);
        }
    }

    private static abstract class LoadProfileSettingsResultImpl extends BaseGamesApiMethodImpl<LoadProfileSettingsResult> {
        protected LoadProfileSettingsResult zzaG(Status status) {
            return new ProfileSettingsEntity(DataHolder.zzcD(status.getStatusCode()));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzaG(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.26 */
    class AnonymousClass26 extends LoadProfileSettingsResultImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.27 */
    class AnonymousClass27 extends LoadProfileSettingsResultImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, false, true);
        }
    }

    private static abstract class UpdateProfileSettingsResultImpl extends BaseGamesApiMethodImpl<Status> {
        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.28 */
    class AnonymousClass28 extends UpdateProfileSettingsResultImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh((zzb) this, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.29 */
    class AnonymousClass29 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.2 */
    class C06712 extends LoadPlayersImpl {
        final /* synthetic */ String zzaul;
        final /* synthetic */ boolean zzbaL;

        C06712(PlayersImpl playersImpl, GoogleApiClient googleApiClient, String str, boolean z) {
            this.zzaul = str;
            this.zzbaL = z;
            super(googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaul, this.zzbaL);
        }
    }

    private static abstract class LoadStockProfileImagesImpl extends BaseGamesApiMethodImpl<LoadStockProfileImagesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.LoadStockProfileImagesImpl.1 */
        class C06801 implements LoadStockProfileImagesResult {
            final /* synthetic */ Status zzamf;

            C06801(LoadStockProfileImagesImpl loadStockProfileImagesImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        protected LoadStockProfileImagesResult zzaH(Status status) {
            return new C06801(this, status);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzaH(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.30 */
    class AnonymousClass30 extends LoadStockProfileImagesImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzr(this);
        }
    }

    private static abstract class UpdateGamerProfileImpl extends BaseGamesApiMethodImpl<UpdateGamerProfileResult> {

        /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.UpdateGamerProfileImpl.1 */
        class C06831 implements UpdateGamerProfileResult {
            final /* synthetic */ Status zzamf;

            C06831(UpdateGamerProfileImpl updateGamerProfileImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        protected UpdateGamerProfileResult zzaK(Status status) {
            return new C06831(this, status);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzaK(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.31 */
    class AnonymousClass31 extends UpdateGamerProfileImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, false, null, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.32 */
    class AnonymousClass32 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi((zzb) this, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.33 */
    class AnonymousClass33 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzj((zzb) this, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.34 */
    class AnonymousClass34 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzk((zzb) this, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.3 */
    class C06723 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.4 */
    class C06734 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzbaL;
        final /* synthetic */ int zzbbd;

        C06734(PlayersImpl playersImpl, GoogleApiClient googleApiClient, int i, boolean z) {
            this.zzbbd = i;
            this.zzbaL = z;
            super(googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbbd, false, this.zzbaL);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.5 */
    class C06745 extends LoadPlayersImpl {
        final /* synthetic */ int zzbbd;

        C06745(PlayersImpl playersImpl, GoogleApiClient googleApiClient, int i) {
            this.zzbbd = i;
            super(googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbbd, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.6 */
    class C06756 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzbaL;
        final /* synthetic */ int zzbbd;

        C06756(PlayersImpl playersImpl, GoogleApiClient googleApiClient, int i, boolean z) {
            this.zzbbd = i;
            this.zzbaL = z;
            super(googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzbbd, false, this.zzbaL);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.7 */
    class C06767 extends LoadPlayersImpl {
        final /* synthetic */ int zzbbd;

        C06767(PlayersImpl playersImpl, GoogleApiClient googleApiClient, int i) {
            this.zzbbd = i;
            super(googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzbbd, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.8 */
    class C06778 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzbaL;

        C06778(PlayersImpl playersImpl, GoogleApiClient googleApiClient, boolean z) {
            this.zzbaL = z;
            super(googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzbaL);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl.9 */
    class C06789 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "nearby", null, 0, false, false);
        }
    }

    public Intent getCompareProfileIntent(GoogleApiClient googleApiClient, Player player) {
        return Games.zzi(googleApiClient).zza(new PlayerEntity(player));
    }

    public Player getCurrentPlayer(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEc();
    }

    public String getCurrentPlayerId(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzax(true);
    }

    public Intent getPlayerSearchIntent(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEm();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.zza(new C06778(this, googleApiClient, z));
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient googleApiClient, int i, boolean z) {
        return googleApiClient.zza(new C06734(this, googleApiClient, i, z));
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.zza(new C06745(this, googleApiClient, i));
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.zza(new C06767(this, googleApiClient, i));
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.zza(new C06701(this, googleApiClient, str));
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, String str, boolean z) {
        return googleApiClient.zza(new C06712(this, googleApiClient, str, z));
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, int i, boolean z) {
        return googleApiClient.zza(new C06756(this, googleApiClient, i, z));
    }
}
