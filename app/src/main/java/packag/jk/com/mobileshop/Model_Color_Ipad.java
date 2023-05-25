package packag.jk.com.mobileshop;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Model_Color_Ipad extends AppCompatActivity {

    String Device_Name, Model_Name;
    Button b1, b2, b3, b4;
    ListView lv;
    List<model> artistlist1;
    DatabaseReference databaseReference;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model__color__ipad);

        b1 = findViewById(R.id.btn);
        b2 = findViewById(R.id.btn1);
        b3 = findViewById(R.id.btn2);
        b4 = findViewById(R.id.btn3);
        progressBar = findViewById(R.id.pb_ipad);

        Intent i = getIntent();
        Device_Name = i.getStringExtra("device_name");
        Model_Name = i.getStringExtra("model_name");
//        Toast.makeText(this, Device_Name , Toast.LENGTH_SHORT).show();
        checkConnection();
        lv = findViewById(R.id.lv);

        artistlist1 = new ArrayList<>();

        String company = Device_Name;
        String company_model = Model_Name;
        String color = "color";
        checkConnection();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Models").child(company)
                .child(company_model);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressBar.setVisibility(View.VISIBLE);
                for (DataSnapshot artistsnap : dataSnapshot.getChildren()) {
                    model m = artistsnap.getValue(model.class);
                    b1.setText(m.getModel_color());
                    b2.setText(m.getSecond_model_color());
                    b3.setText(m.getThird_model_color());
                    b4.setText(m.getFour_model_color());

                    String b_1 = b1.getText().toString();
                    String b_2 = b2.getText().toString();
                    String b_3 = b3.getText().toString();
                    String b_4 = b4.getText().toString();

                    if (!b_1.isEmpty()) {
                        b1.setVisibility(View.VISIBLE);
                    }
                    if (!b_2.isEmpty()) {
                        b2.setVisibility(View.VISIBLE);
                    }
                    if (!b_3.isEmpty()) {
                        b3.setVisibility(View.VISIBLE);
                    }
                    if (!b_4.isEmpty()) {
                        b4.setVisibility(View.VISIBLE);
                    }

                }
                modellist adapter = new modellist(Model_Color_Ipad.this, artistlist1);
                lv.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);

                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkConnection();
                        Intent i = new Intent(getApplicationContext(), All_mobile_problem_activity.class);
                        i.putExtra("device_name", Device_Name);
                        i.putExtra("model_name", Model_Name);
                        i.putExtra("model_color", b1.getText().toString());
                        startActivity(i);
                    }
                });

                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkConnection();
                        Intent i = new Intent(getApplicationContext(), All_mobile_problem_activity.class);
                        i.putExtra("device_name", Device_Name);
                        i.putExtra("model_name", Model_Name);
                        i.putExtra("model_color", b2.getText().toString());
                        startActivity(i);
                    }
                });

                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkConnection();
                        Intent i = new Intent(getApplicationContext(), All_mobile_problem_activity.class);
                        i.putExtra("device_name", Device_Name);
                        i.putExtra("model_name", Model_Name);
                        i.putExtra("model_color", b3.getText().toString());
                        startActivity(i);
                    }
                });

                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        checkConnection();
                        Intent i = new Intent(getApplicationContext(), All_mobile_problem_activity.class);
                        i.putExtra("device_name", Device_Name);
                        i.putExtra("model_name", Model_Name);
                        i.putExtra("model_color", b4.getText().toString());
                        startActivity(i);
                    }
                });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    protected boolean checkConnection()
    {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return  true;
        } else {
            Toast.makeText(Model_Color_Ipad.this, "NO INTERNET CONNECTION...", Toast.LENGTH_LONG).show();
            return false;
        }

    }

}


