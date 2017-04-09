package com.example.timelinedemo.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.timelinedemo.R;
import com.example.timelinedemo.fragments.FriendsStoriesListFragment;
import com.example.timelinedemo.fragments.MyStoriesListFragment;

public class StoriesPagerAdapter extends FragmentPagerAdapter {
    private final String tabTitles[] = new String[]{"My Stories", "Friends Stories"};
    private final int[] tabIcons = {R.drawable.ic_my_stories_state, R.drawable.ic_friends_stories_state};

    public StoriesPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return MyStoriesListFragment.newInstance();
            case 1:
                return FriendsStoriesListFragment.newInstance();
        }

        return null;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "";
    }

    public int getTabIcon(int position) {
        return tabIcons[position];
    }
}
