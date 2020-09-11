/**@author <Carina Pineda>
Sept 10,2020
CS 301 Part A Face Maker


External Citation
Date: 10 September 2020
Problem: Did not know how to populate a spinner
Resource:
Dr. Nuxoll's code from CS 301 Section b */

//package
package com.example.pineda20_facemaker_parta;

//required imports
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


//class
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner playSpin; // make Spinner object
    String[] spinnerOptions = {"Entry1", "Entry2", "Entry3"}; // 3 options that will be displayed on the Spinner


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        playSpin = (Spinner) findViewById(R.id.spinner);

        //This will populate the spinner with the three entries from above
        ArrayAdapter<String> playAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                this.spinnerOptions); //
        //applying the method to the playSpin Spinner object
        playSpin.setAdapter(playAdapter);

        //we now have a populated spinner


    }

    //implements the method onClick because it is a required method from the View.onClickListener interface
    //its empty for now because we do not need to implement it for part A
    @Override
    public void onClick(View view) {

    }
}
