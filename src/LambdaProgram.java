import ApplicationModel.LambdaAppEngine;
import LambdaAppGui.LambdaView;
import LambdaAppGui.ReductionGui;

public class LambdaProgram {

    public static void main(String[] args) {
        LambdaAppEngine lambdaAppEngine = new LambdaAppEngine();

        LambdaView lambdaView = new ReductionGui(lambdaAppEngine);
        lambdaView.display();
    }
}
