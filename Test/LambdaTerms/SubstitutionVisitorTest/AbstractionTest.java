package LambdaTerms.SubstitutionVisitorTest;

import LambdaTerms.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by User on 23/12/2016.
 */
public class AbstractionTest {

    private LambdaAbstraction abstractionTerm;
    private LambdaTerm actual;
    private String varToBeReplaced;
    private LambdaTerm expected;
    private SubstitutionVisitor substitutionVisitor;
    private LambdaTerm substitute;

    @Test
    public void doesNotReplaceBoundVariables() {
        varToBeReplaced = "x";
        abstractionTerm = new LambdaAbstraction(varToBeReplaced, new
                LambdaApplication(varToBeReplaced, "y"));

        substitute = new LambdaVariable("z");
        substitutionVisitor = new SubstitutionVisitor(varToBeReplaced,
                substitute);

        actual = substitutionVisitor.visit(abstractionTerm);

        expected = abstractionTerm;

        assertEquals(expected, actual);
    }
}
