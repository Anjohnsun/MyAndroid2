package com.example.androidhomework2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

public class ThemeMenuActivity extends AppCompatActivity {
    private static final String RESULT_KEY = "RESULT";
    private int RESULT = 0;
    private Button light_theme;
    private Button dark_theme;
    private Button to_calc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_menu);

        light_theme = findViewById(R.id.btn_light_theme);
        dark_theme = findViewById(R.id.btn_dark_theme);
        to_calc = findViewById(R.id.to_calc);

        to_calc.setOnClickListener(v -> {
            finish();
        });
        ThemeStorage themeStorage = new ThemeStorage(this);
        setResult(RESULT);
        setTheme(themeStorage.getCurrentTheme().getRes());
    }

    @Override
    protected void onStart() {
        super.onStart();
        ThemeStorage themeStorage = new ThemeStorage(this);
        light_theme.setOnClickListener(v -> {
            themeStorage.setCurrentTheme(Theme.OPTION_1);
            RESULT = -1;
            recreate();

        });
        dark_theme.setOnClickListener(v -> {
            themeStorage.setCurrentTheme(Theme.OPTION_2);
            RESULT = 0;
            recreate();
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(RESULT_KEY, RESULT);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        RESULT = savedInstanceState.getInt(RESULT_KEY);
        setResult(RESULT);
    }
}