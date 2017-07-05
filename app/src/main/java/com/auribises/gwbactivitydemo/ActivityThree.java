package com.auribises.gwbactivitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityThree extends AppCompatActivity implements View.OnClickListener{

    EditText eTxtName, etxtPhone;
    Button btnSubmit;

    void initViews(){ // AnyName
        eTxtName = (EditText)findViewById(R.id.editTextName);
        etxtPhone = (EditText)findViewById(R.id.editTextPhone);
        btnSubmit = (Button)findViewById(R.id.buttonBack);

        btnSubmit.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        initViews();
    }

    @Override
    public void onClick(View view) {
        String name = eTxtName.getText().toString().trim();
        String phone = etxtPhone.getText().toString().trim();

        Intent data1 = new Intent(); // Empty Intent to store the data
        data1.putExtra("keyName",name);
        data1.putExtra("keyPhone",phone);

        setResult(201,data1); // 201 is a resultCode. Any Number of your choice
        finish(); // Must finish the Activity after setResult
    }
}
