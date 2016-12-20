package ApplicationModel;

import LambdaTerm.LambdaTerm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by User on 19/12/2016.
 */
public class SimpleLambdaParser implements LambdaParser {

    Deque<LambdaTerm> lambdaTerms = new LinkedList<>();

    @Override
    public void add(LambdaTerm lambdaTerm) {
        lambdaTerms.add(lambdaTerm);
    }

    @Override
    public void removeLastInput() {

    }

    //as lambdaTerms is being used up this means parse() can't be called
    // consecutively
    @Override
    public LambdaTerm parse() {
        assert(!lambdaTerms.isEmpty()) : "No lambda terms to parse";

        return combineTerms(lambdaTerms);
    }

    private LambdaTerm combineTerms(Deque<? extends LambdaTerm> lambdaTerms) {
        LambdaTerm result = lambdaTerms.pollFirst();
        if(!lambdaTerms.isEmpty()) {
            result = result.compose(combineTerms(lambdaTerms));
        }

        return result;
    }
}
