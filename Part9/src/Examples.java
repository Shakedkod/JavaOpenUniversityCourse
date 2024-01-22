public class Examples
{
    // O(n^2)
    public static int halfSumDefault(int[] a)
    {
        int sumA = 0, sumB = 0;
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < i; j++) {
                sumA += a[j];
            }

            for (int j = i; j < a.length; j++) {
                sumB += a[j];
            }

            if (sumA == sumB)
                return i;
        }

        return -1;
    }

    // O(n)
    public static int halfSumBetter(int[] a)
    {
        int arSum = 0, sum = 0;

        for (int i = 0; i < a.length; i++) {
            arSum += a[i];
        }

        for (int i = 0; i < a.length; i++) {
            sum += a[i];

            if (sum * 2 == arSum)
                return i;
            if (sum * 2 > arSum)
                return -1;
        }

        return -1;
    }

    private static int sumOfDivisorsLinearComplexity(int number)
    {
        if(number>=1)
            return 0;

        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0)
                sum += i;
        }

        return sum;
    }

    //
    public static int countFriendsDefault(int n)
    {
        int count = 0;

        for (int i = 1; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int sumA = sumOfDivisorsLinearComplexity(i);
                int sumB = sumOfDivisorsLinearComplexity(j);

                if (sumA == j && sumB == i)
                {
                    count++;
                    System.out.println(i + ", " + j);
                }
            }
        }

        return count;
    }

    // O(n^1.5)
    private static int sumOfDivisors(int number)
    {
        if (number <= 1)
            return 0;

        int sum = 1;
        for (int divisor = 2; (divisor * divisor) <= number; divisor++) {
            if (number % divisor == 0)
                if (divisor * divisor == number)
                    sum += divisor;
                else
                    sum += (divisor + number / divisor);
        }

        return sum;
    }

    // O(n^1.5)
    private static int findFriend(int a, int n)
    {
        int b = sumOfDivisors(a);
        if (b > a && b < n && a == sumOfDivisors(b))
            return b;
        else
            return -1;
    }

    // O(n*n^1.5)
    public static int countFriendsOptimal(int n)
    {
        int count = 0;
        for (int a = 1; a < n; a++) {
            int b = findFriend(a, n);

            if (b != -1)
            {
                count++;
                System.out.println(a + ", " + b);
            }
        }

        return count;
    }

    // O(n)
    public static int included(int x, int y)
    {
        boolean[] xDigits = {false, false, false, false, false, false, false, false, false, false};
        boolean[] yDigits = {false, false, false, false, false, false, false, false, false, false};

        while (x != 0)
        {
            xDigits[x%10] = true;
            x = x/10;
        }

        while (y != 0)
        {
            yDigits[y%10] = true;
            y = y/10;
        }

        int k = 0;

        for (int i = 0; i < 10; i++) {
            if (xDigits[i] && !yDigits[i])
                k++;
        }

        return k;
    }
}
