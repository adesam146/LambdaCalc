package ApplicationModel;

import LambdaTerms.*;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 19/12/2016.
 */
public class SimpleLambdaParserTest {

    private final SimpleLambdaParser lambdaParser = new SimpleLambdaParser();
    public static final String X_STR = "x";
    public static final String Y_STR = "y";

    @Test
    public void canParseOneVariableTerm() {
        lambdaParser.add(new VariableToken(X_STR));
        LambdaTerm outputLambdaTerm = lambdaParser.parse();

        LambdaVariable expectedTerm = new LambdaVariable(X_STR);
        assertEquals(expectedTerm, outputLambdaTerm);
    }

    @Test
    public void parsesAbstractionTermWithReturnTermProvided() {
        AbstractionToken abstractionToken = new AbstractionToken
                (X_STR);
        VariableToken variableTerm = new VariableToken(Y_STR);

        lambdaParser.add(abstractionToken);
        lambdaParser.add(variableTerm);
        LambdaTerm outputLambdaTerm = lambdaParser.parse();

        LambdaTerm expectedTerm = new LambdaAbstraction(X_STR, new
                LambdaVariable(Y_STR));

        assertEquals(expectedTerm, outputLambdaTerm);
    }

    @Test
    public void doesNotParseAbstractionTermWithNoReturnTerm() {

    }

    @Test
    public void canParseOneApplicationTerm() {
        VariableToken xToken = new VariableToken(X_STR);
        VariableToken yToken = new VariableToken(Y_STR);

        LambdaTerm expectedResult = new LambdaApplication(new LambdaVariable
                (X_STR), new LambdaVariable(Y_STR));

        lambdaParser.add(xToken);
        lambdaParser.add(yToken);
        LambdaTerm outputLambdaTerm = lambdaParser.parse();

        assertThat(outputLambdaTerm.toString(), is(expectedResult
                .toString()));
    }
}