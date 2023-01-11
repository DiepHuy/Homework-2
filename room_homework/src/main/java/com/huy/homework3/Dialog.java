package com.huy.homework3;

import static com.huy.homework3.EditActivity.USER_KEY;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.huy.homework3.data.AppDatabase;
import com.huy.homework3.data.AppExecutors;
import com.huy.homework3.data.MyDatabase;
import com.huy.homework3.data.User;

/**
 * Created by DucLe on 18/12/2022.
 */
public class Dialog extends DialogFragment {
    private Button mBtnEdit, mBtnDelete;
    private AppDatabase db;

    private User user;

    private OnUpdateListAfterDeleteListener listener;

    public static Dialog newInstance(User user) {
        Bundle args = new Bundle();
        args.putParcelable("user_key", user);
        Dialog fragment = new Dialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        db = MyDatabase.getInstance(context);
        if (context instanceof OnUpdateListAfterDeleteListener) {
            listener = (OnUpdateListAfterDeleteListener) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = getArguments().getParcelable("user_key");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        mBtnEdit = view.findViewById(R.id.btnEdit);

        mBtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), EditActivity.class);
                intent.putExtra(USER_KEY, user);
                getActivity().startActivityForResult(intent, MainActivity.EDIT_RC);
                dismiss();
            }
        });

        mBtnDelete = view.findViewById(R.id.btnDelete);

        mBtnDelete.setOnClickListener(v ->
                AppExecutors.getInstance().diskIO().execute(() -> {
                    int i = db.userDao().delete(user);
                    Log.d("xxxx", "run: " + i);
                    if (i > 0) {
                        if (listener != null) {
                            listener.updateData();
                        }
                        //showToast
                        AppExecutors.getInstance().mainThread().execute(() ->
                                Toast.makeText(getContext(), "Delete successful", Toast.LENGTH_SHORT).show());
                        dismiss();
                    }
                }));
    }

    public interface OnUpdateListAfterDeleteListener {
        void updateData();
    }
}
