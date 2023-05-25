package packag.jk.com.mobileshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Samsung_model_activity extends AppCompatActivity {

    // for bundle
    String Device_Name;

    EditText et1, et2, et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samsung_model_activity);
        et1 = findViewById(R.id.et_samsung_model_name);
        et2 = findViewById(R.id.et_samsung_model_color);
        et3 = findViewById(R.id.et_samsung_issue);


//        // extract bundle
//        Bundle bundle = getIntent().getExtras();
//        //Extract the data…
//        Device_Name = bundle.getString("device_name");

        Intent i = getIntent();
        Device_Name = i.getStringExtra("device_name");
//        Toast.makeText(this, ""+Device_Name, Toast.LENGTH_SHORT).show();
    }


    public void next_mobile_problem(View view) {
        String model = et1.getText().toString();
        String model_color = et2.getText().toString();
        String model_issue = et3.getText().toString();

        if (model.isEmpty()) {
            et1.setError("Please Enter Model Name");
        } else if (model_color.isEmpty()) {
            et2.setError("Enter Model Color");
        } else if (model_issue.isEmpty()) {
            et3.setError("Enter Model Issue");
        }
        else {
            Intent i = new Intent(getApplicationContext(), Date_time_book_samsung_activity.class);
            Bundle b = new Bundle();
            b.putString("device_name", Device_Name);
            b.putString("samsung_model_name", model);
            b.putString("samsung_model_color", model_color);
            b.putString("samsung_model_issue", model_issue);
            i.putExtras(b);
            startActivity(i);
        }
    }
}
