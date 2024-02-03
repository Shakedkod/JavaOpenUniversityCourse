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
            {
                arrayThirdLargest = arraySecondLargest;
                arraySecondLargest = arrayMax;
                arrayMax = arr[i];
            }
            else if (arr[i] > arraySecondLargest)
            {
                arrayThirdLargest = arraySecondLargest;
                arraySecondLargest = arr[i];
            }
            else if (arr[i] > arrayThirdLargest)
            {
                arrayThirdLargest = arr[i];
            }

            if (arr[i] < arrayMin)
            {
                arraySecondSmallest = arrayMin;
                arrayMin = arr[i];
            }
            else if (arr[i] < arraySecondSmallest)
            {
                arraySecondSmallest = arr[i];
            }
        }

        int maxMultiply = arrayMax * arraySecondLargest * arrayThirdLargest;
        int maxMinusMultiply = arrayMin * arraySecondSmallest * arrayMax;

        return Math.max(maxMultiply, maxMinusMultiply);
    }

    /**
     * Q2 FUNCTION
     * this function finds the median of the combination of 2 arrays given.
     *
     * TIME COMPLEXITY: O(n) - the function will run one loop that goes throw the length of the two arrays divided by
     *                          2, with means, the length of 1 array or n.
     * SPACE COMPLEXITY: O(1) - all the var defined in the function are not dependent on the length of the arrays.
     *
     * @param arr1 the first array
     * @param arr2 the second array
     * @return the median.
     */
    public static int findMedian(int[] arr1, int[] arr2)
    {
        // Binary Search
        int low = 0, high = arr1.length;

        while (low <= high)
        {
            int partitionX = (low + high) / 2;
            int partitionY = (arr1.length * 2 + 1) / 2 - partitionX;

            int leftArr1 = (partitionX == 0) ? Integer.MIN_VALUE : arr1[partitionX - 1];
            int rightArr1 = (partitionX == arr1.length) ? Integer.MAX_VALUE : arr1[partitionX];
            int leftArr2 = (partitionY == 0) ? Integer.MIN_VALUE : arr2[partitionY - 1];
            int rightArr2 = (partitionY == arr2.length) ? Integer.MAX_VALUE : arr2[partitionY];

            if (leftArr1 <= rightArr2 && leftArr2 <= rightArr1)
                if ((arr1.length + arr2.length) % 2 == 0)
                    return (Math.max(leftArr1, leftArr2) + Math.min(rightArr1, rightArr2)) / 2;
                else
                    return Math.max(leftArr1, leftArr2);
            else if (leftArr1 > rightArr2)
                high = partitionX - 1;
            else
                low = partitionX + 1;
        }

        return Integer.MIN_VALUE; // the func will get here only if the arrays aren't sorted witch isn't espoused to
        // happen in this exercise, but it won't compile otherwise.
    }

    /**
     * Q3 FUNCTION
     * This function creates a string that the two strings given are included in.
     *
     * @param st1 the first string to be included.
     * @param st2 the second string to be included.
     * @return the string that the two strings given are included in.
     */
    public static String minimalSt(String st1, String st2)
    {
        // Stopping points
        if (st1.length() == 0)
            return st2;

        if (st2.length() == 0)
            return st1;

        // Recursion
        if (st1.charAt(0) == st2.charAt(0))
            return st1.charAt(0) + minimalSt(st1.substring(1), st2.substring(1));

        String st3 = st1.charAt(0) + minimalSt(st1.substring(1), st2);
        String st4 = st2.charAt(0) + minimalSt(st1, st2.substring(1));

        return st3.length() > st4.length() ? st4 : st3;
    }

    private static int maxSnake(int[][] mat, int row, int colum, int beforeValue)
    {
        if (row == (mat.length - 1 )&& colum == (mat[0].length - 1)) // STOPPING - if the snake is on its last item.
            return 1;

        if (row > (mat.length - 1) || row < 0 || colum > (mat[0].length - 1) || colum < 0) // if the snake is out of the array
            return Integer.MIN_VALUE;

        if (mat[row][colum] == 0) // if the snake is on the tile it had been before
            return Integer.MIN_VALUE;

        if (Math.abs(mat[row][colum] - beforeValue) > 1) // the fourth rule of the snake
            return Integer.MIN_VALUE;

        int temp = mat[row][colum];
        mat[row][colum] = 0;

        int longestPath = 1 + Math.max(
                maxSnake(mat, row + 1, colum, temp), // one up
                Math.max(
                        maxSnake(mat, row - 1, colum, temp), // one down
                        Math.max(
                                maxSnake(mat, row, colum + 1, temp), // one right
                                maxSnake(mat, row, colum - 1, temp)  // one left
                        )
                )
        );

        mat[row][colum] = temp;
        return longestPath;
    }

    /**
     * Q4 FUNCTION
     * this function calculates the longest "snake route" throw an array.
     *
     * @param mat the array in witch the "snake route" will exist.
     * @return the length of the "snake route".
     */
    public static int maxSnake(int[][] mat)
    {
        int result = maxSnake(mat, 0, 0, mat[0][0]);

        if (result == 0) // if there isn't a route
            return Integer.MIN_VALUE;

        return result;
    }
}
