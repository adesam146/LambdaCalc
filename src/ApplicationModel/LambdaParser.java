package ApplicationModel;

import LambdaTerms.LambdaTerm;

public interface LambdaParser {
    void add(LambdaToken lambdaToken);
    void removeLastInput();
    LambdaTerm parse();
}

