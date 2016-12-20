package LambdaTerm;

/**
 * Created by User on 19/12/2016.
 */
public class LambdaApplication implements LambdaTerm {

    private final LambdaTerm leftTerm;
    private final LambdaTerm rightTerm;

    public LambdaApplication(LambdaTerm leftTerm, LambdaTerm rightTerm) {
        this.leftTerm = leftTerm;
        this.rightTerm = rightTerm;
    }

    @Override
    public LambdaTerm compose(LambdaTerm lambdaTerm) {
        return null;
    }

    @Override
    public String toString() {
        return "(" + leftTerm + " " + rightTerm + ")";
    }
}
