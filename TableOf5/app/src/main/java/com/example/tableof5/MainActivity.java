package com.example.tableof5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private TextView textView10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView4);
        textView5=findViewById(R.id.textView5);
        textView6=findViewById(R.id.textView6);
        textView7=findViewById(R.id.textView7);
        textView8=findViewById(R.id.textView8);
        textView9=findViewById(R.id.textView9);
        textView10=findViewById(R.id.textView10);
        table();
    }
    public void table()
    {
       textView1.setText(" 5  X  1  =  5 ");
       textView2.setText(" 5  X  2  =  10 ");
       textView3.setText(" 5  X  3  =  15 ");
       textView4.setText(" 5  X  4  =  20 ");
       textView5.setText(" 5  X  5  =  25 ");
       textView6.setText(" 5  X  6  =  30 ");
       textView7.setText(" 5  X  7  =  35 ");
       textView8.setText(" 5  X  8  =  40 ");
       textView9.setText(" 5  X  9  =  45 ");
       textView10.setText(" 5  X  10  =  50 ");
    }
}