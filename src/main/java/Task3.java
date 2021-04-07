import java.util.Scanner;

public class Task3 {

    /**
     * Executes either calculator or search for the longest word in array
     * depending on value from console.
     * @param args command line parameters
     * @see Task2#executeCalculator()
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 for calculator and 2 for max length word search:");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Task2.executeCalculator();
                break;
            case 2:
                executeSearch();
                break;
            default:
                System.out.println("Wrong number. Restart program and enter either 1 or 2");
        }
        scanner.close();
    }

    /**
     * Searches for the longest word in an array. Prints that word and its length.
     */
    public static void executeSearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the array:");
        int length = scanner.nextInt();
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            System.out.printf("Enter word №%d:\n", i + 1);
            array[i] = scanner.next();
        }
        int maxLength = 0;
        String maxLengthWord = "";
        for (String word: array) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                maxLengthWord = word;
            }
        }
        System.out.printf("The word with the max length: %s\nIt's length: %d",
                maxLengthWord, maxLength);
    }
}
