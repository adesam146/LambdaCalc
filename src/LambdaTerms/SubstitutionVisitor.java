package LambdaTerms;

/**
 * Created by User on 21/12/2016.
 */
public class SubstitutionVisitor implements LambdaTermVisitor<LambdaTerm> {

    private LambdaVariable variableToBeReplaced;
    private LambdaTerm substitute;

    public SubstitutionVisitor(LambdaVariable variableToBeReplaced,
                               LambdaTerm substitute) {
        this.variableToBeReplaced = variableToBeReplaced;
        this.substitute = substitute;
    }

    public SubstitutionVisitor(String varToBeReplaced, LambdaTerm substitute) {
        this.variableToBeReplaced = new LambdaVariable(varToBeReplaced);
        this.substitute = substitute;
    }

    @Override
    public LambdaTerm visit(LambdaTerm lambdaTerm) {
        return lambdaTerm.accept(this);
    }

    @Override
    public LambdaTerm visitLambdaVariable(LambdaVariable lambdaVariable) {
        if(lambdaVariable.equals(variableToBeReplaced)) {
            return substitute;
        } else {
            return lambdaVariable;
        }
    }

    @Override
    public LambdaTerm visitLambdaApplication(LambdaApplication lambdaApplication) {
        LambdaTerm leftTerm = lambdaApplication.getLeftTerm();
        LambdaTerm rightTerm = lambdaApplication.getRightTerm();
        return new LambdaApplication(visit(leftTerm), visit(rightTerm));
    }

    @Override
    public LambdaTerm visitLambdaAbstraction(LambdaAbstraction lambdaAbstraction) {
        return null;
    }
}
