public class IntList
{
    private IntNode _head;

    // Constructors
    public IntList()
    {
        _head = null;
    }

    public IntList(IntNode node)
    {
        _head = node;
    }

    // Public Methods
    public boolean empty()
    {
        return (_head == null);
    }

    public IntNode nextElement(IntNode node)
    {
        return node.getNext();
    }

    public int getValueOfNode(IntNode node)
    {
        return node.getValue();
    }

    public void addToEnd(IntNode node)
    {
        if (empty())
            _head = node;
        else
        {
            IntNode ptr= _head;

            while (ptr.getNext() != null)
                ptr = ptr.getNext();
            ptr.setNext(node);
        }
    }
}