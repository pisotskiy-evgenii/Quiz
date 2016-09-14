package study.quiz.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;

import study.quiz.R;
import study.quiz.presentation.view.adapter.FragmentAdapter;

public class WelcomeActivity extends BaseActivity implements View.OnClickListener {

    private static final String AUTHORIZATION = "authorization";
    private static ViewPager pager;
    private static CirclePageIndicator circleIndicator;
    private static TextView joinNow;
    private static TextView haveLogin;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //Set the pager with an adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));

        //Set the circle indicator and bind it to the adapter
        circleIndicator = (CirclePageIndicator) findViewById(R.id.circle_indicator);
        circleIndicator.setViewPager(pager);

        //Set the listener for the text Join Now
        joinNow = (TextView) findViewById(R.id.join_now);
        joinNow.setOnClickListener(this);

        //Set the listener for the text 'Have an account? Log in'
        haveLogin = (TextView) findViewById(R.id.have_login);
        haveLogin.setOnClickListener(this);

        // Set the first page for the slide screen.
        pager.setCurrentItem(0);
    }

    @Override
    public void onClick(View view) {
        Intent authorization = new Intent(this, AuthorizationActivity.class);
        authorization.putExtra(AUTHORIZATION, view.getId());
        startActivity(authorization);
    }
}
