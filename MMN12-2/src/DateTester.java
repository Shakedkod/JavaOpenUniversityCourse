public class DateTester {
    public static void main(String[] args) {
        boolean testPassed;

        // Test 1: Check valid date creation
        Date validDate = new Date(15, 6, 2021);
        testPassed = validDate.getDay() == 15 && validDate.getMonth() == 6 && validDate.getYear() == 2021;
        System.out.println("Test 1 - Valid Date Creation: " + (testPassed ? "Passed" : "Failed"));

        // Test 2: Check invalid day
        Date invalidDayDate = new Date(32, 1, 2021);
        testPassed = invalidDayDate.getDay() == 1; // Assuming default day is 1
        System.out.println("Test 2 - Invalid Day: " + (testPassed ? "Passed" : "Failed"));

        // Test 3: Check invalid month
        Date invalidMonthDate = new Date(10, 13, 2021);
        testPassed = invalidMonthDate.getMonth() == 1; // Assuming default month is 1
        System.out.println("Test 3 - Invalid Month: " + (testPassed ? "Passed" : "Failed"));

        System.out.println("INVALIDMONTHDATE: "+ invalidMonthDate);

        // Test 4: Check invalid year
        Date invalidYearDate = new Date(10, 5, 10000);
        testPassed = invalidYearDate.getYear() == 2000; // Assuming default year is 2000
        System.out.println("Test 4 - Invalid Year: " + (testPassed ? "Passed" : "Failed"));

        // Test 5: Check leap year
        Date leapYearDate = new Date(29, 2, 2020);
        testPassed = leapYearDate.getDay() == 29;
        System.out.println("Test 5 - Leap Year: " + (testPassed ? "Passed" : "Failed"));

        // Test 6: Check non-leap year
        Date nonLeapYearDate = new Date(29, 2, 2021);
        testPassed = nonLeapYearDate.getDay() == 1; // Assuming default day is 1
        System.out.println("Test 6 - Non-Leap Year: " + (testPassed ? "Passed" : "Failed"));

        // Test 7: Test toString method
        String expectedDateString = "15/06/2021";
        testPassed = validDate.toString().equals(expectedDateString);
        System.out.println("Test 7 - ToString Method: " + (testPassed ? "Passed" : "Failed"));

        // Test 8: Test equals method
        Date sameAsValidDate = new Date(15, 6, 2021);
        testPassed = validDate.equals(sameAsValidDate);
        System.out.println("Test 8 - Equals Method: " + (testPassed ? "Passed" : "Failed"));

        // Test 9: Test before method
        Date earlierDate = new Date(1, 1, 2021);
        testPassed = earlierDate.before(validDate);
        System.out.println("Test 9 - Before Method: " + (testPassed ? "Passed" : "Failed"));

        // Test 10: Test after method
        Date laterDate = new Date(1, 1, 2022);
        testPassed = laterDate.after(validDate);
        System.out.println("Test 10 - After Method: " + (testPassed ? "Passed" : "Failed"));

        // Additional tests can be added here to cover more scenarios
    }
}