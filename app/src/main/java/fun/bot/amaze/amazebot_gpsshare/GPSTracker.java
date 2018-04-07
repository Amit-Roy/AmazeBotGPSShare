package fun.bot.amaze.amazebot_gpsshare;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by sunny on 07-Apr-18.
 */

public class GPSTracker implements LocationListener {

    private Context context;

    public GPSTracker(Context context) {
        this.context = context;
    }

    public Location getLocation() {

        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "Permission for GPS not granted", Toast.LENGTH_LONG).show();
            return null;
        }

        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (locationManager != null) {
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000, 10, this);
                return locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            } else {
                Toast.makeText(context, "Please enable GPS", Toast.LENGTH_LONG).show();
            }
        }

        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
