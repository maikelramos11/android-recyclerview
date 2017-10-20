package com.example.kevin.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView texto;
    Button buton1;
    Button buton2;
    Button buton3;
    Button buton4;
    Button buton5;
    Button buton6;
    Button buton7;
    Button buton8;
    Button buton9;
    Button buton10;
    Button buton11;
    Button buton12;
    Button buton13;
    Button buton14;
    Button buton15;
    Button buton16;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buton1 = (Button) findViewById(R.id.button1);
        buton2 = (Button) findViewById(R.id.button2);
        buton3 = (Button) findViewById(R.id.button3);
        buton4 = (Button) findViewById(R.id.button4);
        buton5 = (Button) findViewById(R.id.button5);
        buton6 = (Button) findViewById(R.id.button6);
        buton7 = (Button) findViewById(R.id.button7);
        buton8 = (Button) findViewById(R.id.button8);
        buton9 = (Button) findViewById(R.id.button9);
        buton10 = (Button) findViewById(R.id.button10);
        buton11 = (Button) findViewById(R.id.button11);
        buton12 = (Button) findViewById(R.id.button12);
        buton13 = (Button) findViewById(R.id.button13);
        buton14 = (Button) findViewById(R.id.button14);
        buton15 = (Button) findViewById(R.id.button15);
        buton16 = (Button) findViewById(R.id.button16);
        texto = (TextView) findViewById(R.id.texto);

        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("1");
            }
        });
        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("2");
            }
        });

        buton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("3");
            }
        });

        buton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("4");
            }
        });


        buton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("5");
            }
        });

        buton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("6");
            }
        });

        buton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("7");
            }
        });
        buton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("8");
            }
        });
        buton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("9");
            }
        });
        buton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("0");
            }
        });
        buton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("+");
            }
        });

        buton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("-");
            }
        });

        buton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("X");
            }
        });

        buton14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText(".");
            }
        });
        buton15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("=");
            }
        });
        buton16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                texto.setText("/");
            }
        });


    }}

