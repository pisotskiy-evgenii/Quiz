package study.quiz.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import study.quiz.R;

public class SignFragment extends BaseFragment {

    TextView haveLogin;
    OnTextLoginClickListener onTextLoginClickListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onTextLoginClickListener = (OnTextLoginClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnTextLoginClickListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentSignup = inflater.inflate(R.layout.fragment_signup, container, false);

        haveLogin = (TextView) fragmentSignup.findViewById(R.id.log_in);
        haveLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onTextLoginClickListener.onClickTextLogin(fragmentManager);
            }
        });

        return fragmentSignup;
    }

    public interface OnTextLoginClickListener {
        void onClickTextLogin(FragmentManager fragmentManager);
    }
}
