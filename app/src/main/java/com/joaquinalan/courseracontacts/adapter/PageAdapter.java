package com.joaquinalan.courseracontacts.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by joaquinalan on 29/01/2017.
 */

public class PageAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentArrayList;

    public PageAdapter(FragmentManager fm, List<Fragment> fragmentArrayList) {
        super(fm);
        mFragmentArrayList = fragmentArrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentArrayList.size();
    }
}
