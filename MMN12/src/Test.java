import java.util.Arrays;

public class Test
{
    private int _testCounter;
    private final int DEFAULT_COUNTER = 0;
    private final String FAIL_COLOR = "\\033[1;31m";
    private final String MAIN_COLOR = "\\033[0m";
    private final String TITLE_COLOR = "";
    private final String SUCCESS_COLOR = "\\033[1;32m";

    public Test(String testName)
    {
        _testCounter = DEFAULT_COUNTER;
        System.out.println("========== Testing " + testName + " ==========");
    }

    public boolean check(int expected, int actual)
    {
        _testCounter++;
        if (expected == actual)
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + MAIN_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR);
        return false;
    }

    public boolean check(double expected, double actual)
    {
        _testCounter++;
        if (expected == actual)
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + MAIN_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR);
        return false;
    }

    public boolean check(boolean expected, boolean actual)
    {
        _testCounter++;
        if (expected == actual)
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + MAIN_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR);
        return false;
    }

    public boolean check(String expected, String actual)
    {
        _testCounter++;
        if (expected.equals(actual))
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + MAIN_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR);
        return false;
    }

    public boolean check(Object expected, Object actual)
    {
        _testCounter++;
        if (expected.equals(actual))
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + MAIN_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR);
        return false;
    }

    public boolean check(int[] expected, int[] actual)
    {
        _testCounter++;
        if (Arrays.equals(expected, actual))
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + MAIN_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR);
        return false;
    }

    public boolean check(double[] expected, double[] actual)
    {
        _testCounter++;
        if (Arrays.equals(expected, actual))
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + MAIN_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR);
        return false;
    }

    public boolean check(String[] expected, String[] actual)
    {
        _testCounter++;
        if (Arrays.equals(expected, actual))
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + MAIN_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR);
        return false;
    }

    public boolean check(Object[] expected, Object[] actual)
    {
        _testCounter++;
        if (Arrays.equals(expected, actual))
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + MAIN_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR);
        return false;
    }

    public boolean checkToString(Object expected, Object actual)
    {
        _testCounter++;
        if (expected.toString().equals(actual.toString()))
        {
            System.out.println("Test #" + _testCounter + " -> " + SUCCESS_COLOR + "SUCCEEDED" + MAIN_COLOR);
            return true;
        }

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR);
        return false;
    }
}
