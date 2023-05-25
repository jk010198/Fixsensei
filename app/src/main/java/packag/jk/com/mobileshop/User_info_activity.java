package packag.jk.com.mobileshop;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User_info_activity extends AppCompatActivity {

    // for bundle
    String Device_Name, Model_Name, Model_Color, Issue, Date_Slot, Time_Slot;
    String Uname, Email, Phoneno, Altphnno, Validemail;

    EditText et1, et2, et3, et4;
    Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_activity);
        et1 = findViewById(R.id.et_name);
        et2 = findViewById(R.id.et_email);
        et3 = findViewById(R.id.et_phoneno);
        et4 = findViewById(R.id.et_alt_phoneno);

        // extract bundle
        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        Device_Name = bundle.getString("device_name");
        Model_Name = bundle.getString("model_name");
        Model_Color = bundle.getString("model_color");
        Issue = bundle.getString("issue");
        Date_Slot = bundle.getString("date_slot");
        Time_Slot = bundle.getString("time_slot");
    }

    public void next_location_info(View view) {
        Uname = et1.getText().toString();
        Email = et2.getText().toString();
        Phoneno = et3.getText().toString();
        Altphnno = et4.getText().toString();
        Validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" + "(" + "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+";

        Matcher matcher = Pattern.compile(Validemail).matcher(Email);

        if (Uname.isEmpty()) {
            et1.setError("Please Enter Name");
        } else if (!(matcher.matches())) {
            et2.setError("Enter Valid Email");
        } else if (Phoneno.length() >= 11 || Phoneno.length() < 10 || Phoneno.isEmpty()) {
            et3.setError("Invalid Number");
        } else if (Altphnno.length() >= 1 && Altphnno.length() < 10 || Altphnno.length() >= 11) {
            et4.setError("Invalid Number");
        } else {
            try {
                Bundle b = new Bundle();
                b.putString("device_name", Device_Name);
                b.putString("model_name", Model_Name);
                b.putString("model_color", Model_Color);
                b.putString("issue", Issue);
                b.putString("date_slot", Date_Slot);
                b.putString("time_slot", Time_Slot);
                b.putString("u_name", Uname);
                b.putString("email", Email);
                b.putString("phn_no", Phoneno);
                b.putString("alt_phn_no", Altphnno);
                Intent i = new Intent(getApplicationContext(), Location_info_activity.class);
                i.putExtras(b);
                startActivity(i);
                //startActivity(new Intent(getApplicationContext(), Location_info_activity.class));
            } catch (Exception e) {
//                Toast.makeText(this, "" + e, Toast.LENGTH_LONG).show();
            }
        }
    }

    /*
    public void Datepicker(View view) {

        et = findViewById(R.id.et_datepicker);

        c = Calendar.getInstance();
        final int y = c.get(c.YEAR);
        final int m = c.get(c.MONTH);
        final int d = c.get(c.DAY_OF_MONTH);


        /// ye hai code...
        DatePickerDialog dpd = new DatePickerDialog(User_info_activity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int month, int i2) {
                et.setText(i2 + "/" + (month + 1) + "/" + i);
            }


        }, Calendar.YEAR, Calendar.MONTH,
                Calendar.DAY_OF_MONTH);
        dpd.getDatePicker().setMinDate(c.getTimeInMillis());
        dpd.show();
    }*/
}
