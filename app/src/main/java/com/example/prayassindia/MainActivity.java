package com.example.prayassindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.prayassindia.MESSAGE";


    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Abhay").child("prayass");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);








    }
      public void addMember(View view){
          Intent intent = new Intent(this, MemberDetails.class);

          String message = "mohan";
          intent.putExtra(EXTRA_MESSAGE, message);
          startActivity(intent);

    }

    public void yourProfile(View v){

        Intent intent = new Intent(this,UserProfile.class);

        startActivity(intent);




    }

    public void attand(View view){

        Intent intent = new Intent(this,Attandance.class);

        startActivity(intent);





    }

    public void checkAttandance(View view){
        Intent intent = new Intent (this,CheckAttandance.class);
        startActivity(intent);



    }





}
