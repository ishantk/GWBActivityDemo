package com.auribises.gwbactivitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.RandomAccessFile;

public class ViewsActivity extends AppCompatActivity implements View.OnClickListener,CompoundButton.OnCheckedChangeListener{

    // Declare Refrences to the Views. Reference variable can be anyname
    CheckBox cbCpp, cbJava, cbPy;
    RadioButton rbMale, rbFemale;

    Button btnSubmit;

    Spinner spCity;
    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapter,autoAdapter;

    RatingBar ratingBar;


    // Create a method(any name) to initialize views
    void initViews(){
        cbCpp = (CheckBox)findViewById(R.id.checkBoxCpp);
        cbJava = (CheckBox)findViewById(R.id.checkBoxJava);
        cbPy = (CheckBox)findViewById(R.id.checkBoxPython);

        rbFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        rbMale = (RadioButton)findViewById(R.id.radioButtonMale);


        btnSubmit = (Button)findViewById(R.id.buttonSubmit);

        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(ViewsActivity.this,"You gave "+v+" ratings",Toast.LENGTH_LONG).show();
            }
        });

        //btnSubmit.setOnClickListener(this);

        // EventHandling with Anonymous Class
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = autoCompleteTextView.getText().toString().trim();
                Toast.makeText(ViewsActivity.this,"You Clicked Button: "+str,Toast.LENGTH_LONG).show();
            }
        });

        cbCpp.setOnCheckedChangeListener(this);
        cbJava.setOnCheckedChangeListener(this);
        cbPy.setOnCheckedChangeListener(this);
        rbFemale.setOnCheckedChangeListener(this);
        rbMale.setOnCheckedChangeListener(this);

    }

    void initSpinner(){
        spCity = (Spinner)findViewById(R.id.spinner);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);

        adapter.add("--Select City--"); //0
        adapter.add("Ludhiana");
        adapter.add("Chandigarh");
        adapter.add("Delhi");
        adapter.add("Bengaluru");
        adapter.add("California");  //n-1

        spCity.setAdapter(adapter);


        spCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                String city = adapter.getItem(pos);

                if(pos!=0)
                    Toast.makeText(ViewsActivity.this,"You Selected:: "+city,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    void initAutoComplete(){
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        autoAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);

        autoAdapter.add("Handkerchiefs"); //0
        autoAdapter.add("Handbags");
        autoAdapter.add("Shoes");
        autoAdapter.add("Shirts");
        autoAdapter.add("Wallets");
        autoAdapter.add("Shorts");  //n-1

        autoCompleteTextView.setAdapter(autoAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_views);
        initViews();
        initSpinner();
        initAutoComplete();
    }

    @Override
    public void onClick(View view) {
        String str = autoCompleteTextView.getText().toString().trim();
        Toast.makeText(this,"You Clicked Button: "+str,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        int id = compoundButton.getId();

        switch (id){
            case R.id.checkBoxCpp:
                if(b)
                    Toast.makeText(this,"You Checked CPP",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this,"You UnChecked CPP",Toast.LENGTH_LONG).show();
                break;

            case R.id.checkBoxJava:
                Toast.makeText(this,"You Selected Java: "+cbJava.isChecked(),Toast.LENGTH_LONG).show();
                break;

            case R.id.checkBoxPython:

                break;

            case R.id.radioButtonFemale:
                Toast.makeText(this,"You Selected Female: "+rbFemale.isChecked(),Toast.LENGTH_LONG).show();
                break;

            case R.id.radioButtonMale:

                break;

        }
    }
}
