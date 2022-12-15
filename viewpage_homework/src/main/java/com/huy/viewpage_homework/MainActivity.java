package com.huy.viewpage_homework;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity implements HomeFragment.SendDataListener {

    public static final int HOME_POSITION = 0;
    public static final int FAVORITE_POSITION = 1;
    public static final int MY_PAGE_POSITION = 2;

    private TabLayout mTabLayout;
    private ViewPager2 mViewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.content_frame_1, new HomeFragment());
//        fragmentTransaction.add(R.id.content_frame_2, new FavoriteFragment());
//        fragmentTransaction.commit();

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);

        viewPagerAdapter = new ViewPagerAdapter(this);
        mViewPager.setAdapter(viewPagerAdapter);
        new TabLayoutMediator(mTabLayout, mViewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case HOME_POSITION:
                        tab.setText("HOME");
                        tab.setIcon(R.drawable.ic_baseline_home_24);
                        break;
                    case FAVORITE_POSITION:
                        tab.setText("FAVORITE");
                        tab.setIcon(R.drawable.ic_baseline_favorite_24);
                        break;
                    case MY_PAGE_POSITION:
                        tab.setText("MY PAGE");
                        tab.setIcon(R.drawable.ic_baseline_backpack_24);
                        break;
                }

            }
        }).attach();
    }

    @Override
    public void sendData(int result) {
        FavoriteFragment favoriteFragment = (FavoriteFragment) viewPagerAdapter.getFragment(FAVORITE_POSITION);
        favoriteFragment.receiveData(result);

    }
}