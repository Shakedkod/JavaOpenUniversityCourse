
/**
 * Write a description of class StudentsTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StudentsTester
{
    public static void main(String[] args)
    {
        Test tester = new Test("Q1 - SUB LIST SUM");

        // TEST 1
        IntList l1 = new IntList();
        l1.addToEnd(3);
        l1.addToEnd(6);
        l1.addToEnd(2);
        l1.addToEnd(7);
        l1.addToEnd(1);
        tester.check(l1.subListSum(15), true);
        tester.check(l1.subListSum(14), false);

        // TEST 2
        IntList l2 = new IntList();
        l2.addToEnd(3);
        l2.addToEnd(9);
        l2.addToEnd(8);
        l2.addToEnd(4);
        l2.addToEnd(2);
        l2.addToEnd(1);
        tester.check(l2.subListSum(7), true);
        tester.check(l2.subListSum(20), true);
        tester.check(l2.subListSum(90), false);

        // TEST 3 - EMPTY LIST
        IntList l3 = new IntList();
        tester.check(l3.subListSum(7), false);

        // TEST 4 - ONE ITEM LIST
        IntList l4 = new IntList();
        l4.addToEnd(7);
        tester.check(l4.subListSum(7), true);
        tester.check(l4.subListSum(8), false);

        /////////////////////////////////
        tester.endTest();
        tester = new Test("Q2 - Average Node");
        /////////////////////////////////

        // TEST 1
        IntList l7 = new IntList();
        l7.addToEnd(5);
        l7.addToEnd(7);
        l7.addToEnd(-2);
        l7.addToEnd(10);
        IntNode result = l7.averageNode();
        tester.check(result.getValue(), -2);

        // TEST 2
        IntList l8 = new IntList();
        l8.addToEnd(1);
        l8.addToEnd(0);
        l8.addToEnd(0);
        l8.addToEnd(0);
        l8.addToEnd(1);
        //tester.check(l8.averageNode(), l8._head.getNext().getNext().getNext());

        // TEST 3 - EMPTY LIST
        IntList l9 = new IntList();
        tester.check(l9.averageNode(), null);

        // TEST 4 - ONE ITEM LIST
        IntList l10 = new IntList();
        l10.addToEnd(7);
        tester.check(l10.averageNode(), null);

        // TEST 6 - MIXED NUMBERS
        IntList l12 = new IntList();
        l12.addToEnd(-3);
        l12.addToEnd(9);
        l12.addToEnd(-8);
        l12.addToEnd(4);
        l12.addToEnd(-2);
        l12.addToEnd(1);
        result = l12.averageNode();
        tester.check(result.getValue(), 9);

        /////////////////////////////////
        tester.endTest();
        tester = new Test("Q3 - Add To End & To String & To String Reverse");
        /////////////////////////////////

        // TEST 1
        IntListTwo l13 = new IntListTwo();
        l13.addToEnd(5);
        l13.addToEnd(7);
        l13.addToEnd(-2);
        l13.addToEnd(10);
        tester.check(l13.toString(), "{5, 7, -2, 10}");

        // TEST 2
        IntListTwo l14 = new IntListTwo();
        l14.addToEnd(1);
        l14.addToEnd(0);
        l14.addToEnd(0);
        l14.addToEnd(0);
        l14.addToEnd(1);
        tester.check(l14.toString(), "{1, 0, 0, 0, 1}");

        // TEST 3 - EMPTY LIST
        IntListTwo l15 = new IntListTwo();
        tester.check(l15.toString(), "{}");

        // TEST 4 - ONE ITEM LIST
        IntListTwo l16 = new IntListTwo();
        l16.addToEnd(7);
        tester.check(l16.toString(), "{7}");

        // TEST 5 - REVERSE
        IntListTwo l17 = new IntListTwo();
        l17.addToEnd(5);
        l17.addToEnd(7);
        l17.addToEnd(-2);
        l17.addToEnd(10);
        tester.check(l17.toStringReverse(), "{10, -2, 7, 5}");

        // TEST 6 - REVERSE EMPTY LIST
        IntListTwo l18 = new IntListTwo();
        tester.check(l18.toStringReverse(), "{}");

        // TEST 7 - REVERSE ONE ITEM LIST
        IntListTwo l19 = new IntListTwo();
        l19.addToEnd(7);
        tester.check(l19.toStringReverse(), "{7}");

        // TEST 8 - REVERSE TWO ITEMS LIST
        IntListTwo l20 = new IntListTwo();
        l20.addToEnd(7);
        l20.addToEnd(5);
        tester.check(l20.toStringReverse(), "{5, 7}");

        // TEST 9 - REVERSE THREE ITEMS LIST
        IntListTwo l21 = new IntListTwo();
        l21.addToEnd(7);
        l21.addToEnd(5);
        l21.addToEnd(3);
        tester.check(l21.toStringReverse(), "{3, 5, 7}");

        /////////////////////////////////
        tester.endTest();
        tester = new Test("Q4 - Is Way");
        /////////////////////////////////

        // TEST 1
        IntListTwo l22 = new IntListTwo();
        l22.addToEnd(5);
        l22.addToEnd(7);
        l22.addToEnd(-2);
        l22.addToEnd(10);
        tester.check(l22.isWay(), false);

        // TEST 2
        IntListTwo l23 = new IntListTwo();
        l23.addToEnd(1);
        l23.addToEnd(1);
        tester.check(l23.isWay(), true);

        // TEST 3
        IntListTwo l24 = new IntListTwo();
        l24.addToEnd(1);
        l24.addToEnd(2);
        l24.addToEnd(3);
        tester.check(l24.isWay(), false);

        // TEST 4
        IntListTwo l25 = new IntListTwo();
        l25.addToEnd(1);
        l25.addToEnd(2);
        l25.addToEnd(3);
        l25.addToEnd(1);
        l25.addToEnd(1);
        l25.addToEnd(3);
        tester.check(l25.isWay(), true);

        // TEST 5 - EMPTY LIST
        IntListTwo l26 = new IntListTwo();
        tester.check(l26.isWay(), false);

        // TEST 6 - ONE ITEM LIST
        IntListTwo l27 = new IntListTwo();
        l27.addToEnd(7);
        tester.check(l27.isWay(), true);

        // TEST 7 - TWO ITEMS LIST
        IntListTwo l28 = new IntListTwo();
        l28.addToEnd(7);
        l28.addToEnd(5);
        tester.check(l28.isWay(), false);

        // TEST 8 - TWO ITEMS LIST
        IntListTwo l29 = new IntListTwo();
        l29.addToEnd(1);
        l29.addToEnd(1);
        tester.check(l29.isWay(), true);

        // TEST 9
        IntListTwo l30 = new IntListTwo();
        l30.addToEnd(2);
        l30.addToEnd(4);
        l30.addToEnd(1);
        l30.addToEnd(6);
        l30.addToEnd(4);
        l30.addToEnd(2);
        l30.addToEnd(4);
        l30.addToEnd(3);
        l30.addToEnd(5);
        tester.check(l30.isWay(), true);

        // TEST 10
        IntListTwo l31 = new IntListTwo();
        l31.addToEnd(1);
        l31.addToEnd(4);
        l31.addToEnd(3);
        l31.addToEnd(1);
        l31.addToEnd(2);
        l31.addToEnd(4);
        l31.addToEnd(3);
        tester.check(l31.isWay(), false);

        /////////////////////////////////
        tester.endTest();

        System.out.println("All tests passed! - hopefully...");
    }
}
