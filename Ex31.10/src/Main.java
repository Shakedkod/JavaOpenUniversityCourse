public class Main
{
    public static int NextInt(String message)
    {
        System.out.print(message);
        return new java.util.Scanner(System.in).nextInt();
    }

    public static int[][] separateArray(int[] inputArray)
    {
        // a function that separates the array into two arrays
        // one for negative numbers and one for positive numbers
        // and returns a 2D array with the two arrays
        // input: an array of integers
        // output: a 2D array with two arrays of integers

        int[][] result = new int[2][inputArray.length];
        int negativeIndex = 0;
        int positiveIndex = 0;

        for (int num : inputArray)
        {
            System.out.println(num);
            if (num < 0)
            {
                result[0][negativeIndex] = num;
                negativeIndex++;
            }
            else
            {
                result[1][positiveIndex] = num;
                positiveIndex++;
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        // Get the array from the user
        int arrayLength = NextInt("Enter the number of numbers you want to enter: ");
        int[] inputArray = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++)
            inputArray[i] = NextInt("Enter number " + (i + 1) + ": ");

        // Separate the array
        int[][] result = separateArray(inputArray);

        // Print the result
        System.out.println("Negative numbers: ");
        for (int num : result[0])
            if (num != 0)
                System.out.print(num + " ");
        System.out.println();

        System.out.println("Positive numbers: ");
        for (int num : result[1])
            if (num != 0)
                System.out.print(num + " ");
        System.out.println();
    }
}