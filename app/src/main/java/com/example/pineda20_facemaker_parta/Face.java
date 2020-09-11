/** @author <Carina Pineda>
Sept 10,2020
CS 301 Part A Face Maker*/

//package
package com.example.pineda20_facemaker_parta;


import java.util.Random;

//Face Class
public class Face {

    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle;


    /**calls randomize method in Face constructor*/
    public Face(){
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

    /**will assign a random number typecast as an int to the
     @param skinColor
     @param eyeColor
     @param hairColor
     @param hairStyle */
    public void randomize() {


        Random rand = new Random();
        skinColor = rand.nextInt(255);
        eyeColor = rand.nextInt(255);
        hairColor = rand.nextInt(255);
        hairStyle = rand.nextInt(255);

    }

}
