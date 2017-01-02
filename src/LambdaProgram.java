import ApplicationModel.BetaReductionEngine;
import ApplicationModel.LambdaAppEngine;
import LambdaAppUI.SimpleLambdaParser;
import LambdaAppUI.LambdaView;
import LambdaAppUI.SimpleGui;

public class LambdaProgram {

    public static void main(String[] args) {
        LambdaAppEngine lambdaAppEngine = new BetaReductionEngine();

        LambdaView lambdaView = new SimpleGui(lambdaAppEngine, new
                SimpleLambdaParser());

        lambdaView.display();
    }
}
