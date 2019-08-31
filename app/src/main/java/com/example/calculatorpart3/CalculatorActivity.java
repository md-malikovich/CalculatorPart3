package com.example.calculatorpart3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    Double firstNum = 0.0;
    Double secondNum = 0.0;
    Double result = 0.0;

    static final String NEW_TEXT_KEY = "new_text_key";
    EditText num1, num2;
    TextView c_text_view;
    Button btnAdd, btnSub, btnMulti, btnDiv, btnSave;

    public String resultText;
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        c_text_view = findViewById(R.id.c_text_view);

        btnAdd = findViewById(R.id.btn_add);
        btnSub = findViewById(R.id.btn_sub);
        btnMulti = findViewById(R.id.btn_multi);
        btnDiv = findViewById(R.id.btn_div);
        btnSave = findViewById(R.id.btn_save);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firstNum = Double.parseDouble(num1.getText().toString());
                secondNum = Double.parseDouble(num2.getText().toString());

                switch (view.getId()) {

                    case R.id.btn_add:
                        operator = "+";
                        result = firstNum + secondNum;
                        c_text_view.setText(Double.toString(result));
                        Log.d("ololo", "+");
                        break;

                    case R.id.btn_sub:
                        operator = "-";
                        result = firstNum - secondNum;
                        c_text_view.setText(Double.toString(result));
                        Log.d("ololo", "-");
                        break;

                    case R.id.btn_multi:
                        operator = "*";
                        result = firstNum * secondNum;
                        c_text_view.setText(Double.toString(result));
                        Log.d("ololo", "*");
                        break;

                    case R.id.btn_div:
                        operator = "/";
                        result = firstNum / secondNum;
                        c_text_view.setText(Double.toString(result));
                        Log.d("ololo", "/");
                        break;

                    case R.id.btn_save:
                        Intent intent = new Intent();
                        c_text_view.setText(firstNum + " " + operator + " " + secondNum + " = " + result);
                        resultText = c_text_view.getText().toString();
                        intent.putExtra(NEW_TEXT_KEY, resultText);
                        setResult(RESULT_OK, intent);
                        finish();
                        break;
                }
            }
        };
        btnAdd.setOnClickListener(onClickListener);
        btnSub.setOnClickListener(onClickListener);
        btnMulti.setOnClickListener(onClickListener);
        btnDiv.setOnClickListener(onClickListener);
        btnSave.setOnClickListener(onClickListener);
    }
}