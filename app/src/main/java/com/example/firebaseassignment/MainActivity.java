package com.example.firebaseassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button bMobile,bElectronics,bHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bElectronics=findViewById(R.id.button3);
        bHome = findViewById(R.id.button2);
        bMobile= findViewById(R.id.button1);
    }
    public void click(View view)
    {
        Intent i = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(i);
    }

}