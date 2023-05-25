package packag.jk.com.mobileshop;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Info_preview extends AppCompatActivity {

    String Device_Name, Model_Name, Model_Color, Issue, Date_Slot, Time_Slot, U_name1, Email, Phn_no,
            Alt_phn_no, Add;
    TextView tv_device_name, tv_model_name, tv_model_color, tv_issue, tv_date_time, tv_user_name,
            tv_user_email, tv_contact_no, tv_alternate_contact, tv_add;

    DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_preview);

        tv_device_name = findViewById(R.id.tv_main_device_name);
        tv_model_name = findViewById(R.id.tv_main_model_name);
        tv_model_color = findViewById(R.id.tv_main_model_color);
        tv_issue = findViewById(R.id.tv_main_issue_name);
        tv_date_time = findViewById(R.id.tv_main_time_date);
        tv_user_name = findViewById(R.id.tv_main_name);
        tv_user_email = findViewById(R.id.tv_main_email);
        tv_contact_no = findViewById(R.id.tv_main_mobile_no);
        tv_alternate_contact = findViewById(R.id.tv_main_alternate_mobile_no);
        tv_add = findViewById(R.id.tv_main_address);


        //dbref = FirebaseDatabase.getInstance().getReference("Order");


        // extract bundle
        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        Device_Name = bundle.getString("device_name");
        Model_Name = bundle.getString("model_name");
        Model_Color = bundle.getString("model_color");
        Issue = bundle.getString("issue");
        Date_Slot = bundle.getString("date_slot");
        Time_Slot = bundle.getString("time_slot");
        U_name1 = bundle.getString("u_name");
        Email = bundle.getString("email");
        Phn_no = bundle.getString("phn_no");
        Alt_phn_no = bundle.getString("alt_phn_no");
        Add = bundle.getString("add");

        //Create the text view
        try {
            tv_device_name.setText(Device_Name);
            tv_model_name.setText(Model_Name);
            tv_model_color.setText(Model_Color);
            tv_issue.setText(Issue);
            tv_date_time.setText(Date_Slot + "\n" + Time_Slot);
            tv_user_name.setText(U_name1);
            tv_user_email.setText(Email);
            tv_contact_no.setText(Phn_no);
            tv_alternate_contact.setText(Alt_phn_no);
            tv_add.setText(Add);
        } catch (Exception e) {
//            Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
        }
    }


    public void sendData(View view) {
        if (checkConnection()) {
            addOrders();
        }
    }

    public void addOrders() {

        dbref = FirebaseDatabase.getInstance().getReference("Order");
        String id = dbref.push().getKey();
        String device_name = Device_Name;
        String model_name = Model_Name;
        String issue = Issue;
        String date = Date_Slot + "  " + Time_Slot;
        String name = U_name1;
        String model_color = Model_Color;
        String email = Email;
        String phn = Phn_no;
        String alt_phn = Alt_phn_no;
        String add = Add;
        String remark = "";

        order o = new order(id, device_name, model_name, issue, date, name, model_color, email, phn, alt_phn, add, remark);

        dbref.child(id).setValue(o);

//        Toast.makeText(this, "Data sent...", Toast.LENGTH_SHORT).show();

        AlertDialog.Builder adb = new AlertDialog.Builder(Info_preview.this);
        adb.setTitle("Thank You");
        adb.setMessage("Thank you for your request, you will be contacted momentary to confirmed your appointment.");
        adb.setIcon(R.drawable.logo1);
        adb.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(Info_preview.this, "No...!", Toast.LENGTH_SHORT).show();
                finishAffinity();
            }
        });
        adb.setCancelable(false);
        adb.show();
    }

    protected boolean checkConnection() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            Toast.makeText(Info_preview.this, "NO INTERNET CONNECTION...", Toast.LENGTH_LONG).show();
            return false;
        }
    }
}