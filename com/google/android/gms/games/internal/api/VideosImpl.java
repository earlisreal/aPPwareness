package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Games.StatusImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.games.video.Videos.CaptureAvailableResult;
import com.google.android.gms.games.video.Videos.CaptureCapabilitiesResult;
import com.google.android.gms.games.video.Videos.CaptureOverlayStateListener;
import com.google.android.gms.games.video.Videos.CaptureStateResult;
import com.google.android.gms.games.video.Videos.CaptureStoppedResult;
import com.google.android.gms.games.video.Videos.CaptureStreamingAvailabilityResult;
import com.google.android.gms.games.video.Videos.CaptureStreamingMetadataResult;
import com.google.android.gms.games.video.Videos.CaptureStreamingUrlResult;
import com.google.android.gms.games.video.Videos.ListVideosResult;
import com.google.android.gms.internal.zzzv.zzb;

public final class VideosImpl implements Videos {

    private static abstract class CaptureStopImpl extends BaseGamesApiMethodImpl<CaptureStoppedResult> {

        /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.CaptureStopImpl.1 */
        class C07551 implements CaptureStoppedResult {
            final /* synthetic */ Status zzamf;

            C07551(CaptureStopImpl captureStopImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        public CaptureStoppedResult zzbi(Status status) {
            return new C07551(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbi(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.10 */
    class AnonymousClass10 extends CaptureStopImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzq(this);
        }
    }

    private static abstract class CaptureStreamingMetadataImpl extends BaseGamesApiMethodImpl<CaptureStreamingMetadataResult> {

        /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.CaptureStreamingMetadataImpl.1 */
        class C07571 implements CaptureStreamingMetadataResult {
            final /* synthetic */ Status zzamf;

            C07571(CaptureStreamingMetadataImpl captureStreamingMetadataImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        public CaptureStreamingMetadataResult zzbk(Status status) {
            return new C07571(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbk(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.11 */
    class AnonymousClass11 extends CaptureStreamingMetadataImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl(this);
        }
    }

    private static abstract class CaptureStreamingUrlImpl extends BaseGamesApiMethodImpl<CaptureStreamingUrlResult> {

        /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.CaptureStreamingUrlImpl.1 */
        class C07581 implements CaptureStreamingUrlResult {
            final /* synthetic */ Status zzamf;

            C07581(CaptureStreamingUrlImpl captureStreamingUrlImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public String getUrl() {
                return null;
            }
        }

        public CaptureStreamingUrlResult zzbl(Status status) {
            return new C07581(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbl(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.12 */
    class AnonymousClass12 extends CaptureStreamingUrlImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzm(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.13 */
    class AnonymousClass13 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((BaseGamesApiMethodImpl) this, null, null);
        }
    }

    private static abstract class ListVideosImpl extends BaseGamesApiMethodImpl<ListVideosResult> {

        /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.ListVideosImpl.1 */
        class C07591 implements ListVideosResult {
            final /* synthetic */ Status zzamf;

            C07591(ListVideosImpl listVideosImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        public ListVideosResult zzbm(Status status) {
            return new C07591(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbm(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.14 */
    class AnonymousClass14 extends ListVideosImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, null, 0);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.15 */
    class AnonymousClass15 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, null, false);
        }
    }

    private static abstract class CaptureCapabilitiesImpl extends BaseGamesApiMethodImpl<CaptureCapabilitiesResult> {

        /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.CaptureCapabilitiesImpl.1 */
        class C07531 implements CaptureCapabilitiesResult {
            final /* synthetic */ Status zzamf;

            C07531(CaptureCapabilitiesImpl captureCapabilitiesImpl, Status status) {
                this.zzamf = status;
            }

            public VideoCapabilities getCapabilities() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        private CaptureCapabilitiesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public CaptureCapabilitiesResult zzbg(Status status) {
            return new C07531(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbg(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.1 */
    class C07431 extends CaptureCapabilitiesImpl {
        C07431(VideosImpl videosImpl, GoogleApiClient googleApiClient) {
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi(this);
        }
    }

    private static abstract class CaptureStateImpl extends BaseGamesApiMethodImpl<CaptureStateResult> {

        /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.CaptureStateImpl.1 */
        class C07541 implements CaptureStateResult {
            final /* synthetic */ Status zzamf;

            C07541(CaptureStateImpl captureStateImpl, Status status) {
                this.zzamf = status;
            }

            public CaptureState getCaptureState() {
                return null;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        private CaptureStateImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public CaptureStateResult zzbh(Status status) {
            return new C07541(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbh(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.2 */
    class C07442 extends CaptureStateImpl {
        C07442(VideosImpl videosImpl, GoogleApiClient googleApiClient) {
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzj(this);
        }
    }

    private static abstract class CaptureStreamingAvailabilityImpl extends BaseGamesApiMethodImpl<CaptureStreamingAvailabilityResult> {

        /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.CaptureStreamingAvailabilityImpl.1 */
        class C07561 implements CaptureStreamingAvailabilityResult {
            final /* synthetic */ Status zzamf;

            C07561(CaptureStreamingAvailabilityImpl captureStreamingAvailabilityImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }
        }

        public CaptureStreamingAvailabilityResult zzbj(Status status) {
            return new C07561(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbj(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.3 */
    class C07453 extends CaptureStreamingAvailabilityImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzk(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.4 */
    class C07464 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzn(this);
        }
    }

    private static abstract class CaptureAvailableImpl extends BaseGamesApiMethodImpl<CaptureAvailableResult> {

        /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.CaptureAvailableImpl.1 */
        class C07521 implements CaptureAvailableResult {
            final /* synthetic */ Status zzamf;

            C07521(CaptureAvailableImpl captureAvailableImpl, Status status) {
                this.zzamf = status;
            }

            public Status getStatus() {
                return this.zzamf;
            }

            public boolean isAvailable() {
                return false;
            }
        }

        private CaptureAvailableImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public CaptureAvailableResult zzbf(Status status) {
            return new C07521(this, status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbf(status);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.5 */
    class C07475 extends CaptureAvailableImpl {
        final /* synthetic */ int zzbbD;

        C07475(VideosImpl videosImpl, GoogleApiClient googleApiClient, int i) {
            this.zzbbD = i;
            super(null);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzbbD);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.6 */
    class C07486 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzo(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.7 */
    class C07497 extends ListVideosImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzp(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.8 */
    class C07508 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg((zzb) this, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.VideosImpl.9 */
    class C07519 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, null);
        }
    }

    public PendingResult<CaptureCapabilitiesResult> getCaptureCapabilities(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C07431(this, googleApiClient));
    }

    public Intent getCaptureOverlayIntent(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEv();
    }

    public PendingResult<CaptureStateResult> getCaptureState(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new C07442(this, googleApiClient));
    }

    public PendingResult<CaptureAvailableResult> isCaptureAvailable(GoogleApiClient googleApiClient, int i) {
        return googleApiClient.zza(new C07475(this, googleApiClient, i));
    }

    public boolean isCaptureSupported(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEw();
    }

    public void registerCaptureOverlayStateChangedListener(GoogleApiClient googleApiClient, CaptureOverlayStateListener captureOverlayStateListener) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zze(googleApiClient.zzr(captureOverlayStateListener));
        }
    }

    public void unregisterCaptureOverlayStateChangedListener(GoogleApiClient googleApiClient) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzEx();
        }
    }
}
