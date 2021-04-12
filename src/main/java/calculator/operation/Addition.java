package calculator.operation;

public class Addition implements Operation {

    /**
     * Calculates the sum of two numbers.
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public double getResult(double a, double b) {
        return a + b;
    }
}