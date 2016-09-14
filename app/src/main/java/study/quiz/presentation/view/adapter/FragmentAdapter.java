package study.quiz.presentation.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import study.quiz.presentation.view.fragment.SlideFragment;

public class FragmentAdapter extends FragmentPagerAdapter {

    private static final int PAGE_COUNT = 3;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * @return Return the number of pages available for slide
     */
    @Override
    public int getCount() {
        return (PAGE_COUNT);
    }

    /**
     * Return the page associated with a specified position.
     */
    @Override
    public Fragment getItem(int position) {
        return SlideFragment.newInstance(position);
    }
}
