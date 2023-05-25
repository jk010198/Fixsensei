package packag.jk.com.mobileshop;

import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_name, tv_website, tv_website_name, tv_contact, tv_contactNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Secondactivity(View view) {
        startActivity(new Intent(getApplicationContext(),Second_activity.class));
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
        adb.setTitle("Confirm");
        adb.setMessage("Do you want to exit...?");
        adb.setIcon(R.drawable.logo1);
        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent= new Intent(getApplicationContext(),Splashscreen.class);
                intent.putExtra("exit_code",true);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
        adb.setNegativeButton("No", null );
        adb.setCancelable(false);
        adb.show();

    }

    // create menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // when clicking menu option
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        switch (i) {
            case R.id.about_menu:
                final AlertDialog.Builder adb1 = new AlertDialog.Builder(MainActivity.this);
                View view1= getLayoutInflater().inflate(R.layout.about_us,null);
                adb1.setTitle("About Us");
                adb1.setIcon(R.drawable.logo1);
                adb1.setView(view1);
                adb1.setNegativeButton("Ok", null );
                tv_name =view1.findViewById(R.id.tv1_name);
                tv_website =view1.findViewById(R.id.tv_website);
                tv_website_name =view1.findViewById(R.id.tv_name_website);
                tv_contact =view1.findViewById(R.id.tv_contact);
                tv_contactNo =view1.findViewById(R.id.tv_contact_no);

                Typeface tf = Typeface.createFromAsset(getAssets(),
                        "fonts/font_4.TTF");
                //TextView tv = (TextView) findViewById(R.id.CustomFontText);
                tv_name.setTypeface(tf);
                tv_website.setTypeface(tf);
                tv_website_name.setTypeface(tf);
                tv_contact.setTypeface(tf);
                tv_contactNo.setTypeface(tf);

                adb1.show();
                break;
        }
        return true;
    }

}
