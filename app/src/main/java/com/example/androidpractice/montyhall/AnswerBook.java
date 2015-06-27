package com.example.androidpractice.montyhall;

import java.util.Random;

/**
 * Created by 205796 on 6/26/15.
 */
public class AnswerBook {

    //Member variables
    public String[] mAnswers = {

            "Goat!",
            "Goat!",
            "You Win a Car!"
    };

    //Methods

    public String getAnswers() {

        String answer = "";



        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mAnswers.length);

        //answer = mAnswers[randomNumber];

        return answer;
    }


}
