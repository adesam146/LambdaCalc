package LambdaAppUI;

import LambdaTerms.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Stream;

public class SimpleLambdaParser implements LambdaParser {

    private final LambdaView lambdaView;
    Deque<LambdaToken> lambdaTokens = new LinkedList<>();

    public SimpleLambdaParser(LambdaView lambdaView) {
        this.lambdaView = lambdaView;
    }

    @Override
    public void add(LambdaToken lambdaToken) {
        lambdaTokens.add(lambdaToken);
        notifyView();
    }

    @Override
    public void removeLastInput() {
        notifyView();
    }

    private void notifyView() {
        lambdaView.updateInputDisplay();
    }

    //as lambdaTokens is being used up this means parse() can't be called
    // consecutively
    @Override
    public LambdaTerm parse() {
        assert(!lambdaTokens.isEmpty()) : "No lambda terms to parse";

        return combineTerms(lambdaTokens);
    }

    @Override
    public Stream<LambdaToken> getTokens() {
        return lambdaTokens.stream();
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
