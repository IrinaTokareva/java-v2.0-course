package calculator.operation;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

@RunWith(JUnitParamsRunner.class)
public class OperationHandlerTest {

    @Test
    public void checkGetOperationsString() {
        Assert.assertEquals("+-*/", OperationHandler.getOperationsString());
    }

    @Test
    public void checkGetOperationsList() {
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("+");
        expectedResult.add("-");
        expectedResult.add("*");
        expectedResult.add("/");
        List<String> result = OperationHandler.getOperationsList();
        if (expectedResult.size() != result.size()) {
            Assert.fail("The length of operation list does not match expected");
        }
        for (String operation: expectedResult) {
            if (!result.contains(operation)) {
                Assert.fail("Operation list does not contain expected expected operation " + operation);
            }
        }
        Assert.assertTrue(true);
    }

    @Test
    @Parameters({
            "+, 1",
            "-, 1",
            "*, 2",
            "/, 2",
            "unknown, -1"
    })
    public void checkGetOperationPriority(String operation, int expectedPriority) {
        Assert.assertEquals(expectedPriority, OperationHandler.getOperationPriority(operation));
    }

    @Test
    @Parameters({
            "2.2, 2.0, +, 4.2",
            "2.2, 2.0, -, 0.2",
            "2.2, 2.0, *, 4.4",
            "2.2, 2.0, /, 1.1"
    })
    public void checkGetOperationResult(double a, double b, String operation, double expectedResult) {
        try {
            Assert.assertEquals(expectedResult, OperationHandler.getOperationResult(a, b, operation), 0.00000001);
        } catch (OperationNotSupportedException e) {
            Assert.fail("Operation " + operation + " should be supported");
        }
    }

    @Test
    public void checkThatGetOperationResultThrowsExceptionIfOperationIsUnknown() {
        Throwable e = null;
        try {
            OperationHandler.getOperationResult(1, 1, "unknown");
        } catch (Throwable ex) {
            e = ex;
        }
        Assert.assertTrue(e instanceof OperationNotSupportedException);
        Assert.assertEquals("Unsupported operation: unknown", e.getMessage());
    }
}