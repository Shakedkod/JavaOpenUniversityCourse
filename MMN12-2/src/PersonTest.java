public class PersonTest {

    public static void main(String[] args) {
        // Test Case 1: Default constructor
        Person person1 = new Person("", 1, 1, 2000, "123456789");
        System.out.println("Test Case 1:\n" + person1);

        // Test Case 2: Valid input
        Person person2 = new Person("John Doe", 15, 6, 1995, "987654321");
        System.out.println("\nTest Case 2:\n" + person2);

        // Test Case 3: Copy constructor
        Person person3 = new Person(person2);
        System.out.println("\nTest Case 3:\n" + person3);

        // Test Case 4: Empty name and invalid ID
        Person person4 = new Person("", 1, 1, 2000, "12");
        System.out.println("\nTest Case 4:\n" + person4);

        // Test Case 5: Null name and valid ID
        Person person5 = new Person(null, 1, 1, 2000, "123456789");
        System.out.println("\nTest Case 5:\n" + person5);

        // Test Case 6: Null date
        Person person6 = new Person("Alice", 0, 0, 0, "111222333");
        System.out.println("\nTest Case 6:\n" + person6);

        // Test Case 7: Set name with empty string
        person2.setName("");
        System.out.println("\nTest Case 7:\n" + person2);

        // Test Case 8: Set ID with invalid length
        person2.setId("123");
        System.out.println("\nTest Case 8:\n" + person2);

        // Test Case 9: Set invalid date
        person2.setDateOfBirth(new Date(0, 0, 0));
        System.out.println("\nTest Case 9:\n" + person2);

        // Test Case 10: Equals method
        System.out.println("\nTest Case 10: Equals method");
        System.out.println("person2 equals person3: " + person2.equals(person3));
        System.out.println("person2 equals person4: " + person2.equals(person4));

        // Test Case 11: CompareTo method (person2 is younger)
        System.out.println("\nTest Case 11: CompareTo method");
        System.out.println("person2 compareTo person3: " + person2.compareTo(person3));

        // Test Case 12: CompareTo method (person2 is older)
        System.out.println("\nTest Case 12: CompareTo method");
        System.out.println("person3 compareTo person2: " + person3.compareTo(person2));

        // Test Case 13: CompareTo method (same age)
        System.out.println("\nTest Case 13: CompareTo method");
        System.out.println("person2 compareTo person4: " + person2.compareTo(person4));

        // Test Case 14: Set name to null and ID to a valid value
        person2.setName(null);
        person2.setId("111222333");
        System.out.println("\nTest Case 14:\n" + person2);

        // Test Case 15: Set valid date
        person2.setDateOfBirth(new Date(25, 12, 1980));
        System.out.println("\nTest Case 15:\n" + person2);

        // Test Case 16: Set name, ID, and date to valid values using setters
        person2.setName("Bob");
        person2.setId("999888777");
        person2.setDateOfBirth(new Date(10, 3, 1990));
        System.out.println("\nTest Case 16:\n" + person2);

        // Test Case 18: CompareTo method with same birthdate
        Person person8 = new Person("Charlie", 10, 3, 1990, "555444333");
        System.out.println("\nTest Case 18:\n" + "person2 compareTo person8: " + person2.compareTo(person8));

        // Test Case 19: Equals method with different names
        Person person9 = new Person("Alice", 25, 12, 1980, "999888777");
        System.out.println("\nTest Case 19:\n" + "person2 equals person9: " + person2.equals(person9));

        // Test Case 20: Set name and ID to default values
        person2.setName("Someone");
        person2.setId("000000000");
        System.out.println("\nTest Case 20:\n" + person2);

        // Test Case 21: Large name, valid ID, and date
        Person person10 = new Person("ThisIsALongNameForTestingEdgeCases", 1, 1, 2000, "123456789");
        System.out.println("\nTest Case 21:\n" + person10);

        // Test Case 23: Default constructor with valid ID and date
        Person person12 = new Person("Jane", 10, 5, 1988, "111223344");
        Person person13 = new Person("John", 20, 12, 1992, "555666777");
        Person person14 = new Person("Jack", 5, 8, 2001, "999888777");
        System.out.println("\nTest Case 23:\n" + person12 + "\n" + person13 + "\n" + person14);
    }
}