package com.tigrenok.recipesapp.fragment;

import static android.content.Intent.getIntent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tigrenok.recipesapp.R;

public class RecipesClicked extends Fragment {

    TextView title, info, text, ingredients;
    ImageView image;

    public RecipesClicked() {
        // Пустой конструктор обязателен
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Надуваем макет для этого фрагмента
        View view = inflater.inflate(R.layout.fragment_recipes_clicked, container, false);

        ingredients = view.findViewById(R.id.recipeIngredients);
        text = view.findViewById(R.id.recipeText);
        title = view.findViewById(R.id.recipesTitle);
        info = view.findViewById(R.id.recipesInfo);
        image = view.findViewById(R.id.recipesImage);

        // Получение переданных данных из аргументов
        Bundle args = getArguments();
        if (args != null) {
            String recIng = args.getString("ingredients", "");
            String recText = args.getString("text", "");
            String titleText = args.getString("title", "");
            String infoText = args.getString("info", "");
            int imageInt = args.getInt("image", 0);

            // Установка данных в соответствующие элементы
            ingredients.setText(recIng);
            text.setText(recText);
            title.setText(titleText);
            info.setText(infoText);
            image.setImageResource(imageInt);
        }

        return view;
    }
}

