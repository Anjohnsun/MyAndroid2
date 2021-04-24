package com.example.androidhomework2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private TextView output;
    private Button btn_plus;
    private Button btn_minus;
    private Button btn_erase;
    private Button btn_equals;
    private Button change_theme;

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
        Calculator calculator = new Calculator();

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.newSimbol(0);
                output.setText(calculator.showLabel());
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.newSimbol(1);
                output.setText(calculator.showLabel());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.newSimbol(2);
                output.setText(calculator.showLabel());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.newSimbol(3);
                output.setText(calculator.showLabel());
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.newSimbol(4);
                output.setText(calculator.showLabel());
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.newSimbol(5);
                output.setText(calculator.showLabel());
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.newSimbol(6);
                output.setText(calculator.showLabel());
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.newSimbol(7);
                output.setText(calculator.showLabel());
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.newSimbol(8);
                output.setText(calculator.showLabel());
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.newSimbol(9);
                output.setText(calculator.showLabel());
            }
        });

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
                calculator.getResult();
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
                if (themeStorage.getCurrentTheme().equals(Theme.OPTION_1)){
                    themeStorage.setCurrentTheme(Theme.OPTION_2);
                } else {
                    themeStorage.setCurrentTheme((Theme.OPTION_1));
                }

                recreate();
            }
        });
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