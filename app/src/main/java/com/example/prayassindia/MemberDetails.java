package com.example.prayassindia;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MemberDetails extends AppCompatActivity {

    String baki;


    EditText name,branch,rollno,days,subject;

    Member member;

    DatabaseReference reff;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_details);

        member = new Member();

        name = (EditText)findViewById(R.id.textView);
        branch = (EditText)findViewById(R.id.textView1);
        rollno = (EditText)findViewById(R.id.rollno);
        days = (EditText)findViewById(R.id.daysalloted);
        subject = (EditText)findViewById(R.id.subject);













        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

    }

    public void changevisiblity(View v){
        baki = (rollno.getText().toString());
        member.setRollno( baki);
        member.setBranch(branch.getText().toString());
        member.setDays(days.getText().toString());
        member.setSub(subject.getText().toString());
        member.setName(name.getText().toString());



        reff = FirebaseDatabase.getInstance().getReference().child("member");
        reff.child(baki).setValue(member);
        branch.setText("");
        days.setText("");
        name.setText("");
        subject.setText("");
        rollno.setText("");
        Toast.makeText(getApplicationContext(),"Submited Successfull",Toast.LENGTH_LONG);







    }


}
