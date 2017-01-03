package ApplicationModel;

import LambdaAppUI.AbstractionToken;
import LambdaAppUI.LambdaView;
import LambdaAppUI.SimpleLambdaParser;
import LambdaAppUI.VariableToken;
import LambdaTerms.*;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import java.util.stream.Collectors;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 19/12/2016.
 */
public class SimpleLambdaParserTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    LambdaView lambdaView = context.mock(LambdaView.class);

    private final SimpleLambdaParser lambdaParser = new SimpleLambdaParser
            (lambdaView);
    public static final String X_STR = "x";
    public static final String Y_STR = "y";
    private int numOfUpdatesToView;

    @Test
    public void viewUpdateWhenTokenAdded() {
        numOfUpdatesToView = 1;
        viewUpdatedOnceExpectation(numOfUpdatesToView);

        lambdaParser.add(new VariableToken("x"));
    }

    @Test
    public void viewUpdateWhenTokenRemoved() {
        numOfUpdatesToView = 1;
       viewUpdatedOnceExpectation(numOfUpdatesToView);

        lambdaParser.removeLastInput();
    }

    private void viewUpdatedOnceExpectation(int numberOfUpdates) {
        context.checking(new Expectations() {{
            exactly(numberOfUpdates).of(lambdaView).updateInputDisplay();
        }});
    }

    @Test
    public void canParseOneVariableTerm() {
        numOfUpdatesToView = 1;
        viewUpdatedOnceExpectation(numOfUpdatesToView);

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

        numOfUpdatesToView = 2;
        viewUpdatedOnceExpectation(numOfUpdatesToView);

        lambdaParser.add(abstractionToken);
        lambdaParser.add(variableTerm);
        LambdaTerm outputLambdaTerm = lambdaParser.parse();

        LambdaTerm expectedTerm = new LambdaAbstraction(X_STR, new
                LambdaVariable(Y_STR));


        assertEquals(expectedTerm, outputLambdaTerm);
    }

    @Test
    public void canGetTokensInTheOrderOfInput() {
        VariableToken xToken = new VariableToken(X_STR);
        AbstractionToken abstractionToken = new AbstractionToken
                (X_STR);
        VariableToken yToken = new VariableToken(Y_STR);

        viewUpdatedOnceExpectation(3);

        lambdaParser.add(xToken);
        lambdaParser.add(abstractionToken);
        lambdaParser.add(yToken);

        assertThat(lambdaParser.getTokens().collect(Collectors.toList()),
                contains(xToken, abstractionToken, yToken));
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

        numOfUpdatesToView = 2;
        viewUpdatedOnceExpectation(numOfUpdatesToView);

        lambdaParser.add(xToken);
        lambdaParser.add(yToken);
        LambdaTerm outputLambdaTerm = lambdaParser.parse();


        assertThat(outputLambdaTerm.toString(), is(expectedResult
                .toString()));
    }
}