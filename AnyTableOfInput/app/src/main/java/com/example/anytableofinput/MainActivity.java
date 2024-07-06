package com.example.anytableofinput;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button button;
    private TextView textView2;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        editText=findViewById(R.id.editText);
        button=findViewById(R.id.button);
        textView2=findViewById(R.id.textView2);

    }
    public void table(View view)
    {
        result="";
        int num=Integer.parseInt(editText.getText().toString());
        for(int i=1;i<=10;i++)
        {
            result+=num +"  x  "+i+"  =  "+num*i+"\n";
            textView2.setText(result);
        }
    }

}