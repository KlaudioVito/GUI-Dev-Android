/**
 * CSC 221 - Assignment 6
 * Android App Development
 * by Klaudio Vito
 * 11/18/2015
 */

package com.example.klaudio.assignment_6;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final Random rand = new Random(System.currentTimeMillis()); //declaration of random number generator
    protected int theta = 0; //angle of rotation, initially set to zero
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //tells the app to look for the design of in activity_main.xml file
        final Button QuitButton = (Button) findViewById(R.id.QuitButton); //reference to the Quit Button in the design
        final Button GenerateButton = (Button) findViewById(R.id.GenerateButton);//reference to the Generate Button in the design
        final Button MenuButton = (Button) findViewById(R.id.MenuButton);//reference to the Menu Button in the design
        final Button ExpandButton = (Button) findViewById(R.id.ExpandButton);//reference to the Expand Button in the design
        final Button ShrinkButton = (Button) findViewById(R.id.ShrinkButton);//reference to the Shrink Button in the design
        final Button RotateButton = (Button) findViewById(R.id.RotateButton);//reference to the Rotate CW Button in the design
        final Button ccwRotate = (Button) findViewById(R.id.ccwButton);//reference to the Rotate CCW Button in the design
        final ImageView rectangle = (ImageView) findViewById(R.id.drawRectangle);//declaration of rectangle ImageView found by drawRectangle ID
        rectangle.getLayoutParams().width = 100 + rand.nextInt(350); // set rectangle initial width;
        rectangle.getLayoutParams().height = 100 + rand.nextInt(250); // set rectangle initial height;
        rectangle.requestLayout(); //show on the screen;
        final TextView area = (TextView) findViewById(R.id.area); //declare TextView are found by area ID
        area.setText("Area is: " + rectangle.getLayoutParams().width * rectangle.getLayoutParams().height); //set the text to be displayed by area
        ExpandButton.setVisibility(View.GONE); //make button invisible, it will be visible on "Menu" click
        ShrinkButton.setVisibility(View.GONE);//make button invisible, it will be visible on "Menu" click
        RotateButton.setVisibility(View.GONE);//make button invisible, it will be visible on "Menu" click
        ccwRotate.setVisibility(View.GONE);//make button invisible, it will be visible on "Menu" click
        //click listener for the quit button
        QuitButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        System.exit(0);
                    }
                }
        );
        //click listener for the generate button
        GenerateButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        ExpandButton.setTextColor(Color.BLACK); //set text color for the button to be BLACK
                        ShrinkButton.setTextColor(Color.BLACK);//set text color for the button to be BLACK
                        RotateButton.setTextColor(Color.BLACK);//set text color for the button to be BLACK
                        ccwRotate.setTextColor(Color.BLACK);//set text color for the button to be BLACK
                        rectangle.setColorFilter(Color.BLACK);//set text color for the button to be BLACK
                        MenuButton.setVisibility(View.VISIBLE);//display motion menu
                        ExpandButton.setVisibility(View.GONE);//remove button from view
                        ShrinkButton.setVisibility(View.GONE);//remove button from view
                        RotateButton.setVisibility(View.GONE);//remove button from view
                        ccwRotate.setVisibility(View.GONE);//remove button from view
                        theta = 0; //set rotation angle to zero
                        rectangle.setRotation(theta); //reset rectangle position if it was rotated before
                        int x; //parameter for width
                        int y;//parameter for height
                        do {
                            x = rand.nextInt(670);
                        } while (x < 150 || x > 670); //get an x value between 150 and 670 in order to keep the rectangle inside the screen

                        do {
                            y = rand.nextInt(670);
                        } while (y < 150 || y > 700);//get a y value between 150 and 670 in order to keep the rectangle inside the screen

                        rectangle.getLayoutParams().width = x; //set rectangle width to x
                        rectangle.getLayoutParams().height = y; //set rectangle height to y
                        rectangle.requestLayout(); //generate new rectangle
                        area.setText("Area is: " + rectangle.getLayoutParams().width * rectangle.getLayoutParams().height); //set new area
                    }
                }
        );
        //click listener for the menu button
        MenuButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        MenuButton.setVisibility(View.GONE); //remove menu button
                        ExpandButton.setVisibility(View.VISIBLE); //show button on screen
                        ShrinkButton.setVisibility(View.VISIBLE);//show button on screen
                        RotateButton.setVisibility(View.VISIBLE);//show button on screen
                        ccwRotate.setVisibility(View.VISIBLE);//show button on screen
                    }
                }
        );
        //click listener for the expand button
        ExpandButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        ExpandButton.setTextColor(Color.YELLOW); //color the text YELLOW
                        ShrinkButton.setTextColor(Color.BLACK); //color the text BLACK
                        RotateButton.setTextColor(Color.BLACK);//color the text BLACK
                        ccwRotate.setTextColor(Color.BLACK);//color the text BLACK
                        if(rectangle.getLayoutParams().width < 750 && rectangle.getLayoutParams().height < 750 ) {
                            rectangle.getLayoutParams().width += 25; //increase width
                            rectangle.getLayoutParams().height += 25;//incrase height
                        }
                        else{

                            rectangle.getLayoutParams().width = rectangle.getLayoutParams().width; //cannot increase anymore
                            rectangle.getLayoutParams().height = rectangle.getLayoutParams().height; //cannot increase anymore
                        }
                        rectangle.setColorFilter(Color.RED); //set the color of the rectangle to be RED
                        rectangle.requestLayout(); //update the rectangle view
                        area.setText("Area is: " + rectangle.getLayoutParams().width * rectangle.getLayoutParams().height);//update area text
                    }
                }
        );
        //click listener for the shrink button
        ShrinkButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        ExpandButton.setTextColor(Color.BLACK); //set text color to BLACK
                        ShrinkButton.setTextColor(Color.YELLOW);//set text color to YELLOW
                        RotateButton.setTextColor(Color.BLACK);//set text color to BLACK
                        ccwRotate.setTextColor(Color.BLACK);//set text color to BLACK
                        if(rectangle.getLayoutParams().width > 150 && rectangle.getLayoutParams().height > 150 ){
                            rectangle.getLayoutParams().width -= 25; //reduce width
                            rectangle.getLayoutParams().height -= 25;//reduce height
                        }
                        else {
                            rectangle.getLayoutParams().width = rectangle.getLayoutParams().width; //cannot reduce anymore
                            rectangle.getLayoutParams().height = rectangle.getLayoutParams().height;//cannot reduce anymore
                        }
                        rectangle.setColorFilter(Color.BLUE);//set rectangle color to BLUE
                        rectangle.requestLayout(); //update rectangle view
                        area.setText("Area is: " + rectangle.getLayoutParams().width * rectangle.getLayoutParams().height);//update area text
                    }
                }
        );
        //click listener for the rotate button
        RotateButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        ExpandButton.setTextColor(Color.BLACK); //set text color to BLACK
                        ShrinkButton.setTextColor(Color.BLACK); //set text color to BLACK
                        RotateButton.setTextColor(Color.YELLOW); //set text color to YE::PW
                        ccwRotate.setTextColor(Color.BLACK); //set text color to BLACK
                        theta += 15; //increase rotation angle by 15 degrees
                        rectangle.setRotation(theta); //rotate the rectangle
                        rectangle.setColorFilter(Color.GREEN); //set color to GREEN
                        rectangle.requestLayout(); //update view
                    }
                }
        );
        //click listener for the ccwRotate button
        ccwRotate.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        ExpandButton.setTextColor(Color.BLACK);//set text color to BLACK
                        ShrinkButton.setTextColor(Color.BLACK);//set text color to BLACK
                        RotateButton.setTextColor(Color.BLACK);//set text color to BLACK
                        ccwRotate.setTextColor(Color.YELLOW);//set text color to YELLOW
                        theta -= 15;//reduce rotation angle by 15 degrees
                        rectangle.setRotation(theta); //rotate the rectangle
                        rectangle.setColorFilter(Color.GREEN);//set color to GREEN
                        rectangle.requestLayout(); //update the view
                    }
                }
        );
    }
}