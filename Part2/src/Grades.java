/***************************************************************
 * This class gets the following 3 parameters from the user:
 * 1) the exam grade
 * 2) the average grade of the homework assignments that he submitted
 * 3) the number of homework assignments that he submitted
 * and calculates the final grade of the student according to a given formula.
 */
import java.util.Scanner;

public class Grades
{
    public static void main(String[] args)
    {
        // declaration of constants
        final int PASS = 55;
        final int GOOD_HOMEWORK_AVERAGE = 8;
        final double WEIGHT_OF_5_6_ASSIGNMENTS = .2;
        final double WEIGHT_OF_7_8_ASSIGNMENTS_IF_PASSED = .3;
        final double WEIGHT_OF_7_8_ASSIGNMENTS_IF_FAILED_GOOD_AVERAGE = .25;
        final double WEIGHT_OF_7_8_ASSIGNMENTS_IF_FAILED_BAD_AVERAGE = .2;

        // declaration of variables
        int examGrade, homeworkAverage, numberOfAssignments;
        double finalGrade;
        Scanner scan = new Scanner(System.in);

        // getting data from the user
        System.out.print("Please enter the exam grade: ");
        examGrade = scan.nextInt();
        System.out.print("Please enter the average grade of the homework assignments: ");
        homeworkAverage = scan.nextInt();
        homeworkAverage *= 10;
        System.out.print("Please enter the number of homework assignments: ");
        numberOfAssignments = scan.nextInt();

        finalGrade = examGrade;

        // calculating the final grade
        if (numberOfAssignments <= 4)
            finalGrade = 0;
        else if (numberOfAssignments <= 6)
        {
            if (examGrade >= PASS)
            {
                finalGrade = examGrade * (1 - WEIGHT_OF_5_6_ASSIGNMENTS);
                finalGrade += homeworkAverage * WEIGHT_OF_5_6_ASSIGNMENTS;
            }
        }
        else // the number of assignments the student submitted is 7 or 8
        {
            if (homeworkAverage > examGrade)
            {
                if (examGrade >= PASS)
                {
                    finalGrade = examGrade * (1 - WEIGHT_OF_7_8_ASSIGNMENTS_IF_PASSED);
                    finalGrade += homeworkAverage * WEIGHT_OF_7_8_ASSIGNMENTS_IF_PASSED;
                }
                else // the exam grade is less than PASS (54)
                {
                    if ((homeworkAverage/10) >= GOOD_HOMEWORK_AVERAGE) // homeworkAverage >= 8
                    {
                        finalGrade = examGrade* (1 - WEIGHT_OF_7_8_ASSIGNMENTS_IF_FAILED_GOOD_AVERAGE);
                        finalGrade += homeworkAverage * WEIGHT_OF_7_8_ASSIGNMENTS_IF_FAILED_GOOD_AVERAGE;
                    }
                    else // homeworkAverage < 8
                    {
                        finalGrade = examGrade * (1 - WEIGHT_OF_7_8_ASSIGNMENTS_IF_FAILED_BAD_AVERAGE);
                        finalGrade += homeworkAverage * WEIGHT_OF_7_8_ASSIGNMENTS_IF_FAILED_BAD_AVERAGE;
                    }
                } // the student did not pass the exam
            } // the homework average is higher than the exam grade
        } // the student submitted 7 or 8 assignments

        // printing the final grade
        System.out.println("The final grade is: " + finalGrade);
    } // end of method main
} // end of class Grades