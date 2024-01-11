public class BinarySearch
{
    public static int binarySearch(int[] ar, int key)
    {
        int low = 0, high = ar.length - 1, mid;

        while (low <= high)
        {
            mid = (low + high) / 2;

            if (ar[mid] == key)
                return mid;

            if (ar[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}
