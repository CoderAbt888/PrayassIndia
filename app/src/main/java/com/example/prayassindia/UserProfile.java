package com.example.prayassindia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity {


    String  roll,name,branch,rollis,days,subjectis;
    DatabaseReference reff11;
    EditText rollno;
    TextView namete,branchte,rollte,subte,dayste;


    Button btn,enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        namete = (TextView)findViewById(R.id.name) ;
        branchte = (TextView)findViewById(R.id.branch);
        dayste = (TextView)findViewById(R.id.days);
        subte = (TextView)findViewById(R.id.subject);
        rollte = (TextView)findViewById(R.id.roll);
        btn = (Button)findViewById(R.id.pressagain);
        enter = (Button)findViewById(R.id.buton);

        rollno = (EditText)findViewById(R.id.Enterroll);

        Intent intent = getIntent();


    }

    public  void open(View v){
        roll = rollno.getText().toString();


        rollno.setVisibility(View.INVISIBLE);
        enter.setVisibility(View.INVISIBLE);
        btn.setVisibility(View.VISIBLE);
        namete.setText(name);




    }

    public void pressagain(View view){
        String hid="dkjflskdjflkjflksjdlksjlkdjlksjlkdjflksjflkjdf";

        reff11 = FirebaseDatabase.getInstance().getReference().child("member").child(roll);
        Log.i(" hid",reff11.toString());

        reff11.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                name = dataSnapshot.child("name").getValue().toString();
                branch = dataSnapshot.child("branch").getValue().toString();
                days = dataSnapshot.child("days").getValue().toString().toUpperCase();
                rollis = dataSnapshot.child("rollno").getValue().toString();
                subjectis = dataSnapshot.child("sub").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        namete.setText(name);
        branchte.setText(branch);
        dayste.setText(days);
        rollte.setText(rollis);
        subte.setText(subjectis);

        if(days!=null) {
            btn.setVisibility(View.INVISIBLE);
        }


    }


}
