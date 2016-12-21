package LambdaTerms;

public class LambdaAbstraction implements LambdaTerm {

    private final String variable;
    private final LambdaTerm returnTerm;

    public LambdaAbstraction(String variable, LambdaTerm returnTerm) {
        this.variable = variable;
        this.returnTerm = returnTerm;
    }

    @Override
    public <T> T accept(LambdaTermVisitor<T> visitor) {
        return visitor.visitLambdaAbstraction(this);
    }

    public String getVariable() {
        return variable;
    }

    public LambdaTerm getReturnTerm() {
        return returnTerm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LambdaAbstraction that = (LambdaAbstraction) o;

        if (!variable.equals(that.variable)) return false;
        return returnTerm.equals(that.returnTerm);
    }

    @Override
    public int hashCode() {
        int result = variable.hashCode();
        result = 31 * result + returnTerm.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
