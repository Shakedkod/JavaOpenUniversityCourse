public class IntNodeTwo
{
    private int _value;
    private IntNodeTwo _next, _prev;

    // Constructors
    public IntNodeTwo(int value)
    {
        _value = value;
        _next = null;
        _prev = null;
    }

    public IntNodeTwo(int value, IntNodeTwo next, IntNodeTwo prev)
    {
        _value = value;
        _next = next;
        _prev = prev;
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

    public IntNodeTwo getNext()
    {
        return _next;
    }

    public void setNext(IntNodeTwo next)
    {
        _next = next;
    }

    public IntNodeTwo getPrev()
    {
        return _prev;
    }

    public void setPrev(IntNodeTwo prev)
    {
        _prev = prev;
    }
}
