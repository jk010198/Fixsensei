package packag.jk.com.mobileshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date_time_book_samsung_activity extends AppCompatActivity {

    // for bundle
    String Samsung_Device_Name, Samsung_Model_Name, Samsung_Issue, Samsung_model_color;
    TabHost tabhost;
    Calendar c;
    String date_slot, time_slot;
    RadioButton rb1;
    boolean enable = false;
    String a;
    int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_book_samsung_activity);
        rb1 = findViewById(R.id.rb_1);

        tabhost = findViewById(R.id.tb1);


        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        c = Calendar.getInstance();
        Calendar today = c;

        time = (c.get(Calendar.HOUR_OF_DAY));

        /// for tab_1
        tabhost.setup();
        TabHost.TabSpec tab1 = tabhost.newTabSpec(""+sdf.format(c.getTime()));
        tab1.setContent(R.id.tab1);
        a = sdf.format(c.getTime());
        tab1.setIndicator(sdf.format(c.getTime()));
        tabhost.addTab(tab1);

        if (tabhost.getCurrentTabTag().equals(a)){
            if (time >= 13)
            {
                rb1.setEnabled(false);
            }
        }

        c.add(Calendar.DAY_OF_MONTH, 1);
        Calendar tomorrow = c;

        /// for tab_2
        tabhost.setup();
        TabHost.TabSpec tab2 = tabhost.newTabSpec(""+sdf.format(c.getTime()));
        tab2.setContent(R.id.tab2);
        tab2.setIndicator(sdf.format(c.getTime()));
        tabhost.addTab(tab2);

        c.add(Calendar.DAY_OF_MONTH, 1);
        Calendar tomorrow_nxt = c;

        /// for tab_3
        tabhost.setup();
        TabHost.TabSpec tab3 = tabhost.newTabSpec(""+sdf.format(c.getTime()));
        tab3.setContent(R.id.tab3);
        tab3.setIndicator(sdf.format(c.getTime()));
        tabhost.addTab(tab3);

        date_slot = tabhost.getCurrentTabTag();
      //  Toast.makeText(this, ""+date_slot, Toast.LENGTH_SHORT).show();

        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                date_slot = tabId;
                if (tabhost.getCurrentTabTag().equals(a)){
                    if (time >= 13)
                    {
                        rb1.setEnabled(false);
                        enable = false;
                    }
                } else {
                    rb1.setEnabled(true);
                    enable = true;
                }
//                Toast.makeText(Date_time_book_samsung_activity.this, ""+date_slot, Toast.LENGTH_SHORT).show();
            }
        });

        // extract bundle
        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        Samsung_Device_Name = bundle.getString("device_name");
        Samsung_Model_Name = bundle.getString("samsung_model_name");
        Samsung_Issue = bundle.getString("samsung_model_issue");
        Samsung_model_color = bundle.getString("samsung_model_color");

    }

    public void isCheckedRadio(View view) {
        String rt1 = rb1.getText().toString();


        if (rb1.isChecked()) {
            enable = true;
            time_slot = rt1;
//            Toast.makeText(this, "" + rt1, Toast.LENGTH_SHORT).show();
        }
    }

    public void next_fill_details(View view) {
        if (enable) {
            Intent i = new Intent(getApplicationContext(), User_info_activity.class);
            Bundle b = new Bundle();
            b.putString("device_name", Samsung_Device_Name);
            b.putString("model_name", Samsung_Model_Name);
            b.putString("model_color", Samsung_model_color);
            b.putString("issue", Samsung_Issue);
            b.putString("date_slot", date_slot);
            b.putString("time_slot", time_slot);
            i.putExtras(b);
            startActivity(i);
        }
    }
}
