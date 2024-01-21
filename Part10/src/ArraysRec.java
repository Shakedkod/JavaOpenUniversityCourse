public class ArraysRec
{
    public static int recSum(int[] a, int i)
    {
        if (i == a.length)
            return 0;

        return (a[i] + recSum(a, i + 1));
    }

    public static void printRec(int[] a, int low, int high)
    {
        if (low <= high)
        {
            System.out.print(a[low] + "\t");
            printRec(a, low + 1, high);
        }
    }

    public static boolean recFind(int[] a, int x, int i)
    {
        if (i == a.length)
            return false;

        if (a[i] == x)
           return true;

        return recFind(a, x, i + 1);
    }

    public static int binarySearch(int[] a, int x, int low, int high)
    {
        if (high < low)
            return -1;

        int middle = (high + low) / 2;
        if (a[middle] == x)
            return middle;
        else if (a[middle] < x)
            return binarySearch(a, x, middle + 1, high);
        else
            return binarySearch(a, x, low, middle - 1);
    }

    public static int binarySearch(int[] a, int x)
    {
        return binarySearch(a, x, 0, a.length - 1);
    }

    public static boolean isPalindrome(int[] a, int low, int high)
    {
        if (low >= high)
            return true;

        if (a[low] != a[high])
            return false;

        return isPalindrome(a, low + 1, high - 1);
    }

    public static boolean isPalindrome(int[] a)
    {
        return isPalindrome(a, 0, a.length - 1);
    }

    // [Sunday, Monday, Tuesday, yadnoM, yadnuS] == true
    public static String reverseString(String s)
    {
        if (s.length() == 0)
            return "";

        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static boolean isStringPalindrome(String[] a, int low, int high)
    {
        if (low >= high)
            return true;

        if (!a[low].equals(reverseString(a[high])))
            return false;

        return isStringPalindrome(a, low + 1, high - 1);
    }

    public static boolean isStringPalindrome(String[] a)
    {
        return isStringPalindrome(a, 0, a.length - 1);
    }

    private static double multiply(double[] a, int i)
    {
        if (i == a.length)
            return 1;

        return a[i] * multiply(a, i + 1);
    }

    public static double multiply(double[] a)
    {
        return multiply(a, 0);
    }

    public static int recMax(int[] a, int i)
    {
        if (i == a.length - 1)
            return a[a.length - 1];

        int currentMax = recMax(a, i + 1);

        if (a[i] < currentMax)
            return currentMax;
        else
            return a[i];
    }

    public static int recMax(int[] a)
    {
        return recMax(a, 0);
    }

    public static int recMin(int[] a, int i)
    {
        if (i == a.length-1)
            return a.length - 1;

        int currMinInd = recMax(a, i + 1);

        if (a[i] > a[currMinInd])
            return currMinInd;
        else
            return i;
    }

    public static void selectionSort(int[] a, int i)
    {
        if (i == a.length - 1)
            return;

        int smallest = recMin(a, i);
        if (smallest != i)
        {
            int temp = a[smallest];
            a[smallest] = a[i];
            a[i] = temp;
        }

        selectionSort(a, i + 1);
    }

    public static void selectionSort(int[] a)
    {
        selectionSort(a, 0);
    }

    private static void swap(int[] a, int left, int right)
    {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    private static int partition(int[] a, int low, int high)
    {
        int left = low, right = high;
        int pivot = a[low];

        while (left < right)
        {
            while (left < right && a[left] <= pivot)
                left++;
            while (a[right] > pivot)
                right--;

            if (left < right)
                swap(a, left, right);
        }

        swap(a, low, right);
        return right;
    }

    private static void quickSort(int[] a, int low, int high)
    {
        if (low < high)
        {
            int m = partition(a, low, high);
            quickSort(a, low, m - 1);
            quickSort(a, m + 1, high);
        }
    }

    // O(n*log(n))
    public static void quickSort(int[] a)
    {
        quickSort(a, 0, a.length - 1);
    }
}
