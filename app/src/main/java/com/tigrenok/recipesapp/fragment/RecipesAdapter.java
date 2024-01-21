package com.tigrenok.recipesapp.fragment;

import static android.app.PendingIntent.getActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tigrenok.recipesapp.R;

import java.util.ArrayList;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.MyHolder>{

    Context context;
    ArrayList<RecipesRecycler> arrayList;
    LayoutInflater layoutInflater;

    public RecipesAdapter(Context context, ArrayList<RecipesRecycler> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recipes_item, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.recipeIngredients.setText(arrayList.get(position).getRecipeText());
        holder.recipeText.setText(arrayList.get(position).getRecipeText());
        holder.recipesTitle.setText(arrayList.get(position).getRecipesTitle());
        holder.recipesInfo.setText(arrayList.get(position).getRecipesInfo());
        holder.recipesImage.setImageResource(arrayList.get(position).getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int position = holder.getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        RecipesClicked recipesClickedFragment = new RecipesClicked();
                        Bundle bundle = new Bundle();

                        // Передача данных во второй фрагмент
                        bundle.putString("ingredients", arrayList.get(position).getRecipeIngredients());
                        bundle.putString("text", arrayList.get(position).getRecipeText());
                        bundle.putString("title", arrayList.get(position).getRecipesTitle());
                        bundle.putString("info", arrayList.get(position).getRecipesInfo());
                        bundle.putInt("image", arrayList.get(position).getImage());

                        recipesClickedFragment.setArguments(bundle);

                        FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frameLayout, recipesClickedFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView recipesTitle, recipesInfo, recipeText, recipeIngredients;
        ImageView recipesImage;
        CardView cardView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            recipeIngredients = itemView.findViewById(R.id.recipeIngredients);
            recipeText = itemView.findViewById(R.id.recipeText);
            recipesTitle = itemView.findViewById(R.id.recipesTitle);
            recipesInfo = itemView.findViewById(R.id.recipesInfo);
            recipesImage = itemView.findViewById(R.id.recipesImage);
            cardView = itemView.findViewById(R.id.card_view);
        }

    }
}
