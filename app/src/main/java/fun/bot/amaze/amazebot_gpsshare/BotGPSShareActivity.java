package fun.bot.amaze.amazebot_gpsshare;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BotGPSShareActivity extends AppCompatActivity {

    Button btnGetLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGetLoc = findViewById(R.id.btnGetLoc);
        ActivityCompat.requestPermissions(BotGPSShareActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        btnGetLoc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                GPSTracker gpsTracker = new GPSTracker(getApplicationContext());
                Location loc = gpsTracker.getLocation();
                Toast.makeText(getApplicationContext(), "Lat: " + loc.getLongitude() + " Lon: " + loc.getLongitude(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
