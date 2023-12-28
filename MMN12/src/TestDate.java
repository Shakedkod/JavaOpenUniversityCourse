import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDate
{
    @Test
    public void testDate()
    {
        System.out.println("********** Test Date - Started **********");
        System.out.println("\n1. Testing Constructors and toString:");

        Date d1=new Date(13,10,1998);
        Date d2=new Date(d1);
        Assertions.assertEquals(d1.toString(), "13/10/1998");
        Assertions.assertEquals(d2.toString(), "13/10/1998");
    }
}

