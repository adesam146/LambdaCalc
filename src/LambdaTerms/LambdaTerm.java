package LambdaTerms;

public interface LambdaTerm {

    /*LambdaTerm is used here for the second argument as we might perhaps in
    the future want to replace not just variable terms*/
    void substitution(LambdaTerm substitute, LambdaTerm toBeReplaced);

    void substitution(LambdaTerm substitute, String varToBeReplaced);

    /* A visitor in this case might be some kind of specialized operation on
     LambdaTerms that isn't common*/
    <T> T accept(LambdaTermVisitor<T> visitor);
}
