import java.util.Arrays;
import java.util.Random;

public class Task4_1 {

    public static void main(String[] args) {
        int length = 20;
        int from = -10;
        int to = 10;
        int[] array = createAndFillArray(length, from, to);
        System.out.println("Initial array: ");
        System.out.println(Arrays.toString(array));
        findAndSwitch(array, length, from, to);
        System.out.println("Array where first minimum positive and " +
                "first maximum negative elements are switched:");
        System.out.println(Arrays.toString(array));
    }

    /**
     * Creates array of integers and fills it with random values from -10 to 10.
     * @param length array length
     * @param from all values in array are greater than this value
     * @param to all values in array are lesser than this value
     * @return created array
     */
    private static int[] createAndFillArray(int length, int from, int to) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Random().nextInt(to - from) + from;
        }
        return array;
    }

    /**
     * Finds first minimum positive and first maximum negative elements
     * in array and switches them.
     * @param array array
     * @param length array length
     * @param from all values in array are greater than this value
     * @param to all values in array are lesser than this value
     */
    private static void findAndSwitch(int[] array, int length, int from, int to) {
        int maxNegative = from - 1;
        int maxNegativeIndex = 0;
        int minPositive = to + 1;
        int minPositiveIndex = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] < 0 && maxNegative < array[i]) {
                maxNegative = array[i];
                maxNegativeIndex = i;
            }
            if (array[i] > 0 && minPositive > array[i]) {
                minPositive = array[i];
                minPositiveIndex = i;
            }
        }
        int tmp = array[maxNegativeIndex];
        array[maxNegativeIndex] = array[minPositiveIndex];
        array[minPositiveIndex] = tmp;
    }
}
