package com.example.listviewadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
   private ListView listView;
    String arr[]={"Hi","This","is","Mayank","Anand.","Thank","You !"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        // Using built in adapter
        // ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arr);
        // listView.setAdapter(ad);

        // using our adapter
        MayankAdapter ad=new MayankAdapter(this,R.layout.mayanklayout,arr);
        listView.setAdapter(ad);

    }
}