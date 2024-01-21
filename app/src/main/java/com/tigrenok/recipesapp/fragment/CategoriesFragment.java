package com.tigrenok.recipesapp.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tigrenok.recipesapp.R;


public class CategoriesFragment extends Fragment {
    Context context;

    CardView breakfast, lunch, salads, soups, drinks, pastas;
    GridLayout gridLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_categories, container, false);

        gridLayout = view.findViewById(R.id.gridLayout);
        breakfast = view.findViewById(R.id.breakfast);

// Add similar onClickListeners for the other CardViews

        return view;
    }
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}