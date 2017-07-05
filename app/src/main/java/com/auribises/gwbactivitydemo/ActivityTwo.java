package com.auribises.gwbactivitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityTwo extends AppCompatActivity {

    TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        txtData = (TextView)findViewById(R.id.textViewData);

        // Receive the reference of the intent created in ActivityOne(Calling Activity)
        Intent rcv = getIntent();
        //String name = rcv.getStringExtra("keyName");
        //String phone = rcv.getStringExtra("keyPhone");
        //int age = rcv.getIntExtra("keyAge",0);

       /* Bundle bundle = rcv.getBundleExtra("keyBundle");
        String name = bundle.getString("keyName");
        String phone = bundle.getString("keyPhone");
        int age = bundle.getInt("keyAge");*/

       Person person = (Person)rcv.getSerializableExtra("keyPerson");

        txtData.setText(person.getName()+"\n"+person.getPhone()+"\n"+person.getAge());
    }

    public void goBackHandler(View view){
        finish();
    }
}
