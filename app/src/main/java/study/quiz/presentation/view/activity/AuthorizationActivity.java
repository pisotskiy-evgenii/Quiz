package study.quiz.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.facebook.FacebookSdk;

import study.quiz.R;
import study.quiz.presentation.view.fragment.LoginFragment;
import study.quiz.presentation.view.fragment.SignFragment;

public class AuthorizationActivity extends BaseActivity implements SignFragment.OnTextLoginClickListener {

    private LoginFragment loginFragment;
    private SignFragment singupFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //The Facebook SDK needs to be initialized before using any of its methods.
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_authorization);

        loginFragment = new LoginFragment();
        singupFragment = new SignFragment();

        Intent intent = getIntent();
        int idButtonAuth = intent.getIntExtra("authorization", -1);
        switch (idButtonAuth) {
            case R.id.join_now:
                addFragment(R.id.fl_authorization_activity, singupFragment);
                break;
            case R.id.have_login:
                addFragment(R.id.fl_authorization_activity, loginFragment);
                break;
        }
    }

    @Override
    public void onClickTextLogin(FragmentManager fragmentManager) {
        replaceFragment(fragmentManager, loginFragment, R.id.fl_authorization_activity);
    }
}
