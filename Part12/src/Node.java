public class Node
{
    private int _number;
    private Node _leftSon, _rightSon;

    // Constructors
    public Node(int number)
    {
        _number = number;
        _leftSon = null;
        _rightSon = null;
    }

    // Getters
    public int getNumber()
    {
        return _number;
    }

    public Node getLeftSon()
    {
        return _leftSon;
    }

    public Node getRightSon()
    {
        return _rightSon;
    }

    // Setters
    public void setNumber(int number)
    {
        _number = number;
    }

    public void setLeftSon(Node leftSon)
    {
        _leftSon = leftSon;
    }

    public void setRightSon(Node rightSon)
    {
        _rightSon = rightSon;
    }
}