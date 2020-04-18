package com.example.moyeo;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class GraduationContentsPagerAdapter extends FragmentPagerAdapter {
    private int PageCount;
    public GraduationContentsPagerAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.PageCount = pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Graduation_info_tab1 graduationInfoTab1 = new Graduation_info_tab1();
                return graduationInfoTab1;

            case 1:
                Graduation_info_tab2 graduationInfoTab2 = new Graduation_info_tab2();
                return graduationInfoTab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PageCount;
    }
}
