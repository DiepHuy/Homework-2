package com.huy.viewpage_homework;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    private EditText mEdtA, mEdtB;
    private Button mBtnPlus;
    private SendDataListener mSendDataListener;

    public interface SendDataListener {

        void sendData(int result);

    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mSendDataListener = (SendDataListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_home, container, false);


        // Inflate the layout for this fragment
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEdtA = view.findViewById(R.id.edtA);
        mEdtB = view.findViewById(R.id.edtB);
        mBtnPlus = view.findViewById(R.id.btnPlus);

        mBtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSendDataListener != null) {
                    int result = Integer.valueOf(mEdtA.getText().toString())+Integer.valueOf(mEdtB.getText().toString());
                    mSendDataListener.sendData(result);
                }
            }
        });
    }
}
