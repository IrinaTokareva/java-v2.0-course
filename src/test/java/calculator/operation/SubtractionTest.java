package calculator.operation;

import calculator.operation.Operation;
import calculator.operation.Subtraction;
import org.junit.Assert;
import org.junit.Test;

public class SubtractionTest {

    @Test
    public void testGetOperation() {
        Operation operation = new Subtraction();
        double a = 2.7;
        double b = 4.2;
        Assert.assertEquals(a - b, operation.getResult(a, b), 0.0);
    }
}