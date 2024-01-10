// The Origin class gets three points in the plane and prints which one of them is closest to the origin
// Author: Shaked Kodman Kolran.
// ID: 216590125.
import java.util.Scanner;

public class Origin
{
    // Prompts the user to enter 3 points and prints the one closest to the origin
    public static void main(String[] args)
    {
        Scanner scan = new Scanner (System.in);

        // Prompt user for coordinates of point 1
        System.out.println("Enter first point coordinates:");
        int x1 = scan.nextInt();
        int y1 = scan.nextInt();

        // Prompt user for coordinates of point 2
        System.out.println ("Enter second point coordinates:");
        int x2 = scan.nextInt();
        int y2 = scan.nextInt();

        // Prompt user for coordinates of point 3
        System.out.println ("Enter third point coordinates:");
        int x3 = scan.nextInt();
        int y3 = scan.nextInt();

        // Calculate distance from origin for each point
        double point1DistanceFromOrigin = Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2));
        double point2DistanceFromOrigin = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));
        double point3DistanceFromOrigin = Math.sqrt(Math.pow(x3, 2) + Math.pow(y3, 2));

        // Determine which point is closest to the origin
        int x, y;

        if (point1DistanceFromOrigin < point2DistanceFromOrigin)
            if (point1DistanceFromOrigin < point3DistanceFromOrigin)
            {
                x = x1;
                y = y1;
            }
            else
            {
                x = x3;
                y = y3;
            }
        else if (point2DistanceFromOrigin < point3DistanceFromOrigin)
        {
            x = x2;
            y = y2;
        }
        else
        {
            x = x3;
            y = y3;
        }

        System.out.println ("The nearest point to the origin is (" + x + ", " + y + ")");
    } // end of method main
} //end of class Origin