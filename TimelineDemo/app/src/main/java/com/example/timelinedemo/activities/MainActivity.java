package com.example.timelinedemo.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.timelinedemo.R;
import com.example.timelinedemo.adapters.StoriesPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tbTitles)
    TabLayout tbTitles;
    @BindView(R.id.vpStories)
    ViewPager vpStories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        StoriesPagerAdapter adapter = new StoriesPagerAdapter(getSupportFragmentManager(),
                MainActivity.this);
        vpStories.setAdapter(adapter);

        tbTitles.setupWithViewPager(vpStories);
    }
}
