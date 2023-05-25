package packag.jk.com.mobileshop;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Info_preview_samsung extends AppCompatActivity {

    String Samsung_Device_Name, Samsung_Model_Name, Samsung_Issue, Samsung_Model_Color, Samsung_Phn_No,
            Samsung_Alt_Phn_No, Samsung_User_Add, Samsung_Date_Slot, Samsung_Time_slot, Samsung_User_Name,
            Samsung_Email;
    TextView tv_device_name, tv_model_name, tv_email, tv_issue, tv_date_time, tv_user_name, tv_phn_color,
            tv_contact_no, tv_alternate_contact, tv_add;

    DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_preview_samsung);

        tv_device_name = findViewById(R.id.tv_main_device_name);
        tv_model_name = findViewById(R.id.tv_main_model_name);
        tv_issue = findViewById(R.id.tv_main_issue_name);
        tv_date_time = findViewById(R.id.tv_main_time_date);
        tv_user_name = findViewById(R.id.tv_main_name);
        tv_email = findViewById(R.id.tv_main_email);
        tv_phn_color = findViewById(R.id.tv_main_phn_color);
        tv_contact_no = findViewById(R.id.tv_main_mobile_no);
        tv_alternate_contact = findViewById(R.id.tv_main_alternate_mobile_no);
        tv_add = findViewById(R.id.tv_main_address);

        //dbref = FirebaseDatabase.getInstance().getReference("Order");

        // extract bundle
        Bundle bundle = getIntent().getExtras();
        //Extract the data…
        Samsung_Device_Name = bundle.getString("device_name");
        Samsung_Model_Name = bundle.getString("samsung_model_name");
        Samsung_Issue = bundle.getString("samsung_model_issue");
        Samsung_Model_Color = bundle.getString("samsung_model_color");
        Samsung_Phn_No = bundle.getString("samsung_phn_no");
        Samsung_Alt_Phn_No = bundle.getString("samsung_alt_phn_no");
        Samsung_User_Add = bundle.getString("samsung_user_add");
        Samsung_Date_Slot = bundle.getString("samsung_date_slot");
        Samsung_Time_slot = bundle.getString("samsung_time_slot");
        Samsung_User_Name = bundle.getString("samsung_user_name");
        Samsung_Email = bundle.getString("samsung_user_email");
        //Create the text view
        try {
            tv_device_name.setText(Samsung_Device_Name);
            tv_model_name.setText(Samsung_Model_Name);
            tv_issue.setText(Samsung_Issue);
            tv_date_time.setText(Samsung_Date_Slot + "\n" + Samsung_Time_slot);
            tv_user_name.setText(Samsung_User_Name);
            tv_email.setText(Samsung_Email);
            tv_phn_color.setText(Samsung_Model_Color);
            tv_contact_no.setText(Samsung_Phn_No);
            tv_alternate_contact.setText(Samsung_Alt_Phn_No);
            tv_add.setText(Samsung_User_Add);
        } catch (Exception e) {
//            Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
        }
    }
    public void submitdata(View view) {
        addOrders();
    }

    public void addOrders(){
        dbref = FirebaseDatabase.getInstance().getReference("Order");
        String id = dbref.push().getKey();
        String device_name = Samsung_Device_Name;
        String model_name = Samsung_Model_Name;
        String issue =  Samsung_Issue;
        String date = Samsung_Date_Slot +"  "+ Samsung_Time_slot;
        String name = Samsung_User_Name;
        String email =  Samsung_Email;
        String model_color = Samsung_Model_Color;
        String phn = Samsung_Phn_No;
        String alt_phn =  Samsung_Alt_Phn_No;
        String add = Samsung_User_Add;
        String remark = "";

        order o = new order(id,device_name,model_name,issue,date,name,model_color,email,phn,alt_phn,add,remark);

        dbref.child(id).setValue(o);

       // Toast.makeText(this, "Data sent...", Toast.LENGTH_SHORT).show();

        AlertDialog.Builder adb = new AlertDialog.Builder(Info_preview_samsung.this);
        adb.setTitle("Thank You");
        adb.setMessage("Thank you for your request, you will be contacted momentary to confirmed your appointment.");
        adb.setIcon(R.drawable.ic_info);
        adb.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(Info_preview_samsung.this, "No...!", Toast.LENGTH_SHORT).show();
                finish();
                System.exit(0);
            }
        });
        adb.setCancelable(false);
        adb.show();
    }
}
