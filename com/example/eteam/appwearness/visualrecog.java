package com.example.eteam.appwearness;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import com.github.paolorotolo.appintro.BuildConfig;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyImagesOptions;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.VisualClassification;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class visualrecog extends AppCompatActivity {
    private static final int CAMERA_PHOTO = 111;
    public Button alcohol;
    public CheckBox alcoholcheck;
    public Button bottled;
    public CheckBox bottledcheck;
    public Button canned;
    public CheckBox cannedcheck;
    public CheckBox contain;
    public Button flash;
    public CheckBox flashcheck;
    private Uri imageToUploadUri;
    public VisualRecognition service;
    public String totest;

    /* renamed from: com.example.eteam.appwearness.visualrecog.1 */
    class C03691 implements OnClickListener {
        C03691() {
        }

        public void onClick(View v) {
            visualrecog.this.totest = "flashlight";
            visualrecog.this.contain = visualrecog.this.flashcheck;
            visualrecog.this.captureCameraImage();
        }
    }

    /* renamed from: com.example.eteam.appwearness.visualrecog.2 */
    class C03702 implements OnClickListener {
        C03702() {
        }

        public void onClick(View v) {
            visualrecog.this.totest = "cannedgoods";
            visualrecog.this.contain = visualrecog.this.cannedcheck;
            visualrecog.this.captureCameraImage();
        }
    }

    /* renamed from: com.example.eteam.appwearness.visualrecog.3 */
    class C03713 implements OnClickListener {
        C03713() {
        }

        public void onClick(View v) {
            visualrecog.this.totest = "bottledwater";
            visualrecog.this.contain = visualrecog.this.bottledcheck;
            visualrecog.this.captureCameraImage();
        }
    }

    /* renamed from: com.example.eteam.appwearness.visualrecog.4 */
    class C03724 implements OnClickListener {
        C03724() {
        }

        public void onClick(View v) {
            visualrecog.this.totest = "alcohol";
            visualrecog.this.contain = visualrecog.this.alcoholcheck;
            visualrecog.this.captureCameraImage();
        }
    }

    public visualrecog() {
        this.service = new VisualRecognition(VisualRecognition.VERSION_DATE_2016_05_20);
        this.totest = BuildConfig.FLAVOR;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0361R.layout.activity_visualrecog);
        StrictMode.setThreadPolicy(new Builder().permitAll().build());
        this.service.setApiKey("25c92d84b5ab62b3d448db2a49ff6f08f632a393");
        this.flashcheck = (CheckBox) findViewById(C0361R.id.flashcheck);
        this.cannedcheck = (CheckBox) findViewById(C0361R.id.cannedgoodscheck);
        this.bottledcheck = (CheckBox) findViewById(C0361R.id.bottledwatercheck);
        this.alcoholcheck = (CheckBox) findViewById(C0361R.id.alcoholcheck);
        this.flash = (Button) findViewById(C0361R.id.flashlightbutton);
        this.flash.setOnClickListener(new C03691());
        this.canned = (Button) findViewById(C0361R.id.cannedgoods);
        this.canned.setOnClickListener(new C03702());
        this.bottled = (Button) findViewById(C0361R.id.bottledwater);
        this.bottled.setOnClickListener(new C03713());
        this.alcohol = (Button) findViewById(C0361R.id.alcohol);
        this.alcohol.setOnClickListener(new C03724());
    }

    private void captureCameraImage() {
        Intent chooserIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        File f = new File(Environment.getExternalStorageDirectory(), "toclassify.jpg");
        Log.d("wew", f.getPath());
        chooserIntent.putExtra("output", Uri.fromFile(f));
        this.imageToUploadUri = Uri.fromFile(f);
        startActivityForResult(chooserIntent, CAMERA_PHOTO);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("wew", this.imageToUploadUri.getPath());
        if (requestCode != CAMERA_PHOTO || resultCode != -1) {
            return;
        }
        if (this.imageToUploadUri == null) {
            Toast.makeText(this, "Error while capturing Image", 1).show();
        } else if (this.service != null) {
            try {
                ClassifyImagesOptions.Builder options = new ClassifyImagesOptions.Builder();
                options.classifierIds("typhoonkits_825741593");
                options.images(new File(this.imageToUploadUri.getPath()));
                options.threshold(0.0d);
                VisualClassification result = (VisualClassification) this.service.classify(options.build()).execute();
                Log.d("test1", result.toString());
                JSONArray as = new JSONObject(result.toString()).getJSONArray("images").getJSONObject(0).getJSONArray("classifiers").getJSONObject(0).getJSONArray("classes");
                double tempscore = 0.0d;
                int max = 0;
                for (int i = 0; i < as.length(); i++) {
                    Log.d("jsonresponse", as.getJSONObject(i).getString("class") + "  " + as.getJSONObject(i).getString("score"));
                    double temp = Double.parseDouble(as.getJSONObject(i).getString("score"));
                    if (temp > tempscore) {
                        tempscore = temp;
                        max = i;
                    } else if (tempscore > temp) {
                    }
                }
                String string = as.getJSONObject(max).getString("class");
                Toast.makeText(this, "This Item is " + r16, 0).show();
            } catch (Exception e) {
                Log.e("earl is real", "onActivityResult: " + e.getMessage(), e);
            }
        } else {
            Toast.makeText(this, "Error while capturing Image", 1).show();
        }
    }

    private Bitmap getBitmap(String path) {
        Uri uri = Uri.fromFile(new File(path));
        try {
            Bitmap b;
            InputStream in = getContentResolver().openInputStream(uri);
            Options o = new Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(in, null, o);
            in.close();
            int scale = 1;
            while (true) {
                if (((double) (o.outWidth * o.outHeight)) * (1.0d / Math.pow((double) scale, 2.0d)) <= 1200000.0d) {
                    break;
                }
                scale++;
            }
            StringBuilder append = new StringBuilder().append("scale = ");
            int i = o.outWidth;
            Log.d(BuildConfig.FLAVOR, r19.append(scale).append(", orig-width: ").append(r0).append(", orig-height: ").append(o.outHeight).toString());
            in = getContentResolver().openInputStream(uri);
            if (scale > 1) {
                scale--;
                o = new Options();
                o.inSampleSize = scale;
                b = BitmapFactory.decodeStream(in, null, o);
                int height = b.getHeight();
                int width = b.getWidth();
                Log.d(BuildConfig.FLAVOR, "1th scale operation dimenions - width: " + width + ", height: " + height);
                double y = Math.sqrt(1200000.0d / (((double) width) / ((double) height)));
                double d = (double) width;
                Bitmap scaledBitmap = Bitmap.createScaledBitmap(b, (int) ((y / ((double) height)) * r0), (int) y, true);
                b.recycle();
                b = scaledBitmap;
                System.gc();
            } else {
                b = BitmapFactory.decodeStream(in);
            }
            in.close();
            Log.d(BuildConfig.FLAVOR, "bitmap size - width: " + b.getWidth() + ", height: " + b.getHeight());
            return b;
        } catch (IOException e) {
            Log.e(BuildConfig.FLAVOR, e.getMessage(), e);
            return null;
        }
    }
}
