package com.example.assignment.UnitTwo;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.assignment.UnitThree.Part1Fragment;
import com.example.assignment.UnitThree.Part2Fragment;
import com.example.assignment.UnitThree.Part3Fragment;
import com.example.assignment.UnitThree.Part4Fragment;
import com.example.assignment.UnitThree.Part5Fragment;
import com.example.assignment.UnitThree.Part6Fragment;
import com.example.assignment.UnitThree.Part7Fragment;

public class UnitTwoViewPagerAdapter extends FragmentStateAdapter {

    public UnitTwoViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new unitTwoP1Fragment();
            case 1:
                return new unitTwoP2Fragment();
            case 2:
                return new unitTwoP3Fragment();
            default:
                return new Part1Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Number of fragments
    }
}

