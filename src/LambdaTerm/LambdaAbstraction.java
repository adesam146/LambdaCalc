package LambdaTerm;

/**
 * Created by User on 19/12/2016.
 */
public class LambdaAbstraction implements LambdaTerm {

    private final String variable;

    public LambdaAbstraction(String variable) {
        this.variable = variable;
    }

    @Override
    public LambdaTerm compose(LambdaTerm lambdaTerm) {
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
