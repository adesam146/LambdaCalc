package ApplicationModel;

public class LambdaAppEngine {

    private final LambdaParser lambdaParser;

    public LambdaAppEngine() {
        this.lambdaParser = new SimpleLambdaParser();
    }

    public void undoInput() {
        lambdaParser.removeLastInput();
    }

    public void addInput(LambdaToken lambdaToken) {
        lambdaParser.add(lambdaToken);
    }
}
