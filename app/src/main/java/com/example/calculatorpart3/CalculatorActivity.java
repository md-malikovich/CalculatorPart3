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

    static final String NEW_TEXT_KEY = "new_text_key";
    EditText num1, num2;
    TextView c_text_view;
    Button btnAdd, btnSub, btnMulti, btnDiv, btnSave;

    public String resultText;

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
                switch (view.getId()) {

                    case R.id.btn_add:
                        Double firstNumAdd = Double.parseDouble(num1.getText().toString());
                        Double secondNumAdd = Double.parseDouble(num2.getText().toString());
                        Double add = firstNumAdd + secondNumAdd;
                        c_text_view.setText(Double.toString(add));
                        Log.d("ololo", "+");
                        break;

                    case R.id.btn_sub:
                        Double firstNumSub = Double.parseDouble(num1.getText().toString());
                        Double secondNumSub = Double.parseDouble(num2.getText().toString());
                        Double sub = firstNumSub - secondNumSub;
                        c_text_view.setText(Double.toString(sub));
                        Log.d("ololo", "-");
                        break;

                    case R.id.btn_multi:
                        Double firstNumMulti = Double.parseDouble(num1.getText().toString());
                        Double secondNumMulti = Double.parseDouble(num2.getText().toString());
                        Double multi = firstNumMulti * secondNumMulti;
                        c_text_view.setText(Double.toString(multi));
                        Log.d("ololo", "*");
                        break;

                    case R.id.btn_div:
                        Double firstNumDiv = Double.parseDouble(num1.getText().toString());
                        Double secondNumDiv = Double.parseDouble(num2.getText().toString());
                        Double div = firstNumDiv / secondNumDiv;
                        c_text_view.setText(Double.toString(div));
                        Log.d("ololo", "/");
                        break;

                    case R.id.btn_save:
                        Intent intent = new Intent();
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


/*

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Double firstNum = Double.parseDouble(num1.getText().toString());
                final Double secondNum = Double.parseDouble(num2.getText().toString());
                Double addition;
                addition = firstNum + secondNum;
                c_text_view.setText(Double.toString(addition));
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Double firstNum = Double.parseDouble(num1.getText().toString());
                final Double secondNum = Double.parseDouble(num2.getText().toString());
                Double addition;
                addition = firstNum - secondNum;
                c_text_view.setText(Double.toString(addition));
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Double firstNum = Double.parseDouble(num1.getText().toString());
                final Double secondNum = Double.parseDouble(num2.getText().toString());
                Double addition;
                addition = firstNum * secondNum;
                c_text_view.setText(Double.toString(addition));
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Double firstNum = Double.parseDouble(num1.getText().toString());
                final Double secondNum = Double.parseDouble(num2.getText().toString());
                Double addition;
                addition = firstNum / secondNum;
                c_text_view.setText(Double.toString(addition));
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                resultText = c_text_view.getText().toString();
                intent.putExtra(NEW_TEXT_KEY, resultText);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

 */