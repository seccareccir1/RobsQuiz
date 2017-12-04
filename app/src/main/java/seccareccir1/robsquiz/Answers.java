package seccareccir1.robsquiz;

/**
 * Created by RobertSeccareccia on 10/11/17.
 */

public class Answers {

    private int mq1;
    private int mq2;
    private int mq3;

    public int getq1() {
        return mq1;
    }

    public void setq1(int q1) {
        mq1 = q1;
    }
    public int getq2() {
        return mq2;
    }

    public void setq2(int q2) {
        mq2 = q2;
    }
    public int getq3() { return mq3; }
    public void setq3(int q3) {
        mq3 = q3;
    }

    public Answers(int q1, int q2, int q3){
        mq1 = q1;
        mq2 = q2;
        mq3 = q3;
    }

}
