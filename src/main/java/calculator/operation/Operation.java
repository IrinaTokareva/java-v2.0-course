package calculator.operation;

public interface Operation {

    /**
     * Calculates result of operation between two numbers.
     * @param a first number
     * @param b second number
     * @return operation result
     */
    double getResult(double a, double b);
}