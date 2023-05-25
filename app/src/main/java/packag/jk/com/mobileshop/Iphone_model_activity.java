package packag.jk.com.mobileshop;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.GONE;

public class Iphone_model_activity extends AppCompatActivity {

    Spinner s;
    String iphone_model[] = {"---Select Model---", "iPhone 4", "iPhone 4S", "iPhone 5", "iPhone 5S", "iPhone 5C",
            "iPhone SE", "iPhone 6", "iPhone 6S", "iPhone 6 Plus", "iPhone 6S Plus", "iPhone 7",
            "iPhone 7 Plus", "iPhone 8", "iPhone 8 Plus", "iPhone X","Device is not in the list"};
    // for bundle
    String Device_Name, Model_Name;
    String no_selection_iphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iphone_model_activity);

        // extract bundle
        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        Device_Name = bundle.getString("device_name");

        s = findViewById(R.id.spinner_iphone);

        ArrayAdapter aa = new ArrayAdapter(Iphone_model_activity.this, android.R.layout.simple_spinner_dropdown_item, iphone_model);
        s.setAdapter(aa);
        s.setDropDownVerticalOffset(110);
        s.getGravity();

        s.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView)s.getSelectedView()).setTextColor(Color.BLACK);
                ((TextView)s.getSelectedView()).setTextSize(23);
            }
        });

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Model_Name = (String) adapterView.getItemAtPosition(position);
                no_selection_iphone = (String) adapterView.getItemAtPosition(position);
                //adapterView.getChildAt(0).setTextColor(Color.WHITE);
                //b.setEnabled(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void nxt_activity(View view) {

        if (!no_selection_iphone.equals("---Select Model---")) {
            if (Model_Name.equals("Device is not in the list")) {
                Intent i = new Intent(getApplicationContext(), Samsung_model_activity.class);
                i.putExtra("device_name", Device_Name);
                startActivity(i);
            } else {
                Intent i1 = new Intent(getApplicationContext(), model_color.class);
                i1.putExtra("device_name", Device_Name);
                i1.putExtra("model_name", Model_Name);
                startActivity(i1);
            }
            //startActivity(new Intent(getApplicationContext(), All_mobile_problem_activity.class));
        }
    }
}
