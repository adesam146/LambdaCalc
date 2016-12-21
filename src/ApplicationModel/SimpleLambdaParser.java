package ApplicationModel;

import LambdaTerms.*;

import java.util.Deque;
import java.util.LinkedList;

public class SimpleLambdaParser implements LambdaParser {

    Deque<LambdaToken> lambdaTokens = new LinkedList<>();

    @Override
    public void add(LambdaToken lambdaToken) {
        lambdaTokens.add(lambdaToken);
    }

    @Override
    public void removeLastInput() {

    }

    //as lambdaTokens is being used up this means parse() can't be called
    // consecutively
    @Override
    public LambdaTerm parse() {
        assert(!lambdaTokens.isEmpty()) : "No lambda terms to parse";

        return combineTerms(lambdaTokens);
    }

    private LambdaTerm combineTerms(Deque<? extends LambdaToken> lambdaTokens) {
        LambdaToken firstToken = lambdaTokens.pollFirst();
        LambdaTerm result;
        if(!lambdaTokens.isEmpty()) {
            //this is the case where we either need to for an application
            // term or an abstraction term
            result = firstToken.compose(combineTerms(lambdaTokens));
        } else {
            //this is when we have a lone variable
            result = new LambdaVariable(firstToken.getText());
        }

        return result;
    }
}
