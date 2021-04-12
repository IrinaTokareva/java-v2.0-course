package calculator;

import calculator.operation.OperationHandler;
import javax.naming.OperationNotSupportedException;
import java.text.ParseException;
import java.util.Stack;
import java.util.StringTokenizer;

public class ExpressionCalculator {

    /**
     * Calculates expression result using reversed polish notation algorithm.
     * @param expression arithmetic expression that can contain brackets
     *                  and any of the implemented operation
     * @return Expression result
     * @throws OperationNotSupportedException when expression contains
     * unimplemented operation. Is never actually thrown, because before
     * result is calculated expression is checked for any unknown characters
     * @throws ParseException when expression is incorrect (i.e. brackets do not match,
     * expression has unknown characters)
     * @throws ArithmeticException when expression contains division by zero
     * @see <a href="https://habr.com/ru/post/282379/">https://habr.com/ru/post/282379/</a>
     */
    public double calculate(String expression)
            throws OperationNotSupportedException, ParseException, ArithmeticException {
        Stack<Double> result = new Stack<>();
        for (String element: parse(expression)) {
            try {
                result.push(Double.parseDouble(element));
            } catch (NumberFormatException e) {
                // if element is not a number then it's a binary operator
                if (result.size() < 2) {
                    throw new ParseException("Expression is invalid", 0);
                }
                double b = result.pop();
                result.push(OperationHandler.getOperationResult(result.pop(), b, element));
            }
        }
        if (result.size() != 1) {
            throw new ParseException("Expression is invalid", 0);
        }
        return result.pop();
    }

    private Stack<String> parse(String infix) throws ParseException {
        infix = infix.replaceAll("\\s+", "");
        Stack<String> postfix = new Stack<>();
        Stack<String> operationsStack = new Stack<>();
        String delimiters = "()" + OperationHandler.getOperationsString();
        StringTokenizer tokenizer = new StringTokenizer(infix, delimiters, true);
        String current;
        String prev = "";
        while (tokenizer.hasMoreTokens()) {
            current = tokenizer.nextToken();
            if (isUnaryMinus(current, prev)) {
                current = "-" + tokenizer.nextToken();
            }
            processToken(current, operationsStack, postfix);
            prev = current;
        }
        processRestOfOperationStack(operationsStack, postfix);
        System.out.println("Parsed expression (reversed polish notation): " + postfix.toString());
        return postfix;
    }

    private boolean isUnaryMinus(String current, String prev) {
        return current.equals("-") && (prev.equals("") || prev.equals("("));
    }

    private void processToken(String current, Stack<String> operationsStack,
                                     Stack<String> postfix) throws ParseException {
        if (current.equals("(")) {
            operationsStack.push(current);
        } else if (current.equals(")")) {
            processClosingBracket(operationsStack, postfix);
        } else if (OperationHandler.getOperationsList().contains(current)) {
            processOperation(current, operationsStack, postfix);
        } else {
            processNumber(current, postfix);
        }
    }

    private void processClosingBracket(Stack<String> operationsStack,
                                              Stack<String> postfix) throws ParseException {
        if (!operationsStack.contains("(")) {
            throw new ParseException("Brackets do not match", 0);
        }
        while (!operationsStack.peek().equals("(")) {
            postfix.push(operationsStack.pop());
        }
        operationsStack.pop();
    }

    private void processOperation(String current, Stack<String> operationsStack,
                                         Stack<String> postfix) {
        while (!operationsStack.isEmpty()
                && OperationHandler.getOperationPriority(operationsStack.peek())
                >= OperationHandler.getOperationPriority(current)) {
            postfix.push(operationsStack.pop());
        }
        operationsStack.push(current);
    }

    private void processNumber(String current, Stack<String> postfix) throws ParseException {
        try {
            Double.parseDouble(current);
        } catch (Exception e) {
            throw new ParseException("Unrecognized part: " + current, 0);
        }
        postfix.push(current);
    }

    private void processRestOfOperationStack(Stack<String> operationsStack,
                                                    Stack<String> postfix) throws ParseException {
        while (!operationsStack.isEmpty()) {
            postfix.push(operationsStack.pop());
        }
        if (postfix.contains("(") || postfix.contains(")")) {
            throw new ParseException("Brackets do not match", 0);
        }
    }
}