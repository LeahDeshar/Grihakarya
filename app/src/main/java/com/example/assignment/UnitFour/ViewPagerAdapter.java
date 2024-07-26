package com.example.assignment.UnitFour;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;



public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FourPartOneFragment();
            case 1:
                return new FourPartTwoFragment();
            case 2:
                return new FourPartThreeFragment();
            // Add cases for other units
            default:
                return new FourPartThreeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Number of fragments
    }
}