import ApplicationModel.LambdaAppEngine;
import ApplicationModel.LambdaParser;
import LambdaAppGui.LambdaView;
import LambdaAppGui.ReductionGui;
import LambdaTerm.LambdaTerm;

public class LambdaProgram {

    public static void main(String[] args) {
        LambdaAppEngine lambdaAppEngine = new LambdaAppEngine();

        LambdaView lambdaView = new ReductionGui(lambdaAppEngine);
        lambdaView.display();
    }
}
