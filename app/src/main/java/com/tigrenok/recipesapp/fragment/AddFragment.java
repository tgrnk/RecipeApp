package com.tigrenok.recipesapp.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textview.MaterialTextView;
import com.tigrenok.recipesapp.R;

public class AddFragment extends Fragment implements AddDialogFragment.AddTextDialogListener{

    TextView addTitle;
    FloatingActionButton addBtn;

    public AddFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add, container, false);

        addTitle = view.findViewById(R.id.addTitle);
        addBtn = view.findViewById(R.id.btnAdd);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            showAddTextDialog();

            }
        });
        return view;
    }

    private void showAddTextDialog() {
        AddDialogFragment dialog = new AddDialogFragment();
        dialog.setListener(this);
        dialog.show(requireActivity().getSupportFragmentManager(), "AddDialogFragment");
    }

    @Override
    public void onTextAdded(String newText) {
        // Обновление TextView
        newText = "Название: " + addTitle;
        addTitle.setText(newText);
    }

}