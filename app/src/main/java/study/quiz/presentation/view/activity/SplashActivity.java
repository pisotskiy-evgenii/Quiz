package study.quiz.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import study.quiz.R;

public class SplashActivity extends BaseActivity {

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Delay appearing preview screen for two seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*
                * Some work like authenticating, downloading or something else could be done here
                */
                Intent welcome = new Intent(SplashActivity.this, WelcomeActivity.class);
                startActivity(welcome);
                finish();
            }
        }, 2000);
    }
}
