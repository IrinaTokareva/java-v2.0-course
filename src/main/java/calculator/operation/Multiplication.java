package calculator.operation;

public class Multiplication implements Operation {

    /**
     * Calculates the composition of two numbers.
     * @param a first number
     * @param b second number
     * @return composition of two numbers
     */
    public double getResult(double a, double b) {
        return a * b;
    }
}