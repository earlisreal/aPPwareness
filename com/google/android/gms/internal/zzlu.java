package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzlu implements Callable<zzov> {
    static long zzPS;
    private final Context mContext;
    private final zzlt zzGp;
    private final zzav zzGr;
    private int zzPF;
    private final com.google.android.gms.internal.zzov.zza zzPo;
    private final zzpp zzQb;
    private final zzr zzQc;
    private boolean zzQd;
    private List<String> zzQe;
    private JSONObject zzQf;
    private final Object zzrN;
    private final zzgf zzsr;

    /* renamed from: com.google.android.gms.internal.zzlu.1 */
    class C14121 extends com.google.android.gms.internal.zzlt.zza {
        final /* synthetic */ String zzQg;
        final /* synthetic */ zzb zzQh;
        final /* synthetic */ zzqc zzQi;
        final /* synthetic */ zzlu zzQj;

        /* renamed from: com.google.android.gms.internal.zzlu.1.1 */
        class C14111 implements zzhx {
            final /* synthetic */ zzjb zzGz;
            final /* synthetic */ C14121 zzQk;

            C14111(C14121 c14121, zzjb com_google_android_gms_internal_zzjb) {
                this.zzQk = c14121;
                this.zzGz = com_google_android_gms_internal_zzjb;
            }

            public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
                try {
                    String str = (String) map.get("success");
                    if (!TextUtils.isEmpty(str)) {
                        if (this.zzQk.zzQg.equals(new JSONObject(str).optString("ads_id", BuildConfig.FLAVOR))) {
                            this.zzGz.zzb("/nativeAdPreProcess", this.zzQk.zzQh.zzQz);
                            this.zzQk.zzQi.zzh(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                        }
                    }
                } catch (Throwable e) {
                    zzpy.zzb("Malformed native JSON response.", e);
                    this.zzQk.zzQj.zzS(0);
                    zzac.zza(this.zzQk.zzQj.zziQ(), (Object) "Unable to set the ad state error!");
                    this.zzQk.zzQi.zzh(null);
                }
            }
        }

        C14121(zzlu com_google_android_gms_internal_zzlu, String str, zzb com_google_android_gms_internal_zzlu_zzb, zzqc com_google_android_gms_internal_zzqc) {
            this.zzQj = com_google_android_gms_internal_zzlu;
            this.zzQg = str;
            this.zzQh = com_google_android_gms_internal_zzlu_zzb;
            this.zzQi = com_google_android_gms_internal_zzqc;
        }

        public void zze(zzjb com_google_android_gms_internal_zzjb) {
            zzhx c14111 = new C14111(this, com_google_android_gms_internal_zzjb);
            this.zzQh.zzQz = c14111;
            com_google_android_gms_internal_zzjb.zza("/nativeAdPreProcess", c14111);
            try {
                JSONObject jSONObject = new JSONObject(this.zzQj.zzPo.zzVB.body);
                jSONObject.put("ads_id", this.zzQg);
                com_google_android_gms_internal_zzjb.zza("google.afma.nativeAds.preProcessJsonGmsg", jSONObject);
            } catch (Throwable e) {
                zzpy.zzc("Exception occurred while invoking javascript", e);
                this.zzQi.zzh(null);
            }
        }

        public void zziO() {
            this.zzQi.zzh(null);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlu.2 */
    class C14132 implements Runnable {
        final /* synthetic */ zzlu zzQj;
        final /* synthetic */ zzqc zzQl;
        final /* synthetic */ String zzQm;

        C14132(zzlu com_google_android_gms_internal_zzlu, zzqc com_google_android_gms_internal_zzqc, String str) {
            this.zzQj = com_google_android_gms_internal_zzlu;
            this.zzQl = com_google_android_gms_internal_zzqc;
            this.zzQm = str;
        }

        public void run() {
            this.zzQl.zzh((zzhm) this.zzQj.zzQc.zzcs().get(this.zzQm));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlu.3 */
    class C14143 implements zzhx {
        final /* synthetic */ zzlu zzQj;
        final /* synthetic */ zzgr zzQn;

        C14143(zzlu com_google_android_gms_internal_zzlu, zzgr com_google_android_gms_internal_zzgr) {
            this.zzQj = com_google_android_gms_internal_zzlu;
            this.zzQn = com_google_android_gms_internal_zzgr;
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
            this.zzQj.zzb(this.zzQn, (String) map.get("asset"));
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlu.4 */
    class C14154 extends com.google.android.gms.internal.zzlt.zza {
        final /* synthetic */ zzhx zzQo;

        C14154(zzlu com_google_android_gms_internal_zzlu, zzhx com_google_android_gms_internal_zzhx) {
            this.zzQo = com_google_android_gms_internal_zzhx;
        }

        public void zze(zzjb com_google_android_gms_internal_zzjb) {
            com_google_android_gms_internal_zzjb.zza("/nativeAdCustomClick", this.zzQo);
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlu.5 */
    class C14165 implements com.google.android.gms.internal.zzqe.zza<List<zzgo>, zzgm> {
        final /* synthetic */ String zzQp;
        final /* synthetic */ Integer zzQq;
        final /* synthetic */ Integer zzQr;
        final /* synthetic */ int zzQs;
        final /* synthetic */ int zzQt;
        final /* synthetic */ int zzQu;
        final /* synthetic */ int zzQv;

        C14165(zzlu com_google_android_gms_internal_zzlu, String str, Integer num, Integer num2, int i, int i2, int i3, int i4) {
            this.zzQp = str;
            this.zzQq = num;
            this.zzQr = num2;
            this.zzQs = i;
            this.zzQt = i2;
            this.zzQu = i3;
            this.zzQv = i4;
        }

        public /* synthetic */ Object apply(Object obj) {
            return zzj((List) obj);
        }

        public zzgm zzj(List<zzgo> list) {
            zzgm com_google_android_gms_internal_zzgm;
            if (list != null) {
                try {
                    if (!list.isEmpty()) {
                        com_google_android_gms_internal_zzgm = new zzgm(this.zzQp, zzlu.zzh(list), this.zzQq, this.zzQr, this.zzQs > 0 ? Integer.valueOf(this.zzQs) : null, this.zzQt + this.zzQu, this.zzQv);
                        return com_google_android_gms_internal_zzgm;
                    }
                } catch (Throwable e) {
                    zzpy.zzb("Could not get attribution icon", e);
                    return null;
                }
            }
            com_google_android_gms_internal_zzgm = null;
            return com_google_android_gms_internal_zzgm;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzlu.6 */
    class C14176 implements com.google.android.gms.internal.zzpp.zza<zzgo> {
        final /* synthetic */ String zzLG;
        final /* synthetic */ zzlu zzQj;
        final /* synthetic */ boolean zzQw;
        final /* synthetic */ double zzQx;
        final /* synthetic */ boolean zzQy;

        C14176(zzlu com_google_android_gms_internal_zzlu, boolean z, double d, boolean z2, String str) {
            this.zzQj = com_google_android_gms_internal_zzlu;
            this.zzQw = z;
            this.zzQx = d;
            this.zzQy = z2;
            this.zzLG = str;
        }

        @TargetApi(19)
        public zzgo zzg(InputStream inputStream) {
            Bitmap decodeStream;
            Options options = new Options();
            options.inDensity = (int) (160.0d * this.zzQx);
            if (!this.zzQy) {
                options.inPreferredConfig = Config.RGB_565;
            }
            try {
                decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            } catch (Throwable e) {
                zzpy.zzb("Error grabbing image.", e);
                decodeStream = null;
            }
            if (decodeStream == null) {
                this.zzQj.zza(2, this.zzQw);
                return null;
            }
            if (zzs.zzyF()) {
                int width = decodeStream.getWidth();
                int height = decodeStream.getHeight();
                zzpe.m29v("Decoded image w: " + width + " h:" + height + " bytes: " + decodeStream.getAllocationByteCount());
            }
            return new zzgo(new BitmapDrawable(Resources.getSystem(), decodeStream), Uri.parse(this.zzLG), this.zzQx);
        }

        @TargetApi(19)
        public /* synthetic */ Object zzh(InputStream inputStream) {
            return zzg(inputStream);
        }

        public zzgo zziS() {
            this.zzQj.zza(2, this.zzQw);
            return null;
        }

        public /* synthetic */ Object zziT() {
            return zziS();
        }
    }

    public interface zza<T extends com.google.android.gms.internal.zzgu.zza> {
        T zza(zzlu com_google_android_gms_internal_zzlu, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException;
    }

    class zzb {
        public zzhx zzQz;

        zzb(zzlu com_google_android_gms_internal_zzlu) {
        }
    }

    static {
        zzPS = TimeUnit.SECONDS.toMillis(60);
    }

    public zzlu(Context context, zzr com_google_android_gms_ads_internal_zzr, zzpp com_google_android_gms_internal_zzpp, zzav com_google_android_gms_internal_zzav, com.google.android.gms.internal.zzov.zza com_google_android_gms_internal_zzov_zza, zzgf com_google_android_gms_internal_zzgf) {
        this.zzrN = new Object();
        this.mContext = context;
        this.zzQc = com_google_android_gms_ads_internal_zzr;
        this.zzQb = com_google_android_gms_internal_zzpp;
        this.zzPo = com_google_android_gms_internal_zzov_zza;
        this.zzGr = com_google_android_gms_internal_zzav;
        this.zzsr = com_google_android_gms_internal_zzgf;
        this.zzGp = zza(context, com_google_android_gms_internal_zzov_zza, com_google_android_gms_ads_internal_zzr, com_google_android_gms_internal_zzav);
        this.zzGp.zziE();
        this.zzQd = false;
        this.zzPF = -2;
        this.zzQe = null;
    }

    private com.google.android.gms.internal.zzgu.zza zza(zza com_google_android_gms_internal_zzlu_zza, JSONObject jSONObject, String str) throws ExecutionException, InterruptedException, JSONException {
        if (zziQ() || com_google_android_gms_internal_zzlu_zza == null || jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("tracking_urls_and_actions");
        String[] zzd = zzd(jSONObject2, "impression_tracking_urls");
        this.zzQe = zzd == null ? null : Arrays.asList(zzd);
        this.zzQf = jSONObject2.optJSONObject("active_view");
        com.google.android.gms.internal.zzgu.zza zza = com_google_android_gms_internal_zzlu_zza.zza(this, jSONObject);
        if (zza == null) {
            zzpy.m28e("Failed to retrieve ad assets.");
            return null;
        }
        zza.zzb(new zzgv(this.mContext, this.zzQc, this.zzGp, this.zzGr, jSONObject, zza, this.zzPo.zzSF.zzvf, str));
        return zza;
    }

    private zzqf<zzgo> zza(JSONObject jSONObject, boolean z, boolean z2) throws JSONException {
        String string = z ? jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL) : jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        if (!TextUtils.isEmpty(string)) {
            return z2 ? new zzqd(new zzgo(null, Uri.parse(string), optDouble)) : this.zzQb.zza(string, new C14176(this, z, optDouble, optBoolean, string));
        } else {
            zza(0, z);
            return new zzqd(null);
        }
    }

    private void zza(com.google.android.gms.internal.zzgu.zza com_google_android_gms_internal_zzgu_zza) {
        if (com_google_android_gms_internal_zzgu_zza instanceof zzgr) {
            zzgr com_google_android_gms_internal_zzgr = (zzgr) com_google_android_gms_internal_zzgu_zza;
            zzb com_google_android_gms_internal_zzlu_zzb = new zzb(this);
            zzhx c14143 = new C14143(this, com_google_android_gms_internal_zzgr);
            com_google_android_gms_internal_zzlu_zzb.zzQz = c14143;
            this.zzGp.zza(new C14154(this, c14143));
        }
    }

    private JSONObject zzaG(String str) throws ExecutionException, InterruptedException, TimeoutException, JSONException {
        if (zziQ()) {
            return null;
        }
        zzqc com_google_android_gms_internal_zzqc = new zzqc();
        this.zzGp.zza(new C14121(this, str, new zzb(this), com_google_android_gms_internal_zzqc));
        return (JSONObject) com_google_android_gms_internal_zzqc.get(zzPS, TimeUnit.MILLISECONDS);
    }

    private zzov zzb(com.google.android.gms.internal.zzgu.zza com_google_android_gms_internal_zzgu_zza) {
        int i;
        synchronized (this.zzrN) {
            i = this.zzPF;
            if (com_google_android_gms_internal_zzgu_zza == null && this.zzPF == -2) {
                i = 0;
            }
        }
        return new zzov(this.zzPo.zzSF.zzRd, null, this.zzPo.zzVB.zzJY, i, this.zzPo.zzVB.zzJZ, this.zzQe, this.zzPo.zzVB.orientation, this.zzPo.zzVB.zzKe, this.zzPo.zzSF.zzRg, false, null, null, null, null, null, 0, this.zzPo.zzvj, this.zzPo.zzVB.zzRJ, this.zzPo.zzVv, this.zzPo.zzVw, this.zzPo.zzVB.zzRP, this.zzQf, i != -2 ? null : com_google_android_gms_internal_zzgu_zza, null, null, null, this.zzPo.zzVB.zzSc, this.zzPo.zzVB.zzSd, null, this.zzPo.zzVB.zzKb, this.zzPo.zzVB.zzSg);
    }

    private Integer zzb(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    private void zzb(zzhh com_google_android_gms_internal_zzhh, String str) {
        try {
            zzhl zzz = this.zzQc.zzz(com_google_android_gms_internal_zzhh.getCustomTemplateId());
            if (zzz != null) {
                zzz.zza(com_google_android_gms_internal_zzhh, str);
            }
        } catch (Throwable e) {
            zzpy.zzc(new StringBuilder(String.valueOf(str).length() + 40).append("Failed to call onCustomClick for asset ").append(str).append(".").toString(), e);
        }
    }

    private String[] zzd(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    private static List<Drawable> zzh(List<zzgo> list) throws RemoteException {
        List<Drawable> arrayList = new ArrayList();
        for (zzgo zzfK : list) {
            arrayList.add((Drawable) zze.zzE(zzfK.zzfK()));
        }
        return arrayList;
    }

    public /* synthetic */ Object call() throws Exception {
        return zziP();
    }

    public void zzS(int i) {
        synchronized (this.zzrN) {
            this.zzQd = true;
            this.zzPF = i;
        }
    }

    zzlt zza(Context context, com.google.android.gms.internal.zzov.zza com_google_android_gms_internal_zzov_zza, zzr com_google_android_gms_ads_internal_zzr, zzav com_google_android_gms_internal_zzav) {
        return new zzlt(context, com_google_android_gms_internal_zzov_zza, com_google_android_gms_ads_internal_zzr, com_google_android_gms_internal_zzav);
    }

    zzlv zza(Context context, zzav com_google_android_gms_internal_zzav, com.google.android.gms.internal.zzov.zza com_google_android_gms_internal_zzov_zza, zzgf com_google_android_gms_internal_zzgf, zzr com_google_android_gms_ads_internal_zzr) {
        return new zzlv(context, com_google_android_gms_internal_zzav, com_google_android_gms_internal_zzov_zza, com_google_android_gms_internal_zzgf, com_google_android_gms_ads_internal_zzr);
    }

    public zzqf<zzgo> zza(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, z, z2);
    }

    public List<zzqf<zzgo>> zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) throws JSONException {
        JSONArray jSONArray = z ? jSONObject.getJSONArray(str) : jSONObject.optJSONArray(str);
        List<zzqf<zzgo>> arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            zza(0, z);
            return arrayList;
        }
        int length = z3 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(zza(jSONObject2, z, z2));
        }
        return arrayList;
    }

    public Future<zzgo> zza(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, optBoolean, z);
    }

    public void zza(int i, boolean z) {
        if (z) {
            zzS(i);
        }
    }

    public zzqf<zzqp> zzc(JSONObject jSONObject, String str) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return new zzqd(null);
        }
        if (!TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
            return zza(this.mContext, this.zzGr, this.zzPo, this.zzsr, this.zzQc).zzf(optJSONObject);
        }
        zzpy.zzbe("Required field 'vast_xml' is missing");
        return new zzqd(null);
    }

    protected zza zzd(JSONObject jSONObject) throws ExecutionException, InterruptedException, JSONException, TimeoutException {
        if (zziQ() || jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        boolean z = this.zzPo.zzSF.zzvx != null ? this.zzPo.zzSF.zzvx.zzGD : false;
        boolean z2 = this.zzPo.zzSF.zzvx != null ? this.zzPo.zzSF.zzvx.zzGF : false;
        if ("2".equals(string)) {
            return new zzlw(z, z2);
        }
        if ("1".equals(string)) {
            return new zzlx(z, z2);
        }
        if ("3".equals(string)) {
            String string2 = jSONObject.getString("custom_template_id");
            zzqc com_google_android_gms_internal_zzqc = new zzqc();
            zzpi.zzWR.post(new C14132(this, com_google_android_gms_internal_zzqc, string2));
            if (com_google_android_gms_internal_zzqc.get(zzPS, TimeUnit.MILLISECONDS) != null) {
                return new zzly(z);
            }
            string2 = "No handler for custom template: ";
            String valueOf = String.valueOf(jSONObject.getString("custom_template_id"));
            zzpy.m28e(valueOf.length() != 0 ? string2.concat(valueOf) : new String(string2));
        } else {
            zzS(0);
        }
        return null;
    }

    public zzqf<zzgm> zze(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return new zzqd(null);
        }
        String optString = optJSONObject.optString("text");
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer zzb = zzb(optJSONObject, "text_color");
        Integer zzb2 = zzb(optJSONObject, "bg_color");
        int optInt2 = optJSONObject.optInt("animation_ms", CardNetwork.OTHER);
        int optInt3 = optJSONObject.optInt("presentation_ms", GamesStatusCodes.STATUS_SNAPSHOT_NOT_FOUND);
        int i = (this.zzPo.zzSF.zzvx == null || this.zzPo.zzSF.zzvx.versionCode < 2) ? 1 : this.zzPo.zzSF.zzvx.zzGG;
        List arrayList = new ArrayList();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = zza(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(zza(optJSONObject, "image", false, false));
        }
        return zzqe.zza(zzqe.zzo(arrayList), new C14165(this, optString, zzb2, zzb, optInt, optInt3, optInt2, i));
    }

    public zzov zziP() {
        try {
            this.zzGp.zziF();
            String zziR = zziR();
            JSONObject zzaG = zzaG(zziR);
            com.google.android.gms.internal.zzgu.zza zza = zza(zzd(zzaG), zzaG, zziR);
            zza(zza);
            return zzb(zza);
        } catch (CancellationException e) {
            if (!this.zzQd) {
                zzS(0);
            }
            return zzb(null);
        } catch (ExecutionException e2) {
            if (this.zzQd) {
                zzS(0);
            }
            return zzb(null);
        } catch (InterruptedException e3) {
            if (this.zzQd) {
                zzS(0);
            }
            return zzb(null);
        } catch (Throwable e4) {
            zzpy.zzc("Malformed native JSON response.", e4);
            if (this.zzQd) {
                zzS(0);
            }
            return zzb(null);
        } catch (Throwable e42) {
            zzpy.zzc("Timeout when loading native ad.", e42);
            if (this.zzQd) {
                zzS(0);
            }
            return zzb(null);
        }
    }

    public boolean zziQ() {
        boolean z;
        synchronized (this.zzrN) {
            z = this.zzQd;
        }
        return z;
    }

    String zziR() {
        return UUID.randomUUID().toString();
    }
}
