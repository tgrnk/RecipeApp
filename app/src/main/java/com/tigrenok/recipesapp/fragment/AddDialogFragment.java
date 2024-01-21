package com.tigrenok.recipesapp.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

import com.tigrenok.recipesapp.R;

public class AddDialogFragment extends DialogFragment {
    public interface AddTextDialogListener {
        void onTextAdded(String newText);
    }

    private AddTextDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_dialog, null);

        EditText editText = view.findViewById(R.id.addText);

        builder.setView(view)
                .setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String newText = editText.getText().toString();
                        listener.onTextAdded(newText);
                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

        return builder.create();
    }

    public void setListener(AddTextDialogListener listener) {
        this.listener = listener;
    }
}
