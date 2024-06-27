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
                return new WidgetOneFragment();
            case 1:
                return new WidgetTwoFragment();
            case 2:
                return new WidgetThreeFragment();
            case 3:
                return new WidgetFourFragment();
            case 4:
                return new WidgetFiveFragment();
            case 5:
                return new WidgetSixFragment();
            // Add cases for other units
            default:
                return new PartTwoFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 6; // Number of fragments
    }
}