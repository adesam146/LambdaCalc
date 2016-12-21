package LambdaTerms;

public class LambdaApplication implements LambdaTerm {

    private final LambdaTerm leftTerm;
    private final LambdaTerm rightTerm;

    public LambdaApplication(LambdaTerm leftTerm, LambdaTerm rightTerm) {
        this.leftTerm = leftTerm;
        this.rightTerm = rightTerm;
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
