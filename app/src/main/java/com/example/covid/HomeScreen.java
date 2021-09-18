package com.example.covid;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeScreen extends Fragment {

    LinearLayout knowMore, covidHelp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_screen, container, false);

        covidHelp = view.findViewById(R.id.covid_help);
        knowMore = view.findViewById(R.id.know_more);

        Dialog dialog = new Dialog(getContext());

        covidHelp.setOnClickListener(v -> {
            dialog.setContentView(R.layout.helpline_dialoge);
            dialog.show();
        });

        knowMore.setOnClickListener(v -> {
            dialog.setContentView(R.layout.state_helpline);
            dialog.show();
        });

        return view;
    }
}