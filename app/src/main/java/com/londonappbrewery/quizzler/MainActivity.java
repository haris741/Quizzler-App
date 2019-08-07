package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    // TODO: Declare constants here


    // TODO: Declare member variables here:

        Button trueButton;
        Button falseButton;
        TextView mTextView;
        TextView mScoreTextView;
        ProgressBar mProgressBar;
        int questionNumber=0;
        int mScore=0;

;    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };
    final int progressBarIncrement=(int) Math.ceil(100/ mQuestionBank.length); //the magnitude with which the progress bar will be increased;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trueButton = (Button) findViewById(R.id.true_button);
        falseButton=(Button) findViewById(R.id.false_button);
        mScoreTextView= (TextView) findViewById(R.id.score);
        mProgressBar= (ProgressBar) findViewById(R.id.progress_bar);

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);

                updateQuestion();
            }
        });
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
                updateQuestion();
            }
        });
        mTextView=(TextView) findViewById(R.id.question_text_view);

    }
    private void updateQuestion()
    {

        questionNumber=(questionNumber+1)%mQuestionBank.length;
        if(questionNumber==0)
        {

           AlertDialog.Builder alert = new AlertDialog.Builder(this);
           alert.setTitle("Game Over");
           alert.setCancelable(false);
           alert.setMessage("Your Score is "+ mScore);
           alert.setPositiveButton("Close app", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   finish();
               }
           });
           alert.show();

        }
        mTextView.setText(mQuestionBank[questionNumber].getQuestionId());
        mProgressBar.incrementProgressBy(progressBarIncrement);
        mScoreTextView.setText("Score: "+ mScore+"/"+ mQuestionBank.length);

    }
    private void checkAnswer(boolean answer)
    {
        if(answer== mQuestionBank[questionNumber].getAnswer())
        {
            Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
            mScore++;
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
        }
    }
}
