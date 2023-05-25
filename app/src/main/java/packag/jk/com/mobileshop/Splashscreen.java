package packag.jk.com.mobileshop;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Splashscreen extends AppCompatActivity {

    //Thread t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);



        /// to check activity is being called by back button from Main Activity////
        Intent in= getIntent();
        boolean exitcode=in.getBooleanExtra("exit_code",false);
        if(exitcode)
        {
            finish();
            System.exit(0);
        }
        ///////////////////////////////
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(getApplicationContext(),WelcomeActivity.class);
                startActivity(intent);
            }
        }, 3500);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        finish();
        System.exit(0);
    }
}
