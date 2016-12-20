package ApplicationModel;

import LambdaTerm.*;

/**
 * Created by User on 20/12/2016.
 */
public class AbstractionToken implements LambdaToken {
    private final String bindingVar;

    public AbstractionToken(String bindingVar) {
        this.bindingVar = bindingVar;
    }

    @Override
    public String getText() {
        return bindingVar;
    }

    @Override
    public LambdaTerm compose(LambdaTerm lambdaTerm) {
        return new LambdaAbstraction(bindingVar, lambdaTerm);
    }
}
