package com.example.eteam.appwearness;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;

public class ToolKit extends AppCompatActivity implements Runnable {
    private static final String TAG = "EARL IS REAL";
    private Camera camera;
    private boolean hasFlash;
    private boolean isFlashOn;
    private boolean isStrobeOn;
    private MediaPlayer mMediaPlayer;
    private Parameters params;

    /* renamed from: com.example.eteam.appwearness.ToolKit.1 */
    class C03621 implements OnCheckedChangeListener {
        C03621() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                ToolKit.this.turnOnFlash();
            } else {
                ToolKit.this.turnOffFlash();
            }
        }
    }

    /* renamed from: com.example.eteam.appwearness.ToolKit.2 */
    class C03642 implements OnCheckedChangeListener {

        /* renamed from: com.example.eteam.appwearness.ToolKit.2.1 */
        class C03631 implements Runnable {
            C03631() {
            }

            public void run() {
                while (ToolKit.this.isStrobeOn) {
                    ToolKit.this.turnOnFlash();
                    ToolKit.this.turnOffFlash();
                }
            }
        }

        C03642() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                ToolKit.this.isStrobeOn = true;
                AsyncTask.execute(new C03631());
                return;
            }
            ToolKit.this.isStrobeOn = false;
            ToolKit.this.turnOffFlash();
        }
    }

    /* renamed from: com.example.eteam.appwearness.ToolKit.3 */
    class C03653 implements OnCheckedChangeListener {
        C03653() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                ToolKit.this.play(ToolKit.this.getApplicationContext(), C0361R.raw.hous_fire);
            } else {
                ToolKit.this.stop();
            }
        }
    }

    /* renamed from: com.example.eteam.appwearness.ToolKit.4 */
    class C03664 implements OnCompletionListener {
        C03664() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            ToolKit.this.stop();
        }
    }

    public ToolKit() {
        this.isStrobeOn = false;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0361R.layout.activity_tool_kit);
        Switch btnSwitch = (Switch) findViewById(C0361R.id.switch1);
        Switch strobeSwitch = (Switch) findViewById(C0361R.id.switch2);
        Switch alarmSwitch = (Switch) findViewById(C0361R.id.switch3);
        this.hasFlash = getApplicationContext().getPackageManager().hasSystemFeature("android.hardware.camera.flash");
        if (this.hasFlash) {
            getCamera();
            btnSwitch.setOnCheckedChangeListener(new C03621());
            strobeSwitch.setOnCheckedChangeListener(new C03642());
            alarmSwitch.setOnCheckedChangeListener(new C03653());
            return;
        }
        Toast.makeText(this, "Flash not supported!", 0).show();
    }

    public void stop() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }

    public void play(Context c, int rid) {
        stop();
        this.mMediaPlayer = MediaPlayer.create(c, rid);
        this.mMediaPlayer.setOnCompletionListener(new C03664());
        this.mMediaPlayer.start();
    }

    private void turnOffFlash() {
        if (this.isFlashOn && this.camera != null && this.params != null) {
            this.params = this.camera.getParameters();
            this.params.setFlashMode("off");
            this.camera.setParameters(this.params);
            this.camera.stopPreview();
            this.isFlashOn = false;
        }
    }

    private void getCamera() {
        if (this.camera == null) {
            try {
                this.camera = Camera.open();
                this.params = this.camera.getParameters();
            } catch (RuntimeException e) {
                Log.e("Camera Error", ". Failed to Open. Error: " + e.getMessage());
            }
        }
    }

    private void turnOnFlash() {
        if (!this.isFlashOn && this.camera != null && this.params != null) {
            this.params = this.camera.getParameters();
            this.params.setFlashMode("torch");
            this.camera.setParameters(this.params);
            this.camera.startPreview();
            this.isFlashOn = true;
        }
    }

    public void run() {
        Log.d(TAG, "run: strobe light on");
        while (this.isStrobeOn) {
            turnOnFlash();
            turnOffFlash();
            turnOnFlash();
        }
    }
}
