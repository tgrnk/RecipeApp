package com.tigrenok.recipesapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.tigrenok.recipesapp.R;

import pl.droidsonroids.gif.GifImageView;

public class BreakfastFragment extends Fragment {

    GifImageView cat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_breakfast, container, false);

        cat = view.findViewById(R.id.cat);

        return view;
    }
}