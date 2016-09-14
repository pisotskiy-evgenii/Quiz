package study.quiz.presentation.view.fragment;

import android.support.v4.app.Fragment;

import study.quiz.presentation.utils.ToastMaker;

/**
 * Base {@link Fragment} class for every fragment in this application.
 */
public abstract class BaseFragment extends Fragment {

    protected android.support.v4.app.FragmentManager fragmentManager;

    /**
     * Shows a {@link android.widget.Toast} message.
     *
     * @param message An string representing a message to be shown.
     */
    protected void showToast(String message) {
        ToastMaker.showMessage(getActivity(), message);
    }
}
