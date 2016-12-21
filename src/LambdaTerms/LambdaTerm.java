package LambdaTerms;

/**
 * Created by User on 19/12/2016.
 */
public interface LambdaTerm {

    //Chose to use a visitor which would essentially be a way to model any
    // operation that are usually done with LambdaTerms i.e. the lambdaTerm
    // shouldn't really care about concepts like alpha equivalence, beta
    // equivalence, substitution and others. Therefore as more concepts about
    // lambdaTerms are made we don't have to change each LambdaTerm. They are
    // essentially value objects.
    <T> T accept(LambdaTermVisitor<T> visitor);
}
