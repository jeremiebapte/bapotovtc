package com.bapoto.vtc.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bapoto.bapoto.R;


public class AllReservationFragment extends Fragment {



    public AllReservationFragment() {
        // Required empty public constructor
    }

   public static AllReservationFragment newInstance() {
        return (new AllReservationFragment());
   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_reservation, container, false);
    }
}