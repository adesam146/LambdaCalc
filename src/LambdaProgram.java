import ApplicationModel.LambdaParser;
import LambdaAppGui.LambdaView;
import LambdaAppGui.ReductionGui;
import LambdaTerm.LambdaTerm;

public class LambdaProgram {

    public static void main(String[] args) {
        LambdaParser lambdaParser = new LambdaParser() {
            @Override
            public void parse(LambdaTerm lambdaTerm) {

            }
        };

        LambdaView lambdaView = new ReductionGui(lambdaParser);
        lambdaView.display();
    }
}
