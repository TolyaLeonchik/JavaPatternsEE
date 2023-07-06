package com.patterns.frontController;

public enum URL {
    GET_INGREDIENTS("/getIngredients"),
    ADD_INGREDIENT("/addIngredient"),
    DELETE_INGREDIENT("/deleteIngredient");

    public final String url;

    URL(String url) {
        this.url = url;
    }

    public String getURL() {
        return url;
    }
}
