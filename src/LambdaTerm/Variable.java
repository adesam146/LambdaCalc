package LambdaTerm;

public class Variable implements LambdaTerm {

    private final String variable;

    public Variable(String variable) {
        this.variable = variable;
    }

    @Override
    public LambdaTerm compose(LambdaTerm lambdaTerm) {
        return new LambdaApplication(this, lambdaTerm);
    }

    @Override
    public String toString() {
        return variable;
    }
}
