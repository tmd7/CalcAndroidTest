package com.tlepberghenov.marat.calcandroidtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {
    private TextView screen;
    private String display = "";
    private String mathOperator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcl);

        screen = (TextView) findViewById(R.id.textViewFirst);
        screen.setText(display);
    }

    public void updateScreen() {
        screen.setText(display);
    }

    public void onClickNumber(View v) {
        Button b = (Button) v;
        display += b.getText();
        updateScreen();
    }

    public void onClickOperator(View v) {
        Button b = (Button) v;
        display += b.getText();
        mathOperator = b.getText().toString();
        updateScreen();
    }

    public void onClickClear(View v) {
        Button b = (Button) v;
        display = "";
        mathOperator = "";
        updateScreen();
    }

    public void onClickEqual(View v) {
        double a = 0;
        double b = 0;

        String[] operation = display.split(mathOperator);
        if (operation.length < 2) return;
        System.out.println("logEqual " + operation[0]+ " " + operation[1]);

        String sTmp = "";
        char[] chArr = operation[0].toCharArray();
        if (chArr[0] == '-') {
            for (int i = 1; i < chArr.length; i++) {
                sTmp += chArr[i];
            }
            double dTmp = Double.valueOf(sTmp) * -1;
            a = dTmp;
        }

        a = Double.valueOf(operation[0]);
        b = Double.valueOf(operation[1]);

        Double result = operate(a, b, mathOperator);
        display = "";
        updateScreen();
        display = String.valueOf(result);
        updateScreen();
    }

    public void onClickPlusMinus(View v) {
        Button b = (Button) v;
        double d = Double.valueOf(screen.getText().toString()) * -1;
        display = String.valueOf(d);
        updateScreen();
    }

    public double operate(Double a, Double b, String op) {
        switch (op) {
            case "+" : return a + b;
            case "-" : return a - b;
            case "X" : return a * b;
            case "/" : try {
                return a / b;
            }catch (Exception e) {
                Log.d("Calc", e.getMessage());
            }
        }
        return -1;
    }
}
