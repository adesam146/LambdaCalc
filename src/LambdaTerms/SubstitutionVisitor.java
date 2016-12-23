package LambdaTerms;

/**
 * Created by User on 21/12/2016.
 */
public class SubstitutionVisitor implements LambdaTermVisitor<LambdaTerm> {

    private LambdaVariable varTermToBeReplaced;
    private LambdaTerm substitute;

    public SubstitutionVisitor(LambdaVariable varTermToBeReplaced,
                               LambdaTerm substitute) {
        this.varTermToBeReplaced = varTermToBeReplaced;
        this.substitute = substitute;
    }

    public SubstitutionVisitor(String varToBeReplaced, LambdaTerm substitute) {
        this.varTermToBeReplaced = new LambdaVariable(varToBeReplaced);
        this.substitute = substitute;
    }

    @Override
    public LambdaTerm visit(LambdaTerm lambdaTerm) {
        return lambdaTerm.accept(this);
    }

    @Override
    public LambdaTerm visitLambdaVariable(LambdaVariable lambdaVariable) {
        if(lambdaVariable.equals(varTermToBeReplaced)) {
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
        LambdaVariable bindingVarTerm = new LambdaVariable(lambdaAbstraction
                .getVariable());
        if(bindingVarTerm.equals(varTermToBeReplaced)) {
            return lambdaAbstraction;
        }

        return null;
    }
}
