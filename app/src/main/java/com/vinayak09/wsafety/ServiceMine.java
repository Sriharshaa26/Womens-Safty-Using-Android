package com.vinayak09.wsafety;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.IBinder;
import android.telephony.SmsManager;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import com.github.tbouron.shakedetector.library.ShakeDetector;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class ServiceMine extends Service {

    boolean isRunning = false;

    FusedLocationProviderClient fusedLocationClient;

    String num1 = "", num2 = "", num3 = "", num4 = "", num5 = "";
    String num6 = "", num7 = "", num8 = "", num9 = "", num10 = "";
    String num11 = "", num12 = "", num13 = "", num14 = "", num15 = "";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    SmsManager manager = SmsManager.getDefault();
    String myLocation;

    @Override
    public void onCreate() {
        super.onCreate();

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            // Logic to handle location object
                            location.getAltitude();
                            location.getLongitude();
                            myLocation = "http://maps.google.com/maps?q=loc:" + location.getLatitude() + "," + location.getLongitude();
                        } else {
                            myLocation = "Unable to Find Location :(";
                        }
                    }
                });


        ShakeDetector.create(this, () -> {

            //if you want to play siren sound you can do it here
            //just create music player and play here
            //before playing sound please set volume to max

            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);

            num1 = sharedPreferences.getString("ENUM1", "NONE");
            num2 = sharedPreferences.getString("ENUM2", "NONE");
            num3 = sharedPreferences.getString("ENUM3", "NONE");
            num4 = sharedPreferences.getString("ENUM4", "NONE");
            num5 = sharedPreferences.getString("ENUM5", "NONE");
            num6 = sharedPreferences.getString("ENUM6", "NONE");
            num7 = sharedPreferences.getString("ENUM7", "NONE");
            num8 = sharedPreferences.getString("ENUM8", "NONE");
            num9 = sharedPreferences.getString("ENUM9", "NONE");
            num10 = sharedPreferences.getString("ENUM10", "NONE");
            num11 = sharedPreferences.getString("ENUM11", "NONE");
            num12 = sharedPreferences.getString("ENUM12", "NONE");
            num13 = sharedPreferences.getString("ENUM13", "NONE");
            num14 = sharedPreferences.getString("ENUM14", "NONE");
            num15 = sharedPreferences.getString("ENUM15", "NONE");

            if (!num1.equalsIgnoreCase("NONE"))
                manager.sendTextMessage(num1, null, "Im in Trouble!\nSending My Location :\n" + myLocation, null, null);
            if (!num2.equalsIgnoreCase("NONE"))
                manager.sendTextMessage(num2, null, "Im in Trouble!\nSending My Location :\n" + myLocation, null, null);
            if (!num3.equalsIgnoreCase("NONE"))
                manager.sendTextMessage(num3, null, "Im in Trouble!\nSending My Location :\n" + myLocation, null, null);
            if (!num4.equalsIgnoreCase("NONE"))
                manager.sendTextMessage(num4, null, "Im in Trouble!\nSending My Location :\n" + myLocation, null, null);
            if (!num5.equalsIgnoreCase("NONE"))
                manager.sendTextMessage(num5, null, "Im in Trouble!\nSending My Location :\n" + myLocation, null, null);
            if (!num6.equalsIgnoreCase("NONE"))
                manager.sendTextMessage(num6, null, "Im in Trouble!\nSending My Location :\n" + myLocation, null, null);
            if (!num7.equalsIgnoreCase("NONE"))
                manager.sendTextMessage(num7, null, "Im in Trouble!\nSending My Location :\n" + myLocation, null, null);
            if (!num8.equalsIgnoreCase("NONE"))
                manager.sendTextMessage(num8, null, "Im in Trouble!\nSending My Location :\n" + myLocation, null, null);
            if (!num9.equalsIgnoreCase("NONE"))
                manager.sendTextMessage(num9, null, "Im in Trouble!\nSending My Location :\n" + myLocation, null, null);
            if (!num10.equalsIgnoreCase("NONE"))
                manager.sendTextMessage(num10, null, "Im in Trouble!\nSending My Location :\n" + myLocation, null, null);
            if (!num11.equalsIgnoreCase("NONE"))
                manager.sendTextMessage(num11, null, "Im in Trouble!\nSending My Location :\n" + myLocation, null, null);
            if (!num12.equalsIgnoreCase("NONE"))
                manager.sendTextMessage(num12, null, "Im in Trouble!\nSending My Location :\n" + myLocation, null, null);
            if (!num13.equalsIgnoreCase("NONE"))
                manager.sendTextMessage(num13, null, "Im in Trouble!\nSending My Location :\n" + myLocation, null, null);
            if (!num14.equalsIgnoreCase("NONE"))
                manager.sendTextMessage(num14, null, "Im in Trouble!\nSending My Location :\n" + myLocation, null, null);
            if (!num15.equalsIgnoreCase("NONE"))
                manager.sendTextMessage(num15, null, "Im in Trouble!\nSending My Location :\n" + myLocation, null, null);

        });

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        if (intent.getAction().equalsIgnoreCase("STOP")) {
            if (isRunning) {
                this.stopForeground(true);
                this.stopSelf();
            }
        } else {


            Intent notificationIntent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("MYID", "CHANNELFOREGROUND", NotificationManager.IMPORTANCE_DEFAULT);

                NotificationManager m = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                m.createNotificationChannel(channel);

                Notification notification = new Notification.Builder(this, "MYID")
                        .setContentTitle("Women Safety")
                        .setContentText("Shake Device to Send SOS")
                        .setSmallIcon(R.drawable.girl_vector)
                        .setContentIntent(pendingIntent)
                        .build();
                this.startForeground(115, notification);
                isRunning = true;
                return START_NOT_STICKY;
            }
        }

        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
