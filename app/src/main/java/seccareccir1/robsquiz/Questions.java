package seccareccir1.robsquiz;

/**
 * Created by RobertSeccareccia on 10/11/17.
 */

public class Questions {

        private int mTextResId;

        public int getTextResId() {
            return mTextResId;
        }

        public void setTextResId(int textResId) {
            mTextResId = textResId;
        }

        public int isAnswerTrue() {
            return mAnswerTrue;
        }

        public void setAnswerTrue(int answerTrue) {
            mAnswerTrue = answerTrue;
        }

        private int mAnswerTrue;

        public Questions(int textResId, int answerTrue){
            mTextResId = textResId;
            mAnswerTrue = answerTrue;
        }

    }

