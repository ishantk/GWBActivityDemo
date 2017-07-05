package com.auribises.gwbactivitydemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityOne extends AppCompatActivity {

    // Declare Reference Variable
    EditText eTxtName,eTxtPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        eTxtName = (EditText) findViewById(R.id.editTextName);
        eTxtPhone = (EditText) findViewById(R.id.editTextPhone);

        //System.out.println("ActivityOne - onCreate");
        Log.i("ActivityOne","--onCreate--");
        Toast.makeText(this,"ActivityOne - onCreate",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //System.out.println("ActivityOne - onStart");
        Log.i("ActivityOne","--onStart--");
        Toast.makeText(this,"ActivityOne - onStart",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //System.out.println("ActivityOne - onResume");
        Log.i("ActivityOne","--onResume--");
        Toast.makeText(this,"ActivityOne - onResume",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //System.out.println("ActivityOne - onPause");
        Log.i("ActivityOne","--onPause--");
        Toast.makeText(this,"ActivityOne - onPause",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //System.out.println("ActivityOne - onStop");
        Log.i("ActivityOne","--onStop--");
        Toast.makeText(this,"ActivityOne - onStop",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //System.out.println("ActivityOne - onDestroy");
        Log.i("ActivityOne","--onDestroy--");
        Toast.makeText(this,"ActivityOne - onDestroy",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //System.out.println("ActivityOne - onRestart");
        Log.i("ActivityOne","--onRestart--");
        Toast.makeText(this,"ActivityOne - onRestart",Toast.LENGTH_LONG).show();
    }

    public void clickHandler(View view){

        String name = eTxtName.getText().toString().trim();
        String phone = eTxtPhone.getText().toString().trim();

        // 1. Forward Pass - Direct
//        Intent intent = new Intent(ActivityOne.this,ActivityTwo.class);
//        intent.putExtra("keyName",name);
//        intent.putExtra("keyPhone",phone);
//        intent.putExtra("keyAge",20);
//        startActivity(intent);

        // 2. Forward Pass - Bundle
        /*Intent intent = new Intent(ActivityOne.this,ActivityTwo.class);

        Bundle bundle = new Bundle();
        bundle.putString("keyName",name);
        bundle.putString("keyPhone",phone);
        bundle.putInt("keyAge",25);

        intent.putExtra("keyBundle",bundle);


        startActivity(intent);*/

        // 3. Forward Pass - Serializable
//        Intent intent = new Intent(ActivityOne.this,ActivityTwo.class);
//        Person person = new Person(name,phone,30);
//        intent.putExtra("keyPerson",person);
//        startActivity(intent);


        // Backward Passing
        Intent intent = new Intent(ActivityOne.this,ActivityThree.class);
        startActivityForResult(intent,101); // 101 is a requestCode (Any number of your choice)

        /*String name = eTxtName.getText().toString().trim();

        int num = Integer.parseInt(name);

        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<=10;i++){
            buffer.append(num+" "+i+"'s are "+(num*i)+"\n");
        }*/


        //Toast.makeText(this,"You Clicked Button: "+name,Toast.LENGTH_LONG).show();
        //Toast.makeText(this,buffer.toString(),Toast.LENGTH_LONG).show();


        // Start An Activity

        // EXPLICIT INTENT
        //Intent intent = new Intent(ActivityOne.this,ActivityTwo.class);
        //startActivity(intent);

        // IMPLICIT INTENT
        //Intent intent = new Intent("com.auribises.gwbactivitydemo.activitytwo");
        //startActivity(intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 101 && resultCode == 201){
            String name = data.getStringExtra("keyName");
            String phone = data.getStringExtra("keyPhone");

            eTxtName.setText(name);
            eTxtPhone.setText(phone); // if you are setting data on view. Make sure it is String
        }
    }
}
