public class DateTest {
    public static void main(String[] args) {
        // Test 1: Minimum and Maximum Valid Values
        testMinMaxValues();

        // Test 2: Leap Year Edge Cases
        testLeapYearCases();

        // Test 3: Negative Years
        testNegativeYears();

        // Test 4: Equality Check
        testEqualityCheck();

        // Test 5: Date Difference
        testDateDifference();

        // Test 6: Invalid Day, Month, or Year
        testInvalidValues();

        // Test 7: Immutable Check
        testImmutable();

        // Test 8: Setting Day, Month, and Year Independently
        testSettersIndependently();

        // Test 9: Edge Cases around Year Change
        testYearChange();

        // Test 10: Constructors with Default Values
        testConstructorsWithDefaultValues();

        // Test 11: Edge Case - February 30th
        testFebruary30th();

        // Test 12: Invalid Month for Leap Year
        testInvalidMonthForLeapYear();

        // Test 13: Invalid Date
        testInvalidDate();

        // Test 14: Setting Day/Month Beyond Maximum
        testSettingDayMonthBeyondMaximum();

        // Test 15: Setting Year Beyond Maximum
        testSettingYearBeyondMaximum();

        // Test 16: Testing toString() with Single-Digit Day/Month
        testToStringWithSingleDigitDayMonth();

        // Test 17: Testing toString() with Single-Digit Year
        testToStringWithSingleDigitYear();

        // Test 18: Testing addYearsToDate with Large Values
        testAddYearsToDateWithLargeValues();

        // Test 19: Testing addYearsToDate with Negative Large Values
        testAddYearsToDateWithNegativeLargeValues();

        // Test 20: Edge Case - Date Difference with Same Dates
        testDateDifferenceWithSameDates();

        // Test 21: Edge Case - Date Difference with One Day Apart
        testDateDifferenceOneDayApart();

        // Test 22: Edge Case - Date Difference with Same Month
        testDateDifferenceSameMonth();

        // Test 23: Edge Case - Date Difference with Same Year
        testDateDifferenceSameYear();

        // Test 24: Edge Case - Date Difference with Same Date
        testDateDifferenceSameDate();

        // Test 25: Edge Case - Date Difference with Large Difference
        testDateDifferenceLargeDifference();

        // Test 26: Edge Case - Date Difference with Negative Difference
        testDateDifferenceNegativeDifference();

        // Test 27: Edge Case - Date Difference with Invalid Dates
        testDateDifferenceInvalidDates();

        // Test 29: Edge Case - Setting Invalid Date After Valid Date
        testSettingInvalidDateAfterValidDate();
    }

    // Helper method to create and print a Date object
    private static void printDate(Date date) {
        System.out.println(date.toString());
    }

    // Test 1: Minimum and Maximum Valid Values
    private static void testMinMaxValues() {
        System.out.println("Test 1: Minimum and Maximum Valid Values");
        // Minimum valid values
        Date minDate = new Date(1, 1, 1000);
        printDate(minDate);

        // Maximum valid values
        Date maxDate = new Date(31, 12, 9999);
        printDate(maxDate);
    }

    // Test 2: Leap Year Edge Cases
    private static void testLeapYearCases() {
        System.out.println("Test 2: Leap Year Edge Cases");
        // February 29th in a leap year
        Date leapYearDate = new Date(29, 2, 2020);
        printDate(leapYearDate);

        // February 28th in a non-leap year
        Date nonLeapYearDate = new Date(28, 2, 2021);
        printDate(nonLeapYearDate);
    }

    // Test 3: Negative Years
    private static void testNegativeYears() {
        System.out.println("Test 3: Negative Years");
        // Adding -5 years to the current date
        Date currentDate = new Date(1, 1, 2022);
        Date negativeYearsDate = currentDate.addYearsToDate(-5);
        printDate(negativeYearsDate);
    }

    // Test 4: Equality Check
    private static void testEqualityCheck() {
        System.out.println("Test 4: Equality Check");
        Date date1 = new Date(1, 1, 2000);
        Date date2 = new Date(1, 1, 2000);
        System.out.println("Are the two dates equal? " + date1.equals(date2));
    }

    // Test 5: Date Difference
    private static void testDateDifference() {
        System.out.println("Test 5: Date Difference");
        Date date1 = new Date(1, 1, 2022);
        Date date2 = new Date(1, 1, 2023);
        int difference = date1.difference(date2);
        System.out.println("The difference in days is: " + difference);
    }

