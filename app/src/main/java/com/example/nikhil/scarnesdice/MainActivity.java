package com.example.nikhil.scarnesdice;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int user_overall_score;
    int user_turn_score;
    int computer_overall_score;
    int computer_turn_score;
    Random rand;
    int max = 6, min = 1;
    TextView textv ;
    ImageView imgvw;
    Button btn1, btn2, btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textv = (TextView)findViewById(R.id.textView);
        imgvw = (ImageView)findViewById(R.id.imageView);
        btn1 = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
    }

    public void reset_Handler(View view) {
        user_overall_score = 0;
        user_turn_score = 0;
        computer_overall_score = 0;
        computer_turn_score = 0;
        textv.setText("user score is : 0 and computer score is : 0");
    }
    public void hold_Handler(View view) {

        user_turn_score = 0;
        computer_turn_score = 0;
        textv.setText("user_overall_score = " + String.valueOf(user_overall_score) + " computer turn score = " + String.valueOf(computer_overall_score) +" user turn score = " + String.valueOf(user_turn_score) + " computer turn score = " + String.valueOf(computer_turn_score) );
     computer_turn(view);
    }

   public void computer_turn(View view) {
       //  while (computer_overall_score < 20) {
       Log.d("first position","first position");
       btn1.setEnabled(false);
       btn2.setEnabled(false);
       boolean iterat = true;
       while (iterat) {
           Log.d("second position","second position");
           if (computer_overall_score < 20) {

               final Handler timerHandler = new Handler();
               Runnable timerRunnable = new Runnable() {
                   @Override
                   public void run() {
                       timerHandler.postDelayed(this, 500);
                   }
               };
               Random r = new Random();
               computer_turn_score = r.nextInt(7 - 1) + 1;
               computer_overall_score = computer_overall_score + computer_turn_score;
               Log.d(String.valueOf(computer_turn_score),"errorr  zzzzzzzzzzzzzzz");
               if (computer_turn_score == 1) {
                   computer_overall_score = 0;
                   textv.setText("your score is = " + String.valueOf(user_overall_score) + " computer overall score = " + String.valueOf(computer_overall_score));
                   btn1.setEnabled(true);
                   btn2.setEnabled(true);
                   Log.d("third position","third position");
                   break;
               }
               textv.setText("your score is = " + String.valueOf(user_overall_score) + " computer overall score = " + String.valueOf(computer_overall_score) + " computer turn score is = " + String.valueOf(computer_turn_score));
               switch (computer_turn_score) {
                   case 1:

                       imgvw.setImageResource(R.drawable.dice1);
                       break;
                   case 2:
                       imgvw.setImageResource(R.drawable.dice2);
                       break;
                   case 3:
                       imgvw.setImageResource(R.drawable.dice3);
                       break;
                   case 4:
                       imgvw.setImageResource(R.drawable.dice4);
                       break;
                   case 5:
                       imgvw.setImageResource(R.drawable.dice5);
                       break;
                   case 6:
                       imgvw.setImageResource(R.drawable.dice6);
                       break;
                   default:
                       textv.setText("wrong choice");
                       break;
               }
           } else {
                btn1.setEnabled(true);
               btn2.setEnabled(true);
               break;
           }
       }

   }
   public void roll_Handler(View view) {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
       Random r = new Random();
       user_turn_score = r.nextInt(7 - 1) + 1;
 //       int randomNum = rand.nextInt((max - min) + 1) + min;
       user_overall_score = user_overall_score + user_turn_score;
       if (user_turn_score == 1){
           user_overall_score = 0;
        computer_turn(view);
        }
        textv.setText("your score is = " + String.valueOf(user_overall_score) + " computer score is = 0 user turn score is "+ String.valueOf(user_turn_score));
       switch (user_turn_score){
           case 1:
                imgvw.setImageResource(R.drawable.dice1);
               break;
           case 2:
               imgvw.setImageResource(R.drawable.dice2);
               break;
           case 3:
               imgvw.setImageResource(R.drawable.dice3);
               break;
           case 4:
               imgvw.setImageResource(R.drawable.dice4);
               break;
           case 5:
               imgvw.setImageResource(R.drawable.dice5);
               break;
           case 6:
               imgvw.setImageResource(R.drawable.dice6);
               break;
           default:
               textv.setText("error occured");
       }


    }
}
