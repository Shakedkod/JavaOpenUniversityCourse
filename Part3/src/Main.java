import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        Random r = new Random();

        // r.nextInt(6) -> between 0 and 5
        int num = r.nextInt(6) + 1;
        System.out.println("Random number: " + num);

        // r.nextInt(5, 10) -> between 5 and 9
        int num2 = r.nextInt(5, 10);
        System.out.println("Random number: " + num2);

        // r.nextDouble() -> between 0.0 and 1.0
        double num3 = r.nextDouble();

        // r.nextDouble(5.0) -> between 0.0 and 5.0
        double num4 = r.nextDouble(5.0);

        /////////////////////////////////////////////////////////

        String str1 = new String("Hello");
        String str2 = new String("Hello");
        String str3 = new String("World");

        // str1.length() -> 5
        System.out.println(str1.length());

        // str1 == str2 -> false
        System.out.println(str1 == str2);

        // str1.equals(str2) -> true
        System.out.println(str1.equals(str2));

        // str1.charAt(0) -> 'H'
        System.out.println(str1.charAt(0));

        // str1.indexOf('e') -> 1
        System.out.println(str1.indexOf('e'));

        // str1.compareTo(str3) -> -15
        System.out.println(str1.compareTo(str3));

        // str1.substring(1, 3) -> "el"
        System.out.println(str1.substring(1, 3));

        // str1.substring(1) -> "ello"
        System.out.println(str1.substring(1));

        // str1.toUpperCase() -> "HELLO"
        System.out.println(str1.toUpperCase());

        // str1.toLowerCase() -> "hello"
        System.out.println(str1.toLowerCase());

        /////////////////////////////////////////////////////////

        // Math.abs(-5) -> 5
        System.out.println(Math.abs(-5));

        // Math.pow(2, 3) -> 8
        System.out.println(Math.pow(2, 3));

        // Math.sqrt(9) -> 3
        System.out.println(Math.sqrt(9));

        // Math.floor(3.14) -> 3
        System.out.println(Math.floor(3.14));

        // Math.round(3.14) -> 3
        System.out.println(Math.round(3.14));

        // Math.ceil(3.14) -> 4
        System.out.println(Math.ceil(3.14));

        // Math.max(5, 10) -> 10
        System.out.println(Math.max(5, 10));

        // Math.min(5, 10) -> 5
        System.out.println(Math.min(5, 10));
    }
}