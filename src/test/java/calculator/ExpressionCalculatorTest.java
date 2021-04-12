package calculator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.naming.OperationNotSupportedException;
import java.text.ParseException;

@RunWith(JUnitParamsRunner.class)
public class ExpressionCalculatorTest {

    @Test
    @Parameters({
            "2+ 2, 4",
            "3 * 4 - 9 / 3 * 1.5 + 2, 9.5",
            "3*4-(9/3*1.5+2), 5.5",
            "-3+4.1, 1.1",
            "2.2*13-(-3.7+3), 29.3",
            "1 2 3 + 11, 134"
    })
    public void checkThatCalculateReturnsCorrectResultForCorrectExpression(String expression,
                                                                           double expectedResult) {
        try {
            Assert.assertEquals(expectedResult,
                    new ExpressionCalculator().calculate(expression),  0.00000001);
        } catch (OperationNotSupportedException | ParseException e) {
            Assert.fail("Method should not throw exception. Exception class: "
                    + e.getClass() + ". Exception message: " + e.getMessage());
        }
    }

    @Test
    @Parameters({
            ")11+1, class java.text.ParseException, Brackets do not match",
            "(3+4)-6*2)+2, class java.text.ParseException, Brackets do not match",
            "1+((2+4)-6*7, class java.text.ParseException, Brackets do not match",
            "(1+2)^2-9, class java.text.ParseException, Unrecognized part: ^2",
            "1+3*6 operator 7, class java.text.ParseException, Unrecognized part: 6operator7",
            "3+4*6-9/-3, class java.text.ParseException, Expression is invalid",
            "(1+2)-(3)(4), class java.text.ParseException, Expression is invalid",
            "(3+6/0)*2-7, class java.lang.ArithmeticException, Division by zero"
    })
    public void checkThatCalculateThrowsParseExceptionWhenExpressionIsInvalid(
            String expression, String exceptionClass, String exceptionMessage) {
        Throwable e = null;
        try {
            new ExpressionCalculator().calculate(expression);
        } catch (Throwable ex) {
            e = ex;
        }
        Assert.assertNotNull(e);
        Assert.assertEquals(exceptionClass, e.getClass().toString());
        Assert.assertEquals(exceptionMessage, e.getMessage());
    }
}