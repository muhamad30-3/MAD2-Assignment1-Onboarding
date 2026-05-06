package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment2 extends Fragment {

    EditText etName, etEmail;
    Button btnContinue;

    OnDataSend dataSend;


    public interface OnDataSend {
        void onSendData(String name);
    }

    public Fragment2() {
        // Required empty constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataSend = (OnDataSend) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_2, container, false);


        etName = view.findViewById(R.id.etName);
        etEmail = view.findViewById(R.id.etEmail);
        btnContinue = view.findViewById(R.id.btnContinue);


        btnContinue.setOnClickListener(v -> {
            String name = etName.getText().toString();


            dataSend.onSendData(name);
        });

        return view;
    }
}