package com.cucc.ccalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private List<String> text = new ArrayList<>();
    private int[] number = new int[16];
    private String finalString = "";
    private int result = 0;
    private String temp = "";
    private int[] operations = new int[15];
    private static int i = 0, j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button click0 = (Button)findViewById(R.id.button17);
        Button click1 = (Button)findViewById(R.id.button11);
        Button click2 = (Button)findViewById(R.id.button12);
        Button click3 = (Button)findViewById(R.id.button13);
        Button click4 = (Button)findViewById(R.id.button6);
        Button click5 = (Button)findViewById(R.id.button7);
        Button click6 = (Button)findViewById(R.id.button8);
        Button click7 = (Button)findViewById(R.id.button2);
        Button click8 = (Button)findViewById(R.id.button3);
        Button click9 = (Button)findViewById(R.id.button4);
        Button clickAddition = (Button)findViewById(R.id.button5);
        Button clickSubs = (Button)findViewById(R.id.button9);
        Button clickMultiply = (Button)findViewById(R.id.button14);
        Button clickDivision = (Button)findViewById(R.id.button18);
        Button clickEquals = (Button)findViewById(R.id.button19);
        Button clickClear = (Button)findViewById(R.id.button15);

        click0.setOnClickListener(this);
        click1.setOnClickListener(this);
        click2.setOnClickListener(this);
        click3.setOnClickListener(this);
        click4.setOnClickListener(this);
        click5.setOnClickListener(this);
        click6.setOnClickListener(this);
        click7.setOnClickListener(this);
        click8.setOnClickListener(this);
        click9.setOnClickListener(this);
        clickAddition.setOnClickListener(this);
        clickSubs.setOnClickListener(this);
        clickMultiply.setOnClickListener(this);
        clickDivision.setOnClickListener(this);
        clickEquals.setOnClickListener(this);
        clickClear.setOnClickListener(this);

    }


    public void onClick(View v){

        TextView tv = (TextView)findViewById(R.id.textView);

        switch (v.getId()){

            case R.id.button17: {
                insertInput("0");
                createString();
                tv.setText(finalString);
                break;
            }
            case R.id.button11: {
                insertInput("1");
                createString();
                tv.setText(finalString);
                break;
            }
            case R.id.button12: {
                insertInput("2");
                createString();
                tv.setText(finalString);
                break;
            }
            case R.id.button13: {
                insertInput("3");
                createString();
                tv.setText(finalString);
                break;
            }
            case R.id.button6: {
                insertInput("4");
                createString();
                tv.setText(finalString);
                break;
            }
            case R.id.button7: {
                insertInput("5");
                createString();
                tv.setText(finalString);
                break;
            }
            case R.id.button8: {
                insertInput("6");
                createString();
                tv.setText(finalString);
                break;
            }
            case R.id.button2: {
                insertInput("7");
                createString();
                tv.setText(finalString);
                break;
            }
            case R.id.button3: {
                insertInput("8");
                createString();
                tv.setText(finalString);
                break;
            }
            case R.id.button4: {
                insertInput("9");
                createString();
                tv.setText(finalString);
                break;
            }
            case R.id.button5: {
                insertInput("+");
                createString();
                number[j] = Integer.parseInt(temp);
                j++;
                temp = "";
                tv.setText(finalString);
                operations[i] = 1;
                i++;
                break;
            }
            case R.id.button9: {
                insertInput("-");
                createString();
                number[j] = Integer.parseInt(temp);
                j++;
                temp = "";
                operations[i] = 2;
                i++;
                tv.setText(finalString);
                break;
            }
            case R.id.button14: {
                insertInput("*");
                createString();
                number[j] = Integer.parseInt(temp);
                j++;
                temp = "";
                operations[i] = 3;
                i++;
                tv.setText(finalString);
                break;
            }
            case R.id.button18: {
                insertInput("/");
                createString();
                number[j] = Integer.parseInt(temp);
                j++;
                temp = "";
                operations[i] = 4;
                i++;
                tv.setText(finalString);
                break;
            }
            case R.id.button19: {
                text.clear();
                readOperations(operations);
                temp = "";
                finalString = Integer.toString(result);
                tv.setText(finalString);
                break;
            }
            case R.id.button15: {
                finalString = "0";
                text.clear();
                tv.setText(finalString);
            }

        }

    }

    private void insertInput(String s){

        Log.d("test", "Text : " + s);

        if(TextUtils.isDigitsOnly(s)){
            temp = temp + s;
            text.add(s);
        } else text.add(s);


    }

    private void createString(){
        for(String st : text) {
            finalString = String.join("", text);
        }
    }

    private void readOperations(int[] j){

        int resultSet = 0, numarator = 0;

        for(int k : j){


            switch (k){

                case 1: {
                    resultSet = j[numarator] + j[numarator+1];
                    numarator++;
                    break;
                }
                case 2: {
                    resultSet = j[numarator] - j[numarator+1];
                    numarator++;
                    break;
                }
                case 3: {
                    resultSet = j[numarator] * j[numarator + 1];
                    numarator++;
                    break;
                }
                case 4: {
                    resultSet = j[numarator] + j[numarator+1];
                    numarator++;
                    break;
                }

            }

            result = result + resultSet;

            numarator++;

        }

    }


}
