package com.huy.viewpage_homework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FavoriteFragment extends Fragment {
    private TextView mtvResult;
    private int result;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_favorite, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mtvResult = view.findViewById(R.id.tvResult);
    }

    public void receiveData(int result) {
        this.result = result;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (result != 0){
            mtvResult.setText(String.valueOf(result));
        }
    }
}