    // Test 6: Invalid Day, Month, or Year
    private static void testInvalidValues() {
        System.out.println("Test 6: Invalid Day, Month, or Year");
        // Testing with invalid day value
        Date invalidDayDate = new Date(30, 2, 2022);
        printDate(invalidDayDate);

        // Testing with invalid month value
        Date invalidMonthDate = new Date(1, 13, 2022);
        printDate(invalidMonthDate);

        // Testing with invalid year value
        Date invalidYearDate = new Date(1, 1, 999);
        printDate(invalidYearDate);
    }

    // Test 7: Immutable Check
    private static void testImmutable() {
        System.out.println("Test 7: Immutable Check");
        Date originalDate = new Date(1, 1, 2022);
        Date modifiedDate = originalDate.addYearsToDate(5);

        System.out.println("Original Date: " + originalDate.toString());
        System.out.println("Modified Date: " + modifiedDate.toString());
    }

    // Test 8: Setting Day, Month, and Year Independently
    private static void testSettersIndependently() {
        System.out.println("Test 8: Setting Day, Month, and Year Independently");
        Date date = new Date(29, 2, 2024);
        date.setDay(28);
        date.setMonth(2);
        date.setYear(2030);
        printDate(date);
    }

    // Test 9: Edge Cases around Year Change
    private static void testYearChange() {
        System.out.println("Test 9: Edge Cases around Year Change");
        // Test case where changing the year affects the day and month
        Date yearChangeDate = new Date(31, 12, 2022);
        Date newYearDate = yearChangeDate.addYearsToDate(1);
        printDate(newYearDate);
    }

    // Test 10: Constructors with Default Values
    private static void testConstructorsWithDefaultValues() {
        System.out.println("Test 10: Constructors with Default Values");
        // Testing default constructor
        Date defaultDate = new Date(0, 0, 0);
        printDate(defaultDate);

        // Testing copy constructor with default values
        Date originalDate = new Date(25, 12, 2022);
        Date copyDate = new Date(originalDate);
        printDate(copyDate);
    }

    // Test 11: Edge Case - February 30th
    private static void testFebruary30th() {
        System.out.println("Test 11: Edge Case - February 30th");
        // Attempt to create a date with February 30th
        Date invalidDate = new Date(30, 2, 2022);
        printDate(invalidDate);
    }

    // Test 12: Invalid Month for Leap Year
    private static void testInvalidMonthForLeapYear() {
        System.out.println("Test 12: Invalid Month for Leap Year");
        // Attempt to create a date with February 29th in a non-leap year
        Date invalidDate = new Date(29, 2, 2021);
        printDate(invalidDate);
    }

    // Test 13: Invalid Date
    private static void testInvalidDate() {
        System.out.println("Test 13: Invalid Date");
        // Attempt to create a date with an invalid combination
        Date invalidDate = new Date(32, 13, 2022);
        printDate(invalidDate);
    }

    // Test 14: Setting Day/Month Beyond Maximum
    private static void testSettingDayMonthBeyondMaximum() {
        System.out.println("Test 14: Setting Day/Month Beyond Maximum");
        // Attempt to set day and month beyond their maximum valid values
        Date date = new Date(1, 1, 2022);
        date.setDay(32);
        date.setMonth(13);
        printDate(date);
    }

    // Test 15: Setting Year Beyond Maximum
    private static void testSettingYearBeyondMaximum() {
        System.out.println("Test 15: Setting Year Beyond Maximum");
        // Attempt to set year beyond its maximum valid value
        Date date = new Date(1, 1, 2022);
        date.setYear(10000);
        printDate(date);
    }

    // Test 16: Testing toString() with Single-Digit Day/Month
    private static void testToStringWithSingleDigitDayMonth() {
        System.out.println("Test 16: Testing toString() with Single-Digit Day/Month");
        // Test toString with single-digit day and month values
        Date date = new Date(5, 3, 2022);
        printDate(date);
    }

    // Test 17: Testing toString() with Single-Digit Year
    private static void testToStringWithSingleDigitYear() {
        System.out.println("Test 17: Testing toString() with Single-Digit Year");
        // Test toString with a single-digit year
        Date date = new Date(5, 3, 22);
        printDate(date);
    }

    // Test 18: Testing addYearsToDate with Large Values
    private static void testAddYearsToDateWithLargeValues() {
        System.out.println("Test 18: Testing addYearsToDate with Large Values");
        // Test adding a large positive value to the year
        Date date = new Date(1, 1, 2022);
        Date result = date.addYearsToDate(1000);
        printDate(result);
    }

