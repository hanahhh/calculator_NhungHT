package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {
    TextView result;
    TextView textUp;
    private StringBuffer str = new StringBuffer("");
    private StringBuffer exp = new StringBuffer("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        textUp = findViewById(R.id.textUp);
    }

    private void updateText(String strToAdd){
        str.append(strToAdd);
        result.setText(str);
    }
    private void updateCount(String strToAdd){
        exp.append(" " + str + " " + strToAdd);
        str.delete(0, str.length());
        textUp.setText(exp);
        result.setText(str);
    }

    public void CE_BTN(View view){
        str.delete(0, str.length());
        result.setText(str);
    }
    public void C_BTN(View view){
        str.delete(0, str.length());
        exp.delete(0, exp.length());
        result.setText(str);
        textUp.setText(exp);
    }
    public void divideBTN(View view){
        updateCount("/");
    }
    public void backspaceBTN(View view){
        if(str.length() != 0){
            str.deleteCharAt(str.length() - 1);
        }
        result.setText(str);
    }
    public void sevenBTN(View view){
        updateText("7");
    }
    public void eightBTN(View view){
        updateText("8");
    }
    public void nineBTN(View view){
        updateText("9");
    }
    public void multiplyBTN(View view){
        updateCount("x");
    }
    public void fourBTN(View view){
        updateText("4");
    }
    public void fiveTBN(View view){
        updateText("5");
    }
    public void sixBTN(View view){
        updateText("6");
    }
    public void minusBTN(View view){
        updateCount("-");
    }
    public void oneBTN(View view){
        updateText("1");
    }
    public void twoBTN(View view){
        updateText("2");
    }
    public void threeBTN(View view){
        updateText("3");
    }
    public void addBTN(View view){
        updateCount("+");
    }
    public void addMinusBTN(View view){
        updateCount("+/-");
    }
    public void zeroBTN(View view){
        updateText("0");
    }
    public void pointBTN(View view){
        updateText(".");
    }
    public void equalBTN(View view){
        updateCount("");
        System.out.println(exp);
        Double resultExp = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            resultExp = (double)engine.eval(exp.toString());
        } catch (ScriptException e){
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if(resultExp != null){
            result.setText(String.valueOf(resultExp.doubleValue()));
        }
        str.delete(0, str.length());
        exp.delete(0, exp.length());
    }
}