package com.example.androidhomework2;

public enum Theme {
    OPTION_1("option_1", R.style.Theme_AndroidHomework2),
    OPTION_2("option_2", R.style.Theme_AndroidHomework2_2);

    private final String key;
    private final int res;

    Theme(String key, int res){
        this.key = key;
        this.res = res;
    }

    public String getKey() {
        return key;
    }

    public int getRes() {
        return res;
    }
}
