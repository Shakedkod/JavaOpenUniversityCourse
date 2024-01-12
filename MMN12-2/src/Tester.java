public class Tester
{
    public static void main(String[] args)
    {
        int successes = 0, counter = 0;

        Test tester = new Test("Date");
        System.out.println("\nA. Testing Constructors and toString:");
        Date d1=new Date(13,10,1998);
        Date d2=new Date(d1);

        successes += tester.check(d1.toString(), "13/10/1998") ? 1 : 0;
        successes += tester.checkToString(d1, d2) ? 1 : 0;

        System.out.println("\nB. Testing accessors and mutators:");
        d1.setDay(8);
        d1.setMonth(10);
        d1.setYear(2016);
        successes += tester.check(d1.toString(), "08/10/2016") ? 1 : 0;
        successes += tester.check(d1.getDay(), 8) ? 1 : 0;
        successes += tester.check(d1.getMonth(), 10) ? 1 : 0;
        successes += tester.check(d1.getYear(), 2016) ? 1 : 0;

        System.out.println("\n3. Testing equals method:");
        Date d3=new Date(3,5,1998);
        Date d4=new Date(3,5,1998);
        successes += tester.check(d3.equals(d4), true) ? 1 : 0;

        System.out.println("\n4. Testing before method:");
        successes += tester.check(d3.before(d1), true) ? 1 : 0;

        System.out.println("\n5. Testing after method:");
        successes += tester.check(d3.after(d1), false) ? 1 : 0;

        System.out.println("\n6. Testing difference method:");
        successes += tester.check(d2.difference(d3), 163) ? 1 : 0;

        System.out.println("\n7. Testing addYearsToDate method:");
        Date d5 = new Date(14, 2, 2021);
        int num = 3;
        Date d6 = d5.addYearsToDate(num);
        successes += tester.check(d6.toString(), "14/02/2024") ? 1 : 0;
        System.out.println("\nthe date "+num+" years after "+ d5 +" is : "+d6);

        // advanced tests
        boolean testPassed;

        // Test 1: Check valid date creation
        Date validDate = new Date(15, 6, 2021);
        testPassed = validDate.getDay() == 15 && validDate.getMonth() == 6 && validDate.getYear() == 2021;
        successes += tester.check(testPassed, true) ? 1 : 0;

        // Test 2: Check invalid day
        Date invalidDayDate = new Date(32, 1, 2021);
        testPassed = invalidDayDate.getDay() == 1; // Assuming default day is 1
        successes += tester.check(testPassed, true) ? 1 : 0;

        // Test 3: Check invalid month
        Date invalidMonthDate = new Date(10, 13, 2021);
        testPassed = invalidMonthDate.getMonth() == 1; // Assuming default month is 1
        successes += tester.check(testPassed, true) ? 1 : 0;

        System.out.println("INVALIDMONTHDATE: "+ invalidMonthDate);

        // Test 4: Check invalid year
        Date invalidYearDate = new Date(10, 5, 10000);
        testPassed = invalidYearDate.getYear() == 2000; // Assuming default year is 2000
        successes += tester.check(testPassed, true) ? 1 : 0;

        // Test 5: Check leap year
        Date leapYearDate = new Date(29, 2, 2020);
        testPassed = leapYearDate.getDay() == 29;
        successes += tester.check(testPassed, true) ? 1 : 0;

        // Test 6: Check non-leap year
        Date nonLeapYearDate = new Date(29, 2, 2021);
        testPassed = nonLeapYearDate.getDay() == 1; // Assuming default day is 1
        successes += tester.check(testPassed, true) ? 1 : 0;

        // Test 7: Test toString method
        String expectedDateString = "15/06/2021";
        testPassed = validDate.toString().equals(expectedDateString);
        successes += tester.check(testPassed, true) ? 1 : 0;

        // Test 8: Test equals method
        Date sameAsValidDate = new Date(15, 6, 2021);
        testPassed = validDate.equals(sameAsValidDate);
        successes += tester.check(testPassed, true) ? 1 : 0;

        // Test 9: Test before method
        Date earlierDate = new Date(1, 1, 2021);
        testPassed = earlierDate.before(validDate);
        successes += tester.check(testPassed, true) ? 1 : 0;

        // Test 10: Test after method
        Date laterDate = new Date(1, 1, 2022);
        testPassed = laterDate.after(validDate);
        successes += tester.check(testPassed, true) ? 1 : 0;

        counter += tester.endTest();

        // Person
        tester = new Test("Person");

        System.out.println("\n1. Testing Constructors and toString:");
        Person p1 = new Person("Israel Israeli", 22, 10, 1993, "123456789");
        successes += tester.check(p1.toString(), "Name: Israel Israeli\n" +
                "ID: 123456789\n" +
                "Date of birth: 22/10/1993"
        ) ? 1 : 0;
        Person p2 = new Person(p1);
        successes += tester.checkToString(p1, p2) ? 1 : 0;

        System.out.println("\n2. Testing accessors and mutators:");
        successes += tester.check(p1.getName(), "Israel Israeli") ? 1 : 0;
        successes += tester.check(p1.getDateOfBirth().toString(), "22/10/1993") ? 1 : 0;
        successes += tester.check(p1.getId(), "123456789") ? 1 : 0;

        p1.setName("Miriam Levi");
        p1.setId("121212");
        p1.setDateOfBirth(new Date(19, 9, 1981));
        successes += tester.check(p1.toString(), "Name: Miriam Levi\n" +
                "ID: 123456789\n" +
                "Date of birth: 19/09/1981"
        ) ? 1 : 0;

        System.out.println("\n3. Testing equals method:");
        Person p3 = new Person("Yossef Ben Avrham", 5, 3, 1998, "123123123");
        Person p4 = new Person("Yossef Ben Avrham", 5, 3, 1998, "321321321");
        successes += tester.check(p3.equals(p4), false) ? 1 : 0;

        System.out.println("\n4. Testing compare method:");
        successes += tester.check(p1.compareTo(p3) > 0, true) ? 1 : 0;

        counter += tester.endTest();

        // Apartment
        tester = new Test("Apartment");

        System.out.println("\n1. Testing Constructors and toString:");
        p1 = new Person("Israel Israeli", 22, 10, 1993, "123456789");
        Apartment a1 = new Apartment(4, 81, 6500, p1, 1, 7, 2022, 1, 7, 2024);
        successes += tester.check(a1.toString(), "Number of rooms: 4\n" +
                "Area: 81.0\n" +
                "Price: 6500.0 NIS\n" +
                "Tenant name: Israel Israeli\n" +
                "Rental start date: 01/07/2022\n" +
                "Rental end date: 01/07/2024"
        ) ? 1 : 0;
        Apartment a2 = new Apartment(a1);
        successes += tester.checkToString(a1, a2) ? 1 : 0;

        System.out.println("\n2. Testing accessors and mutators:");
        successes += tester.check(a1.getNoOfRooms(), 4) ? 1 : 0;
        successes += tester.check(a1.getArea(), 81.0) ? 1 : 0;
        successes += tester.check(a1.getPrice(), 6500.0) ? 1 : 0;
        successes += tester.check(a1.getTenant().getName(), "Israel Israeli") ? 1 : 0;
        successes += tester.check(a1.getRentalStartDate().toString(), "01/07/2022") ? 1 : 0;
        successes += tester.check(a1.getRentalEndDate().toString(), "01/07/2024") ? 1 : 0;

        p2 = new Person("David Levi", 11, 12, 2001, "987654321");
        a1.setTenant(p2);
        a1.setNoOfRooms(5);
        a1.setArea(110);
        a1.setPrice(9900);
        a1.setRentalStartDate(new Date(1, 8, 2023));
        a1.setRentalEndDate(new Date(1, 8, 2025));
        successes += tester.check(a1.toString(), "Number of rooms: 5\n" +
                "Area: 110.0\n" +
                "Price: 9900.0 NIS\n" +
                "Tenant name: David Levi\n" +
                "Rental start date: 01/08/2023\n" +
                "Rental end date: 01/08/2025"
        ) ? 1 : 0;

        System.out.println("\n3. Testing equals method:");
        Apartment a3 = new Apartment(4, 81, 6500, p1, 1, 7, 2022, 1, 7, 2024);
        Apartment a4 = new Apartment(4, 81, 6500, p1, 1, 7, 2022, 1, 7, 2024);
        successes += tester.check(a3.equals(a4), true) ? 1 : 0;

        System.out.println("\n4. Testing extendRentalPeriod method:");
        a1.extendRentalPeriod(1);
        successes += tester.check(a1.getRentalEndDate().getYear(), 2026) ? 1 : 0;

        System.out.println("\n5. Testing daysLeft method:");
        Date d = new Date(1, 6, 2024);
        int left = a2.daysLeft(d);
        successes += tester.check(left, 30) ? 1 : 0;

        System.out.println("\n6. Testing changeTenant method:");
        p3 = new Person("Miriam Levi", 19, 9, 2001, "123123123");
        Date startDate = new Date(1, 6, 2024);
        successes += tester.check(a4.changeTenant(startDate, p3, 7000), true) ? 1 : 0;

        counter += tester.endTest();

        tester.finalReport(counter, successes);
    }
}

