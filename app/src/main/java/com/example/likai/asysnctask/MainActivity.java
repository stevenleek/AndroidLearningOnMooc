package com.example.likai.asysnctask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Asystask task = new Asystask();
        task.execute();
    }
    public void imageLoad(View view){
        startActivity(new Intent(this, ImageTest.class));
    }
}
