package com.example.assignment.widget;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.assignment.UnitOne.PartOneFragment;
import com.example.assignment.UnitOne.PartThreeFragment;
import com.example.assignment.UnitOne.PartTwoFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new PartOneFragment();
            case 1:
                return new PartTwoFragment();
            case 2:
                return new PartThreeFragment();
            // Add cases for other units
            default:
                return new PartTwoFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Number of fragments
    }
}