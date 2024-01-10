// The Equation class gets three coefficients of a polynomial equation and prints its roots
// Author: Shaked Kodman Kolran.
// ID: 216590125.
import java.util.Scanner;

public class Equation
{
    // Prompts the user to enter 3 numbers and prints the roots to the equation ax^2 + bx + c = 0
    public static void main(String[] args)
    {
        // Prompt user for coefficients of the polynomial equation
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter 3 coefficients of the polynomial equation:");
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c = scan.nextDouble();

        // Calculate delta and print the solutions
        double delta = Math.pow(b, 2) - (4 * a * c);

        // Check if there are solutions and print them
        if (delta < 0)
            System.out.println("There is no solution.");
        else if (delta == 0)
        {
            double x = (-b) / (2 * a);
            System.out.println("There is 1 solution. X1 = " + x + ".");
        }
        else
        {
            double x1 = ((-b) + Math.sqrt(delta)) / (2 * a);
            double x2 = ((-b) - Math.sqrt(delta)) / (2 * a);
            System.out.println("There are 2 solutions. X1 = " + x1 + ", X2 = " + x2 + ".");
        }
    } // end of method main
} //end of class Equation