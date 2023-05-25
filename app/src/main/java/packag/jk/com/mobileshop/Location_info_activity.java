package packag.jk.com.mobileshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Location_info_activity extends AppCompatActivity {

    // for bundle
    String Device_Name, Model_Name, Model_Color, Issue, Date_Slot, Time_Slot, U_name, Email, Phn_no, Alt_phn_no;
    String Address;

    String build_name, area, city, pin, landmark;

    EditText et1, et2, et3, et4, et5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_info_activity);
        et1 = findViewById(R.id.et_buildingname);
        et2 = findViewById(R.id.et_area);
        et3 = findViewById(R.id.et_city);
        et4 = findViewById(R.id.et_pincode);
        et5 = findViewById(R.id.et_land);

        // extract bundle
        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        Device_Name = bundle.getString("device_name");
        Model_Name = bundle.getString("model_name");
        Model_Color = bundle.getString("model_color");
        Issue = bundle.getString("issue");
        Date_Slot = bundle.getString("date_slot");
        Time_Slot = bundle.getString("time_slot");
        U_name = bundle.getString("u_name");
        Email = bundle.getString("email");
        Phn_no = bundle.getString("phn_no");
        Alt_phn_no = bundle.getString("alt_phn_no");
    }

    public void submit_data(View view) {
        build_name = et1.getText().toString();
        area = et2.getText().toString();
        city = et3.getText().toString();
        pin = et4.getText().toString();
        landmark = et5.getText().toString();

        if (build_name.isEmpty()) {
            et1.setError("Enter Flat No., Building Name");
        } else if (area.isEmpty()) {
            et2.setError("Enter Locatity, Area or Street");
        } else if (city.isEmpty()) {
            et3.setError("Enter City");
        } else if (pin.isEmpty() || pin.length() > 6 || pin.length() < 6) {
            et4.setError("Enter Valid Pincode");
        } else {
            if (landmark.isEmpty()) {
                Address = build_name + ",\n" + area + ",\n" + city + "," + pin;
            } else {
                Address = build_name + ",\n" + area + ",\n" + landmark + ",\n" + city + "," + pin;
            }

            Bundle b = new Bundle();
            b.putString("device_name", Device_Name);
            b.putString("model_name", Model_Name);
            b.putString("model_color", Model_Color);
            b.putString("issue",Issue);
            b.putString("date_slot", Date_Slot);
            b.putString("time_slot", Time_Slot);
            b.putString("u_name", U_name);
            b.putString("email", Email);
            b.putString("phn_no", Phn_no);
            b.putString("alt_phn_no", Alt_phn_no);
            b.putString("add", Address);
            Intent i = new Intent(getApplicationContext(), Info_preview.class);
            i.putExtras(b);
            startActivity(i);
        }
    }
}

