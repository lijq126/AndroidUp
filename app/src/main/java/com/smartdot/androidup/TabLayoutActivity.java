package com.smartdot.androidup;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.smartdot.androidup.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tabs);
        initViewPager();

    }

    private void initViewPager() {

        List<String> titles = new ArrayList<>();
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            titles.add("标题" + i);
            fragments.add(new ItemFragment());
        }
        for (String title : titles) {
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(fragmentAdapter);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        
    }
}
