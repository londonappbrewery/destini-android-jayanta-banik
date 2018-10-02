package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button B1,B2;
    TextView story;
    int n=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        if(savedInstanceState!=null)
            n=savedInstanceState.getInt("IndexKey",1);

        story = (TextView) findViewById(R.id.storyTextView);
        B1= (Button) findViewById(R.id.buttonTop);
        B2= (Button) findViewById(R.id.buttonBottom);

        n=updateStory(n);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n==1||n==2)
                    n=updateStory(3);
                else if(n==3)
                    n=updateStory(6);
                else
                    n=updateStory(1);

            }
        });
       // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n==1)
                    n=updateStory(2);
                else if(n==2)
                    n=updateStory(4);
                else
                   finish();
            }
        });


    }

    protected int updateStory(int n) {
        switch(n){
            case 1:
                story.setText(R.string.T1_Story);
                B1.setText(R.string.T1_Ans1);
                B2.setText(R.string.T1_Ans2);
                break;
            case 2:
                story.setText(R.string.T2_Story);
                B1.setText(R.string.T2_Ans1);
                B2.setText(R.string.T2_Ans2);
                break;
            case 3:
                story.setText(R.string.T3_Story);
                B1.setText(R.string.T3_Ans1);
                B2.setText(R.string.T3_Ans2);
                break;
            case 4:
                story.setText(R.string.T4_End);
                B1.setText(R.string.again);
                B2.setText(R.string.End_app);
                break;
            case 5:
                story.setText(R.string.T5_End);
                B1.setText(R.string.again);
                B2.setText(R.string.End_app);
                break;
            case 6:
                story.setText(R.string.T6_End);
                B1.setText(R.string.again);
                B2.setText(R.string.End_app);
                break;
            default:
                Log.d("destini","wrong case in update method");


        }
        return n;
    }

    @Override
    public  void  onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("IndexKey",n);
    }
}
