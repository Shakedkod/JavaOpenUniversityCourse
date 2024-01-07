public class TestDate
{
    public static void main(String[] args)
    {
        Test tester = new Test("Date");
        System.out.println("\n1. Testing Constructors and toString:");

        Date d1=new Date(13,10,1998);
        Date d2=new Date(d1);
        tester.check(d1.toString(), "13/10/1998");
        tester.check(d2.equals(d1), true);


    }
}

