/**
 * This class represents a one-way int list.
 *
 * ID: 216590125
 * @author Shaked Kodman Kolran
 * @version 01-02-24
 */
public class IntList
{
    private IntNode _head;

    public IntList()
    {
        _head = null;
    }

    public void addToEnd(int num)
    {
        // adds num at the end of the list
        IntNode node = new IntNode(num);
        if (_head == null)
            _head = node;
        else {
            IntNode ptr = _head;
            while (ptr.getNext() != null)
                ptr = ptr.getNext();
            ptr.setNext(node);
        }
    }

    public String toString()
    {
        String s = "";
        IntNode temp = _head;
        while (temp != null) {
            s = s + temp.getValue() + " --> ";
            temp = temp.getNext();
        }
        s += " null";
        return s;
    }


    // My Methods //

    /**
     * FUNCTION Q1
     * This function searches for a connected sub list that
     *      the sum of her items is equal to the number given.
     *
     * TIME COMPLEXITY: O(n) - we need to go throw the whole list once to see all the sublists.
     * SPACE COMPLEXITY: O(1) - the function does not create any variables that are affected by the length of the list.
     *
     * @param num the number to find
     * @return true if found, false if not
     */
    public boolean subListSum(int num)
    {
        if (_head == null)
            return false;

        if (_head.getNext() == null)
            return (_head.getValue() == num);

        IntNode start = _head;
        IntNode end = _head.getNext();
        int sum = start.getValue() + end.getValue();

        while (start.getNext() != null)
        {
            if (sum == num)
                return true;
            else if (sum > num)
            {
                sum -= start.getValue();
                start = start.getNext();
            }
            else
            {
                if (end.getNext() == null)
                    return false;

                end = end.getNext();
                sum += end.getValue();
            }
        }

        return false;
    }

    /**
     * FUNCTION Q2
     * This function returns the average node, witch is the node that divides the list with the condition that the average
     * difference between all the nodes that are before this node, including him, and all the nodes that are after this one,
     * is the larges.
     *
     * TIME COMPLEXITY: O(n) - you have to go throw the whole list at least once to sum up all the values.
     * SPACE COMPLEXITY: O(1) - the function does not create any variables that are affected by the length of the list.
     *
     * @return the IntNode witch divides the list according to the rules above.
     */
    public IntNode averageNode()
    {
        if (_head == null || _head.getNext() == null)
            return null;

        int sumUntil = _head.getValue(), sumForwards = 0;
        int NumOfValuesUntil = 1, NumOfValuesForwards = 0;

        // getting sumForwards start value
        IntNode temp = _head.getNext();
        while (temp != null)
        {
            sumForwards += temp.getValue();
            NumOfValuesForwards++;
            temp = temp.getNext();
        }

        // initial values
        IntNode largestAvgDifferenceNode = _head;
        temp = _head.getNext().getNext();
        int largestAvgDifferenceValue = Math.abs((sumUntil / NumOfValuesUntil) - (sumForwards / NumOfValuesForwards));

        // the getNext() is because the last node can't be a variable divisor according to the question rules
        while (temp.getNext() != null)
        {
            // change the values
            sumUntil += temp.getValue();
            sumForwards -= temp.getValue();

            // check
            int tempAvgDifferenceValue = Math.abs((sumUntil / NumOfValuesUntil) - (sumForwards / NumOfValuesForwards));
            if (tempAvgDifferenceValue >= largestAvgDifferenceValue)
            {
                largestAvgDifferenceNode = temp;
                largestAvgDifferenceValue = tempAvgDifferenceValue;
            }

            // move to the next
            temp = temp.getNext();
        }

        return largestAvgDifferenceNode;
    }
}