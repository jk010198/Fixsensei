package packag.jk.com.mobileshop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class model_color extends AppCompatActivity {

    String Device_Name, Model_Name;
    Button btn_1, btn_2, btn_3, btn_4, btn_5;
    ListView lv;
    List<model> artistlist1;
    DatabaseReference databaseReference;
    ProgressBar progressBar;
    String company;
    String company_model;
    String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_color);
        btn_1 = findViewById(R.id.btn);
        btn_2 = findViewById(R.id.btn1);
        btn_3 = findViewById(R.id.btn2);
        btn_4 = findViewById(R.id.btn3);
        btn_5 = findViewById(R.id.btn4);
        progressBar = findViewById(R.id.pb);
        //  progressBar.setVisibility(View.VISIBLE);

//        // extract bundle
//        Bundle bundle = getIntent().getExtras();
//        //Extract the data…
//        Device_Name = bundle.getString("device_name");
//        Model_Name = bundle.getString("model_name");

        Intent i = getIntent();
        String s = i.getStringExtra("device_name");
        String s1 = i.getStringExtra("model_name");
//        Toast.makeText(this, s + "" + s1, Toast.LENGTH_SHORT).show();

        lv = findViewById(R.id.lv);

        artistlist1 = new ArrayList<>();
        Model_Name = s1;
        Device_Name = s;

        company = Device_Name;
        company_model = Model_Name;
        color = "color";
        new MyAsyn().execute();

                       ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                       NetworkInfo netInfo = cm.getActiveNetworkInfo();

                       if (netInfo != null && netInfo.isConnectedOrConnecting()) {

                       } else {
                           Toast.makeText(model_color.this, "NO INTERNET CONNECTION...", Toast.LENGTH_LONG).show();
                       }



        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkConnection();
                Intent i = new Intent(getApplicationContext(), Mobile_problem_iphone.class);
                i.putExtra("device_name", Device_Name);
                i.putExtra("model_name", Model_Name);
                i.putExtra("model_color", btn_1.getText().toString());
                startActivity(i);
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkConnection();
                Intent i = new Intent(getApplicationContext(), Mobile_problem_iphone.class);
                i.putExtra("device_name", Device_Name);
                i.putExtra("model_name", Model_Name);
                i.putExtra("model_color", btn_2.getText().toString());
                startActivity(i);
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkConnection();
                Intent i = new Intent(getApplicationContext(), Mobile_problem_iphone.class);
                i.putExtra("device_name", Device_Name);
                i.putExtra("model_name", Model_Name);
                i.putExtra("model_color", btn_3.getText().toString());
                startActivity(i);
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkConnection();
                Intent i = new Intent(getApplicationContext(), Mobile_problem_iphone.class);
                i.putExtra("device_name", Device_Name);
                i.putExtra("model_name", Model_Name);
                i.putExtra("model_color", btn_4.getText().toString());
                startActivity(i);
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkConnection();
                Intent i = new Intent(getApplicationContext(), Mobile_problem_iphone.class);
                i.putExtra("device_name", Device_Name);
                i.putExtra("model_name", Model_Name);
                i.putExtra("model_color", btn_5.getText().toString());
                startActivity(i);
            }
        });
    }


    class MyAsyn extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
//            Toast.makeText(model_color.this, "abcd", Toast.LENGTH_SHORT).show();
            //progressBar.setVisibility(View.VISIBLE);

                ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo netInfo = cm.getActiveNetworkInfo();

                if (netInfo != null && netInfo.isConnectedOrConnecting()) {

                } else {
                    Toast.makeText(model_color.this, "NO INTERNET CONNECTION...", Toast.LENGTH_LONG).show();
                }

        }

        @Override
        protected Void doInBackground(Void... voids) {
            databaseReference = FirebaseDatabase.getInstance().getReference().child("Models").child(company)
                    .child(company_model);

            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    progressBar.setVisibility(View.VISIBLE);
                    for (DataSnapshot artistsnap : dataSnapshot.getChildren()) {
                        model m = artistsnap.getValue(model.class);
                        btn_1.setText(m.getModel_color());
                        btn_2.setText(m.getSecond_model_color());
                        btn_3.setText(m.getThird_model_color());
                        btn_4.setText(m.getFour_model_color());
                        btn_5.setText(m.getFive_model_color());

                        String b_1 = btn_1.getText().toString();
                        String b_2 = btn_2.getText().toString();
                        String b_3 = btn_3.getText().toString();
                        String b_4 = btn_4.getText().toString();
                        String b_5 = btn_5.getText().toString();

                        if (!b_1.isEmpty()) {
                            btn_1.setVisibility(View.VISIBLE);
                        }
                        if (!b_2.isEmpty()) {
                            btn_2.setVisibility(View.VISIBLE);
                        }
                        if (!b_3.isEmpty()) {
                            btn_3.setVisibility(View.VISIBLE);
                        }
                        if (!b_4.isEmpty()) {
                            btn_4.setVisibility(View.VISIBLE);
                        }
                        if (!b_5.isEmpty()) {
                            btn_5.setVisibility(View.VISIBLE);
                        }

                        //artistlist1.add(m);
                    }

                    modellist adapter = new modellist(model_color.this, artistlist1);
                    lv.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            //progressBar.setVisibility(View.GONE);
            //super.onPostExecute(aVoid);
        }
    }
   protected void checkConnection()
    {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if (netInfo != null && netInfo.isConnectedOrConnecting()) {

        } else {
            Toast.makeText(model_color.this, "NO INTERNET CONNECTION...", Toast.LENGTH_LONG).show();
        }

    }

}
