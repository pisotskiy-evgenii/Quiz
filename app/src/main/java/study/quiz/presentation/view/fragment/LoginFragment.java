package study.quiz.presentation.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import study.quiz.R;
import study.quiz.presentation.view.activity.AuthorizationActivity;
import study.quiz.presentation.view.activity.MainActivity;

public class LoginFragment extends BaseFragment {

    AuthorizationActivity authorizationActivity;
    private LoginButton loginButtonFacebook;
    //callback manager will handle the login responses
    private CallbackManager callbackManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentLogin = inflater.inflate(R.layout.fragment_login, container, false);
        loginButtonFacebook = (LoginButton) fragmentLogin.findViewById(R.id.login_button_facebook);
        loginButtonFacebook.setReadPermissions("email");
        loginButtonFacebook.setFragment(this);

        // Register a callback function with LoginButton to respond to the login result
        loginButtonFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                getUserInfo(loginResult);
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
        return fragmentLogin;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        authorizationActivity = (AuthorizationActivity) context;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    //To get the facebook user's own profile information via  creating a new request.<br />
    //When the request is completed, a callback is called to handle the success condition.<br />

    protected void getUserInfo(LoginResult login_result) {
        GraphRequest data_request = GraphRequest.newMeRequest(
                login_result.getAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject jsonObject,
                            GraphResponse response) {
                        Intent mainPage = new Intent(authorizationActivity, MainActivity.class);
                        mainPage.putExtra("jsondata", jsonObject.toString());
                        startActivity(mainPage);
                    }
                });
        Bundle permission_param = new Bundle();
        permission_param.putString("fields", "id, name, email, picture.width(72).height(72)");
        data_request.setParameters(permission_param);
        data_request.executeAsync();
    }
}
