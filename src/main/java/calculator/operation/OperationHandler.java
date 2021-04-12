package calculator.operation;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class OperationHandler {
    private static final String ADDITION = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";

    /**
     * Constructs string of operations.
     * @return string of operations
     */
    public static String getOperationsString() {
        return ADDITION + SUBTRACTION + MULTIPLICATION + DIVISION;
    }

    /**
     * Constructs list of operations.
     * @return list of operations
     */
    public static List<String> getOperationsList() {
        List<String> operations = new ArrayList<>();
        operations.add(ADDITION);
        operations.add(SUBTRACTION);
        operations.add(MULTIPLICATION);
        operations.add(DIVISION);
        return operations;
    }

    /**
     * Establishes operation priority for reversed polish notation algorithm.
     * @param operation operation
     * @return operation priority
     */
    public static int getOperationPriority(String operation) {
        switch (operation) {
            case ADDITION:
            case SUBTRACTION:
                return 1;
            case MULTIPLICATION:
            case DIVISION:
                return 2;
            default:
                return -1;
        }
    }

    /**
     * Calculates operation result by calling the method of the suitable implementation
     * of Operation interface.
     * @param a first number
     * @param b second number
     * @param operation operation
     * @return operation result
     * @throws OperationNotSupportedException when operation is not implemented
     */
    public static double getOperationResult(double a, double b, String operation)
            throws OperationNotSupportedException {
        Operation op;
        switch (operation) {
            case ADDITION:
                op = new Addition();
                break;
            case SUBTRACTION:
                op = new Subtraction();
                break;
            case MULTIPLICATION:
                op = new Multiplication();
                break;
            case DIVISION:
                op = new Division();
                break;
            default:
                throw new OperationNotSupportedException("Unsupported operation: " + operation);
        }
        return op.getResult(a, b);
    }
}