package ApplicationModel;

import LambdaTerms.*;

public class VariableToken implements LambdaToken{

    private final String variable;

    public VariableToken(String variable) {
        this.variable = variable;
    }

    @Override
    public String getText() {
        return variable;
    }

    @Override
    public LambdaTerm compose(LambdaTerm lambdaTerm) {
        return new LambdaApplication(new LambdaVariable(variable), lambdaTerm);
    }
}
