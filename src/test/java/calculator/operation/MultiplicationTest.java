package calculator.operation;

import org.junit.Assert;
import org.junit.Test;

public class MultiplicationTest {

    @Test
    public void checkGetOperation() {
        Operation operation = new Multiplication();
        double a = 2.7;
        double b = 4.2;
        Assert.assertEquals(a * b, operation.getResult(a, b), 0.0);
    }
}