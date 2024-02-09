public class IntListTwo {
    IntNodeTwo _head, _tail;

    public IntListTwo() {
        _head = null;
        _tail = null;
    }

    // My Methods //

    // Q3 FUNCTIONS
    /**
     * This function adds a new node to the list at the end of it.
     *
     * @param num the value of the node that will be added.
     */
    public void addToEnd(int num)
    {
        if (_tail == null) // the check for _head isn't necessary because the only way that _tail will be null is if the list is completely empty.
        {
            _head = new IntNodeTwo(num);
            _tail = _head;
        }

        IntNodeTwo temp = _tail;
        _tail = new IntNodeTwo(num, null, temp);
        temp.setNext(_tail);
    }

    /**
     * This function returns a String representation of the list.
     *
     * @return the String representation.
     */
    public String toString()
    {
        if (_head == null)
            return "{}";

        IntNodeTwo temp = _head;
        String result = "{";

        while (temp != _tail)
        {
            result += temp.getNum() + ", ";

            temp = temp.getNext();
        }

        return result + _tail.getNum() + "}";
    }

    private String toStringReverse(IntNodeTwo node)
    {
        if (node == _head) // stopping condition
            return node.getNum() + "";

        return node.getNum() + ", " + toStringReverse(node.getPrev());
    }

    /**
     * This function returns a String representation of the list in reverse order.
     *
     * @return the reverse String representation.
     */
    public String toStringReverse()
    {
        if (_tail == null)
            return "{}";

        // the return statement takes care of the braces so that the overloaded function won't have to.
        return "{" + toStringReverse(_tail) + "}";
    }

    
}