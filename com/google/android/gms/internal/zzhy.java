package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.github.paolorotolo.appintro.BuildConfig;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.plus.PlusShare;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public class zzhy implements zzhx {
    private final Context mContext;
    private final zzqa zztr;

    /* renamed from: com.google.android.gms.internal.zzhy.1 */
    class C13221 implements Runnable {
        final /* synthetic */ Map zzGB;
        final /* synthetic */ zzqp zzHy;
        final /* synthetic */ zzhy zzHz;

        /* renamed from: com.google.android.gms.internal.zzhy.1.1 */
        class C13211 implements Runnable {
            final /* synthetic */ JSONObject zzHA;
            final /* synthetic */ C13221 zzHB;

            C13211(C13221 c13221, JSONObject jSONObject) {
                this.zzHB = c13221;
                this.zzHA = jSONObject;
            }

            public void run() {
                this.zzHB.zzHy.zzb("fetchHttpRequestCompleted", this.zzHA);
                zzpy.zzbc("Dispatched http response.");
            }
        }

        C13221(zzhy com_google_android_gms_internal_zzhy, Map map, zzqp com_google_android_gms_internal_zzqp) {
            this.zzHz = com_google_android_gms_internal_zzhy;
            this.zzGB = map;
            this.zzHy = com_google_android_gms_internal_zzqp;
        }

        public void run() {
            zzpy.zzbc("Received Http request.");
            JSONObject zzaa = this.zzHz.zzaa((String) this.zzGB.get("http_request"));
            if (zzaa == null) {
                zzpy.m28e("Response should not be null.");
            } else {
                zzpi.zzWR.post(new C13211(this, zzaa));
            }
        }
    }

    @zzmb
    static class zza {
        private final String mValue;
        private final String zzAH;

        public zza(String str, String str2) {
            this.zzAH = str;
            this.mValue = str2;
        }

        public String getKey() {
            return this.zzAH;
        }

        public String getValue() {
            return this.mValue;
        }
    }

    @zzmb
    static class zzb {
        private final String zzHC;
        private final URL zzHD;
        private final ArrayList<zza> zzHE;
        private final String zzHF;

        public zzb(String str, URL url, ArrayList<zza> arrayList, String str2) {
            this.zzHC = str;
            this.zzHD = url;
            if (arrayList == null) {
                this.zzHE = new ArrayList();
            } else {
                this.zzHE = arrayList;
            }
            this.zzHF = str2;
        }

        public String zzfZ() {
            return this.zzHC;
        }

        public URL zzga() {
            return this.zzHD;
        }

        public ArrayList<zza> zzgb() {
            return this.zzHE;
        }

        public String zzgc() {
            return this.zzHF;
        }
    }

    @zzmb
    class zzc {
        private final zzd zzHG;
        private final boolean zzHH;
        private final String zzHI;

        public zzc(zzhy com_google_android_gms_internal_zzhy, boolean z, zzd com_google_android_gms_internal_zzhy_zzd, String str) {
            this.zzHH = z;
            this.zzHG = com_google_android_gms_internal_zzhy_zzd;
            this.zzHI = str;
        }

        public String getReason() {
            return this.zzHI;
        }

        public boolean isSuccess() {
            return this.zzHH;
        }

        public zzd zzgd() {
            return this.zzHG;
        }
    }

    @zzmb
    static class zzd {
        private final String zzFU;
        private final String zzHC;
        private final int zzHJ;
        private final List<zza> zzHK;

        public zzd(String str, int i, List<zza> list, String str2) {
            this.zzHC = str;
            this.zzHJ = i;
            if (list == null) {
                this.zzHK = new ArrayList();
            } else {
                this.zzHK = list;
            }
            this.zzFU = str2;
        }

        public String getBody() {
            return this.zzFU;
        }

        public int getResponseCode() {
            return this.zzHJ;
        }

        public String zzfZ() {
            return this.zzHC;
        }

        public Iterable<zza> zzge() {
            return this.zzHK;
        }
    }

    public zzhy(Context context, zzqa com_google_android_gms_internal_zzqa) {
        this.mContext = context;
        this.zztr = com_google_android_gms_internal_zzqa;
    }

    protected zzc zza(zzb com_google_android_gms_internal_zzhy_zzb) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) com_google_android_gms_internal_zzhy_zzb.zzga().openConnection();
            zzv.zzcJ().zza(this.mContext, this.zztr.zzaZ, false, httpURLConnection);
            Iterator it = com_google_android_gms_internal_zzhy_zzb.zzgb().iterator();
            while (it.hasNext()) {
                zza com_google_android_gms_internal_zzhy_zza = (zza) it.next();
                httpURLConnection.addRequestProperty(com_google_android_gms_internal_zzhy_zza.getKey(), com_google_android_gms_internal_zzhy_zza.getValue());
            }
            if (!TextUtils.isEmpty(com_google_android_gms_internal_zzhy_zzb.zzgc())) {
                httpURLConnection.setDoOutput(true);
                byte[] bytes = com_google_android_gms_internal_zzhy_zzb.zzgc().getBytes();
                httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.close();
            }
            List arrayList = new ArrayList();
            if (httpURLConnection.getHeaderFields() != null) {
                for (Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
                    for (String com_google_android_gms_internal_zzhy_zza2 : (List) entry.getValue()) {
                        arrayList.add(new zza((String) entry.getKey(), com_google_android_gms_internal_zzhy_zza2));
                    }
                }
            }
            return new zzc(this, true, new zzd(com_google_android_gms_internal_zzhy_zzb.zzfZ(), httpURLConnection.getResponseCode(), arrayList, zzv.zzcJ().zza(new InputStreamReader(httpURLConnection.getInputStream()))), null);
        } catch (Exception e) {
            return new zzc(this, false, null, e.toString());
        }
    }

    protected JSONObject zza(zzd com_google_android_gms_internal_zzhy_zzd) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", com_google_android_gms_internal_zzhy_zzd.zzfZ());
            if (com_google_android_gms_internal_zzhy_zzd.getBody() != null) {
                jSONObject.put("body", com_google_android_gms_internal_zzhy_zzd.getBody());
            }
            JSONArray jSONArray = new JSONArray();
            for (zza com_google_android_gms_internal_zzhy_zza : com_google_android_gms_internal_zzhy_zzd.zzge()) {
                jSONArray.put(new JSONObject().put("key", com_google_android_gms_internal_zzhy_zza.getKey()).put("value", com_google_android_gms_internal_zzhy_zza.getValue()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", com_google_android_gms_internal_zzhy_zzd.getResponseCode());
        } catch (Throwable e) {
            zzpy.zzb("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
        zzph.zza(new C13221(this, map, com_google_android_gms_internal_zzqp));
    }

    public JSONObject zzaa(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            Object obj = BuildConfig.FLAVOR;
            try {
                obj = jSONObject.optString("http_request_id");
                zzc zza = zza(zzb(jSONObject));
                if (zza.isSuccess()) {
                    jSONObject2.put("response", zza(zza.zzgd()));
                    jSONObject2.put("success", true);
                    return jSONObject2;
                }
                jSONObject2.put("response", new JSONObject().put("http_request_id", obj));
                jSONObject2.put("success", false);
                jSONObject2.put("reason", zza.getReason());
                return jSONObject2;
            } catch (Exception e) {
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", obj));
                    jSONObject2.put("success", false);
                    jSONObject2.put("reason", e.toString());
                    return jSONObject2;
                } catch (JSONException e2) {
                    return jSONObject2;
                }
            }
        } catch (JSONException e3) {
            zzpy.m28e("The request is not a valid JSON.");
            try {
                return new JSONObject().put("success", false);
            } catch (JSONException e4) {
                return new JSONObject();
            }
        }
    }

    protected zzb zzb(JSONObject jSONObject) {
        URL url;
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
        String optString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(optString2);
        } catch (Throwable e) {
            zzpy.zzb("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new zza(optJSONObject.optString("key"), optJSONObject.optString("value")));
            }
        }
        return new zzb(optString, url, arrayList, optString3);
    }
}
