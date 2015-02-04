package com.example.willyg.app0129_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.example.bmi_2.MESSAGE";

    TextView name, height, weight;
    EditText entername, enterheight, enterweight;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.textView);
        height = (TextView) findViewById(R.id.textView2);
        weight = (TextView) findViewById(R.id.textView3);
        entername = (EditText) findViewById(R.id.editText);
        enterheight = (EditText) findViewById(R.id.editText2);
        enterweight = (EditText) findViewById(R.id.editText3);
        button = (Button) findViewById(R.id.button);
    }

    public void clac(View view) {
        String aa = entername.getText().toString();
        String bb = enterheight.getText().toString();
        String cc = enterweight.getText().toString();
        double height = Double.parseDouble(enterheight.getText().toString()) / 100;
        double width = Double.parseDouble(enterweight.getText().toString());

        double BMI = width / (height * height);

        Intent intent = new Intent(this, showbmi.class);
        String sendbmi = ("Name:" + aa + "\n" + "height(cm):" + bb + "\n" + "weight(kg):" + cc
                + "\n" + "BMI:" + BMI);
        intent.putExtra(EXTRA_MESSAGE, sendbmi);
        startActivity(intent);
    }
}

