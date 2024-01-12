public class ApartmentTest {
    public static void main(String[] args) {
        // Test Case 1: Default Apartment
        Person defaultPerson = new Person("Default Tenant", 1, 1, 1980, "123456789");
        Apartment defaultApartment = new Apartment(3, 80, 5000, defaultPerson, 29, 2, 2000, 1, 1, 2027);
        System.out.println("Default Apartment:\n" + defaultApartment);

        // Test Case 2: Copy Constructor
        Apartment copiedApartment = new Apartment(defaultApartment);
        System.out.println("\nCopied Apartment:\n" + copiedApartment);

        // Test Case 3: Setters with Valid Values
        Person newPerson = new Person("New Tenant", 1, 1, 1990, "987654321");
        Date newStartDate = new Date(1, 1, 2023);
        Date newEndDate = new Date(1, 1, 2024);
        defaultApartment.setNoOfRooms(4);
        defaultApartment.setArea(100);
        defaultApartment.setPrice(6000);
        defaultApartment.setTenant(newPerson);
        defaultApartment.setRentalStartDate(newStartDate);
        defaultApartment.setRentalEndDate(newEndDate);
        System.out.println("\nApartment after Setters with Valid Values:\n" + defaultApartment);

        // Test Case 4: Setters with Invalid Values
        Person invalidPerson = new Person("Invalid Tenant", 1, 1, 1990, "123456789");
        Date invalidStartDate = new Date(1, 1, 2025);
        Date invalidEndDate = new Date(28, 2, 2026);
        defaultApartment.setNoOfRooms(0);
        defaultApartment.setArea(-50);
        defaultApartment.setPrice(-2000);
        //  defaultApartment.setTenant(invalidPerson);
        defaultApartment.setRentalStartDate(invalidStartDate);
        defaultApartment.setRentalEndDate(invalidEndDate);
        System.out.println("\nApartment after Setters with Invalid Values:\n" + defaultApartment);

        // Test Case 5: Equals Method
        Apartment copiedApartment2 = new Apartment(defaultApartment);
        System.out.println("\nEquality Check:\nDefault Apartment equals Copied Apartment: " + defaultApartment.equals(copiedApartment2));

        // Test Case 6: Extend Rental Period
        defaultApartment.extendRentalPeriod(2);
        System.out.println("\nApartment after Extending Rental Period by 2 years:\n" + defaultApartment);

        // Test Case 7: Days Left
        Date currentDate = new Date(1, 1, 2030);
        System.out.println("\nDays Left until End of Lease from Current Date: " + defaultApartment.daysLeft(currentDate));

        // Test Case 8: Change Tenant with Valid Conditions
        Person youngerPerson = new Person("Younger Tenant", 1, 1, 1995, "555555555");
        Date validStartDate = new Date(1, 1, 2028);
        double validPrice = 7000;
        boolean changeSuccessful = defaultApartment.changeTenant(validStartDate, youngerPerson, validPrice);
        System.out.println("\nApartment after Changing Tenant with Valid Conditions:\n" + defaultApartment);
        System.out.println("Tenant Change Successful: " + changeSuccessful);

        // Test Case 9: Change Tenant with Invalid Conditions
        Person olderPerson = new Person("Older Tenant", 1, 1, 1980, "111111111");
        Date invalidStartDate2 = new Date(1, 1, 2023);
        double invalidPrice = 4000;
        boolean changeUnsuccessful = defaultApartment.changeTenant(invalidStartDate2, olderPerson, invalidPrice);
        System.out.println("\nApartment after Attempting to Change Tenant with Invalid Conditions:\n" + defaultApartment);
        System.out.println("Tenant Change Successful: " + changeUnsuccessful);
    }
}