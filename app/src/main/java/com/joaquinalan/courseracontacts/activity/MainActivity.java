package com.joaquinalan.courseracontacts.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import com.joaquinalan.courseracontacts.R;
import com.joaquinalan.courseracontacts.adapter.PageAdapter;
import com.joaquinalan.courseracontacts.fragment.ProfileFragment;
import com.joaquinalan.courseracontacts.fragment.RecyclerViewFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tbMyActionBar = (Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(tbMyActionBar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout_main);
        mViewPager = (ViewPager) findViewById(R.id.viewpager_main);

        setupViewPager();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragmentArrayList = new ArrayList<>();

        fragmentArrayList.add(new RecyclerViewFragment());
        fragmentArrayList.add(new ProfileFragment());
        return fragmentArrayList;
    }

    private void setupViewPager() {
        mViewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), getFragments()));
        mTabLayout.setupWithViewPager(mViewPager);
        //mTabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts);
        //mTabLayout.getTabAt(1).setIcon(R.drawable.ic_profile);
    }
}
