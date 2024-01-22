import java.util.Arrays;

public class Test
{
    private int _testCounter;
    private String _testName;
    private final int DEFAULT_COUNTER = 0;
    public static final String FAIL_COLOR = "\u001B[31m";
    public static final String RESET_COLOR = "\u001B[0m";
    public static final String TITLE_COLOR = "\u001B[43m";
    public static final String SUCCESS_COLOR = "\u001B[32m";

    public Test(String testName)
    {
        _testName = testName;
        _testCounter = DEFAULT_COUNTER;
        System.out.println(TITLE_COLOR + "========== Testing " + testName + " ==========" + RESET_COLOR);
    }

    public boolean check(int expected, int actual)
    {
        _testCounter++;
        if (expected == actual)
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + RESET_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + RESET_COLOR + " OUTPUT: " + expected);
        return false;
    }

    public boolean check(double expected, double actual)
    {
        _testCounter++;
        if (expected == actual)
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + RESET_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + RESET_COLOR + " OUTPUT: " + expected);
        return false;
    }

    public boolean check(boolean expected, boolean actual)
    {
        _testCounter++;
        if (expected == actual)
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + RESET_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + RESET_COLOR + " OUTPUT: " + expected);
        return false;
    }

    public boolean check(String expected, String actual)
    {
        _testCounter++;
        if (expected.equals(actual))
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + RESET_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + RESET_COLOR + " OUTPUT: " + expected);
        return false;
    }

    public boolean check(Object expected, Object actual)
    {
        _testCounter++;
        if (expected.equals(actual))
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + RESET_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + RESET_COLOR + " OUTPUT: " + expected);
        return false;
    }

    public boolean check(int[] expected, int[] actual)
    {
        _testCounter++;
        if (Arrays.equals(expected, actual))
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + RESET_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + RESET_COLOR + " OUTPUT: " + Arrays.toString(expected));
        return false;
    }

    public boolean check(double[] expected, double[] actual)
    {
        _testCounter++;
        if (Arrays.equals(expected, actual))
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + RESET_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + RESET_COLOR + " OUTPUT: " + Arrays.toString(expected));
        return false;
    }

    public boolean check(String[] expected, String[] actual)
    {
        _testCounter++;
        if (Arrays.equals(expected, actual))
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + RESET_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + RESET_COLOR + " OUTPUT: " + Arrays.toString(expected));
        return false;
    }

    public boolean check(Object[] expected, Object[] actual)
    {
        _testCounter++;
        if (Arrays.equals(expected, actual))
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + RESET_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + RESET_COLOR + " OUTPUT: " + Arrays.toString(expected));
        return false;
    }

    public boolean checkToString(Object expected, Object actual)
    {
        _testCounter++;
        if (expected.toString().equals(actual.toString()))
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + RESET_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + RESET_COLOR + " OUTPUT: " + expected);
        return false;
    }

    public int endTest()
    {
        System.out.println("========== Test Ended for " + _testName + " ==========\n");
        int count = _testCounter;
        _testCounter = DEFAULT_COUNTER;
        _testName = "";

        return count;
    }

    public void finalReport()
    {
        System.out.println(TITLE_COLOR + "========== FINAL REPORT ==========" + RESET_COLOR);
        System.out.println(_testCounter + " tests committed.\n");
    }

    public void finalReport(int counter, int successes)
    {
        System.out.println(TITLE_COLOR + "========== FINAL REPORT ==========" + RESET_COLOR);
        System.out.println(counter + " tests committed.\n"
                + SUCCESS_COLOR + successes + " from them passed.\n" + RESET_COLOR
                + FAIL_COLOR + (counter - successes) + " from them failed."  + RESET_COLOR);
    }
}
