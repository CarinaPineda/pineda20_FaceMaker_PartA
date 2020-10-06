/** @author <Carina Pineda>
October 5th,2020

CS 301 Part B Face Maker*/

//package
package com.example.pineda20_facemaker_parta;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceView;

import androidx.annotation.RequiresApi;

import java.util.Random;

//Face Class
public class Face extends SurfaceView {

    private int hairStyle;
    private int skinColorRed;
    private int skinColorGreen;
    private int skinColorBlue;
    private int eyeColorRed;
    private int eyeColorGreen;
    private int eyeColorBlue;
    private int hairColorRed;
    private int hairColorGreen;
    private int hairColorBlue;
    private int skinColor;
    private int hairColor;
    private int eyeColor;

    Paint randomEyeColor = new Paint();
    Paint randomHairColor = new Paint();
    Paint randomSkinColor = new Paint();

    /**
     * calls randomize method in Face constructor
     */
    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        randomize();
    }


/**
 External Citation
 Date: 10 September 2020
 Problem: Didn't know how to make random int in specific rnage
 Resource:
 https://stackoverflow.com/questions/20560899/generate-a-random-color-java
 Solution: Used line of example code from stack overflow
 */

    /**
     * will assign a random number typecast as an int to the
     *
     * @param skinColor
     * @param eyeColor
     * @param hairColor
     * @param hairStyle
     */
    public void randomize() {

        Random rand = new Random();
        this.skinColorRed = rand.nextInt(255);
        this.skinColorGreen = rand.nextInt(255);
        this.skinColorBlue = rand.nextInt(255);

        this.eyeColorRed = rand.nextInt(255);
        this.eyeColorGreen = rand.nextInt(255);
        this.eyeColorBlue = rand.nextInt(255);

        this.hairColorRed = rand.nextInt(255);
        this.hairColorGreen = rand.nextInt(255);
        this.hairColorBlue = rand.nextInt(255);

        //randomize the hairStyle with 3 different options
        this.hairStyle = rand.nextInt(3);

        //the random colors are all ints and they are set to a new rgb in skinColor,eyeColor and hairColor
        skinColor = Color.rgb(skinColorRed, skinColorGreen, skinColorBlue);
        eyeColor = Color.rgb(eyeColorRed, eyeColorGreen, eyeColorBlue);
        hairColor= Color.rgb(hairColorRed, hairColorGreen, hairColorBlue);

        //this is where my paint is being passed the random rgb
        this.randomSkinColor.setColor(skinColor);
        this.randomEyeColor.setColor(eyeColor);
        this.randomHairColor.setColor(hairColor);

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)//<-- im not exactly sure i was getting an error and it
    // said to input this for my drawHair I think it has to do with my version of android studio??

    @Override
    public void onDraw(Canvas canvas) {
        //this is where everything gets drawn
        //skin colors
        this.randomSkinColor.setColor(skinColor);
        this.randomEyeColor.setColor(eyeColor);
        this.randomHairColor.setColor(hairColor);

        //calling the methods for my head,eyes, hairStyle, and Smile to make it cleaner
        drawHead(canvas);
        drawEyes(canvas);
        drawHairStyle(canvas);
        drawSmile(canvas);

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)//<-- im not exactly sure i was getting an error and it
    // said to input this for my drawHair I think it has to do with my version of android studio??


   /**
    * External Citation
    * Date: October 4th 2020
    * Problem: I wasnt sure how to draw a filled in triangle
    * https://stackoverflow.com/questions/3501126/how-to-draw-a-filled-triangle-in-android-canvas
    * Solution: Used example code to use the path and draw the triangle for a hair option
    //draw Hair style - I set each hair style to its option since its an int
    //then whichever option it hits it will draw the oval,rectangle or use path to draw a triangle.
    */
    public void drawHairStyle(Canvas canvas) {
        if (hairStyle == 0) {
            canvas.drawOval(700.0f, 350.0f, 1100.0f, 450.0f, randomHairColor);
        } else if (hairStyle == 1) {
            canvas.drawRect(700.0f, 350.0f, 1100.0f, 450.0f, randomHairColor);
        } else if (hairStyle == 2) {
            Path path = new Path();
            path.moveTo(700.0f, 400.0f); // Top
            path.lineTo(900.0f, 300.0f); // Bottom left
            path.lineTo(1100.0f, 400.0f); // Bottom right
            path.close();
            canvas.drawPath(path, randomHairColor);
        }

    }
    //draw head method
    public void drawHead(Canvas canvas){
        canvas.drawCircle(900.0f, 600.0f, 250.0f, randomSkinColor);
    }
    //draw eyes method
    public void drawEyes(Canvas canvas){
        canvas.drawCircle(960.0f, 550.0f, 30.0f, randomEyeColor);
        canvas.drawCircle(840.0f, 550.0f, 30.0f, randomEyeColor);
    }

    //draw smile method
    public void drawSmile(Canvas canvas){
        RectF smile = new RectF(840.0f, 575.0f, 960.0f, 700.0f);
        canvas.drawArc(smile, 0.0f, 180.0f, false, randomEyeColor);
    }


    //since all of my instance variables are private I need to use getters and setters to use them in
    //my main activity.java class
    public int getHairStyle(){
        return this.hairStyle;
    }
    public int getHairColor() { return this.hairColor;}
    public int getSkinColor() { return this.skinColor;}
    public int getEyeColor() { return this.eyeColor;}
    public void setHairStyle(int x){
        this.hairStyle = x;
    }
    public void setHairColor(int x) { this.hairColor = x;}
    public void setEyeColor(int x) {this.eyeColor = x;}
    public void setSkinColor(int x) {this.skinColor = x;}
}
