package fun.bot.amaze.amazebot_gpsshare;

import android.content.Context;
import android.widget.Toast;

import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpPost;
import com.koushikdutta.async.http.AsyncHttpResponse;
import com.koushikdutta.async.http.body.StringBody;

import java.sql.SQLOutput;

/**
 * Created by sunny on 07-Apr-18.
 */

public class BotRemoteServer {

    private GPSTracker gpsTracker;
    private Context applicationContext;

    public BotRemoteServer(GPSTracker gpsTracker, Context applicationContext) {
        this.gpsTracker = gpsTracker;
        this.applicationContext = applicationContext;
    }

    public void startGPSLocShare() {
        AsyncHttpPost postLoc = new AsyncHttpPost("http://192.168.0.101/postLoc");
        StringBody stringBody = new StringBody("{\n" +
                "  \"Location\" : {\n" +
                "    \"Latitude\" : 123,\n" +
                "    \"Longitude\" : 456\n" +
                "  }\n" +
                "}");
        postLoc.setBody(stringBody);
        AsyncHttpClient.getDefaultInstance().executeString(postLoc, new AsyncHttpClient.StringCallback() {

            @Override
            public void onCompleted(Exception e, AsyncHttpResponse source, String result) {
                Toast.makeText(applicationContext, result, Toast.LENGTH_LONG).show();
            }
        });

    }
}
