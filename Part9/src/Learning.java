public class Learning
{
    /**
     * number of actions: n-1 prints
     * order of complexity: O(n)
     * @param n the input
     */
    public void method1(int n)
    {
        for (int j = 0; j < n; j++)
            System.out.print("*");
    }

    /**
     * number of actions: 100 prints
     * order of complexity: O(1)
     * @param n the input
     */
    public void method2(int n)
    {
        for (int j = 0; j < 100; j++)
            System.out.print("*");
    }

    /**
     * number of actions: 14n prints
     *הלולאה הפנימית עושה 14 הדפסות כאשר הלולאה החיצונית מפעילה אותה n פעמים
     * order of complexity: O(n)
     * @param n the input
     */
    public void method3(int n)
    {
        for (int i = 0; i < n; i++)
            for (int j = 1; j < 15; j++)
                System.out.print("*");
    }

    // The Two Color Flag //
    /**
     * number of actions: 4
     * order of complexity: O(1)
     * @param a the array to swap on
     * @param i the index of the first element
     * @param j the index of the other element
     */
    public static void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * number of actions: a lot
     * order of complexity: O(n)
     * @param a
     */
    public static void twoColorFlag2(int[] a)
    {
        int low = 0, high = a.length - 1;

        while (low < high)
        {
            if (a[low] == 0)
                low++;
            else if (a[high] == 1)
                high--;
            else
            {
                swap(a, low, high);
                low++;
                high--;
            }
        }
    }
    // End of The Two Color Flag //

    /**
     * number of actions:
     * order of complexity: O(n^2)
     * @param a the array to find in
     * @return the max subtraction
     */
    public static int method4(int[] a)
    {
        int temp = 0;

        for (int i = 0; i < a.length; i++)
            for (int j = i+1; j < a.length; j++)
                if (Math.abs(a[j] - a[i]) > temp)
                    temp = Math.abs(a[j] - a[i]);

        return temp;
    }

    /**
     * number of actions:
     * order of complexity: O(n)
     * @param a the array to find in
     * @return the max subtraction
     */
    public static int method4_Better(int[] a)
    {
        int min = a[0], max = a[0];

        for (int i = 1; i < a.length; i++)
        {
            if (a[i] < min)
                min = a[i];
            else if (a[i] > max)
                max = a[i];
        }

        return (max - min);
    }

    // order of complexity: O(n*log(n))
    public static boolean method5(int[] a, int num)
    {
        for (int i = 0; i < a.length; i++)
            if (BinarySearch.binarySearch(a, num - a[i]) != -1)
                return true;

        return false;
    }

    // order of complexity: O(n)
    public static boolean bestMethod5(int[] a, int num)
    {
        int left = 0, right = a.length - 1;

        while (left < right)
        {
            if (a[left] + a[right] == num)
                return true;
            else if (a[left] + a[right] > num)
                right--;
            else
                left++;
        }

        return false;
    }
}
