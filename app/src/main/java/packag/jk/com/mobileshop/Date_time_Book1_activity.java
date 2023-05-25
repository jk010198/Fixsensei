package packag.jk.com.mobileshop;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date_time_Book1_activity extends AppCompatActivity {

    // for bundle
    String Device_Name, Model_Name, Model_Color, Issue;
    String Current_Date_Slot, Date_Slot, Time_Slot;

    TabHost tabhost;

    RadioButton rb1;

    // for checking radio button is checked or not
    boolean enable = false;

    Calendar c;
    int time;
    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time__book_activity);
        tabhost = findViewById(R.id.tb1);
        rb1 = findViewById(R.id.rb_1);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        c = Calendar.getInstance();
        Calendar today = c;

        time = (c.get(Calendar.HOUR_OF_DAY));
        //int date = c.get(Calendar.DATE);

        /// for tab_1
        tabhost.setup();
        TabHost.TabSpec tab1 = tabhost.newTabSpec("" + sdf.format(c.getTime()));
        tab1.setContent(R.id.tab1);
        a = sdf.format(c.getTime());
        tab1.setIndicator(sdf.format(c.getTime()));
        tabhost.addTab(tab1);
        tabhost.onTouchModeChanged(true);

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
        TabHost.TabSpec tab2 = tabhost.newTabSpec("" + sdf.format(c.getTime()));
        tab2.setContent(R.id.tab2);
        tab2.setIndicator(sdf.format(c.getTime()));
        tabhost.addTab(tab2);
        tabhost.onTouchModeChanged(true);

        c.add(Calendar.DAY_OF_MONTH, 1);
        Calendar tomorrow_nxt = c;

        /// for tab_3
        tabhost.setup();
        TabHost.TabSpec tab3 = tabhost.newTabSpec("" + sdf.format(c.getTime()));
        tab3.setContent(R.id.tab3);
        tab3.setIndicator(sdf.format(c.getTime()));
        tabhost.addTab(tab3);

        Date_Slot = tabhost.getCurrentTabTag();

        //Current_Date_Slot = tabhost.getCurrentTabTag();
      //  Toast.makeText(this, "" + Date_Slot, Toast.LENGTH_SHORT).show();

        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Date_Slot = tabId;
                if (tabhost.getCurrentTabTag().equals(a)){
                    if (time >= 13)
                    {
                        rb1.setEnabled(false);
                        enable = false;
                    }
                } else {
                    rb1.setEnabled(true);
                    if (rb1.isChecked()) {
                        enable = true;
                    }
                }
               // Toast.makeText(Date_time_Book1_activity.this, "" + Date_Slot, Toast.LENGTH_SHORT).show();
            }
        });


        // extract bundle
        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        Device_Name = bundle.getString("device_name");
        Model_Name = bundle.getString("model_name");
        Model_Color = bundle.getString("model_color");
        Issue = bundle.getString("issue");
    }

    public void isCheckedRadio(View view) {
        String rt1 = rb1.getText().toString();

        if (rb1.isChecked()) {
            enable = true;
            Time_Slot = rt1;
           // Toast.makeText(this, "" + rt1, Toast.LENGTH_SHORT).show();
        }
    }

    public void next_fill_details(View view) {
        if (enable) {
            Intent i = new Intent(getApplicationContext(), User_info_activity.class);
            Bundle b = new Bundle();
            b.putString("device_name", Device_Name);
            b.putString("model_name", Model_Name);
            b.putString("model_color", Model_Color);
            b.putString("issue", Issue);
            b.putString("date_slot", Date_Slot);
            b.putString("time_slot", Time_Slot);
            i.putExtras(b);
            startActivity(i);
            //startActivity(new Intent(getApplicationContext(),User_info_activity.class));
        }
    }
}