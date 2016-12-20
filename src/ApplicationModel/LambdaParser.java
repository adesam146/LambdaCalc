package ApplicationModel;

import LambdaTerm.LambdaTerm;

public interface LambdaParser {
    void add(LambdaTerm lambdaTerm);
    void removeLastInput();
    LambdaTerm parse();
}

