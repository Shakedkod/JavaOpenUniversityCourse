public class IntListTwo
{
    private IntNodeTwo _head, _tail;

    // Constructors
    public IntListTwo()
    {
        _head = null;
        _tail = null;
    }

    // Public Methods
    public void insertAfter(int num, IntNodeTwo node)
    {
        IntNodeTwo temp = new IntNodeTwo(num);

        if (_head == null)
        {
            _head = temp;
            _tail = _head;
        }
        else
        {
            IntNodeTwo curr = _head;

            while (curr != node)
                curr = curr.getNext();

            temp.setNext(curr.getNext());
            temp.setPrev(curr);
            curr.setNext(temp);

            if (temp.getNext() == null)
                _tail = temp;
            else
                temp.getNext().setPrev(temp);
        }
    }

    public void rearrange()
    {
        IntNodeTwo left = _head;
        IntNodeTwo right = _tail;

        while (left != right)
        {
            if (left.getValue() < 0)
                left = left.getNext();
            else if (right.getValue() > 0)
                right = right.getPrev();
            else
            {
                int temp = left.getValue();
                left.setValue(right.getValue());
                right.setValue(temp);
            }
        }
    }
}