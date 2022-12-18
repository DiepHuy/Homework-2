package com.dl.dialog_example;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.DialogFragment;

/**
 * Created by DucLe on 18/12/2022.
 */
public class CustomDialog extends DialogFragment {
    private static final String KEY = "old_text";
    private OnTransferTextListener listener;

    private String oldText;

    public static CustomDialog newInstance(String oldText) {
        Bundle args = new Bundle();
        args.putString(KEY, oldText);
        CustomDialog fragment = new CustomDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnTransferTextListener) {
            listener = (OnTransferTextListener) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        oldText = getArguments().getString(KEY);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_custom, null);

        AppCompatEditText editText = view.findViewById(R.id.edt);
        AppCompatButton button = view.findViewById(R.id.btnOK);
        AppCompatTextView tvOldText = view.findViewById(R.id.tvOldText);
        tvOldText.setText("Old text: " + oldText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.transfer(editText.getText().toString());
                }
                dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setView(view);

        return builder.create();
    }

    public interface OnTransferTextListener {
        void transfer(String text);
    }
}
