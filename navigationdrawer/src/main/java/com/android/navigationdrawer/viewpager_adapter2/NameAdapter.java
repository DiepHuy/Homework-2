package com.android.navigationdrawer.viewpager_adapter2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * Created by DucLe on 11/12/2022.
 */
public class NameAdapter extends FragmentStateAdapter {

    public NameAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new Fragment1();
        }
        if (position == 1) {
            return new Fragment2();
        }
        if (position == 2) {
            return new Fragment3();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
