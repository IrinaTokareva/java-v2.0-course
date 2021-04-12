package calculator.operation;

public class Division implements Operation {

    /**
     * Calculates the quotient of two numbers.
     * @param a first number
     * @param b second number
     * @return the quotient of a and b
     * @throws ArithmeticException when b is zero
     */
    public double getResult(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}