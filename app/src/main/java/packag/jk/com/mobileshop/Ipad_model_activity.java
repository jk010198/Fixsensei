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

public class Ipad_model_activity extends AppCompatActivity {

    Spinner s;
    String ipad_model[] = {"---Select Model---", "iPad 2", "iPad 3", "iPad 4", "iPad Mini", "iPad Mini 2",
            "iPad Mini 3", "iPad Mini 4", "iPad Air", "iPad Air 2",
            "iPad Pro 2015", "iPad Pro 2016", "Device is not in the list"};
    String Device_Name, Model_Name;
    String no_selection_ipad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipad_model_activity);

        // extract bundle
        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        Device_Name = bundle.getString("device_name");
        //Create the text view


        //b.setEnabled(false);
        s = findViewById(R.id.spinner_ipad);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, ipad_model);
        s.setAdapter(aa);
        //s.setDropDownWidth(300);
        //s.setSelection(3);
        s.setDropDownVerticalOffset(110);
        s.getGravity();

        s.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ((TextView) s.getSelectedView()).setTextColor(Color.BLACK);
                ((TextView) s.getSelectedView()).setTextSize(23);
            }
        });

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Model_Name = (String) adapterView.getItemAtPosition(position);
                no_selection_ipad = (String) adapterView.getItemAtPosition(position);
                //adapterView.getChildAt(0).setTextColor(Color.WHITE);
                //b.setEnabled(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void next_mobile_problem(View view) {

        if (!no_selection_ipad.equals("---Select Model---")) {
            if (Model_Name.equals("Device is not in the list")) {
                Intent i = new Intent(getApplicationContext(), Samsung_model_activity.class);
                i.putExtra("device_name", Device_Name);
                startActivity(i);
            } else {
                Intent i = new Intent(getApplicationContext(), Model_Color_Ipad.class);
                Bundle b = new Bundle();
                b.putString("device_name", Device_Name);
                b.putString("model_name", Model_Name);
                i.putExtras(b);
                startActivity(i);
            }
        }
    }
}
