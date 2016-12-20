package LambdaTerm;

/**
 * Created by User on 19/12/2016.
 */
public class LambdaAbstraction implements LambdaTerm {

    private final String variable;
    private final LambdaTerm returnTerm;

    public LambdaAbstraction(String variable, LambdaTerm returnTerm) {
        this.variable = variable;
        this.returnTerm = returnTerm;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LambdaAbstraction that = (LambdaAbstraction) o;

        if (variable != null && !variable.equals(that.variable) ||
                variable == null && that.variable != null){
            return false;
        }
        return returnTerm != null && returnTerm.equals(that.returnTerm)
                || returnTerm == null && that.returnTerm == null;

    }

    @Override
    public int hashCode() {
        int result = variable != null ? variable.hashCode() : 0;
        result = 31 * result + (returnTerm != null ? returnTerm.hashCode() : 0);
        return result;
    }
}
