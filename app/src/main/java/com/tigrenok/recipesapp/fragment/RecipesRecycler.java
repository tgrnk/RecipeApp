package com.tigrenok.recipesapp.fragment;

public class RecipesRecycler {
    String recipesTitle, recipesInfo, recipeText, recipeIngredients;
    int image;

    public String getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(String recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public String getRecipeText() {
        return recipeText;
    }

    public void setRecipeText(String recipeText) {
        this.recipeText = recipeText;
    }

    public String getRecipesTitle() {
        return recipesTitle;
    }

    public void setRecipesTitle(String recipesTitle) {
        this.recipesTitle = recipesTitle;
    }

    public String getRecipesInfo() {
        return recipesInfo;
    }

    public void setRecipesInfo(String recipesInfo) {
        this.recipesInfo = recipesInfo;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


}
