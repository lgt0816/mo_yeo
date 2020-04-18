package com.example.moyeo;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ContentsPagerAdapter extends FragmentPagerAdapter {
    private int mPageCount;

    public ContentsPagerAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount=pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Study_info_tab1 studyInfoTab1 = new Study_info_tab1();
                return studyInfoTab1;
            case 1:
                Study_info_tab2 studyInfoTab2 = new Study_info_tab2();
                return studyInfoTab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
