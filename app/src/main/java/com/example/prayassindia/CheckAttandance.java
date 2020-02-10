package com.example.prayassindia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class CheckAttandance extends AppCompatActivity {
    RelativeLayout rl;
    EditText datedatee;
    Button btn8,btn9;
    String dateie,class4teacher,class5teacher,class6teacher,class7teacher;
    DatabaseReference reff1,reff12;
    TextView text14,text15,text16,text17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_attandance);

         Intent intent = getIntent();
        rl = (RelativeLayout)findViewById(R.id.allstuf);
        datedatee = (EditText)findViewById(R.id.datedate);
        btn8 = (Button)findViewById(R.id.button7);

        text14 = (TextView)findViewById(R.id.cla14);
        text15 = (TextView)findViewById(R.id.cla15);
        text16 = (TextView)findViewById(R.id.cla16);
        text17 = (TextView)findViewById(R.id.cla17);
        btn9 = (Button)findViewById(R.id.button8);

    }

    public void dateenter(View view){

        datedatee.setVisibility(View.INVISIBLE);
        btn8.setVisibility(View.INVISIBLE);
        dateie = datedatee.getText().toString();
        btn9.setVisibility(View.VISIBLE);






    }

    public void pressagain1(View view){
        rl.setVisibility(View.VISIBLE);
        reff1 = FirebaseDatabase.getInstance().getReference().child("member").child("today").child(dateie);
        reff12 = FirebaseDatabase.getInstance().getReference().child("member").child("1811001");
        Log.i("heloreff",reff1.toString());

        Log.i("heloindiais",reff12.toString());




        reff1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                class4teacher = dataSnapshot.child("class4").getValue().toString();
                class5teacher = dataSnapshot.child("class5").getValue().toString();
                class6teacher = dataSnapshot.child("class6").getValue().toString();
                class7teacher = dataSnapshot.child("class7").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        text14.setText(class4teacher);
        text15.setText(class5teacher);
        text16.setText(class6teacher);
        text17.setText(class7teacher);


    }
}
