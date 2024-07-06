package com.example.knowledgehub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void openAcivity(View view)
    {
        Intent intent=new Intent(this,MainActivity2.class);
        button=findViewById(R.id.button);
        startActivity(intent);
    }
}