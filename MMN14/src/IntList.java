/**
 * This class represents a list made with int objects.
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


    // My Functions //

    /**
     * This function searches for a connected sub list that
     *      the sum of her items is equal to the number given.
     *
     * TIME COMPLEXITY: O(n^2) - TODO: SIMPLIFY IT
     * SPACE COMPLEXITY: O(1) - does not create any objects that are affected by the length of the list.
     *
     * @param num the number to find
     * @return true if found, false if not
     */
    public boolean subListSum(int num)
    {
        IntNode node = _head;

        while (node != null)
        {
            int sum = node.getValue();
            IntNode temp = node.getNext();

            while (temp != null || sum < num)
            {
                sum += temp.getValue();
                temp = temp.getNext();

                if (sum == num)
                    return true;
             }

            node = node.getNext();
        }

        return false;
    }
}