    // Test 19: Testing addYearsToDate with Negative Large Values
    private static void testAddYearsToDateWithNegativeLargeValues() {
        System.out.println("Test 19: Testing addYearsToDate with Negative Large Values");
        // Test adding a large negative value to the year
        Date date = new Date(1, 1, 2022);
        Date result = date.addYearsToDate(-1050);
        printDate(result);
    }

    // Test 20: Edge Case - Date Difference with Same Dates
    private static void testDateDifferenceWithSameDates() {
        System.out.println("Test 20: Edge Case - Date Difference with Same Dates");
        // Test date difference with two identical dates
        Date date1 = new Date(1, 1, 2022);
        Date date2 = new Date(1, 1, 2022);
        int difference = date1.difference(date2);
        System.out.println("The difference in days is: " + difference);
    }

    // Test 21: Edge Case - Date Difference with One Day Apart
    private static void testDateDifferenceOneDayApart() {
        System.out.println("Test 21: Edge Case - Date Difference with One Day Apart");
        // Test date difference with two dates that are one day apart
        Date date1 = new Date(1, 1, 2022);
        Date date2 = new Date(2, 1, 2022);
        int difference = date1.difference(date2);
        System.out.println("The difference in days is: " + difference);
    }

    // Test 22: Edge Case - Date Difference with Same Month
    private static void testDateDifferenceSameMonth() {
        System.out.println("Test 22: Edge Case - Date Difference with Same Month");
        // Test date difference with two dates in the same month
        Date date1 = new Date(10, 3, 2022);
        Date date2 = new Date(25, 3, 2022);
        int difference = date1.difference(date2);
        System.out.println("The difference in days is: " + difference);
    }

    // Test 23: Edge Case - Date Difference with Same Year
    private static void testDateDifferenceSameYear() {
        System.out.println("Test 23: Edge Case - Date Difference with Same Year");
        // Test date difference with two dates in the same year
        Date date1 = new Date(1, 5, 2022);
        Date date2 = new Date(1, 12, 2022);
        int difference = date1.difference(date2);
        System.out.println("The difference in days is: " + difference);
    }

    // Test 24: Edge Case - Date Difference with Same Date
    private static void testDateDifferenceSameDate() {
        System.out.println("Test 24: Edge Case - Date Difference with Same Date");
        // Test date difference with two identical dates
        Date date1 = new Date(7, 8, 2022);
        Date date2 = new Date(7, 8, 2022);
        int difference = date1.difference(date2);
        System.out.println("The difference in days is: " + difference);
    }

    // Test 25: Edge Case - Date Difference with Large Difference
    private static void testDateDifferenceLargeDifference() {
        System.out.println("Test 25: Edge Case - Date Difference with Large Difference");
        // Test date difference with two dates having a large difference
        Date date1 = new Date(1, 1, 2022);
        Date date2 = new Date(1, 1, 2200);
        int difference = date1.difference(date2);
        System.out.println("The difference in days is: " + difference);
    }

    // Test 26: Edge Case - Date Difference with Negative Difference
    private static void testDateDifferenceNegativeDifference() {
        System.out.println("Test 26: Edge Case - Date Difference with Negative Difference");
        // Test date difference with two dates where date1 is after date2
        Date date1 = new Date(1, 1, 2022);
        Date date2 = new Date(1, 1, 2021);
        int difference = date1.difference(date2);
        System.out.println("The difference in days is: " + difference);
    }

    // Test 27: Edge Case - Date Difference with Invalid Dates
    private static void testDateDifferenceInvalidDates() {
        System.out.println("Test 27: Edge Case - Date Difference with Invalid Dates");
        // Test date difference with two invalid dates
        Date invalidDate1 = new Date(32, 13, 2022);
        Date invalidDate2 = new Date(25, 12, 2021);
        int difference = invalidDate1.difference(invalidDate2);
        System.out.println("The difference in days is: " + difference);
    }

    // Test 29: Edge Case - Setting Invalid Date After Valid Date
    private static void testSettingInvalidDateAfterValidDate() {
        System.out.println("Test 29: Edge Case - Setting Invalid Date After Valid Date");
        // Test setting an invalid date after a valid date
        Date validDate = new Date(1, 1, 2022);
        Date invalidDate = new Date(32, 2, 2022);
        validDate.setDay(30);
        validDate.setMonth(2);
        validDate.setYear(2022);
        printDate(validDate);
    }
}