package com.huy.dialog_homework;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DucLe on 18/12/2022.
 */
public class ColorDialog extends DialogFragment {
    private RecyclerView rcvColor;
    private ColorAdapter mColorAdapter;
    private Button mBtnOk;
    private OnTransferTextListener listener;
    List<Color> list = new ArrayList<>();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnTransferTextListener) {
            listener = (OnTransferTextListener) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview_fragment, null);

        mBtnOk = view.findViewById(R.id.btnOK);

        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    int itemSelectedPos = mColorAdapter.getSelectedItemPosition();
                    if (itemSelectedPos >= 0) {
                        listener.transfer(list.get(itemSelectedPos));
                    }
                }
                dismiss();
            }
        });

        rcvColor = view.findViewById(R.id.rcv_color);
        mColorAdapter = new ColorAdapter();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getActivity(), 4);
        rcvColor.setLayoutManager(gridLayoutManager);

        list = getListColor();
        mColorAdapter.setData(list);
        rcvColor.setAdapter(mColorAdapter);

        return view;
    }


    private List<Color> getListColor() {
        List<Color> list = new ArrayList<>();

        list.add(new Color(R.color.purple_200, false));
        list.add(new Color(R.color.purple_500, false));
        list.add(new Color(R.color.purple_700, false));
        list.add(new Color(R.color.teal_200, false));
        list.add(new Color(R.color.teal_700, false));
        list.add(new Color(R.color.black, false));
        list.add(new Color(R.color.brown, false));
        list.add(new Color(R.color.yellow, false));

        list.add(new Color(R.color.purple_200, false));
        list.add(new Color(R.color.purple_500, false));
        list.add(new Color(R.color.purple_700, false));
        list.add(new Color(R.color.teal_200, false));
        list.add(new Color(R.color.teal_700, false));
        list.add(new Color(R.color.black, false));
        list.add(new Color(R.color.brown, false));
        list.add(new Color(R.color.yellow, false));

        list.add(new Color(R.color.purple_200, false));
        list.add(new Color(R.color.purple_500, false));
        list.add(new Color(R.color.purple_700, false));
        list.add(new Color(R.color.teal_200, false));
        list.add(new Color(R.color.teal_700, false));
        list.add(new Color(R.color.black, false));
        list.add(new Color(R.color.brown, false));
        list.add(new Color(R.color.yellow, false));

        list.add(new Color(R.color.purple_200, false));
        list.add(new Color(R.color.purple_500, false));
        list.add(new Color(R.color.purple_700, false));
        list.add(new Color(R.color.teal_200, false));
        list.add(new Color(R.color.teal_700, false));
        list.add(new Color(R.color.black, false));
        list.add(new Color(R.color.brown, false));
        list.add(new Color(R.color.yellow, false));


        return list;
    }

    public interface OnTransferTextListener {
        void transfer(Color color);
    }
}
