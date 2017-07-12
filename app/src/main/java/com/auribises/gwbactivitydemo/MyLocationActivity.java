package com.auribises.gwbactivitydemo;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MyLocationActivity extends AppCompatActivity implements LocationListener {

    @InjectView(R.id.textViewLocation)
    TextView txtLocation;

    @InjectView(R.id.buttonFetch)
    Button btnFetch;

    LocationManager locationManager;

    NotificationManager notificationManager;
    NotificationCompat.Builder builder;
    Notification notification;

    double latitude, longitude;

    ProgressDialog progressDialog;

    /*void initViews(){
        txtLocation = (TextView)findViewById(R.id.textViewLocation);
        btnFetch = (Button)findViewById(R.id.buttonFetch);
    }*/


    void showNotification(){
        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Location");
        builder.setContentText("Location is: "+latitude+" - "+longitude);
        builder.setSmallIcon(R.drawable.music);
        builder.setDefaults(Notification.DEFAULT_ALL); // VIBRATE Permission must be written in Manifest

        Intent intent = new Intent(MyLocationActivity.this,ActivityOne.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,222,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        notification = builder.build();

        notificationManager.notify(101,notification);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_location);
        //initViews();
        ButterKnife.inject(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        // Handling Button Click through Anonymous Class
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ActivityCompat.checkSelfPermission(MyLocationActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MyLocationActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MyLocationActivity.this,"Please Grant Permissions in Settings",Toast.LENGTH_LONG).show();
                }else {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10, 5, MyLocationActivity.this);
                    progressDialog.show();
                }

            }
        });
    }

    @Override
    public void onLocationChanged(Location location) {

        latitude = location.getLatitude();
        longitude = location.getLongitude();

        txtLocation.setText("Location is: "+latitude+" - "+longitude);

        // Reverse Geocoding
        try {
            Geocoder geocoder = new Geocoder(this);
            List<Address> adrsList = geocoder.getFromLocation(latitude,longitude,5);

            if(adrsList!=null && adrsList.size()>0){
                Address address = adrsList.get(0);
                StringBuffer buffer = new StringBuffer();

                for(int i=0;i<address.getMaxAddressLineIndex();i++){
                    buffer.append(address.getAddressLine(i)+"\n");
                }

                txtLocation.setText("Address: "+buffer.toString());
            }



        }catch (Exception e){
            e.printStackTrace();
        }

        //location.getSpeed();
        //location.distanceTo(location1)

        showNotification();
        progressDialog.dismiss();
        locationManager.removeUpdates(this);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
