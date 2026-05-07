package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity
        implements Fragment2.OnDataSend, Fragment3.OnCheckboxChange {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new Fragment2())
                    .commit();
        }
    }


    @Override
    public void onSendData(String name) {

        Fragment3 fragment3 = new Fragment3();

        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        fragment3.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        android.R.anim.slide_in_left,   
                        android.R.anim.slide_out_right  
                )
                .replace(R.id.fragment_container, fragment3)
                .commit();
    }


    @Override
    public void onCheckChanged(boolean isChecked) {

    }
}
