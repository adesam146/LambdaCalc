package LambdaTerm;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LambdaVariable that = (LambdaVariable) o;

        return variable != null ? variable.equals(that.variable) :
                that.variable == null;
    }

    @Override
    public int hashCode() {
        return variable != null ? variable.hashCode() : 0;
    }
}
