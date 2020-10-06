/** @author <Carina Pineda>
October 5th,2020

CS 301 Part B Face Maker*/



//package
package com.example.pineda20_facemaker_parta;

//required imports
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;


//class
public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener {

    //instance variables
    private Face ff;
    private SeekBar seekbarRed;
    private SeekBar seekbarBlue;
    private SeekBar seekbarGreen;
    private Spinner playSpin; // make Spinner object
    private RadioButton hairButton;
    private RadioButton eyeButton;
    private RadioButton skinButton;
    private LinearLayout verticalLayout;
    private Button randomFace;
    private int redSlide = 0;
    private int greenSlide = 0;
    private int blueSlide = 0;
    String[] spinnerOptions = {"Hair Style 1", "Hair Style 2", "Hair Style 3"}; // 3 options that will be displayed on the Spinner

    /**External Citation
     Date: 10 September 2020
     Problem: Did not know how to populate a spinner
     Resource:
     Dr. Nuxoll's code from CS 301 Section b */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        playSpin = (Spinner) findViewById(R.id.spinner);

        //This will populate the spinner with the three entries from above
        ArrayAdapter<String> playAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_dropdown_item, this.spinnerOptions); //
        //applying the method to the playSpin Spinner object
        playSpin.setAdapter(playAdapter);
        //we now have a populated spinner
        playSpin.setOnItemSelectedListener(this);

        ff = findViewById(R.id.FaceSurfaceView);
        verticalLayout = findViewById(R.id.linearLayout);

        //found all of the ID's for the seekbar, radioButtons, and the randomFace
        //then we need to listen for any changes anywhere
        seekbarRed = findViewById(R.id.Seekbar_Red);
        seekbarRed.setOnSeekBarChangeListener(this);

        seekbarBlue = findViewById(R.id.Seekbar_Blue);
        seekbarBlue.setOnSeekBarChangeListener(this);

        seekbarGreen = findViewById(R.id.SeekBar_Green);
        seekbarGreen.setOnSeekBarChangeListener(this);

        hairButton = findViewById(R.id.radioButton3);
        hairButton.setOnClickListener(this);

        eyeButton = findViewById(R.id.radioButton2);
        eyeButton.setOnClickListener(this);

        skinButton = findViewById(R.id.radioButton);
        skinButton.setOnClickListener(this);

        randomFace = findViewById(R.id.buttonRandom);
        randomFace.setOnClickListener(this);


    //find view of each radio
        //listen to each of them

    }

    //implements the method onClick because it is a required method from the View.onClickListener interface
    //its empty for now because we do not need to implement it for part A
    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.buttonRandom){
            ff.randomize(); //draws a random face every time you press the button randomize() class in Face.java does the hairstyles and colors
            ff.invalidate(); // redraws the face
        }
        int red;
        int green;
        int blue;

        //if the view's id is equal to the hair radio button then we want to get its red,green, and blue value
        //then those values will be set to the SetProgress for the current state of the seekbar
        if(view.getId()==R.id.radioButton3){
            red = Color.red(ff.getHairColor());
            green = Color.green(ff.getHairColor());
            blue = Color.blue(ff.getHairColor());
            this.seekbarRed.setProgress(red);
            this.seekbarGreen.setProgress(green);
            this.seekbarBlue.setProgress(blue);
        }
        //the same will happen for the skin radio button
        else if(view.getId()==R.id.radioButton) {
            red = Color.red(ff.getSkinColor());
            green = Color.green(ff.getSkinColor());
            blue = Color.blue(ff.getSkinColor());
            this.seekbarRed.setProgress(red);
            this.seekbarGreen.setProgress(green);
            this.seekbarBlue.setProgress(blue);
        }

        //the same will happen for the Eye radio button
        else if(view.getId()==R.id.radioButton2) {
            red = Color.red(ff.getEyeColor());
            green = Color.green(ff.getEyeColor());
            blue = Color.blue(ff.getEyeColor());
            this.seekbarRed.setProgress(red);
            this.seekbarGreen.setProgress(green);
            this.seekbarBlue.setProgress(blue);
        }
        //redraw on the ff face surface view
        ff.invalidate();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //the hair style will change with what value of i gets passed through
        ff.setHairStyle(i);
        ff.invalidate();
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        /**for the onProgressChanged we're looking for the blue red and green seek bar
        then the param @redSlide, @blueSlide,@greenSlide are set to the progress when you slide
         it then we take each of these values and set it to the a new rgb C
         if the hair button was picked then we set that color to it
         if the skinbutton was clicked then it sets to that color same for eyeButton
        */
        if(seekBar.getId() == R.id.Seekbar_Blue) {
            blueSlide = i;
        }
        else if(seekBar.getId() == R.id.Seekbar_Red){
                redSlide = i;
            }
        else if(seekBar.getId() == R.id.SeekBar_Green){
                greenSlide = i;
        }
        int c = Color.rgb(redSlide, greenSlide, blueSlide);

        if(this.hairButton.isChecked()) {
            ff.setHairColor(c);
        }
        else if(this.skinButton.isChecked()){
            ff.setSkinColor(c);
        }
        else if(this.eyeButton.isChecked()){
            ff.setEyeColor(c);
        }

        ff.invalidate();
    }

    //methods that were needed to implement the class but did not need to use
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}
}
