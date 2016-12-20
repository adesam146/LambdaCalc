package ApplicationModel;

import LambdaTerm.*;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 19/12/2016.
 */
public class SimpleLambdaParserTest {

    private final SimpleLambdaParser lambdaParser = new SimpleLambdaParser();

    @Test
    public void canParseOneVariableTerm() {
        Variable inputVariableTerm = new Variable("x");
        lambdaParser.add(inputVariableTerm);
        LambdaTerm outputLambdaTerm = lambdaParser.parse();

        assertThat(inputVariableTerm.toString(), is(outputLambdaTerm.toString
                ()));
    }

    //Should actually be that it doesn't parse it.
//    @Test
//    public void canParseOneAbstractionTerm() {
//        LambdaTerm inputAbstractionTerm = new LambdaAbstraction("x");
//        lambdaParser.add(inputAbstractionTerm);
//        LambdaTerm outputLambdaTerm = lambdaParser.parse();
//
//        assertThat(inputAbstractionTerm.toString(), is(outputLambdaTerm
//                .toString()));
//    }

    @Test
    public void canParseOneApplicationTerm() {
        Variable x = new Variable("x");
        Variable y = new Variable("y");

        LambdaTerm expectedResult = new LambdaApplication(x, y);

        lambdaParser.add(x);
        lambdaParser.add(y);
        LambdaTerm outputLambdaTerm = lambdaParser.parse();

        assertThat(outputLambdaTerm.toString(), is(expectedResult
                .toString()));
    }
}