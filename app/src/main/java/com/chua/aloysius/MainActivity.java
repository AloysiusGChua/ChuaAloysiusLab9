package com.chua.aloysius;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db;
    DatabaseReference points;
    EditText eFname, eLname, ePoints;
    ArrayList<String> keyList;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseDatabase.getInstance();
        points = db.getReference("points");
        eFname = findViewById(R.id.etFname);
        eLname = findViewById(R.id.etLname);
        ePoints = findViewById(R.id.etPoints);
        keyList = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        points.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ss : dataSnapshot.getChildren()){
                    keyList.add(ss.getKey());
                }
                Toast.makeText(MainActivity.this, keyList.get(0), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void addRecord (View v){
        String fname = eFname.getText().toString().trim();
        String lname = eLname.getText().toString().trim();
        Long score = Long.parseLong(ePoints.getText().toString().trim());
        String key = points.push().getKey();
        Student stud = new Student(fname, lname, score);
        points.child(key).setValue(stud);
        Toast.makeText(this, "Record Inserted...", Toast.LENGTH_LONG).show();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
