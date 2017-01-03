package LambdaAppUI;

import LambdaTerms.LambdaTerm;

import java.util.stream.Stream;

public interface LambdaParser {
    void add(LambdaToken lambdaToken);
    void removeLastInput();
    LambdaTerm parse();
    Stream<LambdaToken> getTokens();
}

