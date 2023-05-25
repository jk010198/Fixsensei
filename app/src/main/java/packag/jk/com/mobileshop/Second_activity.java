package packag.jk.com.mobileshop;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Second_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
    }

    public void iphone(View view) {
        Intent i = new Intent(getApplicationContext(), Iphone_model_activity.class);
        Bundle b = new Bundle();
        b.putString("device_name", "iPhone");
        i.putExtras(b);
        startActivity(i);
        //startActivity(new Intent(getApplicationContext(),Iphone_model_activity.class));
    }

    public void ipad(View view) {
        Intent i = new Intent(getApplicationContext(), Ipad_model_activity.class);
        Bundle b = new Bundle();
        b.putString("device_name", "iPad");
        i.putExtras(b);
        startActivity(i);
        //startActivity(new Intent(getApplicationContext(),Samsung_model_activity.class));
    }

    public void samsung(View view) {
        Intent i = new Intent(getApplicationContext(), Samsung_model_activity.class);
        Bundle b = new Bundle();
        b.putString("device_name", "Android");
        i.putExtras(b);
        startActivity(i);
        //startActivity(new Intent(getApplicationContext(),Samsung_model_activity.class));
    }
}
