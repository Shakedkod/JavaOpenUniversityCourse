public class Sorting
{
    /**
     * time complexity order: n^2
     * @param ar the array to sort
     */
    public static void bubbleSort(int[] ar)
    {
        boolean swap = true;
        for (int i = ar.length - 1; (i > 0) && (swap); i--)
        {
            swap = false;
            for (int j = 0; j < i; j++)
            {
                if (ar[j] > ar[j+1])
                {
                    swap = true;
                    int temp = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = temp;
                }
            }
        }
    }

    /**
     * time complexity order: n^2
     * @param ar the array to sort
     */
    public static void selectionSort(int[] ar)
    {
        for (int i = 0; i < ar.length - 1; i++)
        {
            int smallest = i;
            for (int j = i + 1; j < ar.length; j++)
                if (ar[j] < ar[smallest])
                    smallest = j;

            if (smallest != i)
            {
                int temp = ar[smallest];
                ar[smallest] = ar[i];
                ar[i] = temp;
            }
        }
    }

    /**
     * time complexity order: n^2
     * @param ar the array to sort
     */
    public static void insertionSort(int[] ar)
    {
        int j;
        for (int i = 1; i < ar.length; i++)
        {
            int newest = ar[i];

            for (j = i-1; j >= 0 && ar[j] > newest; j--)
            {
                ar[j+1] = ar[j];
            }
            ar[j+1] = newest;
        }
    }
}
