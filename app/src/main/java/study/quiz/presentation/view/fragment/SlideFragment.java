package study.quiz.presentation.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import study.quiz.R;
import study.quiz.presentation.utils.Constants;

public class SlideFragment extends BaseFragment {

    private static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    private String[] infoText;
    private int pageNumber;

    public static SlideFragment newInstance(int page) {
        SlideFragment fragment = new SlideFragment();
        Bundle args = new Bundle();
        args.putInt(ARGUMENT_PAGE_NUMBER, page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments() != null ? getArguments().getInt(ARGUMENT_PAGE_NUMBER) : 1;
        infoText = getResources().getStringArray(R.array.info_about_game);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentSlide = inflater.inflate(R.layout.fragment_slide, container, false);

        TextView textPreview = (TextView) fragmentSlide.findViewById(R.id.displayText);
        textPreview.setText(infoText[pageNumber]);

        FrameLayout frameLayout = (FrameLayout) fragmentSlide.findViewById(R.id.fl_welcome);
        frameLayout.setBackgroundResource(Constants.drawableArray[pageNumber]);
        return fragmentSlide;
    }
}
