package LambdaTerms;

/**
 * Created by User on 21/12/2016.
 */
public interface LambdaTermVisitor<T> {

    T visit(LambdaTerm lambdaTerm);
    T visitLambdaVariable(LambdaVariable lambdaVariable);
    T visitLambdaApplication(LambdaApplication lambdaApplication);
    T visitLambdaAbstraction(LambdaAbstraction lambdaAbstraction);
}
