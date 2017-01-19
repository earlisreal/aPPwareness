package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.drive.ExecutionOptions;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzmb
public final class zzhw {
    public static final zzhx zzHd;
    public static final zzhx zzHe;
    public static final zzhx zzHf;
    public static final zzhx zzHg;
    public static final zzhx zzHh;
    public static final zzhx zzHi;
    public static final zzhx zzHj;
    public static final zzhx zzHk;
    public static final zzhx zzHl;
    public static final zzhx zzHm;
    public static final zzhx zzHn;
    public static final zzhx zzHo;
    public static final zzhx zzHp;
    public static final zzhx zzHq;
    public static final zzhx zzHr;
    public static final zzhx zzHs;
    public static final zzhx zzHt;
    public static final zzif zzHu;
    public static final zzhx zzHv;
    public static final zzhx zzHw;
    public static final zzhx zzHx;

    /* renamed from: com.google.android.gms.internal.zzhw.1 */
    class C13121 implements zzhx {
        C13121() {
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw.2 */
    class C13132 implements zzhx {
        C13132() {
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
            zzgs zzll = com_google_android_gms_internal_zzqp.zzll();
            if (zzll != null) {
                zzll.zzfR();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw.3 */
    class C13143 implements zzhx {
        C13143() {
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                zzav zzkX = com_google_android_gms_internal_zzqp.zzkX();
                if (zzkX != null) {
                    zzkX.zzW().zza(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                zzpy.zzbe("Could not parse touch parameters from gmsg.");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw.4 */
    class C13154 implements zzhx {
        C13154() {
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
            if (((Boolean) zzfx.zzCX.get()).booleanValue()) {
                com_google_android_gms_internal_zzqp.zzL(!Boolean.parseBoolean((String) map.get("disabled")));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw.5 */
    class C13165 implements zzhx {
        C13165() {
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
            String str = (String) map.get("action");
            if ("pause".equals(str)) {
                com_google_android_gms_internal_zzqp.zzbV();
            } else if ("resume".equals(str)) {
                com_google_android_gms_internal_zzqp.zzbW();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw.6 */
    class C13176 implements zzhx {
        C13176() {
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                com_google_android_gms_internal_zzqp.zzkV().zzlu();
            } else if (map.keySet().contains("stop")) {
                com_google_android_gms_internal_zzqp.zzkV().zzlv();
            } else if (map.keySet().contains("cancel")) {
                com_google_android_gms_internal_zzqp.zzkV().zzlw();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw.7 */
    class C13187 implements zzhx {
        C13187() {
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                com_google_android_gms_internal_zzqp.zzM(true);
            }
            if (map.keySet().contains("stop")) {
                com_google_android_gms_internal_zzqp.zzM(false);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw.8 */
    class C13198 implements zzhx {
        C13198() {
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
            com_google_android_gms_internal_zzqp.zza("locationReady", zzv.zzcJ().zza((View) com_google_android_gms_internal_zzqp, (WindowManager) com_google_android_gms_internal_zzqp.getContext().getSystemService("window")));
            zzpy.zzbe("GET LOCATION COMPILED");
        }
    }

    /* renamed from: com.google.android.gms.internal.zzhw.9 */
    class C13209 implements zzhx {
        C13209() {
        }

        public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                zzpy.zzbe("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = com_google_android_gms_internal_zzqp.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH) != null));
            }
            com_google_android_gms_internal_zzqp.zza("openableURLs", hashMap);
        }
    }

    static {
        zzHd = new C13121();
        zzHe = new C13209();
        zzHf = new zzhx() {
            public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
                PackageManager packageManager = com_google_android_gms_internal_zzqp.getContext().getPackageManager();
                try {
                    try {
                        JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                        JSONObject jSONObject = new JSONObject();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            try {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                                String optString = jSONObject2.optString("id");
                                Object optString2 = jSONObject2.optString("u");
                                Object optString3 = jSONObject2.optString("i");
                                Object optString4 = jSONObject2.optString("m");
                                Object optString5 = jSONObject2.optString("p");
                                Object optString6 = jSONObject2.optString("c");
                                jSONObject2.optString("f");
                                jSONObject2.optString("e");
                                Intent intent = new Intent();
                                if (!TextUtils.isEmpty(optString2)) {
                                    intent.setData(Uri.parse(optString2));
                                }
                                if (!TextUtils.isEmpty(optString3)) {
                                    intent.setAction(optString3);
                                }
                                if (!TextUtils.isEmpty(optString4)) {
                                    intent.setType(optString4);
                                }
                                if (!TextUtils.isEmpty(optString5)) {
                                    intent.setPackage(optString5);
                                }
                                if (!TextUtils.isEmpty(optString6)) {
                                    String[] split = optString6.split("/", 2);
                                    if (split.length == 2) {
                                        intent.setComponent(new ComponentName(split[0], split[1]));
                                    }
                                }
                                try {
                                    jSONObject.put(optString, packageManager.resolveActivity(intent, ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH) != null);
                                } catch (Throwable e) {
                                    zzpy.zzb("Error constructing openable urls response.", e);
                                }
                            } catch (Throwable e2) {
                                zzpy.zzb("Error parsing the intent data.", e2);
                            }
                        }
                        com_google_android_gms_internal_zzqp.zzb("openableIntents", jSONObject);
                    } catch (JSONException e3) {
                        com_google_android_gms_internal_zzqp.zzb("openableIntents", new JSONObject());
                    }
                } catch (JSONException e4) {
                    com_google_android_gms_internal_zzqp.zzb("openableIntents", new JSONObject());
                }
            }
        };
        zzHg = new zzhx() {
            public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
                String str = (String) map.get("u");
                if (str == null) {
                    zzpy.zzbe("URL missing from click GMSG.");
                    return;
                }
                Uri zza;
                Uri parse = Uri.parse(str);
                try {
                    zzav zzkX = com_google_android_gms_internal_zzqp.zzkX();
                    if (zzkX != null && zzkX.zzc(parse)) {
                        zza = zzkX.zza(parse, com_google_android_gms_internal_zzqp.getContext(), com_google_android_gms_internal_zzqp.getView());
                        new zzps(com_google_android_gms_internal_zzqp.getContext(), com_google_android_gms_internal_zzqp.zzkY().zzaZ, zza.toString()).zziw();
                    }
                } catch (zzaw e) {
                    String str2 = "Unable to append parameter to URL: ";
                    str = String.valueOf(str);
                    zzpy.zzbe(str.length() != 0 ? str2.concat(str) : new String(str2));
                }
                zza = parse;
                new zzps(com_google_android_gms_internal_zzqp.getContext(), com_google_android_gms_internal_zzqp.zzkY().zzaZ, zza.toString()).zziw();
            }
        };
        zzHh = new zzhx() {
            public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
                zze zzkT = com_google_android_gms_internal_zzqp.zzkT();
                if (zzkT != null) {
                    zzkT.close();
                    return;
                }
                zzkT = com_google_android_gms_internal_zzqp.zzkU();
                if (zzkT != null) {
                    zzkT.close();
                } else {
                    zzpy.zzbe("A GMSG tried to close something that wasn't an overlay.");
                }
            }
        };
        zzHi = new zzhx() {
            private void zzd(zzqp com_google_android_gms_internal_zzqp) {
                zzpy.zzbd("Received support message, responding.");
                zzd zzbz = com_google_android_gms_internal_zzqp.zzbz();
                if (!(zzbz == null || zzbz.zzsO == null)) {
                    com_google_android_gms_internal_zzqp.getContext();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(NotificationCompatApi24.CATEGORY_EVENT, "checkSupport");
                    jSONObject.put("supports", false);
                    com_google_android_gms_internal_zzqp.zzb("appStreaming", jSONObject);
                } catch (Throwable th) {
                }
            }

            public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
                if ("checkSupport".equals(map.get("action"))) {
                    zzd(com_google_android_gms_internal_zzqp);
                    return;
                }
                zze zzkT = com_google_android_gms_internal_zzqp.zzkT();
                if (zzkT != null) {
                    zzkT.zzg(com_google_android_gms_internal_zzqp, map);
                }
            }
        };
        zzHj = new zzhx() {
            public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
                com_google_android_gms_internal_zzqp.zzK("1".equals(map.get("custom_close")));
            }
        };
        zzHk = new zzhx() {
            public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
                String str = (String) map.get("u");
                if (str == null) {
                    zzpy.zzbe("URL missing from httpTrack GMSG.");
                } else {
                    new zzps(com_google_android_gms_internal_zzqp.getContext(), com_google_android_gms_internal_zzqp.zzkY().zzaZ, str).zziw();
                }
            }
        };
        zzHl = new zzhx() {
            public void zza(zzqp com_google_android_gms_internal_zzqp, Map<String, String> map) {
                String str = "Received log message: ";
                String valueOf = String.valueOf((String) map.get("string"));
                zzpy.zzbd(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            }
        };
        zzHm = new C13132();
        zzHn = new C13143();
        zzHo = new C13154();
        zzHp = new C13165();
        zzHq = new zzih();
        zzHr = new zzii();
        zzHs = new zzim();
        zzHt = new zzhv();
        zzHu = new zzif();
        zzHv = new C13176();
        zzHw = new C13187();
        zzHx = new C13198();
    }
}
