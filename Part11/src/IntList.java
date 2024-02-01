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

    // TIME COMPLEXITY: O(n)
    public void addToEnd(IntNode node)
    {
        if (empty())
            _head = node;
        else
        {
            IntNode ptr = _head;

            while (ptr.getNext() != null)
                ptr = ptr.getNext();
            ptr.setNext(node);
        }
    }

    public void addToHead(IntNode node)
    {
        IntNode temp = _head;
        _head = node;
        node.setNext(temp);
    }

    private IntNode addToHeadRec(IntNode node, int num)
    {
        if (node == null)
            return new IntNode(num, null);
        else
        {
            node.setNext(addToHeadRec(node.getNext(), num));
            return node;
        }
    }

    public void addToHeadRec(int num)
    {
        _head = addToHeadRec(_head, num);
    }

    private IntNode addInOrder(IntNode p, int num)
    {
        if (p == null)
            return new IntNode(num);

        if (p.getValue() > num)
            return new IntNode(num, p);

        p.setNext(addInOrder(p.getNext(), num));
        return p;
    }

    public void addInOrder(int num)
    {
        _head = addInOrder(_head, num);
    }

    // TIME COMPLEXITY: O(n)
    public void remove(int num)
    {
        if (_head != null)
        {
            if (_head.getValue() == num)
                _head = _head.getNext();
            else
            {
                IntNode behind = _head;

                while (behind.getNext() != null)
                {
                    if (behind.getNext().getValue() == num)
                    {
                        behind.setNext(behind.getNext().getNext());
                        return;
                    }
                    else
                        behind = behind.getNext();
                } // end of while
            } // end of else (_head.getValue() == num)
        } // end of if(_head != null)
    }

    // TIME COMPLEXITY: O(n)
    public void printList()
    {
        IntNode temp = _head;

        while (temp != null)
        {
            System.out.print(temp.getValue() + " --> ");
            temp = temp.getNext();
        }
        System.out.println("null");
    }

    private void printRec(IntNode p)
    {
        if (p == null)
        {
            System.out.println();
            return;
        }
        else
        {
            System.out.print(p.getValue() + " --> ");
            printRec(p.getNext());
        }
    }

    public void printRec()
    {
        printRec(_head);
    }

    // TIME COMPLEXITY: O(n)
    public int length()
    {
        IntNode temp = _head;
        int count = 0;

        while (temp != null)
        {
            count++;
            temp = temp.getNext();
        }

        return count;
    }

    private int lengthRec(IntNode p)
    {
        if (p == null)
            return 0;
        return 1 + lengthRec(p.getNext());
    }

    public int lengthRec()
    {
        return lengthRec(_head);
    }

    // TIME COMPLEXITY: O(n)
    public IntNode predecessor(IntNode node)
    {
        if (_head == null || _head == node)
            return null;

        IntNode behind = _head;
        while (behind.getNext() != null)
        {
            if (behind.getNext() == node)
                return behind;
            else
                behind = behind.getNext();
        }

        return null;
    }

    // MERGE SORT //
    private IntNode merge(IntNode list1, IntNode list2)
    {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.getValue() < list2.getValue())
        {
            list1.setNext(merge(list1.getNext(), list2));
            return list1;
        }
        else
        {
            list2.setNext(merge(list1, list2.getNext()));
            return list2;
        }
    }

    private IntNode split(IntNode node)
    {
        if (node == null || node.getNext() == null)
            return null;

        IntNode list2 = node.getNext();
        node.setNext(list2.getNext());
        list2.setNext(split(list2.getNext()));
        return list2;
    }

    private IntNode mergeSort(IntNode node)
    {
        if (node == null || node.getNext() == null)
            return node;

        IntNode list2 = split(node);

        node = mergeSort(node);
        list2 = mergeSort(list2);

        return merge(node, list2);
    }

    // TIME COMPLEXITY: O(n*log(n))
    // SPACE COMPLEXITY: O(1) - without addressing recession.
    public void mergeSort()
    {
        _head = mergeSort(_head);
    }
}