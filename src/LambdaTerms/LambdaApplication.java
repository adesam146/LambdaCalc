package LambdaTerms;

public class LambdaApplication implements LambdaTerm {

    private final LambdaTerm leftTerm;
    private final LambdaTerm rightTerm;

    public LambdaApplication(LambdaTerm leftTerm, LambdaTerm rightTerm) {
        this.leftTerm = leftTerm;
        this.rightTerm = rightTerm;
    }

    //You would probably need to make applicationTerms of two variable a lot,
    // the need for this was noticed while writing the test cases
    public LambdaApplication(String leftVar, String rightVar) {
        this.leftTerm = new LambdaVariable(leftVar);
        this.rightTerm = new LambdaVariable(rightVar);
    }

    @Override
    public String toString() {
        return "(" + leftTerm + " " + rightTerm + ")";
    }

    @Override
    public <T> T accept(LambdaTermVisitor<T> visitor) {
        return visitor.visitLambdaApplication(this);
    }

    public LambdaTerm getLeftTerm() {
        return leftTerm;
    }

    public LambdaTerm getRightTerm() {
        return rightTerm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LambdaApplication that = (LambdaApplication) o;

        if (!leftTerm.equals(that.leftTerm)) return false;
        return rightTerm.equals(that.rightTerm);

    }

    @Override
    public int hashCode() {
        int result = leftTerm.hashCode();
        result = 31 * result + rightTerm.hashCode();
        return result;
    }
}
