public class Ex13
{
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
}
