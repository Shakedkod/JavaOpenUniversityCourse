import java.util.Arrays;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;
import org.fusesource.jansi.AnsiConsole;

public class Test
{
    private int _testCounter;
    private String _testName;
    private static final Ansi ansi = Ansi.ansi();
    private final int DEFAULT_COUNTER = 0;
    private final String FAIL_COLOR = "";
    private final String MAIN_COLOR = "";
    private final String TITLE_COLOR = "";
    private final String SUCCESS_COLOR = "";

    public Test(String testName)
    {
        AnsiConsole.systemInstall();
        _testName = testName;
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

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR + " OUTPUT: " + expected);
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

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR + " OUTPUT: " + expected);
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

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR + " OUTPUT: " + expected);
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

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR + " OUTPUT: " + expected);
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

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR + " OUTPUT: " + expected);
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

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR + " OUTPUT: " + Arrays.toString(expected));
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

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR + " OUTPUT: " + Arrays.toString(expected));
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

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR + " OUTPUT: " + Arrays.toString(expected));
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

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR + " OUTPUT: " + Arrays.toString(expected));
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

        System.out.println("Test #" + _testCounter + " -> " + FAIL_COLOR + "FAILED" + MAIN_COLOR + " OUTPUT: " + expected);
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
}
