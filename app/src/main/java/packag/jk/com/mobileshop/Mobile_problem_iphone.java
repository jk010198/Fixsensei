package packag.jk.com.mobileshop;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Mobile_problem_iphone extends AppCompatActivity {

    String Device_Name, Model_Name, Model_Color;
    String issue, issue1;
    EditText et_issue;
    CheckBox cb_1, cb_2, cb_3, cb_4, cb_5, cb_6, cb_7, cb_8, cb_9, cb_10, cb_11, cb_12;
    DatabaseReference databaseReference;
    ProgressBar progressBar;

    boolean enable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_problem_iphone);


        progressBar = findViewById(R.id.pb_iphone_issue);
        cb_1 = findViewById(R.id.cb1);
        cb_2 = findViewById(R.id.cb2);
        cb_3 = findViewById(R.id.cb3);
        cb_4 = findViewById(R.id.cb4);
        cb_5 = findViewById(R.id.cb5);
        cb_6 = findViewById(R.id.cb6);
        cb_7 = findViewById(R.id.cb7);
        cb_8 = findViewById(R.id.cb8);
        cb_9 = findViewById(R.id.cb9);
        cb_10 = findViewById(R.id.cb10);
        cb_11 = findViewById(R.id.cb11);
        cb_12 = findViewById(R.id.cb12);
        et_issue = findViewById(R.id.et_issue_iphone);

        cb_12.setEnabled(false);


        // remove foucs
        et_issue.clearFocus();
//        et_issue.setCursorVisible(true);

        //Extract the data…
        Device_Name = getIntent().getStringExtra("device_name");
        Model_Name = getIntent().getStringExtra("model_name");
        Model_Color = getIntent().getStringExtra("model_color");

        String company = Device_Name;
        String company_model = Model_Name;
        String color = "issue";
        checkConnection();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Issue").child(company)
                .child(company_model);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressBar.setVisibility(View.VISIBLE);
                for (DataSnapshot artistsnap : dataSnapshot.getChildren()) {
                    issueModel im = artistsnap.getValue(issueModel.class);
                    cb_1.setText(im.getIssue1());
                    cb_2.setText(im.getIssue2());
                    cb_3.setText(im.getIssue3());
                    cb_4.setText(im.getIssue4());
                    cb_5.setText(im.getIssue5());
                    cb_6.setText(im.getIssue6());
                    cb_7.setText(im.getIssue7());
                    cb_8.setText(im.getIssue8());
                    cb_9.setText(im.getIssue9());
                    cb_10.setText(im.getIssue10());
                    cb_11.setText(im.getIssue11());

                    String cb1 = cb_1.getText().toString();
                    String cb2 = cb_2.getText().toString();
                    String cb3 = cb_3.getText().toString();
                    String cb4 = cb_4.getText().toString();
                    String cb5 = cb_5.getText().toString();
                    String cb6 = cb_6.getText().toString();
                    String cb7 = cb_7.getText().toString();
                    String cb8 = cb_8.getText().toString();
                    String cb9 = cb_9.getText().toString();
                    String cb10 = cb_10.getText().toString();
                    String cb11 = cb_11.getText().toString();

                    if (!cb1.isEmpty()) {
                        cb_1.setVisibility(View.VISIBLE);
                    }
                    if (!cb2.isEmpty()) {
                        cb_2.setVisibility(View.VISIBLE);
                    }
                    if (!cb3.isEmpty()) {
                        cb_3.setVisibility(View.VISIBLE);
                    }
                    if (!cb4.isEmpty()) {
                        cb_4.setVisibility(View.VISIBLE);
                    }
                    if (!cb5.isEmpty()) {
                        cb_5.setVisibility(View.VISIBLE);
                    }
                    if (!cb6.isEmpty()) {
                        cb_6.setVisibility(View.VISIBLE);
                    }
                    if (!cb7.isEmpty()) {
                        cb_7.setVisibility(View.VISIBLE);
                    }
                    if (!cb8.isEmpty()) {
                        cb_8.setVisibility(View.VISIBLE);
                    }
                    if (!cb9.isEmpty()) {
                        cb_9.setVisibility(View.VISIBLE);
                    }
                    if (!cb10.isEmpty()) {
                        cb_10.setVisibility(View.VISIBLE);
                    }
                    if (!cb11.isEmpty()) {
                        cb_11.setVisibility(View.VISIBLE);
                    }
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        et_issue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cb_12.setEnabled(true);
                if (et_issue.getText().toString().isEmpty()) {
                    cb_12.setEnabled(false);
                    cb_12.setChecked(false);
                    enable = false;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }

    public void ischecked(View view) {
        issue = "";
        //enable = false;
        if (cb_1.isChecked()) {
            enable = true;
            issue += cb_1.getText().toString() + "\n";
        }
        if (cb_2.isChecked()) {
            enable = true;
            issue += cb_2.getText().toString() + "\n";
        }
        if (cb_3.isChecked()) {
            enable = true;
            issue += cb_3.getText().toString() + "\n";
        }
        if (cb_4.isChecked()) {
            enable = true;
            issue += cb_4.getText().toString() + "\n";
        }
        if (cb_5.isChecked()) {
            enable = true;
            issue += cb_5.getText().toString() + "\n";
        }
        if (cb_6.isChecked()) {
            enable = true;
            issue += cb_6.getText().toString() + "\n";
        }
        if (cb_7.isChecked()) {
            enable = true;
            issue += cb_7.getText().toString() + "\n";
        }
        if (cb_8.isChecked()) {
            enable = true;
            issue += cb_8.getText().toString() + "\n";
        }
        if (cb_9.isChecked()) {
            enable = true;
            issue += cb_9.getText().toString() + "\n";
        }
        if (cb_10.isChecked()) {
            enable = true;
            issue += cb_10.getText().toString() + "\n";
        }
        if (cb_11.isChecked()) {
            enable = true;
            issue += cb_11.getText().toString() + "\n";
        }

        if (cb_12.isChecked()) {
            enable = true;
            issue += et_issue.getText().toString();
        }


        if (!(cb_1.isChecked() || cb_2.isChecked() || cb_3.isChecked() || cb_4.isChecked() ||
                cb_5.isChecked() || cb_6.isChecked() || cb_7.isChecked() || cb_8.isChecked() || cb_9.isChecked() || cb_10.isChecked() ||
                cb_11.isChecked() || cb_12.isChecked())) {
            enable = false;
        }
//        Toast.makeText(this, "" + issue, Toast.LENGTH_SHORT).show();
    }


    public void submit(View view) {
     if(checkConnection())
     {
        if (enable) {
            enable = true;
            Bundle b = new Bundle();
            b.putString("device_name", Device_Name);
            b.putString("model_name", Model_Name);
            b.putString("model_color", Model_Color);
            b.putString("issue", issue);
            Intent i = new Intent(getApplicationContext(), Date_time_Book1_activity.class);
            i.putExtras(b);
            startActivity(i);
        }

        }
        //startActivity(new Intent(getApplicationContext(),Date_time_Book_activity.class));
    }

    protected boolean checkConnection()
    {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                return true;
        } else {
            Toast.makeText(Mobile_problem_iphone.this, "NO INTERNET CONNECTION...", Toast.LENGTH_LONG).show();
            return false;
        }

    }
}
