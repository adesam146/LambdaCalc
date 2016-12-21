package LambdaTerms.SubstitutionVisitorTest;

import LambdaTerms.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 21/12/2016.
 */
public class VariableVisitTest {

    private final String X_VAR = "x";
    private final LambdaVariable variableTerm = new LambdaVariable(X_VAR);
    private SubstitutionVisitor substitutionVisitor;
    private LambdaTerm result;
    private LambdaTerm substitute;
    private LambdaTerm expected;

    @Test
    public void canSubstituteInVariableTerm() {
        substitute = new LambdaVariable("y");
        substitutionVisitor = new SubstitutionVisitor(new LambdaVariable(X_VAR),
                substitute);

        result = variableTerm.accept(substitutionVisitor);

        expected = substitute;

        assertEquals(expected, result);
    }

    @Test
    public void canSubstituteInAbstractionTerm() {
        substitute = new LambdaAbstraction("y", new LambdaVariable("z"));
        substitutionVisitor = new SubstitutionVisitor(X_VAR,
                substitute);

        result = variableTerm.accept(substitutionVisitor);

        expected = substitute;

        assertEquals(expected, result);
    }

    @Test
    public void canSubstituteInApplicationTerm() {
        LambdaTerm substitute = new LambdaApplication(new LambdaVariable("y")
                , new LambdaVariable("z"));

        substitutionVisitor = new SubstitutionVisitor(X_VAR, substitute);

        result = variableTerm.accept(substitutionVisitor);

        expected = substitute;

        assertEquals(expected, result);
    }


    @Test
    public void noSubMadeIfVarToBeReplacedDoesNotEqualLambdaVariable() {
        LambdaTerm substitute = new LambdaAbstraction("y", new LambdaVariable
                ("z"));

        String varToReplace = "u";
        substitutionVisitor = new SubstitutionVisitor(varToReplace, substitute);

        result = variableTerm.accept(substitutionVisitor);

        expected = variableTerm;
        assertEquals(expected, result);
    }

}