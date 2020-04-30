package com.example.realcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;

import java.net.ConnectException;

public class MainActivity extends AppCompatActivity {
    Button addorsub, brackets, percentage, divide, number7,number8, number9, multiplication, number6, number5 , number4, substraction , number3, number2,number1, addition, clear,number0, dot, equal;
    TextView data, output;
    String process;
    Boolean checkbracket = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number0 = findViewById(R.id.number0);
        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        number4 = findViewById(R.id.number4);
        number5 = findViewById(R.id.number5);
        number6 = findViewById(R.id.number6);
        number7 = findViewById(R.id.number7);
        number8 = findViewById(R.id.number8);
        number9 = findViewById(R.id.number9);
        addition = findViewById(R.id.addition);
        addorsub = findViewById(R.id.addorsub);
        substraction = findViewById(R.id.substraction);
        brackets = findViewById(R.id.brackets);
        percentage = findViewById(R.id.percentage) ;
        divide = findViewById(R.id.divison);
        multiplication = findViewById(R.id.multiplication);
        clear = findViewById(R.id.clear);
        dot = findViewById(R.id.dot);
        equal = findViewById(R.id.equal);


        data = findViewById(R.id.data);
        output = findViewById(R.id.output);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.setText("");
                output.setText("");
            }
        });

        number0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process + "0");

            }
        });

        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process + "1");

            }
        });

        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process + "2");

            }
        });

        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process + "3");

            }
        });

        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process + "4");

            }
        });
        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process + "5");

            }
        });

        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process + "6");

            }
        });

        number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process + "7");

            }
        });

        number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process + "8");

            }
        });

        number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process + "9");

            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process + "+");

            }
        });

        substraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process + "-");

            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process + "/");

            }
        });

        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process + "x");

            }
        });

        addorsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process + "+/_");

            }
        });

        brackets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkbracket){
                    process = data.getText().toString();
                    data.setText(process + ")");
                    checkbracket = true;


                }else {
                    process = data.getText().toString();
                    data.setText(process + "(");
                    checkbracket =false;

                }
            }
        });

        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process + "%");

            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                data.setText(process + ".");

            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            private Object Scope;

            @Override
            public void onClick(View v) {
                process = data.getText().toString();
                process = process.replaceAll("x" ,"*");
                process = process.replaceAll("%" , "/100");

                Context rhino = Context .enter();

                rhino.setOptimizationLevel(-1);

                String finalResult ="";

                try {
                    Scriptable scriptable =rhino.initSafeStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                }catch (Exception e) {
                    finalResult="0";
                }

                output.setText(finalResult);

            }
        });


    }
}
