package calculator.operation;

import org.junit.Assert;
import org.junit.Test;

public class DivisionTest {

    @Test
    public void checkGetOperationWithCorrectParams() {
        Operation operation = new Division();
        double a = 2.7;
        double b = 4.2;
        Assert.assertEquals(a / b, operation.getResult(a, b), 0.0);
    }

    @Test
    public void checkThatGetOperationThrowsExceptionIfSecondParamIsZero() {
        Operation operation = new Division();
        double a = 2.7;
        double b = 0;
        Throwable e = null;
        try {
            operation.getResult(a, b);
        } catch (Throwable ex) {
            e = ex;
        }
        Assert.assertTrue(e instanceof ArithmeticException);
        Assert.assertEquals("Division by zero", e.getMessage());
    }
}