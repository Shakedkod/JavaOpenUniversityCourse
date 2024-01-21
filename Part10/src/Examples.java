public class Examples
{
    // O(n)
    public static long power(int a, int n)
    {
        if (n == 0)
            return 1;

        return (a * power(a, n-1));
    }

    // O(log n)
    public static long betterPower(int a, int n)
    {
        if (n == 0)
            return 1;

        long temp = betterPower(a, n/2);
        if (n % 2 == 0)
            return (temp * temp);
        return  (a * temp * temp);
    }

    public static int fibonacci(int n)
    {
        if (n == 2 || n == 1)
            return 1;

        return fibonacci(n - 1) + fibonacci(n - 2); // add the two elements that before him
    }

    public static void binaryNumbers(int n, String str)
    {
        if (n == 0)
            System.out.println(str);
        else
        {
            binaryNumbers(n-1, str+"0");
            binaryNumbers(n-1, str+"1");
        }
    }

    public static void binaryNumbers(int n)
    {
        binaryNumbers(n, "");
    }

    public static int numberOfChars(String s, char ch) // returns the number of times a char is in a string
    {
        if (s.length() == 0)
            return 0;

        if (s.charAt(0) == ch)
            return 1 + numberOfChars(s.substring(1), ch);
        else
            return numberOfChars(s.substring(1), ch);
    }

    // שאלה 1 ביחידה 10.2
    public static int necklace(int n)
    {
        if (n == 1 || n == 2)
            return n;

        return necklace(n - 1) + necklace (n - 2);
    }

    // שאלה 2 ביחידה 10.2
    public static int strings(int n, String s)
    {
        if (n == 0)
            return 0;

        return strings(n - 1, s + 'a')
                + strings(n - 1, s + 'b')
                + strings(n - 1, s + 'c')
                + strings(n - 1, s + 'd');
    }

    public static int strings(int n)
    {
        return strings(n, "s");
    }
}
