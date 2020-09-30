package com.example.firebaseassignment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
EditText et1,et2,et3,et4,et5;
Button saveButton,readButton;
DatabaseReference myref;
private ListView simpleList;
ArrayList<String> arrayList = new ArrayList<>();
ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myref = FirebaseDatabase.getInstance().getReference();
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        et1 = findViewById(R.id.et1);
        et2= findViewById(R.id.et2);
        et3= findViewById(R.id.et3);
        et4= findViewById(R.id.et4);
        et5= findViewById(R.id.et5);
        saveButton = findViewById(R.id.saveButton);
        readButton = findViewById(R.id.readButton);
        simpleList = findViewById(R.id.list1);
        simpleList.setAdapter(adapter);
        simpleList.setVisibility(View.INVISIBLE);
        myref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String string = snapshot.getValue(String.class);
                arrayList.add(string);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void writeData(View view)
    {
        String info1 = et1.getText().toString();
        String info2 = et2.getText().toString();
        String info3 = et3.getText().toString();
        String info4 = et4.getText().toString();
        String info5 = et5.getText().toString();
        Information information = new Information(info1,info2,info3,info4,info5);
        myref.setValue(information);

    }
    public void readData(View view)
    {
        simpleList.setVisibility(View.VISIBLE);
    }

}