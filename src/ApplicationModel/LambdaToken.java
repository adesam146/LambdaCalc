package ApplicationModel;

import LambdaTerm.LambdaTerm;

/**
 * Created by User on 20/12/2016.
 */
public interface LambdaToken {

    String getText();
    LambdaTerm compose(LambdaTerm lambdaTerm);
}
