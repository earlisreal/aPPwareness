package com.example.eteam.appwearness;

import android.content.SharedPreferences.Editor;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import com.example.eteam.appwearness.Global.Config;
import com.example.eteam.appwearness.Interface.RequestInterface;
import com.example.eteam.appwearness.Object.Device;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Firebase extends FirebaseInstanceIdService {
    private final String TAG;

    /* renamed from: com.example.eteam.appwearness.Firebase.1 */
    class C03491 implements Callback<Integer> {
        C03491() {
        }

        public void onResponse(Call<Integer> call, Response<Integer> response) {
            int deviceId = ((Integer) response.body()).intValue();
            Log.i(Config.TAG, "onResponse: " + deviceId);
            if (response.code() == ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION) {
                Log.d(Config.TAG, "onResponse: " + response.body());
                Editor editor = Firebase.this.getApplicationContext().getSharedPreferences(Firebase.this.getString(C0361R.string.preference_file_key), 0).edit();
                editor.putInt(Firebase.this.getString(C0361R.string.device_id_key), deviceId);
                editor.apply();
            }
        }

        public void onFailure(Call<Integer> call, Throwable t) {
            Log.e(Config.TAG, "onFailure: " + t.getMessage(), t);
        }
    }

    public Firebase() {
        this.TAG = Config.TAG;
    }

    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(Config.TAG, "Refreshed token: " + refreshedToken);
        FirebaseMessaging.getInstance().subscribeToTopic("news");
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String refreshedToken) {
        ((RequestInterface) Config.getClient(Config.SERVER).create(RequestInterface.class)).store(new Device(refreshedToken)).enqueue(new C03491());
    }
}
