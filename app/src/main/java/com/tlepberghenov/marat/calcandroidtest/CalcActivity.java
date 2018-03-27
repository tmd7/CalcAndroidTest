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
       String[] operation = display.split(mathOperator);
       if (operation.length < 2) return;
        System.out.println("log " + operation[0]+ " " + operation[1]);
       Double result = operate(operation[0], operation[1], mathOperator);
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

    public double operate(String a, String b, String op) {
        switch (op) {
            case "+" : return Double.valueOf(a) + Double.valueOf(b);
            case "-" : return Double.valueOf(a) - Double.valueOf(b);
            case "/" : return Double.valueOf(a) / Double.valueOf(b);
            case "X" : try {
                return Double.valueOf(a) * Double.valueOf(b);
            }catch (Exception e) {
                Log.d("Calc", e.getMessage());
            }
        }
        return -1;
    }
}
