package LambdaTerms;

public class LambdaVariable implements LambdaTerm {

    private final String variable;

    public LambdaVariable(String variable) {
        this.variable = variable;
    }

    @Override
    public String toString() {
        return variable;
    }

    @Override
    public <T> T accept(LambdaTermVisitor<T> visitor) {
        return visitor.visitLambdaVariable(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LambdaVariable that = (LambdaVariable) o;

        return variable.equals(that.variable);

    }

    @Override
    public int hashCode() {
        return variable.hashCode();
    }
}
