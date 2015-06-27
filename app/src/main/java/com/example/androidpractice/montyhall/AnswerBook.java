package com.example.androidpractice.montyhall;

import android.util.Log;

import java.util.Random;

/**
 * Created by 205796 on 6/26/15.
 */
public class AnswerBook {
    String TAG = "Answerbook Debug:";
    //Member variables
    public String[] mAnswers = {
            "You Win a Trip to Jamaica!",
            "You Win a Car!",
            "You Win a NYU Android course!"
    };

    //Methods

    public String getAnswers() {

        String answer = "";

        Random randomPrizeGenerator = new Random();
        int randomPrizeNumber = randomPrizeGenerator.nextInt(mAnswers.length);
        Log.d(TAG,"randomPrizeGenerator :"+randomPrizeGenerator);
        answer = mAnswers[randomPrizeNumber];

        return answer;
    }


}
