package calculator;

import javax.naming.OperationNotSupportedException;
import java.text.ParseException;
import java.util.Scanner;

public class CalculatorMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter arithmetic expression (use only +,-,*,/,(,)):");
        String expression = scanner.nextLine();
        try {
            System.out.printf("Result: %.4f\n", new ExpressionCalculator().calculate(expression));
        } catch (OperationNotSupportedException | ParseException | ArithmeticException e) {
            System.err.println(e.getMessage());
        }
    }
}
