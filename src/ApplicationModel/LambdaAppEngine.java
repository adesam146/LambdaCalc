package ApplicationModel;

import LambdaTerm.LambdaTerm;
import LambdaTerm.Variable;

/**
 * Created by User on 19/12/2016.
 */
public class LambdaAppEngine {

    private final LambdaParser lambdaParser;

    public LambdaAppEngine() {
        this.lambdaParser = new SimpleLambdaParser();
    }

    public void undoInput() {
        lambdaParser.removeLastInput();
    }

    public void addInput(LambdaTerm lambdaTerm) {
        lambdaParser.add(lambdaTerm);
    }
}
