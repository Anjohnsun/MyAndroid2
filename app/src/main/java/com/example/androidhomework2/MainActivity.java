package com.example.androidhomework2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btn_plus, btn_minus, btn_erase, btn_equals, change_theme;
    private TextView output;
    private final int[] numberButtonIds = new int[]{R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3,
            R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9};
    private final Calculator calculator = new Calculator();

    private ThemeStorage themeStorage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themeStorage = new ThemeStorage(this);

        setTheme(themeStorage.getCurrentTheme().getRes());

        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.button_0);
        btn1 = findViewById(R.id.button_1);
        btn2 = findViewById(R.id.button_2);
        btn3 = findViewById(R.id.button_3);
        btn4 = findViewById(R.id.button_4);
        btn5 = findViewById(R.id.button_5);
        btn6 = findViewById(R.id.button_6);
        btn7 = findViewById(R.id.button_7);
        btn8 = findViewById(R.id.button_8);
        btn9 = findViewById(R.id.button_9);
        output = findViewById(R.id.output);
        btn_plus = findViewById(R.id.button_plus);
        btn_minus = findViewById(R.id.button_minus);
        btn_erase = findViewById(R.id.button_erase);
        btn_equals = findViewById(R.id.button_equals);
        change_theme = findViewById(R.id.change_theme);

    }

    @Override
    protected void onStart() {
        super.onStart();

        for (int i = 0; i < numberButtonIds.length; i++) {
            int index = i;
            findViewById(numberButtonIds[i]).setOnClickListener(v -> {
                calculator.newSimbol(index);
                output.setText(calculator.showLabel());
            });
        }


        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.newAction("-");
                output.setText(calculator.showLabel());
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.newAction("+");
                output.setText(calculator.showLabel());
            }
        });

        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.calculate();
                output.setText(calculator.showLabel());
            }
        });

        btn_erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.eraseAll();
                output.setText(calculator.showLabel());
            }
        });
        change_theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (themeStorage.getCurrentTheme().equals(Theme.OPTION_1)) {
                    themeStorage.setCurrentTheme(Theme.OPTION_2);
                } else {
                    themeStorage.setCurrentTheme((Theme.OPTION_1));
                }

                recreate();
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculator.setActions(savedInstanceState.getStringArrayList("ACTIONS"));
        calculator.setAfterEqual(savedInstanceState.getBoolean("AFTER_EQUAL"));
        calculator.setLabel(savedInstanceState.getString("LABEL"));
        calculator.setLastIsInt(savedInstanceState.getBoolean("LAST_INT"));
        calculator.setNumbers(savedInstanceState.getIntegerArrayList("NUMBERS"));
        calculator.setResult(savedInstanceState.getInt("RESULT"));
        output.setText(calculator.showLabel());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("RESULT", calculator.getResult());
        outState.putStringArrayList("ACTIONS", calculator.getActions());
        outState.putIntegerArrayList("NUMBERS", calculator.getNumbers());
        outState.putString("LABEL", calculator.getLabel());
        outState.putBoolean("AFTER_EQUAL", calculator.getIsAfterEqual());
        outState.putBoolean("LAST_INT", calculator.getIsLastIsInt());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}