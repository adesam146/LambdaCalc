package LambdaTerms.SubstitutionVisitorTest;

import LambdaTerms.LambdaApplication;
import LambdaTerms.LambdaTerm;
import LambdaTerms.LambdaVariable;
import LambdaTerms.SubstitutionVisitor;
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
        applicationTerm = new LambdaApplication(new LambdaVariable
                (varToBeReplaced), new LambdaVariable("y"));

        substitute = new LambdaVariable("z");
        substitutionVisitor = new SubstitutionVisitor(varToBeReplaced,
                substitute);

        result = substitutionVisitor.visit(applicationTerm);

        expected = new LambdaApplication(new LambdaVariable("z"), new
                LambdaVariable("y"));

        assertEquals(expected, result);
    }

    @Test
    public void canSubInVariableTermIntoBothPartsOfTerm() {
        varToBeReplaced = "x";
        applicationTerm = new LambdaApplication(new LambdaVariable
                (varToBeReplaced), new LambdaVariable(varToBeReplaced));

        replacementVar = "z";
        substitute = new LambdaVariable(replacementVar);

        substitutionVisitor = new SubstitutionVisitor(varToBeReplaced,
                substitute);

        result = substitutionVisitor.visit(applicationTerm);

        expected = new LambdaApplication(new LambdaVariable(replacementVar), new
                LambdaVariable(replacementVar));

        assertEquals(expected, result);
    }
}
