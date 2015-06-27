package com.example.androidpractice.montyhall;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.util.Log;

import java.util.Random;

public class MontyActivity extends ActionBarActivity {
    // for debug purpose TAG created
    String TAG = "Monty Debug:";

    public int getRando() {
        // give me a random number
        Random randomGenerator = new Random();
        // anything between 1 and 3 (thats 0,1,2)
        int guessNumber = randomGenerator.nextInt(3);
        Log.d(TAG, "random number made by getRando() : "+ guessNumber);
       return guessNumber;
    }
    public int randomNumber = getRando();

    private AnswerBook mAnswerBook = new AnswerBook();
    public String answer = mAnswerBook.getAnswers();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monty);

        //Declare our view Variables
        final Button door1Button = (Button) findViewById(R.id.door1Button);
        final Button door2Button = (Button) findViewById(R.id.door2Button);
        final Button door3Button = (Button) findViewById(R.id.door3Button);
        final Button resetButton = (Button) findViewById(R.id.resetButton);
        final Button quitButton = (Button) findViewById(R.id.quitButton);

        View.OnClickListener quitListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        };

        quitButton.setOnClickListener(quitListener);

        //Reset Button doors values

        View.OnClickListener resetListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                door1Button.setText("DOOR1");
                door2Button.setText("DOOR2");
                door3Button.setText("DOOR3");
                randomNumber = getRando();
                answer = mAnswerBook.getAnswers();
                Log.d(TAG, "random made by reset: "+randomNumber);
                Log.d(TAG, "new prize made by reset: "+answer);

                //getRando();
            }
        };

        resetButton.setOnClickListener(resetListener);


        View.OnClickListener door3Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(randomNumber == 2){
                    door3Button.setText(answer);
                }else{
                    door3Button.setText("NO PRIZE HERE");
                }

            }
        };

        door3Button.setOnClickListener(door3Listener);

        View.OnClickListener door2Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(randomNumber == 1){
                    door2Button.setText(answer);
                }else{
                    door2Button.setText("NO PRIZE HERE");
                }

            }
        };
        door2Button.setOnClickListener(door2Listener);

        View.OnClickListener door1Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(randomNumber == 0){
                    door1Button.setText(answer);
                }else{
                    door1Button.setText("NO PRIZE HERE");
                }
            }
        };

        door1Button.setOnClickListener(door1Listener);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_monty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
