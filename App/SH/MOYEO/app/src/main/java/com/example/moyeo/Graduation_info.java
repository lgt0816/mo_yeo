package com.example.moyeo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Graduation_info extends AppCompatActivity {

    private Context context;
    private GraduationContentsPagerAdapter graduationContentsAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.graduation_info);

        context = getApplicationContext();
        tabLayout=(TabLayout)findViewById(R.id.graduation_tab);
        tabLayout.addTab(tabLayout.newTab().setText("정보"));
        tabLayout.addTab(tabLayout.newTab().setText("Q&A"));

        viewPager = (ViewPager)findViewById(R.id.graduation_content);
        graduationContentsAdapter = new GraduationContentsPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(graduationContentsAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private View createTabView(String tabName){
        View tabView = LayoutInflater.from(context).inflate(R.layout.study_info_custom_tab,null);
        TextView txt_name=(TextView)tabView.findViewById(R.id.txt_name);
        txt_name.setText(tabName);
        return tabView;
    }
}
