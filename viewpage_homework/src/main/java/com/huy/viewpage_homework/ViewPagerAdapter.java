package com.huy.viewpage_homework;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {

    List<Fragment> fragmentList = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        fragmentList.add(new HomeFragment());
        fragmentList.add(new FavoriteFragment());
        fragmentList.add(new MyPageFragment());
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }


    public Fragment getFragment(int pos) {
        return fragmentList.get(pos);
    }
}
