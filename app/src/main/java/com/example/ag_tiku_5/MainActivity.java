package com.example.ag_tiku_5;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements TabLayout.BaseOnTabSelectedListener {

    private Toolbar toolbar;
    private FrameLayout frame;
    private TabLayout tab;
    private RelativeLayout rel;
    private ShouFragment shouFragment;
    private WoFragment woFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFramelayout();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        frame = (FrameLayout) findViewById(R.id.frame);
        tab = (TabLayout) findViewById(R.id.tab);
        rel = (RelativeLayout) findViewById(R.id.rel);

        toolbar.setTitle("首页");
        tab.addTab(tab.newTab().setText("首页").setIcon(R.drawable.shou));
        tab.addTab(tab.newTab().setText("我的").setIcon(R.drawable.wo));
        tab.addOnTabSelectedListener(this);

    }

    private void initFramelayout() {
        shouFragment = new ShouFragment();
        woFragment = new WoFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame,shouFragment)
                .add(R.id.frame,woFragment)
                .hide(woFragment)
                .commit();
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        switch (tab.getPosition()){
            case 0:
                getSupportFragmentManager().beginTransaction()
                    .show(shouFragment)
                        .hide(woFragment)
                        .commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction()
                        .hide(shouFragment)
                        .show(woFragment)
                        .commit();
                break;
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
