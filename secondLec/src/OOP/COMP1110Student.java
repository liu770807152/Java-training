package OOP;

public class COMP1110Student extends Student {
    private int ass1;
    private int ass2;
    private int ce;
    private int labtest;
    private int mse;
    private int exam;

    public COMP1110Student(int age, String name, String uid, int ass1, int ass2, int ce, int labtest, int mse, int exam) {
        super(age, name, uid);
        this.ass1 = ass1;
        this.ass2 = ass2;
        this.ce = ce;
        this.labtest = labtest;
        this.mse = mse;
        this.exam = exam;
    }

    public int redeem(int mark, int outOf) {
        return Math.max(mark, outOf*exam/100);
    }

    public int mark() {
        return redeem(ass1, 5) + ass2 + redeem(ce, 5) + redeem(labtest, 5) + redeem(mse, 10) + exam/2;
    }

    @Override
    public String toString() {
        return super.toString()+", with mark of: "+mark()+", and a grade "+Grade.fromMark(mark());
    }
}

