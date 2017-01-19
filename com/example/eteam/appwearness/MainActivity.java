package com.example.eteam.appwearness;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.example.eteam.appwearness.Global.Config;
import com.example.eteam.appwearness.Interface.RequestInterface;
import com.example.eteam.appwearness.Object.Coordinate;
import com.example.eteam.appwearness.Object.OpenWeather.Coord;
import com.example.eteam.appwearness.Object.OpenWeather.Weather;
import com.example.eteam.appwearness.Object.OpenWeatherItem;
import com.example.eteam.appwearness.Object.OpenWeatherResponse;
import com.example.eteam.appwearness.Object.Report;
import com.example.eteam.appwearness.Object.ReportResponse;
import com.example.eteam.appwearness.Object.ReportType;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.C0397R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.wearable.MessageApi;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelSlideListener;
import com.sothree.slidinguppanel.SlidingUpPanelLayout.PanelState;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnNavigationItemSelectedListener, OnConnectionFailedListener, ConnectionCallbacks {
    private static final int CAMERA_PHOTO = 111;
    private static final String TAG = "DemoActivity";
    private Uri imageToUploadUri;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private SlidingUpPanelLayout mLayout;
    private GoogleMap mMap;
    private SupportMapFragment mapFragment;

    /* renamed from: com.example.eteam.appwearness.MainActivity.1 */
    class C03501 implements Runnable {
        C03501() {
        }

        public void run() {
            SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this.getBaseContext());
            if (getPrefs.getBoolean("firstStart", true)) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, Intro.class));
                Editor e = getPrefs.edit();
                e.putBoolean("firstStart", false);
                e.apply();
            }
        }
    }

    /* renamed from: com.example.eteam.appwearness.MainActivity.2 */
    class C03512 implements PanelSlideListener {
        C03512() {
        }

        public void onPanelSlide(View panel, float slideOffset) {
            Log.i(MainActivity.TAG, "onPanelSlide, offset " + slideOffset);
        }

        public void onPanelStateChanged(View panel, PanelState previousState, PanelState newState) {
            Log.i(MainActivity.TAG, "onPanelStateChanged " + newState);
        }
    }

    /* renamed from: com.example.eteam.appwearness.MainActivity.3 */
    class C03523 implements OnClickListener {
        C03523() {
        }

        public void onClick(View view) {
            MainActivity.this.mLayout.setPanelState(PanelState.COLLAPSED);
        }
    }

    /* renamed from: com.example.eteam.appwearness.MainActivity.4 */
    class C03534 implements OnClickListener {
        C03534() {
        }

        public void onClick(View v) {
            MainActivity.this.sendReport(1);
        }
    }

    /* renamed from: com.example.eteam.appwearness.MainActivity.5 */
    class C03545 implements OnClickListener {
        C03545() {
        }

        public void onClick(View v) {
            MainActivity.this.sendReport(2);
        }
    }

    /* renamed from: com.example.eteam.appwearness.MainActivity.6 */
    class C03556 implements OnClickListener {
        C03556() {
        }

        public void onClick(View v) {
            MainActivity.this.sendReport(3);
        }
    }

    /* renamed from: com.example.eteam.appwearness.MainActivity.7 */
    class C03577 implements OnMapReadyCallback {

        /* renamed from: com.example.eteam.appwearness.MainActivity.7.1 */
        class C03561 implements Callback<ReportResponse> {
            C03561() {
            }

            public void onResponse(Call<ReportResponse> call, Response<ReportResponse> response) {
                Log.i(MainActivity.TAG, "onResponse: getreports code -> " + response.code());
                if (response.code() == ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION) {
                    List<ReportType> reportTypes = ((ReportResponse) response.body()).getReportTypes();
                    Log.d(MainActivity.TAG, "onResponse: report count -> " + ((ReportResponse) response.body()).getReports().size());
                    for (Report report : ((ReportResponse) response.body()).getReports()) {
                        Coordinate coordinate = report.getCoordinate();
                        LatLng latLng = new LatLng(coordinate.getLat(), coordinate.getLon());
                        MarkerOptions option = new MarkerOptions();
                        option.position(latLng);
                        option.icon(BitmapDescriptorFactory.fromResource(MainActivity.this.getApplicationContext().getResources().getIdentifier("ic_floodicon", "drawable", MainActivity.this.getApplicationContext().getPackageName())));
                        option.title(((ReportType) reportTypes.get(report.getReport_type_id() - 1)).getDescription());
                        MainActivity.this.mMap.addMarker(option);
                    }
                }
            }

            public void onFailure(Call<ReportResponse> call, Throwable t) {
                Log.e(MainActivity.TAG, "onFailure: " + t.getMessage(), t);
            }
        }

        C03577() {
        }

        public void onMapReady(GoogleMap map) {
            MainActivity.this.loadMap(map);
            LatLng philippines = new LatLng(15.59305d, 120.739067d);
            ((RequestInterface) Config.getClient(Config.SERVER).create(RequestInterface.class)).getFloodReports().enqueue(new C03561());
            if (ContextCompat.checkSelfPermission(MainActivity.this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(MainActivity.this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                MainActivity.this.mMap.setMyLocationEnabled(true);
            }
        }
    }

    /* renamed from: com.example.eteam.appwearness.MainActivity.8 */
    class C03598 implements Callback<OpenWeatherResponse> {

        /* renamed from: com.example.eteam.appwearness.MainActivity.8.1 */
        class C03581 implements OnMarkerClickListener {
            C03581() {
            }

            public boolean onMarkerClick(Marker marker) {
                MainActivity.this.mLayout.setPanelState(PanelState.COLLAPSED);
                return false;
            }
        }

        C03598() {
        }

        public void onResponse(Call<OpenWeatherResponse> call, Response<OpenWeatherResponse> response) {
            Log.i(MainActivity.TAG, "onResponse: code -> " + response.code());
            if (response.code() == ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION) {
                Log.d(MainActivity.TAG, "onResponse: orayt");
                OpenWeatherResponse openWeather = (OpenWeatherResponse) response.body();
                Log.d(MainActivity.TAG, "onResponse: size -> " + openWeather.getCount());
                for (OpenWeatherItem item : openWeather.getList()) {
                    Coord coordinate = item.getCoord();
                    Weather weather = (Weather) item.getWeather().get(0);
                    MarkerOptions option = new MarkerOptions();
                    option.position(new LatLng(coordinate.getLat(), coordinate.getLon()));
                    option.icon(BitmapDescriptorFactory.fromResource(MainActivity.this.getApplicationContext().getResources().getIdentifier("weather_" + weather.getIcon(), "drawable", MainActivity.this.getApplicationContext().getPackageName())));
                    option.title(weather.getMain());
                    option.snippet(weather.getDescription());
                    MainActivity.this.mMap.addMarker(option);
                    MainActivity.this.mMap.setOnMarkerClickListener(new C03581());
                }
            }
        }

        public void onFailure(Call<OpenWeatherResponse> call, Throwable t) {
            Log.e(MainActivity.TAG, "onFailure: " + t.getMessage(), t);
        }
    }

    /* renamed from: com.example.eteam.appwearness.MainActivity.9 */
    class C03609 implements Callback<Integer> {
        C03609() {
        }

        public void onResponse(Call<Integer> call, Response<Integer> response) {
            Log.i(MainActivity.TAG, "onResponse: code -> " + response.code());
            if (response.code() == ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION) {
                Log.d(MainActivity.TAG, "onResponse: " + response.body());
                Toast.makeText(MainActivity.this, "Success! " + response.body(), 0).show();
            }
        }

        public void onFailure(Call<Integer> call, Throwable t) {
            Log.e(MainActivity.TAG, "onFailure: " + t.getMessage(), t);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0361R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(C0397R.id.toolbar);
        setSupportActionBar(toolbar);
        new Thread(new C03501()).start();
        if (this.mGoogleApiClient == null) {
            this.mGoogleApiClient = new Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(C0361R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, C0361R.string.navigation_drawer_open, C0361R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        this.mLayout = (SlidingUpPanelLayout) findViewById(C0361R.id.sliding_layout1);
        this.mLayout.setAnchorPoint(0.5f);
        this.mLayout.setPanelState(PanelState.HIDDEN);
        this.mLayout.addPanelSlideListener(new C03512());
        this.mLayout.setFadeOnClickListener(new C03523());
        ((NavigationView) findViewById(C0361R.id.nav_view)).setNavigationItemSelectedListener(this);
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(C0361R.id.flood2);
        FloatingActionButton fab3 = (FloatingActionButton) findViewById(C0361R.id.flood1);
        ((FloatingActionButton) findViewById(C0361R.id.flood3)).setOnClickListener(new C03534());
        fab2.setOnClickListener(new C03545());
        fab3.setOnClickListener(new C03556());
        this.mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(C0361R.id.map);
        if (this.mapFragment != null) {
            this.mapFragment.getMapAsync(new C03577());
        }
    }

    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(C0361R.id.drawer_layout);
        if (drawer.isDrawerOpen((int) MediaRouterJellybean.ALL_ROUTE_TYPES)) {
            drawer.closeDrawer((int) MediaRouterJellybean.ALL_ROUTE_TYPES);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0361R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == C0361R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = new Intent(this, Typhoon.class);
        if (id == C0361R.id.nav_share) {
            startActivity(new Intent(this, ToolKit.class));
        } else if (id == C0361R.id.nav_Typhoon) {
            intent.putExtra("index", 6);
            startActivity(intent);
        } else if (id == C0361R.id.nav_earthquake) {
            intent.putExtra("index", 2);
            startActivity(intent);
        } else if (id == C0361R.id.nav_fire) {
            intent.putExtra("index", 1);
            startActivity(intent);
        } else if (id == C0361R.id.nav_landslides) {
            intent.putExtra("index", 3);
            startActivity(intent);
        } else if (id == C0361R.id.nav_stormsurge) {
            intent.putExtra("index", 4);
            startActivity(intent);
        } else if (id == C0361R.id.nav_Volcanoes) {
            intent.putExtra("index", 5);
            startActivity(intent);
        } else if (id == C0361R.id.nav_send) {
            Intent resultIntent = new Intent("com.example.anthony.visualrecog.MainActivity");
            PendingIntent pIntent = PendingIntent.getActivity(getApplicationContext(), 0, resultIntent, 0);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this).setSmallIcon(C0361R.mipmap.ic_launcher).addAction(0, "Yes", pIntent).addAction(0, "No", PendingIntent.getActivity(getApplicationContext(), 0, new Intent(this, Typhoon.class), 0)).setColor(-1).setContentTitle("Strong Typhoon Incoming").setContentText("Are you ready?");
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            stackBuilder.addParentStack(MainActivity.class);
            stackBuilder.addNextIntent(resultIntent);
            mBuilder.setContentIntent(stackBuilder.getPendingIntent(0, 134217728));
            ((NotificationManager) getSystemService("notification")).notify(0, mBuilder.build());
        }
        ((DrawerLayout) findViewById(C0361R.id.drawer_layout)).closeDrawer((int) MediaRouterJellybean.ALL_ROUTE_TYPES);
        return true;
    }

    protected void onStart() {
        this.mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        this.mGoogleApiClient.disconnect();
        super.onStop();
    }

    protected void loadMap(GoogleMap googleMap) {
        this.mMap = googleMap;
        if (this.mMap != null) {
            Toast.makeText(this, "Map Fragment was loaded properly!", 0).show();
        } else {
            Toast.makeText(this, "Error - Map was null!!", 0).show();
        }
    }

    public void onConnected(@Nullable Bundle bundle) {
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            Log.d(TAG, "onConnected: Permission ok");
            this.mLastLocation = LocationServices.FusedLocationApi.getLastLocation(this.mGoogleApiClient);
            if (this.mLastLocation != null) {
                Log.d(TAG, "latitude : " + String.valueOf(this.mLastLocation.getLatitude()));
                Log.d(TAG, "longitude : " + String.valueOf(this.mLastLocation.getLongitude()));
                this.mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(this.mLastLocation.getLatitude(), this.mLastLocation.getLongitude()), 14.0f));
                ((RequestInterface) Config.getClient(Config.OPEN_WEATHER).create(RequestInterface.class)).getWeather(this.mLastLocation.getLatitude(), this.mLastLocation.getLongitude(), 50, Config.OPEN_WEATHER_API).enqueue(new C03598());
                return;
            }
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1);
    }

    public void onConnectionSuspended(int i) {
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MessageApi.FILTER_PREFIX /*1*/:
                if (grantResults.length <= 0 || grantResults[0] != 0) {
                    Toast.makeText(getApplicationContext(), "Cannot Get Your current Location", 0).show();
                }
            default:
        }
    }

    private void sendReport(int reportTypeId) {
        ((RequestInterface) Config.getClient(Config.SERVER).create(RequestInterface.class)).reportFlood(new Report(getApplicationContext().getSharedPreferences(getString(C0361R.string.preference_file_key), 0).getInt(getString(C0361R.string.device_id_key), 0), new Coordinate(this.mLastLocation.getLongitude(), this.mLastLocation.getLatitude()), reportTypeId)).enqueue(new C03609());
    }
}
