package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.github.paolorotolo.appintro.C0394R;
import com.google.ads.AdSize;
import com.google.android.gms.C0397R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.io.IOException;

public final class zzbts extends zzbun<zzbts> {
    private static volatile zzbts[] zzcqG;
    public int type;
    public zzbts[] zzcqH;
    public zzbuj zzcqI;
    public zzbtz zzcqJ;
    public zzbud zzcqK;
    public zzbtn zzcqL;
    public zzbug zzcqM;
    public zzbue zzcqN;
    public zzbuc zzcqO;
    public zzbto zzcqP;
    public zzbtp zzcqQ;
    public zzbua zzcqR;
    public zzbuh zzcqS;
    public zzbuk zzcqT;
    public zzbtv zzcqU;
    public zzbtw zzcqV;
    public zzbub zzcqW;
    public zzbuf zzcqX;

    public zzbts() {
        this.type = 0;
        this.zzcqH = zzact();
        this.zzcsg = -1;
    }

    public static zzbts zzab(byte[] bArr) throws zzbus {
        return (zzbts) zzbut.zza(new zzbts(), bArr);
    }

    public static zzbts[] zzact() {
        if (zzcqG == null) {
            synchronized (zzbur.zzcsf) {
                if (zzcqG == null) {
                    zzcqG = new zzbts[0];
                }
            }
        }
        return zzcqG;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbts)) {
            return false;
        }
        zzbts com_google_android_gms_internal_zzbts = (zzbts) obj;
        if (this.type != com_google_android_gms_internal_zzbts.type || !zzbur.equals(this.zzcqH, com_google_android_gms_internal_zzbts.zzcqH)) {
            return false;
        }
        if (this.zzcqI == null) {
            if (com_google_android_gms_internal_zzbts.zzcqI != null) {
                return false;
            }
        } else if (!this.zzcqI.equals(com_google_android_gms_internal_zzbts.zzcqI)) {
            return false;
        }
        if (this.zzcqJ == null) {
            if (com_google_android_gms_internal_zzbts.zzcqJ != null) {
                return false;
            }
        } else if (!this.zzcqJ.equals(com_google_android_gms_internal_zzbts.zzcqJ)) {
            return false;
        }
        if (this.zzcqK == null) {
            if (com_google_android_gms_internal_zzbts.zzcqK != null) {
                return false;
            }
        } else if (!this.zzcqK.equals(com_google_android_gms_internal_zzbts.zzcqK)) {
            return false;
        }
        if (this.zzcqL == null) {
            if (com_google_android_gms_internal_zzbts.zzcqL != null) {
                return false;
            }
        } else if (!this.zzcqL.equals(com_google_android_gms_internal_zzbts.zzcqL)) {
            return false;
        }
        if (this.zzcqM == null) {
            if (com_google_android_gms_internal_zzbts.zzcqM != null) {
                return false;
            }
        } else if (!this.zzcqM.equals(com_google_android_gms_internal_zzbts.zzcqM)) {
            return false;
        }
        if (this.zzcqN == null) {
            if (com_google_android_gms_internal_zzbts.zzcqN != null) {
                return false;
            }
        } else if (!this.zzcqN.equals(com_google_android_gms_internal_zzbts.zzcqN)) {
            return false;
        }
        if (this.zzcqO == null) {
            if (com_google_android_gms_internal_zzbts.zzcqO != null) {
                return false;
            }
        } else if (!this.zzcqO.equals(com_google_android_gms_internal_zzbts.zzcqO)) {
            return false;
        }
        if (this.zzcqP == null) {
            if (com_google_android_gms_internal_zzbts.zzcqP != null) {
                return false;
            }
        } else if (!this.zzcqP.equals(com_google_android_gms_internal_zzbts.zzcqP)) {
            return false;
        }
        if (this.zzcqQ == null) {
            if (com_google_android_gms_internal_zzbts.zzcqQ != null) {
                return false;
            }
        } else if (!this.zzcqQ.equals(com_google_android_gms_internal_zzbts.zzcqQ)) {
            return false;
        }
        if (this.zzcqR == null) {
            if (com_google_android_gms_internal_zzbts.zzcqR != null) {
                return false;
            }
        } else if (!this.zzcqR.equals(com_google_android_gms_internal_zzbts.zzcqR)) {
            return false;
        }
        if (this.zzcqS == null) {
            if (com_google_android_gms_internal_zzbts.zzcqS != null) {
                return false;
            }
        } else if (!this.zzcqS.equals(com_google_android_gms_internal_zzbts.zzcqS)) {
            return false;
        }
        if (this.zzcqT == null) {
            if (com_google_android_gms_internal_zzbts.zzcqT != null) {
                return false;
            }
        } else if (!this.zzcqT.equals(com_google_android_gms_internal_zzbts.zzcqT)) {
            return false;
        }
        if (this.zzcqU == null) {
            if (com_google_android_gms_internal_zzbts.zzcqU != null) {
                return false;
            }
        } else if (!this.zzcqU.equals(com_google_android_gms_internal_zzbts.zzcqU)) {
            return false;
        }
        if (this.zzcqV == null) {
            if (com_google_android_gms_internal_zzbts.zzcqV != null) {
                return false;
            }
        } else if (!this.zzcqV.equals(com_google_android_gms_internal_zzbts.zzcqV)) {
            return false;
        }
        if (this.zzcqW == null) {
            if (com_google_android_gms_internal_zzbts.zzcqW != null) {
                return false;
            }
        } else if (!this.zzcqW.equals(com_google_android_gms_internal_zzbts.zzcqW)) {
            return false;
        }
        if (this.zzcqX == null) {
            if (com_google_android_gms_internal_zzbts.zzcqX != null) {
                return false;
            }
        } else if (!this.zzcqX.equals(com_google_android_gms_internal_zzbts.zzcqX)) {
            return false;
        }
        return (this.zzcrX == null || this.zzcrX.isEmpty()) ? com_google_android_gms_internal_zzbts.zzcrX == null || com_google_android_gms_internal_zzbts.zzcrX.isEmpty() : this.zzcrX.equals(com_google_android_gms_internal_zzbts.zzcrX);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.zzcqX == null ? 0 : this.zzcqX.hashCode()) + (((this.zzcqW == null ? 0 : this.zzcqW.hashCode()) + (((this.zzcqV == null ? 0 : this.zzcqV.hashCode()) + (((this.zzcqU == null ? 0 : this.zzcqU.hashCode()) + (((this.zzcqT == null ? 0 : this.zzcqT.hashCode()) + (((this.zzcqS == null ? 0 : this.zzcqS.hashCode()) + (((this.zzcqR == null ? 0 : this.zzcqR.hashCode()) + (((this.zzcqQ == null ? 0 : this.zzcqQ.hashCode()) + (((this.zzcqP == null ? 0 : this.zzcqP.hashCode()) + (((this.zzcqO == null ? 0 : this.zzcqO.hashCode()) + (((this.zzcqN == null ? 0 : this.zzcqN.hashCode()) + (((this.zzcqM == null ? 0 : this.zzcqM.hashCode()) + (((this.zzcqL == null ? 0 : this.zzcqL.hashCode()) + (((this.zzcqK == null ? 0 : this.zzcqK.hashCode()) + (((this.zzcqJ == null ? 0 : this.zzcqJ.hashCode()) + (((this.zzcqI == null ? 0 : this.zzcqI.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31) + zzbur.hashCode(this.zzcqH)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.zzcrX == null || this.zzcrX.isEmpty())) {
            i = this.zzcrX.hashCode();
        }
        return hashCode + i;
    }

    public void zza(zzbum com_google_android_gms_internal_zzbum) throws IOException {
        if (this.type != 0) {
            com_google_android_gms_internal_zzbum.zzF(1, this.type);
        }
        if (this.zzcqH != null && this.zzcqH.length > 0) {
            for (zzbut com_google_android_gms_internal_zzbut : this.zzcqH) {
                if (com_google_android_gms_internal_zzbut != null) {
                    com_google_android_gms_internal_zzbum.zza(2, com_google_android_gms_internal_zzbut);
                }
            }
        }
        if (this.zzcqI != null) {
            com_google_android_gms_internal_zzbum.zza(3, this.zzcqI);
        }
        if (this.zzcqJ != null) {
            com_google_android_gms_internal_zzbum.zza(4, this.zzcqJ);
        }
        if (this.zzcqK != null) {
            com_google_android_gms_internal_zzbum.zza(5, this.zzcqK);
        }
        if (this.zzcqL != null) {
            com_google_android_gms_internal_zzbum.zza(6, this.zzcqL);
        }
        if (this.zzcqM != null) {
            com_google_android_gms_internal_zzbum.zza(7, this.zzcqM);
        }
        if (this.zzcqN != null) {
            com_google_android_gms_internal_zzbum.zza(8, this.zzcqN);
        }
        if (this.zzcqO != null) {
            com_google_android_gms_internal_zzbum.zza(9, this.zzcqO);
        }
        if (this.zzcqP != null) {
            com_google_android_gms_internal_zzbum.zza(10, this.zzcqP);
        }
        if (this.zzcqQ != null) {
            com_google_android_gms_internal_zzbum.zza(11, this.zzcqQ);
        }
        if (this.zzcqR != null) {
            com_google_android_gms_internal_zzbum.zza(12, this.zzcqR);
        }
        if (this.zzcqS != null) {
            com_google_android_gms_internal_zzbum.zza(13, this.zzcqS);
        }
        if (this.zzcqT != null) {
            com_google_android_gms_internal_zzbum.zza(14, this.zzcqT);
        }
        if (this.zzcqU != null) {
            com_google_android_gms_internal_zzbum.zza(15, this.zzcqU);
        }
        if (this.zzcqV != null) {
            com_google_android_gms_internal_zzbum.zza(16, this.zzcqV);
        }
        if (this.zzcqW != null) {
            com_google_android_gms_internal_zzbum.zza(17, this.zzcqW);
        }
        if (this.zzcqX != null) {
            com_google_android_gms_internal_zzbum.zza(18, this.zzcqX);
        }
        super.zza(com_google_android_gms_internal_zzbum);
    }

    public zzbts zzao(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        while (true) {
            int zzacu = com_google_android_gms_internal_zzbul.zzacu();
            switch (zzacu) {
                case MessageApi.FILTER_LITERAL /*0*/:
                    break;
                case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                    zzacu = com_google_android_gms_internal_zzbul.zzacy();
                    switch (zzacu) {
                        case MessageApi.FILTER_LITERAL /*0*/:
                        case MessageApi.FILTER_PREFIX /*1*/:
                        case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                        case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                        case Dimension.UNIT_IN /*4*/:
                        case Dimension.UNIT_MM /*5*/:
                        case BuyButtonText.LOGO_ONLY /*6*/:
                        case BuyButtonText.DONATE_WITH /*7*/:
                        case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                        case GamesStatusCodes.STATUS_GAME_NOT_FOUND /*9*/:
                        case ConnectionResult.DEVELOPER_ERROR /*10*/:
                        case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                        case C0397R.styleable.MapAttrs_uiZoomGestures /*12*/:
                        case ConnectionResult.CANCELED /*13*/:
                        case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                        case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                        case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                        case ConnectionResult.SIGN_IN_FAILED /*17*/:
                        case ConnectionResult.SERVICE_UPDATING /*18*/:
                            this.type = zzacu;
                            break;
                        default:
                            continue;
                    }
                case ConnectionResult.SERVICE_UPDATING /*18*/:
                    int zzc = zzbuw.zzc(com_google_android_gms_internal_zzbul, 18);
                    zzacu = this.zzcqH == null ? 0 : this.zzcqH.length;
                    Object obj = new zzbts[(zzc + zzacu)];
                    if (zzacu != 0) {
                        System.arraycopy(this.zzcqH, 0, obj, 0, zzacu);
                    }
                    while (zzacu < obj.length - 1) {
                        obj[zzacu] = new zzbts();
                        com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                        com_google_android_gms_internal_zzbul.zzacu();
                        zzacu++;
                    }
                    obj[zzacu] = new zzbts();
                    com_google_android_gms_internal_zzbul.zza(obj[zzacu]);
                    this.zzcqH = obj;
                    continue;
                case C0394R.styleable.Toolbar_logoDescription /*26*/:
                    if (this.zzcqI == null) {
                        this.zzcqI = new zzbuj();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqI);
                    continue;
                case C0394R.styleable.AppCompatTheme_actionModePasteDrawable /*34*/:
                    if (this.zzcqJ == null) {
                        this.zzcqJ = new zzbtz();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqJ);
                    continue;
                case C0394R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /*42*/:
                    if (this.zzcqK == null) {
                        this.zzcqK = new zzbud();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqK);
                    continue;
                case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                    if (this.zzcqL == null) {
                        this.zzcqL = new zzbtn();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqL);
                    continue;
                case C0394R.styleable.AppCompatTheme_activityChooserViewStyle /*58*/:
                    if (this.zzcqM == null) {
                        this.zzcqM = new zzbug();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqM);
                    continue;
                case C0394R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                    if (this.zzcqN == null) {
                        this.zzcqN = new zzbue();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqN);
                    continue;
                case C0394R.styleable.AppCompatTheme_listPreferredItemPaddingRight /*74*/:
                    if (this.zzcqO == null) {
                        this.zzcqO = new zzbuc();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqO);
                    continue;
                case C0394R.styleable.AppCompatTheme_listChoiceBackgroundIndicator /*82*/:
                    if (this.zzcqP == null) {
                        this.zzcqP = new zzbto();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqP);
                    continue;
                case AdSize.LARGE_AD_HEIGHT /*90*/:
                    if (this.zzcqQ == null) {
                        this.zzcqQ = new zzbtp();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqQ);
                    continue;
                case C0394R.styleable.AppCompatTheme_buttonBarPositiveButtonStyle /*98*/:
                    if (this.zzcqR == null) {
                        this.zzcqR = new zzbua();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqR);
                    continue;
                case C0394R.styleable.AppCompatTheme_editTextStyle /*106*/:
                    if (this.zzcqS == null) {
                        this.zzcqS = new zzbuh();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqS);
                    continue;
                case C0394R.styleable.AppCompatTheme_listMenuViewStyle /*114*/:
                    if (this.zzcqT == null) {
                        this.zzcqT = new zzbuk();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqT);
                    continue;
                case 122:
                    if (this.zzcqU == null) {
                        this.zzcqU = new zzbtv();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqU);
                    continue;
                case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                    if (this.zzcqV == null) {
                        this.zzcqV = new zzbtw();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqV);
                    continue;
                case 138:
                    if (this.zzcqW == null) {
                        this.zzcqW = new zzbub();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqW);
                    continue;
                case 146:
                    if (this.zzcqX == null) {
                        this.zzcqX = new zzbuf();
                    }
                    com_google_android_gms_internal_zzbul.zza(this.zzcqX);
                    continue;
                default:
                    if (!super.zza(com_google_android_gms_internal_zzbul, zzacu)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public /* synthetic */ zzbut zzb(zzbul com_google_android_gms_internal_zzbul) throws IOException {
        return zzao(com_google_android_gms_internal_zzbul);
    }

    protected int zzv() {
        int zzv = super.zzv();
        if (this.type != 0) {
            zzv += zzbum.zzH(1, this.type);
        }
        if (this.zzcqH != null && this.zzcqH.length > 0) {
            int i = zzv;
            for (zzbut com_google_android_gms_internal_zzbut : this.zzcqH) {
                if (com_google_android_gms_internal_zzbut != null) {
                    i += zzbum.zzc(2, com_google_android_gms_internal_zzbut);
                }
            }
            zzv = i;
        }
        if (this.zzcqI != null) {
            zzv += zzbum.zzc(3, this.zzcqI);
        }
        if (this.zzcqJ != null) {
            zzv += zzbum.zzc(4, this.zzcqJ);
        }
        if (this.zzcqK != null) {
            zzv += zzbum.zzc(5, this.zzcqK);
        }
        if (this.zzcqL != null) {
            zzv += zzbum.zzc(6, this.zzcqL);
        }
        if (this.zzcqM != null) {
            zzv += zzbum.zzc(7, this.zzcqM);
        }
        if (this.zzcqN != null) {
            zzv += zzbum.zzc(8, this.zzcqN);
        }
        if (this.zzcqO != null) {
            zzv += zzbum.zzc(9, this.zzcqO);
        }
        if (this.zzcqP != null) {
            zzv += zzbum.zzc(10, this.zzcqP);
        }
        if (this.zzcqQ != null) {
            zzv += zzbum.zzc(11, this.zzcqQ);
        }
        if (this.zzcqR != null) {
            zzv += zzbum.zzc(12, this.zzcqR);
        }
        if (this.zzcqS != null) {
            zzv += zzbum.zzc(13, this.zzcqS);
        }
        if (this.zzcqT != null) {
            zzv += zzbum.zzc(14, this.zzcqT);
        }
        if (this.zzcqU != null) {
            zzv += zzbum.zzc(15, this.zzcqU);
        }
        if (this.zzcqV != null) {
            zzv += zzbum.zzc(16, this.zzcqV);
        }
        if (this.zzcqW != null) {
            zzv += zzbum.zzc(17, this.zzcqW);
        }
        return this.zzcqX != null ? zzv + zzbum.zzc(18, this.zzcqX) : zzv;
    }
}
