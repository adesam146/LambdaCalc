package ApplicationModel;

import LambdaTerm.LambdaTerm;

public interface LambdaParser {
    void add(LambdaToken lambdaToken);
    void removeLastInput();
    LambdaTerm parse();
}

