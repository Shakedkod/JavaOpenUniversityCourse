/**
 * This class contains the methods of the Java course MMN13.
 *
 * ID: 216590125
 * @author Shaked Kodman Kolran
 * @version 25-1-24
 */
public class Ex13
{
    /**
     * Q1 FUNCTION
     * This functions calculates the largest multiplication in the array.
     *
     * TIME COMPLEXITY: O(n) - the function has one loop that goes over the whole array.
     * SPACE COMPLEXITY: O(1) - all the variables that the function creates are primitive types(int) and not influenced by the array size(n).
     *
     * @param arr the array that the numbers for the multiplication will be taken from
     * @return the result of the multiplication
     */
    public static int maxMult3(int[] arr)
    {
        if (arr.length < 3)
            return Integer.MIN_VALUE;

        int arrayMax = Integer.MIN_VALUE, arraySecondLargest = Integer.MIN_VALUE, arrayThirdLargest = Integer.MIN_VALUE;
        int arrayMin = Integer.MAX_VALUE, arraySecondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] > arrayMax)
                arrayMax = arr[i];
            else if (arr[i] > arraySecondLargest)
                arraySecondLargest = arr[i];
            else if (arr[i] > arrayThirdLargest)
                arrayThirdLargest = arr[i];
            else if (arr[i] < arrayMin)
                arrayMin = arr[i];
            else if (arr[i] < arraySecondSmallest)
                arraySecondSmallest = arr[i];
        }

        int maxMultiply = arrayMax * arraySecondLargest * arrayThirdLargest;
        int maxMinusMultiply = arrayMin * arraySecondSmallest * arrayMax;

        return Math.max(maxMultiply, maxMinusMultiply);
    }

    /**
     * Q3 FUNCTION
     * TODO
     *
     * TIME COMPLEXITY: TODO
     * SPACE COMPLEXITY: TODO
     *
     * @param st1 TODO
     * @param st2 TODO
     * @return TODO
     */
    public static String minimalSt(String st1, String st2)
    {
        if (st1.length() == 0 && st2.length() == 0)
            return "";

        if (st1.length() == 0)
            return st2.charAt(0) + minimalSt("", st2.substring(1));

        if (st2.length() == 0)
            return st1.charAt(0) + minimalSt(st1.substring(1), "");

        // TODO: this is also problematic
        if (st1.charAt(0) == st2.charAt(0))
            return st1.charAt(0) + minimalSt(st1.substring(1), st2.substring(1));

        // TODO: it doesn't fully work, but its a good start
        return st1.charAt(0) + st2.charAt(0) + minimalSt(st1.substring(1), st2.substring(1));
    }
}
