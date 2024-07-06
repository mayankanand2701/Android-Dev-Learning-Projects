package com.example.sumofnum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextNumber;
    private EditText editTextNumber2;
     private TextView textView;
     private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumber=findViewById(R.id.editTextNumber);
        editTextNumber2=findViewById(R.id.editTextNumber2);
        textView=findViewById(R.id.textView);
    }
    public void calculate(View view)
    {
       int a=Integer.parseInt(editTextNumber.getText().toString());
      int b=Integer.parseInt(editTextNumber.getText().toString());
      int sum=a+b;
        textView.setText("The sum of two number is ="+sum);
    }
}