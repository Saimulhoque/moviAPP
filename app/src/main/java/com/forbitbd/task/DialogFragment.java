package com.forbitbd.task;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class DialogFragment extends androidx.fragment.app.DialogFragment implements View.OnClickListener {

    Button btnok;

    public DialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.fragment_dialog, null);

        btnok = view.findViewById(R.id.btnok);
        btnok.setOnClickListener(this);

        AlertDialog alertDialog = new AlertDialog.Builder(getContext(),R.style.Theme_AppCompat_Dialog_Alert).create();
        alertDialog.setView(view);
        return alertDialog;
    }

    @Override
    public void onClick(View v) {
        if (v==btnok){
            dismiss();
            getActivity().finish();
        }
    }

}

