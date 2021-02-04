package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.gridlayout.widget.GridLayout;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    // o=yellow, 1 =red, 2=empty
    int user = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningState = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    boolean gameActive = true;
    boolean c = true;


    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        int tappedSpace = Integer.parseInt(counter.getTag().toString());


        if (gameState[tappedSpace] == 2 && gameActive && c) {
            gameState[tappedSpace] = user;

            counter.setTranslationY(-2000);
            if (user == 0) {
                counter.setImageResource(R.drawable.yellow);
                counter.animate().translationYBy(2000).setDuration(300);
                user = 1;

            } else if (user == 1) {
                counter.setImageResource(R.drawable.red);
                counter.animate().translationYBy(2000).setDuration(300);
                user = 0;
            }


        }

        if (gameState[0] == 2 || gameState[1] == 2 ||gameState[2] == 2 ||gameState[3] == 2 ||gameState[4] == 2 ||gameState[5] == 2 ||gameState[6] == 2 ||gameState[7] == 2 ||gameState[8] == 2){
                c =true;
            }else {
                c = false;
                Button playAgainButton = (Button) findViewById(R.id.playAgainButon);

                TextView winnerTextView = (TextView) findViewById(R.id.textView);


                winnerTextView.setText("It's a Tie :(");

                winnerTextView.setVisibility(View.VISIBLE);
                playAgainButton.setVisibility(View.VISIBLE);
            }


        for (int[] winningState : winningState) {
            String winner = "";

            if (gameState[winningState[0]] == gameState[winningState[1]] && gameState[winningState[1]] == gameState[winningState[2]] && gameState[winningState[0]] != 2) {
                //someone has won
                gameActive = false;
                if (user == 1) {
                    winner = "Yellow";
                } else
                    winner = "Red";

                Button playAgainButton = (Button) findViewById(R.id.playAgainButon);

                TextView winnerTextView = (TextView) findViewById(R.id.textView);


                winnerTextView.setText(winner + "  Has Won!!");

                winnerTextView.setVisibility(View.VISIBLE);
                playAgainButton.setVisibility(View.VISIBLE);
            }
        }


    }

            public void Again (View view){
                Button playAgainButton = (Button) findViewById(R.id.playAgainButon);

                TextView winnerTextView = (TextView) findViewById(R.id.textView);


                winnerTextView.setVisibility(View.INVISIBLE);
                playAgainButton.setVisibility(View.INVISIBLE);
                GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
                for (int i = 0; i < gridLayout.getChildCount(); i++) {

                    ImageView counter = (ImageView) gridLayout.getChildAt(i);
                    counter.setImageDrawable(null);

                }
                Arrays.fill(gameState, 2);
                user = 0;
                gameActive = true;


            }



            @Override
            protected void onCreate (Bundle savedInstanceState){
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
            }
        }












