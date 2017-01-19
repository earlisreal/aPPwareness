package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.social.Social;
import com.google.android.gms.games.social.Social.InviteUpdateResult;
import com.google.android.gms.games.social.Social.LoadInvitesResult;
import com.google.android.gms.internal.zzzv.zzb;

public class SocialImpl implements Social {

    private static abstract class SocialInviteUpdateImpl extends BaseGamesApiMethodImpl<InviteUpdateResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.SocialInviteUpdateImpl.1 */
        class C07251 implements InviteUpdateResult {
            final /* synthetic */ Status zzamf;

            C07251(SocialInviteUpdateImpl socialInviteUpdateImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        public InviteUpdateResult zzaX(Status status) {
            return new C07251(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaX(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.1 */
    class C07151 extends SocialInviteUpdateImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzo((zzb) this, null);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.2 */
    class C07162 extends SocialInviteUpdateImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzp((zzb) this, null);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.3 */
    class C07173 extends SocialInviteUpdateImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzr(this, null);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.4 */
    class C07184 extends SocialInviteUpdateImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzq((zzb) this, null);
        }
    }

    private static abstract class LoadSocialInvitesImpl extends BaseGamesApiMethodImpl<LoadInvitesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.LoadSocialInvitesImpl.1 */
        class C07241 implements LoadInvitesResult {
            final /* synthetic */ Status zzamf;

            C07241(LoadSocialInvitesImpl loadSocialInvitesImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public void release() {
            }
        }

        public LoadInvitesResult zzaW(Status status) {
            return new C07241(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaW(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.5 */
    class C07195 extends LoadSocialInvitesImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, 0);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.6 */
    class C07206 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze(this, 0, false, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.7 */
    class C07217 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze(this, 0, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.8 */
    class C07228 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzs(this, null);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.SocialImpl.9 */
    class C07239 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf((zzb) this, null, false);
        }
    }
}
