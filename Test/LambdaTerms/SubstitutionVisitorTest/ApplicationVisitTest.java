package LambdaTerms.SubstitutionVisitorTest;

import LambdaTerms.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by User on 21/12/2016.
 */
public class ApplicationVisitTest {

    private LambdaApplication applicationTerm;
    private LambdaTerm result;
    private String varToBeReplaced;
    private LambdaTerm expected;
    private SubstitutionVisitor substitutionVisitor;
    private LambdaTerm substitute;
    private String replacementVar;

    @Test
    public void canSubInVariableTermIntoSimpleApplication() {
        varToBeReplaced = "x";
        //(x y)
        applicationTerm = new LambdaApplication(new LambdaVariable
                (varToBeReplaced), new LambdaVariable("y"));

        substitute = new LambdaVariable("z");
        substitutionVisitor = new SubstitutionVisitor(varToBeReplaced,
                substitute);

        result = substitutionVisitor.visit(applicationTerm);

        //(z y)
        expected = new LambdaApplication(substitute, new
                LambdaVariable("y"));

        assertEquals(expected, result);
    }

    @Test
    public void canSubInAbstractionTermIntoSimpleApplication() {
        varToBeReplaced = "x";
        //(x y)
        applicationTerm = new LambdaApplication(new LambdaVariable
                (varToBeReplaced), new LambdaVariable("y"));

        //(\x. xx)
        substitute = new LambdaAbstraction("x", new LambdaApplication("x",
                "x"));
        substitutionVisitor = new SubstitutionVisitor(varToBeReplaced,
                substitute);

        result = substitutionVisitor.visit(applicationTerm);

        //((\x. xx) y)
        expected = new LambdaApplication(substitute, new
                LambdaVariable("y"));

        assertEquals(expected, result);
    }

    @Test
    public void canSubInApplicationTermIntoSimpleApplication() {
        varToBeReplaced = "x";
        //(x y)
        applicationTerm = new LambdaApplication(new LambdaVariable
                (varToBeReplaced), new LambdaVariable("y"));

        //(x y)
        substitute = new LambdaApplication("x", "x");
        substitutionVisitor = new SubstitutionVisitor(varToBeReplaced,
                substitute);

        result = substitutionVisitor.visit(applicationTerm);

        //((x x) y)
        expected = new LambdaApplication(substitute, new
                LambdaVariable("y"));

        assertEquals(expected, result);
    }

    @Test
    public void canSubInVariableTermIntoBothPartsOfTerm() {
        varToBeReplaced = "x";
        //(x x)
        applicationTerm = new LambdaApplication(new LambdaVariable
                (varToBeReplaced), new LambdaVariable(varToBeReplaced));

        replacementVar = "z";
        substitute = new LambdaVariable(replacementVar);

        substitutionVisitor = new SubstitutionVisitor(varToBeReplaced,
                substitute);

        result = substitutionVisitor.visit(applicationTerm);

        //(z z)
        expected = new LambdaApplication(substitute, substitute);

        assertEquals(expected, result);
    }
}
