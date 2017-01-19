package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.C0397R;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;

@zzmb
public class zzkl extends zzko {
    private final Context mContext;
    private final Map<String, String> zzFs;

    /* renamed from: com.google.android.gms.internal.zzkl.1 */
    class C13971 implements OnClickListener {
        final /* synthetic */ String zzLG;
        final /* synthetic */ String zzLH;
        final /* synthetic */ zzkl zzLI;

        C13971(zzkl com_google_android_gms_internal_zzkl, String str, String str2) {
            this.zzLI = com_google_android_gms_internal_zzkl;
            this.zzLG = str;
            this.zzLH = str2;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                ((DownloadManager) this.zzLI.mContext.getSystemService("download")).enqueue(this.zzLI.zzj(this.zzLG, this.zzLH));
            } catch (IllegalStateException e) {
                this.zzLI.zzay("Could not store picture.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzkl.2 */
    class C13982 implements OnClickListener {
        final /* synthetic */ zzkl zzLI;

        C13982(zzkl com_google_android_gms_internal_zzkl) {
            this.zzLI = com_google_android_gms_internal_zzkl;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.zzLI.zzay("User canceled the download.");
        }
    }

    public zzkl(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
        super(com_google_android_gms_internal_zzqp, "storePicture");
        this.zzFs = map;
        this.mContext = com_google_android_gms_internal_zzqp.zzkR();
    }

    public void execute() {
        if (this.mContext == null) {
            zzay("Activity context is not available");
        } else if (zzv.zzcJ().zzC(this.mContext).zzfi()) {
            String str = (String) this.zzFs.get("iurl");
            if (TextUtils.isEmpty(str)) {
                zzay("Image url cannot be empty.");
            } else if (URLUtil.isValidUrl(str)) {
                String zzax = zzax(str);
                if (zzv.zzcJ().zzaX(zzax)) {
                    Resources resources = zzv.zzcN().getResources();
                    Builder zzB = zzv.zzcJ().zzB(this.mContext);
                    zzB.setTitle(resources != null ? resources.getString(C0397R.string.store_picture_title) : "Save image");
                    zzB.setMessage(resources != null ? resources.getString(C0397R.string.store_picture_message) : "Allow Ad to store image in Picture gallery?");
                    zzB.setPositiveButton(resources != null ? resources.getString(C0397R.string.accept) : "Accept", new C13971(this, str, zzax));
                    zzB.setNegativeButton(resources != null ? resources.getString(C0397R.string.decline) : "Decline", new C13982(this));
                    zzB.create().show();
                    return;
                }
                r1 = "Image type not recognized: ";
                str = String.valueOf(zzax);
                zzay(str.length() != 0 ? r1.concat(str) : new String(r1));
            } else {
                r1 = "Invalid image url: ";
                str = String.valueOf(str);
                zzay(str.length() != 0 ? r1.concat(str) : new String(r1));
            }
        } else {
            zzay("Feature is not supported by the device.");
        }
    }

    String zzax(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    Request zzj(String str, String str2) {
        Request request = new Request(Uri.parse(str));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
        zzv.zzcL().zza(request);
        return request;
    }
}
