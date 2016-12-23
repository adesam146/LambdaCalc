package LambdaTerms.SubstitutionVisitorTest;

import LambdaTerms.*;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by User on 21/12/2016.
 */
public class ApplicationVisitTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    private LambdaApplication applicationTerm;
    private LambdaTerm actual;
    private String varToBeReplaced;
    private LambdaTerm expected;
    private SubstitutionVisitor substitutionVisitor;
    private LambdaTerm substitute;

    @Test
    public void canSubInVariableTermIntoSimpleApplication() {
        varToBeReplaced = "x";
        //(x y)
        applicationTerm = new LambdaApplication(new LambdaVariable
                (varToBeReplaced), new LambdaVariable("y"));

        substitute = new LambdaVariable("z");
        substitutionVisitor = new SubstitutionVisitor(varToBeReplaced,
                substitute);

        actual = substitutionVisitor.visit(applicationTerm);

        //(z y)
        expected = new LambdaApplication(substitute, new
                LambdaVariable("y"));

        assertEquals(expected, actual);
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

        actual = substitutionVisitor.visit(applicationTerm);

        //((\x. xx) y)
        expected = new LambdaApplication(substitute, new
                LambdaVariable("y"));

        assertEquals(expected, actual);
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

        actual = substitutionVisitor.visit(applicationTerm);

        //((x x) y)
        expected = new LambdaApplication(substitute, new
                LambdaVariable("y"));

        assertEquals(expected, actual);
    }

    @Test
    public void canSubInVariableTermIntoBothPartsOfTerm() {
        varToBeReplaced = "x";
        //(x x)
        applicationTerm = new LambdaApplication(new LambdaVariable
                (varToBeReplaced), new LambdaVariable(varToBeReplaced));

        // z
        substitute = new LambdaVariable("z");

        substitutionVisitor = new SubstitutionVisitor(varToBeReplaced,
                substitute);

        actual = substitutionVisitor.visit(applicationTerm);

        //(z z)
        expected = new LambdaApplication(substitute, substitute);

        assertEquals(expected, actual);
    }

    @Test
    public void visitsBothPartOfApplicationTerm() {
        //JMock seems to only allow one mockery of an interface
        LambdaTerm mockTerm = context.mock(LambdaTerm.class);
        applicationTerm = new LambdaApplication(mockTerm, mockTerm);

        //These don't really matter
        varToBeReplaced = "x";
        substitute = new LambdaVariable("z");
        substitutionVisitor = new SubstitutionVisitor(varToBeReplaced,
                substitute);

        context.checking(new Expectations() {{
            //The return value doesn't matter
            exactly(2).of(mockTerm).accept(substitutionVisitor); will
                    (returnValue(new LambdaVariable("x")));
        }});

        substitutionVisitor.visit(applicationTerm);
    }
}
