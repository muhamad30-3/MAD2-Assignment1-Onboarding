package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment3 extends Fragment {

    TextView tvName;
    CheckBox checkBox;
    Button btnFinish;

    OnCheckboxChange checkboxChange;

    // Interface (مطلوب في الأسايمنت)
    public interface OnCheckboxChange {
        void onCheckChanged(boolean isChecked);
    }

    public Fragment3() {
        // Required empty constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        checkboxChange = (OnCheckboxChange) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_3, container, false);

        // ربط العناصر
        tvName = view.findViewById(R.id.tvName);
        checkBox = view.findViewById(R.id.checkBox);
        btnFinish = view.findViewById(R.id.btnFinish);

        // عرض الاسم القادم من Fragment2
        if (getArguments() != null) {
            String name = getArguments().getString("name");
            tvName.setText("Welcome " + name);
        }

        // الزر بالبداية disabled
        btnFinish.setEnabled(false);

        // التحكم بالـ CheckBox
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {

            // إرسال الحالة للـ Activity
            checkboxChange.onCheckChanged(isChecked);

            if (isChecked) {
                btnFinish.setEnabled(true);
                btnFinish.setText("Finish");
            } else {
                btnFinish.setEnabled(false);
                btnFinish.setText("Continue");
            }
        });

        // عند الضغط على Finish
        btnFinish.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Finished ✅", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}