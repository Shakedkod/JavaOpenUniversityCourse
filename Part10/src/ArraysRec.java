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

    public static int numberPaths(int x, int y)
    {
        if ((x == 0) && (y == 0))
            return 0;

        if ((x == 0) || (y == 0))
            return 1;

        return numberPaths(x - 1, y) + numberPaths(x, y - 1);
    }

    private static boolean sumNum(int[] a, int num, int i)
    {
        if (i == a.length)
            return false;

        if (a[i] == num)
            return true;

        return sumNum(a, num, i + 1) || sumNum(a, num - a[i], i + 1);
    }

    public static boolean sumNum(int[] a, int num)
    {
        return sumNum(a, num, 0);
    }

    public static boolean diffCharsByOne(String s1, String s2)
    {
        if (s1.length() != s2.length() || s1.length() == 0)
            return false;

        if (s1.charAt(0) != s2.charAt(0))
            return (s1.substring(1).equals(s2.substring(1)));

        return diffCharsByOne(s1.substring(1), s2.substring(1));
    }

    // שאלה 1 ביחידה 10.6
    private int[] _arr;

    private int equalSum(int i, int sumUntil, int sumForward)
    {
        if (i == _arr.length)
            return -1;

        sumUntil += _arr[i];
        sumForward -= _arr[i];

        if (sumUntil == sumForward)
            return i;

        return equalSum(i + 1, sumUntil, sumForward);
    }

    private int arraySum(int i)
    {
        if (_arr.length == i)
            return 0;

        return (_arr[i] + arraySum(i + 1));
    }

    public int equalSum()
    {
        return equalSum(0, 0, arraySum(0));
    }
}
