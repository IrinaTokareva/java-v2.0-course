import java.util.Scanner;

public class Task2 {

    /**
     * Main method. Executes calculator.
     * @param args command line parameters
     */
    public static void main(String[] args) {
        executeCalculator();
    }

    /**
     * Executes calculator.
     */
    public static void executeCalculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number:");
        double a = scanner.nextDouble();
        System.out.println("Enter the second number:");
        double b = scanner.nextDouble();
        System.out.println("Enter operation (+, -, *, /):");
        String operation = scanner.next();
        scanner.close();
        calculateAndPrint(a, b, operation);
    }

    /**
     * Calculates and prints the result of operation between two numbers
     * or prints certain message if operation is not implemented.
     * @param a first number
     * @param b second number
     * @param operation operation (+, -, * or /)
     */
    private static void calculateAndPrint(double a, double b, String operation) {
        if (operation.equals("+")) {
            System.out.printf("Result: %.4f\n", a + b);
        } else if (operation.equals("-")) {
            System.out.printf("Result: %.4f\n", a - b);
        } else if (operation.equals("*")) {
            System.out.printf("Result: %.4f\n", a * b);
        } else if (operation.equals("/")) {
            System.out.printf("Result: %.4f\n", a / b);
        } else {
            System.out.println("Entered operation is not implemented");
        }
    }
}