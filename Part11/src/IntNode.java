public class IntNode
{
    private int _value;
    private IntNode _next;

    // Constructors
    public IntNode(int value)
    {
        _value = value;
        _next = null;
    }

    public IntNode(int value, IntNode next)
    {
        _value = value;
        _next = next;
    }

    // Getters & Setters
    public int getValue()
    {
        return _value;
    }

    public void setValue(int value)
    {
        _value = value;
    }

    public IntNode getNext()
    {
        return _next;
    }

    public void setNext(IntNode next)
    {
        _next = next;
    }
}
