package seccareccir1.robsquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";
    private Button mq1Button;
    private Button mq2Button;
    private Button mq3Button;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;

    private Questions[] mQuestionBank = new Questions[] {
            new Questions(R.string.question_a, 2),
            new Questions(R.string.question_b, 1),
            new Questions(R.string.question_c, 3),
            new Questions(R.string.question_d, 1),
    };
    private Answers[] mAnswerBank = new Answers[] {
            new Answers(R.string.question_a_1, R.string.question_a_2, R.string.question_a_3),
            new Answers(R.string.question_b_1, R.string.question_b_2, R.string.question_b_3),
            new Answers(R.string.question_c_1, R.string.question_c_2, R.string.question_c_3),
            new Answers(R.string.question_d_1, R.string.question_d_2, R.string.question_d_3),
    };

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) Called");
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        mQuestionTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
                updateAnswers();
            }
        });

        mq1Button = (Button) findViewById(R.id.q1);
        mq1Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkAnswer(1);
            }
        });
        mq2Button = (Button) findViewById(R.id.q2);
        mq2Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(2);
            }
        });
        mq3Button = (Button) findViewById(R.id.q3);
        mq3Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(3);
            }
        });

        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
                updateAnswers();
            }
        });
        mPrevButton = (ImageButton) findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                updateQuestion();
                updateAnswers();
            }
        });
        updateQuestion();
        updateAnswers();
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"onStart() called");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"onResume() called");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"onPause() called");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG,"onStop() called");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy() called");
    }

    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    public static String getTAG() {
        return TAG;
    }



    private void updateAnswers(){
        int A1 = mAnswerBank[mCurrentIndex].getq1();
        int A2 = mAnswerBank[mCurrentIndex].getq2();
        int A3 = mAnswerBank[mCurrentIndex].getq3();
        mq1Button.setText(A1);
        mq2Button.setText(A2);
        mq3Button.setText(A3);
    }

    private void checkAnswer(int userPress){
        int answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId = 0;

        if(userPress == answerIsTrue){
            messageResId = R.string.correct_toast;
        }else{
            messageResId = R.string.incorrect_toast;
        }
        Toast t = Toast.makeText(this, messageResId, Toast.LENGTH_SHORT);
        t.setGravity(Gravity.TOP,0,0);
        t.show();
    }
}
