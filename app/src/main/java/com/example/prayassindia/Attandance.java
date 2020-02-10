package com.example.prayassindia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Attandance extends AppCompatActivity {

    TextView cla4,cla5,cla6,cla7;
    String class4sir,class5sir,class6sir,class7sir,daytoday,datetoday;
    String atclas4,atclas5,atclas6,atclas7;
    CheckBox ch4,ch5,ch6,ch7;
    String s4,s5,s6,s7;
    Button btn3,btn4;
    EditText day4,date;
    Attandancee attandance;

    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attandance);

        Intent intent = getIntent();
        cla4 = (TextView)findViewById(R.id.cla4);
        cla5 = (TextView)findViewById(R.id.cla5);
        cla6 = (TextView)findViewById(R.id.cla6);
        cla7 = (TextView)findViewById(R.id.cla7);
        day4 = (EditText)findViewById(R.id.daytoday);
        date = (EditText)findViewById(R.id.date);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        ch4 = (CheckBox)findViewById(R.id.clas4);
        ch5 = (CheckBox)findViewById(R.id.clas5);
        ch6 = (CheckBox)findViewById(R.id.clas6);
        ch7 = (CheckBox)findViewById(R.id.clas7);
        atclas4="absent";
        atclas5 ="absent";
        atclas6 = "absent";
        atclas7 = "absent";
        attandance = new Attandancee();


    }

    public  void today(View view){

        daytoday = day4.getText().toString();
        reff = FirebaseDatabase.getInstance().getReference().child("member").child("att").child(daytoday);

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

//                name = dataSnapshot.child("name").getValue().toString();
                class4sir = dataSnapshot.child("4").getValue().toString();
                class5sir = dataSnapshot.child("5").getValue().toString();
                class6sir = dataSnapshot.child("6").getValue().toString();
                class7sir = dataSnapshot.child("7").getValue().toString();



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        cla4.setText(class4sir);
        cla5.setText(class5sir);
        cla6.setText(class6sir);
        cla7.setText(class7sir);
        btn3.setText("Press Again");





    }

    public void  onCheckboxClicked(View view){

        Boolean checked = ((CheckBox) view).isChecked();
      //  Log.i("boolean",checked);


        switch(view.getId()) {
            case R.id.clas4:
                if (checked)
                    atclas4 = "present";
                // Put some meat on the sandwich
            else
                // Remove the meat
                atclas4 = "absent";
                break;
            case R.id.clas5:
                if (checked)
                    atclas5 = "present";
                // Cheese me
            else
                // I'm lactose intolerant
                atclas5 = "absent";
                break;
            case R.id.clas6:
                if(checked)
                    atclas6 = "present";
                else
                    atclas6 = "absent";

                    break;
            case R.id.clas7:
                if(checked)
                { atclas7 = "present";




                }
                else
                    atclas7 = "absent";
                    break;

        }







    }

    public void submitattandance(View view){

        reff = FirebaseDatabase.getInstance().getReference().child("member").child("today");


        s4 = class4sir+":-"+atclas4;
        s5 = class5sir+":-"+atclas5;
        s6 = class6sir+":-"+atclas6;
        s7 = class7sir+":-"+atclas7;

        attandance.setClass4(s4);
        attandance.setClass5(s5);
        attandance.setClass6(s6);
        attandance.setClass7(s7);
        reff.child(datetoday).setValue(attandance);




    }

    public void submitDate(View view){

        btn4.setVisibility(View.VISIBLE);
        datetoday = date.getText().toString();




    }
}
